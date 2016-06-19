package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Sprite;

class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame	viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	private static final ImageObserver ImageObserver = null;

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
	 *b 
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
		//graphics.drawString( "Message" /*this.getViewFrame().getModel().getMessage()*/, 10, 20) ;
		
		  
		  System.out.println( "ViewPanel.paintComponent( ) : DrawImage()" );
		  
		  // NW_EXEAMPLE - Display a sprite.
		  
		  Toolkit tk = Toolkit.getDefaultToolkit();
		        //Gif, Jpeg ou png.
		  
		  java.awt.Image imgL = tk.getImage("c:/sprite/lorann_b.png");
		  java.awt.Image imgLG = tk.getImage("c:/sprite/lorann_GIF.gif");
		  java.awt.Image imgB = tk.getImage("c:/sprite/bone.png");
		  java.awt.Image imgBH = tk.getImage("c:/sprite/horizontal_bone.png") ;
		  java.awt.Image imgBV = tk.getImage("c:/sprite/vertical_bone.png");
		  java.awt.Image imgP = tk.getImage("c:/sprite/purse.png");
		  java.awt.Image imgCB = tk.getImage("c:/sprite/crystal_ball.png");
		  java.awt.Image imgM1 = tk.getImage("c:/sprite/monster_1");
		  java.awt.Image imgM2 = tk.getImage("c:/sprite/monster_2");
		  java.awt.Image imgM3 = tk.getImage("c:/sprite/monster_3");
		  java.awt.Image imgM4 = tk.getImage("c:/sprite/mosnter_4");
		  
		  // Image is load on first use.
		  
		  MediaTracker mt = new MediaTracker(this);
		  
		  mt.addImage(imgL, 1);
		  mt.addImage(imgB, 2);
		  mt.addImage(imgLG, 3);
		  mt.addImage(imgBH, 4);
		  mt.addImage(imgBV, 5);
		  mt.addImage(imgP, 6);
		  mt.addImage(imgCB, 7);
		  mt.addImage(imgM1, 8);
		  mt.addImage(imgM2, 9);
		  mt.addImage(imgM3, 10);
		  mt.addImage(imgM4, 11);
		  
		  try {
		     mt.waitForID(0);         // Image is in memory.
		  } 
		  
		  catch(InterruptedException e) {} 
		 System.out.println(this.viewFrame.getModel().getIDmap());
		 
		 Sprite sprite = new Sprite( 40, 40, "BH", "c:/sprite/lorann_b.png", graphics );
		 sprite.demarre();

		 
		 /* while(1=0){
			  
			  if(ID_Type = "B")
				  BufferedImage bimgB = new BufferedImage( imgB.getWidth(viewFrame), imgB.getHeight(viewFrame), BufferedImage.TYPE_INT_RGB);
			  graphics.drawImage(imgB, Axis_X, Axis_Y, viewFrame);
			  else if (ID_Type = "BH")
				  BufferedImage bimgBH = new BufferedImage( imgBH.getWidth(viewFrame), imgBH.getHeight(viewFrame), BufferedImage.TYPE_INT_RGB);
			  graphics.drawImage(imgBH, Axis_X, Axis_Y, viewFrame);
			  else if(ID_Type = "BV")
				  BufferedImage bimgP = new BufferedImage( imgP.getWidth(viewFrame), imgP.getHeight(viewFrame), BufferedImage.TYPE_INT_RGB);
			  graphics.drawImage(imgP, Axis_X, Axis_Y, viewFrame);
			  else if(ID_Type = "CB")
				  BufferedImage bimgCB = new BufferedImage( imgCB.getWidth(viewFrame), imgCB.getHeight(viewFrame), BufferedImage.TYPE_INT_RGB);
			  graphics.drawImage(imgCB, Axis_X, Axis_Y, viewFrame);
			  else if(ID_Type = "M1")
				  BufferedImage bimgM1 = new BufferedImage( imgM1.getWidth(viewFrame), imgM1.getHeight(viewFrame), BufferedImage.TYPE_INT_RGB);
			  graphics.drawImage(imgM1, Axis_X, Axis_Y, viewFrame);
			  else if(ID_Type = "M2")
				  BufferedImage bimgM2 = new BufferedImage( imgM2.getWidth(viewFrame), imgM2.getHeight(viewFrame), BufferedImage.TYPE_INT_RGB);
			  graphics.drawImage(imgM2, Axis_X, Axis_Y, viewFrame);
			  else if(ID_Type = "M3")
				  BufferedImage bimgM3 = new BufferedImage( imgM3.getWidth(viewFrame), imgM3.getHeight(viewFrame), BufferedImage.TYPE_INT_RGB);
			  graphics.drawImage(imgM3, Axis_X, Axis_Y, viewFrame);
			  else if(ID_Type = "M4")
				  BufferedImage bimgM4 = new BufferedImage( imgM4.getWidth(viewFrame), imgM4.getHeight(viewFrame), BufferedImage.TYPE_INT_RGB);
			  graphics.drawImage(imgM4, Axis_X, Axis_Y, viewFrame);  
		  }*/
		 
		 //ImageObserver IO = ImageObserver;
		 
		  BufferedImage bimgLG = new BufferedImage( 32, 32, BufferedImage.TYPE_INT_RGB);
		  graphics.drawImage( imgB, 0, 0, viewFrame );
		  
		 }

	}