
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame implements Runnable{
	
	JButton NewGame;
	JButton Exit;
	int x = 200;
	boolean visible = true;
	int a;
	public void run(){
		setSize( 500, 500);
		setResizable(false);
		setLayout(null);
		NewGame = new JButton("New Game");
		NewGame.setBounds(200, 200, 100, 30);
		Exit = new JButton ("Exit");
		Exit.setBounds(200, 250, 100, 30);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(NewGame);
		add(Exit);
		
	}
	
}
