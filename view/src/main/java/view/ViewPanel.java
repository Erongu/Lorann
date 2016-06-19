package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
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
	
	 /* @see java.util.Observer#update(java.util.Observable, java.lang.Object)
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
		//graphics.drawString( "Message" /*this.getViewFrame().getModel().getMessage()*/, 10, 20) ;
		
		  
		  System.out.println( "ViewPanel.paintComponent( ) : DrawImage()" );
		  
		  // NW_EXEAMPLE - Display a sprite.
		  
		  Toolkit tk = Toolkit.getDefaultToolkit();
		  java.awt.Image img = tk.getImage("c:/sprite/bone.png");        //Gif, Jpeg ou png.
		  java.awt.Image imgL = tk.getImage("c:/sprite/lorann_b.png");
		  java.awt.Image imgLG = tk.getImage("c:/sprite/lorann_GIF.gif");
		  // Image is load on first use.
		  
		  MediaTracker mt = new MediaTracker(this);
		  mt.addImage(imgL, 5);
		  mt.addImage(img, 5);
		  mt.addImage(imgLG, 5);
		  try {
		     mt.waitForID(0);         // Image is in memory.
		  } 
		  
		  catch(InterruptedException e) {}
		  
		  BufferedImage bimg = new BufferedImage( img.getWidth(viewFrame), img.getHeight(viewFrame), BufferedImage.TYPE_INT_RGB);
		  graphics.drawImage(img, 0, 0, viewFrame);
		  BufferedImage bimgL = new BufferedImage( imgL.getWidth(viewFrame), imgL.getHeight(viewFrame), BufferedImage.TYPE_INT_RGB);
		  graphics.drawImage(imgL, 32, 0, viewFrame);
		  BufferedImage bimgLG = new BufferedImage( imgLG.getWidth(viewFrame), imgLG.getHeight(viewFrame), BufferedImage.TYPE_INT_RGB);
		  graphics.drawImage(imgLG, 32*5, 0, viewFrame);
		  
		 }
	}
	

