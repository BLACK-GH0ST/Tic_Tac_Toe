import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener{
	// all classes we will be using for tic tac toe
	Random random = new Random ();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel =  new JPanel();
	JLabel text_field = new JLabel();
	JButton[] buttons = new JButton[9];
	// No need for player two boolean because is player is not called then
	//player two will be the one to start the game.
	boolean player1_turn;
	
	
	
	//here is the code for the constructor...
	TicTacToe () {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		
		text_field.setBackground(new Color(25, 25, 25));
		text_field.setForeground(new Color(25, 255, 0));
		text_field.setFont(new Font("Ink Free", Font.BOLD, 75));
		text_field.setHorizontalAlignment(JLabel.CENTER);
		text_field.setText("Tic Tac Toe");
		text_field.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3, 3));
		button_panel.setBackground(new Color(150, 150, 150));
		
		/*For the button in the game 1-9. for the 
		 * Key pressed on the Game.
		 *            ___                 ___                  ___ 
		 * Square_One |_|      Square_Two |_|     Square_Three |_|
		 *             ___                 ___               ___
		 * Square_Four |_|     Square_Five |_|    Square_Six |_|
		 *               ___               ___               ___
		 *  Square_Seven |_|  Square_Eight |_|   Square_Nine |_|
		 */
		
		for (int i=0; i<9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("San serif", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(text_field);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		firstTurn();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<9; i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText() == ""){
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						player1_turn = false;
						text_field.setText("O Turn");
						Check();
					}
				} 
			else {
				  if(buttons[i].getText() == ""){
					buttons[i].setForeground(new Color(0, 0, 255));
					buttons[i].setText("O");
					player1_turn = true;
					text_field.setText("X Turn");
					Check();
				}
				
			}
		}
	}
		
	}
	
	public void firstTurn() {
		
		try{Thread.sleep(2000);
		} catch (InterruptedException e) {
		 // TODO Auto-generate catch block
		 e.printStackTrace();	
		}
		if(random.nextInt(2) == 0) {
			player1_turn= true;
			text_field.setText("X Turn");
		} else {
			player1_turn = false;
			text_field.setText("O Turn");
		}
	}
	
	public void Check() {
		//Check X win Conditions
		if (
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0, 1, 2);
			
		}
		if (
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3, 4, 5);
			
		}
		if (
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6, 7, 8);
			
		}
		if (
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0, 3, 6);
			
		}
		if (
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1, 4, 7);
			
		}
		if (
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2, 5, 8);
			
		}
		if (
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0, 4, 8);
			
		}
		if (
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2, 4, 6);
			
		}
		//Check O win Conditions
		
		if (
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0, 1, 2);
			
		}
		if (
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3, 4, 5);
			
		}
		if (
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6, 7, 8);
			
		}
		if (
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0, 3, 6);
			
		}
		if (
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1, 4, 7);
			
		}
		if (
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2, 5, 8);
			
		}
		if (
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0, 4, 8);
			
		}
		if (
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2, 4, 6);
			
		}
		
	}
	
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
	
		for(int i=0; i>9; i++) {
			buttons[i].setEnabled(false);
		}
		text_field.setText("Abandon all hope O");
	}
	
public void oWins(int a, int b, int c) {
	buttons[a].setBackground(Color.GREEN);
	buttons[b].setBackground(Color.GREEN);
	buttons[c].setBackground(Color.GREEN);

	for(int i=0; i>9; i++) {
		buttons[i].setEnabled(false);
	}
	text_field.setText("Abandon all hope X");
	}
	
}
