package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
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
import model.SpriteLOL;

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
		
	    graphics.setColor(Color.BLACK);
	    graphics.fillRect(0, 0,1000, 1000);
		  System.out.println( "ViewPanel.paintComponent( ) : DrawImage()" );
		  
		  // NW_EXEAMPLE - Display a sprite.
		  
		  Toolkit tk = Toolkit.getDefaultToolkit();
		        //Gif, Jpeg ou png.
		  
		  java.awt.Image imgL = tk.getImage("C:/sprite/lorann_b.png");
		  java.awt.Image imgLG = tk.getImage("C:/sprite/lorann_GIF.gif");
		  java.awt.Image imgB = tk.getImage("C:/sprite/bone.png");
		  java.awt.Image imgBH = tk.getImage("C:/sprite/horizontal_bone.png") ;
		  java.awt.Image imgBV = tk.getImage("C:/sprite/vertical_bone.png");
		  java.awt.Image imgP = tk.getImage("C:/sprite/purse.png");
		  java.awt.Image imgCB = tk.getImage("C:/sprite/crystal_ball.png");
		  java.awt.Image imgM1 = tk.getImage("C:/sprite/monster_1.png");
		  java.awt.Image imgM2 = tk.getImage("C:/sprite/monster_2.png");
		  java.awt.Image imgM3 = tk.getImage("C:/sprite/monster_3.png");
		  java.awt.Image imgM4 = tk.getImage("C:/sprite/monster_4.png");
		  java.awt.Image imgGL = tk.getImage("C:/sprite/gate_closed.png");
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
		  mt.addImage(imgGL, 12);
		  
		  try {
		     mt.waitForID(0);         // Image is in memory.
		  } 
		  
		  catch(InterruptedException e) {} 
		  
		 int idMap = this.viewFrame.getModel().getIDmap();
		  
		 System.out.println( "Id_Map = " + idMap);
		 
		// Sprite sprite = new Sprite( 40, 40, "BH", "c:/sprite/lorann_b.png", graphics );
		// sprite.demarre();
		 
		 //	NW_MOBIL.
		 //ArrayList<SpriteLOL> spriteList = this.viewFrame.getModel().GetSpriteList();
		 ArrayList<SpriteLOL> spriteList = this.viewFrame.getModel().GetSpriteLOLList();
		 
		 if (spriteList != null){
		 
		 for (SpriteLOL lol : spriteList) {
			  
			 //System.out.println(lol.getX()+"/"+  lol.getY()+lol.getType());
			  if(lol.getType().equals( "B")){
			  graphics.drawImage(imgB, lol.getX()*32, lol.getY()*32, viewFrame);
			  }
			  else if (lol.getType().equals("BH")){
			  graphics.drawImage(imgBH, lol.getX()*32, lol.getY()*32, viewFrame);
			  }
			  else if(lol.getType().equals("BV"))
			  {
			  graphics.drawImage(imgBV, lol.getX()*32, lol.getY()*32, viewFrame);
			  }
			  else if(lol.getType().equals("CB"))
			  {
			  graphics.drawImage(imgCB, lol.getX()*32, lol.getY()*32, viewFrame);
			  }
			  else if(lol.getType().equals("M1"))
			  {
			  graphics.drawImage(imgM1, lol.getX()*32, lol.getY()*32, viewFrame);
			  }
			  else if(lol.getType().equals("M2"))
			  {
			  graphics.drawImage(imgM2, lol.getX()*32, lol.getY()*32, viewFrame);
			  }
			  else if(lol.getType().equals("M3"))
			  {
			  graphics.drawImage(imgM3, lol.getX()*32, lol.getY()*32, viewFrame);
			  }
			  else if(lol.getType().equals("M4"))
			  {
			  graphics.drawImage(imgM4, lol.getX()*32,lol.getY()*32 , viewFrame);  
			  }
			  else if(lol.getType().equals("P"))
			  {
			  graphics.drawImage(imgP, lol.getX()*32,lol.getY()*32 , viewFrame);  
			  }
			  else if(lol.getType().equals("GL"))
			  {
			  graphics.drawImage(imgGL, lol.getX()*32,lol.getY()*32 , viewFrame);  
			  }

		 }
			  
			  //	Boucle des mobiles.
			  
			for (SpriteLOL lol : spriteList) {
				  if(lol.getType().equals("L"))
				  {
					  //	PROVISOIRE.
				  graphics.drawImage(imgLG, lol.getX()*32,lol.getY()*32 , viewFrame);  
				  }
					  
			}
			  
			  
		  
		 
		 //ImageObserver IO = ImageObserver;
		 
		  //BufferedImage bimgLG = new BufferedImage( 32, 32, BufferedImage.TYPE_INT_RGB);
		  //graphics.drawImage( imgB, 0, 0, viewFrame);
	}
}
}