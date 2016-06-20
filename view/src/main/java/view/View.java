package view;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import javafx.scene.paint.Color;

public class View implements IView, Runnable {

	/** The frame. */
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
			default:
				return ControllerOrder.Default;
		}		
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.getModel().setIDmap(Integer.parseInt( message ));
	}
	/*
	 * (non-Javadoc)
	 *
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
