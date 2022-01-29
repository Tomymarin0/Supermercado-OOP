package Controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import Clases.caja;
import Clases.cajaView;
import Clases.informeProductoSinStock;
import Clases.informeVentas;
import Clases.itemVenta;
import Clases.producto;
import Clases.productoView;
import Clases.proveedor;
import Clases.proveedorView;
import Clases.venta;

public class Supermercado {
	//atributos
	private ArrayList <producto> productos;
	private ArrayList <proveedor> proveedores;
	private ArrayList <caja> cajas;
	private ArrayList <String> cajeros;
	private static Supermercado instancia;

	private int nroVenta;
	
	
	private Supermercado() {
		super();
		// TODO Auto-generated constructor stub
		productos = new ArrayList<producto>();
		proveedores = new ArrayList<proveedor>();
		cajas = new ArrayList<caja>();
		cajeros = new ArrayList<String>();
		this.nroVenta=0;
		cargaInicial();

	}
	
	public static Supermercado getInstancia()
	{
		if (instancia==null)
			instancia = new Supermercado();
		return instancia;
	}
	
	private void cargaInicial() {
		LocalDate fecha = LocalDate.of(2021, 1, 12);
		caja uno = new caja(fecha, 1, "", 0, 0);
		caja dos = new caja(fecha, 2, "", 0, 0);
		caja tres = new caja(fecha, 3, "", 0, 0);
		caja cuatro = new caja(fecha, 4, "", 0, 0);
		cajas.add(uno);
		cajas.add(dos);
		cajas.add(tres);
		cajas.add(cuatro);
		agregarCajero("carlos");
		agregarCajero("gaspar");
		agregarCajero("victoria");
		agregarCajero("emilia");
		crearProveedor(1,"hola","rivadavia 6500",1234,"hola@gmail.com");
		crearProveedor(2,"holaf","donato 6500",1234,"hola@gmail.com");
		crearProducto(123, "galletitas de agua", "traviata", 1, 150.50f, 130, 20, 100);
		crearProducto(111, "Queso mantecoso", "Sancor", 1, 350f, 50, 20, 100);
		crearProducto(124, "galletitas de agua", "traviata", 1, 150.50f, 10, 20, 100);
		crearProducto(125, "galletitas dulces", "oreo", 1, 150.50f, 10, 20, 100);
		crearProducto(126, "papas fritas", "lays", 1, 150.50f, 10, 20, 100);
		crearProducto(127, "gaseosa", "coca cola", 1, 150.50f, 10, 20, 100);
		crearProducto(128, "gaseosa", "pepsi", 1, 150.50f, 10, 20, 100);
		crearProducto(129, "gaseosa", "sprite", 1, 150.50f, 10, 20, 100);
		crearProducto(130, "gaseosa", "7up", 1, 150.50f, 10, 20, 100);
		crearProducto(131, "galletitas dulces", "oreo", 1, 150.50f, 10, 20, 100);
		crearProducto(132, "papas fritas", "lays", 1, 150.50f, 10, 20, 100);
		crearProducto(133, "gaseosa", "coca cola", 1, 150.50f, 10, 20, 56);
		crearProducto(134, "gaseosa", "pepsi", 1, 150.50f, 10, 20, 44);
		crearProducto(135, "gaseosa", "sprite", 1, 150.50f, 10, 20, 89);
		crearProducto(136, "gaseosa", "7up", 1, 150.50f, 10, 20, 77);
		LocalDate fecha2 = LocalDate.of(2021, 9, 9);
		
		int i=0;
		while(i<25) {
			abrirCaja(fecha2,1,"carlos",123);
			fecha2=fecha2.plusDays(1);
			venta venta = iniciarVenta(1);
			agregarItems(venta,123,5);
			venta.calcularTotal();
			venta.calcularVuelto(1000, venta.getValorVenta());
			finalizarVenta(venta);
			cerrarCaja(1);
			i++;
		}
		
		}
		
	//metodos de negocio
	
	//proveedor
	private proveedor buscarProveedor(int cuit) { // busca el proveedor, si lo encuetra devuelve el objeto proveedor, sino, devuelve null
		for (int i=0; i<proveedores.size();i++){
			proveedor aux = proveedores.get(i);
			if (aux.sosElProveedor(cuit))
				return aux;			
		}
		
		return null;
	}
	
