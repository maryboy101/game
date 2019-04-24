package csc2a.designpatterns;

import csc2a.model.Block;
import csc2a.model.Nurse;
import csc2a.model.Player;

/**
 * 
 * AbstractVisitor interface
 * Used to define all of the render functions for your different GameObjects
 * @author  <YOUR DETAILS HERE>
 *
 */
public interface iRenderVisitor {
	
	/* TODO: render(YourGameObjectA a); method */
	void render(Player player);

	void render(Block block);

	void render(Nurse nurse);

	

	
	
	
	/* TODO: render(YourGameObjectB b); method */
	
	// ...
	
	/* TODO: render(YourGameObjectC c); method */
}
