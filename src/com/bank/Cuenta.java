package com.bank;

import java.util.Arrays;

public abstract class Cuenta {
	
	
	private int saldo;
//	private int numCuenta;
//	private static int nextNumCuenta = 0;
	private Transaccion listaTransacciones[];
	private int numTransaccion;
//	private int pin;
	
	public Cuenta() {
		listaTransacciones = new Transaccion[10];
		numTransaccion =0;
	}
	
	public Cuenta(int s) {
	this();
	saldo=s;
	//this.numCuenta=numCuenta;
	//this.pin=pin;
	}
	/**
	public static int getNextNumCuenta() {
		
		int id = nextNumCuenta;
		nextNumCuenta++;
		return id;
		
	}
	
*/
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int s) {
		saldo = s;
	}

	public Transaccion[] getListaTransacciones() {
		return listaTransacciones;
	}

	public void setListaTransacciones(Transaccion[] listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}

	public boolean validarMontoDisponible(Extraccion extraccion, Cliente cliente) {
		int saldoCa= this.saldo;
		int saldoCc = cliente.getCc().getSaldo()+cliente.getCc().getDescubierto();
		if(saldoCa+saldoCc>=extraccion.monto) {
			return true;
		}
		return false;
	}
	
	public void depositar(Deposito deposito) {
		this.saldo= this.saldo + deposito.monto;
		addTransaccion(deposito);    	
	}
	
	public boolean extraer(Extraccion extraccion, Cliente cliente) {
		
		boolean validar = validarMontoDisponible(extraccion,cliente);
		
		if(validar=true) {
			if (extraccion.monto<=saldo)
				this.saldo=this.saldo-extraccion.monto;
			else {
				cliente.getCc().setSaldo(cliente.getCc().getSaldo() + (saldo-extraccion.monto));
				this.saldo=0;
			}
			addTransaccion(extraccion);
			return true;
		}
		else {
			return false;
		}	
	}
	
	public void addTransaccion(Transaccion t) {
        int i = numTransaccion++;
        listaTransacciones[i] = t;
    }
 
	public Transaccion getTransaccion(int transaccion_index) {
        return listaTransacciones[transaccion_index];
    }
	
	/*public boolean validar(int pin, int numCuenta) {
		
		if((pin == this.pin)&& (numCuenta == this.numCuenta)) {
			return true;
		}
		else {
			return false;
		}
		
	}*/
	
	
	public String verSaldo(Saldo saldo) {
		
		return saldo.verOperacion();
	}
	
	public String verTransacciones(HistorialTransacciones ts) {
		
		return ts.verOperacion();
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", listaTransacciones=" + Arrays.toString(listaTransacciones)
				+ ", numTransaccion=" + numTransaccion + "]";
	}
	
		
}
