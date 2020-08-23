package com.bank;

import java.util.Scanner;

public class Atm {
	
	
	private int saldoDisponible;
	private final int VALOR_BILLETE = 20;
	private int cantBilletes;
	private Banco banco;
	private Cliente clienteActivo;
	private Scanner sc;
	private int idTrans = 1;
	
	public Atm(Banco banco) {
		super();
		this.cantBilletes = 500;
		this.saldoDisponible = cantBilletes*VALOR_BILLETE;
		this.banco = banco;
		sc = new Scanner(System.in);
	}
	
	
	
	public Cliente autenticar(int pin, int numCuenta) {
		
		if(banco.autenticar(pin, numCuenta)!=null) {
			
			clienteActivo = banco.autenticar(pin, numCuenta);
			return clienteActivo;
		}
		else {	
			return null;
		}
	}
	
	public void depositoEfectivo(int monto, Cuenta cuenta) {
		Deposito deposito = new Deposito(monto, idTrans++,cuenta.getClass().getSimpleName()+" "+ clienteActivo.getNumCuenta());
		cuenta.depositar(deposito);
		saldoDisponible += monto;
		solicitarSaldo();

	}
	
	
	/*public void extraerEfectivo(int monto) {
		int billetes =monto/this.VALOR_BILLETE;
		Extraccion extraccion = new Extraccion(monto,idTrans++, clienteActivo.getCa().getClass().getSimpleName()+ " " + clienteActivo.getCa().getNumCuenta());
		
		if ((clienteActivo.getCa().validarMontoDisponible(extraccion))==true){
			
			if(this.cantBilletes>=billetes) {
				clienteActivo.getCuenta().extraer(extraccion);
				this.cantBilletes= this.cantBilletes - billetes;
				setSaldoDisponibleAtm(this.cantBilletes);
			}
			else
				System.out.println("LA EXTRACCION NO ES POSIBLE, ESTE CAJERO NO TIENE SUFICIENTE DINERO");
		}
		else 
			System.out.println("LA EXTRACCION NO ES POSIBLE, SOLO POSEE " + clienteActivo.getCuenta().getSaldo() +" EN SU CUENTA");
		
	}*/
	
	public void extraerEfectivo2(int monto) {
		Extraccion extraccion = new Extraccion(monto, idTrans++, clienteActivo.getCa().getClass().getSimpleName()+ " " + clienteActivo.getNumCuenta());
		
		if ((clienteActivo.getCa().validarMontoDisponible(extraccion,clienteActivo))==true){
			
			if(saldoDisponible>=monto) {
				clienteActivo.getCa().extraer(extraccion, clienteActivo);
				saldoDisponible -= monto;
				solicitarSaldo();
			}
			else
				System.out.println("LA EXTRACCION NO ES POSIBLE, ESTE CAJERO NO TIENE SUFICIENTE DINERO");
		}
		else {
			System.out.println("LA EXTRACCION NO ES POSIBLE, NO POSEE SALDO SUFICIENTE EN SU CAJA DE AHORRO, EN SU CUENTA CORRIENTE NI DESCUBIERTO");
			verSaldo();
		}
	}

	public int getSaldoDisponibleAtm() {
		return saldoDisponible;
	}

	public void setSaldoDisponibleAtm(int cantBilletes) {
		this.saldoDisponible = cantBilletes * this.VALOR_BILLETE;
	}
	
	public void setCantBilletes(int cantBilletes) {
		this.cantBilletes=cantBilletes;
	}
	public Cliente getClienteActivo() {
		return clienteActivo;
	}
	
	private void consultaDeTransacciones(){
		HistorialTransacciones ht = new HistorialTransacciones(clienteActivo.getCa());
		HistorialTransacciones ht2 = new HistorialTransacciones(clienteActivo.getCc());
		System.out.println("***REPORTE DE OPERACIONES DE CAJA AHORRO***");
		System.out.println("----------------------------------");
		System.out.println (clienteActivo.getCa().verTransacciones(ht));
		System.out.println("\r\n***REPORTE DE OPERACIONES DE CTA CORRIENTE***");
		System.out.println("----------------------------------");
		System.out.println (clienteActivo.getCa().verTransacciones(ht2));
	}
	
	
	
