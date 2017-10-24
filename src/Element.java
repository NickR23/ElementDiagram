import java.awt.geom.Ellipse2D;
import java.awt.event.*;
import javax.swing.Timer;

public class Element implements ActionListener{
	private int numElectrons;
	private int protons;
	private String name;
	private float angle;
    private double ex[];
    private double ey[];
    private Ellipse2D.Double[] electron;
    
	public Element(double Width, double Height, int numE) {
		Timer ElementTime  = new Timer (90,this);
		numElectrons = numE;
	    electron = new Ellipse2D.Double[numE];
	    ex = new double [numE];
	    ey = new double [numE];
		for(int i = 0; i<numE;i++) {
			ex[i] = (int)(Width/2)+675;
			ey[i] = (int)(Height/2)+225;
			electron[i] = new Ellipse2D.Double();
			electron[i].setFrame(ex[i],ey[i],5,5);
		}
		angle = 20;
		ElementTime.start();
	}
	
	
	public void setProtons(int p) {
		protons = p;
	}
	public void setName(String n) {
		name = n;
	}
	public Ellipse2D.Double getE(int j){
		return electron[j];
	}
	public double getEX(int e) {
		return ex[e];
	}
	public double getEY(int e) {
		return ey[e];
	}
	public int getNumElectrons() {
		return numElectrons;
	}
	public int getProtons() {
		return protons;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i<numElectrons; i++) {
			ex[i] = ex[i] - 30 * Math.cos(angle);
			ey[i] = ey[i] + 30 * Math.sin(angle);
			angle-=0.5;
			electron[i].setFrame(ex[i],ey[i],5,5);
		}
	}
}
