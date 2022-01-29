package Clases;

import java.util.Vector;

public class informeProductoSinStock {
	//atributos
	private int codigo;
	private int proveedor;
	private float precio;
	private int stock;
	private int stockMin;
	private int reposicion;
	
	//constructor
	public informeProductoSinStock(int codigo, int proveedor, float precio, int stock, int stockMin, int reposicion) {
		super();
		this.codigo = codigo;
		this.proveedor = proveedor;
		this.precio = precio;
		this.stock = stock;
		this.stockMin = stockMin;
		this.reposicion = reposicion;
	}
	//getter y setter



	//metodos

	public Vector<String> getVector() {
		// TODO Auto-generated method stub
		Vector<String>datos = new Vector<String>();
		datos.add(String.valueOf(codigo));
		datos.add(String.valueOf(proveedor));
		datos.add(String.valueOf(precio));
		datos.add(String.valueOf(stock));
		datos.add(String.valueOf(stockMin));
		datos.add(String.valueOf(reposicion));
		
		return datos;
	}
	
	

}
