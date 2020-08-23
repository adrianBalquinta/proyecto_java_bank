package com.bank;

import java.util.Arrays;

public class CajaAhorro extends Cuenta {

	public CajaAhorro(int s) {
		super(s);
	}
	
	@Override
	public String toString() {
		return "Caja Ahorro [saldo=" + super.getSaldo() +  ", listaTransacciones="
				+ Arrays.toString(super.getListaTransacciones()) + "]";
	}
}
