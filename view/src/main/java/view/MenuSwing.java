package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import model.DBConnection;
import model.Model;

/**
 *
 * @author NWYART
 */
public class MenuSwing extends JMenuBar {

    public MenuSwing() {
    // Listener générique qui affiche l'action du menu utilisï¿½
    ActionListener afficherMenuListener = new ActionListener() {
    public void actionPerformed(ActionEvent event) {
        
    //  NW_TODO - Charger le niveau choisit.
    System.out.println( "" + event.getActionCommand());
    
   
    }
};

// Création du menu Fichier
JMenu fichierMenu = new JMenu("Levels");

JMenuItem item = new JMenuItem("Level 1", '1');
item.addActionListener(afficherMenuListener);
fichierMenu.add(item);
item = new JMenuItem("Level 2", '2');
item.addActionListener(afficherMenuListener);
//fichierMenu.insertSeparator(1);
fichierMenu.add(item);
item = new JMenuItem("Level 3", '3');
item.addActionListener(afficherMenuListener);
fichierMenu.add(item);
item = new JMenuItem("Level 4", '4');
item.addActionListener(afficherMenuListener);
fichierMenu.add(item);
item = new JMenuItem("Level 5", '5');
item.addActionListener(afficherMenuListener);
fichierMenu.add(item);


add(fichierMenu);

}
}
