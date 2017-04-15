import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class MatchSlipsScreen extends JPanel {

	int wdt;
	int hgt;
	
	public MatchSlipsScreen(int width, int height){
	super();
	this.wdt = width;
	this.hgt = height;
	
	JPanel slips = new JPanel();
	slips.setPreferredSize(new Dimension(584, 612));
	GridBagLayout gbl = new GridBagLayout();
	gbl.columnWidths = new int[] {40, 40, 60, 40, 40, 40, 40, 40, 40};
	gbl.rowHeights = new int[] {20, 20, 20, 20, 20, 20, 20, 20, 20, 20};
	slips.setLayout(gbl);
	
	GridBagConstraints gbc = new GridBagConstraints();
	for (int i = 0; i < (int)Math.ceil(Menu.numParticipants / 2); i++){
		System.out.println(i);
	}
	
	
	
	
	JScrollPane pane = new JScrollPane(slips);
	pane.setPreferredSize(new Dimension(584, 312));
	
	add(pane);
	}
}
