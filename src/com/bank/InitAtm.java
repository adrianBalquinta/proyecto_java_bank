package com.bank;


public class InitAtm {

	public static void main(String[] args) {
		
		Banco banco = new Banco();
		initializeCustomers(banco);
		
		System.out.println(banco);
		
		Cliente clientes[] = banco.getClientes();
		for (int i=0; i<clientes.length; i++) {
			if(clientes[i]!=null)
				System.out.println(clientes[i]);
		}
		System.out.println(" ");
		Atm atm = new Atm(banco);
		atm.getMenu();
	}
	
	private static void initializeCustomers(Banco banco) {
		
		CuentaCorriente cc1 = new CuentaCorriente(1000, 1000);
		CajaAhorro ca1 = new CajaAhorro(100);
        Cliente cliente0 = new Cliente("Sam", "Contreras", ca1, cc1, 11111, 11111);
        banco.addCliente(cliente0);
        
        CajaAhorro ca2 = new CajaAhorro(200);
		CuentaCorriente cc2 = new CuentaCorriente(1000, 1000);
        Cliente cliente1 = new Cliente("Adrian", "Balquinta", ca2, cc2, 22222,22222);
        banco.addCliente(cliente1);
        
		CuentaCorriente cc3 = new CuentaCorriente(1000, 1000);
		CajaAhorro ca3 = new CajaAhorro(300);
        Cliente cliente2 = new Cliente("Pablo ", "Oestereicher", ca3, cc3, 33333, 33333);
        banco.addCliente(cliente2);
        
        CuentaCorriente cc4 = new CuentaCorriente(1000, 1000);
		CajaAhorro ca4 = new CajaAhorro(400);
        Cliente cliente3 = new Cliente("Mayra ", "Gomez", ca4, cc4, 44444, 44444);
        banco.addCliente(cliente3);
        
        CajaAhorro ca5 = new CajaAhorro(500);
		CuentaCorriente cc5 = new CuentaCorriente(1000, 1000);
        Cliente cliente4 = new Cliente("Carlos", "Tevez", ca5, cc5, 55555,55555);
        banco.addCliente(cliente4);
        
        CajaAhorro ca6 = new CajaAhorro(600);
		CuentaCorriente cc6 = new CuentaCorriente(1000, 1000);
        Cliente cliente5 = new Cliente("Ana Maria", "Revollo", ca6, cc6, 66666,66666);
        banco.addCliente(cliente5);
        
        CajaAhorro ca7 = new CajaAhorro(700);
		CuentaCorriente cc7 = new CuentaCorriente(1000, 1000);
        Cliente cliente7 = new Cliente("Gregorio", "Mamani", ca7, cc7, 77777,77777);
        banco.addCliente(cliente7);
        
        CajaAhorro ca8 = new CajaAhorro(700);
		CuentaCorriente cc8 = new CuentaCorriente(1000, 1000);
        Cliente cliente8 = new Cliente("David", "CR", ca8, cc8, 88888,88889);
        banco.addCliente(cliente8);
        
        
        
        
        
        
        
    }
	
		
}
