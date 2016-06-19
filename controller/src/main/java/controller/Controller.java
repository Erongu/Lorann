package controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc

public class Controller implements IController {

	/** The view. */
	private IView	view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		
		//this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
		
		System.out.println("Controller.control()" );
		
	
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		
		switch (controllerOrder) {
			case Level1:
				this.model.setIDmap(1);
				spritelist = this.model.loadMap();
				break;
			case Level2:
				this.model.setIDmap(2);
				spritelist = this.model.loadMap();
				break;
			case Level3:
				this.model.setIDmap(3);
				spritelist = this.model.loadMap();
				break;
			case Level4:
				this.model.setIDmap(4);
				spritelist = this.model.loadMap();
				break;
			case Level5:
				this.model.setIDmap(5);
				spritelist = this.model.loadMap();
				break;
			default:
				this.model.setIDmap(0);
				spritelist = this.model.loadMap();
				break;
		}
		System.out.println(spritelist.toString());	
	}

}
