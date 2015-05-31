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
}
