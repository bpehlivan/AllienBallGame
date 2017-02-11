
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Source {
	public static void main(String args[]){
		
		FrameCreator frame = new FrameCreator( "frame1", true);
		Menu menu = new Menu();
		
		menu.run();
		menu.setVisible(true);
		menu.NewGame.addActionListener(
				new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						frame.run();
						
						
					}
				}	
		);
		menu.Exit.addActionListener(
				new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						frame.frame.dispose();
						frame.frame2.dispose();
						frame.frame3.dispose();
						menu.dispose();
						
					}
				}	
		);
	}
}
