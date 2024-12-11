package com.fca.calidad.service;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fca.calidad.DAO.IDAOUser;
import com.fca.calidad.model.User;

public class UserServiceTest {

private User usuario;
private UserService servicio;
private IDAOUser dao;
private HashMap<Integer,User>baseDedatos;

@BeforeEach
void setup(){
    dao = mock(IDAOUser.class);
        servicio = new UserService(dao);
        baseDedatos = new HashMap<>();
}
/* 
@Test
void updateTest() {

    User userOld = new User("nombreOriginal", "email@example.com", "password123");
    userOld.setId(1);
    baseDedatos.put(userOld.getId(), userOld);

    User Actualizado = new User("nombreNuevo", "email@example.com", "password456");
    Actualizado.setId(1);

    when(dao.findById(1)).thenReturn(userOld);
    when(dao.updateUser(any(User.class))).thenAnswer(new Answer<User>() {
        public User answer(InvocationOnMock invocation) throws Throwable {
            User arg = (User) invocation.getArguments()[0];
            baseDedatos.replace(arg.getId(), arg);

            return baseDedatos.get(arg.getId());
        }
    });

    User result = servicio.updateUser(Actualizado);

    System.out.println("Nombre esperado: nombreNuevo | Nombre obtenido: " + result.getName());
    System.out.println("Contraseña esperada: password456 | Contraseña obtenida: " + result.getPassword());

     assertThat(result.getName(), is("nombreNuevo"));
     assertThat(result.getPassword(), is("password456"));
}
     */
    @Test
    void crearUsuario () {

        //crea un usario esperado
        String name = "newUser";
        String email = "nuevo@ejemplo.com";
        String password = "pass12345";
        
        //mock para crear el usuario
        when(dao.findUserByEmail(email)).thenReturn(null);
        when(dao.save(any(User.class))).thenReturn(1);

        User result = servicio.createUser(name, email, password);


        assertThat(result.getName(), is("newUser"));
        assertThat(result.getEmail(), is("nuevo@ejemplo.com"));
        assertThat(result.getPassword(), is("pass12345"));

        System.out.println("Nombre esperado: newUser | Nombre obtenido: " + result.getName());
        System.out.println("Email esperado: nuevo@ejemplo.com | Email obtenido: " + result.getEmail());
        System.out.println("Password esperado: pass12345 | Password obtenido: " + result.getPassword());


    }
    @Test
    void buscarAllUsers() {
        //Creo nueva array de usuarios falsos
        User usuario1 = new User("usuario1", "usuario1@ejemplo.com", "pass12345");
        User usuario2 = new User("usuario2", "usuario2@ejemplo.com", "pass12456");
        User usuario3 = new User("usuario3", "usuario3@ejemplo.com", "pass12367");

        usuario1.setId(1);
        usuario2.setId(2);
        usuario3.setId(3);

        baseDedatos.put(usuario1.getId(), usuario1);
        baseDedatos.put(usuario2.getId(), usuario2);
        baseDedatos.put(usuario3.getId(), usuario3);

        for (User user : baseDedatos.values()) {
            System.out.println("Nombre:" + user.getName() + user.getEmail() + user.getPassword());

        }

        //mock para devolver array de usuarios simulados o falsos
        when(dao.findAll()).thenReturn(List.copyOf(baseDedatos.values()));


        //Imprimir usuarios esperados con el array y los imprime
        
    }

    @Test
    void buscarUsuarioByEmail() {
        //Declaro el email esperado
        String email = "correo@test.com";
        User usuarioEsperado = new User("UserTest", email, "PassTes");

        when(dao.findUserByEmail(email)).thenReturn(usuarioEsperado);

        User result = servicio.findUserByEmail(email);

        System.out.println("Email esperado: correo@test.com | Email obtenido: " + result.getEmail());

    }

    @Test
    void buscarUsuarioById(){
        int id = 1;
        User idEsperado = new User("UserTest", "email", "PassTes");
        idEsperado.setId(id);

        when(dao.findById(id)).thenReturn(idEsperado);

        User result = servicio.findUserById(id);

        System.out.println("ID esperado: 1 | ID obtenido: " + result.getId());
    }

    @Test
    void eliminarUsuario() {

        when(dao.deleteById(1)).thenReturn(true);
        when(dao.deleteById(2)).thenReturn(false);
        boolean result = servicio.deleteUser(1);
        assertTrue(result);

        result = servicio.deleteUser(2);
        assertFalse(result);      
    }
}

