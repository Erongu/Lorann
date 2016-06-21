
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
	/**
	 * Observable : use for see a statement 
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	

	}
	@Override
	public void loadMap() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList GetSpriteList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIDmap(int iDmap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIDmap() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList GetSpriteLOLList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLorannMove(int i, int j) {
		// TODO Auto-generated method stub
		
	}

}

