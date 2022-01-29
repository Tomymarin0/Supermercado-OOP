package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.producto;
import Clases.productoView;
import Controlador.Supermercado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaProducto extends JFrame {

	private JPanel contentPane;
	private JTextField codigo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public BajaProducto() {
		setTitle("Eliminar Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 278, 85);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(21, 14, 46, 14);
		contentPane.add(lblNewLabel);
		
		codigo = new JTextField();
		codigo.setBounds(77, 11, 65, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		JButton eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod=0;
				try {
					cod=Integer.parseInt(codigo.getText());
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Codigo",JOptionPane.ERROR_MESSAGE);
				}
				if(cod!=0) {//se verifica que se haya parseado correctamente
					productoView miProd = Supermercado.getInstancia().buscarProductoView(cod);
					if(miProd!=null) {//se verifica que el producto buscado exsita
						if(miProd.isTieneVentas()==true) {//se verifica si tiene ventas para saber si se hace una baja logica o fisica
							Supermercado.getInstancia().eliminarProducto(cod);
							JOptionPane.showMessageDialog(null,"Como el producto tenia ventas asociadas, se ha realizado una baja logica","Producto Eliminado",JOptionPane.INFORMATION_MESSAGE);
						} else {
							Supermercado.getInstancia().bajaFisicaProducto(cod);
							JOptionPane.showMessageDialog(null,"Como el producto no tenia ventas asociadas, se ha realizado una baja fisica del sistema","Producto Eliminado",JOptionPane.INFORMATION_MESSAGE);
						} 
					
						} else {
							JOptionPane.showMessageDialog(null,"El producto buscado no existe, ingrese uno valido","Producto inexistente",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		eliminar.setBounds(152, 10, 89, 23);
		contentPane.add(eliminar);
	}

}
