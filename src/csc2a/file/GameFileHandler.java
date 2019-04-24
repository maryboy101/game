package csc2a.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import csc2a.model.GameObject;
import csc2a.model.GameObjectContainer;
import csc2a.model.Nurse;
import csc2a.model.Player;

/**
 * 
 * Class to handle all interactions with files
 * @author <YOUR DETAILS HERE>
 *
 */
public class GameFileHandler {
	/* TODO: Methods to handle text files */
		public static GameObjectContainer<GameObject> readLevels(File TheFile)
		{
			GameObjectContainer<GameObject> arraylist = new GameObjectContainer<>();	
			
			Scanner dataIn = null;
			Nurse temp = null;
			try
			{
				dataIn = new Scanner(TheFile);
				
				while(dataIn.hasNextLine())
				{
					String Nurseline = dataIn.nextLine();
					StringTokenizer sNurse = new StringTokenizer(Nurseline, "\t");
					while(sNurse.hasMoreTokens()) {
						
						int Nursex = Integer.parseInt(sNurse.nextToken());
						int Nursey = Integer.parseInt(sNurse.nextToken());
						temp= new Nurse(Nursex, Nursey);
						arraylist.addGameObject(temp);	
				}	
				}
				return arraylist;
			} catch(IOException ex)
			{
				ex.printStackTrace();
				
			} finally
			{
				dataIn.close();
			}
			
			/* TODO: Read each line of the file      */
			/* 	TODO: Validate using validate method */
			/* 	TODO: Create correct instance        */
			/* 	TODO: Add to ArrayList               */
			/* 	TODO: Handle problems                */
			/* TODO: Free resources                  */
				
			/* TODO: Return ArrayList */
			return null;
					
		}
	
	/* TODO: Methods to handle binary files */
}
