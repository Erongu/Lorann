package contract;

import java.util.ArrayList;
import java.util.Observable;

//import model.Sprite.RunningThread;

/**
 * The Interface IModel.
 * @param <SpriteLOL>
 *
 *
 */
public interface IModel<SpriteLOL> {

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	String getMessage();

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	void loadMessage(String key);
	
	public void loadMap ();
	
	public ArrayList<SpriteLOL> GetSpriteList();
	
	public void setIDmap(int iDmap);
	
	public int getIDmap();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
