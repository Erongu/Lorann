package view;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import javafx.scene.paint.Color;

public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		
		System.out.println("View()");
				
		this.viewFrame = new ViewFrame(model);
	    
		SwingUtilities.invokeLater(this);

		Connection cnx = jpublankprojectDB();
		
	    Statement stmt = null;
	    String query = "select ID_Object, ID_Map, ID_Type, " +
	                   "AXIS_X, AXIS_Y " +
	                   "from map";
	    try {
	        stmt = cnx.createStatement();
	        ResultSet rs = stmt.executeQuery(query);


	        while (rs.next()) {
	            String typeId = rs.getString("ID_Type");
	            
	            //System.out.println( typeId );
	            

	            
	        }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_G:
				return ControllerOrder.English;
			case KeyEvent.VK_F:
				return ControllerOrder.Francais;
			case KeyEvent.VK_D:
				return ControllerOrder.Deutsch;
			case KeyEvent.VK_I:
				return ControllerOrder.Indonesia;
			default:
				return ControllerOrder.English;
		}
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}
	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
	
	public void CreateSprite( int x, int y){
		
		System.out.println( "View.CreateSprite( " + Integer.toString(x) + ", " + Integer.toString(y) + " )" );
		
	    this.viewFrame.setLayout(null);

	    JPanel spriteB = new JPanel();
	    JLabel labell1 = new JLabel();
	    labell1.setIcon(new ImageIcon("C:/sprite/bone.png"));
	    labell1.setLocation( x, y);
	    labell1.setSize(32, 32);
	    spriteB.add(labell1);
	    this.viewFrame.add( spriteB );
	}

	public  Connection jpublankprojectDB(){
		
		try{
			Class.forName( "com.mysql.jdbc.Driver" );
			
			System.out.println("View.jpublankprojectDB() : Driver created.");
			
			String url = "jdbc:mysql://localhost:3306/jpublankproject";
			String user = "root";
			String pass = "";
			
			Connection jpublankprojectConnection = DriverManager.getConnection( url, user, pass );
			
			System.out.println("View.jpublankprojectDB() : Connection created.");
			
			return jpublankprojectConnection;
			
		}catch( Exception E){
			E.printStackTrace();
			//return null;
		}
		return null;
	}
}