	public void verSaldo() {
		int saldoCa = this.clienteActivo.getCa().getSaldo();
		int saldoCc = this.clienteActivo.getCc().getSaldo();
		int descubierto = this.clienteActivo.getCc().getDescubierto();
		
		System.out.println("***REPORTE DE SALDOS***");
		System.out.println("-----------------------");
		System.out.println("*** Saldo CA = " +saldoCa);
		System.out.println("*** Saldo CC = " +saldoCc);
		System.out.println("*** Descubierto CC = " +descubierto);
		
		return;
	}
	
	public void getMenu() {
		int opcion,pin,cuenta = 0;
		while (1!=0) {
			boolean salir = false;
			System.out.println("-------------------------");
			System.out.println("--BIENVENIDO AL TP BANK--");
			System.out.println("-------------------------");
			System.out.println(" ");
			System.out.println("Ingresar numero de cuenta: ");
			cuenta= sc.nextInt();
			System.out.println("Ingresar pin: ");
			pin = sc.nextInt();
			if (Integer.toString(cuenta).length() < 5 || Integer.toString(pin).length() < 5 ) 
				System.out.println("\r\n****INGRESAR NRO DE CUENTA Y PIN = 5 DIGITOS\r\n");
			else if(autenticar(pin, cuenta)!=null && autenticar(pin, cuenta).equals(getClienteActivo())) {
				System.out.println(" ");
				System.out.println(" ");
				solicitarSaldo();
				System.out.println(" ");
				System.out.println(" ");
			
				while (!salir) {
					System.out.println("Ingresar opcion: ");
					System.out.println("1-Solicitar saldo");
					System.out.println("2-Retirar efectivo");
					System.out.println("3-Depositar efectivo");
					System.out.println("4-Consulta de transacciones");
					System.out.println("5-Dinero disponible en cajero (OPCION SOLO PARA ADMINISTRADORES)");
					System.out.println("6-Salir");
					opcion	= sc.nextInt();
					while(opcion <= 6 && !salir) {
						switch (opcion) {
						case 1:
							solicitarSaldo();
							opcion=7;
							break;
						case 2:
							retirar();
							opcion=7;
							break;
						case 3:
							System.out.println(" ");
							System.out.println("Ingresar opcion: ");
							System.out.println("31-Caja de ahorro");
							System.out.println("32-Cuenta Corriente");
							int tipo= sc.nextInt();
							if(tipo==31 || tipo==32)
								depositar(tipo);
							else
								System.out.println("\r\nOPCION INCORRECTA\r\n");
							opcion=7;
							break;
						case 4:
							consultarTransacciones();
							opcion=7;
							break;
						case 5:
							saldoAtm();
							opcion=7;
							break;
						case 6:
							salir=true;
							System.out.println("--GRACIAS POR OPERAR CON TP BANK--");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							break;
						default:
							break;
						}
					}
				}
			}
			
			else {
				System.out.println("");
				System.out.println("****NUMERO DE CUENTA Y/O PIN INCORRECTOS, POR FAVOR INGRESE NUEVAMENTE SUS CREDENCIALES");
				System.out.println("");
				opcion = 0;
			}
		}
	}
	
	private void solicitarSaldo() {
		//System.out.println("***Saldo de cuenta " + clienteActivo.getCuenta().getNumCuenta() + ":");
		System.out.println("");
		verSaldo();
		System.out.println("");
		return;
	}

	private void retirar () {
		System.out.println("Ingrese monto a retirar: ");
		int monto = sc.nextInt();
		extraerEfectivo2(monto);
		return;
	}
	
	private void depositar (int tipo) {
		System.out.println("Ingrese monto a depositar: ");
		int monto = sc.nextInt();
		if(tipo==31)
			depositoEfectivo(monto,clienteActivo.getCa());
		else
			depositoEfectivo(monto,clienteActivo.getCc());
		return;
	}
	
	private void consultarTransacciones () {
		consultaDeTransacciones();
		return;
	}
	
	private void saldoAtm () {
		System.out.println("****El saldo disponible en el cajero es de: " + saldoDisponible);
		return;
	}
	
	
	
}
