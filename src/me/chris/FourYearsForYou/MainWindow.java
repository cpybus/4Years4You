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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.imgscalr.Scalr;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainWindow extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2451788337777377959L;
	
	private JPanel contentPane;
	
	JLabel label_8;
	JLabel label_7;
	JLabel label_6;
	JLabel label_5;
	JLabel label_4;
	JLabel label_3;
	JLabel label_2;
	JLabel label_1;
	JLabel label;
	
	SemesterBox fresh_fall;
	SemesterBox fresh_winter;
	SemesterBox fresh_spring;
	SemesterBox fresh_summer;
	
	SemesterBox soph_fall;
	SemesterBox soph_winter;
	SemesterBox soph_spring;
	SemesterBox soph_summer;
	
	SemesterBox juni_fall;
	SemesterBox juni_winter;
	SemesterBox juni_spring;
	SemesterBox juni_summer;
	
	SemesterBox seni_fall;
	SemesterBox seni_winter;
	SemesterBox seni_spring;
	SemesterBox seni_summer;
	
	/**
	 * Create the application.
	 */
	public MainWindow()
	{
		
		initialize();
		setVisible(true);
	}
	
	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 989);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/Red Divider.png")));
		label_6.setBounds(0, 929, 1100, 21);
		contentPane.add(label_6);
		
		fresh_fall = new SemesterBox(0, true);
		fresh_fall.setLocation(19, 360);
		contentPane.add(fresh_fall);
		
		fresh_winter = new SemesterBox(1, false);
		fresh_winter.setLocation(fresh_fall.getX()+fresh_fall.getWidth()+17, 360);
		contentPane.add(fresh_winter);
		
		fresh_spring = new SemesterBox(2, true);
		fresh_spring.setLocation(fresh_winter.getX()+fresh_winter.getWidth()+17, 360);
		contentPane.add(fresh_spring);
		
		fresh_summer = new SemesterBox(3, false);
		fresh_summer.setLocation(fresh_spring.getX()+fresh_spring.getWidth()+17, 360);
		contentPane.add(fresh_summer);
		
		
		soph_fall = new SemesterBox(0, true);
		soph_fall.setLocation(19, 571);
		contentPane.add(soph_fall);
		
		soph_winter = new SemesterBox(1, false);
		soph_winter.setLocation(soph_fall.getX()+soph_fall.getWidth()+17, 571);
		contentPane.add(soph_winter);
		
		soph_spring = new SemesterBox(2, true);
		soph_spring.setLocation(soph_winter.getX()+soph_winter.getWidth()+17, 571);
		contentPane.add(soph_spring);
		
		soph_summer = new SemesterBox(3, false);
		soph_summer.setLocation(soph_spring.getX()+soph_spring.getWidth()+17, 571);
		contentPane.add(soph_summer);
		
		
		juni_fall = new SemesterBox(0, true);
		juni_fall.setLocation(19, 782);
		contentPane.add(juni_fall);
		
		juni_winter = new SemesterBox(1, false);
		juni_winter.setLocation(juni_fall.getX()+juni_fall.getWidth()+17, 782);
		contentPane.add(juni_winter);
		
		juni_spring = new SemesterBox(2, true);
		juni_spring.setLocation(juni_winter.getX()+juni_winter.getWidth()+17, 782);
		contentPane.add(juni_spring);
		
		juni_summer = new SemesterBox(3, false);
		juni_summer.setLocation(juni_spring.getX()+juni_spring.getWidth()+17, 782);
		contentPane.add(juni_summer);
		
		
		seni_fall = new SemesterBox(0, true);
		seni_fall.setLocation(19, 993);
		contentPane.add(seni_fall);
		
		seni_winter = new SemesterBox(1, false);
		seni_winter.setLocation(seni_fall.getX()+seni_fall.getWidth()+17, 993);
		contentPane.add(seni_winter);
		
		seni_spring = new SemesterBox(2, true);
		seni_spring.setLocation(seni_winter.getX()+seni_winter.getWidth()+17, 993);
		contentPane.add(seni_spring);
		
		seni_summer = new SemesterBox(3, false);
		seni_summer.setLocation(seni_spring.getX()+seni_spring.getWidth()+17, 993);
		contentPane.add(seni_summer);
		
		label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/Info Box.png")));
		label_8.setBounds(915, 263, 75, 50);
		contentPane.add(label_8);
		
		label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/Info Box.png")));
		label_7.setBounds(1000, 263, 75, 50);
		contentPane.add(label_7);
		
		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/Row Backgrounds.png")));
		label_5.setBounds(0, 341, 1100, 844);
		contentPane.add(label_5);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/Red Divider.png")));
		label_4.setBounds(0, 320, 1100, 21);
		contentPane.add(label_4);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/RPI Title.png")));
		label_3.setBounds(80, 5, 165, 39);
		contentPane.add(label_3);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/4Y4Y Title.png")));
		label_2.setBounds(55, 15, 338, 108);
		contentPane.add(label_2);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/Gray Drop.png")));
		label_1.setBounds(64, -50, 342, 155);
		contentPane.add(label_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/Banner.png")));
		label.setBounds(0, -75, 1100, 514);
		contentPane.add(label);
		
		contentPane.addMouseWheelListener(new MouseWheelListener()
		{
			public void mouseWheelMoved(MouseWheelEvent arg0)
			{
				int current_y = label_4.getLocation().y;
				int future_y = current_y - arg0.getUnitsToScroll()*4;
				
				if(arg0.getWheelRotation() > 0) //scroll down, move rows up
				{
					//4y4y title
					if(future_y < 64)
					{
						label_2.setBounds(55, -20, 338, 108);
						label_3.setBounds(375, 15, 165, 39);
						
						label_1.setBounds(64, -50, 492, 155);
						label_1.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/Gray Drop - Scrolled.png")));
					}
					else if(future_y < 95)
					{
						label_2.setBounds(55, future_y - 80, 338, 108);
						label_3.setBounds(80, future_y - 90, 165, 39);
					}
					else
					{
						label_2.setBounds(55, 15, 338, 108);
						label_3.setBounds(80, 5, 165, 39);
					}
					
					//red divider and banner
					if(future_y < 64)
					{
						label_5.setBounds(0, 85, 1100, 844);
						
						label_4.setBounds(0, 64, 1100, 21);
						
						label.setBounds(0, -203, 1100, 514);
						
						label_7.setBounds(1000, 7, 75, 50);
						label_8.setBounds(915, 7, 75, 50);
						
						fresh_fall.setLocation(19, 64 + 40);
						fresh_winter.setLocation(fresh_fall.getX()+fresh_fall.getWidth()+17, 64 + 40);
						fresh_spring.setLocation(fresh_winter.getX()+fresh_winter.getWidth()+17, 64 + 40);
						fresh_summer.setLocation(fresh_spring.getX()+fresh_spring.getWidth()+17, 64 + 40);
						
						soph_fall.setLocation(19, 64 + 251);
						soph_winter.setLocation(soph_fall.getX()+soph_fall.getWidth()+17, 64 + 251);
						soph_spring.setLocation(soph_winter.getX()+soph_winter.getWidth()+17, 64 + 251);
						soph_summer.setLocation(soph_spring.getX()+soph_spring.getWidth()+17, 64 + 251);
						
						juni_fall.setLocation(19, 64 + 462);
						juni_winter.setLocation(juni_fall.getX()+juni_fall.getWidth()+17, 64 + 462);
						juni_spring.setLocation(juni_winter.getX()+juni_winter.getWidth()+17, 64 + 462);
						juni_summer.setLocation(juni_spring.getX()+juni_spring.getWidth()+17, 64 + 462);
						
						seni_fall.setLocation(19, 64 + 673);
						seni_winter.setLocation(seni_fall.getX()+seni_fall.getWidth()+17, 64 + 673);
						seni_spring.setLocation(seni_winter.getX()+seni_winter.getWidth()+17, 64 + 673);
						seni_summer.setLocation(seni_spring.getX()+seni_spring.getWidth()+17, 64 + 673);
					}
					else
					{
						label_4.setBounds(0, future_y, 1100, 21);
						
						label_5.setBounds(0, future_y + 21, 1100, 844);
						
						label.setBounds(0, future_y / 2 - 235 , 1100, 514);
						
						label_7.setBounds(1000, future_y - 57, 75, 50);
						label_8.setBounds(915, future_y - 57, 75, 50);
						
						fresh_fall.setLocation(19, future_y + 40);
						fresh_winter.setLocation(fresh_fall.getX()+fresh_fall.getWidth()+17, future_y + 40);
						fresh_spring.setLocation(fresh_winter.getX()+fresh_winter.getWidth()+17, future_y + 40);
						fresh_summer.setLocation(fresh_spring.getX()+fresh_spring.getWidth()+17, future_y + 40);
						
						soph_fall.setLocation(19, future_y + 251);
						soph_winter.setLocation(soph_fall.getX()+soph_fall.getWidth()+17, future_y + 251);
						soph_spring.setLocation(soph_winter.getX()+soph_winter.getWidth()+17, future_y + 251);
						soph_summer.setLocation(soph_spring.getX()+soph_spring.getWidth()+17, future_y + 251);
						
						juni_fall.setLocation(19, future_y + 462);
						juni_winter.setLocation(juni_fall.getX()+juni_fall.getWidth()+17, future_y + 462);
						juni_spring.setLocation(juni_winter.getX()+juni_winter.getWidth()+17, future_y + 462);
						juni_summer.setLocation(juni_spring.getX()+juni_spring.getWidth()+17, future_y + 462);
						
						seni_fall.setLocation(19, future_y + 673);
						seni_winter.setLocation(seni_fall.getX()+seni_fall.getWidth()+17, future_y + 673);
						seni_spring.setLocation(seni_winter.getX()+seni_winter.getWidth()+17, future_y + 673);
						seni_summer.setLocation(seni_spring.getX()+seni_spring.getWidth()+17, future_y + 673);
					}					
				}
				else if(arg0.getWheelRotation() < 0) //scroll up, move rows down
				{
					//4y4y title
					if(future_y > 95)
					{
						label_2.setBounds(55, 15, 338, 108);
						label_3.setBounds(80, 5, 165, 39);
					}
					else if(future_y > 64)
					{
						label_2.setBounds(55, future_y - 80, 338, 108);
						label_3.setBounds(80, future_y - 90, 165, 39);
						
						label_1.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/Gray Drop.png")));
						label_1.setBounds(64, -50, 342, 155);
					}
					else
					{
						label_2.setBounds(55, 15, 338, 108);
						label_3.setBounds(80, 5, 165, 39);
					}
					
					//red divider and banner
					if(future_y > 320)
					{
						label_4.setBounds(0, 320, 1100, 21);
						
						label.setBounds(0, -75, 1100, 514);
						
						label_5.setBounds(0, 341, 1100, 844);
						
						label_7.setBounds(1000, 263, 75, 50);
						label_8.setBounds(915, 263, 75, 50);
						
						fresh_fall.setLocation(19, 320 + 40);
						fresh_winter.setLocation(fresh_fall.getX()+fresh_fall.getWidth()+17, 320 + 40);
						fresh_spring.setLocation(fresh_winter.getX()+fresh_winter.getWidth()+17, 320 + 40);
						fresh_summer.setLocation(fresh_spring.getX()+fresh_spring.getWidth()+17, 320 + 40);
						
						soph_fall.setLocation(19, 320 + 251);
						soph_winter.setLocation(soph_fall.getX()+soph_fall.getWidth()+17, 320 + 251);
						soph_spring.setLocation(soph_winter.getX()+soph_winter.getWidth()+17, 320 + 251);
						soph_summer.setLocation(soph_spring.getX()+soph_spring.getWidth()+17, 320 + 251);
						
						juni_fall.setLocation(19, 320 + 462);
						juni_winter.setLocation(juni_fall.getX()+juni_fall.getWidth()+17, 320 + 462);
						juni_spring.setLocation(juni_winter.getX()+juni_winter.getWidth()+17, 320 + 462);
						juni_summer.setLocation(juni_spring.getX()+juni_spring.getWidth()+17, 320 + 462);
						
						seni_fall.setLocation(19, 320 + 673);
						seni_winter.setLocation(seni_fall.getX()+seni_fall.getWidth()+17, 320 + 673);
						seni_spring.setLocation(seni_winter.getX()+seni_winter.getWidth()+17, 320 + 673);
						seni_summer.setLocation(seni_spring.getX()+seni_spring.getWidth()+17, 320 + 673);
						
					}
					else
					{
						label_4.setBounds(0, future_y, 1100, 21);
						
						label.setBounds(0, future_y / 2 - 235 , 1100, 514);
						
						label_5.setBounds(0, future_y + 21, 1100, 844);
						
						label_7.setBounds(1000, future_y - 57, 75, 50);
						label_8.setBounds(915, future_y - 57, 75, 50);
						
						fresh_fall.setLocation(19, future_y + 40);
						fresh_winter.setLocation(fresh_fall.getX()+fresh_fall.getWidth()+17, future_y + 40);
						fresh_spring.setLocation(fresh_winter.getX()+fresh_winter.getWidth()+17, future_y + 40);
						fresh_summer.setLocation(fresh_spring.getX()+fresh_spring.getWidth()+17, future_y + 40);
						
						soph_fall.setLocation(19, future_y + 251);
						soph_winter.setLocation(soph_fall.getX()+soph_fall.getWidth()+17, future_y + 251);
						soph_spring.setLocation(soph_winter.getX()+soph_winter.getWidth()+17, future_y + 251);
						soph_summer.setLocation(soph_spring.getX()+soph_spring.getWidth()+17, future_y + 251);
						
						juni_fall.setLocation(19, future_y + 462);
						juni_winter.setLocation(juni_fall.getX()+juni_fall.getWidth()+17, future_y + 462);
						juni_spring.setLocation(juni_winter.getX()+juni_winter.getWidth()+17, future_y + 462);
						juni_summer.setLocation(juni_spring.getX()+juni_spring.getWidth()+17, future_y + 462);
						
						seni_fall.setLocation(19, future_y + 673);
						seni_winter.setLocation(seni_fall.getX()+seni_fall.getWidth()+17, future_y + 673);
						seni_spring.setLocation(seni_winter.getX()+seni_winter.getWidth()+17, future_y + 673);
						seni_summer.setLocation(seni_spring.getX()+seni_spring.getWidth()+17, future_y + 673);
					}
				}				
			}
		});
	}
}