	public proveedorView buscarProveedorView(int cuit) {//obtiene la vista del proveedor y la envia
		proveedor prov = buscarProveedor(cuit);
		if(prov!=null)
			return prov.getView();
		return null;
	}
	
	public void crearProveedor(int cuit, String razonSocial, String domicilio, int telefono, String mail) //busca que no exista el proveedor por el cuit, si existe no hace nada
	{																		//si no existe lo crea y lo añade al array de proveedores
		proveedor newProveedor = buscarProveedor(cuit);
		if (newProveedor == null)
		{
			newProveedor = new proveedor(cuit, razonSocial, domicilio, telefono, mail);
			proveedores.add(newProveedor);
		}		
	}
	public void modificarProveedor(int cuit, String razonSocial, String domicilio, int telefono, String mail) {//permite modificar todo menos el cuit
		proveedor modProveedor = buscarProveedor(cuit); //busca que el proveedor exista, sino existe no se hace nada
		if (modProveedor!= null) {
			if(domicilio!=null)
				modProveedor.setDomicilio(domicilio);
			if(razonSocial!=null)
				modProveedor.setRazonSocial(razonSocial);
			if(!modProveedor.sosElTelefono(telefono))
				modProveedor.setTelefono(telefono);
			if(mail!=null)
				modProveedor.setMail(mail);
		}
	}
	public void eliminarProveedor(int cuit) { //baja logica del proveedor, le cambia su estado a eliminado
		proveedor existeProv=buscarProveedor(cuit);
		if (existeProv!=null)
			existeProv.setEliminado(true);
	}
	public void bajaFisicaProveedor(int cuit) {//baja fisica del proveedor, se lo elimina del array de proveedores
		proveedor existeProv=buscarProveedor(cuit);
		int posicion = 0;
		if(existeProv!=null) {
			if(existeProv.isTieneProductos()==false) {//para poder realizar la baja total el sistema debe verificar que no tenga productos, si NO tiene productos se lo borra
				 posicion=buscarPosicionProv(cuit);
				 if(posicion!=-1) {
					 proveedores.remove(posicion);
				 }
			}
		}
			
	}
	private int buscarPosicionProv(int cuit) {//devuelve la posicion en la cual esta el proveedor que se desea, si no existe devuelve -1
		for (int i=0; i<proveedores.size();i++){
			proveedor aux = proveedores.get(i);
			if (aux.sosElProveedor(cuit))
				return i;			
		}
		
		return -1;
	}
	
	//producto
	private producto buscarProducto(int codigo) {// busca el producto, si lo encuetra devuelve el objeto producto, sino, devuelve null
		for (int i=0; i<productos.size();i++){
			producto aux = productos.get(i);
			if (aux.sosElProducto(codigo))
				return aux;			
		}
		
		return null;
	}
	
	public productoView buscarProductoView(int codigo) {//devuelve las views del producto buscado
		producto prod = buscarProducto(codigo);
		if(prod!=null)
			return prod.getView();
		return null;
	}
	
	public void crearProducto(int codigo, String descripcion, String marca, int proveedor, float precio, int stock,
			int stockMin, int rep)
	{ //para crear el producto verifica que este no exista, si existe no se hace nada
		producto newProducto = buscarProducto(codigo);
		if (newProducto == null){
			proveedor existeProv = buscarProveedor(proveedor);//verifica que el proveedor que se le quiera asignar exista, si no existe no se hace nada
			if (existeProv!=null) {
				if(existeProv.isEliminado()==false) { //si estaba eliminado logicamente lo reactiva
					newProducto = new producto(codigo, descripcion, marca, proveedor, precio, stock, stockMin, rep);
					productos.add(newProducto);
					existeProv.setTieneProductos(true);

				}
			}
		} 
	}
	
