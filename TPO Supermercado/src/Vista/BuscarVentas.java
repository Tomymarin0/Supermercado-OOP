package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Clases.venta;
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

public class BuscarVentas extends JFrame {

	private JPanel contentPane;
	private JTextField dia1;
	private JTextField mes1;
	private JTextField ano1;
	private JTextField dia2;
	private JTextField mes2;
	private JTextField ano2;
	private JTextField numero;
	private JTextField cajero;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public BuscarVentas() {
		setTitle("Buscar Ventas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fecha 1:");
		lblNewLabel.setBounds(10, 11, 59, 14);
		contentPane.add(lblNewLabel);
		
		JLabel awegf = new JLabel("Dia:");
		awegf.setBounds(63, 11, 46, 14);
		contentPane.add(awegf);
		
		dia1 = new JTextField();
		dia1.setBounds(91, 8, 34, 20);
		contentPane.add(dia1);
		dia1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mes:");
		lblNewLabel_1.setBounds(135, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		mes1 = new JTextField();
		mes1.setColumns(10);
		mes1.setBounds(167, 8, 34, 20);
		contentPane.add(mes1);
		
		JLabel lblNewLabel_2 = new JLabel("A\u00F1o:");
		lblNewLabel_2.setBounds(211, 11, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		ano1 = new JTextField();
		ano1.setBounds(244, 8, 59, 20);
		contentPane.add(ano1);
		ano1.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha 2:");
		lblFecha.setBounds(10, 42, 59, 14);
		contentPane.add(lblFecha);
		
		JLabel awegf_1 = new JLabel("Dia:");
		awegf_1.setBounds(63, 42, 46, 14);
		contentPane.add(awegf_1);
		
		dia2 = new JTextField();
		dia2.setEnabled(false);
		dia2.setColumns(10);
		dia2.setBounds(91, 39, 34, 20);
		contentPane.add(dia2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mes:");
		lblNewLabel_1_1.setBounds(135, 42, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		mes2 = new JTextField();
		mes2.setEnabled(false);
		mes2.setColumns(10);
		mes2.setBounds(167, 39, 34, 20);
		contentPane.add(mes2);
		
		JLabel lblNewLabel_2_1 = new JLabel("A\u00F1o:");
		lblNewLabel_2_1.setBounds(211, 42, 46, 14);
		contentPane.add(lblNewLabel_2_1);
		
		ano2 = new JTextField();
		ano2.setEnabled(false);
		ano2.setColumns(10);
		ano2.setBounds(244, 39, 59, 20);
		contentPane.add(ano2);
		
		JButton confirmarFecha1 = new JButton("Confirmar");
		JButton confirmarFecha2 = new JButton("Confirmar");
		confirmarFecha2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se confirma la fecha2
				int d=0;
				int m=0;
				int a=0;
				LocalDate fecha2 = LocalDate.of(1, 1, 1);
				try {
					d=Integer.parseInt(dia2.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Dia",JOptionPane.ERROR_MESSAGE);
				}
				try {
					m=Integer.parseInt(mes2.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Mes",JOptionPane.ERROR_MESSAGE);
				}
				try {
					a=Integer.parseInt(ano2.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Año",JOptionPane.ERROR_MESSAGE);
				}
				try {
					fecha2 = LocalDate.of(a, m, d);
				} catch (Exception e6) {
					JOptionPane.showMessageDialog(null,"Ingrese una fecha valida","Fecha Invalida",JOptionPane.ERROR_MESSAGE);
				}
				int d1 = Integer.parseInt(dia1.getText());
				int m1 = Integer.parseInt(mes1.getText());
				int a1 = Integer.parseInt(ano1.getText());
				LocalDate aux = LocalDate.of(1,1,1);
				LocalDate fecha1 = LocalDate.of(a1,m1,d1);
				if(fecha2.isAfter(aux) && fecha2.isAfter(fecha1)) {//se verifica que la fecha 2 se haya parseado bien y que sea mayor a la fecha 1
					dia2.setEnabled(false);
					mes2.setEnabled(false);
					ano2.setEnabled(false);
					confirmarFecha2.setEnabled(false);
					JOptionPane.showMessageDialog(null,"La fecha ingresada es valida","Fecha Correcta",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"Ingrese una fecha valida","Error Fecha",JOptionPane.ERROR_MESSAGE);
				}
			}
				
			
		});
		confirmarFecha1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se confirma la fecha 1
				int d=0;
				int m=0;
				int a=0;
				LocalDate fecha = LocalDate.of(1, 1, 1);
				try {
					d=Integer.parseInt(dia1.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Dia",JOptionPane.ERROR_MESSAGE);
				}
				try {
					m=Integer.parseInt(mes1.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Mes",JOptionPane.ERROR_MESSAGE);
				}
				try {
					a=Integer.parseInt(ano1.getText());
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
					dia1.setEnabled(false);
					mes1.setEnabled(false);
					ano1.setEnabled(false);
					confirmarFecha1.setEnabled(false);
					dia2.setEnabled(true);
					mes2.setEnabled(true);
					ano2.setEnabled(true);
					confirmarFecha2.setEnabled(true);
					JOptionPane.showMessageDialog(null,"La fecha ingresada es valida, si desea buscar entre fechas, ingrese una fecha en fecha 2","Fecha Correcta",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"Ingrese una fecha valida","Error Fecha",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		confirmarFecha1.setBounds(313, 7, 108, 23);
		contentPane.add(confirmarFecha1);
		

		confirmarFecha2.setEnabled(false);
		confirmarFecha2.setBounds(313, 38, 108, 23);
		contentPane.add(confirmarFecha2);
		
		JLabel lblNewLabel_3 = new JLabel("Caja:");
		lblNewLabel_3.setBounds(10, 78, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		numero = new JTextField();
		numero.setBounds(49, 75, 34, 20);
		contentPane.add(numero);
		numero.setColumns(10);
		
		JButton buscarCaja = new JButton("Buscar");
		buscarCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se confirma la caja ingresada
				int cod=-999;
				try {
					cod=Integer.parseInt(numero.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Solo debe ingresar numeros enteros","Error Caja",JOptionPane.ERROR_MESSAGE);
				}
				if(cod!=-999) {//se verifica que se haya parseado correctamente
					if(Supermercado.getInstancia().buscarCajaView(cod)!=null) {//se verifica que exista la caja
						JOptionPane.showMessageDialog(null,"Se encontro la caja buscada","Caja Encontrada",JOptionPane.INFORMATION_MESSAGE);
						buscarCaja.setEnabled(false);
						numero.setEnabled(false);

					} else {
						JOptionPane.showMessageDialog(null,"La caja buscada no existe","Error Caja",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		buscarCaja.setBounds(101, 74, 89, 23);
		contentPane.add(buscarCaja);
		
		JLabel lblNewLabel_4 = new JLabel("Cajero:");
		lblNewLabel_4.setBounds(10, 118, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		cajero = new JTextField();
		cajero.setBounds(63, 115, 86, 20);
		contentPane.add(cajero);
		cajero.setColumns(10);
		
		JButton buscarCajero = new JButton("Buscar");
		buscarCajero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se confirma el cajero ingresado
				boolean aux = Supermercado.getInstancia().buscarCajero(cajero.getText());
				if(aux==true) {//se verifica que el cajero exista
					JOptionPane.showMessageDialog(null,"Se encontro el cajero buscado","Cajero Encontrado",JOptionPane.INFORMATION_MESSAGE);
					cajero.setEnabled(false);
					buscarCajero.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null,"El cajero buscado no existe","Error Cajero",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buscarCajero.setBounds(167, 114, 89, 23);
		contentPane.add(buscarCajero);
		
		JButton buscarVentas = new JButton("Buscar ventas");
		buscarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//se buscan las ventas con los filtros ingresados
				boolean estado=false;//este estado se usa para saber si ya entro en algun filtro para que luego no entre en otro que quiza tambien cumpla los requisitos de busqueda
				if(numero.isEnabled()==false && cajero.isEnabled()==false && estado!=true) {//caja cajero
					int cod = Integer.parseInt(numero.getText());
					estado=true;
					Vector<Vector<String>> aux = Supermercado.getInstancia().getVentasNumeroCajero(cod, cajero.getText());
					if(aux!=null) {//verifica que se hayan encontrado ventas
						tablaVentas miVentana = new tablaVentas(aux);
						miVentana.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron ventas en la caja de ese cajero","Error Ventas",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				if(numero.isEnabled()==false && dia1.isEnabled()==false && estado!=true) {//caja fecha o fechas
					int cod = Integer.parseInt(numero.getText());
					int d1 = Integer.parseInt(dia1.getText());
					int m1 = Integer.parseInt(mes1.getText());
					int a1 = Integer.parseInt(ano1.getText());
					LocalDate fecha2 = LocalDate.of(a1,m1,d1);
					if(dia2.isEnabled()==false) {//se verifica que se haya ingresado algo en la fecha 2
						int d2 = Integer.parseInt(dia2.getText());
						int m2 = Integer.parseInt(mes2.getText());
						int a2 = Integer.parseInt(ano2.getText());
						LocalDate aux = LocalDate.of(a2,m2,d2);
						fecha2=aux;
					}
					LocalDate fecha1 = LocalDate.of(a1,m1,d1);
					estado=true;
					Vector<Vector<String>> aux = Supermercado.getInstancia().getVentasNumeroFechas(cod, fecha1, fecha2);
					if(aux!=null) {//verifica que se hayan encontrado ventas
						tablaVentas miVentana = new tablaVentas(aux);
						miVentana.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron ventas en la caja con esa/s fecha/s","Error Ventas",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				if(cajero.isEnabled()==false && dia1.isEnabled()==false && estado!=true) {//cajero fecha o fechas
					int d1 = Integer.parseInt(dia1.getText());
					int m1 = Integer.parseInt(mes1.getText());
					int a1 = Integer.parseInt(ano1.getText());
					LocalDate fecha2 = LocalDate.of(a1,m1,d1);
					if(dia2.isEnabled()==false) {//se verifica que se haya ingresado algo en la fecha 2
						int d2 = Integer.parseInt(dia2.getText());
						int m2 = Integer.parseInt(mes2.getText());
						int a2 = Integer.parseInt(ano2.getText());
						LocalDate aux = LocalDate.of(a2,m2,d2);
						fecha2=aux;
					}
					LocalDate fecha1 = LocalDate.of(a1,m1,d1);
					estado=true;
					Vector<Vector<String>> aux = Supermercado.getInstancia().getVentasCajeroFechas(cajero.getText(), fecha1, fecha2);
					if(aux!=null) {//verifica que se hayan encontrado ventas
						tablaVentas miVentana = new tablaVentas(aux);
						miVentana.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron ventas del cajero en esa/s fecha/s","Error Ventas",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				if(numero.isEnabled()==true && dia1.isEnabled()==true && cajero.isEnabled()==true && dia2.isEnabled()==false && estado!=true) {//al dejar los campos vacios se muestran todas las ventas
					Vector<Vector<String>> aux = Supermercado.getInstancia().getTodasLasVentas();
					estado=true;
					if(aux!=null) {//verifica que se hayan encontrado ventas
						tablaVentas miVentana = new tablaVentas(aux);
						miVentana.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No hay ventas en el sistema","Error Ventas",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				if(numero.isEnabled()==false && estado!=true) {//caja
					int cod = Integer.parseInt(numero.getText());
					estado=true;
					Vector<Vector<String>> aux = Supermercado.getInstancia().getVentasPorCaja(cod);
					if(aux!=null) {//verifica que se hayan encontrado ventas
						tablaVentas miVentana = new tablaVentas(aux);
						miVentana.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron ventas en esa caja","Error Ventas",JOptionPane.ERROR_MESSAGE);
					}
				}
				if(dia1.isEnabled()==false && estado!=true) {//fecha o fechas
					int d1 = Integer.parseInt(dia1.getText());
					int m1 = Integer.parseInt(mes1.getText());
					int a1 = Integer.parseInt(ano1.getText());
					LocalDate fecha2 = LocalDate.of(a1,m1,d1);
				
					if(dia2.isEnabled()==false) {//se verifica que haya ingresado fecha 2
						int d2 = Integer.parseInt(dia2.getText());
						int m2 = Integer.parseInt(mes2.getText());
						int a2 = Integer.parseInt(ano2.getText());
						LocalDate aux = LocalDate.of(a2,m2,d2);
						fecha2=aux;
					}
					LocalDate fecha1 = LocalDate.of(a1,m1,d1);
					estado=true;
					Vector<Vector<String>> aux = Supermercado.getInstancia().getVentasEntreFechas(fecha1, fecha2);
					if(aux!=null) {//verifica que se hayan encontrado ventas
						tablaVentas miVentana = new tablaVentas(aux);
						miVentana.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron ventass con esa/s fecha/s","Error Venta",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if(cajero.isEnabled()==false && estado!=true) {//cajero
					Vector<Vector<String>> aux = Supermercado.getInstancia().getVentasPorCajero(cajero.getText());
					estado=true;
					if(aux!=null) {//verifica que se hayan encontrado ventas
						tablaVentas miVentana = new tablaVentas(aux);
						miVentana.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se encontraron ventas con ese cajero","Error Venta",JOptionPane.ERROR_MESSAGE);
					}
				}
				dia1.setText("");
				mes1.setText("");
				ano1.setText("");
				dia2.setText("");
				mes2.setText("");
				ano2.setText("");
				cajero.setText("");
				numero.setText("");
				cajero.setEnabled(true);
				numero.setEnabled(true);
				dia1.setEnabled(true);
				mes1.setEnabled(true);
				ano1.setEnabled(true);
				dia2.setEnabled(false);
				mes2.setEnabled(false);
				ano2.setEnabled(false);
				buscarCaja.setEnabled(true);
				confirmarFecha1.setEnabled(true);
				confirmarFecha2.setEnabled(false);
				buscarCajero.setEnabled(true);
				estado=false;
			}
		});
		buscarVentas.setBounds(10, 159, 117, 23);
		contentPane.add(buscarVentas);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setBounds(304, 159, 117, 23);
		contentPane.add(cancelar);
	}
}
