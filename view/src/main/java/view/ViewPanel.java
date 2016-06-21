package view;
import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

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
* 
* @param viewFrame
*          the new view frame
*/
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

/**
* 
*
* @see java.util.Observer#update(java.util.Observable, java.lang.Object)
*/
	public void update(final Observable arg0, final Object arg1) {
		
		System.out.println("ViewPanel.update()");
		
		this.repaint();
		}
/**
* Draw Sprite
* @param Graphics
*/
	protected void paintComponent(final Graphics graphics ) {
		
		//this.viewFrame.getModel().setMonsterMove();
		System.out.println("ViewPanel.paintComponent( ) : " + graphics.toString());
		int idMap = this.viewFrame.getModel().getIDmap();
		
		graphics.setColor(Color.black);
	    graphics.fillRect(0, 0,1000, 1000);
	    graphics.setColor(Color.white);
	    
	    Font fonte = new Font("TimesRoman", Font.BOLD,20);
		graphics.setFont(fonte);	
		
		ArrayList<SpriteLOL> spriteList = this.viewFrame.getModel().GetSpriteLOLList();
	
	    if( idMap == 0 ) 
	    	{
	    	if(spriteList.size() > 0 ) 
	    		graphics.drawString( "Score : " + this.getViewFrame().getModel().getScore()+ " - Game Over", 10, 12*32+40) ;
	    	else {
	    		graphics.drawString("To start : press key : 1 ,2 ,3 ,4 ,5 for loading a level", 10, 12*32+40);
	    	}
	    	return;
	    	}
	    else graphics.drawString( "Score : " + this.getViewFrame().getModel().getScore() , 10, 12*32+40) ;
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
		  java.awt.Image imgGU = tk.getImage("c:/sprite/gate_open.png");
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
		  mt.addImage(imgGU, 13);
		  
		  try {
		     mt.waitForID(0);         // Image is in memory.
		  } 
		  
		  catch(InterruptedException e) {} 
		  
		 System.out.println( "Id_Map = " + idMap);
		 
		 if (spriteList != null){
		 
		 for (SpriteLOL lol : spriteList) {
			  
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
			  else if(lol.getType().equals("P")){
			  graphics.drawImage(imgP, lol.getX()*32,lol.getY()*32 , viewFrame);
			  }
			  else if(lol.getType().equals("GU"))
				  graphics.drawImage(imgGU, lol.getX()*32,lol.getY()*32 , viewFrame);

		 }
			  //	Same for Movable sprite

			for (SpriteLOL lol : spriteList) {
				  if(lol.getType().equals("L"))
				  {
				  graphics.drawImage(imgLG, lol.getX()*32,lol.getY()*32 , viewFrame);  
				  }
			}
		 }
	}
}