package com.bank;

import java.util.Arrays;

public class HistorialTransacciones extends Solicitud {

	public HistorialTransacciones(Cuenta cuenta) {
		super(cuenta);
		
	}

	@Override
	public String verOperacion() {
		
			return "Lista de operaciones :\n"+Arrays.toString(listaTransacciones);	
	}
	

}
