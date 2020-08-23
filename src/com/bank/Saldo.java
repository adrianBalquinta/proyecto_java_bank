package com.bank;

public class Saldo extends Solicitud {

	

	public Saldo(Cuenta cuenta) {
		super(cuenta);
		
	}

	@Override
	public String verOperacion() {
		
		return "****El saldo de la " + (super.tipoCuenta.equals("CajaAhorro")?"Caja de Ahorro": "Cuenta Corriente") + " Numero " + super.numCuenta + " es: "+super.saldo;
	}
	
	

}
