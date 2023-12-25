package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TicTacToe implements ActionListener{
	
	JFrame frame= new JFrame();
	JLabel GameName= new JLabel();
	JButton startButton= new JButton();

    public static void main(String[] args) {
		
    	new TicTacToe();
	}
    
    TicTacToe(){
		
		frame.setSize(500,500);
		frame.setTitle("Tic Tac Toe");
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(153,204,255));
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		GameName.setText("Tic Tac Toe");
		GameName.setForeground(new Color(139,0,0));
		GameName.setFont(new Font("Gabriola",Font.BOLD,65));
		GameName.setHorizontalAlignment(JLabel.CENTER);
		GameName.setLayout(null);
		
		startButton.setBounds(170, 300, 150, 40);
		startButton.setText("Start Game");
		startButton.setFocusable(false);
		startButton.setFont(new Font("Comic Sans",Font.PLAIN,20));
		startButton.addActionListener(this);

		GameName.add(startButton);
		frame.add(GameName);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton) {
			frame.dispose();
			new GameWindow();
	    }
	}
	
}