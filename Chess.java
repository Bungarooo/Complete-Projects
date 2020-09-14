import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Chess extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1174297163061350612L;

	private JButton[][] gridButton = new JButton[8][8];
	
	int number = 1;
	
	public static final Color BEIGE = new Color(0xF5F5DC);
	public static final Color GAINSBORO = new Color(0xDCDCDC);
	public static final Color RED = new Color(0xFF0000);
	public static final Color GRAY = new Color(0x97817A);
	public static final Color BLUE = new Color(0x001BFA);
	
	private Color tempC = BLUE;
	
	private MenuBar menuBar = new MenuBar();
	private Menu menuFile = new Menu("File");
	private Menu menuHelp = new Menu("Help");
	private MenuItem menuNew = new MenuItem("New Game");
	private MenuItem menuFileExit = new MenuItem("Exit");
	private MenuItem menuAbout = new MenuItem("About");
	private MenuItem menuChessHelp = new MenuItem("Instructions");
	
	public Chess() {
		
		menuNew.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						resetGame();
					}
				}
				
				);
		
		menuAbout.addActionListener
        (
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {
                	ImageIcon icon = new ImageIcon("images/logo.jpg");
                	String message = "This is the wonderful game chess. Coded by Ben Ungar, "
                			+ "with some base code from\na class taught by Andy Abreu. " 
                			+ "And inspired by the glorious Dylan Wood.";
                	JOptionPane.showMessageDialog(null,message,"Chess",JOptionPane.INFORMATION_MESSAGE,icon);
                }
            }
     	);
		
		
		 menuFileExit.addActionListener
	        (
	            new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    Chess.this.windowClosed();
	                }
	            }
	        );
		 
		 menuChessHelp.addActionListener
	        (
	            new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                	ImageIcon icon = new ImageIcon("images/chess.jpg");
	                	String message = "This chess game is unrestricted in controls so you can cheat... "
	                	+ "but don't, that takes away the fun.\n\nP.S. Subscribe to Pewdiepie";
	                	JOptionPane.showMessageDialog(null,message,"Chess Help",JOptionPane.INFORMATION_MESSAGE,icon);
	                }
	            }
	     	);
		 
		 menuFile.add(menuNew);
	     menuFile.addSeparator();       
	     menuFile.add(menuFileExit);
	     menuHelp.add(menuAbout);
	     menuHelp.add(menuChessHelp);
         menuBar.add(menuFile);
         menuBar.add(menuHelp);
		 setMenuBar(menuBar);
		 
		 JPanel panel = new JPanel();
		 panel.setLayout(new GridLayout(8,8));
		 
		 for(int i=0;i<8;i++) {
				gridButton[i] = new JButton[8];
				for(int j=0;j<8;j++) {
					gridButton[i][j] = new JButton();
					gridButton[i][j].setFont(new Font("Courier New",Font.BOLD,16));
		   			gridButton[i][j].setForeground(Color.blue);
		   			gridButton[i][j].setText("");		   			
		   			gridButton[i][j].setFocusable(false);		   			
		   			gridButton[i][j].addActionListener(this);
		   			gridButton[i][j].setBackground(GAINSBORO);
		   			
		   			if((i+j)%2 != 0) {
		   				gridButton[i][j].setBackground(BEIGE);
		   			}
					panel.add(gridButton[i][j]); 
				}
		 }
		 
		 setLayout(new BorderLayout());
		 add(panel,BorderLayout.CENTER);
		 
		 this.addWindowListener
	        (
	            new WindowAdapter() {
	                public void windowClosing(WindowEvent e) {
	                    Chess.this.windowClosed();
	                }
	            }
	        ); 
		 
		 setBoard();
	}
	
	
	public void setBoard() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(i == 1) {
					gridButton[i][j].setText("P");
					gridButton[i][j].setForeground(BLUE);
				}
				else if(i == 6) {
					gridButton[i][j].setText("P");
					gridButton[i][j].setForeground(RED);
				}
				else if(i == 0 && j == 0 || i == 0 && j == 7) {
					gridButton[i][j].setText("R");
					gridButton[i][j].setForeground(BLUE);
				}
				else if(i == 0 && j == 1 || i == 0 && j == 6) {
					gridButton[i][j].setText("N");
					gridButton[i][j].setForeground(BLUE);
				}
				else if(i == 0 && j == 2 || i == 0 && j == 5) {
					gridButton[i][j].setText("B");
					gridButton[i][j].setForeground(BLUE);
				}
				else if(i == 0 && j == 3 ) {
					gridButton[i][j].setText("K");
					gridButton[i][j].setForeground(BLUE);
				}
				else if(i == 0 && j == 4) {
					gridButton[i][j].setText("Q");
					gridButton[i][j].setForeground(BLUE);
				}
				else if(i == 7 && j == 0 || i == 7 && j == 7) {
					gridButton[i][j].setText("R");
					gridButton[i][j].setForeground(RED);
				}
				else if(i == 7 && j == 1 || i == 7 && j == 6) {
					gridButton[i][j].setText("N");
					gridButton[i][j].setForeground(RED);
				}
				else if(i == 7 && j == 2 || i == 7 && j == 5) {
					gridButton[i][j].setText("B");
					gridButton[i][j].setForeground(RED);
				}
				else if(i == 7 && j == 3 ) {
					gridButton[i][j].setText("K");
					gridButton[i][j].setForeground(RED);
				}
				else if(i == 7 && j == 4) {
					gridButton[i][j].setText("Q");
					gridButton[i][j].setForeground(RED);
				}
				
			}
		}
	}
	
	public void resetGame() {
		for(int i=0; i<8 ; i++) {
		   	for(int j=0;j<8;j++)
		   	{
		   		gridButton[i][j].removeActionListener(this);
	   			gridButton[i][j].setForeground(Color.red);
	   			gridButton[i][j].setText("");
	   			gridButton[i][j].setFocusable(false);		   			
	   			gridButton[i][j].addActionListener(this);
		   	}
		}
		
		setBoard();
    }
	
	public void actionPerformed(ActionEvent e) {
		boolean hasGray = false;
		JButton temp = null;
		
		for(int a = 0; a < 8; a++) {
			for(int b = 0; b < 8; b++) {
				if(gridButton[a][b].getBackground() == GRAY) {
					hasGray = true;
					temp = gridButton[a][b];
				}
			}
		}
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if((JButton)e.getSource() == gridButton[i][j]) {
					if(hasGray == true) {
						if(gridButton[i][j].getBackground() == GRAY) {
							gridButton[i][j].setBackground(tempC);
							return;
						}
						
						gridButton[i][j].setText(temp.getText());
						gridButton[i][j].setForeground(temp.getForeground());
						temp.setBackground(tempC);
						temp.setText("");
					}
					else {
						if(gridButton[i][j].getText() != "") {
							
							tempC = gridButton[i][j].getBackground();
							gridButton[i][j].setBackground(GRAY);
						}
					}
				}
			}
		}
	}
	
	protected void windowClosed() {        
        System.exit(0);
    }
	
	public static void main(String[] args) {
		Chess game = new Chess();
        game.setTitle("Play Chess"); 		// add title to the frame       
        //game.setSize(new Dimension(470, 480));	// set the size of the frame
        game.setSize(new Dimension(470, 470));
        game.setResizable(false);				// frame's size is fixed        
        game.setVisible(true);
	}
}
