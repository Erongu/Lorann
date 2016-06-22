package contract;

import java.util.ArrayList;
import java.util.Observable;

/**
 * The Interface IModel.
 * @param <SpriteLOL> spritelol
 *
 *
 */
public interface IModel<SpriteLOL> {

/** 
* Load the map.
* @param iD_Map idmap
*/
/**
 * 
 * @return collection of the sprite
 */
	public ArrayList<SpriteLOL> GetSpriteList();
/**
* setIDmap
* @param iDmap  idmap
*/
	public void setIDmap(int iDmap);
/*
 * Initialize IDMap		
 * 
 */
	public int getIDmap();

/**
* Gets the observable.
*
* @return the observable
*/
	Observable getObservable();
/*
 * Initialize Score
 * 
 */
	public int getScore();
	
	public ArrayList<SpriteLOL> GetSpriteLOLList();
/**
* setLorannMove
* @param i  X
* @param j  Y
*/
	public void setLorannMove(int i, int j);
	
	public void FireballManager();
}
