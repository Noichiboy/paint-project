import java.util.ArrayList;

/***
 * Ici l'interface Donnees qui contient un tableau de couleurs et de formes pour les combo box.
 * Contient aussi une liste de dessins qui contient les dessins faite pas les utilisateurs. Il nous servira aussi pour les boutons "effacer" et "revenir"
 * Avec par exemple removeAll pour tout supprimer.
 *
 */
public interface Data {
	public final static String[] couleurs = {"rouge","bleu","vert"};
	
	public final static String[] formes = {"cercle","rectangle","triangle","ellipse","segment"};
	ArrayList <Dessin> dessins = new ArrayList <Dessin>();
}
