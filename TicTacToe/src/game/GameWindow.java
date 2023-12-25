package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameWindow implements ActionListener{
		
	Random random= new Random();
	JFrame frame2= new JFrame();
	JPanel titlePanel= new JPanel();
	JPanel buttonPanel= new JPanel();
	JLabel textField= new JLabel();
	JButton[] buttons= new JButton[9];
	boolean playerXTurn, playerOTurn;
	int move=0;
				
	GameWindow(){
		frame2.setSize(500,500);
		frame2.setTitle("Tic Tac Toe");
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setResizable(false);
		frame2.getContentPane().setBackground(new Color(50,50,50));
		frame2.setLocationRelativeTo(null);
				
		textField.setBackground(new Color(50,50,50));
		textField.setOpaque(true);
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Courier",Font.BOLD,50));
		textField.setHorizontalAlignment(JLabel.CENTER);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 800, 100);			
				
		buttonPanel.setLayout(new GridLayout(3,3));		
				
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Malgun Gothic",Font.BOLD,60));
			buttons[i].setBackground(new Color(205,207,222));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
				
			titlePanel.add(textField);
			frame2.add(titlePanel,BorderLayout.NORTH);
			frame2.add(buttonPanel);
				
			turn1();
				
		}
			
		@Override
		public void actionPerformed(ActionEvent e) {
		    for (int i = 0; i < 9; i++) {
		        if (e.getSource() == buttons[i]) {
			            click(i);
		        }
		    }
		}
		public void click(int index) {
		    if (playerXTurn) {
		        move(index, "X", "O");
		    } else {
		        move(index, "O", "X");
		    }
		    move++;
		    if(move==9) {
		    	checkDraw();
		    }
		}
		
		public void checkDraw() {
			
	        boolean allFilled = true;
	        for (JButton button : buttons) {
	            if (button.getText().isEmpty()) {
	                allFilled = false;
	                break;
	            }
	        }
	        
	        if (allFilled) {
	            JOptionPane.showMessageDialog(null, "It's Draw!", "Draw", JOptionPane.INFORMATION_MESSAGE);
	            frame2.dispose();
	        }
	    }
			public void move(int index, String currentPlayer, String nextPlayer) {
		    if (buttons[index].getText().equals("")) {
		        buttons[index].setForeground(getColor(currentPlayer));
		        buttons[index].setText(currentPlayer);
		        playerXTurn = !playerXTurn;
		        textField.setText(nextPlayer + " turn");
		        check();
		    }
		}
			public Color getColor(String player) {
			if(player.equals("X")) {
				new Color(255, 0, 0);
			}
			else {
				new Color(0, 0, 255);
			}
		    return (player.equals("X")) ? new Color(255, 0, 0) : new Color(0, 0, 255);
			}
			public void turn1() {
			
			if(random.nextInt(2)==0) {
				playerXTurn=true;
				textField.setText("X turn");
			}
			else {
				playerOTurn=true;
				textField.setText("O turn");
			}
		}
		
		public void check() {
			if((buttons[0].getText()=="X") &&(buttons[1].getText()=="X") &&(buttons[2].getText()=="X")) {
				xWin(0,1,2);
			}
			if((buttons[3].getText()=="X") &&(buttons[4].getText()=="X") &&(buttons[5].getText()=="X")) {
				xWin(3,4,5);
			}
			if((buttons[6].getText()=="X") &&(buttons[7].getText()=="X") &&(buttons[8].getText()=="X")) {
				xWin(6,7,8);
			}
			if((buttons[0].getText()=="X") &&(buttons[3].getText()=="X") &&(buttons[6].getText()=="X")) {
				xWin(0,3,6);
			}
			if((buttons[1].getText()=="X") &&(buttons[4].getText()=="X") &&(buttons[7].getText()=="X")) {
				xWin(1,4,7);
			}
			if((buttons[2].getText()=="X") &&(buttons[5].getText()=="X") &&(buttons[8].getText()=="X")) {
				xWin(2,5,8);
				}
			if((buttons[0].getText()=="X") &&(buttons[4].getText()=="X") &&(buttons[8].getText()=="X")) {
				xWin(0,4,8);
			}
			if((buttons[2].getText()=="X") &&(buttons[4].getText()=="X") &&(buttons[6].getText()=="X")) {
				xWin(2,4,6);
			}
			
			if((buttons[0].getText()=="O") &&(buttons[1].getText()=="O") &&(buttons[2].getText()=="O")) {
				oWin(0,1,2);
			}
			if((buttons[3].getText()=="O") &&(buttons[4].getText()=="O") &&(buttons[5].getText()=="O")) {
				oWin(3,4,5);
			}
			if((buttons[6].getText()=="O") &&(buttons[7].getText()=="O") &&(buttons[8].getText()=="O")) {
				oWin(6,7,8);
			}
			if((buttons[0].getText()=="O") &&(buttons[3].getText()=="O") &&(buttons[6].getText()=="O")) {
				oWin(0,3,6);
			}
			if((buttons[1].getText()=="O") &&(buttons[4].getText()=="O") &&(buttons[7].getText()=="O")) {
				oWin(1,4,7);
			}
			if((buttons[2].getText()=="O") &&(buttons[5].getText()=="O") &&(buttons[8].getText()=="O")) {
				oWin(2,5,8);
			}
			if((buttons[0].getText()=="O") &&(buttons[4].getText()=="O") &&(buttons[8].getText()=="O")) {
				oWin(0,4,8);
			}
			if((buttons[2].getText()=="O") &&(buttons[4].getText()=="O") &&(buttons[6].getText()=="O")) {
				oWin(2,4,6);
			}
			
		}
		
		public void xWin(int a, int b, int c) {
			buttons[a].setBackground(Color.GREEN);
			buttons[b].setBackground(Color.GREEN);
			buttons[c].setBackground(Color.GREEN);
				
			for(int i=0;i<9;i++) {
				buttons[i].setEnabled(false);
			}
			textField.setText("Winner is X");
			JOptionPane.showMessageDialog(null, "			X Wins","Winner Winner!",1);
			frame2.dispose();
		}
		
		   public void oWin(int a, int b, int c) {
		   	buttons[a].setBackground(Color.GREEN);
			buttons[b].setBackground(Color.GREEN);
			buttons[c].setBackground(Color.GREEN);
			
			for(int i=0;i<9;i++) {
				buttons[i].setEnabled(false);
			}
			textField.setText("Winner is O");
			JOptionPane.showMessageDialog(null, "			O Wins","Winner Winner!",1);
			frame2.dispose();
		}
		   
}