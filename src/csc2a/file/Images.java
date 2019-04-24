package csc2a.file;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.scene.image.Image;

public class Images {
	

	public static Image getBackground()
	{
		FileInputStream input = null;
		Image image = null;
		try
		{
			input = new FileInputStream("./data/Hopital.jpg");
			image = new Image(input);
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally
		{
			if(input != null)
			{
				try
				{
					input.close();
				}catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return image;
	}


public static Image getPlayer()
{
	FileInputStream input = null;
	Image image = null;
	try
	{
		input = new FileInputStream("./data/player.jpg");
		image = new Image(input);
		
	}catch(IOException e)
	{
		e.printStackTrace();
	}finally
	{
		if(input != null)
		{
			try
			{
				input.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	return image;
}

public static Image getBlock()
{
	FileInputStream input = null;
	Image image = null;
	try
	{
		input = new FileInputStream("./data/block.png");
		image = new Image(input);
		
	}catch(IOException e)
	{
		e.printStackTrace();
	}finally
	{
		if(input != null)
		{
			try
			{
				input.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	return image;
}

public static Image getNurse()
{
	FileInputStream input = null;
	Image image = null;
	try
	{
		input = new FileInputStream("./data/nurse.jpg");
		image = new Image(input);
		
	}catch(IOException e)
	{
		e.printStackTrace();
	}finally
	{
		if(input != null)
		{
			try
			{
				input.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	return image;
}
}

