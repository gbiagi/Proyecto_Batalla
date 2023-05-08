package proyectoJava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class BatallaDeRaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Juego();
		String urlDatos = "jdbc:mysql://localhost/BatallaDeRaces?serverTimezone=UTC";
		String usuario = "root";
		String pass = "1234";

		try {
			// Cargar Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver cargado correctamente");

			// Crear conexión BBDD
			Connection conn = DriverManager.getConnection(urlDatos, usuario, pass);
			System.out.println("Conexión creada correctamente");

			// Instanciar objeto de la clase consulta
			Statement stmnt = conn.createStatement();

			// Crear consulta
			String query1 = "select * from construcciones";
			
			// Ejecutar la consulta
			ResultSet rs1 = stmnt.executeQuery(query1);
			while (rs1.next()) {
				System.out.println("ID = " + rs1.getInt(1) + " Nombre = " + rs1.getString(2)
						+ " Precio = " + rs1.getInt(3));
			}
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no se ha cargado correctamente");
		} catch (SQLException e) {
			System.out.println("Conexión no creada correctamente");
		}
	}
}

class Juego extends JFrame {
	private JPanel panel;
	private JToolBar toolBar;
	private JButton personaje, arma, ranking;
	public Juego() {
		toolBar = new JToolBar();
		personaje = new JButton("Choose Character");
		arma = new JButton("Choose Weapon");
		arma.addActionListener(null);
		ranking = new JButton("Ranking");
		panel = new JPanel();
		personaje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new personajes();
			}
		});
		panel.add(personaje);
		panel.add(arma);
		panel.add(ranking);
		toolBar.add(panel);
		
		this.setTitle("BATALLA DE RACES");
		this.add(toolBar);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	class personajes extends JFrame {
		private JButton h1,h2,h3,e1,e2,e3,n1,n2,n3;
		public personajes() {
			ImageIcon huma1 = new ImageIcon("huma/huma1.png");
			ImageIcon huma2 = new ImageIcon("huma/huma2.jpg");
			ImageIcon huma3 = new ImageIcon("huma/huma3.jpg");
			ImageIcon elf1 = new ImageIcon("elf/elf1.jpg");
			ImageIcon elf2 = new ImageIcon("elf/elf2.jpg");
			ImageIcon elf3 = new ImageIcon("elf/elf3.jpg");
			ImageIcon nan1 = new ImageIcon("nan/nan1.jpg");
			ImageIcon nan2 = new ImageIcon("nan/nan2.jpg");
			ImageIcon nan3 = new ImageIcon("nan/nan3.png");
						
			// Boton con imágenes de cada raza,3 de cada, cuando se presione una imágen desaparece la ventana
			h1 = new JButton(huma1);
			h1.addActionListener(new ActionListener() {
				int raza=0;
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Select huma");
					raza = 1;
					OcultarPer();}});
			h2 = new JButton(huma2);
			h2.addActionListener(new ActionListener() {
				int raza=0;
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Select huma");
					raza=1;
					OcultarPer();}});
			h3 = new JButton(huma3);
			h3.addActionListener(new ActionListener() {
				int raza=0;
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Select huma");
					raza=1;
					OcultarPer();}});
			e1 = new JButton(elf1);
			e1.addActionListener(new ActionListener() {
				int raza=0;
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Select elf");
					raza=2;
					OcultarPer();}});
			e2 = new JButton(elf2);
			e2.addActionListener(new ActionListener() {
				int raza=0;
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Select elf");
					raza=2;
					OcultarPer();}});
			e3 = new JButton(elf3);
			e3.addActionListener(new ActionListener() {
				int raza=0;
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Select elf");
					raza=2;
					OcultarPer();}});
			n1 = new JButton(nan1);
			n1.addActionListener(new ActionListener() {
				int raza=0;
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Select nan");
					raza=3;
					OcultarPer();}});
			n2 = new JButton(nan2);
			n2.addActionListener(new ActionListener() {
				int raza=0;
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Select nan");
					raza=3;
					OcultarPer();}});
			n3 = new JButton(nan3);
			n3.addActionListener(new ActionListener() {
				int raza=0;
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Select nan");
					raza=3;
					OcultarPer();}});
			
			this.setLayout(new GridLayout(3,3));

			this.add(h1);
			this.add(h2);
			this.add(h3);
			this.add(e1);
			this.add(e2);
			this.add(e3);
			this.add(n1);
			this.add(n2);
			this.add(n3);

			this.pack();
			this.setTitle("Personajes");
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);
			
		}
		public void OcultarPer() {
			this.setVisible(false);
		}
	}
}


