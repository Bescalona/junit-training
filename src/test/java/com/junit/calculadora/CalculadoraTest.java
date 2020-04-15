package com.junit.calculadora;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculadoraTest {
	
	@InjectMocks
	Calculadora calc = new Calculadora(); //Dependiente
	
	@Mock
	CalculadoraCloud calcloud; //Dependencia
	
	@BeforeClass
	public static void SuperInit() {
		System.out.println("Me ejecuto antes de todos los test");
	}
	
	@Before
	public void init() {
		System.out.println("Inicializando calculadora");
		
		//comportamiento predecible de la dependencia
		when(calcloud.sumar(5, 5)).thenReturn(10.00);
		
	}
	
	@Test
	public void probarSuma() {
		
		System.out.println("Probando suma");
		//Resultado esperado
		double resultado = 10.0; //(5+5)
		
		assertEquals(resultado,calc.sumar(5, 5), 0.001);
		assertEquals(7.00,calc.sumar(2, 5), 0.001);
	}
	
	@Test
	public void probarSumaCloud() {
		
		assertEquals(10.00,calc.sumarCloud(5, 5), 0.001);
		
	}
	
	@Test
	public void probarResta() {
		System.out.println("Probando resta");
		assertEquals(2.00,calc.restar(5, 3), 0.001);
	}
	
	@After
	public void close() {
		System.out.println("Finalizando tests");
	}
	
	@AfterClass
	public static void Superclose() {
		System.out.println("Me ejecuto al final de todos los test");
	}
}
