import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Weapons extends JFrame {
	
	private JButton w1,w2,w3,w4,w5,w6,w7,w8,w9;
	
	public Weapons() {
		
		ImageIcon weapon_1 = new ImageIcon("armes/arc.jpeg");
		ImageIcon weapon_2 = new ImageIcon("armes/daga.jpeg");
		ImageIcon weapon_3 = new ImageIcon("armes/destral_dues_mans.jpeg");
		ImageIcon weapon_4 = new ImageIcon("armes/destral.jpeg");
		ImageIcon weapon_5 = new ImageIcon("armes/espasa.jpg");
		ImageIcon weapon_6 = new ImageIcon("armes/espases_dobles.jpg");
		ImageIcon weapon_7 = new ImageIcon("armes/katana.jpg");
		ImageIcon weapon_8 = new ImageIcon("armes/punyal.jpeg");
		ImageIcon weapon_9 = new ImageIcon("armes/simitarra.jpg");
					
		// Button with images of each weapon
		
		w1 = new JButton(weapon_1);
		w1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OcultarPer();}});
		
		w2 = new JButton(weapon_2);
		w2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OcultarPer();}});
		
		w3 = new JButton(weapon_3);
		w3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OcultarPer();}});
		
		w4 = new JButton(weapon_4);
		w4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OcultarPer();}});
		
		w5 = new JButton(weapon_5);
		w5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OcultarPer();}});
		
		w6 = new JButton(weapon_6);
		w6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OcultarPer();}});
		
		w7 = new JButton(weapon_7);
		w7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OcultarPer();}});
		
		w8 = new JButton(weapon_8);
		w8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OcultarPer();}});
		
		w9 = new JButton(weapon_9);
		w9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OcultarPer();}});
		
		this.setLayout(new GridLayout(3,3));

		this.add(w1);
		this.add(w2);
		this.add(w3);
		this.add(w4);
		this.add(w5);
		this.add(w6);
		this.add(w7);
		this.add(w8);
		this.add(w9);

		this.pack();
		this.setTitle("Weapons");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	public void OcultarPer() {
		this.setVisible(false);
	}
}
