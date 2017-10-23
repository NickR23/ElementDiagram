import javax.swing.JFrame;
import java.io.IOException;
public class ElementDiagramDemo{
	public static void main (String[] args) {
		System.out.println("Initializing...");
		JFrame mainView = new JFrame("Element Visualizer");
		
		DrawingComponent DC = new DrawingComponent();

		mainView.add(DC);
		mainView.setSize(1200, 800);
		mainView.setVisible(true);
	}
}
