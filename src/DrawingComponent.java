import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;
public class DrawingComponent extends JPanel implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Timer worldT = new Timer (100,this);
	float angle = 20;
	int ex = 120, ey = 120;
	
	
	//Paints to JFrame
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		setBackground(Color.BLACK);
		g2d.setColor(Color.WHITE);
		g2d.fillOval(150, 150, 50, 50);
		g2d.setColor(Color.YELLOW);
		g2d.fillOval(ex, ey, 5, 5);
		//init scene timer
		worldT.start();
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		ex = (ex -= 10*Math.cos(angle));
		ey = (ey += 10*Math.sin(angle));
		angle-=0.5;
		repaint();
	}
}
