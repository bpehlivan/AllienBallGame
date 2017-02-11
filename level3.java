
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class level3 extends JPanel implements ActionListener, ChangeListener  {
	double x = 0, y = 744, Xvel = 1,Yvel = -1,  a = 10;
	double LineX = 110, LineY = 680;
	boolean Collusion = false;
	boolean Alien1Int = false;
	boolean Alien1IntCheck = false;
	boolean Visible = false;
	JButton NextLevel = new JButton("Menu");
	Timer t;
	ImageIcon barrierImg;
	ImageIcon alien1;
	
	JSlider power = new JSlider( 0, 100, 50);
	JSlider angle = new JSlider( 0,90, 45);
	JLabel powerLabel = new JLabel();
	JLabel AngleLabel = new JLabel();
	public level3(){
		setLayout(null);
		t = new Timer(1 , this);
		if(t.isRunning()){
			setFocusable(false);
		}else{
			setFocusable(true);
		}
		power.setMajorTickSpacing(20);
		this.setBackground(Color.WHITE);
		angle.setMajorTickSpacing(30);
		power.setPaintTicks(true);
		angle.setPaintTicks(true);
		power.setPaintLabels(true);
		angle.setPaintLabels(true);
		power.addChangeListener(this);
		angle.addChangeListener(this);
		power.setBounds(200, 800, 200, 50);
		angle.setBounds(470, 800, 200, 50);
		NextLevel.setBounds( 550, 300, 150, 50);
		powerLabel.setText("power");
		AngleLabel.setText("Angle");
		powerLabel.setBounds(160, 800, 40, 30);
		AngleLabel.setBounds(420, 800, 40, 30);
		
		
		add(NextLevel);
		add(powerLabel);
		add(AngleLabel);
		add(power);
		add(angle);
		
		JButton FireButton = new JButton("Fire");
		JButton ResetButton = new JButton("Try Again");
		ResetButton.setBounds(0, 0, 100, 40);
		ResetButton.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						x = 0;
						y = 744;
						Xvel = 1;
						Yvel = -1;
						repaint();
						t.stop();
					}
					
				} 
				);
		add(ResetButton);
		FireButton.setBounds(26, 800, 100, 40);
		add(FireButton);
		FireButton.addActionListener(
				
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						t.start();
					}
					
				} 
				);
	}
	
	
	public void paintComponent(Graphics g){
		
		NextLevel.setVisible(Visible);
		super.paintComponent(g);
		if(Alien1IntCheck == true){
				Visible = true;
				
				
				repaint();
		}
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D barrier = new Rectangle2D.Double(400,550,50,220);
		Rectangle2D ground = new Rectangle2D.Double( 0, 770, 1500, 15);
		Rectangle2D Allien1 = new Rectangle2D.Double( 510, 690, 40, 80);
		Ellipse2D ball = new Ellipse2D.Double( x, y, 25, 25);
		Line2D line = new Line2D.Double( 20, 770, LineX, LineY);
		barrierImg = new ImageIcon("barrier.png");
		
		barrierImg.paintIcon(this,g,400,550);
		
		alien1 = new ImageIcon("alienImage.png");
	if(Alien1Int == true){
		Alien1IntCheck = true;
	}
	if(Alien1IntCheck == false){
		
		alien1.paintIcon(this, g, 470, 650);
	}
		g2.draw(line);
		g2.draw(barrier);
		g2.draw(Allien1);
		g2.draw(ball);
		g2.draw(ground);
		
		g2.setColor(Color.RED);
		Alien1Int = ball.intersects(Allien1);
		 Collusion = ball.intersects(barrier);
		g2.setColor(Color.BLACK);
		
		g2.fill(line);
		g2.fill(ball);
		g2.setColor(Color.GREEN);
		g2.fill(ground);
	}

	public void actionPerformed(ActionEvent e) {
	
		if(x < 0 || x > 1475){
			Xvel = -Xvel;
		}
		if(y > 744 ){
			t.stop();
		}
		if(Collusion == true){
			if(y < 550){
				Yvel = -Yvel;
			}else{
				Xvel = -Xvel;
			}
		}
		x = x + Xvel;
		y = y + Yvel;
		Yvel = Yvel + (0.004);
		repaint();
	}

	
	
	
	double aY = 0;
	@Override
	public void stateChanged(ChangeEvent e) {
		if(t.isRunning()== false){
			double takenValue = (double) power.getValue();
			double takenAngle =(double) angle.getValue();
			
			aY = (takenAngle)/45;
			if(takenAngle == 90){
				Xvel = 0;
			}
			else{
			
				Xvel = (takenValue)/(25*aY);
			}
			LineY = 770 - takenAngle*2;//*((takenAngle/45)*(takenAngle/45));
			LineX = 150 - takenAngle;
			Yvel = -aY*(takenValue)/25;
			repaint();
		}else
		{
			
		}
	}

	
		
	}
