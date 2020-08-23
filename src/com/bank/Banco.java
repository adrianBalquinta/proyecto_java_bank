package com.bank;

import java.util.Arrays;

public class Banco {
	private int numClientes; 
	private Cliente clientes [];
	
	public Banco(){
		clientes = new Cliente [10];
		numClientes = 0;
	}
	
	 public void addCliente(Cliente cliente) {
	        int i = numClientes++;
	        clientes[i] = cliente;
	    }
	
	 public void addCliente(String nombre, String apellido, CajaAhorro ca, CuentaCorriente cc, int pin, int numCuenta) {
	        int i = numClientes++;
	        clientes[i] = new Cliente(nombre, apellido, ca, cc, pin, numCuenta);
	    }
	 
	 public Cliente getCliente(int customer_index) {
	        return clientes[customer_index];
	    }
	 
	 
	 public Cliente[] getClientes() {
		 return clientes;
	 }
	 
	 public Cliente autenticar(int pin, int numCuenta) {
		 
		 for (int i = 0; i< clientes.length;i++) {
			 
			 if(clientes[i]!=null)
			 
				 if((clientes[i].validarPinCuenta(pin, numCuenta)) == true) {
					 return clientes[i];
				 }
		 }
		 
		 return null;
	 }
	 
	 
	 
	@Override
	public String toString() {
		return  "Clientes del banco: "+numClientes ;
	}
	
}
