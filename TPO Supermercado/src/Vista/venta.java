package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.cajaView;
import Clases.productoView;
import Controlador.Supermercado;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class venta extends JFrame {

	private JPanel contentPane;
	private JTextField caja;
	private JTextField producto;
	private JTextField cantidad;
	private Clases.venta newVenta;
	private JTextField total;
	private JTextField vuelto;
	private JTextField recibido;


	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public venta() {

		setTitle("Iniciar Venta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero de Caja:");
		lblNewLabel.setBounds(24, 11, 106, 14);
		contentPane.add(lblNewLabel);
		
		caja = new JTextField();
		caja.setBounds(134, 8, 86, 20);
		contentPane.add(caja);
		caja.setColumns(10);
		
		JButton buscarCaja = new JButton("Buscar");
		JButton finalizarVenta = new JButton("Finalizar Venta");
		JButton calcularVuelto = new JButton("Calcular");
		JButton finalizar = new JButton("Cerrar Carrito");
		JButton agregar = new JButton("Agregar");
		JButton buscarProducto = new JButton("Buscar");
		
		buscarCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se busca la caja
				int cod=0;
				try {
					cod=Integer.parseInt(caja.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Caja",JOptionPane.ERROR_MESSAGE);
				}
				if(cod!=0) {//se verifica el parseo
					cajaView miCaja = Supermercado.getInstancia().buscarCajaView(cod);
					if(miCaja!=null) {//se verifica que la caja existe
						if(miCaja.isEstado()) {//se verifica que la caja este abierta
							JOptionPane.showMessageDialog(null,"Se ha encontrado la caja buscada","Caja Encontrada",JOptionPane.INFORMATION_MESSAGE);
							newVenta = Supermercado.getInstancia().iniciarVenta(cod);
							caja.setEnabled(false);
							producto.setEnabled(true);
							buscarProducto.setEnabled(true);
							buscarCaja.setEnabled(false);
						} else {
							JOptionPane.showMessageDialog(null,"La caja esta cerrada, para iniciar una venta debe estar abierta","Error Caja",JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,"La caja buscada no existe","Error Caja",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		buscarCaja.setBounds(230, 7, 89, 23);
		contentPane.add(buscarCaja);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar Producto:");
		lblNewLabel_1.setBounds(24, 55, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		producto = new JTextField();
		producto.setEnabled(false);
		producto.setBounds(134, 52, 86, 20);
		contentPane.add(producto);
		producto.setColumns(10);
		
		
		buscarProducto.setEnabled(false);
		buscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod=0;
				try {
					cod=Integer.parseInt(producto.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Producto",JOptionPane.ERROR_MESSAGE);
				}
				if(cod!=0) {//se verifica el parseo
					productoView miProd = Supermercado.getInstancia().buscarProductoView(cod);
					if(miProd!=null) {//se verifica que el producto exista
						if(miProd.isEliminado()==false) {//se verifica que el producto no este eliminado
							JOptionPane.showMessageDialog(null,"Se ha encontrado el producto buscado","Producto Encontrado",JOptionPane.INFORMATION_MESSAGE);
							producto.setEnabled(false);
							cantidad.setEnabled(true);
							buscarProducto.setEnabled(false);
							agregar.setEnabled(true);
						} else {
							JOptionPane.showMessageDialog(null,"El producto buscado esta eliminado","Error Producto",JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,"El producto buscado no existe","Error Producto",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		buscarProducto.setBounds(230, 51, 89, 23);
		contentPane.add(buscarProducto);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setBounds(24, 99, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		cantidad = new JTextField();
		cantidad.setEnabled(false);
		cantidad.setBounds(134, 96, 86, 20);
		contentPane.add(cantidad);
		cantidad.setColumns(10);
		
		
		agregar.setEnabled(false);
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cant=0;
				try {
					cant=Integer.parseInt(cantidad.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Cantidad",JOptionPane.ERROR_MESSAGE);
				}
				int cod=Integer.parseInt(producto.getText());
				if(cant!=0 && cant>0) {// se verifica parseo y que la cantidad ingresada no sea negativa
					Supermercado.getInstancia().agregarItems(newVenta, cod, cant);
					JOptionPane.showMessageDialog(null,"Se ha agregado el producto existosamente","Producto Agregado",JOptionPane.INFORMATION_MESSAGE);
					producto.setText("");
					cantidad.setText("");
					producto.setEnabled(true);
					cantidad.setEnabled(true);
					agregar.setEnabled(false);
					buscarProducto.setEnabled(true);
					finalizar.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros mayores a 0","Error Cantidad",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		agregar.setBounds(230, 95, 89, 23);
		contentPane.add(agregar);
		
		
		finalizar.setEnabled(false);
		finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se cierra el carrito
				newVenta.calcularTotal();
				JOptionPane.showMessageDialog(null,"Se ha cerrado el carrito","Carrito Cerrada",JOptionPane.INFORMATION_MESSAGE);
				String tot = String.valueOf(newVenta.getValorVenta());
				total.setText(tot);
				producto.setText("");
				cantidad.setText("");
				producto.setEnabled(false);
				cantidad.setEnabled(false);
				recibido.setEnabled(true);
				buscarProducto.setEnabled(false);
				agregar.setEnabled(false);
				finalizar.setEnabled(false);
				calcularVuelto.setEnabled(true);
			}
		});
		finalizar.setBounds(103, 137, 117, 23);
		contentPane.add(finalizar);
		
		JLabel lblNewLabel_3 = new JLabel("Total:");
		lblNewLabel_3.setBounds(24, 188, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		total = new JTextField();
		total.setEnabled(false);
		total.setBounds(134, 185, 86, 20);
		contentPane.add(total);
		total.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Vuelto:");
		lblNewLabel_4.setBounds(24, 264, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		vuelto = new JTextField();
		vuelto.setEnabled(false);
		vuelto.setBounds(134, 261, 86, 20);
		contentPane.add(vuelto);
		vuelto.setColumns(10);
		
		
		calcularVuelto.setEnabled(false);
		calcularVuelto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float pago = 0;
				try {
					pago=Float.parseFloat(recibido.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros o con decimales","Error Monto Recibido",JOptionPane.ERROR_MESSAGE);
				}
				if(pago!=0 && pago>=newVenta.getValorVenta()) {//se verifica parseo y que el monto recibido no sea menor que el total de la venta
					newVenta.calcularVuelto(pago, newVenta.getValorVenta());
					String vuel = String.valueOf(newVenta.getVuelto());
					vuelto.setText(vuel);
					recibido.setEnabled(false);
					finalizarVenta.setEnabled(true);
					calcularVuelto.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null,"El monto recibido no puede ser menor al total","Error Monto Recibido",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		calcularVuelto.setBounds(230, 260, 89, 23);
		contentPane.add(calcularVuelto);
		
		JLabel lblNewLabel_5 = new JLabel("Monto Recibido:");
		lblNewLabel_5.setBounds(24, 226, 106, 14);
		contentPane.add(lblNewLabel_5);
		
		recibido = new JTextField();
		recibido.setEnabled(false);
		recibido.setBounds(134, 223, 86, 20);
		contentPane.add(recibido);
		recibido.setColumns(10);
		
		
		finalizarVenta.setEnabled(false);
		finalizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se finaliza la venta totalmente, la registra y se actualiza el stock
				Supermercado.getInstancia().finalizarVenta(newVenta);
				JOptionPane.showMessageDialog(null,"Se ha cerrado la venta, registrado y actualizado el stock","Venta Finalizada",JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		finalizarVenta.setBounds(24, 303, 117, 23);
		contentPane.add(finalizarVenta);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setBounds(202, 303, 117, 23);
		contentPane.add(cancelar);
	}
}
