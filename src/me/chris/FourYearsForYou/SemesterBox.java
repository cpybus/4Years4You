package me.chris.FourYearsForYou;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SemesterBox extends JPanel
{

	/**
	 * Create the panel.
	 */
	public SemesterBox(int season, boolean open)
	{
		
		setLayout(null);
		
		JLabel label = new JLabel("");
		
		if(season == 0)
			label.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/FallHeader.png")));
		else if(season == 1)
			label.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/WinterHeader.png")));
		else if(season == 2)
			label.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/SpringHeader.png")));
		else if(season == 3)
			label.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/SummerHeader.png")));
		
		
		label.setBounds(3, 3, 34, 167);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/Grid.png")));
		label_1.setBounds(37, 3, 425, 167);
		add(label_1);
		
		if(open)
		{
			setBounds(0, 0, 465, 173);
			label_1.setBounds(37, 3, 425, 167);
		}
		else
		{
			setBounds(0, 0, 40, 173);
			label_1.setBounds(37, 3, 0, 167);
		}
			
		
		
		
		setBorder(new LineBorder(new Color(0, 0, 0), 3));

	}

}
