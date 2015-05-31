package me.chris.FourYearsForYou;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Class extends JPanel
{
	private static final long serialVersionUID = -4676890861965037772L;

	JTextField className_field;
	JLabel className_label;

	JTextField grade_field;
	JLabel grade_label;
	private JLabel credits_label;
	private JTextField credits_field;

	// used for a dragging
	boolean offsetSet = false;
	int x_offset;
	int y_offset;

	Class nextClass;

	public Class()
	{
		setSize(425, 23);
		setOpaque(false);
		setLayout(null);

		// classname LABEL
		className_label = new JLabel("");
		className_label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		// className_label.setOpaque(false);
		className_label.setBounds(5, 1, 300, 22);
		add(className_label);

		// classname FIELD
		className_field = new JTextField();
		className_field.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		className_field.setBounds(5, 1, 300, 22);
		className_field.setOpaque(false);
		className_field.setBorder(null);
		className_field.setVisible(false);
		className_field.setFocusTraversalKeysEnabled(false);
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
		grade_field.setFocusTraversalKeysEnabled(false);
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
		credits_field.setFocusTraversalKeysEnabled(false);
		add(credits_field);

		// CLASS LABEL AND FIELD
		className_label.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				labelClick(className_label, className_field);
			}

			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				// Thing was being carries
				if (offsetSet)
				{
					GlobalVariables.cla.setVisible(false);
					offsetSet = false;

					// cordinates of mouse
					int x = arg0.getXOnScreen() - GlobalVariables.p.getX();// +
																			// 8;
					int y = arg0.getYOnScreen() - GlobalVariables.p.getY() - 25;

					SemesterBox b = GlobalVariables.p.isPointInsideBox(x, y);

					if (b != null && b != arg0.getComponent().getParent().getParent().getParent())
					{
						b.addClass(GlobalVariables.cla);
						className_label.setText("");
						className_field.setText("");
						grade_label.setText("");
						grade_field.setText("");
						credits_label.setText("");
						credits_field.setText("");
					}
				}
			}
		});

		className_field.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				System.out.println(arg0.getKeyCode());

				if (arg0.getKeyCode() == KeyEvent.VK_TAB)
				{
					className_label.setText(className_field.getText());
					className_field.setVisible(false);
					className_label.setVisible(true);

					grade_field.setText(grade_label.getText());
					grade_label.setVisible(false);
					grade_field.setVisible(true);
					grade_field.requestFocus();
				}
			}
		});

		className_field.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent arg0)
			{
				fieldDone(className_label, className_field);
			}
		});

		className_field.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// this listener will also end up calling focusLost
				fieldDone(className_label, className_field);
			}
		});

		// GRADE LABEL AND FIELD
		grade_label.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				labelClick(grade_label, grade_field);
			}
		});

		grade_field.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				if (arg0.getKeyCode() == KeyEvent.VK_TAB)
				{
					String t = grade_field.getText().trim();
					if (checkIfValidLetterGrade(t))
						fieldDone(grade_label, grade_field, t.toUpperCase());
					else
						fieldDone(grade_label, grade_field, "");

					labelClick(credits_label, credits_field);
				}
			}
		});

		grade_field.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent arg0)
			{
				String t = grade_field.getText().trim();
				if (checkIfValidLetterGrade(t))
					fieldDone(grade_label, grade_field, t.toUpperCase());
				else
					fieldDone(grade_label, grade_field, "");

			}
		});

		grade_field.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String t = grade_field.getText().trim();
				if (checkIfValidLetterGrade(t))
					fieldDone(grade_label, grade_field, t.toUpperCase());
				else
					fieldDone(grade_label, grade_field, "");

			}
		});

		// credits LABEL AND FIELD
		credits_label.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				labelClick(credits_label, credits_field);
			}
		});

		credits_field.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				System.out.println(arg0.getKeyCode());

				if (arg0.getKeyCode() == KeyEvent.VK_TAB)
				{
					String t = credits_field.getText().trim();
					if (GlobalVariables.isDouble(t) != -1)
						fieldDone(credits_label, credits_field, String.format("%.3g%n", GlobalVariables.isDouble(t)));
					else
						fieldDone(credits_label, credits_field, "");

					// send up signal to move to next class
					labelClick(nextClass.className_label, nextClass.className_field);
				}
			}
		});

		credits_field.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent arg0)
			{
				String t = credits_field.getText().trim();
				if (GlobalVariables.isDouble(t) != -1)
					fieldDone(credits_label, credits_field, String.format("%.3g%n", GlobalVariables.isDouble(t)));
				else
					fieldDone(credits_label, credits_field, "");
			}
		});

		credits_field.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String t = credits_field.getText().trim();
				if (GlobalVariables.isDouble(t) != -1)
					fieldDone(credits_label, credits_field, String.format("%.3g%n", GlobalVariables.isDouble(t)));
				else
					fieldDone(credits_label, credits_field, "");
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

				if (offsetSet == false)
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
		if (className_label.getText().trim().equalsIgnoreCase(""))
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

	public void setNextClass(Class c2)
	{
		nextClass = c2;
	}

	public void labelClick(JLabel l, JTextField t)
	{
		t.setText(l.getText());
		l.setVisible(false);
		t.setVisible(true);
		t.requestFocus();
	}

	public void fieldDone(JLabel l, JTextField t)
	{
		l.setText(t.getText());
		t.setVisible(false);
		l.setVisible(true);
	}

	public void fieldDone(JLabel l, JTextField t, String s)
	{
		l.setText(s);
		t.setVisible(false);
		l.setVisible(true);
	}

	public boolean checkIfValidLetterGrade(String t)
	{
		if (t.equalsIgnoreCase("A") || t.equalsIgnoreCase("A-") || t.equalsIgnoreCase("B+") || t.equalsIgnoreCase("B") || t.equalsIgnoreCase("B-") || t.equalsIgnoreCase("C+")
				|| t.equalsIgnoreCase("C") || t.equalsIgnoreCase("C-") || t.equalsIgnoreCase("D+") || t.equalsIgnoreCase("D") || t.equalsIgnoreCase("F") || t.equalsIgnoreCase("")
				|| t.equalsIgnoreCase(" ") || t.equalsIgnoreCase("TR"))
			return true;

		return false;
	}
}
