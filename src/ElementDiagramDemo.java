import javax.swing.JFrame;

public class ElementDiagramDemo {
	public static void main (String[] args) {
		System.out.println("Initializing...");
		JFrame mainView = new JFrame("Element Visualizer");
		
		DrawingComponent DC = new DrawingComponent();
		mainView.add(DC);
		mainView.setSize(400, 400);
		mainView.setVisible(true);
	}
}
