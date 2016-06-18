package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

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
    System.out.println("" + event.getActionCommand() + "Select");
    }
};

// CrÃ©ation du menu Fichier
JMenu fichierMenu = new JMenu("Levels");

//JMenuItem item = new JMenuItem("Iniialiser", 'N');
//item.addActionListener(afficherMenuListener);
//fichierMenu.add(item);
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

// CrÃ©ation du menu Editer
/*
JMenu editerMenu = new JMenu("Editer");
item = new JMenuItem("Copier");
item.addActionListener(afficherMenuListener);
item.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
editerMenu.add(item);
item = new JMenuItem("Couper");
item.addActionListener(afficherMenuListener);
item.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit()
.getMenuShortcutKeyMask(), false));
editerMenu.add(item);
item = new JMenuItem("Coller");
item.addActionListener(afficherMenuListener);
item.setAccelerator(KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
editerMenu.add(item);
// CrÃ©ation du menu Divers
JMenu diversMenu = new JMenu("Divers");
JMenu sousMenuDiver1 = new JMenu("Sous menu 1");
item.addActionListener(afficherMenuListener);
item = new JMenuItem("Sous menu 1 1");
sousMenuDiver1.add(item);
item.addActionListener(afficherMenuListener);
JMenu sousMenuDivers2 = new JMenu("Sous menu 1 2");
item = new JMenuItem("Sous menu 1 2 1");
sousMenuDivers2.add(item);
sousMenuDiver1.add(sousMenuDivers2);
diversMenu.add(sousMenuDiver1);
item = new JCheckBoxMenuItem("ValidÃ©");
diversMenu.add(item);
item.addActionListener(afficherMenuListener);
diversMenu.addSeparator();
ButtonGroup buttonGroup = new ButtonGroup();
item = new JRadioButtonMenuItem("Cas 1");
diversMenu.add(item);
item.addActionListener(afficherMenuListener);
buttonGroup.add(item);
item = new JRadioButtonMenuItem("Cas 2");
diversMenu.add(item);
item.addActionListener(afficherMenuListener);
buttonGroup.add(item);
diversMenu.addSeparator();
diversMenu.add(item = new JMenuItem("Autre",
new ImageIcon("about_32.png")));
item.addActionListener(afficherMenuListener);*/
// ajout des menus Ã  la barre de menu
add(fichierMenu);
/*
add(editerMenu);
add(diversMenu);*/
}
}
