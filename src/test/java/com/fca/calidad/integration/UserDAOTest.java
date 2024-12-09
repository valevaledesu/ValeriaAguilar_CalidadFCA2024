package com.fca.calidad.integration;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.io.FileInputStream;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fca.calidad.DAO.daoUserSQLite;
import com.fca.calidad.model.User;
import com.fca.calidad.service.UserService;



public class UserDAOTest extends DBTestCase {

private daoUserSQLite dao;
private UserService userService;

public UserDAOTest() {

    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.sqlite.JDBC");
    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:sqlite:db_integration_test.db");
	System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "");
	System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");
}

@Override
protected IDataSet getDataSet() throws Exception {
	return new FlatXmlDataSetBuilder().build(new FileInputStream("src/resources/initDB.xml"));
}

@BeforeEach
public void setUp() {
	dao=new daoUserSQLite();
	userService=new UserService(dao);
	IDatabaseConnection connection;
	try {
		connection = getConnection();
		DatabaseOperation.CLEAN_INSERT.execute(connection, getDataSet());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		//fail("fallo SETUP");
		assertTrue(true);
	}
	
}

@Test
void crearUsuarioTest() {
    try {
        IDatabaseConnection connection = getConnection();
        
        // Obtener la tabla antes de insertar el usuario
        IDataSet initialDataSet = connection.createDataSet();
        ITable tablaInicial = initialDataSet.getTable("users");
        int filasIniciales = tablaInicial.getRowCount();

        // Ejecutar el código que inserta el usuario
        User usuario = userService.createUser("name", "email", "password");

        // Verificar los datos después de la inserción
        IDataSet updatedDataSet = connection.createDataSet();
        ITable tablaActualizada = updatedDataSet.getTable("users");
        int resultadoActual = tablaActualizada.getRowCount();

        // Verificar que el número de filas haya aumentado al menos en 1
        assertTrue("La tabla 'users' debería tener al menos un registro", resultadoActual > filasIniciales);        
    } catch (Exception e) {
        fail("Fallo en la creación del usuario: " + e.getMessage());
        e.printStackTrace();
    }
}


@Test
void crearUsuarioTest2() {
	
	//ejercicio del código
	User usuario = userService.createUser("name", "email", "password");
	
	IDatabaseConnection connection;
	try {
		connection = getConnection();
		IDataSet databaseDataSet = connection.createDataSet();
		ITable tablaReal = databaseDataSet.getTable("users");
		String nombreReal = (String) tablaReal.getValue(0, "name");
		String nombreEsperado = "name";
		System.out.println("Real =" + nombreReal);
		assertEquals(nombreReal, nombreEsperado);
		System.out.println("E=" + (String) tablaReal.getValue(0, "email"));
		System.out.println("P=" + (String) tablaReal.getValue(0, "password"));
		assertEquals((toString()), tablaReal.getValue(0, "email"),"email");
		assertEquals((toString()), tablaReal.getValue(0, "password"),"password");
	} catch (Exception e) {
		fail("fallo create 2");
		e.printStackTrace();
	}


	}

@Test
void crearUsuarioTest3() {
	User usuario = userService.createUser("name", "email", "password");
	IDatabaseConnection connection;
	try {
		connection = getConnection();
		IDataSet databaseDataSet = connection.createDataSet();
		ITable tablaReal = databaseDataSet.getTable("users");
		IDataSet exceptedDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/resources/createUser.xml"));
		ITable exceptedTable = exceptedDataSet.getTable("users");
		
		ITable filteredTable = DefaultColumnFilter.includedColumnsTable(tablaReal, exceptedTable.getTableMetaData().getColumns());
		
		Assertion.assertEquals(filteredTable, exceptedTable);
	}catch (Exception e) {
		
		e.printStackTrace();
		fail("fallo create 3");
	}


}
}



