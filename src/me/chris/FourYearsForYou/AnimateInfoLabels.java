package me.chris.FourYearsForYou;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimateInfoLabels implements ActionListener
{
	
	boolean animate;
	
	AnimateInfoLabels(boolean a) //if a is true animate out, if a is false animate back in
	{
		animate = a;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(animate) //animate out
		{
			int x = GlobalVariables.p.allInfoLabels.get(0).getX();
			int change = (int) ((-1. / 4335. * x * x) + (105. / 289. * x) - (127.));
			int newX = x - change;
			int y = GlobalVariables.p.allInfoLabels.get(0).getY();
			
			if(newX >= 915)
			{
				for(int index = 0; index < GlobalVariables.p.allInfoLabels.size()-1; index++)
					GlobalVariables.p.allInfoLabels.get(index).setLocation(newX, y);
			}
			else if(newX >= 830)
			{
				for(int index = 0; index < GlobalVariables.p.allInfoLabels.size()-2; index++)
					GlobalVariables.p.allInfoLabels.get(index).setLocation(newX, y);
			}
			else if(newX >= 745)
			{
				for(int index = 0; index < GlobalVariables.p.allInfoLabels.size()-3; index++)
					GlobalVariables.p.allInfoLabels.get(index).setLocation(newX, y);
			}
			else if(newX >= 660)
			{
				for(int index = 0; index < GlobalVariables.p.allInfoLabels.size()-4; index++)
					GlobalVariables.p.allInfoLabels.get(index).setLocation(newX, y);
			}
			else if(newX >= 575)
			{
				for(int index = 0; index < GlobalVariables.p.allInfoLabels.size()-5; index++)
					GlobalVariables.p.allInfoLabels.get(index).setLocation(newX, y);
			}
			else
			{
				GlobalVariables.p.timer_infolabels.stop();
			}
			
			if(newX <= 575)
				GlobalVariables.p.allInfoLabels.get(0).setLocation(575, y);
			else if(newX <= 660)
				GlobalVariables.p.allInfoLabels.get(1).setLocation(660, y);
			else if(newX <= 745)
				GlobalVariables.p.allInfoLabels.get(2).setLocation(745, y);
			else if(newX <= 830)
				GlobalVariables.p.allInfoLabels.get(3).setLocation(830, y);
			else if(newX <= 915)
				GlobalVariables.p.allInfoLabels.get(4).setLocation(915, y);
		}
		else //animate in
		{
			int x = GlobalVariables.p.allInfoLabels.get(0).getX();
			int change = (int) ((-1. / 4335. * x * x) + (105. / 289. * x) - (127.));
			int newX = x + change;
			int y = GlobalVariables.p.allInfoLabels.get(0).getY();
			
			if(newX >= 915)
			{
				for(int index = 0; index < GlobalVariables.p.allInfoLabels.size()-1; index++)
					GlobalVariables.p.allInfoLabels.get(index).setLocation(newX, y);
			}
			else if(newX >= 830)
			{
				for(int index = 0; index < GlobalVariables.p.allInfoLabels.size()-2; index++)
					GlobalVariables.p.allInfoLabels.get(index).setLocation(newX, y);
			}
			else if(newX >= 745)
			{
				for(int index = 0; index < GlobalVariables.p.allInfoLabels.size()-3; index++)
					GlobalVariables.p.allInfoLabels.get(index).setLocation(newX, y);
			}
			else if(newX >= 660)
			{
				for(int index = 0; index < GlobalVariables.p.allInfoLabels.size()-4; index++)
					GlobalVariables.p.allInfoLabels.get(index).setLocation(newX, y);
			}
			else if(newX >= 575)
			{
				for(int index = 0; index < GlobalVariables.p.allInfoLabels.size()-5; index++)
					GlobalVariables.p.allInfoLabels.get(index).setLocation(newX, y);
			}
			
			if(newX >= 1000)
			{
				for(int index = 0; index < GlobalVariables.p.allInfoLabels.size()-1; index++)
					GlobalVariables.p.allInfoLabels.get(index).setLocation(1000, y);
				
				GlobalVariables.p.timer_infolabels.stop();
			}
		}
	}

}
