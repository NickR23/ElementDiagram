import java.awt.geom.Ellipse2D;
import java.awt.event.*;
import javax.swing.Timer;

public class Element implements ActionListener{
	private int numElectrons;
	private int protons;
	private String name;
	private String abreviation;
    private double ex[];
    private double ey[];
    private float angle[];
    private int energy[];
    private Ellipse2D.Double[] electron;
    
	public Element(double width, double height, int numE) {
		Timer ElementTime  = new Timer (100,this);
		numElectrons = numE;
	    electron = new Ellipse2D.Double[numE];
	    ex = new double [numE];
	    ey = new double [numE];
	    angle = new float[numE];
	    energy = new int[numE];
	    
		for(int i = 0; i<numE;i++) {
			if(i%2==0) {
				ex[i] = 675;
				ey[i] = 230;
			}else {
				ex[i] = 580;
				ey[i] = 180;
			}

			angle[i]=20;
			electron[i] = new Ellipse2D.Double();
			electron[i].setFrame(ex[i],ey[i],5,5);
			if(i <= 1) {
				energy[i]=1;
				//Moves the electron over so it lines up in the next orbital.
				ex[i] += 10;
				ey[i] -= 10;
			}
			else {
				energy[i]=2;
				//Moves the electron over so it lines up in the next orbital.
				ex[i] += 55;
				ey[i] += 20;
			}
		}
		ElementTime.start();
	}
	
	
	public void setProtons(int p) {
		protons = p;
	}
	public void setName(String n,String a) {
		name = n;
		abreviation = a;
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
	public String getAbreviation() {
		return abreviation;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i<numElectrons; i++) {
			if(i%2 == 0) {
				ex[i] = ex[i] - (30*energy[i]) * Math.cos(angle[i]);
				ey[i] = ey[i] + (30*energy[i]) * Math.sin(angle[i]);
				angle[i]-=0.5;
			}
			else {
				ex[i] = (ex[i] + (30*energy[i]) * Math.sin(angle[i]));
				ey[i] = ey[i] - (30*energy[i]) * Math.cos(angle[i]);
				angle[i]+=0.5;
			}
				
			electron[i].setFrame(ex[i],ey[i],5,5);
			
		}
	}
}
