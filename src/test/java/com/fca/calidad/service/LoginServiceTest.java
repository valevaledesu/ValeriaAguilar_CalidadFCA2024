package com.fca.calidad.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fca.calidad.DAO.IDAOUser;
import com.fca.calidad.model.User;

public class LoginServiceTest {

    LoginService service;
    IDAOUser dao;

    @Test
    void loginTest(){
        dao = mock(IDAOUser.class);
        service = new LoginService(dao);
        User usuario = new User("nombre1", "aguilar@email.com" , "12345");

        when(dao.findByUserName("nombre1")).thenReturn(usuario);

        boolean result = service.login("nombre1", "12345");

        System.out.println("Resultado esperado: true | Resultado obtenido: " + result);
        assertThat(result, is(true));
        
    }

    @Test
    void usuarioIncorrecto(){
        dao = mock(IDAOUser.class);
        service = new LoginService(dao);

        User usuario = new User("nombre1", "aguilar@email.com" , "12345");

        when(dao.findByUserName("nombreIncorrecto")).thenReturn(null);

        boolean result = service.login("nombreIncorrecto", "12345");

        System.out.println("Resultado esperado: false | Resultado obtenido: " + result);
        assertThat(result, is(false));
        
    }
    @Test
    void contrasenaIncorrecta(){
        dao = mock(IDAOUser.class);
        service = new LoginService(dao);

        User usuario = new User("nombre1", "aguilar@email.com" , "12345");

        when(dao.findByUserName("nombre1")).thenReturn(usuario);

        boolean result = service.login("nombre1", "12345");

        System.out.println("Resultado esperado: true | Resultado obtenido: " + result);
        assertThat(result, is(true));
        
    }

}
