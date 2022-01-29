package Vista;

import java.awt.BorderLayout;
import javax.swing.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.producto;
import Clases.productoView;
import Clases.proveedorView;
import Controlador.Supermercado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class ModificarProducto extends JFrame {

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
	public ModificarProducto() {
		setTitle("Modificar Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 335, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(24, 37, 46, 14);
		contentPane.add(lblNewLabel);
		
		codigo = new JTextField();
		codigo.setBounds(141, 34, 59, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		JButton buscar = new JButton("Buscar");
		JButton modificar = new JButton("Modificar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod=0;
				try {
					cod=Integer.parseInt(codigo.getText());
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Codigo",JOptionPane.ERROR_MESSAGE);
				}
				if(cod!=0) {//se verifica el parseo
					productoView miProd = Supermercado.getInstancia().buscarProductoView(cod);
					if(miProd!=null) {
						descripcion.setText(miProd.getDescripcion());
						marca.setText(miProd.getMarca());
						String prov=String.valueOf(miProd.getProveedor());
						proveedor.setText(prov);
						String price=String.valueOf(miProd.getPrecio());
						precio.setText(price);
						String st=String.valueOf(miProd.getStock());
						stock.setText(st);
						String stm=String.valueOf(miProd.getStockMin());
						stockMin.setText(stm);
						String rep=String.valueOf(miProd.getPedidoReposicion());
						reposicion.setText(rep);
						modificar.setEnabled(true);
						buscar.setEnabled(false);
						codigo.setEnabled(false);
					} else {
						JOptionPane.showMessageDialog(null,"El producto "+codigo.getText()+" no existe","Error al buscar",JOptionPane.ERROR_MESSAGE);
					}
				}
	
			}
		});
		buscar.setBounds(210, 33, 89, 23);
		contentPane.add(buscar);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion:");
		lblNewLabel_1.setBounds(24, 88, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		descripcion = new JTextField();
		descripcion.setBounds(141, 85, 158, 20);
		contentPane.add(descripcion);
		descripcion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Marca:");
		lblNewLabel_2.setBounds(24, 139, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		marca = new JTextField();
		marca.setBounds(141, 136, 158, 20);
		contentPane.add(marca);
		marca.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Proveedor:");
		lblNewLabel_3.setBounds(24, 190, 78, 14);
		contentPane.add(lblNewLabel_3);
		
		proveedor = new JTextField();
		proveedor.setBounds(141, 187, 59, 20);
		contentPane.add(proveedor);
		proveedor.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Precio:");
		lblNewLabel_4.setBounds(24, 241, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		precio = new JTextField();
		precio.setBounds(141, 238, 59, 20);
		contentPane.add(precio);
		precio.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Stock:");
		lblNewLabel_5.setBounds(24, 292, 78, 14);
		contentPane.add(lblNewLabel_5);
		
		stock = new JTextField();
		stock.setBounds(141, 289, 59, 20);
		contentPane.add(stock);
		stock.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Stock Minimo:");
		lblNewLabel_6.setBounds(24, 343, 129, 14);
		contentPane.add(lblNewLabel_6);
		
		stockMin = new JTextField();
		stockMin.setBounds(141, 340, 59, 20);
		contentPane.add(stockMin);
		stockMin.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Pedido Reposicion:");
		lblNewLabel_7.setBounds(24, 394, 129, 14);
		contentPane.add(lblNewLabel_7);
		
		reposicion = new JTextField();
		reposicion.setBounds(141, 391, 59, 20);
		contentPane.add(reposicion);
		reposicion.setColumns(10);
		
		
		modificar.setEnabled(false);
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod=0;
				try {
					cod=Integer.parseInt(codigo.getText());
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Primero debe buscar un producto valido","Error",JOptionPane.ERROR_MESSAGE);
				}
				if(cod!=0) {//se verifica el parseo
					if(Supermercado.getInstancia().buscarProductoView(cod)!=null) {//se verifica que exista el producto
						int prov=0;
						float price=0;
						int st=-4;
						int stm=-4;
						int rep=-4;
						try {
							prov=Integer.parseInt(proveedor.getText());
						}
						catch (Exception ex) {
							JOptionPane.showMessageDialog(null,"Debe ingresar solo numeros enteros","Error Proveedor",JOptionPane.ERROR_MESSAGE);
						}
						proveedorView miProv = Supermercado.getInstancia().buscarProveedorView(prov);
						if(miProv!=null && miProv.isEliminado()==false) {

							try {
								price=Float.parseFloat(precio.getText());
							} 
							catch (Exception e0) {
								JOptionPane.showMessageDialog(null,"Debe ingresar solo numeros enteros o decimales","Error Precio",JOptionPane.ERROR_MESSAGE);
							}
							try {
								st=Integer.parseInt(stock.getText());
							}
							catch (Exception e1) {
								JOptionPane.showMessageDialog(null,"Debe ingresar solo numeros enteros","Error Stock",JOptionPane.ERROR_MESSAGE);
							}
							try {
								stm=Integer.parseInt(stockMin.getText());
							}
							catch (Exception e2) {
								JOptionPane.showMessageDialog(null,"Debe ingresar solo numeros enteros","Error Stock Minimo",JOptionPane.ERROR_MESSAGE);
							}
							try {
								rep=Integer.parseInt(reposicion.getText());
							}
							catch (Exception e3) {
								JOptionPane.showMessageDialog(null,"Debe ingresar solo numeros enteros","Error Pedido Reposicion",JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null,"El proveedor ingresado no existe, ingrese un proveedor existente o creelo si es nuevo.","Error Proveedor inexistente",JOptionPane.ERROR_MESSAGE);

						}
						
						if(price!=0 && st!=-4 && stm!=-4 && rep!=-4) {//se verifica el parseo de los datos ingresados
							productoView prod = Supermercado.getInstancia().buscarProductoView(cod);
							Supermercado.getInstancia().modificarProducto(cod, descripcion.getText(), marca.getText(), prov, price, st, stm, rep,prod.isEliminado());
							JOptionPane.showMessageDialog(null,"El producto se modifico exitosamente","Producto Modificado",JOptionPane.INFORMATION_MESSAGE);
							codigo.setEnabled(true);
							codigo.setText("");
							descripcion.setText("");
							marca.setText("");
							proveedor.setText("");
							precio.setText("");
							stock.setText("");
							stockMin.setText("");
							reposicion.setText("");
							buscar.setEnabled(true);
							modificar.setEnabled(false);
						}
					} else {
						JOptionPane.showMessageDialog(null,"Primero debe buscar un producto valido","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		modificar.setBounds(24, 437, 89, 23);
		contentPane.add(modificar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		cancelar.setBounds(210, 437, 89, 23);
		contentPane.add(cancelar);
		
		

	}
}
