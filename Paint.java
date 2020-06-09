import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Paint extends JFrame {	
	private BoutonListener e = new BoutonListener();
	private JPanel pn = new JPanel();
	private PanneauCentre pc = new PanneauCentre();
	private JToggleButton crayon = new JToggleButton(new ImageIcon("logoCrayon.png"));
	private JToggleButton gomme = new JToggleButton(new ImageIcon("logoGomme.png"));	
	private JComboBox<String> colorChoice = new JComboBox<String>();	
	private JComboBox<String> shapeChoice = new JComboBox<String>();
	private JTextField text = new JTextField(10);
	JButton deleteAll = new JButton("Effacer tout");
	JButton wayback = new JButton("Retour en arriere");
	
	public Paint (String  titre , int x, int y, int w, int h)  {
		super (titre);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(x,y,w,h);
		this.setVisible(true);
		this.initialise();
		}
		
	private JPanel getPanelSud(){		
		
		JPanel ps = new JPanel();
		ps.setLayout(new FlowLayout());
		
		
		ps.add(deleteAll);
		deleteAll.addActionListener(e);

		ps.add(wayback);
		wayback.addActionListener(e);

		return ps;
	}
		
	private JPanel getPanelCentre(){
		this.addMouseListener(e);
		return pc;
	}
	
	private JPanel getPanelNord(){		
		JLabel couleur = new JLabel("Couleur : ");
		
		int sizeCouleurs = Data.couleurs.length;
		
		for(int i = 0; i < sizeCouleurs; i++){ 
			colorChoice.addItem(Data.couleurs[i]);}
		pn.add(colorChoice); //couleurs
		
		int sizeFormes = Data.formes.length;
		
		for(int i = 0; i < sizeFormes; i++){ 
			shapeChoice.addItem(Data.formes[i]);}
		pn.add(shapeChoice);//formes
		
		JLabel taille = new JLabel(" Taille : ");
		pn.add(taille);
		pn.add(text);//taille
		
		pn.add(crayon);//crayon
		
		pn.add(gomme);//gomme
		
		return pn;
	}

	public void initialise(){
		this.setLayout(new BorderLayout());
		this.add(this.getPanelNord(),BorderLayout.NORTH);
		this.add(this.getPanelCentre(), BorderLayout.CENTER);
		this.add(this.getPanelSud(),BorderLayout.SOUTH);
	}
	
	public static void main( String [ ]  args ) {
		Paint fenetre = new Paint("Paint",100,0,1000,600);
		fenetre.setVisible(true);
		}
	
private class BoutonListener implements ActionListener, MouseListener, KeyListener {
	//ActionListener
	public void actionPerformed(ActionEvent a) {
	Object source = a.getSource();
	
	if(gomme.isSelected() && crayon.isSelected()){
		JOptionPane.showMessageDialog(null, 
			"Interdit de cliquer sur 2 boutons en meme temps !");
	}
	if(source.equals(wayback)){
		Data.dessins.remove(Data.dessins.size()-1);
		pc.repaint();
	}
	if(source.equals(deleteAll)){
		Data.dessins.removeAll(Data.dessins);
		pc.repaint();
	}
	}
	
	//MouseListener
	public void mousePressed(MouseEvent e) {
		if(crayon.isSelected()){
			int taille;
			if(text.getText().isEmpty()){//Si texte vide, taille = 50.
				taille = 50;
			}			
			else{
				taille = Integer.parseInt(text.getText());//Si texte rempli, taille = value
			}
			String couleur = (String) colorChoice.getSelectedItem();
			String forme = (String) shapeChoice.getSelectedItem();
			
			Dessin d = new Dessin(e.getX()-(taille/2), e.getY()-(taille/2)-85,couleur,forme,taille);
			Data.dessins.add(d);
		}
		
		if(gomme.isSelected()){
			int taille;
			if(text.getText().isEmpty()){
				taille = 50;
			}			
			else{
				taille = Integer.parseInt(text.getText());
			}
			String forme = (String) shapeChoice.getSelectedItem();
			Dessin d = new Dessin(e.getX()-(taille/2), e.getY()-(taille/2)-85,"blanc",forme,taille);
			Data.dessins.add(d);
		}
		pc.repaint();
	}
	
	public void mouseClicked(MouseEvent arg0) {}
		
	public void mouseEntered(MouseEvent arg0) {}
		
	public void mouseExited(MouseEvent arg0) {}
		
	public void mouseReleased(MouseEvent arg0) {}
	
	//KeyListener
	public void keyPressed(KeyEvent evt){
		/*if (evt.getKeyCode() == KeyEvent.CTRL_MASK) {
	}*/}

	public void keyReleased(KeyEvent evt){} 

	public void keyTyped(KeyEvent evt) {}
	 
		
}//fin inner class

}
