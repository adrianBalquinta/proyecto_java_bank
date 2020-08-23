package com.bank;

public class Deposito extends Transaccion{

	public Deposito(int m, int id, String cuenta) {
		super(m, id, cuenta);
	
	}

	@Override
	public void operar(int monto) {
		this.monto= monto;
		
	}

	

	

	

}
