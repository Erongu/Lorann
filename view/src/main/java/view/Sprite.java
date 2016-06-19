package view;

public class Sprite {
		public int x;
		public int y;
		
		public String imgLG;
		public int spriteType;
		
		private RunningThread runner=null;  
		
		
		private void DisplayThread(){
			
		}
		private void move(){
			//start the movement for every type of thread
			
		}
		
		private void stop(){
			//stop the movement
			
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
