package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame	viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {

		System.out.println("ViewPanel() : " + viewFrame.toString() );
		
		setBorder( BorderFactory.createLineBorder(Color.blue,2) );
		
		//	MW_HS :
		setLayout(null);
		viewFrame.setLayout(null);
	    JPanel spriteB = new JPanel();
	    JLabel labell1 = new JLabel();
	    labell1.setIcon(new ImageIcon("C:/sprite/bone.png"));
	    labell1.setLocation( 0, 0);
	    labell1.setSize(32, 32);
	    spriteB.add(labell1);
	    viewFrame.add( spriteB );	
	    
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}
	
	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		
		System.out.println("ViewPanel.update()");
		
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		
		System.out.println("ViewPanel.paintComponent( ) : " + graphics.toString());
		
		//graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.drawString( "Message" /*this.getViewFrame().getModel().getMessage()*/, 10, 20) ;
		
		setLayout(null);
		
		//System.out.println( "CreateSprite()" );
	    JPanel spriteB = new JPanel();
	    JLabel labell1 = new JLabel();
	    labell1.setIcon(new ImageIcon("C:/sprite/bone.png"));
	    labell1.setLocation( 0, 0);
	    labell1.setSize(32, 32);
	    spriteB.add(labell1);
	    this.setLayout(null);
	    this.add(spriteB);	

	}
	
}
