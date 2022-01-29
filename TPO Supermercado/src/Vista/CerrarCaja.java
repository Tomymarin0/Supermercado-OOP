package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.cajaView;
import Controlador.Supermercado;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CerrarCaja extends JFrame {

	private JPanel contentPane;
	private JTextField caja;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public CerrarCaja() {
		setTitle("Cerrar Caja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 295, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Caja:");
		lblNewLabel.setBounds(20, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel status = new JLabel("");
		status.setBounds(72, 50, 86, 14);
		contentPane.add(status);
		
		caja = new JTextField();
		caja.setBounds(72, 8, 86, 20);
		contentPane.add(caja);
		caja.setColumns(10);
		
		JButton buscar = new JButton("Buscar");
		JButton cerrar = new JButton("Cerrar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int caj=0;
				try {
					caj=Integer.parseInt(caja.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Caja",JOptionPane.ERROR_MESSAGE);
				}
				if(caj!=0) {//se verifica que se haya parseado correctamente
					cajaView caja = Supermercado.getInstancia().buscarCajaView(caj);
					if(caja!=null) {//se verifica que la caja exista
						if(caja.isEstado()) {//se verifica si esta abierta
							status.setText("Abierta");
							cerrar.setEnabled(true);
							buscar.setEnabled(false);
						} else {
							status.setText("Cerrada");
						}
					} else {
						JOptionPane.showMessageDialog(null,"La caja buscada no existe","Error Caja",JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		buscar.setBounds(168, 7, 89, 23);
		contentPane.add(buscar);
		
		JLabel lblNewLabel_1 = new JLabel("Estado:");
		lblNewLabel_1.setBounds(20, 50, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		
		cerrar.setEnabled(false);
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int caj=0;
				try {
					caj=Integer.parseInt(caja.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Caja",JOptionPane.ERROR_MESSAGE);
				}
				if(caj!=0 && Supermercado.getInstancia().buscarCajaView(caj)!=null) {//se verifca que se haya parseado y que la caja exista
					if(Supermercado.getInstancia().cerrarCaja(caj)) {//se cierra la caja
						JOptionPane.showMessageDialog(null,"Se cerro la caja existosamente","Caja Cerrada",JOptionPane.INFORMATION_MESSAGE);
						caja.setText("");
						status.setText("");
						buscar.setEnabled(true);
						cerrar.setEnabled(false);
					} else {//si ya estaba cerrada
						JOptionPane.showMessageDialog(null,"La caja ya estaba cerrada","Error Caja Cerrada",JOptionPane.ERROR_MESSAGE);
						caja.setText("");
						status.setText("");
						buscar.setEnabled(true);
						cerrar.setEnabled(false);
					}
				} else {
					JOptionPane.showMessageDialog(null,"La caja no existe, ingrese una caja valida","Error Caja",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cerrar.setBounds(30, 75, 89, 23);
		contentPane.add(cerrar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setBounds(168, 75, 89, 23);
		contentPane.add(cancelar);
		

	}

}
