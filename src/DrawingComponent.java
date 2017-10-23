import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

import java.lang.Math;
public class DrawingComponent extends JPanel implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Timer worldT = new Timer (100,this);
	float angle = 20;
	double ex = 230, ey = 190;
	
	
	//Paints to JFrame
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		//enables antialiasing and pure stroke
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		
	    setBackground(Color.BLACK);
		g2d.setColor(Color.WHITE);
		g2d.fillOval(150, 150, 50, 50);
		
		g2d.setColor(Color.YELLOW);
		Ellipse2D.Double electron = new Ellipse2D.Double(ex,ey,5,5);
		g2d.fill(electron);
		//init scene timer
		worldT.start();
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		ex = (ex - 30*Math.cos(angle));
		ey = (ey + 30*Math.sin(angle));
		angle-=0.5;
		repaint();
	}
}
