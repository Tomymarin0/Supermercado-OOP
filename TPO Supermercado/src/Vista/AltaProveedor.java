package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Supermercado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField cuit;
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
	public AltaProveedor() {
		setTitle("Crear Proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//para que vuelva a la ventana de origen se usa dispose on close
		setBounds(100, 100, 323, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUIT:");
		lblNewLabel.setBounds(10, 46, 88, 29);
		contentPane.add(lblNewLabel);
		
		cuit = new JTextField();
		cuit.setBounds(87, 50, 59, 20);
		contentPane.add(cuit);
		cuit.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Razon Social:");
		lblNewLabel_1.setBounds(10, 121, 88, 29);
		contentPane.add(lblNewLabel_1);
		
		razonSocial = new JTextField();
		razonSocial.setBounds(87, 125, 206, 20);
		contentPane.add(razonSocial);
		razonSocial.setColumns(10);
		
		JLabel ergserg = new JLabel("Domicilio:");
		ergserg.setBounds(10, 196, 88, 29);
		contentPane.add(ergserg);
		
		domicilio = new JTextField();
		domicilio.setBounds(87, 200, 206, 20);
		contentPane.add(domicilio);
		domicilio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono:");
		lblNewLabel_2.setBounds(10, 271, 88, 29);
		contentPane.add(lblNewLabel_2);
		
		telefono = new JTextField();
		telefono.setBounds(87, 275, 206, 20);
		contentPane.add(telefono);
		telefono.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mail:");
		lblNewLabel_3.setBounds(10, 346, 88, 29);
		contentPane.add(lblNewLabel_3);
		
		mail = new JTextField();
		mail.setBounds(87, 350, 206, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JButton CrearProveedor = new JButton("Crear Proveedor");
		CrearProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cuando se haga un click en crear contacto
				int c=0;
				int tel=0;
				try {
					c=Integer.parseInt(cuit.getText());
				} catch (Exception ex){
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error en CUIT",JOptionPane.ERROR_MESSAGE);
				}
				try {
					tel=Integer.parseInt(telefono.getText());
				} catch (Exception e2){
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error en Telefono",JOptionPane.ERROR_MESSAGE);
				}
				if (c!=0 && tel!=0) {//se verifica que todo este correctamente parseado
					if(Supermercado.getInstancia().buscarProveedorView(c)==null) {//se verifica que el proveedor no exista
						Supermercado.getInstancia().crearProveedor(c, razonSocial.getText(), domicilio.getText(), tel, mail.getText());
						JOptionPane.showMessageDialog(null,"El proveedor se creo exitosamente","Proveedor Creado",JOptionPane.INFORMATION_MESSAGE);
						cuit.setText("");
						razonSocial.setText("");
						domicilio.setText("");
						telefono.setText("");
						mail.setText("");
						
					} else {
						JOptionPane.showMessageDialog(null,"El proveedor ya existe, no se ha creado ni modificado nada","Proveedor Existente",JOptionPane.ERROR_MESSAGE);
					}

				}
				
			}
		});
		CrearProveedor.setBounds(10, 405, 129, 23);
		contentPane.add(CrearProveedor);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setBounds(164, 405, 129, 23);
		contentPane.add(cancelar);
		
	}

}
