package me.chris.FourYearsForYou;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GlobalVariables
{
	public static BufferedImage banner;
	
	GlobalVariables()
	{
		URL u = MainWindow.class.getResource("/me/chris/Resources/RPIQuad.jpg");
		try
		{
			banner = ImageIO.read(u);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
}
