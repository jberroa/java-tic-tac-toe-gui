import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Menu extends JFrame{
	public static Board m;
	
	public Menu()
{
		
		JPanel p = new JPanel(new BorderLayout());
		JPanel p1 = new JPanel(new FlowLayout());
		add(p);
		ImageIcon ttt = new ImageIcon("ttt.jpg");
		p.add(new JLabel(ttt),BorderLayout.CENTER);
		p.add(p1,BorderLayout.PAGE_START);
		JLabel text = new JLabel();
		text.setFont(new Font( "SansSerif", Font.ITALIC, 38));
		
		text.setText("Best Tic Tac Toe Ever!!!");
		p1.add(text);
		
		JButton button = new JButton();
		button.setText("Start Game!!");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				 m = new Board(3);
				m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				m.setSize(500,500);
				m.setVisible(true);

				
			}
		});
		
		p.add(button,BorderLayout.PAGE_END);
		pack();
		
	
}
	
}
