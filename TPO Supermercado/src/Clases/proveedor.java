package Clases;

public class proveedor {
	//atributos
	private int cuit;
	private String razonSocial;
	private String domicilio;
	private int telefono;
	private String mail;
	private boolean tieneProductos;
	private boolean eliminado;
	
	//constructor
	public proveedor(int cuit, String razonSocial, String domicilio, int telefono, String mail) {
		super();
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.tieneProductos = false;
		this.eliminado = false;
	}
	
	//getter y setter
	public boolean isTieneProductos() {
		return tieneProductos;
	}

	public void setTieneProductos(boolean tieneProductos) {
		this.tieneProductos = tieneProductos;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public boolean isEliminado() {
		return eliminado;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getMail() {
		return mail;
	}

	//metodos
	public boolean sosElProveedor(int cuitBuscado) {
		return (cuit==cuitBuscado);
	}
	
	public boolean sosElTelefono(int tel) {
		return (telefono==tel);
	}
	public boolean tieneProductos(boolean tieneProd) {
		return (tieneProductos==tieneProd);
	}
	public proveedorView getView() {
		return (new proveedorView(cuit,razonSocial,domicilio,telefono,mail,tieneProductos,eliminado));
	}
}
