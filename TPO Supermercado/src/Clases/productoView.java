package Clases;

public class productoView {
	//atributos
	private int codigo;
	private String descripcion;
	private String marca;
	private int proveedor;
	private float precio;
	private int stock;
	private int stockMin;
	private int pedidoReposicion;
	private boolean tieneVentas;
	private boolean eliminado;
	
	//constructor
	public productoView(int codigo, String descripcion, String marca, int proveedor, float precio, int stock,
			int stockMin, int pedidoReposicion, boolean tieneVentas, boolean eliminado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.marca = marca;
		this.proveedor = proveedor;
		this.precio = precio;
		this.stock = stock;
		this.stockMin = stockMin;
		this.pedidoReposicion = pedidoReposicion;
		this.tieneVentas = tieneVentas;
		this.eliminado = eliminado;
	}

	//getters
	public int getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public int getProveedor() {
		return proveedor;
	}

	public float getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}

	public int getStockMin() {
		return stockMin;
	}

	public int getPedidoReposicion() {
		return pedidoReposicion;
	}

	public boolean isTieneVentas() {
		return tieneVentas;
	}

	public boolean isEliminado() {
		return eliminado;
	}
	

	
}
