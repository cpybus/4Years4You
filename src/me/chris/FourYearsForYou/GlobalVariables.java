package me.chris.FourYearsForYou;

public class GlobalVariables
{
	public static MainWindow p;
	public static Class cla;

	GlobalVariables()
	{
		cla = new Class();
		cla.setLocation(0,0);
		cla.setOpaque(true);
		cla.setVisible(false);
	}

	public static double isDouble(String s)
	{
		try
		{
			double d = Double.parseDouble(s);
			return d;
		}
		catch (NumberFormatException e)
		{
			return -1;// not a double
		}
	}
	
	public static double convertGradeToNumber(String s)
	{
		if(s.equalsIgnoreCase("A"))
			return 4;
		else if(s.equalsIgnoreCase("A-"))
			return 3.67;
		else if(s.equalsIgnoreCase("B+"))
			return 3.33;
		else if(s.equalsIgnoreCase("B"))
			return 3.00;
		else if(s.equalsIgnoreCase("B-"))
			return 2.67;
		else if(s.equalsIgnoreCase("C+"))
			return 2.33;
		else if(s.equalsIgnoreCase("C"))
			return 2.00;
		else if(s.equalsIgnoreCase("C-"))
			return 1.67;
		else if(s.equalsIgnoreCase("D+"))
			return 1.33;
		else if(s.equalsIgnoreCase("D"))
			return 1.00;
		else if(s.equalsIgnoreCase("F"))
			return 0;
		else
			return -1;
	}
}
