package me.chris.FourYearsForYou;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GlobalVariables
{
	public static BufferedImage banner;
	
	public static Font robotoBlack;

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

		u = MainWindow.class.getResource("/me/chris/Resources/Roboto-Blac.ttf");
		 
		try
		{
			
			robotoBlack = Font.createFont(Font.TRUETYPE_FONT, new File(u.getFile())).deriveFont(50f);
		}
		catch (IOException | FontFormatException e)
		{
			// Handle exception
		}

	}
}
