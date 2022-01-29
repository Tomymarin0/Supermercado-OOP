package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class venta {
	//atributos
	private LocalDate fecha;
	private int caja;
	private String cajero;
	private int nroVenta;
	private ArrayList <itemVenta> items;
	private float valorVenta;
	private float efectivoRecibido;
	private float vuelto;
	
	//constructores
	public venta(LocalDate fecha, int caja, String cajero) {
		super();
		this.fecha = fecha;
		this.caja = caja;
		this.cajero = cajero;
		items=new ArrayList<itemVenta>();
	}
	
	//getter y setter
	public void setNroVenta(int nroVenta) {
		this.nroVenta = nroVenta;
	}
	
	public float getValorVenta() {
		return valorVenta;
	}
	
	public int getCaja() {
		return caja;
	}

	public int getNroVenta() {
		return nroVenta;
	}

	public ArrayList<itemVenta> getItems() {
		return items;
	}

	public float getEfectivoRecibido() {
		return efectivoRecibido;
	}

	public float getVuelto() {
		return vuelto;
	}

	//metodos
	
	public float calcularTotal() {//calcular el total
		float total=0;
		for (int i=0; i<items.size();i++){//recorro todos los item venta, obtengo el precio, multiplico por cantidad y lo voy añadiendo al total
			itemVenta aux = items.get(i);
			total=total+(aux.getPrecio()*aux.getCantidad());
		}
		valorVenta=total;//lo añado a la venta y devuelvo el total
		return total;
	}

	public float calcularVuelto(float efvoRecibido, float total) {//calcula el vuelto
		vuelto=efvoRecibido-total;
		return vuelto;
	}

	public void crearItem(int codigo, int cantidad, float precio) {//cuando se agrega algo al carro de una venta, se crea un item venta con el id del prod, cantidad y el precio
		itemVenta newItem = new itemVenta(codigo, cantidad, precio);
		items.add(newItem);
	}
	
	public Vector<String> getVector() {
		// TODO Auto-generated method stub
		Vector<String>datos = new Vector<String>();
		datos.add(fecha.toString());
		datos.add(String.valueOf(caja));
		datos.add(cajero);
		datos.add(String.valueOf(nroVenta));
		datos.add(String.valueOf(valorVenta));
		
		return datos;
	}

}
