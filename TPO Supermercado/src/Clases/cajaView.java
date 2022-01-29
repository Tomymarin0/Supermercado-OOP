package Clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class cajaView {
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
	public cajaView(LocalDate fecha, int caja, String cajero, float saldoInicial, float saldoFinal, boolean estado, ArrayList<venta> transacciones, ArrayList<informeVentas> informesDiarios) {
		super();
		this.fecha = fecha;
		this.caja = caja;
		this.cajero = cajero;
		this.saldoInicial = saldoInicial;
		this.saldoFinal = saldoFinal;
		this.estado=estado;
		transacciones = new ArrayList<venta>();
		informesDiarios = new ArrayList<informeVentas>();
	}

	//getters
	
	public LocalDate getFecha() {
		return fecha;
	}

	public int getCaja() {
		return caja;
	}

	public String getCajero() {
		return cajero;
	}

	public float getSaldoInicial() {
		return saldoInicial;
	}

	public float getSaldoFinal() {
		return saldoFinal;
	}

	public ArrayList<venta> getTransacciones() {
		return transacciones;
	}

	public ArrayList<informeVentas> getInformesDiarios() {
		return informesDiarios;
	}

	public boolean isEstado() {
		return estado;
	}
	

	
	

}
