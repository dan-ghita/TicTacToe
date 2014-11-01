package tictactoeV2;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TicTacToe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final int columns = 3, rows = 3;
	private ButtonWithCoordinates[][] board = new ButtonWithCoordinates[rows][columns];
	private Character lastSymbol = 'O';
	private static TicTacToe frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TicTacToe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TicTacToe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(rows, columns));
		setContentPane(contentPane);

		for (int i = 0; i < rows; ++i)
			for (int j = 0; j < columns; ++j) {
				ButtonWithCoordinates newButton = new ButtonWithCoordinates(i,
						j, "");
				board[i][j] = newButton;
				newButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.format("You clicked button %d, %d \n",
								newButton.getXCoordinate(), newButton.getYCoordinate());
						// System.out.format("You clicked button %d, %d \n",
						// newButton.getX(), newButton.getY());
						
						if(newButton.getText() == ""){
							if (lastSymbol == 'O') {
								newButton.setText("X");
								lastSymbol = 'X';
							} else {
								newButton.setText("O");
								lastSymbol = 'O';
							}							
						}
						
						if(check(lastSymbol, newButton.getXCoordinate(), newButton.getYCoordinate())){
							String playAgain;
							if(lastSymbol == 'X'){
//								frame.setVisible(false);
								playAgain = JOptionPane.showInputDialog("First player won!\n Would you like to play again? Yes/No");
							}
							else{
//								frame.setVisible(false);								
								playAgain = JOptionPane.showInputDialog("Second player won!\n Would you like to play again? Yes/No");
							}
							
							if(playAgain.toLowerCase().equals("yes")){
								initBoard();
								frame.setVisible(true);
							}
						}									
					}
				});
				contentPane.add(newButton);

			}

	}

	
private void initBoard(){
	
	for (int i = 0; i < rows; i++)
		for (int j = 0; j < columns; j++) 
			board[i][j].setText("");
	lastSymbol = 'O';
	
	
	
}
public Boolean check(Character lastSymbol, int x, int y){
		
		Boolean ok;
		
		// check row
		ok = true;
		for (int i = 0; i < rows; i++) {
			if(board[x][i].getText().equals(Character.toString(lastSymbol)))
				continue;
			else
				ok = false;
		}
		if(ok) return true;
		
		// check column
		ok = true;
		for (int i = 0; i < columns; i++) {
			if(board[i][y].getText().equals(Character.toString(lastSymbol)))
				continue;
			else
				ok = false;
		}
		if(ok) return true;
		
		if(x == y){ // diagonala principala x = y
			ok = true;
			for (int i = 0; i < rows; i++) {
				if(board[i][i].getText().equals(Character.toString(lastSymbol)))
					continue;
				else
					ok = false;
			}
			if(ok) return true;
		}
		
		if(x+y == rows - 1){ // x+y = n+1-2, diagonala secundara
			ok = true;
			for (int i = 0; i < rows; i++) {
				if(board[i][2 - i].getText().equals(Character.toString(lastSymbol)))
					continue;
				else
					ok = false;
			}
			if(ok) return true;
			
		}
		
		return false;
	}
	

}
