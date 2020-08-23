package com.bank;

public abstract class Solicitud {
	protected double saldo;
	protected int numCuenta;
	protected Transaccion listaTransacciones[];
	protected String tipoCuenta;
	
	
	
	public Solicitud(Cuenta cuenta) {
		this.saldo=cuenta.getSaldo();
		//this.numCuenta=cuenta.getNumCuenta();
		this.listaTransacciones = cuenta.getListaTransacciones();
		this.tipoCuenta = cuenta.getClass().getSimpleName();
	}
	
	abstract public String verOperacion();
}
