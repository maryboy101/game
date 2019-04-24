package csc2a.model;

import csc2a.designpatterns.iRenderVisitor;
import javafx.scene.paint.Color;

public class Block extends GameObject {

	public Block(int x, int y) {
		super(x, y,50,50,Color.BROWN,"BLOCK");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void accept(iRenderVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.render(this);
	}
	
}
