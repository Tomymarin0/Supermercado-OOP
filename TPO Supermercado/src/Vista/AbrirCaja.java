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
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class AbrirCaja extends JFrame {

	private JPanel contentPane;
	private JTextField caja;
	private JTextField dia;
	private JTextField mes;
	private JTextField ano;
	private JTextField cajero;
	private JTextField saldoInicial;
	//private JButton buscarcajero;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AbrirCaja() {
		setTitle("Abrir Caja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel awefw = new JLabel("Nro Caja:");
		awefw.setBounds(10, 31, 60, 14);
		contentPane.add(awefw);
		
		caja = new JTextField();
		caja.setBounds(90, 28, 86, 20);
		contentPane.add(caja);
		caja.setColumns(10);
		
		JButton buscar = new JButton("Buscar");
		JButton buscarcajero = new JButton("Buscar");
		JButton abrir = new JButton("Abrir Caja");
		buscarcajero.setEnabled(false);
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se busca que la caja exista
				int caj=0;
				try {
					caj=Integer.parseInt(caja.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Caja",JOptionPane.ERROR_MESSAGE);
				}
				if(caj!=0) {
					cajaView miCaja = Supermercado.getInstancia().buscarCajaView(caj);
					if(miCaja!=null) {//si existe la caja se deshabilita la opcion para que no pueda ser cambiada durante el proceso
						JOptionPane.showMessageDialog(null,"Se ha encontrado la caja buscada","Caja Encontrada",JOptionPane.INFORMATION_MESSAGE);
							cajero.setEnabled(true);
							caja.setEnabled(false);
							buscarcajero.setEnabled(true);
							buscar.setEnabled(false);
					} else { //se informa que no existe
						JOptionPane.showMessageDialog(null,"La caja buscada no existe","Caja Inexistente",JOptionPane.ERROR_MESSAGE);
					}
					
				}				
			}
		});
		buscar.setBounds(195, 27, 89, 23);
		contentPane.add(buscar);
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setBounds(10, 121, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dia:");
		lblNewLabel_1.setBounds(66, 121, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		dia = new JTextField();
		dia.setEnabled(false);
		dia.setBounds(101, 118, 46, 20);
		contentPane.add(dia);
		dia.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mes:");
		lblNewLabel_2.setBounds(157, 121, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		mes = new JTextField();
		mes.setEnabled(false);
		mes.setColumns(10);
		mes.setBounds(195, 118, 46, 20);
		contentPane.add(mes);
		
		JLabel lblNewLabel_3 = new JLabel("Año:");
		lblNewLabel_3.setBounds(248, 121, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		ano = new JTextField();
		ano.setEnabled(false);
		ano.setColumns(10);
		ano.setBounds(283, 118, 46, 20);
		contentPane.add(ano);
		
		JLabel lblNewLabel_4 = new JLabel("Cajero:");
		lblNewLabel_4.setBounds(10, 76, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		cajero = new JTextField();
		cajero.setEnabled(false);
		cajero.setBounds(90, 73, 86, 20);
		contentPane.add(cajero);
		cajero.setColumns(10);
		
		
		buscarcajero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se busca al cajero
				if(Supermercado.getInstancia().buscarCajero(cajero.getText())) {//si existe de deshabilita la opcion para que no sea modificada durante el proceso
					JOptionPane.showMessageDialog(null,"Se ha encontrado al cajero buscado","Cajero Encontrado",JOptionPane.INFORMATION_MESSAGE);
					dia.setEnabled(true);
					mes.setEnabled(true);
					ano.setEnabled(true);
					saldoInicial.setEnabled(true);
					cajero.setEnabled(false);
					buscarcajero.setEnabled(false);
					abrir.setEnabled(true);
				} else {//si no existe se notifica
					JOptionPane.showMessageDialog(null,"El cajero buscado no existe","Cajero Inexistente",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buscarcajero.setBounds(195, 72, 89, 23);
		contentPane.add(buscarcajero);
		
		JLabel lblNewLabel_5 = new JLabel("Saldo Inicial:");
		lblNewLabel_5.setBounds(10, 166, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		saldoInicial = new JTextField();
		saldoInicial.setEnabled(false);
		saldoInicial.setBounds(90, 163, 100, 20);
		contentPane.add(saldoInicial);
		saldoInicial.setColumns(10);
		
		
		abrir.setEnabled(false);
		abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se confirman los datos y se intenta abrir la caja
				int day1=0;
				int month1=0;
				int year1=0;
				float saldoIn=-1;
				int caj=0;
				LocalDate fecha = LocalDate.of(1, 1, 1);
				try {
					caj=Integer.parseInt(caja.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Caja",JOptionPane.ERROR_MESSAGE);
				}
				try {
					day1=Integer.parseInt(dia.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Dia",JOptionPane.ERROR_MESSAGE);
				}
				try {
					month1=Integer.parseInt(mes.getText());
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Mes",JOptionPane.ERROR_MESSAGE);
				}
				try {
					year1=Integer.parseInt(ano.getText());
				} catch (Exception e4) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Año",JOptionPane.ERROR_MESSAGE);
				}
				try {
					saldoIn=Float.parseFloat(saldoInicial.getText());
				} catch (Exception e5) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros o con decimales","Error Saldo Inicial",JOptionPane.ERROR_MESSAGE);
				}
				try {
					fecha = LocalDate.of(year1, month1, day1);
				} catch (Exception e6) {
					JOptionPane.showMessageDialog(null,"Ingrese una fecha valida","Fecha Invalida",JOptionPane.ERROR_MESSAGE);
				}
				LocalDate aux = LocalDate.of(1,1,1);
				if(saldoIn!=-1 && fecha.isAfter(aux) && Supermercado.getInstancia().buscarCajero(cajero.getText()) && Supermercado.getInstancia().buscarCajaView(caj)!=null) {//se verifica que todo se haya parseado bien
					if(Supermercado.getInstancia().abrirCaja(fecha, caj, cajero.getText(), saldoIn)) {//se verifica que la caja no este abierta, si no fue abierta, se entra aca
						JOptionPane.showMessageDialog(null,"La caja se abrio exitosamente","Caja abierta",JOptionPane.INFORMATION_MESSAGE);
						caja.setText("");
						cajero.setText("");
						dia.setText("");
						mes.setText("");
						ano.setText("");
						saldoInicial.setText("");
						cajero.setEnabled(false);
						dia.setEnabled(false);
						mes.setEnabled(false);
						ano.setEnabled(false);
						saldoInicial.setEnabled(false);
						caja.setEnabled(true);
						buscar.setEnabled(true);
						buscarcajero.setEnabled(false);
						abrir.setEnabled(false);
					} else {//la caja ya fue abierta en esa fecha
						JOptionPane.showMessageDialog(null,"La caja ya esta abierta","Error Caja",JOptionPane.ERROR_MESSAGE);
					}
					
				} else {
					//JOptionPane.showMessageDialog(null,"Verifique no haber modificado nada antes de intentar abrir la caja","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		abrir.setBounds(90, 202, 100, 23);
		contentPane.add(abrir);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setBounds(200, 202, 100, 23);
		contentPane.add(cancelar);
	}
}
