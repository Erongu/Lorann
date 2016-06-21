
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
	
	public ArrayList<String> spritelist = new ArrayList<String>();
	
	//	SW_MOBIL..
	public ArrayList<SpriteLOL> spriteLOLlist = new ArrayList<SpriteLOL>();

	private int score;
	private int IDmap;

	public int getIDmap() {
		return IDmap;
	}
	public int getScore(){
		return score;
	}
	public void setIDmap(int iDmap) {
		Boolean change = (IDmap != iDmap); 
		IDmap = iDmap;
		  
		if (change == true){
		spritelist = getSpriteList( );
		//	NW_MOBIL.
		spriteLOLlist = getSpriteLOLList( );
		this.setChanged();
		this.notifyObservers();
		}
	}
/**
 * @param deltaX 
 * @param deltaY
 */
	public void setLorannMove(int deltaX, int deltaY ) {
		
		 for (SpriteLOL lol : spriteLOLlist) {
			 
			  if ( lol.getType().equals( "L")) {	//	Wee find Lorann.
				  
				System.out.println("Model.setLorannMove() - Lorann found.");
				
				int x = lol.getX();
				int y = lol.getY();
				
				//	Find the sprite in the destination position.
				SpriteLOL spriteInCase = getSpriteByPosition( x + deltaX, y + deltaY );
				
				if (spriteInCase == null)		//	Destination is free.
					{
					lol.setX( x+deltaX );
					lol.setY( y+deltaY );
					
					this.setChanged();
					this.notifyObservers();
  				    }
				else{
					//	Destination is not free.
					if ( spriteInCase.Type.equals("P") )	//	Lorann meet a Purse. 
						{
						//	Put the sprite out of the windows drawing zone.
						spriteInCase.X = 1000;
						spriteInCase.Y = 1000;

						lol.setX( x+deltaX );
						lol.setY( y+deltaY );
						
						score += 1000;
						
						this.setChanged();
						this.notifyObservers();
					}
					
					else if ( spriteInCase.Type.equals("CB") )	//	Lorann meet a Crystal_Ball. 
					{
					//	Put the sprite out of the windows drawing zone.
					spriteInCase.X = 1000;
					spriteInCase.Y = 1000;

					lol.setX( x+deltaX );
					lol.setY( y+deltaY );
					
					//method research gate_closed 
					SpriteLOL gateLocked = getSpriteByType("GL");
					
					gateLocked.Type = "GU";
					
					
					this.setChanged();
					this.notifyObservers();
					
				}
					else if(spriteInCase.Type.equals("GU"))
					{
						System.out.println("map 0 ");
					IDmap = 0;
					
					this.setChanged();
					this.notifyObservers();
					}
				}	
				break;
			 }		  
		 }
	}
	private SpriteLOL getSpriteByPosition( int X, int Y ){
	
		for (SpriteLOL lol : spriteLOLlist) {	
			int x = lol.getX();
			int y = lol.getY();
			if ( (X == x) && (Y == y) )	return lol;
			}
		return null;
	}
	
	
	private SpriteLOL getSpriteByType(String Type){
		
		for (SpriteLOL lol : spriteLOLlist) {	
			
			if ( lol.Type.equals(Type) )
				return lol;
			}
		return null;
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
	/* public void loadMessage(final String key) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMessage(daoHelloWorld.find(key).getMessage());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}*/

	public ArrayList<SpriteLOL> GetSpriteList(){
		ArrayList<SpriteLOL> A = new ArrayList<SpriteLOL>();
		
		try {
			Connection cnx = jpublankprojectDB();
			
		    Statement stmt = null;
		    String query = "select ID_Object, ID_Map, ID_Type, " +
		                   "AXIS_X, AXIS_Y " +
		                   "from map WHERE ID_Map =" + Integer.toString(IDmap);
	        stmt = cnx.createStatement();
	        ResultSet rs = stmt.executeQuery(query);

	        while (rs.next()) {
	        	
	            A.add(new SpriteLOL(rs.getString("ID_Type").trim(),rs.getInt("AXIS_X"),rs.getInt("AXIS_Y")));

	        }
		}
	        catch (final SQLException e) {
				e.printStackTrace();
			}
		return A;
		}

	//	NW_MOBIL.
	public ArrayList<SpriteLOL> GetSpriteLOLList(){
		
		//	SW_MODIF
		//System.out.println("Model.GetSpriteLOLList()");
		
		ArrayList<SpriteLOL> A = spriteLOLlist;
		return A;
		}

	public void loadMap () { 
		int ID_Map = this.getIDmap();
		spritelist = new ArrayList<String>();
		try {
			Connection cnx = jpublankprojectDB();
			
		    Statement stmt = null;
		    String query = "select ID_Object, ID_Map, ID_Type, " +
		                   "AXIS_X, AXIS_Y " +
		                   "from map WHERE ID_Map =" + Integer.toString(ID_Map);
	        stmt = cnx.createStatement();
	        ResultSet rs = stmt.executeQuery(query);

	        int i = 0;

	        while (rs.next()) {
	            String typeId = rs.getString("ID_Type");
	            spritelist.add(typeId);
	        }
	        

			;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return;
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

	private ArrayList<String> getSpriteList() {
		  
		  ArrayList<String> A = new ArrayList<String>();
		  ArrayList<Integer> X = new ArrayList<Integer>();
		  ArrayList<Integer> Y = new ArrayList<Integer>();

		  try {
		   Connection cnx = jpublankprojectDB();

		   Statement stmt = null;
		   String query = "select ID_Object, ID_Map, ID_Type, AXIS_X, AXIS_Y " + 
		         "from map WHERE ID_Map = " + Integer.toString( IDmap );
		   stmt = cnx.createStatement();
		   ResultSet rs = stmt.executeQuery(query);

		   while (rs.next()) {

		    A.add(rs.getString("ID_Type").trim());
		    X.add(rs.getInt("AXIS_X"));
		    Y.add(rs.getInt("AXIS_Y"));

		   }
		  } catch (final SQLException e) {
		   e.printStackTrace();
		  }
		  System.out.println("Model.getSpriteList() : IDmap = " + IDmap + ", Nb Sprites = " + A.size());
		  
		  spritelist = A;
		  //spritelistX = X;
		  //spritelistY = Y;
		  
		  // Indicate that the object has changed to all Observers.
		  //this.setChanged();
		  //this.notifyObservers();
		  
		  //System.out.println( "Model.GetSpriteList() : Nb d'observateurs = " + this.countObservers() );
		  
		  return A;
		 }

	//	NW_MOBIL.
	private ArrayList<SpriteLOL> getSpriteLOLList() {
		  
		ArrayList<SpriteLOL> A = new ArrayList<SpriteLOL>();
		
		try {
			Connection cnx = jpublankprojectDB();
			
		    Statement stmt = null;
		    String query = "select ID_Object, ID_Map, ID_Type, " +
		                   "AXIS_X, AXIS_Y " +
		                   "from map WHERE ID_Map =" + Integer.toString(IDmap);
	        stmt = cnx.createStatement();
	        ResultSet rs = stmt.executeQuery(query);

	        while (rs.next()) {
	        	
	            A.add(new SpriteLOL(rs.getString("ID_Type").trim(),rs.getInt("AXIS_X"),rs.getInt("AXIS_Y")));

	        }
		}
	        catch (final SQLException e) {
				e.printStackTrace();
			}
		return A;
		

		 }

}




