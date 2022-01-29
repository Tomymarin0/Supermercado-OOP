package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class tablaInformesSinStock extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param informe 
	 */
	public tablaInformesSinStock(Vector<Vector<String>> informe) {
		setTitle("Informe Productos Sin Stock");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 548, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Pedir los datos a la concesionaria
		Vector<Vector<String>> datos = informe;
		
		//Array de ‘String’ con los titulos de las columnas
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Codigo");
		columnNames.add("Proveedor");
		columnNames.add("Precio");
		columnNames.add("Stock");
		columnNames.add("Stock Minimo");
		columnNames.add("Reposicion");

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 523, 359);
		panel.add(scrollPane);
		
		TableModel jTable1Model = new DefaultTableModel(datos, columnNames);
		table = new JTable(datos,columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
		table.setModel(jTable1Model);
		//table.setBounds(14, 14, 350, 189);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//table.setLocation(new java.awt.Point(0	, 0));
		scrollPane.setViewportView(table);
	}

}
