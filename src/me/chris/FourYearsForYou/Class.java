package me.chris.FourYearsForYou;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;

public class Class extends JPanel
{
	private static final long serialVersionUID = -4676890861965037772L;

	JTextField className_field;
	JLabel className_label;

	JTextField grade_field;
	JLabel grade_label;
	private JLabel credits_label;
	private JTextField credits_field;
	
	//used for a dragging
	boolean offsetSet = false;
	int x_offset;
	int y_offset;

	public Class()
	{
		setSize(425, 23);
		setOpaque(false);
		setLayout(null);

		// classname LABEL
		className_label = new JLabel("");
		className_label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		//className_label.setOpaque(false);
		className_label.setBounds(5, 1, 300, 22);
		add(className_label);

		// classname FIELD
		className_field = new JTextField();
		className_field.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		className_field.setBounds(5, 1, 300, 22);
		className_field.setOpaque(false);
		className_field.setBorder(null);
		className_field.setVisible(false);
		add(className_field);

		// grade LABEL
		grade_label = new JLabel("");
		grade_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade_label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		grade_label.setOpaque(false);
		grade_label.setBounds(305, 1, 60, 22);
		add(grade_label);

		// grade FIELD
		grade_field = new JTextField();
		grade_field.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		grade_field.setHorizontalAlignment(SwingConstants.CENTER);
		grade_field.setBounds(305, 1, 60, 22);
		grade_field.setOpaque(false);
		grade_field.setBorder(null);
		grade_field.setVisible(false);
		add(grade_field);

		// credits LABEL
		credits_label = new JLabel("");
		credits_label.setHorizontalAlignment(SwingConstants.CENTER);
		credits_label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		credits_label.setOpaque(false);
		credits_label.setBounds(365, 1, 60, 22);
		add(credits_label);

		// credits FIELD
		credits_field = new JTextField();
		credits_field.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		credits_field.setHorizontalAlignment(SwingConstants.CENTER);
		credits_field.setBounds(365, 1, 60, 22);
		credits_field.setOpaque(false);
		credits_field.setBorder(null);
		credits_field.setVisible(false);
		add(credits_field);

		// CLASS LABEL AND FIELD
		className_label.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				className_field.setText(className_label.getText());
				className_label.setVisible(false);
				className_field.setVisible(true);
				className_field.requestFocus();
			}
			@Override
			public void mouseReleased(MouseEvent arg0) 
			{
				//Thing was being carries
				if(offsetSet)
				{
					GlobalVariables.cla.setVisible(false);
					offsetSet = false;
					
					//cordinates of mouse
					int x = arg0.getXOnScreen() - GlobalVariables.p.getX();//+ 8;
					int y = arg0.getYOnScreen() - GlobalVariables.p.getY() - 25;
					
					SemesterBox b = GlobalVariables.p.isPointInsideBox(x, y);
					
					if(b != null && b != arg0.getComponent().getParent().getParent().getParent())
					{
						b.addClass(GlobalVariables.cla);
						className_label.setText("");
						className_field.setText("");
						grade_label.setText("");
						grade_field.setText("");
						credits_label.setText("");
						credits_field.setText("");
					}
					/*
					else if(b != null && b == arg0.getComponent().getParent().getParent().getParent())
					{
						System.out.println("add to same box");
					}*/
				}
				
				
			}
		});

		className_field.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent arg0)
			{
				className_label.setText(className_field.getText());
				className_field.setVisible(false);
				className_label.setVisible(true);
			}
		});

		className_field.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				className_label.setText(className_field.getText());
				className_field.setVisible(false);
				className_label.setVisible(true);
			}
		});

		// GRADE LABEL AND FIELD
		grade_label.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				grade_field.setText(grade_label.getText());
				grade_label.setVisible(false);
				grade_field.setVisible(true);
				grade_field.requestFocus();
			}
		});

		grade_field.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent arg0)
			{
				String t = grade_field.getText().trim();
				if (t.equalsIgnoreCase("A") || t.equalsIgnoreCase("A-") || t.equalsIgnoreCase("B+") || t.equalsIgnoreCase("B") || t.equalsIgnoreCase("B-")
						|| t.equalsIgnoreCase("C+") || t.equalsIgnoreCase("C") || t.equalsIgnoreCase("C-") || t.equalsIgnoreCase("D+") || t.equalsIgnoreCase("D")
						|| t.equalsIgnoreCase("F") || t.equalsIgnoreCase("") || t.equalsIgnoreCase(" "))
				{
					grade_label.setText(t.toUpperCase());
					grade_field.setVisible(false);
					grade_label.setVisible(true);
				}
				else
				{
					grade_label.setText("");
					grade_field.setVisible(false);
					grade_label.setVisible(true);
				}
			}
		});

		grade_field.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String t = grade_field.getText().trim();
				if (t.equalsIgnoreCase("A") || t.equalsIgnoreCase("A-") || t.equalsIgnoreCase("B+") || t.equalsIgnoreCase("B") || t.equalsIgnoreCase("B-")
						|| t.equalsIgnoreCase("C+") || t.equalsIgnoreCase("C") || t.equalsIgnoreCase("C-") || t.equalsIgnoreCase("D+") || t.equalsIgnoreCase("D")
						|| t.equalsIgnoreCase("F") || t.equalsIgnoreCase("") || t.equalsIgnoreCase(" "))
				{
					grade_label.setText(t.toUpperCase());
					grade_field.setVisible(false);
					grade_label.setVisible(true);
				}
				else
				{
					grade_label.setText("");
					grade_field.setVisible(false);
					grade_label.setVisible(true);
				}
			}
		});

		// credits LABEL AND FIELD
		credits_label.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				credits_field.setText(credits_label.getText());
				credits_label.setVisible(false);
				credits_field.setVisible(true);
				credits_field.requestFocus();
			}
		});

		credits_field.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent arg0)
			{
				String t = credits_field.getText().trim();
				if (GlobalVariables.isDouble(t) != -1)
				{
					credits_label.setText(String.format("%.3g", GlobalVariables.isDouble(t)));
					credits_field.setVisible(false);
					credits_label.setVisible(true);
				}
				else
				{
					credits_label.setText("");
					credits_field.setVisible(false);
					credits_label.setVisible(true);
				}
			}
		});

		credits_field.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String t = credits_field.getText().trim();
				if (GlobalVariables.isDouble(t) != -1)
				{
					credits_label.setText(String.format("%.3g%n", GlobalVariables.isDouble(t)));
					credits_field.setVisible(false);
					credits_label.setVisible(true);
				}
				else
				{
					credits_label.setText("");
					credits_field.setVisible(false);
					credits_label.setVisible(true);
				}
			}
		});
		
		
		
		
		
		
		

		className_label.addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseDragged(MouseEvent arg0)
			{
				int x_of_frame = GlobalVariables.p.getX();
				int y_of_frame = GlobalVariables.p.getY();
				
				int x_on_screen = arg0.getXOnScreen();
				int y_on_screen = arg0.getYOnScreen();
				
				if(offsetSet == false)
				{
					GlobalVariables.cla.className_label.setText(className_label.getText());
					GlobalVariables.cla.grade_label.setText(grade_label.getText());
					GlobalVariables.cla.credits_label.setText(credits_label.getText());
					GlobalVariables.cla.setLocation(x_on_screen - x_of_frame - 212, y_on_screen - y_of_frame - 35);
					
					GlobalVariables.cla.setVisible(true);
					
					offsetSet = true;
				}
				else
				{
					GlobalVariables.cla.setLocation(x_on_screen - x_of_frame - 212, y_on_screen - y_of_frame - 35);
				}
			}
		});
	}
	
	public boolean isEmpty()
	{
		if(className_label.getText().trim().equalsIgnoreCase(""))
			return true;
		
		return false;
	}
	
	public void set(Class c)
	{
		className_label.setText(c.className_label.getText());
		className_field.setText(c.className_field.getText());
		grade_label.setText(c.grade_label.getText());
		grade_field.setText(c.grade_field.getText());
		credits_label.setText(c.credits_label.getText());
		credits_field.setText(c.credits_field.getText());
		
	}
}
