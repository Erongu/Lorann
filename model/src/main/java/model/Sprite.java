package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Sprite {
	public int X;
	public int Y;
	
	public Image imgLG;
	public BufferedImage bimgLG;
	public String spriteType;
	
	private RunningThread runner = null; 
	private boolean running;
    
	
	public void demarre(){
		//start the movement for every type of thread
    	//if thread isn't started ==> instance it again
    	if(running==false)
    		{
	       	running=true;
	       	System.out.println("demarre");
	        runner = new RunningThread();
	      
            }

	}
	
	private void stop(){
		//stop the movement
		
		System.out.println("Stop");
		
	}
	
	//	Draw the sprite
    public void paint( Graphics g, ImageObserver imgObserver ){
    
    	
    	System.out.println("Sprite.paint()");
    	
    	
    	//BufferedImage bimgLG = new BufferedImage( 32, 32, BufferedImage.TYPE_INT_RGB);

		 //Graphics.drawImage(imgLG, 0, 0, viewFrame );


    	
    	g.drawImage( imgLG, X, Y, imgObserver );
    }

	private class RunningThread extends Thread{
		private RunningThread(){
			start();
		}
		//move the object
		public void run(){
			
			//rules of object and propriety
			//IF (type = fireball) so... It's here that every kind of thread is written
			// Have to start here for comportment
			
			//if(spriteType = M1 )
			//	int x, y;
				System.out.println( "Sprite.Run() - X = " + X + ", Y = " + Y);
				X = X+1;
				Y = Y+1;
			
			try {
				sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void sleep(int milliseconds){
		sleep(milliseconds); // use for not overload the CPU memory 
	}
	
	
}
