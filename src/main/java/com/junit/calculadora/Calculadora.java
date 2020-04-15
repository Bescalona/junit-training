package com.junit.calculadora;

public class Calculadora {
	
	CalculadoraCloud calcloud;
	
	public double sumar (double a, double b) {
		return a + b; 
	}
	
	public double restar (double a, double b) {
		return a - b; 
	}
	
	public double sumarCloud (double a, double b) {
		return calcloud.sumar(a, b);
	}
}
