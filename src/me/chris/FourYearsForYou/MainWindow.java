package me.chris.FourYearsForYou;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class MainWindow extends JFrame
{
	private static final long serialVersionUID = -2451788337777377959L;

	private JPanel contentPane;

	JLabel label_6;
	JLabel label_5;
	JLabel label_4;
	JLabel label_3;
	JLabel label_2;
	JLabel label_1;
	JLabel label;

	SemesterBox fresh_fall = new SemesterBox(0, true);
	SemesterBox fresh_winter = new SemesterBox(1, false);
	SemesterBox fresh_spring = new SemesterBox(2, true);
	SemesterBox fresh_summer = new SemesterBox(3, false);

	SemesterBox soph_fall = new SemesterBox(0, true);
	SemesterBox soph_winter = new SemesterBox(1, false);
	SemesterBox soph_spring = new SemesterBox(2, true);
	SemesterBox soph_summer = new SemesterBox(3, false);

	SemesterBox juni_fall = new SemesterBox(0, true);
	SemesterBox juni_winter = new SemesterBox(1, false);
	SemesterBox juni_spring = new SemesterBox(2, true);
	SemesterBox juni_summer = new SemesterBox(3, false);

	SemesterBox seni_fall = new SemesterBox(0, true);
	SemesterBox seni_winter = new SemesterBox(1, false);
	SemesterBox seni_spring = new SemesterBox(2, true);
	SemesterBox seni_summer = new SemesterBox(3, false);

	ArrayList<ArrayList<SemesterBox>> allSemesters = new ArrayList<ArrayList<SemesterBox>>();
	ArrayList<SemesterBox> freshSemesters = new ArrayList<SemesterBox>();
	ArrayList<SemesterBox> sophSemesters = new ArrayList<SemesterBox>();
	ArrayList<SemesterBox> juniSemesters = new ArrayList<SemesterBox>();
	ArrayList<SemesterBox> seniSemesters = new ArrayList<SemesterBox>();

	Timer timer_semesterbox;
	Timer timer_infolabels;

	JLabel info_6 = new JLabel();
	JLabel info_5 = new JLabel();
	JLabel info_4 = new JLabel();
	JLabel info_3 = new JLabel();
	JLabel info_2 = new JLabel();
	JLabel info_1 = new JLabel();
	
	ArrayList<JLabel> allInfoLabels = new ArrayList<JLabel>();

	public MainWindow()
	{
		freshSemesters.add(fresh_fall);
		freshSemesters.add(fresh_winter);
		freshSemesters.add(fresh_spring);
		freshSemesters.add(fresh_summer);

		sophSemesters.add(soph_fall);
		sophSemesters.add(soph_winter);
		sophSemesters.add(soph_spring);
		sophSemesters.add(soph_summer);

		juniSemesters.add(juni_fall);
		juniSemesters.add(juni_winter);
		juniSemesters.add(juni_spring);
		juniSemesters.add(juni_summer);

		seniSemesters.add(seni_fall);
		seniSemesters.add(seni_winter);
		seniSemesters.add(seni_spring);
		seniSemesters.add(seni_summer);

		allSemesters.add(freshSemesters);
		allSemesters.add(sophSemesters);
		allSemesters.add(juniSemesters);
		allSemesters.add(seniSemesters);
		
		allInfoLabels.add(info_1);
		allInfoLabels.add(info_2);
		allInfoLabels.add(info_3);
		allInfoLabels.add(info_4);
		allInfoLabels.add(info_5);
		allInfoLabels.add(info_6);

		initialize();
		GlobalVariables.p = this;
		setVisible(true);
	}

	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 975);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(GlobalVariables.cla);

		info_6.setHorizontalTextPosition(SwingConstants.CENTER);
		info_6.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/Info Box.png")));
		info_6.setHorizontalAlignment(SwingConstants.CENTER);
		info_6.setForeground(Color.WHITE);
		info_6.setFont(new Font("Arial", Font.BOLD, 29));
		info_6.setToolTipText("Overall GPA");
		info_6.setBounds(1000, 263, 75, 50);
		contentPane.add(info_6);

		info_5.setHorizontalTextPosition(SwingConstants.CENTER);
		info_5.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/Info Box.png")));
		info_5.setHorizontalAlignment(SwingConstants.CENTER);
		info_5.setForeground(Color.WHITE);
		info_5.setFont(new Font("Arial", Font.BOLD, 29));
		info_5.setToolTipText("Quality Points");
		info_5.setBounds(1000, 263, 75, 50);
		contentPane.add(info_5);

		info_4.setHorizontalTextPosition(SwingConstants.CENTER);
		info_4.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/Info Box.png")));
		info_4.setHorizontalAlignment(SwingConstants.CENTER);
		info_4.setForeground(Color.WHITE);
		info_4.setFont(new Font("Arial", Font.BOLD, 29));
		info_4.setToolTipText("Passed Institution Credits");
		info_4.setBounds(1000, 263, 75, 50);
		contentPane.add(info_4);

		info_3.setHorizontalTextPosition(SwingConstants.CENTER);
		info_3.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/Info Box.png")));
		info_3.setHorizontalAlignment(SwingConstants.CENTER);
		info_3.setForeground(Color.WHITE);
		info_3.setFont(new Font("Arial", Font.BOLD, 29));
		info_3.setToolTipText("Failed Institution Credits");
		info_3.setBounds(1000, 263, 75, 50);
		contentPane.add(info_3);

		info_2.setHorizontalTextPosition(SwingConstants.CENTER);
		info_2.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/Info Box.png")));
		info_2.setHorizontalAlignment(SwingConstants.CENTER);
		info_2.setForeground(Color.WHITE);
		info_2.setFont(new Font("Arial", Font.BOLD, 29));
		info_2.setToolTipText("Planned Institution Credits");
		info_2.setBounds(1000, 263, 75, 50);
		contentPane.add(info_2);

		info_1.setHorizontalTextPosition(SwingConstants.CENTER);
		info_1.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/Info Box.png")));
		info_1.setHorizontalAlignment(SwingConstants.CENTER);
		info_1.setForeground(Color.WHITE);
		info_1.setFont(new Font("Arial", Font.BOLD, 29));
		info_1.setToolTipText("Total Transfer Credits");
		info_1.setBounds(1000, 263, 75, 50);
		contentPane.add(info_1);

		// red divider
		label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/Red Divider.png")));
		label_6.setBounds(0, 929, 1100, 21);
		contentPane.add(label_6);

		for (int yearIndex = 0; yearIndex < allSemesters.size(); yearIndex++)
		{
			for (int semesterIndex = 0; semesterIndex < allSemesters.get(yearIndex).size(); semesterIndex++)
			{
				if (semesterIndex == 0)
					allSemesters.get(yearIndex).get(semesterIndex).setLocation(19, 211 * yearIndex + 360);
				else
					allSemesters
							.get(yearIndex)
							.get(semesterIndex)
							.setLocation(allSemesters.get(yearIndex).get(semesterIndex - 1).getX() + allSemesters.get(yearIndex).get(semesterIndex - 1).getWidth() + 17,
									211 * yearIndex + 360);

				contentPane.add(allSemesters.get(yearIndex).get(semesterIndex));
			}
		}

		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/Row Backgrounds.png")));
		label_5.setBounds(0, 341, 1100, 844);
		contentPane.add(label_5);

		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/Red Divider.png")));
		label_4.setBounds(0, 320, 1100, 21);
		contentPane.add(label_4);

		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/RPI Title.png")));
		label_3.setBounds(80, 5, 165, 39);
		contentPane.add(label_3);

		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/4Y4Y Title.png")));
		label_2.setBounds(55, 15, 338, 108);
		contentPane.add(label_2);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/Gray Drop.png")));
		label_1.setBounds(64, -50, 342, 155);
		contentPane.add(label_1);

		label = new JLabel("");
		label.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/Banner.png")));
		label.setBounds(0, -75, 1100, 514);
		contentPane.add(label);

		info_6.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				AnimateInfoLabels animation = new AnimateInfoLabels((info_1.getX() == 1000));
				
				timer_infolabels = new Timer(10, animation);
				timer_infolabels.start();
				
			}
		});

		contentPane.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				routeAnimation(e.getComponent());
			}
		});

		contentPane.addMouseWheelListener(new MouseWheelListener()
		{
			public void mouseWheelMoved(MouseWheelEvent arg0)
			{
				int future_y = label_4.getLocation().y - arg0.getUnitsToScroll() * 4;

				if (arg0.getWheelRotation() > 0) // scroll down, move rows up
				{
					// 4y4y title
					if (future_y < 64)
					{
						label_2.setLocation(55, -20);
						label_3.setLocation(375, 15);

						label_1.setBounds(64, -50, 492, 155);
						label_1.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/Gray Drop - Scrolled.png")));
					}
					else if (future_y < 95)
					{
						label_2.setLocation(55, future_y - 80);
						label_3.setLocation(80, future_y - 90);
					}
					else
					{
						label_2.setLocation(55, 15);
						label_3.setLocation(80, 5);
					}

					// red divider and banner
					if (future_y < 64)
						scrollRows(64, 40, -201, 64, 85, 7);
					else
						scrollRows(40, future_y, future_y / 2 - 235, future_y, future_y + 21, future_y - 57);
				}
				else if (arg0.getWheelRotation() < 0) // scroll up, move rows
														// down
				{
					// 4y4y title
					if (future_y > 95)
					{
						label_2.setLocation(55, 15);
						label_3.setLocation(80, 5);
					}
					else if (future_y > 64)
					{
						label_2.setLocation(55, future_y - 80);
						label_3.setLocation(80, future_y - 90);

						label_1.setIcon(new ImageIcon(MainWindow.class.getResource("/me/chris/Resources/Gray Drop.png")));
						label_1.setBounds(64, -50, 342, 155);
					}
					else
					{
						label_2.setLocation(55, 15);
						label_3.setLocation(80, 5);
					}

					// red divider and banner
					if (future_y > 320)
						scrollRows(40, 320, -75, 320, 341, 263);
					else
						scrollRows(40, future_y, future_y / 2 - 235, future_y, future_y + 21, future_y - 57);
				}
			}
		});
	}

	public void scrollRows(int variable1, int variable2, int variable3, int variable4, int variable5, int variable6)
	{
		label.setLocation(0, variable3);

		label_4.setLocation(0, variable4);

		label_5.setLocation(0, variable5);
		
		for(int index = 0; index < allInfoLabels.size(); index++)
		{
			allInfoLabels.get(index).setLocation(allInfoLabels.get(index).getX(), variable6);
		}

		for (int yearIndex = 0; yearIndex < allSemesters.size(); yearIndex++)
		{
			for (int semesterIndex = 0; semesterIndex < allSemesters.get(yearIndex).size(); semesterIndex++)
			{
				if (semesterIndex == 0)
					allSemesters.get(yearIndex).get(semesterIndex).setLocation(19, 211 * yearIndex + variable1 + variable2);
				else
					allSemesters
							.get(yearIndex)
							.get(semesterIndex)
							.setLocation(allSemesters.get(yearIndex).get(semesterIndex - 1).getX() + allSemesters.get(yearIndex).get(semesterIndex - 1).getWidth() + 17,
									211 * yearIndex + variable1 + variable2);

			}
		}
	}

	public void UpdateRowWidth(int row)
	{
		if (row == 0)
		{
			fresh_winter.setLocation(fresh_fall.getX() + fresh_fall.getWidth() + 17, fresh_fall.getY());
			fresh_spring.setLocation(fresh_winter.getX() + fresh_winter.getWidth() + 17, fresh_fall.getY());
			fresh_summer.setLocation(fresh_spring.getX() + fresh_spring.getWidth() + 17, fresh_fall.getY());
		}
		else if (row == 1)
		{
			soph_winter.setLocation(soph_fall.getX() + soph_fall.getWidth() + 17, soph_fall.getY());
			soph_spring.setLocation(soph_winter.getX() + soph_winter.getWidth() + 17, soph_fall.getY());
			soph_summer.setLocation(soph_spring.getX() + soph_spring.getWidth() + 17, soph_fall.getY());
		}
		else if (row == 2)
		{
			juni_winter.setLocation(juni_fall.getX() + juni_fall.getWidth() + 17, juni_fall.getY());
			juni_spring.setLocation(juni_winter.getX() + juni_winter.getWidth() + 17, juni_fall.getY());
			juni_summer.setLocation(juni_spring.getX() + juni_spring.getWidth() + 17, juni_fall.getY());
		}
		else
		{
			seni_winter.setLocation(seni_fall.getX() + seni_fall.getWidth() + 17, seni_fall.getY());
			seni_spring.setLocation(seni_winter.getX() + seni_winter.getWidth() + 17, seni_fall.getY());
			seni_summer.setLocation(seni_spring.getX() + seni_spring.getWidth() + 17, seni_fall.getY());
		}
	}

	public void routeAnimation(Component c)
	{
		for (int yearIndex = 0; yearIndex < allSemesters.size(); yearIndex++)
		{
			for (int semesterIndex = 0; semesterIndex < allSemesters.get(yearIndex).size(); semesterIndex++)
			{
				if (allSemesters.get(yearIndex).get(semesterIndex) == c)
				{
					AnimateSemesterBox animation = new AnimateSemesterBox(yearIndex, semesterIndex, !allSemesters.get(yearIndex).get(semesterIndex).state);

					timer_semesterbox = new Timer(10, animation);
					timer_semesterbox.start();

					allSemesters.get(yearIndex).get(semesterIndex).state = !allSemesters.get(yearIndex).get(semesterIndex).state;

					return;
				}
			}
		}
	}

	public SemesterBox isPointInsideBox(int x, int y)
	{
		for (int yearIndex = 0; yearIndex < allSemesters.size(); yearIndex++)
		{
			for (int semesterIndex = 0; semesterIndex < allSemesters.get(yearIndex).size(); semesterIndex++)
			{
				if (isInBox(x, y, allSemesters.get(yearIndex).get(semesterIndex)))
				{
					return allSemesters.get(yearIndex).get(semesterIndex);
				}
			}
		}

		return null;
	}

	public boolean isInBox(int x, int y, SemesterBox b)
	{
		if (x >= b.getX() && x <= b.getX() + b.getWidth() && y >= b.getY() && y <= b.getY() + b.getHeight())
		{
			return true;
		}

		return false;
	}

	public double getTransferCredits()
	{
		double count = 0;

		for (int yearIndex = 0; yearIndex < allSemesters.size(); yearIndex++)
		{
			for (int semesterIndex = 0; semesterIndex < allSemesters.get(yearIndex).size(); semesterIndex++)
			{
				count += allSemesters.get(yearIndex).get(semesterIndex).getTransferCredits();
			}
		}

		return count;
	}

	public double getPlannedInstitutionCredits()
	{
		double count = 0;

		for (int yearIndex = 0; yearIndex < allSemesters.size(); yearIndex++)
		{
			for (int semesterIndex = 0; semesterIndex < allSemesters.get(yearIndex).size(); semesterIndex++)
			{
				count += allSemesters.get(yearIndex).get(semesterIndex).getPlannedInstitutionCredits();
			}
		}

		return count;
	}

	public double getFailedInstitutionCredits()
	{
		double count = 0;

		for (int yearIndex = 0; yearIndex < allSemesters.size(); yearIndex++)
		{
			for (int semesterIndex = 0; semesterIndex < allSemesters.get(yearIndex).size(); semesterIndex++)
			{
				count += allSemesters.get(yearIndex).get(semesterIndex).getFailedInstitutionCredits();
			}
		}

		return count;
	}

	public double getPassedInstitutionCredits()
	{
		double count = 0;

		for (int yearIndex = 0; yearIndex < allSemesters.size(); yearIndex++)
		{
			for (int semesterIndex = 0; semesterIndex < allSemesters.get(yearIndex).size(); semesterIndex++)
			{
				count += allSemesters.get(yearIndex).get(semesterIndex).getPassedInstitutionCredits();
			}
		}

		return count;
	}

	public double getQualityPoints()
	{
		// double count = 0;
		double sum = 0;

		for (int yearIndex = 0; yearIndex < allSemesters.size(); yearIndex++)
		{
			for (int semesterIndex = 0; semesterIndex < allSemesters.get(yearIndex).size(); semesterIndex++)
			{
				for (int classIndex = 0; classIndex < allSemesters.get(yearIndex).get(semesterIndex).classList.size(); classIndex++)
				{
					double temp = allSemesters.get(yearIndex).get(semesterIndex).classList.get(classIndex).getQualityPoints();
					if (temp != -1)
					{
						// count++;
						sum += temp;
					}
				}
			}
		}

		return sum;
	}

	public double getOverallGPA()
	{
		if (getPassedInstitutionCredits() + getFailedInstitutionCredits() == 0)
			return 0;

		return getQualityPoints() / (getPassedInstitutionCredits() + getFailedInstitutionCredits());
	}

	public void updateInfoLabels()
	{
		info_1.setText(String.format(String.format("%.3g%n", getTransferCredits())));
		info_2.setText(String.format(String.format("%.3g%n", getPlannedInstitutionCredits())));
		info_3.setText(String.format(String.format("%.3g%n", getFailedInstitutionCredits())));
		info_4.setText(String.format(String.format("%.3g%n", getPassedInstitutionCredits())));
		info_5.setText(String.format(String.format("%.3g%n", getQualityPoints())));
		info_6.setText(String.format(String.format("%.3g%n", getOverallGPA())));
		
		
	}
}
