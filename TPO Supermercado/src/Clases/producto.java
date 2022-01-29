package Clases;

public class producto {
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
	public producto(int codigo, String descripcion, String marca, int proveedor, float precio, int stock,
			int stockMin, int pedidoReposicion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.marca = marca;
		this.proveedor = proveedor;
		this.precio = precio;
		this.stock = stock;
		this.stockMin = stockMin;
		this.pedidoReposicion = pedidoReposicion;
		this.tieneVentas = false;
		this.eliminado = false;
	}
	
	//getter y setter
	public int getProveedor() {
		return proveedor;
	}

	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getPedidoReposicion() {
		return pedidoReposicion;
	}

	public void setPedidoReposicion(int pedidoReposicion) {
		this.pedidoReposicion = pedidoReposicion;
	}

	public boolean isTieneVentas() {
		return tieneVentas;
	}

	public void setTieneVentas(boolean tieneVentas) {
		this.tieneVentas = tieneVentas;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setStockMin(int stockMin) {
		this.stockMin = stockMin;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	public int getStock() {
		return stock;
	}

	public int getStockMin() {
		return stockMin;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	//metodos
	
	public boolean sosElProducto(int codigoBuscado) {
		return codigo==codigoBuscado;
	}
	public boolean sosElProveedor(int prov ) {
		return proveedor==prov;
	}
	public boolean sosElPrecio(float price ) {
		return precio==price;
	}
	public boolean sosElStock(int stockcheck ) {
		return stock==stockcheck;
	}
	public boolean sosElStockMin(int stockcheck ) {
		return stockMin==stockcheck;
	}
	public boolean sosElPedidoReposicion(int rep ) {
		return pedidoReposicion==rep;
	}
	public int necesitaReponer() {
		return stockMin-stock;
	}
	public boolean estaEliminado(boolean elim) {
		return elim=eliminado;
	}
	public void actualizarStock(int cantidad) {
		stock=stock-cantidad;
		tieneVentas=true;
	}
	public productoView getView() {
		return (new productoView(codigo, descripcion, marca, proveedor, precio,stock,
				stockMin, pedidoReposicion, tieneVentas, eliminado));
	}

}
