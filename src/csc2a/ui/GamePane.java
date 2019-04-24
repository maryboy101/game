package csc2a.ui;

import java.io.File;

import csc2a.file.GameFileHandler;
import csc2a.model.Block;
import csc2a.model.GameObject;
import csc2a.model.GameObjectContainer;
import csc2a.model.Player;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * 
 * GamePane provides a custom container to manage all game interactions and host
 * the GameCanvas
 * 
 * @author <YOUR DETAILS HERE>
 *
 */
public class GamePane extends StackPane {

	// Attributes

	private GameCanvas canvas = null; // You need the canvas so the visitor can draw on it
	private Player player;
	private Block block;
	private GameObjectContainer<GameObject> itemsToDraw = new GameObjectContainer<GameObject>();
	private GameObjectContainer<GameObject> handler = null;
	private VBox vBox;
	

	/**
	 * Default constructor
	 */
	public GamePane() {
		super();
		vBox = new VBox();
		menu();
		// Create the canvas to draw on
		canvas = new GameCanvas();
		canvas.setWidth(800);
		canvas.setHeight(600);
		// Bind the width and height so the canvas resizes with window
		// canvas.widthProperty().bind(this.widthProperty());
		// canvas.heightProperty().bind(this.heightProperty());

		AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };

        timer.start();

        nextLevel();
		/* TODO: Construct your GamePane as you see fit */
		
		
		for (int i = 0; i < 20; i++) {
			block = new Block(i * 50, 520);
			itemsToDraw.addGameObject(block);
		}
		player = new Player(100, 100,3,itemsToDraw);
		itemsToDraw.addGameObject(player);

		this.setOnKeyPressed((event) -> {
            switch (event.getCode()) {
            case A:
                player.setLeft(true);
                break;
            case D:
                player.setRight(true);
                break;
            case SPACE:
                player.setJump(true);
                break;
			default:
				break;
        }
    });
		
		this.setOnKeyReleased((event) -> {
			 
			switch (event.getCode()) {
            case A:
                player.setLeft(false);
                break;
            case D:
                player.setRight(false);
                break;
			default:
				break;
			}
		});
		
		
		
		// Add canvas as a child of the Pane
		vBox.getChildren().add(canvas);
		// this.getChildren().add(canvas);
		this.setAlignment(Pos.TOP_CENTER);
		/* TODO: Finish setting up your GamePane */
		this.getChildren().add(vBox);
		
	}

	protected void update() {
		// TODO Auto-generated method stub
		if(this.player.isLeft()==true)
		{
			this.player.moveLeft();
		}if(this.player.isRight()==true)
		{
			this.player.moveRight();
		}if(this.player.isJump()==true)
		{
			this.player.jumping();
		}else if(this.player.isFalling() == true)
		{
			this.player.falling();
		}
		
		this.canvas.redrawCanvas();
	}

	private void nextLevel() {
		// TODO Auto-generated method stub
		
	}

	public void menu() {

		MenuBar mb = new MenuBar();

		Menu menu = new Menu();
		menu.setText("Options");
		mb.getMenus().add(menu);

		MenuItem SG = new MenuItem();
		SG.setText("Start game");
		menu.getItems().add(SG);
		int counter =1;
		// Event listener
		SG.setOnAction(e -> {
			
			handler = GameFileHandler.readLevels(new File("./data/level"+ counter + ".txt"));
	        for(GameObject n : handler){
	        	itemsToDraw.addGameObject(n);
	        }
		    
			canvas.setItems(itemsToDraw);
			canvas.redrawCanvas();

			
		});

		MenuItem EG = new MenuItem();
		EG.setText("Exit game");
		menu.getItems().add(EG);

		EG.setOnAction(e -> {
			System.exit(0);

		});

		// Game instructions to user
		MenuItem Instructions = new MenuItem();
		Instructions.setText("Instructions");
		menu.getItems().add(Instructions);

		Instructions.setOnAction(e -> {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Playing Instructions");
			// alert.setHeaderText("Look, an Information Dialog");
			alert.setContentText("This is how you play the game");

			alert.showAndWait();
		});

		MenuItem References = new MenuItem();
		References.setText("References");
		menu.getItems().add(References);

		References.setOnAction(e -> {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("References used");
			// alert.setHeaderText("Look, an Information Dialog");
			alert.setContentText("These are the references used to make the game");

			alert.showAndWait();

		});

		// add menu items to menu

		this.vBox.getChildren().add(mb);
		// this.getChildren().add(mb);
		this.getChildren().add(new Separator());

	}

	public void setItems(GameObjectContainer<GameObject> items) {
		canvas.setItems(items);
	}
	 
}
