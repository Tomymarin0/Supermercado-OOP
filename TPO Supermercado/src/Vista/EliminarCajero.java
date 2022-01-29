package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlador.Supermercado;

public class EliminarCajero extends JFrame {

	private JPanel contentPane;
	private JTextField cajero;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public EliminarCajero() {
		setTitle("Eliminar Cajero");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 474, 105);
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
		
		JButton agregar = new JButton("Buscar");
		JButton eliminar = new JButton("Eliminar");
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Supermercado.getInstancia().buscarCajero(cajero.getText())) {//se busca al cajero, si existe lo elimina
					JOptionPane.showMessageDialog(null,"Se ha encontrado al cajero buscado","Cajero Encontrado",JOptionPane.INFORMATION_MESSAGE);
					cajero.setEnabled(false);
					agregar.setEnabled(false);
					eliminar.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null,"El cajero buscado no existe","Cajero Inexistente",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		agregar.setBounds(359, 7, 89, 23);
		contentPane.add(agregar);
		
		
		eliminar.setEnabled(false);
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supermercado.getInstancia().eliminarCajero(cajero.getText());//confirmado el cajero se lo elimina
				JOptionPane.showMessageDialog(null,"Se ha eliminado al cajero exitosamente","Cajero Eliminado",JOptionPane.INFORMATION_MESSAGE);
				cajero.setEnabled(true);
				cajero.setText("");
				agregar.setEnabled(true);
				eliminar.setEnabled(false);
			}
		});
		eliminar.setBounds(359, 35, 89, 23);
		contentPane.add(eliminar);
		
	}

}
