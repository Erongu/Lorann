package contract;

import java.util.ArrayList;
import java.util.Observable;

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

	public ArrayList<SpriteLOL> GetSpriteList();
/**
* setIDmap
* @param iDmap
*/
	public void setIDmap(int iDmap);
/**
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
/**
 * Initialize Score
 * @return
 */
	public int getScore();
	
	public ArrayList<SpriteLOL> GetSpriteLOLList();
/**
* setLorannMove
* @param i
* @param j
 */
	public void setLorannMove(int i, int j);
	
	public void FireballManager();
}
