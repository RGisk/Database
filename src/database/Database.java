
package database;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author jquesadaabeijon
 */
public class Database{

    public static void main(String[] args) {
        Methods met = new Methods();
        met.connect();
        met.createTable();
        int op = 0;

/**
 * Creo un switch case que sirve para elegir entre las diferentes opciones del despertador.
 */
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(">>>MENU<<< \n1. Insertar elemento \n2. Borrar elemento \n3. Modificar elemento \n4. Salir"));

            } catch (HeadlessException | NumberFormatException e) {
                System.out.println(e.getMessage());

            }
            switch (op) {

                case 1:
                    met.insert(new Element(JOptionPane.showInputDialog("Introducir ID: "), JOptionPane.showInputDialog("Introducir nombre: "), JOptionPane.showInputDialog("Introducir apellido: "), JOptionPane.showInputDialog("Introducir edad: ")));
                    break;
                case 2:
                    met.delete(JOptionPane.showInputDialog("Introducir ID del elemento a borrar: "));
                    break;
                case 3:
                    met.update(new Element(JOptionPane.showInputDialog("Introducir ID: "), JOptionPane.showInputDialog("Introducir nombre: "), JOptionPane.showInputDialog("Introducir apellido: "), JOptionPane.showInputDialog("Introducir edad: ")));
                    break;
                case 4:
                    System.exit(0);
            }

        } while (op!=0);
    }
}

