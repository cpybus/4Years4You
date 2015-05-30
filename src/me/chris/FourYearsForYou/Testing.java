package me.chris.FourYearsForYou;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Testing extends JFrame
{

	private static final long serialVersionUID = -9199573673824201184L;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Testing frame = new Testing();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Testing()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 989);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/Info Box.png")));
		label_8.setBounds(915, 263, 75, 50);
		contentPane.add(label_8);
		
		label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/Info Box.png")));
		label_7.setBounds(1000, 263, 75, 50);
		contentPane.add(label_7);
		
		label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Testing.class.getResource("/me/chris/Resources/Red Divider.png")));
		label_6.setBounds(0, 929, 1100, 21);
		contentPane.add(label_6);
		
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
				//System.out.println(arg0.getPreciseWheelRotation() + ", " + arg0.getScrollAmount() + ", " + arg0.getScrollType() + ", " + arg0.getUnitsToScroll() + ", " + arg0.getWheelRotation() );
				
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
					}
					else
					{
						label_4.setBounds(0, future_y, 1100, 21);
						
						label_5.setBounds(0, future_y + 21, 1100, 844);
						
						label.setBounds(0, future_y / 2 - 235 , 1100, 514);
						
						label_7.setBounds(1000, future_y - 57, 75, 50);
						label_8.setBounds(915, future_y - 57, 75, 50);
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
						
					}
					else
					{
						label_4.setBounds(0, future_y, 1100, 21);
						
						label.setBounds(0, future_y / 2 - 235 , 1100, 514);
						
						label_5.setBounds(0, future_y + 21, 1100, 844);
						
						label_7.setBounds(1000, future_y - 57, 75, 50);
						label_8.setBounds(915, future_y - 57, 75, 50);
					}
				}				
			}
		});
	}
}
