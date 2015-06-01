package me.chris.FourYearsForYou;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimateSemesterBox implements ActionListener
{
	int year;
	int semester;
	boolean animate;
	
	AnimateSemesterBox(int y, int s, boolean a)
	{
		year = y;
		semester = s;
		animate = a;
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		int size = GlobalVariables.p.allSemesters.get(year).get(semester).getWidth();
		int nextSize;

		if (!animate)
		{
			nextSize = (int) ((3 * (size * size) / -8480.0) + ((303 * size) / 1696.0) - (335 / 212.0));

			if (size - nextSize < 40)
			{
				GlobalVariables.p.allSemesters.get(year).get(semester).setSize(40, 173);
				GlobalVariables.p.allSemesters.get(year).get(semester).classes.setSize(0, 167);
				GlobalVariables.p.timer_semesterbox.stop();
			}
			else
			{
				GlobalVariables.p.allSemesters.get(year).get(semester).classes.setSize(size - nextSize - 40, 167);
				GlobalVariables.p.allSemesters.get(year).get(semester).setSize(size - nextSize, 173);
				size = size - nextSize;
			}
		}
		else
		{
			nextSize = ((int) ((3 * (size * size) / -8480.0) + ((303 * size) / 1696.0) - (335 / 212.0)));

			if (size + nextSize > 465)
			{
				GlobalVariables.p.allSemesters.get(year).get(semester).setSize(465, 173);
				GlobalVariables.p.allSemesters.get(year).get(semester).classes.setSize(425, 167);
				GlobalVariables.p.timer_semesterbox.stop();
			}
			else
			{
				GlobalVariables.p.allSemesters.get(year).get(semester).classes.setSize(size + nextSize - 40, 167);
				GlobalVariables.p.allSemesters.get(year).get(semester).setSize(size + nextSize, 173);
				size = size + nextSize;
			}
		}

		GlobalVariables.p.UpdateRowWidth(year);
	}

}
