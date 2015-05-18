package me.chris.FourYearsForYou;

import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import org.imgscalr.Scalr;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainWindow extends JFrame
{
	
	JLabel			banner;
	SpringLayout	springLayout;
	BufferedImage	scaledImg;
	
	/**
	 * Create the application.
	 */
	public MainWindow()
	{
		getContentPane().addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent arg0)
			{
				scaledImg = Scalr.resize(GlobalVariables.banner, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH, arg0.getComponent().getWidth(), 400, Scalr.OP_ANTIALIAS);
				springLayout.putConstraint(SpringLayout.SOUTH, banner, scaledImg.getHeight(), SpringLayout.NORTH, getContentPane());
				banner.setIcon(new ImageIcon(scaledImg));
			}
		});
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		// window properties
		setBounds(100, 100, 1500, 699);
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
		
		// end
		setVisible(true);
	}
}
