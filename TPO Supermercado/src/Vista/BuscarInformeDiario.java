package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Clases.informeVentas;
import Controlador.Supermercado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.ScrollPane;

public class BuscarInformeDiario extends JFrame {

	private JPanel contentPane;
	private JTextField numero;
	private JTextField dia;
	private JTextField mes;
	private JTextField ano;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField cajero;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public BuscarInformeDiario() {
		setTitle("Buscar Informe Diario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Caja:");
		lblNewLabel.setBounds(21, 11, 59, 14);
		contentPane.add(lblNewLabel);
		
		numero = new JTextField();
		numero.setBounds(65, 8, 86, 20);
		contentPane.add(numero);
		numero.setColumns(10);
		
		JButton caja = new JButton("Buscar");
		JButton buscarCajero = new JButton("Buscar");
		JButton confirmarFecha = new JButton("Confirmar Fecha");
		confirmarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se confirma la fecha ingresada
				int d=0;
				int m=0;
				int a=0;
				LocalDate fecha = LocalDate.of(1, 1, 1);
				try {
					d=Integer.parseInt(dia.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Dia",JOptionPane.ERROR_MESSAGE);
				}
				try {
					m=Integer.parseInt(mes.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Mes",JOptionPane.ERROR_MESSAGE);
				}
				try {
					a=Integer.parseInt(ano.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Año",JOptionPane.ERROR_MESSAGE);
				}
				try {
					fecha = LocalDate.of(a, m, d);
				} catch (Exception e6) {
					JOptionPane.showMessageDialog(null,"Ingrese una fecha valida","Fecha Invalida",JOptionPane.ERROR_MESSAGE);
				}
				LocalDate aux = LocalDate.of(1,1,1);
				if(fecha.isAfter(aux)) {//se verifica que se haya parseado correctamente
					dia.setEnabled(false);
					mes.setEnabled(false);
					ano.setEnabled(false);
					confirmarFecha.setEnabled(false);
					JOptionPane.showMessageDialog(null,"La fecha ingresada es valida","Fecha Correcta",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"Ingrese una fecha valida","Error Fecha",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		caja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se busca la caja
				int cod=-999;
				try {
					cod=Integer.parseInt(numero.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Caja",JOptionPane.ERROR_MESSAGE);
				}
				if(cod!=-999) {//se verifica que este correctamente parseado
					if(Supermercado.getInstancia().buscarCajaView(cod)!=null) {//se verifica que la caja exista
						JOptionPane.showMessageDialog(null,"Se encontro la caja buscada","Caja Encontrada",JOptionPane.INFORMATION_MESSAGE);
						caja.setEnabled(false);
						numero.setEnabled(false);
					} else {
						JOptionPane.showMessageDialog(null,"La caja buscada no existe","Error Caja",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		caja.setBounds(170, 7, 89, 23);
		contentPane.add(caja);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha:");
		lblNewLabel_1.setBounds(21, 60, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dia:");
		lblNewLabel_2.setBounds(65, 60, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		dia = new JTextField();
		dia.setBounds(97, 57, 32, 20);
		contentPane.add(dia);
		dia.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mes:");
		lblNewLabel_3.setBounds(139, 60, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		mes = new JTextField();
		mes.setColumns(10);
		mes.setBounds(176, 57, 32, 20);
		contentPane.add(mes);
		
		JLabel lblNewLabel_4 = new JLabel("Año:");
		lblNewLabel_4.setBounds(218, 60, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		ano = new JTextField();
		ano.setColumns(10);
		ano.setBounds(252, 57, 52, 20);
		contentPane.add(ano);
		confirmarFecha.setBounds(314, 56, 141, 23);
		contentPane.add(confirmarFecha);
		
		JLabel lblNewLabel_5 = new JLabel("Cajero:");
		lblNewLabel_5.setBounds(21, 106, 59, 14);
		contentPane.add(lblNewLabel_5);
		
		cajero = new JTextField();
		cajero.setBounds(65, 103, 86, 20);
		contentPane.add(cajero);
		cajero.setColumns(10);
		
		
		buscarCajero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se busca el cajero
				boolean aux = Supermercado.getInstancia().buscarCajero(cajero.getText());
				if(aux==true) {//se verifica que exista el cajero
					JOptionPane.showMessageDialog(null,"Se encontro el cajero buscado","Cajero Encontrado",JOptionPane.INFORMATION_MESSAGE);
					cajero.setEnabled(false);
					buscarCajero.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null,"El cajero buscado no existe","Error Cajero",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buscarCajero.setBounds(170, 102, 89, 23);
		contentPane.add(buscarCajero);
		
		JButton buscarInformes = new JButton("Buscar Informes");
		buscarInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se busca los informes con los filtros solicitados
				boolean estado=false;
				if(numero.isEnabled()==false && cajero.isEnabled()==false && dia.isEnabled()==false) {//caja fecha cajero
					int cod = Integer.parseInt(numero.getText());
					int d = Integer.parseInt(dia.getText());
					int m = Integer.parseInt(mes.getText());
					int a = Integer.parseInt(ano.getText());
					LocalDate fecha = LocalDate.of(a,m,d);
					estado=true;
					Vector<Vector<String>> aux = Supermercado.getInstancia().getInformeNumeroFechaCajero(cod, fecha, cajero.getText());
					if(aux!=null) {//se verifica que se hayan encontrado informes
						tablaInformesDiarios miVentana = new tablaInformesDiarios(aux);
						miVentana.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron informes diarios en esa caja","Error Informe",JOptionPane.ERROR_MESSAGE);
					}
				}
				if(numero.isEnabled()==false && cajero.isEnabled()==false && estado!=true) {//caja cajero
					int cod = Integer.parseInt(numero.getText());
					estado=true;
					Vector<Vector<String>> aux = Supermercado.getInstancia().getInformeNumeroCajero(cod, cajero.getText());
					if(aux!=null) {//se vericica que se hayan encontrado informes
						tablaInformesDiarios miVentana = new tablaInformesDiarios(aux);
						miVentana.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron informes diarios en esa caja","Error Informe",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				if(numero.isEnabled()==false && dia.isEnabled()==false && estado!=true) {//caja fecha 
					int cod = Integer.parseInt(numero.getText());
					int d = Integer.parseInt(dia.getText());
					int m = Integer.parseInt(mes.getText());
					int a = Integer.parseInt(ano.getText());
					LocalDate fecha = LocalDate.of(a,m,d);
					estado=true;
					Vector<Vector<String>> aux = Supermercado.getInstancia().getInformeNumeroFecha(cod, fecha);
					if(aux!=null) {//se verifica que se hayan encontrado informes
						tablaInformesDiarios miVentana = new tablaInformesDiarios(aux);
						miVentana.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron informes diarios en esa caja","Error Informe",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				if(cajero.isEnabled()==false && dia.isEnabled()==false && estado!=true) {//cajero dia
					int d = Integer.parseInt(dia.getText());
					int m = Integer.parseInt(mes.getText());
					int a = Integer.parseInt(ano.getText());
					estado=true;
					LocalDate fecha = LocalDate.of(a,m,d);
					Vector<Vector<String>> aux = Supermercado.getInstancia().getInformeCajeroFecha(cajero.getText(), fecha);
					if(aux!=null) {//se verifica que se hayan encontrado informes
						tablaInformesDiarios miVentana = new tablaInformesDiarios(aux);
						miVentana.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron informes diarios en esa caja","Error Informe",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				if(numero.isEnabled()==true && dia.isEnabled()==true && cajero.isEnabled()==true && estado!=true) {//filtros vacios, devuelve todos los informes existentes
					Vector<Vector<String>> aux = Supermercado.getInstancia().getTodosLosInformes();
					estado=true;
					if(aux!=null) {//verifica que se hayan encontrado informes
						tablaInformesDiarios miVentana = new tablaInformesDiarios(aux);
						miVentana.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron informes diarios en esa caja","Error Informe",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				if(numero.isEnabled()==false && estado!=true) {// caja
					int cod = Integer.parseInt(numero.getText());
					estado=true;
					Vector<Vector<String>> aux = Supermercado.getInstancia().getInformesPorCaja(cod);
					if(aux!=null) {//verifica que se hayan encontrado informes
						tablaInformesDiarios miVentana = new tablaInformesDiarios(aux);
						miVentana.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron informes diarios en esa caja","Error Informe",JOptionPane.ERROR_MESSAGE);
					}
				}
				if(dia.isEnabled()==false && estado!=true) {//fecha
					int d = Integer.parseInt(dia.getText());
					int m = Integer.parseInt(mes.getText());
					int a = Integer.parseInt(ano.getText());
					estado=true;
					LocalDate fecha = LocalDate.of(a,m,d);
					Vector<Vector<String>> aux = Supermercado.getInstancia().getInformesPorFecha(fecha);
					if(aux!=null) {//verifica que se hayan encontrado informes
						tablaInformesDiarios miVentana = new tablaInformesDiarios(aux);
						miVentana.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron informes diarios con esa fecha","Error Informe",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if(cajero.isEnabled()==false && estado!=true) {//cajero
					Vector<Vector<String>> aux = Supermercado.getInstancia().getInformesPorCajero(cajero.getText());
					estado=true;
					if(aux!=null) {//verifica que se hayan encontrado informes
						tablaInformesDiarios miVentana = new tablaInformesDiarios(aux);
						miVentana.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron informes diarios con ese cajero","Error Informe",JOptionPane.ERROR_MESSAGE);
					}
				}
				dia.setText("");
				mes.setText("");
				ano.setText("");
				cajero.setText("");
				numero.setText("");
				cajero.setEnabled(true);
				numero.setEnabled(true);
				dia.setEnabled(true);
				mes.setEnabled(true);
				ano.setEnabled(true);
				caja.setEnabled(true);
				confirmarFecha.setEnabled(true);
				buscarCajero.setEnabled(true);
				estado=false;
			}
		});
		buscarInformes.setBounds(21, 149, 133, 23);
		contentPane.add(buscarInformes);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setBounds(322, 149, 133, 23);
		contentPane.add(cancelar);
		

	}
}
