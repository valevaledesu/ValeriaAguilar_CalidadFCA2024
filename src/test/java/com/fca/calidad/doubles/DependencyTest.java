package com.fca.calidad.doubles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DependencyTest {

    private Dependency dependency;
    private SubDependency sub;

    @BeforeEach
    void setup() {
        sub = mock(SubDependency.class);
        dependency = new Dependency(sub);
    }

    @Test
    void test(){
        System.out.println(sub.getClassName());
    }

    @Test
    public void testDependency() {

        //Ejercicio
        when(sub.getClassName()).thenReturn("Hi There");
    
        //verificacion
        assertThat("Hi There",is(sub.getClassName()));
    
    }
}
