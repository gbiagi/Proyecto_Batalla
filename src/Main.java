import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JFrame {
	
	private ArrayList<Characters> characters = new ArrayList<Characters>();
	private ArrayList<Weapons> weapons = new ArrayList<Weapons>();
	private JLabel titulo, portada;
	private JPanel panelRelleno, panelTitulo, panelPortada, panelJugar, panelPersonatge, panelArma, panelSortir, panelPrincipal, panelBotones;
	private JButton jugar, character, arma, sortir;
	
	public Main() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panelRelleno = new JPanel();
		
		titulo = new JLabel("Race Battle");
		titulo.setFont(new Font("Arial", Font.PLAIN, 50));
		panelTitulo = new JPanel();
		panelTitulo.add(titulo);
		
		ImageIcon imagen = new ImageIcon("imagenMenu.JPG");
		portada = new JLabel(imagen);
		panelPortada = new JPanel();
		panelPortada.add(portada);
		
		jugar = new JButton("Play");
		jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (weapons.isEmpty()) {
					JOptionPane.showMessageDialog(panelPrincipal, "You hadn't choose any armed warrior!");
				}
				else {
					
				}
			}
		});
		panelJugar = new JPanel();
		panelJugar.add(jugar);
		
		character = new JButton("Choose warrior");
		character.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new WarriorsFrame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelPersonatge = new JPanel();
		panelPersonatge.add(character);
		
		arma = new JButton("Choose weapon");
		arma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (characters.isEmpty()) {
					JOptionPane.showMessageDialog(panelPrincipal, "You hadn't choose any warrior!");
				}
				else {
					new Weapons();
				}
			}
		});
		panelArma = new JPanel();
		panelArma.add(arma);
		
		sortir = new JButton("Exit");
		sortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panelSortir = new JPanel();
		panelSortir.add(sortir);
		
		panelBotones = new JPanel();
		panelBotones.add(panelJugar, BorderLayout.CENTER);
		panelBotones.add(panelPersonatge, BorderLayout.CENTER);
		panelBotones.add(panelArma, BorderLayout.CENTER);
		panelBotones.add(panelSortir, BorderLayout.CENTER);
		
		panelPrincipal = new JPanel();
		panelPrincipal.add(panelRelleno, BorderLayout.CENTER);
		panelPrincipal.add(panelTitulo, BorderLayout.CENTER);
		panelPrincipal.add(panelPortada, BorderLayout.CENTER);
		panelPrincipal.add(panelBotones, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		this.add(panelPrincipal);
		
		this.setTitle("Menu");
		this.setSize(700, 700);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
class Characters extends JFrame {
	
	private JButton h1,h2,h3,e1,e2,e3,n1,n2,n3;
	
	public Characters() {
		
		ImageIcon huma1 = new ImageIcon("huma/huma1.png");
		ImageIcon huma2 = new ImageIcon("huma/huma2.jpg");
		ImageIcon huma3 = new ImageIcon("huma/huma3.jpg");
		ImageIcon elf1 = new ImageIcon("elf/elf1.jpg");
		ImageIcon elf2 = new ImageIcon("elf/elf2.jpg");
		ImageIcon elf3 = new ImageIcon("elf/elf3.jpg");
		ImageIcon nan1 = new ImageIcon("nan/nan1.jpg");
		ImageIcon nan2 = new ImageIcon("nan/nan2.jpg");
		ImageIcon nan3 = new ImageIcon("nan/nan3.png");
					
		// Button with images of each weapon
		
		h1 = new JButton(huma1);
		h1.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select huma");
				raza = 1;
				OcultarPer();}});
		
		h2 = new JButton(huma2);
		h2.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select huma");
				raza=1;
				OcultarPer();}});
		
		h3 = new JButton(huma3);
		h3.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select huma");
				raza=1;
				OcultarPer();}});
		
		e1 = new JButton(elf1);
		e1.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select elf");
				raza=2;
				OcultarPer();}});
		
		e2 = new JButton(elf2);
		e2.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select elf");
				raza=2;
				OcultarPer();}});
		
		e3 = new JButton(elf3);
		e3.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select elf");
				raza=2;
				OcultarPer();}});
		
		n1 = new JButton(nan1);
		n1.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select nan");
				raza=3;
				OcultarPer();}});
		
		n2 = new JButton(nan2);
		n2.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select nan");
				raza=3;
				OcultarPer();}});
		
		n3 = new JButton(nan3);
		n3.addActionListener(new ActionListener() {
			int raza=0;
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

class Weapons extends JFrame {
	
	private JButton h1,h2,h3,e1,e2,e3,n1,n2,n3;
	
	public Weapons() {
		
		ImageIcon huma1 = new ImageIcon("armes/arc.jpeg");
		ImageIcon huma2 = new ImageIcon("armes/daga.jpeg");
		ImageIcon huma3 = new ImageIcon("armes/destral_dues_mans.jpeg");
		ImageIcon elf1 = new ImageIcon("armes/destral.jpeg");
		ImageIcon elf2 = new ImageIcon("armes/espasa.jpg");
		ImageIcon elf3 = new ImageIcon("armes/espases_dobles.jpg");
		ImageIcon nan1 = new ImageIcon("armes/katana.jpg");
		ImageIcon nan2 = new ImageIcon("armes/punyal.jpeg");
		ImageIcon nan3 = new ImageIcon("armes/simitarra.jpg");
					
		// Button with images of each weapon
		
		h1 = new JButton(huma1);
		h1.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select huma");
				raza = 1;
				OcultarPer();}});
		
		h2 = new JButton(huma2);
		h2.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select huma");
				raza=1;
				OcultarPer();}});
		
		h3 = new JButton(huma3);
		h3.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select huma");
				raza=1;
				OcultarPer();}});
		
		e1 = new JButton(elf1);
		e1.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select elf");
				raza=2;
				OcultarPer();}});
		
		e2 = new JButton(elf2);
		e2.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select elf");
				raza=2;
				OcultarPer();}});
		
		e3 = new JButton(elf3);
		e3.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select elf");
				raza=2;
				OcultarPer();}});
		
		n1 = new JButton(nan1);
		n1.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select nan");
				raza=3;
				OcultarPer();}});
		
		n2 = new JButton(nan2);
		n2.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				System.out.println("Select nan");
				raza=3;
				OcultarPer();}});
		
		n3 = new JButton(nan3);
		n3.addActionListener(new ActionListener() {
			int raza=0;
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
