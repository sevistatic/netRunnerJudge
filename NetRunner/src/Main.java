import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {

	public static void main(String[] args) {
		JFrame programFrame = new JFrame("Android Netrunner Event Reporter");
		programFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		programFrame.setSize(new Dimension(600, 400));
		
		programFrame.setLocationRelativeTo(null);
		JPanel mainMenu = new Menu(584, 362);//size content pane will be after it turns visible
		programFrame.setContentPane(mainMenu);

		programFrame.setVisible(true);
	}

	public static void pause(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
