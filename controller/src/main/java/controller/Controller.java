package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;


public class Controller implements IController {

/** The view. */
	private IView	view;

/** The model. */
	private IModel	model;
	
/** Current Level */
	
private int LevelId;

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
/**
* 
* @see contract.IController#control()
*/
	public void control() {
		
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
/**
* link : keyboard && loading map
* @see setIDmap, loadMap
* @param controllerOrder
* 
* @see contract.IController#orderPerform(contract.ControllerOrder)
*/
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case Level1:
				setLevelId(1);
				this.model.setIDmap(1);
				this.view.printMessage("1");
				break;
			case Level2:
				setLevelId(2);
				this.model.setIDmap(2);
				this.view.printMessage("2");
				break;
			case Level3:
				setLevelId(3);
				this.model.setIDmap(3);
				this.view.printMessage("3");
				break;
			case Level4:
				setLevelId(4);
				this.model.setIDmap(4);
				this.view.printMessage("4");
				break;
			case Level5:
				setLevelId(5);
				this.model.setIDmap(5);
				this.view.printMessage("5");
				break;
				
			case Right:
				this.model.setLorannMove( 1, 0 );
				break;
			case Left:
				this.model.setLorannMove( -1, 0 );
				break;
			case Up:
				this.model.setLorannMove( 0, -1 );
				break;
			case Down:
				this.model.setLorannMove( 0, 1 );
				break;
			case UpLeft:
				this.model.setLorannMove( -1, -1 );
				break;
			case UpRight:
				this.model.setLorannMove( 1, -1 );
				break;
			case DownLeft:
				this.model.setLorannMove( -1, 1 );
				break;
			case DownRight:
				this.model.setLorannMove( 1, 1 );
				break;
			default:
				break;
			case Fireball:
				System.out.println("Fireballllllllll");
				break;
		}
	}
/**
* Choice of Level
* @param levelId
*/
	public void setLevelId(int levelId){
		LevelId = levelId;
	}
}
