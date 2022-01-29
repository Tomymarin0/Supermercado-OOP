package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.proveedor;
import Clases.proveedorView;
import Controlador.Supermercado;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField cuit;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public BajaProveedor() {
		setTitle("Baja Proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 283, 90);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUIT:");
		lblNewLabel.setBounds(23, 21, 52, 14);
		contentPane.add(lblNewLabel);
		
		cuit = new JTextField();
		cuit.setBounds(73, 18, 67, 20);
		contentPane.add(cuit);
		cuit.setColumns(10);
		
		JButton buscar = new JButton("Eliminar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod=0;
				try {
					cod=Integer.parseInt(cuit.getText());
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error en CUIT",JOptionPane.ERROR_MESSAGE);
				}
				if (cod!=0) {//se verifica que todo se haya parseado correctamente
					proveedorView miProveedor=Supermercado.getInstancia().buscarProveedorView(cod);
					if (miProveedor!=null) {//se verifica que el proveedor exista
						if(miProveedor.isTieneProductos()) {//se verifica si tiene productos para saber si hacer baja logica o fisica
							Supermercado.getInstancia().eliminarProveedor(cod);
							JOptionPane.showMessageDialog(null,"Como el proveedor tenia productos asociados, se ha realizado una baja logica","Proveedor Eliminado",JOptionPane.INFORMATION_MESSAGE);
						} else {
							Supermercado.getInstancia().bajaFisicaProveedor(cod);
							JOptionPane.showMessageDialog(null,"Como el proveedor no tenia productos asociados, se ha realizado una baja fisica del sistema","Proveedor Eliminado",JOptionPane.INFORMATION_MESSAGE);
						}
						
					} else {
						JOptionPane.showMessageDialog(null,"El proveedor buscado no existe, ingrese uno valido","Proveedor inexistente",JOptionPane.ERROR_MESSAGE);
					}
				}
					
			}
		});
		buscar.setBounds(150, 17, 89, 23);
		contentPane.add(buscar);
	}

}
