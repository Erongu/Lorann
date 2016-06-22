package view;

import java.awt.event.KeyEvent;
import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

public class View implements IView, Runnable {

	// The frame
	private final ViewFrame viewFrame;

	 /* Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		
		System.out.println("View()");
				
		this.viewFrame = new ViewFrame(model);
	    
		SwingUtilities.invokeLater(this);	
	}
	
/**
* Key code to controller order.
*
* @param keyCode
*          the key code
* @return the controller order
*/

	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		System.out.println("Clavier = "+ Integer.toString(keyCode));
		switch (keyCode) {

			case KeyEvent.VK_1:
				return ControllerOrder.Level1;
			case KeyEvent.VK_2:
				return ControllerOrder.Level2;
			case KeyEvent.VK_3:
				return ControllerOrder.Level3;
			case KeyEvent.VK_4:
				return ControllerOrder.Level4;
			case KeyEvent.VK_5:
				return ControllerOrder.Level5;
				
			case KeyEvent.VK_SPACE:
				return ControllerOrder.Fireball;
				
			case KeyEvent.VK_NUMPAD4:
				return ControllerOrder.Left;
			case KeyEvent.VK_NUMPAD8:
				return ControllerOrder.Up;
			case KeyEvent.VK_NUMPAD2:
				return ControllerOrder.Down;
			case KeyEvent.VK_NUMPAD6:
				return ControllerOrder.Right;
			case KeyEvent.VK_NUMPAD9:
				return ControllerOrder.UpRight;
			case KeyEvent.VK_NUMPAD7:
				return ControllerOrder.UpLeft;
			case KeyEvent.VK_NUMPAD3:
				return ControllerOrder.DownRight;
			case KeyEvent.VK_NUMPAD1:
				return ControllerOrder.DownLeft;
				
				
			default:
				return ControllerOrder.Default;
		}		
	}
	/**
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.getModel().setIDmap(Integer.parseInt( message ));
	}
/** 
*Running the Frame
* @see java.lang.Runnable#run()
*/
	public void run() {
		this.viewFrame.setVisible(true);
	}
/**
* Sets the controller.
*
* @param controller
*          the new controller
*/
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
