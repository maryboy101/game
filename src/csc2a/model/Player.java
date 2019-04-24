package csc2a.model;

import csc2a.designpatterns.iRenderVisitor;
import javafx.scene.paint.Color;

public class Player extends GameObject {
	private int health = 3;
	private int facing = 1;
	boolean left = false,right=false,jump=false,  falling=false;
	GameObjectContainer<GameObject> object;
	
	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public boolean isJump() {
		return jump;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setJump(boolean jump) {
		this.jump = jump;
	}

	public Player(int x, int y,int h,GameObjectContainer<GameObject> object)
	{
		super(x,440,50,80,Color.BLUE,"PLAYER");
		this.object = object;
		health = h;
	}
	
	public void moveLeft() {
        setTranslateX(getTranslateX() - 50);
        collision(object);
    }

    public void moveRight() {
        setTranslateX(getTranslateX() + 50);
        collision(object);
    }
    
    public void jumping()
    {
    	if(getTranslateY() < 350)
    	{
    		System.out.println(getTranslateY());
    		jump = false;
    		falling = true;
    		return;
    	}
    	setTranslateY(getTranslateY() - 25);
    	collision(object);
    	System.out.println("jump");
    }

    public void falling()
    {
    	setTranslateY(getTranslateY()+10);	
    	collision(object);
    }
    
    private void collision(GameObjectContainer<GameObject> object) {
		// used to check for any player collision
    	GameObject renderObject = null;
		for (int i = 0; i < object.getSize(); i++) {
			renderObject = object.iterator().next();

			if (renderObject.getType() == "BLOCK") {
				if (this.getBoundsInParent().intersects(renderObject.getBoundsInParent())) {
					System.out.println("intersected");
					this.setTranslateY(renderObject.getTranslateY() - renderObject.getHeight());
					falling = false;
					jump = false;
				} else {
					falling = true;
				}

			}
			if (renderObject.getType() == "NURSE") {
				if (this.getBoundsInParent().intersects(renderObject.getBoundsInParent())) {
					System.out.println("nurse");
				} else {

				}

			}else {
				falling = false;
			}
			
		}
    }
    
    
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getFacing() {
		return facing;
	}
	public void setFacing(int facing) {
		this.facing = facing;
	}
	
	@Override
	public void accept(iRenderVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.render(this);
		
	}
	
	
}