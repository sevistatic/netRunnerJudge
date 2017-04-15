import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class MatchResultsScreen extends JPanel {
	int wdt;
	int hgt;

	public MatchResultsScreen(int width, int height){
		super();
		this.wdt = width;
		this.hgt = height;
				setBackground(Color.black);
				GridBagLayout gbl = new GridBagLayout();
				gbl.columnWidths = new int[] {wdt / 5, wdt /5, wdt /5, wdt / 5, wdt / 5};
				int h = hgt / 8;
				gbl.rowHeights = new int[] {hgt - h, h};
				setLayout(gbl);
				GridBagConstraints gbc = new GridBagConstraints();

				JPanel namePanel = new JPanel();
				namePanel.setSize(new Dimension(534, 362));
				GridBagConstraints pc = new GridBagConstraints();
				pc.fill = GridBagConstraints.BOTH;
				pc.gridx = 0;
				pc.gridy = 0;
				pc.gridheight = 1;
				pc.gridwidth = 5;
				
				add(namePanel, pc);
				
				JButton goBackButton = new JButton("Go Back");
				goBackButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent evt) {
						// TODO Auto-generated method stub
						Menu.currentCard = 1;
						CardLayout cl = (CardLayout)(Menu.cardPanel.getLayout());
						System.out.println( ((JButton)evt.getSource()).getText() );
						cl.show(Menu.cardPanel, "PAIR_SCREEN");
					}
					
				});
				gbc.fill = GridBagConstraints.BOTH;
				gbc.gridx = 0;
				gbc.gridy = 1;
				gbc.gridheight = 1;
				gbc.gridwidth = 1;
				gbc.gridy = 1;
				add(goBackButton, gbc);
				
				JButton enterResultsButton = new JButton("Confirm Results");
				enterResultsButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent evt) {
						// TODO Auto-generated method stub
						Menu.currentCard = 1;
						CardLayout cl = (CardLayout)(Menu.cardPanel.getLayout());
						System.out.println( ((JButton)evt.getSource()).getText() );
						cl.show(Menu.cardPanel, ((JButton)evt.getSource()).getText());
					}
					
				});
				gbc.gridx = 4;
				add(enterResultsButton, gbc);
				
			}
			
}
