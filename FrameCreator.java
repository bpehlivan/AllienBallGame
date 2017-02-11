
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class FrameCreator implements Runnable {
	private Thread t;
	private String threadName;
	JFrame frame, frame2, frame3;
	boolean setVisible = false;
	BallGame bg;
	level2 lvl2;
	level3 lvl3;
	public FrameCreator(String ThreadName ,boolean visible){
		setVisible = visible;
		threadName = ThreadName;
		bg = new BallGame();
		lvl2 = new level2();
		lvl3 = new level3();
	}
	@Override
	public void run() {
		frame = new JFrame();
		frame2 = new JFrame();
		frame3 = new JFrame();
		frame3.setLayout(null);
		frame2.setLayout(null);
		frame.setLayout(null);
			frame.setSize(1500, 900);
			frame2.setSize(1500, 900);
			frame3.setSize(1500, 900);
			bg.setBounds(0, 0, 1500, 900);
			lvl2.setBounds(0, 0, 1500, 900);
			lvl3.setBounds(0, 0, 1500, 900);
			frame.add(bg);
			frame2.add(lvl2);
			frame3.add(lvl3);
			frame.setVisible(setVisible);
			frame2.setVisible(false);
			frame3.setVisible(false);
			frame.setResizable(false);
			frame2.setResizable(false);
			frame3.setResizable(false);
			bg.NextLevel.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frame.setVisible(false);
						frame2.setVisible(true);
					}
					
				} );
			lvl2.NextLevel2.addActionListener(
					new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							frame2.setVisible(false);
							frame3.setVisible(true);
						}
						
					} );
			lvl3.NextLevel.addActionListener(
					new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							frame3.setVisible(false);
							
						}
						
					} );
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void start ()
	   {
	      System.out.println("Creating frame" +  threadName );
	      if (t == null)
	      {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
}
