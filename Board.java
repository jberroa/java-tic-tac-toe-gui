import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class Board extends JFrame{
	
	
	public static int counter = 0 ;
	public static JPanel panel1 = new JPanel(new FlowLayout());
	public static JButton[][] Button;
	
	public   Board(int size) {
		
		panel1.add(new JLabel("Player X Turn"));
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());// adding a container to panel

		
		JPanel panel2 = new JPanel(new GridLayout(size,size)); // giving layout a grid layout
		
		
		
		add(container);// add container and add it to the panels locations 
		container.add(panel1, BorderLayout.PAGE_START);
		container.add(panel2,BorderLayout.CENTER);
		

		Button = new JButton[size][size];
		for(int i=0; i<Button.length;i++)    // make an array of buttons for the panel
			for(int j=0; j<Button.length;j++)
			{
				Button[i][j] = new JButton();
				Button[i][j].addActionListener(new ButtonManager());// add listener so when users click it performs an action
				panel2.add(Button[i][j]);
				
			}
		pack();
	
		 
	}

	 
	 
	 
	

}