	public void modificarProducto(int codigo, String descripcion, String marca, int proveedor, float precio, int stock,
			int stockMin, int pedidoReposicion, boolean elim) {//permite modificar todo menos el codigo
		producto modProducto = buscarProducto(codigo);
		if (modProducto!= null) {//si el producto no existe no se hace nada
			if(descripcion!=null)
				modProducto.setDescripcion(descripcion);
			if(marca!=null)
				modProducto.setMarca(marca);
			if(!modProducto.sosElProveedor(proveedor)) {
				proveedor newProveedor= buscarProveedor(proveedor);//verifica que exista el nuevo proveedor
				if (newProveedor!=null) {
					modProducto.setProveedor(proveedor);
					newProveedor.setEliminado(false);//cambia el estado de eliminado a false porque vuelve a tener productos
					newProveedor.setTieneProductos(true);//cambia el estado de tiene productos a true por si no tuviera antes
				}
				if(!modProducto.sosElPrecio(precio)) 
					modProducto.setPrecio(precio);
				if(!modProducto.sosElStock(stock))
					modProducto.setStock(stock);
				if(!modProducto.sosElStockMin(stockMin))
					modProducto.setStockMin(stockMin);
				if(!modProducto.sosElPedidoReposicion(pedidoReposicion))
					modProducto.setPedidoReposicion(pedidoReposicion);
				if(!modProducto.estaEliminado(elim)) 
					modProducto.setEliminado(elim);
				
			} else {
				if(!modProducto.sosElPrecio(precio)) 
					modProducto.setPrecio(precio);
				if(!modProducto.sosElStock(stock))
					modProducto.setStock(stock);
				if(!modProducto.sosElStockMin(stockMin))
					modProducto.setStockMin(stockMin);
				if(!modProducto.sosElPedidoReposicion(pedidoReposicion))
					modProducto.setPedidoReposicion(pedidoReposicion);
				if(!modProducto.estaEliminado(elim)) 
					modProducto.setEliminado(elim);
			}
		}
	}
	
	public void eliminarProducto(int codigo) {//baja logica del producto, en caso de no existir no hace nada
		producto existeProd=buscarProducto(codigo);
		if (existeProd!=null)
			existeProd.setEliminado(true);//cambia el estado a eliminado
	}
	
	public void bajaFisicaProducto(int codigo ) {//baja fisica del sistema
		producto existeProd=buscarProducto(codigo);
		int posicion = 0;
		if(existeProd!=null) {//si no existe no hace nada
			if(existeProd.isTieneVentas()==false) {//si tiene ventas NO se lo puede eliminar por requerimiento del negocio
				 posicion=buscarPosicionProd(codigo);
				 if(posicion!=-1) {
					 productos.remove(posicion);
				 }
			}
		}
			
	}
	private int buscarPosicionProd(int codigo) {//busca la posicion del producto en el array de productos y lo devuelve, en caso de no existir devuelve -1
		for (int i=0; i<productos.size();i++){
			producto aux = productos.get(i);
			if (aux.sosElProducto(codigo))
				return i;			
		}
		
		return -1;
	}
	
	//producto sin stock
	public Vector<Vector<String>> prodSinStock() { //devuelve un array list de productos sin stock
		ArrayList <informeProductoSinStock> productosSinStock; 
		productosSinStock = new ArrayList<informeProductoSinStock>();
		for (int i=0; i<productos.size();i++){ //recorro todos los productos
			producto aux = productos.get(i);
			int necesitaReponer = aux.necesitaReponer();//calculo diferencia entre stock minimo y stock
			if(necesitaReponer>0) {//si esa dif es positiva significa que hay que reponer
				informeProductoSinStock newInforme = new informeProductoSinStock(aux.getCodigo(),aux.getProveedor(),aux.getPrecio(),aux.getStock(),aux.getStockMin(),aux.getPedidoReposicion());//se genera informe
				productosSinStock.add(newInforme);//se lo añade
			}
		}
		return getViewsSinStock(productosSinStock);
	}
	
	//caja
	private caja buscarCaja(int caja) {// busca la caja, si la encuetra devuelve el objeto caja, sino, devuelve null
		for (int i=0; i<cajas.size();i++){
			caja aux = cajas.get(i);
			if (aux.sosLaCaja(caja))
				return aux;			
		}
		
		return null;
	}
	
	public cajaView buscarCajaView(int caja) {//obtiene las views de la caja buscada y las envia
		caja caj = buscarCaja(caja);
		if(caj!=null)
			return caj.getView();
		return null;
	}
	
