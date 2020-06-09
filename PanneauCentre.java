import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

/***
 * Class PanneauCentre qui sert à appeler dans la class Paint. C'est pour gerer les dessins dans le centre de la fenetre.
 * Le background du centre est mis en blanc.
 * PaintCompenent pour dessiner."FillOval" pour le cercle et "FillRect" pour le carre.
 * GetX et GetY pour récuperer la position de la souris.
 *
 */
public class PanneauCentre extends JPanel{
	public PanneauCentre(){
		setBackground(Color.WHITE);//Couleur du centre de la fenetre
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for (Dessin d : Data.dessins) {
			if(d.getFormes() == "cercle"){
				g.setColor(d.getCouleurs());
				if (d.getPlein() == true){
					g.fillOval(d.getX(), d.getY(), d.getTaille(), d.getTaille());
					Data.dessins.add(d);
				}else{
					g.drawOval(d.getX(), d.getY(), d.getTaille(), d.getTaille());}
			}else if (d.getFormes()== "rectangle"){
				g.setColor(d.getCouleurs());
				if (d.getPlein() == true){
					g.fillRect(d.getX(), d.getY(), d.getTaille(), d.getTaille());
					Data.dessins.add(d);}
				else{
					g.drawRect(d.getX(), d.getY(), d.getTaille(), d.getTaille());}
			}else if (d.getFormes()== "triangle"){
				g.setColor(d.getCouleurs());
				g.fillRect(d.getX(), d.getY(), d.getTaille(), d.getTaille());
			}else if (d.getFormes()== "ellipse"){
				g.setColor(d.getCouleurs());
				g.fillOval(d.getX(), d.getY(), d.getTaille(), d.getTaille());
			}else if (d.getFormes()== "segment"){
				g.setColor(d.getCouleurs());
				g.drawLine(d.getX(), d.getY(), d.getTaille(), d.getTaille());
			}
		}
	}

}
