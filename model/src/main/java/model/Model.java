package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;

import contract.IModel;

/**
 * Composed by : 1. Initialization 
 * 				 2. Display Map 
 * 				 3. Movement Sprite
 * The Class Model.
 *
 */
public class Model extends Observable implements IModel{
/**
 * 1. Initialization 
 */
	/** The message */
	private String message;
	
	
	public ArrayList<SpriteLOL> spriteLOLlist = new ArrayList<SpriteLOL>();

	private int score;
	
	private int IDmap;

	public int getIDmap() {
		return IDmap;
	}
	public int getScore(){
		return score;
	}
/**
 * Setter IDmap
 * @param iDmap
 */
	public void setIDmap(int iDmap) {
		Boolean change = (IDmap != iDmap); 
		IDmap = iDmap;
		  
		if (change == true){
		
		spriteLOLlist = getSpriteLOLList( );
		score = 0;
		this.setChanged();
		this.notifyObservers();
		}
	}
/**
* Instantiates a new model.
*/
	public Model() {
		this.message = "";
	}
/**
* getter : Write a message
*
* @see contract.IModel#getMessage()
*/
	public String getMessage() {
		return this.message;
	}
/**
* Set the message.
*
* @param message
*          the new message
*/
	private void setMessage(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}

/**
* 
*
* @see contract.IModel#getObservable()
*/
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
/**
 * 2. Display Map
 * 
* Get the Level Collection Sprite 
*/
	
public ArrayList<SpriteLOL> GetSpriteLOLList(){
		
		ArrayList<SpriteLOL> A = spriteLOLlist;
		return A;
		}
	
	public Observable getObservable() {
		return this;
	}
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
/**
 * Private method : Get the Level Collection Sprite
 * @return A
 */
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
/**
 * 3. Movement Sprite
 * 
 * Movement Lorann + changment Purse + Changment Gate
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
					score += 2000;
					
					this.setChanged();
					this.notifyObservers();
					
				}
					else if(spriteInCase.Type.equals("GU") || spriteInCase.Type.equals("M1") || spriteInCase.Type.equals("M2") || spriteInCase.Type.equals("M3") || spriteInCase.Type.equals("M4"))
					{
						System.out.println("map 0 ");
					IDmap = 0;
					
					if(spriteInCase.Type.equals("GU")) score += 2000;
					
					this.setChanged();
					this.notifyObservers();
					}
					
				}	
				break;
			 }		  
		 }
	}
/**
 * Search by Position
 * @param X
 * @param Y
 * @return
 */
	private SpriteLOL getSpriteByPosition( int X, int Y ){
	
		for (SpriteLOL lol : spriteLOLlist) {	
			int x = lol.getX();
			int y = lol.getY();
			if ( (X == x) && (Y == y) )	return lol;
			}
		return null;
	}
	
	/**
	 * Search by Sprite Type
	 * @param Type
	 * 
	 */
	private SpriteLOL getSpriteByType(String Type){
		
		for (SpriteLOL lol : spriteLOLlist) {	
			
			if ( lol.Type.equals(Type) )
				return lol;
			}
		return null;
	}
	

}




