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

public class ModificarProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField buscado;
	private JTextField razonSocial;
	private JTextField domicilio;
	private JTextField telefono;
	private JTextField mail;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ModificarProveedor() {
		setTitle("Modificar Proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 290, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUIT:");
		lblNewLabel.setBounds(10, 28, 46, 14);
		contentPane.add(lblNewLabel);
		
		buscado = new JTextField();
		buscado.setBounds(100, 25, 54, 20);
		contentPane.add(buscado);
		buscado.setColumns(10);
		
		JButton buscar = new JButton("Buscar");
		JButton modificar = new JButton("Modificar");
		modificar.setEnabled(false);
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod=0;
				try {
					cod=Integer.parseInt(buscado.getText());
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error en CUIT",JOptionPane.ERROR_MESSAGE);
				}
				if (cod!=0) {
					proveedorView miProveedor=Supermercado.getInstancia().buscarProveedorView(cod);
					if (miProveedor!=null) {
						razonSocial.setText(miProveedor.getRazonSocial());
						domicilio.setText(miProveedor.getDomicilio());
						String tel= String.valueOf(miProveedor.getTelefono());
						telefono.setText(tel);
						mail.setText(miProveedor.getMail());
						buscado.setEnabled(false);
						buscar.setEnabled(false);
						modificar.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null,"El proveedor "+buscado.getText()+" buscado no existe o fue eliminado","Error al buscar",JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		buscar.setBounds(171, 24, 89, 23);
		contentPane.add(buscar);
		
		JLabel lblNewLabel_1 = new JLabel("Razon Social:");
		lblNewLabel_1.setBounds(10, 106, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		razonSocial = new JTextField();
		razonSocial.setBounds(100, 103, 160, 20);
		contentPane.add(razonSocial);
		razonSocial.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Domicilio:");
		lblNewLabel_2.setBounds(10, 184, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		domicilio = new JTextField();
		domicilio.setBounds(100, 181, 160, 20);
		contentPane.add(domicilio);
		domicilio.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono:");
		lblNewLabel_3.setBounds(10, 262, 72, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mail:");
		lblNewLabel_4.setBounds(10, 340, 72, 14);
		contentPane.add(lblNewLabel_4);
		
		telefono = new JTextField();
		telefono.setBounds(100, 259, 160, 20);
		contentPane.add(telefono);
		telefono.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(100, 337, 160, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod=0;
				try {
					cod=Integer.parseInt(buscado.getText());
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Primero debe buscar un proveedor valido","Error",JOptionPane.ERROR_MESSAGE);
				}
				if(cod!=0) {//se verifica el parseo
					proveedorView miProveedor = Supermercado.getInstancia().buscarProveedorView(cod);
					if(miProveedor!=null) {//se verifica que exista el proveedor
						int tel=0;
						try {
							tel=Integer.parseInt(telefono.getText());
						} catch (Exception e2){
							JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error en Telefono",JOptionPane.ERROR_MESSAGE);
						}
						if(tel!=0) {//se verifica el parseo
							Supermercado.getInstancia().modificarProveedor(cod, razonSocial.getText(), domicilio.getText(), tel, mail.getText());
							JOptionPane.showMessageDialog(null,"El proveedor se modifico exitosamente","Proveedor Modificado",JOptionPane.INFORMATION_MESSAGE);
							buscado.setEnabled(true);
							razonSocial.setText("");
							domicilio.setText("");
							telefono.setText("");
							mail.setText("");
							buscar.setEnabled(true);
							modificar.setEnabled(false);
						}
					}
				}
				
			}
		});
		modificar.setBounds(10, 385, 89, 23);
		contentPane.add(modificar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setBounds(171, 385, 89, 23);
		contentPane.add(cancelar);
	}
}
