package contract;

import java.util.ArrayList;
import java.util.Observable;

//import model.SpriteLOL;

//import model.Sprite.RunningThread;

/**
 * The Interface IModel.
 * @param <SpriteLOL>
 *
 *
 */
public interface IModel<SpriteLOL> {

	/** 
	 * Load the map.
	 * @param ID_Map
	 */
	public void loadMap ();

	public ArrayList<SpriteLOL> GetSpriteList();
	/**
	 * setIDmap
	 * @param iDmap
	 */
	public void setIDmap(int iDmap);
	
	//public static Boolean permission;
	
	public int getIDmap();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	public int getScore();
	
	public ArrayList<SpriteLOL> GetSpriteLOLList();
	/**
	 * setLorannMove
	 * @param i
	 * @param j
	 */
	public void setLorannMove(int i, int j);
}