	public boolean buscarCajero(String cajero) {// busca al cajero, si la encuetra devuelve true, sino false
		for (int i=0; i<cajeros.size();i++){
			String aux = cajeros.get(i);
			if (aux.equalsIgnoreCase(cajero))
				return true;			
		}
		
		return false;
	}
	
	public boolean estaAbierta(int caja, LocalDate diaActual) {//recibe la caja y la fecha en la que se la quiere abrir
		caja aux=buscarCaja(caja);
		if(aux.isEstado()) {
			return true;
		}
		if (aux.abrioHoy(diaActual)) {//si la ultima fecha de la caja coincide con la fecha recibida significa que esta abierta
			return true;
		}
		if (aux.abrioAntes(diaActual))//si la ultima fecha de la caja esta antes de la recibida significa que hoy no abrio, por ende, se puede abrir
			return false;

		return true;		
	}
	
	public boolean abrirCaja(LocalDate fecha, int caja, String cajero, float saldoInicial) {
		caja existe=buscarCaja(caja);
		boolean esta=estaAbierta(caja,fecha);
		boolean existeCajero =buscarCajero(cajero);
		if(existe!=null && esta!=true && existeCajero==true) {//verifica que la caja exista, que no este abierta y que exista el cajero
			existe.setFecha(fecha); //si eso se cumple actualizo la caja con los datos ingresados
			existe.setCajero(cajero);
			existe.setSaldoInicial(saldoInicial);
			existe.setSaldoFinal(saldoInicial);
			existe.setEstado(true);
			return true;
		} else {
			return false;
		}
	}
	
	public venta iniciarVenta(int idcaja) {//se recibe el nro de caja
		caja caja = buscarCaja(idcaja);
		//boolean abierta = estaAbierta(idcaja,diaActual);
		if(caja!=null && caja.isEstado()==true) { //si la caja existe, si esta abierta y no fue cerrada en la fecha actual se abre
			venta newVenta = caja.crearVenta();//crea la venta y me devuevle el objeto venta
			return newVenta;
		} else {
			return null;
		}
		
	}
			
	public void agregarItems(venta newVenta, int codigo, int cantidad) {
			producto prod = buscarProducto(codigo);//se obtiene el producto buscado
			if(prod!=null && prod.isEliminado()!=true) {//se verifica que el producto exista
				float precio = prod.getPrecio();
				newVenta.crearItem(codigo,cantidad,precio);//se genera un item venta por cada producto y se agrega a la lista de itemsVenta
			}
	}

	
	public void actualizarStock(venta newVenta) { //actualiza el stock
		ArrayList<itemVenta> items = newVenta.getItems();//de la venta recibida obtengo la lista de items con su respectivo producto y cantidad
		int i = 0;
		while(i<items.size()) {//recorre la lista de items, por cada item obtiene su codigo y cantidad
			itemVenta aux = items.get(i);
			int cantidad = aux.getCantidad();
			int codigo = aux.getCodigo();
			producto miProd = buscarProducto(codigo);//busca el producto
			miProd.actualizarStock(cantidad);//actualiza el stock del producto buscado
			i++;
		}
		newVenta.setNroVenta(nroVenta);//como la venta ya esta totalmente confirmada se le asigna un numero de venta unico global del supermercado
		nroVenta++;	
	}
	
	public void finalizarVenta(venta newVenta) {
		caja caja = buscarCaja(newVenta.getCaja());
		caja.añadirVenta(newVenta);//se añade la venta a la lista de ventas
		caja.actualizarSaldoFinal(newVenta);//se actualiza el saldo final
		actualizarStock(newVenta);
	}
	
	public boolean cerrarCaja(int nroCaja) {
		caja caja = buscarCaja(nroCaja);
		if (caja.isEstado()==true) {//si la caja que se desea cerrar esta abierta se emite el informe diario y se cierra la caja
			caja.emitirInforme();//se genera el informe diario de la caja
			caja.cerrarCaja();
			return true;
		} else {
			return false;
		}
	}
	
