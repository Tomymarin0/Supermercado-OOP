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

public class AgregarCajero extends JFrame {

	private JPanel contentPane;
	private JTextField cajero;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AgregarCajero() {
		setTitle("Agregar Cajero");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 474, 76);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 11, 68, 14);
		contentPane.add(lblNewLabel);
		
		cajero = new JTextField();

		cajero.setBounds(74, 8, 275, 20);
		contentPane.add(cajero);
		cajero.setColumns(10);
		
		JButton agregar = new JButton("Agregar");
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cajero.getText().equalsIgnoreCase("")!=true) {
					Supermercado.getInstancia().agregarCajero(cajero.getText());
					JOptionPane.showMessageDialog(null,"El cajero se agrego a la lista existosamente","Cajero Agregado",JOptionPane.INFORMATION_MESSAGE);
					cajero.setText("");	
				} else {
					JOptionPane.showMessageDialog(null,"No puede dejar el campo vacio, ingrese un nombre","Error Cajero",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		agregar.setBounds(359, 7, 89, 23);
		contentPane.add(agregar);
		
	}
}
