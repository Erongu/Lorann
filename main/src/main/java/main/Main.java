package main;

import controller.Controller;
import model.Model;
import view.View;

import java.sql.*;

/**
 * The Class Main.
 *
 */
public abstract class Main {

/**
* The main method.
*
* @param args
*          the arguments
*/
	public static void main(final String[] args) {
		
		System.out.println( "main()." );
		final Model model = new Model();
		final View view = new View( model );
		final Controller controller = new Controller( view, model );
		
		view.setController( controller );
		
		controller.control( );

		}

	public static Connection jpublankprojectDB(){
		
		try{
			Class.forName( "com.mysql.jdbc.Driver" );
			
			System.out.println("Driver created.");
			
			String url = "jdbc:mysql://localhost:3306/jpublankproject";
			String user = "root";
			String pass = "";
			
			Connection jpublankprojectConnection = DriverManager.getConnection( url, user, pass );
			
			System.out.println("Connection created.");
			return jpublankprojectConnection;
			
		}catch( Exception E){
			E.printStackTrace();
			//return null;
		}
		return null;
	}	
}