import javax.swing.JFrame;
import java.io.IOException;
public class ElementDiagramDemo{
	public static void main (String[] args) {
		System.out.println("Initializing...");
		JFrame mainView = new JFrame("Element Visualizer");
		
		DrawingComponent DC = new DrawingComponent();
		//loads all of the element data
		try {
			DC.dataLoad();
		}catch(IOException e) {
			System.out.println("Data failed to load");
		}
		mainView.add(DC);
		mainView.setSize(1200, 800);
		mainView.setVisible(true);
	}
}
