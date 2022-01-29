package Clases;

public class proveedorView {
	private int cuit;
	private String razonSocial;
	private String domicilio;
	private int telefono;
	private String mail;
	private boolean tieneProductos;
	private boolean eliminado;
	
	//constructor
	public proveedorView(int cuit, String razonSocial, String domicilio, int telefono, String mail, boolean tieneProductos, boolean eliminado) {
		super();
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.tieneProductos = tieneProductos;
		this.eliminado = eliminado;
	}
	//getters

	public int getCuit() {
		return cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getMail() {
		return mail;
	}

	public boolean isTieneProductos() {
		return tieneProductos;
	}

	public boolean isEliminado() {
		return eliminado;
	}
	

}
