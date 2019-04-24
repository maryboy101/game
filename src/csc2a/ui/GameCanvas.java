package csc2a.ui;

import csc2a.designpatterns.RenderGameObjectVisitor;
import csc2a.file.Images;
import csc2a.model.GameObject;
import csc2a.model.GameObjectContainer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * 
 * Canvas used to render all of your GameObjects using the Visitor
 * This is the Client in the Visitor Design Pattern
 * @author  <YOUR DETAILS HERE>
 *
 */
public class GameCanvas extends Canvas{
	
	//Attributes
	RenderGameObjectVisitor visitor = null;
	/* TODO: Store all of your GameObjects (Using GameObjectContainers) here */
	
	/**
	 * Default Constructor
	 */
	public GameCanvas() {
		this.setHeight(600);
		this.setWidth(800);
		visitor= new RenderGameObjectVisitor();
		this.items = new GameObjectContainer<GameObject>();
	}
	
	/* TODO: Set your GameObjects and redrawCanvas() */
	GameObjectContainer<GameObject> items = null;
	
	public void setItems(GameObjectContainer<GameObject> items)
	{
		this.items = items;
		redrawCanvas();
	}
	
	/**
	 * Method used to redraw the canvas whenever called
	 */
	public void redrawCanvas(){
		
		/* TODO: Get GraphicsContext */
		GraphicsContext gc = this.getGraphicsContext2D();
		/* TODO: Set Visitor's GraphicsContext */
		visitor.setGraphicsContext(gc);
		//gc.setFill(Color.ANTIQUEWHITE);
		//gc.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		gc.drawImage(Images.getBackground(), 0, 0,this.getWidth(), this.getHeight());
		/* TODO: Iterate through ALL GameObjects (Using GameObjectContainers) */
		for(GameObject o:items)
		{
			/* TODO: Get EACH GameObject to accept() the Visitor */
			o.accept(visitor);
		}
			
	}
	
	
}
