package com.bank;

public class Extraccion extends Transaccion{

	public Extraccion(int m, int id, String cuenta) {
		super(m, id, cuenta);
		
	}

	@Override
	public void operar( int monto) {
	
		
		this.monto=monto;
		
		
		
	}
	
	
}
