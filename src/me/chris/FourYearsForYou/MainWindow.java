package me.chris.FourYearsForYou;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import org.imgscalr.Scalr;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainWindow extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2451788337777377959L;
	JLabel			banner;
	SpringLayout	springLayout;
	BufferedImage	scaledImg;
	JPanel			divider;
	JPanel			grayDrop;
	
	/**
	 * Create the application.
	 */
	public MainWindow()
	{
		
		//Code for resizing shit. We'll do that later.
		
		/*
		getContentPane().addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent arg0)
			{
				scaledImg = Scalr.resize(GlobalVariables.banner, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH, arg0.getComponent().getWidth(), 400, Scalr.OP_ANTIALIAS);
				springLayout.putConstraint(SpringLayout.SOUTH, banner, scaledImg.getHeight(), SpringLayout.NORTH, getContentPane());
				banner.setIcon(new ImageIcon(scaledImg));
				
				springLayout.putConstraint(SpringLayout.NORTH, divider, getContentPane().getWidth() /4, SpringLayout.NORTH, getContentPane());
				springLayout.putConstraint(SpringLayout.SOUTH, divider, (getContentPane().getWidth() /4) + 15, SpringLayout.NORTH, getContentPane());
				
				springLayout.putConstraint(SpringLayout.NORTH, grayDrop, -50, SpringLayout.NORTH, getContentPane());
				springLayout.putConstraint(SpringLayout.WEST, grayDrop, getContentPane().getWidth() / 12, SpringLayout.WEST, getContentPane());
				springLayout.putConstraint(SpringLayout.SOUTH, grayDrop, (getContentPane().getWidth() /9), SpringLayout.NORTH, getContentPane());
				springLayout.putConstraint(SpringLayout.EAST, grayDrop, (getContentPane().getWidth() / 12) * 6, SpringLayout.WEST, getContentPane());
				
				getContentPane().repaint();
			}
		});
		*/
		initialize();
		getContentPane().repaint();
	}
	
	private void initialize()
	{
		// window properties
		setBounds(100, 100, 900, 950);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// layout
		springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		
		
		// banner stuff
		banner = new JLabel("");
		scaledImg = Scalr.resize(GlobalVariables.banner, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_WIDTH, this.getWidth(), 400, Scalr.OP_ANTIALIAS);
		springLayout.putConstraint(SpringLayout.NORTH, banner, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, banner, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, banner, scaledImg.getHeight(), SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, banner, 0, SpringLayout.EAST, getContentPane());
		banner.setIcon(new ImageIcon(scaledImg));
		getContentPane().add(banner);
		
		
		
		//divider stuff
		divider = new JPanel();
		divider.setBackground(Color.decode("#dd3322"));
		//springLayout.putConstraint(SpringLayout.NORTH, divider, getContentPane().getWidth() /4, SpringLayout.NORTH, getContentPane());
		//springLayout.putConstraint(SpringLayout.SOUTH, divider, (getContentPane().getWidth() /4) + 15, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, divider, 240, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, divider, 240 + 12, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, divider, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, divider, 0, SpringLayout.EAST, getContentPane());
		getContentPane().add(divider);
		
		
		
		//gray drop
		grayDrop = new JPanel();
		//grayDrop.setOpaque(false);
		grayDrop.setBorder(new RoundEdgedBorder());
		grayDrop.setLayout(null);
		springLayout.putConstraint(SpringLayout.NORTH, grayDrop, -50, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, grayDrop, 75, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, grayDrop, 120, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, grayDrop, 450, SpringLayout.WEST, getContentPane());
		
		springLayout.putConstraint(SpringLayout.NORTH, grayDrop, 400, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, grayDrop, 75, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, grayDrop, 700, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, grayDrop, 450, SpringLayout.WEST, getContentPane());
		getContentPane().add(grayDrop);
		
		
		
		//4y4y logo
		JLabel fyfy = new JLabel(); 
		fyfy.setText("4 Years 4 You");
		
		//Font f = Font.decode("Roboto Black-50");
		fyfy.setFont(GlobalVariables.robotoBlack);
			
		//fyfy.setFont(new Font("Roboto-Black", Font., 50));
		
		/*
		URL u = MainWindow.class.getResource("/me/chris/Resources/Roboto-Blac.ttf");
		Font font = null;
		try
		{
			font = Font.createFont(Font.TRUETYPE_FONT, new File(u.getFile()));
		}
		catch (FontFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		font.deriveFont(50);*/
		
		fyfy.setForeground(Color.decode("#D1D1DA"));
		fyfy.setBounds(10, 60, 400, 400);		
		grayDrop.add(fyfy);
		
		
		// tie up loose ends
		getContentPane().setComponentZOrder(banner, 2);
		getContentPane().setComponentZOrder(divider, 1);
		getContentPane().setComponentZOrder(grayDrop, 0);
		
		setVisible(true);
	}
}
