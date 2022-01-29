package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

public class informeVentas {
	//atributos
	private LocalDate fecha;
	private int caja;
	private String cajero;
	private float saldoInicial;
	private float saldoFinal;
	private ArrayList <venta> transacciones;
	
	//constructor
	public informeVentas(LocalDate fecha, int caja, String cajero, float saldoInicial, float saldoFinal, ArrayList<venta> transacciones) {
		super();
		this.fecha = fecha;
		this.caja = caja;
		this.cajero = cajero;
		this.saldoInicial = saldoInicial;
		this.saldoFinal = saldoFinal;
		this.transacciones = transacciones;
	}

	//getter y setter
	public LocalDate getFecha() {
		return fecha;
	}

	public String getCajero() {
		return cajero;
	}

	public ArrayList<venta> getTransacciones() {
		return transacciones;
	}	
	
	//metodos
	
	public boolean sosLaFecha(LocalDate fecha2) {
		return fecha.isEqual(fecha2);
	}
	public boolean sosElCajero(String cajero2) {
		return cajero.equalsIgnoreCase(cajero2);
	}

	public Vector<String> getVector() {
		// TODO Auto-generated method stub
		Vector<String>datos = new Vector<String>();
		datos.add(fecha.toString());
		datos.add(String.valueOf(caja));
		datos.add(cajero);
		datos.add(String.valueOf(saldoInicial));
		datos.add(String.valueOf(saldoFinal));
		datos.add(String.valueOf(transacciones.size()));
		
		return datos;
	}
	
}
