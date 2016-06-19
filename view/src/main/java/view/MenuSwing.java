package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    // Listener general : the action of menu user
    ActionListener afficherMenuListener = new ActionListener() {
    public void actionPerformed(ActionEvent event) {
        
    //  Load level.
    System.out.println( "MenuSwing.actionPerformed( '" + event.getActionCommand() + "' )");
    
    Connection cnx = jpublankprojectDB();
    
    Statement stmt = null;
    String query = "select ID_Object, ID_Map, ID_Type, " +
                   "AXIS_X, AXIS_Y " +
                   "from map";
    try {
        stmt = cnx.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            String ID_Type = rs.getString("ID_Type");
            

        }

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
    }
    
	public  Connection jpublankprojectDB(){
		
		try{
			Class.forName( "com.mysql.jdbc.Driver" );
			
			System.out.println("MenuSwing.jpublankprojectDB() : Driver created.");
			
			String url = "jdbc:mysql://localhost:3306/jpublankproject";
			String user = "root";
			String pass = "";
			
			Connection jpublankprojectConnection = DriverManager.getConnection( url, user, pass );
			
			System.out.println("MenuSwing.jpublankprojectDB() : Connection created.");
			
			return jpublankprojectConnection;
			
		}catch( Exception E){
			E.printStackTrace();
			//return null;
		}
		return null;
	}
};

// Create file
		JMenu fichierMenu = new JMenu("Levels");

		JMenuItem item = new JMenuItem("Level 1", '1');
		item.addActionListener(afficherMenuListener);
		fichierMenu.add(item);
		item = new JMenuItem("Level 2", '2');
		item.addActionListener(afficherMenuListener);
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
