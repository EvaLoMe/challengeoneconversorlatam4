package challenge;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Principal implements ActionListener, FocusListener {
	private int clicks = 0;
	private JLabel label = new JLabel("Seleccione Parámetros a Convertir");
	private JLabel nombre = new JLabel("Bienvenido al Convertidor de Monedas");
	private JLabel eleccion;
	private JLabel respuesta = new JLabel("Respuesta");
	private JFrame frame = new JFrame();
	private String name;
	private JTextField tf;
	private Convertidor conversor;
	private Convertidor conversor2;
	private Convertidor conversorActual;
	private JComboBox <String> moneda1, moneda2;
	private JComboBox <String> longitud1, longitud2;
	private JPanel panel, pMonedas, pLongitudes;
	
	private JComboBox <String> seleccion;
	public Principal(Convertidor conversor) {
		this.conversor = conversor;
		
		// the clickable button
		JButton button = new JButton("Procesar");
		button.addActionListener(this);
		button.setBackground(new Color(11,186,213));
		
		// the panel with the button and text
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(5,2,15,15));

		panel.add(label);
		
		
		int size = conversor.cantidadDivisas();
		moneda1 = new JComboBox<String>();
		moneda2 = new JComboBox<String>();
		for (int i = 0; i < size; i++) {
			moneda1.addItem(conversor.getDivisa(i));
			moneda2.addItem(conversor.getDivisa(i));
			System.out.println("Entro al for " + i + conversor.getDivisa(i));
		}
		moneda1.setBounds(50, 50, 10, 10);
		moneda2.setBounds(50, 50, 10, 10);
		tf = new JTextField();
		tf.setText("Introduzca valor");
		tf.addFocusListener(this);
		panel.add(new JLabel(" "));
		panel.add(moneda1);
		panel.add(moneda2);
		panel.add(tf);
		panel.add(button);
		panel.add(respuesta);
		panel.setBackground(new Color(15,59,66));
		respuesta.setForeground(new Color(235,248,250));
		label.setForeground(new Color(235,248,250));
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Menú");
		frame.pack();
		//tf.requestFocus();
		
		frame.setVisible(true);
	}
	public Principal(Convertidor conversor, Convertidor conversor2) {
		this.conversor = conversor;
		this.conversor2 = conversor2;
		// the clickable button
		JButton button = new JButton("Procesar");
		button.addActionListener(this);
		button.setBackground(new Color(11,186,213));
		
		// the panel with the button and text
		panel = new JPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(10,5,15,15));
		//panel.setLayout(new FlowLayout());
		panel.add(nombre);
		panel.add(new JLabel(""));
		eleccion=new JLabel("Seleccione convertidor a usar");
		panel.add(eleccion);
		seleccion = new JComboBox<String>();
		seleccion.addItem("Convertidor de Monedas");
		seleccion.addItem("Convertidor de Longitud");
		panel.add(seleccion);
		panel.add(label);
		seleccion.addActionListener(this);
		
		int size = conversor.cantidadDivisas();
		moneda1 = new JComboBox<String>();
		moneda2 = new JComboBox<String>();
		for (int i = 0; i < size; i++) {
			moneda1.addItem(conversor.getDivisa(i));
			moneda2.addItem(conversor.getDivisa(i));
			System.out.println("Entro al for " + i + conversor.getDivisa(i));
		}
		moneda1.setBounds(50, 50, 10, 10);
		moneda2.setBounds(50, 50, 10, 10);
		
		int size2 = conversor2.cantidadDivisas();
		longitud1 = new JComboBox<String>();
		longitud2 = new JComboBox<String>();
		for (int i = 0; i < size2; i++) {
			longitud1.addItem(conversor2.getDivisa(i));
			longitud2.addItem(conversor2.getDivisa(i));
			System.out.println("Entro al for " + i + conversor2.getDivisa(i));
		}
		longitud1.setBounds(50, 50, 10, 10);
		longitud2.setBounds(50, 50, 10, 10);
		
		
		tf = new JTextField();
		tf.setText("Introduzca valor");
		tf.addFocusListener(this);
		panel.add(new JLabel(" "));
		
		pMonedas= new JPanel();
		pLongitudes=new JPanel();
		pMonedas.add(moneda1);
		pMonedas.add(moneda2);
		
		pLongitudes.add(longitud1);
		pLongitudes.add(longitud2);
		
		panel.add(pMonedas);
		panel.add(pLongitudes);
		panel.add(tf);
		panel.add(button);
		panel.add(respuesta);
		panel.setBackground(new Color(15,59,66));
		respuesta.setForeground(new Color(235,248,250));
		label.setForeground(new Color(235,248,250));
		nombre.setForeground(new Color(235,248,250));
		eleccion.setForeground(new Color(235,248,250));
		conversorActual=conversor;
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Menú");
		frame.pack();
		pLongitudes.setVisible(false);
		//tf.requestFocus();
		
		frame.setVisible(true);
	}

	// process the button clicks


	// process the button clicks
	public void actionPerformed(ActionEvent e) {
		String mon1, mon2;
		if(conversorActual.getName().equals(conversor.getName())) {
		mon1 = moneda1.getSelectedItem() + "";
		mon2 = moneda2.getSelectedItem() + "";
		}else {
			mon1 = longitud1.getSelectedItem() + "";
			mon2 = longitud2.getSelectedItem() + "";
		}
		double valorUnitario = conversorActual.convertirADivisa(mon1, mon2);
		double valorConvertir = 0;
		System.out.println("Entrando al AP "+e.getID());
		System.out.println("Entrando al AP "+e.getActionCommand());
		if(e.getActionCommand().equals("comboBoxChanged")) {
			System.out.println("Dentro del selector ");
			if(conversor.getName().equals(seleccion.getSelectedItem())) {
				conversorActual=conversor;
				pMonedas.setVisible(true);
				pLongitudes.setVisible(false);
					}else {
						conversorActual=conversor2;
						pLongitudes.setVisible(true);
						pMonedas.setVisible(false);
					}
		}else {
		try {
			valorConvertir = Double.parseDouble(tf.getText());
			System.out.println("Dentro del try " + tf.getText());
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, tf.getText() + " no es un valor numérico");
			System.out.println("Error numerico");
			valorConvertir = 0;
		} finally {
			String salida=(valorConvertir * valorUnitario)+"0000";
			respuesta.setText(salida.substring(0,salida.indexOf('.')+4) + " " + mon2);
			
			
			
			int eleccion=JOptionPane.showConfirmDialog(null, "Desea continuar? Modo confirm");
			switch(eleccion) {
			case 0: break;
			case 1: case 2: 
				JOptionPane.showMessageDialog(null, "Programa finalizado");
				frame.dispose();
				break;
			
			}
		}
		}
	}

	// create one Frame

	public static void main(String[] args) {
		Convertidor conversor = new Convertidor("Convertidor de Monedas");
		conversor.agregarDivisa("Peso", 1);
		conversor.agregarDivisa("Dólar", 18.78);
		conversor.agregarDivisa("Euro", 19.93);
		conversor.agregarDivisa("Yen Japonés", 0.14);
		conversor.agregarDivisa("Libra esterlina", 22.73);
		conversor.agregarDivisa("Won Sul-Coreano", 0.014);
		Convertidor conversor2 = new Convertidor("Convertidor de Longitud");
		conversor2.agregarDivisa("Pulgada", 2.54);
		conversor2.agregarDivisa("Pie", 30.48);
		conversor2.agregarDivisa("Yarda", 914);
		conversor2.agregarDivisa("Milla", 1609000);
		conversor2.agregarDivisa("Metro", 100);
		conversor2.agregarDivisa("Centìmetro", 1);
		new Principal(conversor, conversor2);
	}

	@Override
	public void focusGained(FocusEvent e) {
		tf.setText("");
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
