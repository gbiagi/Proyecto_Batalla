import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Characters extends JFrame {
	
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
					
		// Button with images of each character
		
		h1 = new JButton(huma1);
		h1.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				raza = 1;
				OcultarPer();}});
		
		h2 = new JButton(huma2);
		h2.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				raza=1;
				OcultarPer();}});
		
		h3 = new JButton(huma3);
		h3.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				raza=1;
				OcultarPer();}});
		
		e1 = new JButton(elf1);
		e1.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				raza=2;
				OcultarPer();}});
		
		e2 = new JButton(elf2);
		e2.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				raza=2;
				OcultarPer();}});
		
		e3 = new JButton(elf3);
		e3.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				raza=2;
				OcultarPer();}});
		
		n1 = new JButton(nan1);
		n1.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				raza=3;
				OcultarPer();}});
		
		n2 = new JButton(nan2);
		n2.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
				raza=3;
				OcultarPer();}});
		
		n3 = new JButton(nan3);
		n3.addActionListener(new ActionListener() {
			int raza=0;
			public void actionPerformed(ActionEvent e) {
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
		this.setTitle("Warriors");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	public void OcultarPer() {
		this.setVisible(false);
	}
}
