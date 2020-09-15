package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	public double x,y;
	public int width, higth;
	public double dx,dy;
	public double speed = 1.7;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y =y;
		this.width =5;
		this.higth = 5;
		
		int angle = new Random().nextInt(120 - 45) + 45 + 1;
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}
	
	public void tick() {
		
	   if (x+(dx*speed) + width >= Game.WIDTH) {
		   dx*=-1;
	   }else if(x+(dx*speed) < 0) {
		   dx*=-1;
	   }
	   
	   
	   if(y >= Game.HEIGHT) {
		   System.out.println("Ponto da CPU");
		   new Game();
		   return;
	   }  else if(y < 0 ) {
		   System.out.println("Ponto da Jogador");
		   new Game();
		   return;
	   }
	   
	   
	   Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)), width, higth);
	   Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.higth);
	   Rectangle boundsEnemy  = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.higth);
	   
	   if(bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt(120 - 45) + 45 + 1;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			
			if(dy > 0) {
				
				dy*=-1;
			}
		   
	   }else if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(120 - 45) + 45 + 1;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			
			if(dy < 0) {
				
				dy*=-1;
			}
	   }
	   
	   x+=dx*speed;
	   y+=dy*speed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int)x, (int)y, width, higth);
	}

}
