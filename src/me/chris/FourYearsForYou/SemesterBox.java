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
	JLabel label_1;
	boolean state; //true means expanded, false means contracted, null means animating
	
	public SemesterBox(int season, boolean open)
	{
		setLayout(null);

		JLabel label = new JLabel("");

		if (season == 0)
			label.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/FallHeader.png")));
		else if (season == 1)
			label.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/WinterHeader.png")));
		else if (season == 2)
			label.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/SpringHeader.png")));
		else if (season == 3)
			label.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/SummerHeader.png")));

		label.setBounds(3, 3, 34, 167);
		add(label);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SemesterBox.class.getResource("/me/chris/Resources/Grid.png")));
		label_1.setBounds(37, 3, 425, 167);
		add(label_1);

		if (open)
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
		
		this.state = open;
		
		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				//MouseEvent convertMouseEvent = SwingUtilities.convertMouseEvent(e.getComponent(), e, e.getComponent().getParent());
				e.getComponent().getParent().dispatchEvent(e);
			}
		});

		
		label.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				MouseEvent convertMouseEvent = SwingUtilities.convertMouseEvent(e.getComponent(), e, e.getComponent().getParent());
				e.getComponent().getParent().dispatchEvent(convertMouseEvent);
			}
		});
	}
	

}
