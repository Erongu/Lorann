package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;

class ViewFrame extends JFrame implements KeyListener {

/** The model. */
	private IModel						model;
/** The controller. */
	private IController				controller;
/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;
	
/**
*  windows
*  @param model   model 
*  @throws HeadlessException    headlessexception 
*/
	
	public ViewFrame(final IModel model) throws HeadlessException {
		
		this.buildViewFrame( model );
		
		setSize(20*32+10,12*32+80);
		
		//	NW_MODIF : Background color of the main windows.
		setBackground( Color.BLACK );
		
		//	NW_MODIF - Place the windows in center.
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( dim.width/ 2 - this.getWidth() /2, dim.height / 2 - this.getHeight() /2 );

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		//	Add Menu for level selection.
		//setJMenuBar( new MenuSwing() );
		
	}
/**
* Instantiates a new view frame.
*
*  @param model
*          the model
*  @param gc 
*  			gc
*          
*/
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}
/**
* Instantiates a new view frame.
*
* @param model
*          the model
* @param title
*          the title
* @throws HeadlessException
*           the headless exception
*/
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}
/**
* Instantiates a new view frame.
*
* @param model
*          the model
* @param title
*          the title
* @param gc
*          the gc
*/
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

/**
* Gets the controller.
*
* @return controller   the new controller 
*/
	private IController getController() {
		return this.controller;
	}
/**
* Sets the new controller
*
* @param controller the new controller
*          
*/
	protected void setController(final IController controller) {
		this.controller = controller;
}
/**
* Gets the model.
*
* @return the model  the model
*/
	protected IModel getModel() {
		return this.model;
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
* Builds the view frame.
*
* @param model
*          the model
*/
	private void buildViewFrame(final IModel model) {
		
		System.out.println("buildViewFrame() - this = " + this.toString() );
		
		this.setLayout(null);
		
		this.setModel( model );
		
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setResizable(false);
		this.addKeyListener(this);
		
		ViewPanel vPanel = new ViewPanel(this);
		
		this.setContentPane(new ViewPanel(this));
		
		//this.setSize( 400 + this.getInsets().left + this.getInsets().right, 60 + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo( null );
	}
/**
* Prints the message.
*
* @param message
*          the message
*/
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

/**
 * KeyTyped
 * 
 * @param e keyevent 
 */
	public void keyTyped(final KeyEvent e) {

	}
/**
 * @param e keyevent
 */
	public void keyPressed(final KeyEvent e) {
		
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));	
	}
/**
* KeyReleased
*
* @param e keyevent e 
*/
	public void keyReleased(final KeyEvent e) {
	}
}