	//obtener datos para tabla
	public Vector<Vector<String>> getViews(ArrayList<informeVentas> listado){
		Vector<Vector<String>> listadoFinal = new Vector<Vector<String>>();//se crea una lista vacia
		int i=0;
		while(i<listado.size()) {//se recorre la lista recibida
			listadoFinal.add(listado.get(i).getVector());// se los convierte al formato necesario para la tabla
			i++;
		}
		return listadoFinal;
		
	}
	
	public Vector<Vector<String>> getViewsVentas(ArrayList<venta> listado){
		Vector<Vector<String>> listadoFinal = new Vector<Vector<String>>();
		int i=0;
		while(i<listado.size()) {//recorro toda la lista
			listadoFinal.add(listado.get(i).getVector());// se los convierte al formato necesario para la tabla
			i++;
		}
		return listadoFinal;
		
	}
	
	public Vector<Vector<String>> getViewsSinStock(ArrayList<informeProductoSinStock> listado){
		Vector<Vector<String>> listadoFinal = new Vector<Vector<String>>();
		int i=0;
		while(i<listado.size()) {//recorro toda la lista
			listadoFinal.add(listado.get(i).getVector());// se los convierte al formato necesario para la tabla
			i++;
		}
		return listadoFinal;
		

		
	}
	//informes diarios
	public Vector<Vector<String>> getInformesPorCaja(int caja) {
		caja aux = buscarCaja(caja);
		ArrayList<informeVentas> informes = aux.getInformesDiarios();
		if (informes.size()>0) {
			return getViews(informes);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
			return null;
		}
	}
	
