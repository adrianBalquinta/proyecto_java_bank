package com.bank;

import java.util.Arrays;

public class CuentaCorriente extends Cuenta {

	private int descubierto;
	
	public CuentaCorriente(int s, int descubierto) {
		super(s);
		this.descubierto = descubierto;
	}
	
	/*public int getSaldo() {
		return super.getSaldo() + this.descubierto;
	}*/
	
	public int getDescubierto() {
		return descubierto;
	}



	public void setDescubierto(int descubierto) {
		this.descubierto = descubierto;
	}



	@Override
	public String toString() {
		return "Cuenta Corriente [saldo=" + super.getSaldo() +  ", listaTransacciones="
				+ Arrays.toString(super.getListaTransacciones()) + "]";
	}
}
