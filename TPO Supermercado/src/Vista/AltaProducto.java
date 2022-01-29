package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.proveedorView;
import Controlador.Supermercado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaProducto extends JFrame {

	private JPanel contentPane;
	private JTextField codigo;
	private JTextField descripcion;
	private JTextField marca;
	private JTextField proveedor;
	private JTextField precio;
	private JTextField stock;
	private JTextField stockMin;
	private JTextField reposicion;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AltaProducto() {
		setTitle("Crear Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel wregewrg = new JLabel("Codigo:");
		wregewrg.setBounds(10, 42, 46, 14);
		contentPane.add(wregewrg);
		
		codigo = new JTextField();
		codigo.setBounds(120, 39, 58, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descripcion:");
		lblNewLabel.setBounds(10, 98, 76, 14);
		contentPane.add(lblNewLabel);
		
		descripcion = new JTextField();
		descripcion.setBounds(120, 95, 190, 20);
		contentPane.add(descripcion);
		descripcion.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setBounds(10, 154, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		marca = new JTextField();
		marca.setBounds(120, 151, 190, 20);
		contentPane.add(marca);
		marca.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Proveedor:");
		lblNewLabel_2.setBounds(10, 210, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		proveedor = new JTextField();
		proveedor.setBounds(120, 207, 58, 20);
		contentPane.add(proveedor);
		proveedor.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(10, 266, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		precio = new JTextField();
		precio.setBounds(120, 263, 58, 20);
		contentPane.add(precio);
		precio.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Stock:");
		lblNewLabel_4.setBounds(10, 322, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		stock = new JTextField();
		stock.setBounds(120, 319, 58, 20);
		contentPane.add(stock);
		stock.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Stock Minimo:");
		lblNewLabel_5.setBounds(10, 378, 155, 14);
		contentPane.add(lblNewLabel_5);
		
		stockMin = new JTextField();
		stockMin.setBounds(120, 375, 58, 20);
		contentPane.add(stockMin);
		stockMin.setColumns(10);
		
		JButton crearProducto = new JButton("Crear Producto");
		crearProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod=0;
				int cuit=0;
				float price=0;
				int st=-4;
				int stm=-4;
				int rep=-4;
				try {
					cod=Integer.parseInt(codigo.getText());
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Codigo",JOptionPane.ERROR_MESSAGE);
				}
				try {
					cuit=Integer.parseInt(proveedor.getText());
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Proveedor",JOptionPane.ERROR_MESSAGE);
				}
				try {
					price=Float.parseFloat(precio.getText());
				}
				catch(Exception e4) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros o con decimal","Error Precio",JOptionPane.ERROR_MESSAGE);
				}
				try {
					st=Integer.parseInt(stock.getText());
					}
				catch(Exception e5) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Stock",JOptionPane.ERROR_MESSAGE);
				}
				try {
					stm=Integer.parseInt(stockMin.getText());
					}
				catch(Exception e6) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Stock Minimo",JOptionPane.ERROR_MESSAGE);
				}
				try {
					rep=Integer.parseInt(reposicion.getText());
					}
				catch(Exception e6) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Pedido Reposicion",JOptionPane.ERROR_MESSAGE);
				}

				if(cuit!=0 && cod!=0 && price>-1 && st>-1 && stm>-1 && rep>-1) {//se verifica que se haya parseado correctamente los campos
					proveedorView miProv = Supermercado.getInstancia().buscarProveedorView(cuit);
					if(miProv!=null && miProv.isEliminado()==false) {//se busca que el proveedor exista
						if(Supermercado.getInstancia().buscarProductoView(cod)==null) {//se verifica que el producto no exista
							Supermercado.getInstancia().crearProducto(cod, descripcion.getText(), marca.getText(), cuit, price, st, stm, rep);
							JOptionPane.showMessageDialog(null,"El producto se creo exitosamente","Producto Creado",JOptionPane.INFORMATION_MESSAGE);
							codigo.setText("");
							descripcion.setText("");
							marca.setText("");
							proveedor.setText("");
							precio.setText("");
							stock.setText("");
							stockMin.setText("");	
							reposicion.setText("");
						} else {
							JOptionPane.showMessageDialog(null,"El producto ya existe, no se ha creado ni modificado nada","Producto Existente",JOptionPane.ERROR_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null,"El proveedor ingresado no existe, ingrese un proveedor existente o creelo si es nuevo.","Error Proveedor inexistente",JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null,"Revise los datos ingresados, no puede ingresar numeros negativos.","Error",JOptionPane.ERROR_MESSAGE);

				}
				
			}
				
		});
		crearProducto.setBounds(10, 471, 132, 23);
		contentPane.add(crearProducto);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setBounds(178, 471, 132, 23);
		contentPane.add(cancelar);
		
		JLabel lblNewLabel_6 = new JLabel("Reposicion:");
		lblNewLabel_6.setBounds(10, 434, 137, 14);
		contentPane.add(lblNewLabel_6);
		
		reposicion = new JTextField();
		reposicion.setBounds(120, 431, 58, 20);
		contentPane.add(reposicion);
		reposicion.setColumns(10);
	}
}
