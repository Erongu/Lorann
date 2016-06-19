package contract;

import java.util.ArrayList;
import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

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
	
	public void GetSpriteList();
	
	public void setIDmap(int iDmap);
	
	public int getIDmap();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
