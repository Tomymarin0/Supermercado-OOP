package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Supermercado;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class menuPrincipal extends JFrame {

	private JPanel contentPane;
	private Supermercado controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menuPrincipal() {
		//instanciar controlador
		//Crear instancia del controlador
		controlador = Supermercado.getInstancia();
		//setear titulo
		setTitle("Menu Principal Supermercado");
		//establecer operacion por defecto
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//modifica tamañl
		setBounds(100, 100, 741, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 725, 21);
		contentPane.add(menuBar);
		
		JMenu cajas = new JMenu("Cajas");
		menuBar.add(cajas);
		
		JMenuItem abrirCaja = new JMenuItem("Abrir Caja");
		abrirCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirCaja miVentana = new AbrirCaja();
				miVentana.setVisible(true);
			}
		});
		cajas.add(abrirCaja);
		
		JMenuItem cerrarCaja = new JMenuItem("Cerrar Caja");
		cerrarCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CerrarCaja miVentana = new CerrarCaja();
				miVentana.setVisible(true);
			}
		});
		
		JMenuItem iniciarVenta = new JMenuItem("Iniciar Venta");
		iniciarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venta miVentana = new venta ();
				miVentana.setVisible(true);
			}
		});
		cajas.add(iniciarVenta);
		cajas.add(cerrarCaja);
		
		JMenu cajeros = new JMenu("Cajeros");
		menuBar.add(cajeros);
		
		JMenuItem Cajero = new JMenuItem("Agregar Cajero");
		Cajero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarCajero miVentana = new AgregarCajero();
				miVentana.setVisible(true);
			}
		});
		cajeros.add(Cajero);
		
		JMenuItem eliminarCajero = new JMenuItem("Eliminar Cajero");
		eliminarCajero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarCajero miVentana = new EliminarCajero();
				miVentana.setVisible(true);
			}
		});
		cajeros.add(eliminarCajero);
		
		JMenu proveedores = new JMenu("Proveedores");
		menuBar.add(proveedores);
		
		JMenuItem crearProveedor = new JMenuItem("Crear Proveedor");
		crearProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaProveedor miVentana = new AltaProveedor();
				miVentana.setVisible(true);
			}
		});
		proveedores.add(crearProveedor);
		
		JMenuItem modificarProveedor = new JMenuItem("Modificar Proveedor");
		modificarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProveedor miVentana = new ModificarProveedor();
				miVentana.setVisible(true);
			}
		});
		proveedores.add(modificarProveedor);
		
		JMenuItem eliminarProveedor = new JMenuItem("Eliminar Proveedor");
		eliminarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaProveedor miVentana = new BajaProveedor();
				miVentana.setVisible(true);
			}
		});
		proveedores.add(eliminarProveedor);
		
		JMenu productos = new JMenu("Productos");
		menuBar.add(productos);
		
		JMenuItem crearProducto = new JMenuItem("Crear Producto");
		crearProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaProducto miVentana = new AltaProducto();
				miVentana.setVisible(true);
			}
		});
		productos.add(crearProducto);
		
		JMenuItem modificarProducto = new JMenuItem("Modificar Producto");
		modificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProducto miVentana = new ModificarProducto();
				miVentana.setVisible(true);
			}
		});
		productos.add(modificarProducto);
		
		JMenuItem eliminarProducto = new JMenuItem("Eliminar Producto");
		eliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaProducto miVentana = new BajaProducto();
				miVentana.setVisible(true);
			}
		});
		productos.add(eliminarProducto);
		
		JMenu informes = new JMenu("Informes");
		menuBar.add(informes);
		
		JMenuItem buscarInformeDiario = new JMenuItem("Buscar Informes Diarios");
		buscarInformeDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarInformeDiario miVentana = new BuscarInformeDiario();
				miVentana.setVisible(true);
			}
		});
		informes.add(buscarInformeDiario);
		
		JMenuItem buscarVentas = new JMenuItem("Buscar Ventas");
		buscarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarVentas miVentana = new BuscarVentas();
				miVentana.setVisible(true);
			}
		});
		informes.add(buscarVentas);
		
		JMenuItem generarInfStock = new JMenuItem("Generar Informes Stock");
		generarInfStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<Vector<String>> informe = Supermercado.getInstancia().prodSinStock();
				if(informe!=null) {
					tablaInformesSinStock miVentana = new tablaInformesSinStock(informe);
					miVentana.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,"No se generaron informes","Error Informe",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		informes.add(generarInfStock);
		
		JMenu salir = new JMenu("Salir");
		menuBar.add(salir);
		
		JMenuItem salirDelSistema = new JMenuItem("Salir del sistema");
		salirDelSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		salir.add(salirDelSistema);
	}
}
