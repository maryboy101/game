package csc2a.designpatterns;

import csc2a.file.Images;
import csc2a.model.Block;
import csc2a.model.Nurse;
import csc2a.model.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * ConcreteVisitor class
 * Used to visit each GameObject and render them onto the GameCanvas
 * @author  <YOUR DETAILS HERE>
 *
 */
public class RenderGameObjectVisitor implements iRenderVisitor{
	
	//Attributes
	GraphicsContext gc = null;
	
	/**
	 * Mutator for the GraphicsContext from the GameCanvas
	 * Used to set gc so the Visitor can draw things on the Canvas
	 * @param gc the GraphicsContext from the GameCanvas
	 */
	public void setGraphicsContext(GraphicsContext gc) {
		this.gc = gc;
	}
	
		
	/**
	 * @return
	 */
	public GraphicsContext getGc() {
		return gc;
	}

	/* TODO: render(YourGameObjectA a){} method */
	@Override
	public void render(Player player) 
		{
			// TODO Auto-generated method stub	
		double x = player.getXLocation();
		double y = player.getYLocation();
		if (player.getFacing()== 1) {
			gc.drawImage(Images.getPlayer(),x,y,player.getWidth(),player.getHeight());

		} else if (player.getFacing()== -1) {
			
			gc.drawImage(Images.getPlayer(),x,y,player.getWidth(),player.getHeight());
		}
		
		}


	@Override
	public void render(Block block) {
		// TODO Auto-generated method stub
		double x = block.getXLocation();
		double y = block.getYLocation();
		gc.drawImage(Images.getBlock(),x,y,block.getWidth(), block.getHeight());
	}


	@Override
	public void render(Nurse nurse) {
		// TODO Auto-generated method stub
		double x = nurse.getXLocation();
		double y = nurse.getYLocation();
		gc.drawImage(Images.getNurse(),x, y,nurse.getWidth(), nurse.getHeight());
	}

			
	/* TODO: render(YourGameObjectB b){} method */
	
	// ...
	
	/* TODO: render(YourGameObjectC m){} method */
	
	
		
	}
	
	
	
	


