import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.lang.Math;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawingComponent extends JPanel implements ActionListener, MouseListener 
{

	private Timer worldT = new Timer (100,this);
	private float angle = 20;
	private double ex = (int)(getWidth()/2)+675, ey = (int)(getHeight()/2)+225;
	private int numOfElements = 2;
	private int currentElement = 1;
    private Element[] elements = new Element[numOfElements];
	File file = new File("Elements.txt");
	
    public void dataLoad() throws IOException{
		Scanner inFile = new Scanner(file);
		for(int i=0; i< numOfElements;i++) {
			elements[i] = new Element();
			elements[i].setElectrons(inFile.nextInt());
			elements[i].setProtons(inFile.nextInt());
			elements[i].setName(inFile.nextLine());
		}
		
		inFile.close();
		System.out.println("Data Loaded");
		//init scene timer
		worldT.start();
    }
    

    
	//Paints to JFrame
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		//enables antialiasing and pure stroke
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		
	    setBackground(Color.BLACK);
		g2d.setColor(Color.WHITE);
		g2d.fillOval(getWidth()/2, (getHeight()/2)-200, 50, 50);
		
		g2d.setColor(Color.YELLOW);
		Ellipse2D.Double electron = new Ellipse2D.Double(ex,ey,5,5);
		g2d.fill(electron);
		
		//displays selected element data
		g2d.drawString("Current element: " + elements[currentElement].getName(), 500, 500);
		g2d.drawString("Number of protons: " + elements[currentElement].getProtons(), 500, 515);
		g2d.drawString("Number of electrons: " + elements[currentElement].getElectrons(), 500, 530);
		g2d.drawString("Electron postion(s): " + ex + "," + ey, 500, 545);

        //Creates a "text console"
        g2d.setColor(Color.WHITE);
        g2d.drawString("~By Nick Rich~", 12, 450);
        g2d.drawString("Window Size : "+getWidth()+"X"+getHeight(), 10, 465);
        g2d.drawString("Panel repaints every "+worldT.getDelay()+"ms",10,480);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		ex = ex - 30 * Math.cos(angle);
		ey = ey + 30 * Math.sin(angle);
		angle-=0.5;
		repaint();
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
