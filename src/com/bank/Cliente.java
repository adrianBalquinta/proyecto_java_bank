package com.bank;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private CajaAhorro ca;
	private CuentaCorriente cc;
	private int pin;
	private int numCuenta;
	
	
	/*public Cliente(String nombre, String apellido, int pin, int numCuenta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.pin = pin;
		this.numCuenta = numCuenta;
		
	}*/
	
	public Cliente(String nombre, String apellido, CajaAhorro ca, CuentaCorriente cc, int pin, int numCuenta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.ca = ca;
		this.cc = cc;
		this.pin = pin;
		this.numCuenta = numCuenta;
		
	}
	
	
	public CajaAhorro getCa() {
		return ca;
	}

	public void setCa(CajaAhorro ca) {
		this.ca = ca;
	}

	public CuentaCorriente getCc() {
		return cc;
	}

	public void setCc(CuentaCorriente cc) {
		this.cc = cc;
	}

	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}
	
	/*public Cuenta getCuenta() {
		return this.cuenta;
	}
	
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}*/

	public boolean validarPinCuenta(int pin, int numCuenta) {
		
		if(this.pin==pin && this.numCuenta==numCuenta) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", ca=" + ca + ", cc=" + cc + ", pin=" + pin
				+ ", numCuenta=" + numCuenta + "]";
	}


	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}


	public int getNumCuenta() {
		return numCuenta;
	}


	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	

	

	

	
}
