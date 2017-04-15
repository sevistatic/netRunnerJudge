import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Menu extends JPanel{

	ArrayList<JPanel> cards = new ArrayList<JPanel>();
	int hgt;
	int wdt;
	public static JPanel cardPanel;
	
	public static int currentCard;
	public static int numParticipants = 0;
	
	public Menu(int width, int height){
		super();
		
		this.hgt = height;
		this.wdt = width;
		cardPanel = new JPanel(new CardLayout());
		cardPanel.setSize(width, height);
		cards.add(setupMainScreen());
		cardPanel.add(cards.get(0), "MAIN_SCREEN");
		cards.add(new PairingsScreen(width, height));
		cardPanel.add(cards.get(1), "PAIR_SCREEN");
		cards.add(new MatchResultsScreen(width, height));
		cardPanel.add(cards.get(2), "MATCH_RESULTS_SCREEN");
		
		cards.add(new FinalStandingsScreen(width, height));
		cardPanel.add(cards.get(3), "FINAL_STANDINGS_SCREEN");
		cards.add(new MatchSlipsScreen(width, height));
		cardPanel.add(cards.get(4), "MATCH_SLIPS_SCREEN");
		//setupMainScreen();
		//setupMatchResultsScreen();
		//setupFinalStandingsScreen();
		//setupMatchSlips();
		
		add(cardPanel);
		currentCard = 0;
		
	}
	
	public JPanel setupMainScreen(){
		
		JPanel card0 = new JPanel();
		card0.setBackground(Color.black);
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {wdt / 5, wdt /5, wdt /5, wdt / 5, wdt / 5};
		int h = hgt / 8;
		gbl.rowHeights = new int[] {hgt - h, h};
		card0.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		final JPanel namePanel = new JPanel();
		namePanel.setSize(new Dimension(534, 1062));
		namePanel.setAutoscrolls(true);
		JScrollPane scrolly = new JScrollPane(namePanel);
		scrolly.setPreferredSize(new Dimension(534, 312));
		
		GridBagLayout npl = new GridBagLayout();
		npl.columnWidths = new int[] {5, 524};
		npl.rowHeights = new int[] {25};
		namePanel.setLayout(npl);
		GridBagConstraints npc = new GridBagConstraints();
		npc.fill = GridBagConstraints.HORIZONTAL;

		npc.gridx = 0;
		npc.gridy = 0;
		npc.gridwidth = 2;
		namePanel.add(new JLabel("Enter Player Names"), npc);
		
		npc.gridwidth = 1;
		for(int i = 1; i < 65; i++){
			npc.gridy = i;
			npc.gridx = 0;
			namePanel.add(new JLabel("" + i), npc);
			npc.gridx = 1;
			JTextField text = new JTextField();
			namePanel.add(text, npc);
		}
		
		
		GridBagConstraints pc = new GridBagConstraints();
		pc.fill = GridBagConstraints.BOTH;
		pc.gridx = 0;
		pc.gridy = 0;
		pc.gridheight = 1;
		pc.gridwidth = 5;
		card0.add(scrolly, pc);
		
		JButton pairButton = new JButton("Pair");
		pairButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				//get number of participants
				
				for (int i = 0; i < 64; i++){
				if (!((JTextField) namePanel.getComponent(i*2+2)).getText().equals("")){
					numParticipants++;
				}
				}
				
				currentCard = 1;
				CardLayout cl = (CardLayout)(cardPanel.getLayout());
				cl.show(cardPanel, "PAIR_SCREEN");
			}
			
		});
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridy = 1;
		card0.add(pairButton, gbc);

		return card0;
	}

	

}
