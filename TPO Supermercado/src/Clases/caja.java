package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class caja {
	//atributos
	private LocalDate fecha;
	private int caja;
	private String cajero;
	private float saldoInicial;
	private float saldoFinal;
	private ArrayList <venta> transacciones;
	private ArrayList <informeVentas> informesDiarios;
	private boolean estado;
	
	//constructor
	public caja(LocalDate fecha, int caja, String cajero, float saldoInicial, float saldoFinal) {
		super();
		this.fecha = fecha;
		this.caja = caja;
		this.cajero = cajero;
		this.saldoInicial = saldoInicial;
		this.saldoFinal = saldoFinal;
		this.estado=false;
		transacciones = new ArrayList<venta>();
		informesDiarios = new ArrayList<informeVentas>();
	}
	
	//getter y setter
	public ArrayList<venta> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(ArrayList<venta> transacciones) {
		this.transacciones = transacciones;
	}

	public ArrayList<informeVentas> getInformesDiarios() {
		return informesDiarios;
	}

	public void setInformesDiarios(ArrayList<informeVentas> informesDiarios) {
		this.informesDiarios = informesDiarios;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setCaja(int caja) {
		this.caja = caja;
	}

	public void setCajero(String cajero) {
		this.cajero = cajero;
	}

	public void setSaldoInicial(float saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public void setSaldoFinal(float saldoFinal) {
		this.saldoFinal = saldoFinal;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public int getCaja() {
		return caja;
	}

	public String getCajero() {
		return cajero;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	//metodos
	public boolean sosLaCaja(int cajaBuscada) {//devuelve si es la caja buscada
		return caja==cajaBuscada;
	}
	
	public void añadirVenta(venta newVenta) {
		transacciones.add(newVenta);
	}
	
	public void actualizarSaldoFinal(venta newVenta) {
		saldoFinal = saldoFinal + newVenta.getValorVenta();//por cada venta se suma el valor de cada venta al valor del saldo final, que inicialmente es igual al saldo inicial
	}
	
	public void emitirInforme() {
		// TODO Auto-generated method stub
		informeVentas informe = new informeVentas(fecha,caja,cajero,saldoInicial,saldoFinal,transacciones);//se crea un informeVentas con los datos de la caja al momento de cierre
		informesDiarios.add(informe);//se añade el informe a la lista
	}
	
	public void cerrarCaja() {
		// TODO Auto-generated method stub
		estado=false;//se actualza su estad
		ArrayList<venta> aux = new ArrayList<venta>();//se crea un arraylist vacio y se reemplaza al actual, para dejar las ventas vacias para el dia siguiente
		transacciones=aux;
	}

	public boolean abrioHoy(LocalDate diaActual) {
		return (fecha.isEqual(diaActual));
	}

	public boolean abrioAntes(LocalDate diaActual) {
		return (fecha.isBefore(diaActual));
	}

	public venta crearVenta() {
		venta newVenta = new venta(fecha,caja,cajero);//creo la venta
		return newVenta;
	}

	public cajaView getView() {
		return (new cajaView(fecha, caja, cajero, saldoInicial, saldoFinal, estado, transacciones, informesDiarios));
	}


}
