package model;

import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;

import contract.IModel;

/**
 * The Class Model.
 *
 */
public class Model extends Observable implements IModel {

	/** The message. */
	private String message;
	private int IDmap;
	
	

	public int getIDmap() {
		return IDmap;
	}

	public void setIDmap(int iDmap) {
		IDmap = iDmap;
	}

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private void setMessage(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMessage(final String key) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMessage(daoHelloWorld.find(key).getMessage());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> loadMap () { 
		int ID_Map = this.getIDmap();
        ArrayList<String> spritelist = new ArrayList<String>();
		try {
			Connection cnx = jpublankprojectDB();
			
		    
		    Statement stmt = null;
		    String query = "select ID_Object, ID_Map, ID_Type, " +
		                   "AXIS_X, AXIS_Y " +
		                   "from map =" + Integer.toString(ID_Map);
	        stmt = cnx.createStatement();
	        ResultSet rs = stmt.executeQuery(query);

	        int i = 0;

	        while (rs.next()) {
	            String typeId = rs.getString("ID_Type");
	            spritelist.add(typeId);
	            
	            //System.out.println( typeId );
	            String picture = "";
	        }
	        

			;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return spritelist;
	}
	
	
	
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
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
}


