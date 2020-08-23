package com.bank;
import java.util.*;

public abstract class Transaccion {
	
	protected int id_Operacion;
	protected Date date;
	protected int monto;
	protected String tipo;
	protected String cuenta;
	
	
	public Transaccion(int m, int id, String cuenta){
		this.monto= m;
		date = new Date();
		id_Operacion = id;
		tipo = this.getClass().getSimpleName();
		this.cuenta  = cuenta;
		
	}
	
	abstract public void operar(int monto);

	@Override
	public String toString() {
		return "Transaccion [id_Operacion=" + id_Operacion + ", date=" + date + ", monto=" + monto + ", tipo=" + tipo
				+ ", cuenta=" + cuenta + "]";
	}
	
}
