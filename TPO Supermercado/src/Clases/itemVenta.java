package Clases;

public class itemVenta {
	//atributos
	private int codigo;
	private int cantidad;
	private float precio;
	
	//constructor
	public itemVenta(int codigo, int cantidad, float precio) {
		super();
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	//getter y setter
	public float getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getCodigo() {
		return codigo;
	}
	
	//metodos
	
}
