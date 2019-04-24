package csc2a.model;

import csc2a.designpatterns.iRenderVisitor;
import javafx.scene.paint.Color;

public class Nurse extends GameObject {
	
	public Nurse(int x, int y)
	{
		super(x,y,50,80,Color.RED,"NURSE");
	}
	
	@Override
	public void accept(iRenderVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.render(this);
		
	}

}
