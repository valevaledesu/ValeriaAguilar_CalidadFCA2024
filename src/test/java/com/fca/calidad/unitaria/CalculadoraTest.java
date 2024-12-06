package com.fca.calidad.unitaria;

import static org.hamcrest.MatcherAssert.assertThat;
import static  org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import com.fca.calidad.unitariaCalculadora.Calculadora;



/**
 * Unit test for simple App.
 */
public class CalculadoraTest {

   @Test
   void suma2numerosPositivosTest() {
    //iniciar
    double num1 = 2;
    double num2 = 5;
    double resultado = 7;
    Calculadora calculadora = new Calculadora();

    //Llamada al metodo que queremos provar
    double resEjecutado = calculadora.suma(num1, num2);

    //verificación
    assertThat(resultado, is(resEjecutado));  
 }
 @Test
 void resta2numerosPositivosTest() {
   //iniciar
   double num1 = 5;
   double num2 = 2;
   double resultado = 3;
   Calculadora calculadora = new Calculadora();

   //Llamada al metodo que queremos provar
   double resEjecutado = calculadora.resta(num1, num2);

   //verificación
   assertThat(resultado, is(resEjecutado));  
}
@Test
 void multiplica2numerosPositivosTest() {
   //iniciar
   double num1 = 2;
   double num2 = 6;
   double resultado = 12;
   Calculadora calculadora = new Calculadora();

   //Llamada al metodo que queremos provar
   double resEjecutado = calculadora.multiplica(num1, num2);

   //verificación
   assertThat(resultado, is(resEjecutado));  
}
@Test
 void divide2numerosPositivosTest() {
   //iniciar
   double num1 = 20;
   double num2 = 2;
   double resultado = 10;
   Calculadora calculadora = new Calculadora();

   //Llamada al metodo que queremos provar
   double resEjecutado = calculadora.divide(num1, num2);

   //verificación
   assertThat(resultado, is(resEjecutado));  
}
@Test
void suma2numerosNegativosTest() {
    // Iniciar
    double num1 = -3;
    double num2 = -7;
    double resultado = -10;
    Calculadora calculadora = new Calculadora();

    // Llamada al método que queremos probar
    double resEjecutado = calculadora.suma(num1, num2);

    // Verificación
    assertThat(resultado, is(resEjecutado));
}
@Test
void sumaConDecimalesTest() {
    // Iniciar
    double num1 = 2.5;
    double num2 = 3.7;
    double resultado = 6.2;
    Calculadora calculadora = new Calculadora();

    // Llamada al método que queremos probar
    double resEjecutado = calculadora.suma(num1, num2);

    // Verificación
    assertThat(resultado, is(resEjecutado));
}

}


