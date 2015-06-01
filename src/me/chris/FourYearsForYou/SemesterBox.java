package me.chris.FourYearsForYou;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SemesterBox extends JPanel
{
	private static final long serialVersionUID = -6306507456401691244L;
	JLabel grid;
	JLabel label;
	boolean state; // true means expanded, false means contracted, null means animating
	JPanel classes;
	JLabel seasonLabel;
	
	Class c1 = new Class();
	Class c2 = new Class();
	Class c3 = new Class();
	Class c4 = new Class();
	Class c5 = new Class();
	Class c6 = new Class();
	Class c7 = new Class();
	
	ArrayList<Class> classList = new ArrayList<Class>();

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
		
		
		//Classes
		c1.setLocation(0, 0);
		classes.add(c1);
		
		c2.setLocation(0, 24);
		c1.setNextClass(c2);
		classes.add(c2);
		
		c3.setLocation(0, 48);
		c2.setNextClass(c3);
		classes.add(c3);
		
		c4.setLocation(0, 72);
		c3.setNextClass(c4);
		classes.add(c4);
		
		c5.setLocation(0, 96);
		c4.setNextClass(c5);
		classes.add(c5);
		
		c6.setLocation(0, 120);
		c5.setNextClass(c6);
		classes.add(c6);
		
		c7.setLocation(0, 144);
		c6.setNextClass(c7);
		classes.add(c7);

		c7.setNextClass(c1);
		
		
		//add classes to list
		classList.add(c1);
		classList.add(c2);
		classList.add(c3);
		classList.add(c4);
		classList.add(c5);
		classList.add(c6);
		classList.add(c7);
		
		
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
		for(int index = 0; index < classList.size(); index++)
		{
			if(classList.get(index).isEmpty())
			{
				classList.get(index).set(c);
				return true;
			}
		}
		
		return false;
	}
	
	public double getTransferCredits()
	{
		double count = 0; 
		
		for(int index = 0; index < classList.size(); index++)
		{
			count += classList.get(index).getTransferCredits();
		}
		
		return count;
	}
	
	public double getPlannedInstitutionCredits()
	{
		double count = 0; 
		
		for(int index = 0; index < classList.size(); index++)
		{
			count += classList.get(index).getPlannedInstitutionCredits();
		}
		
		return count;
	}
	
	public double getFailedInstitutionCredits()
	{
		double count = 0; 
		
		for(int index = 0; index < classList.size(); index++)
		{
			count += classList.get(index).getFailedInstitutionCredits();
		}
		
		return count;
	}
	
	public double getPassedInstitutionCredits()
	{
		double count = 0; 
		
		for(int index = 0; index < classList.size(); index++)
		{
			count += classList.get(index).getPassedInstitutionCredits();
		}
		
		return count;
	}
}