	public Vector<Vector<String>> getInformesPorFecha(LocalDate fecha) {
		int i=1;
		ArrayList<informeVentas> listaFinal = new ArrayList<informeVentas>();
		while(i<cajas.size()+1) {//recorro todas las cajas
			caja aux = buscarCaja(i);
			ArrayList<informeVentas> informes = aux.getInformesDiarios();
			int j=0;
			while(j<informes.size()) {//recorro todos los informes de la caja
				informeVentas inf = informes.get(j);
				if(inf.getFecha().isEqual(fecha)) {
					listaFinal.add(inf);
				}
				j++;
			}
			i++;
		}
		if (listaFinal.size()>0) {
			return getViews(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
			return null;
		}
	}
	
	public Vector<Vector<String>> getInformesPorCajero(String cajero) {
		int i=1;
		ArrayList<informeVentas> listaFinal = new ArrayList<informeVentas>();
		while(i<cajas.size()+1) {//recorro todas las cajas
			caja aux = buscarCaja(i);
			ArrayList<informeVentas> informes = aux.getInformesDiarios();
			int j=0;
			while(j<informes.size()) {//recorro todos los informes de la caja
				informeVentas inf = informes.get(j);
				if(inf.getCajero().equalsIgnoreCase(cajero)) {
					listaFinal.add(inf);
				}
				j++;
			}
			i++;
		}
		if (listaFinal.size()>0) {
			return getViews(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
			return null;
		}
	}
	
	public Vector<Vector<String>> getInformeNumeroCajero(int numero, String cajero) {
		caja aux = buscarCaja(numero);
		ArrayList<informeVentas> lista = aux.getInformesDiarios();
		ArrayList<informeVentas> listaFinal = new ArrayList<informeVentas>();
		int i=0;
		while(i<lista.size()) {//recorro todos los informes
			informeVentas informe = lista.get(i);
			if(informe.getCajero().equalsIgnoreCase(cajero)) {
				listaFinal.add(informe);
			}
			i++;
		}
		if (listaFinal.size()>0) {
			return getViews(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
			return null;
		}
	}
	
	public Vector<Vector<String>> getInformeNumeroFecha(int numero, LocalDate fecha) {
		caja aux = buscarCaja(numero);
		ArrayList<informeVentas> lista = aux.getInformesDiarios();
		ArrayList<informeVentas> listaFinal = new ArrayList<informeVentas>();
		int i=0;
		while(i<lista.size()) {//recorro todos los informes
			informeVentas informe = lista.get(i);
			if(informe.getFecha().isEqual(fecha)) {
				listaFinal.add(informe);
			}
			i++;
		}
		if (listaFinal.size()>0) {
			return getViews(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
			return null;
		}
	}
	
	public Vector<Vector<String>> getInformeCajeroFecha(String cajero, LocalDate fecha){
		ArrayList<informeVentas> listaFinal = new ArrayList<informeVentas>();
		int i=1;
		while(i<cajas.size()+1) {//recorro todas las cajas
			caja caja = buscarCaja(i);
			ArrayList<informeVentas> aux = caja.getInformesDiarios();
			int j=0;
			while(j<aux.size()) {//recorro todos los informes de las cajas
				informeVentas informe = aux.get(j);
				if(informe.getCajero().equalsIgnoreCase(cajero) && informe.getFecha().isEqual(fecha)) {
					listaFinal.add(informe);
				}
				j++;
			}
			i++;
		}
		if (listaFinal.size()>0) {
			return getViews(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
			return null;
		}
	}
	
	public Vector<Vector<String>> getInformeNumeroFechaCajero(int numero, LocalDate fecha, String cajero){
		caja caja = buscarCaja(numero);
		ArrayList<informeVentas> informes = caja.getInformesDiarios();
		ArrayList<informeVentas> listaFinal = new ArrayList<informeVentas>();
		int i=0;
		while(i<informes.size()) {//recorro todos los informes
			informeVentas aux = informes.get(i);
			if(aux.getFecha().isEqual(fecha) && aux.getCajero().equalsIgnoreCase(cajero)) {
				listaFinal.add(aux);
				return getViews(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
			}
			i++;
		}
		return null;
		
	}
	public Vector<Vector<String>> getTodosLosInformes () {
		int i=1;
		ArrayList<informeVentas> listaFinal = new ArrayList<informeVentas>();
		while(i<cajas.size()+1) {//recorro todas las cajas
			caja aux = buscarCaja(i);
			ArrayList<informeVentas> informes = aux.getInformesDiarios();
			int j=0;
			while(j<informes.size()) {//recorro todos los informes de la caja
				informeVentas inf = informes.get(j);
				listaFinal.add(inf);
				j++;
			}
			i++;
		}
		if (listaFinal.size()>0) {
			return getViews(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
			return null;
		}	
	}
	
	
	//informes ventas
	public Vector<Vector<String>> getVentasPorCajero(String cajero) {
		int i=1;
		ArrayList<venta> listaFinal = new ArrayList<venta>();
		while(i<cajas.size()+1) {//recorro todas las cajas
			caja aux = buscarCaja(i);
			ArrayList<informeVentas> informes = aux.getInformesDiarios();
			int j=0;
			while(j<informes.size()) {//recorro todos los infomes de la caja
				informeVentas inf = informes.get(j);
				if(inf.getCajero().equalsIgnoreCase(cajero)) {
					listaFinal.addAll(inf.getTransacciones());
				}
				j++;
			}
			i++;
		}
		if (listaFinal.size()>0) {
			return getViewsVentas(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
			return null;
		}
		
	}
	
	public Vector<Vector<String>> getVentasPorCaja(int caja) {
		caja aux = buscarCaja(caja);
		ArrayList<venta> listaFinal = new ArrayList<venta>(); 
		ArrayList<informeVentas> informes = aux.getInformesDiarios();
		int i=0;
		while(informes.size()>i) {//recorro todos los informes
			informeVentas inf = informes.get(i);
			ArrayList<venta> transacciones = inf.getTransacciones();
			listaFinal.addAll(transacciones);
			i++;
		}
		if (listaFinal.size()>0) {
			return getViewsVentas(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
			return null;
		}
	}
	
	public Vector<Vector<String>> getVentasEntreFechas(LocalDate desde, LocalDate hasta) {
		int i=1;
		ArrayList<venta> listaFinal = new ArrayList<venta>();
		boolean esUnico = desde.isEqual(hasta);
		while(i<cajas.size()+1) {//recorro todas las cajas
			caja aux = buscarCaja(i);
			ArrayList<informeVentas> informes = aux.getInformesDiarios();
			int j=0;
			while(j<informes.size()) {//recorro todos los informes
				informeVentas inf = informes.get(j);
				LocalDate fecha = inf.getFecha();
				if(hasta.isAfter(fecha) && desde.isBefore(fecha)) {
					listaFinal.addAll(inf.getTransacciones());
				}
				if(fecha.isEqual(desde))
					listaFinal.addAll(inf.getTransacciones());
				if(fecha.isEqual(hasta) && esUnico!=true)
					listaFinal.addAll(inf.getTransacciones());
				j++;
			}
			i++;
		}
		if (listaFinal.size()>0) {
			return getViewsVentas(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
			return null;
		}
		
	}
	
	public Vector<Vector<String>> getVentasNumeroCajero(int numero, String cajero){
		caja caja = buscarCaja(numero);
		ArrayList<informeVentas> informes = caja.getInformesDiarios();
		ArrayList<venta> listaFinal = new ArrayList<venta>();
		int i=0;
		while(i<informes.size()) {//recorro todos los informes
			informeVentas aux = informes.get(i);
			if(aux.getCajero().equalsIgnoreCase(cajero)) {
				listaFinal.addAll(aux.getTransacciones());
			}
			i++;
		}
		if(listaFinal.size()>0) {
			return getViewsVentas(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
		return null;
		}
		
	}
	
	public Vector<Vector<String>> getVentasNumeroFechas(int numero, LocalDate desde, LocalDate hasta){
		caja caja = buscarCaja(numero);
		ArrayList<informeVentas> informes = caja.getInformesDiarios();
		ArrayList<venta> listaFinal = new ArrayList<venta>();
		int i=0;
		boolean esUnico = desde.isEqual(hasta);
		while(i<informes.size()) {//recorro todos los infomes
			informeVentas aux = informes.get(i);
			LocalDate fecha = aux.getFecha();
			if(hasta.isAfter(fecha) && desde.isBefore(fecha)) {
				listaFinal.addAll(aux.getTransacciones());
			}
			if(fecha.isEqual(desde))
				listaFinal.addAll(aux.getTransacciones());
			if(fecha.isEqual(hasta) && esUnico!=true)
				listaFinal.addAll(aux.getTransacciones());
			i++;
		}
		if(listaFinal.size()>0) {
			return getViewsVentas(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
		return null;
		}
		
	}
	
	public Vector<Vector<String>> getVentasCajeroFechas(String cajero, LocalDate desde, LocalDate hasta){
		int i=1;
		ArrayList<venta> listaFinal = new ArrayList<venta>();
		boolean esUnico = desde.isEqual(hasta);
		while(i<cajas.size()+1) {//recorro todas las cajas
			caja caja = buscarCaja(i);
			ArrayList<informeVentas> informes = caja.getInformesDiarios();
			int j=0;
			while(j<informes.size()) {//recorro todos los informes
				informeVentas aux = informes.get(j);
				LocalDate fecha = aux.getFecha();
				if(aux.getCajero().equalsIgnoreCase(cajero)) {
					if(hasta.isAfter(fecha) && desde.isBefore(fecha)) {
						listaFinal.addAll(aux.getTransacciones());
					}
					if(fecha.isEqual(desde))
						listaFinal.addAll(aux.getTransacciones());
					if(fecha.isEqual(hasta) && esUnico!=true)
						listaFinal.addAll(aux.getTransacciones());
				}

				j++;
			}
			i++;
		}
		if (listaFinal.size()>0) {
			return getViewsVentas(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
			return null;
		}
		
		
	}
	
	public Vector<Vector<String>> getTodasLasVentas(){
		int i=1;
		ArrayList<venta> listaFinal = new ArrayList<venta>();
		while(i<cajas.size()+1) {//recorro todas las cajas
			caja aux = buscarCaja(i);
			ArrayList<informeVentas> informes = aux.getInformesDiarios();
			int j=0;
			while(j<informes.size()) {//recorro todos los informes de la caja
				informeVentas inf = informes.get(j);
				listaFinal.addAll(inf.getTransacciones());
				j++;
			}
			i++;
		}
		if (listaFinal.size()>0) {
			return getViewsVentas(listaFinal);//devuelve la lista de informes ya convertida en el formato necesario de la tabla
		} else {
			return null;
		}
		
	}
	//extras
	public void agregarCajero(String x) {
		cajeros.add(x);
	}
	public void eliminarCajero(String cajero) {
		for (int i=0; i<cajeros.size();i++){
			String aux = cajeros.get(i);
			if (aux.equalsIgnoreCase(cajero))
				cajeros.remove(i);			
		}
	}
}