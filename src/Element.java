
public class Element {
	private int electrons;
	private int protons;
	private String name;
<<<<<<< Updated upstream
=======
	private String abreviation;
    private double ex[];
    private double ey[];
    private float angle[];
    private int energy[];
    private Ellipse2D.Double[] electron;
    
	public Element(double width, double height, int numE) {
		Timer ElementTime  = new Timer (90,this);
		numElectrons = numE;
	    electron = new Ellipse2D.Double[numE];
	    ex = new double [numE];
	    ey = new double [numE];
	    angle = new float[numE];
	    energy = new int[numE];
	    
		for(int i = 0; i<numE;i++) {

				ex[i] = 675;
				ey[i] = 230;

			angle[i]=20;
			electron[i] = new Ellipse2D.Double();
			electron[i].setFrame(ex[i],ey[i],5,5);
			if(i <= 1) {
				energy[i]=1;
			}
			else {
				energy[i]=2;
			}
		}
		ElementTime.start();
	}
	
>>>>>>> Stashed changes
	
	public void setElectrons(int e) {
		electrons = e;
	}
	public void setProtons(int p) {
		protons = p;
	}
	public void setName(String n, String a) {
		name = n;
		abreviation = a;
	}
	
	public int getElectrons() {
		return electrons;
	}
	public int getProtons() {
		return protons;
	}
	public String getName() {
		return name;
	}
<<<<<<< Updated upstream
=======
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
				ex[i] = ex[i] + (30*energy[i]) * Math.cos(angle[i]);
				ey[i] = ey[i] - (30*energy[i]) * Math.sin(angle[i]);
				angle[i]+=0.5;
			}
				
			electron[i].setFrame(ex[i],ey[i],5,5);
			
		}
	}
>>>>>>> Stashed changes
}
