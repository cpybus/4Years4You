package me.chris.FourYearsForYou;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SemesterBox extends JPanel
{
	private static final long serialVersionUID = -6306507456401691244L;
	JLabel grid;
	JLabel label;
	boolean state; // true means expanded, false means contracted, null means animating
	JPanel classes;
	JLabel seasonLabel;
	
	Class c1;
	Class c2;
	Class c3;
	Class c4;
	Class c5;
	Class c6;
	Class c7;

	public SemesterBox(int season, boolean open)
	{
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setLayout(null);
		this.state = open;

		
		//Season Label
		seasonLabel = new JLabel("");
		seasonLabel.setBounds(3, 3, 34, 167);
		if (season == 0)
			seasonLabel.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/FallHeader.png")));
		else if (season == 1)
			seasonLabel.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/WinterHeader.png")));
		else if (season == 2)
			seasonLabel.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/SpringHeader.png")));
		else if (season == 3)
			seasonLabel.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/SummerHeader.png")));
		add(seasonLabel);

		
		//Classes JPanel
		classes = new JPanel();
		classes.setBounds(37, 3, 425, 167);
		add(classes);
		classes.setLayout(null);
		
		
		c1 = new Class();
		c1.setLocation(0, 0);
		classes.add(c1);
		
		c2 = new Class();
		c2.setLocation(0, 24);
		c1.setNextClass(c2);
		classes.add(c2);
		
		c3 = new Class();
		c3.setLocation(0, 48);
		c2.setNextClass(c3);
		classes.add(c3);
		
		c4 = new Class();
		c4.setLocation(0, 72);
		c3.setNextClass(c4);
		classes.add(c4);
		
		c5 = new Class();
		c5.setLocation(0, 96);
		c4.setNextClass(c5);
		classes.add(c5);
		
		c6 = new Class();
		c6.setLocation(0, 120);
		c5.setNextClass(c6);
		classes.add(c6);
		
		c7 = new Class();
		c7.setLocation(0, 144);
		c6.setNextClass(c7);
		classes.add(c7);
		

		c7.setNextClass(c1);
		
		
		//The grid thing
		grid = new JLabel("");
		grid.setBounds(0, 0, 425, 167);
		classes.add(grid);
		grid.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/Grid.png")));
		
		
		
		//Finally set the size
		if (open)
		{
			setBounds(0, 0, 465, 173);
			classes.setBounds(37, 3, 425, 167);
		}
		else
		{
			setBounds(0, 0, 40, 173);
			classes.setBounds(37, 3, 0, 167);
		}
		
		seasonLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				MouseEvent convertMouseEvent = SwingUtilities.convertMouseEvent(e.getComponent(), e, e.getComponent().getParent());
				e.getComponent().getParent().getParent().dispatchEvent(convertMouseEvent);
			}
		});
	}
	
	public boolean addClass(Class c)
	{
		if(c1.isEmpty())
		{
			c1.set(c);
			return true;
		}
		else if(c2.isEmpty())
		{
			c2.set(c);
			return true;
		}
		else if(c3.isEmpty())
		{
			c3.set(c);
			return true;
		}
		else if(c4.isEmpty())
		{
			c4.set(c);
			return true;
		}
		else if(c5.isEmpty())
		{
			c5.set(c);
			return true;
		}
		else if(c6.isEmpty())
		{
			c6.set(c);
			return true;
		}
		else if(c7.isEmpty())
		{
			c7.set(c);
			return true;
		}
		else
			return false;
	}
}
