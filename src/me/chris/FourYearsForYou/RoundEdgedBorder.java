package me.chris.FourYearsForYou;

import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.Graphics;

public class RoundEdgedBorder extends LineBorder {
	
	int arcWidth = 85;
	int arcHeight = 85;
	
	Color fillColor = Color.decode("#505050");

	public RoundEdgedBorder() {
		super(Color.red);
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {
		g.setColor(fillColor);
		g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
	}
}