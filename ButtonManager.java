import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import sun.java2d.Disposer;

import com.sun.codemodel.internal.JOp;
import com.sun.jdi.event.Event;


public class ButtonManager implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		
		
			

        JButton b = (JButton)e.getSource();
        b.setEnabled(false);
        
        
       if( Board.counter % 2 == 0)// check to see who turn is it x or o's
       {
    	   
    		Board.panel1.removeAll();// remove name in panel1
    	   Board.panel1.add(new JLabel("Player O turn")); // add labe to panel 1
    	   
    	  Board.counter++;				// increase counter for moves 
    	 b.setText("X");				//set buttons text to string 
    	 if(gameOver("x", Board.counter))// checks if game is over
    	 {
    		 Board.panel1.removeAll();
    		 //ask if you want to play again 
    		 int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Confirm",
                     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
             if (response == JOptionPane.NO_OPTION) {
                 System.exit(0);
             } else if (response == JOptionPane.YES_OPTION) {
              
            	 Menu.m.dispose(); //get rid of old window and start main agian
                 Main.main(new String[0] );
                Board.counter =0;
                
             }
         } 
    	 }
    	 
       
       else
       {
    	   // same thing as top except just for o's turn
    	   	Board.panel1.removeAll();
    	   Board.panel1.add(new JLabel("Player X turn"));
    	   Board.counter++;
    	   b.setText("O");
    		 if(gameOver("o", Board.counter))
        	 {
        		 Board.panel1.removeAll();
        		 if(gameOver("o", Board.counter))
            	 {
            		 Board.panel1.removeAll();
            		 
            		 int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Confirm",
                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                     if (response == JOptionPane.NO_OPTION) {
                         System.exit(0);
                     } else if (response == JOptionPane.YES_OPTION) {
                      
                                  
                                    Menu.m.dispose();
                                   Main.main(new String[0] );
                                   Board.counter =0;
                     }
                 } 
        	 }
       }
    }
	

    public boolean gameOver(String piece, int nmoves)
    {   if (sbdyWon(piece)) // checks if somebody won
        {   //JOptionPane.showMessageDialog(null,"Player"+ piece+" Won!");
            return true;
        }
        else
        {   if (nmoves == Board.Button.length*Board.Button[0].length) //draw! if moves == 9 and nobody won
            {   JOptionPane.showMessageDialog(null, "Draw! You BOTH are Sore loosers!");
                return true;
            }
            else
                return false;
        }
    }

    public boolean sbdyWon(String piece)
    {   if (horiz(piece) || vert(piece) || diag(piece)) // checks method for what types of win
            return true;
        return false;
    }

    public boolean horiz(String piece)
    {   for (int i=0; i<Board.Button.length;i++) 
        {  int count = 0;
            for (int j=0; j<Board.Button[0].length;j++)
            {   if (Board.Button[i][j].getText().equalsIgnoreCase(piece)) // checks if positions match horizontally 
                    count++;
                else
                    break;
            }
           if (count == Board.Button[0].length) // if counter = 3 then we have a winner
           {
        	   JOptionPane.showMessageDialog(null, "Player "+piece.toUpperCase()+" Won Horizontally!");
               return true;
           }
        }
        return false;
    }

     public boolean vert(String piece)
    {   for (int i=0; i<Board.Button.length;i++)
        {  int count = 0;
            for (int j=0; j<Board.Button[0].length;j++)
            {   if (Board.Button[j][i].getText().equalsIgnoreCase(piece))// checks for vertical win by checking pieces
                    count++;
                else
                    break;
            }
           if (count == Board.Button.length)
           {
        	   JOptionPane.showMessageDialog(null, "Player "+piece.toUpperCase()+" Won Veritically!");
               return true;
           }
        }
        return false;
    }

     public boolean diag(String piece)
     {  if (leftDiag(piece) || rightDiag(piece))// checkes if left or right diaganol method returns true
            return true;
         return false;
     }

     public boolean leftDiag(String piece)
     {  int x =0, y =0, count=0;

        for (int i=0; i<Board.Button.length;i++)
        {   if (Board.Button[x][y].getText().equalsIgnoreCase(piece))// checks the vertical from left to right to check for win
            {        count++;
                     x++;
                     y++;
            }
            else
                break;
        }
        if (count == Board.Button.length)
        {
     	   JOptionPane.showMessageDialog(null, "Player "+piece.toUpperCase()+" Won Left Diaganol!");
            return true;
        }
        return false;
     }

     public boolean rightDiag(String piece)
     {  int x =0, y =Board.Button[0].length-1, count=0;

        for (int i=0; i<Board.Button.length;i++)
        {   if (Board.Button[x][y].getText().equalsIgnoreCase(piece))// checks from right to left for right diagonal 
            {        count++;
                     x++;
                     y--;
            }
            else
                break;
        }
        if (count == Board.Button.length)
        {
      	   JOptionPane.showMessageDialog(null, "Player "+piece.toUpperCase()+" Won Right Diaganolly!");
             return true;
         }
        return false;
     }




}
