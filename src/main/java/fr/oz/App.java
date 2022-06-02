package fr.oz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

/**
 * @author Romain
 * @version 0.1
 * 
 *
 *
 */
public class App {
    public static void main(String[] args) {
        HashMap<String, String> glossaire = new HashMap<>(); // Initialisation de la collection

        glossaire.put("Sous classe", "Classe héritant d'une autre classe"); // Ajout des elements
        glossaire.put("Méthode", "Une fonction destinatrice d'un message");
        glossaire.put("Polymorphisme", "Un comportement different pour un même message");
        glossaire.put("Collection", "Instance d'une classe gérant un ensemble d'élément");
        glossaire.put("Bonheur", "Maîtriser Java et ses subtilités .. oui oui ...");
        glossaire.put("Interface", "Classe dont toutes les méthodes sont abstraites");
        glossaire.put("Instance", "Objet créé à partir d'une classe");
        boolean vraiMot = false;
        do {

            String question = JOptionPane.showInputDialog(null, "Quel mot cherchez-vous ?", "Mot ?",
                    JOptionPane.QUESTION_MESSAGE);
            if (question == null) {
                break;
            }
            if (glossaire.containsKey(question)) { // Vérification de la présence de la clé dans la collection
                vraiMot = true;
                JOptionPane.showMessageDialog(null, question + " : " + glossaire.get(question) + ".",
                        "Résultat de la recherche",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Le mot n'est pas dans le Glossaire");
            }
        } while (vraiMot != true);

        afficherFormatHtml(glossaire);

    }

    static void afficherFormatHtml(Map map) {
        String affichageTableau = "<html><table style=\"border: thick double #32a1ce\"><tr style=\"background-color: rgb(146, 174, 243)\"><th style=\"border: solid  purple; font-size: 15px; \";>Clé</th><th style=\"border: solid   purple; font-size: 15px\">Valeur</th></tr>";
        Iterator chaque = map.entrySet().iterator();
        while (chaque.hasNext()) {
            Map.Entry mapentry = (Map.Entry) chaque.next();
            affichageTableau = affichageTableau + "<tr><td  style=\"border: 1px solid black\">" + mapentry.getKey()
                    + "</td><td  style=\"border: 1px solid black\">" + mapentry.getValue()
                    + " </td></tr>";

            System.out.println(mapentry.getKey());
            System.out.println(mapentry.getValue());
        }
        affichageTableau = affichageTableau + "</table></html>";

        JOptionPane.showMessageDialog(null, affichageTableau, "La collection...", JOptionPane.INFORMATION_MESSAGE);

    }

}
