package painter;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Painter extends JFrame{

		
	public JPanel mainpanel;
	public Graphics2D g2d;
	public int cX,cY,height,width;
	public static boolean colorFill=false;
	public static Color color=Color.red;

	public Painter() {
		
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10,10,1500,1000);
		setResizable(false);
		setPanel();
		
		//paint2();
	    setVisible(true);
		
	}
	
	public void setPanel() {
		
		JPanel panel = new JPanel();
	    panel.setBackground(Color.green);
		getContentPane().add(panel,BorderLayout.NORTH);
		panel = new JPanel();
		panel.setBackground(Color.green);
		getContentPane().add(panel,BorderLayout.SOUTH);
		panel = new JPanel();
		panel.setBackground(Color.green);
		getContentPane().add(panel,BorderLayout.WEST);
		
		panel = new JPanel();
		panel.setBackground(Color.green);
		getContentPane().add(panel,BorderLayout.EAST);

		JPanel panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setSize(1600,1800);
	    panel4.setBackground(Color.WHITE);
		getContentPane().add(panel4,BorderLayout.CENTER);
		
		mainpanel = new JPanel();
		mainpanel.repaint();
		mainpanel.setSize(1000,800);
		mainpanel.setBackground(Color.BLACK);
		panel4.add(mainpanel);
		
		panel = new JPanel();
		panel.setBackground(Color.gray);
		panel.setBounds(0,800,1600,800);
		panel4.add(panel);
		
		panel = new JPanel();
		panel.setBackground(Color.gray);
		panel.setBounds(1000,0,600,800);
		panel4.add(panel);
		
		panel.setLayout(null);
		
		Button line=new Button("Add Line");
		line.setBounds(160,40,200,45);
		line.setFont(new Font("serif",Font.BOLD,20));
		line.setForeground(Color.white);
		line.setBackground(Color.blue);
		panel.add(line);
		line.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				g2d=(Graphics2D)mainpanel.getGraphics();
				IShape line=new Line(500,100,300,200);
				line.draw(g2d);
			}
			
		});
		
		Button circle=new Button("Add Circle");
		circle.setBounds(160,110,200,45);
		circle.setFont(new Font("serif",Font.BOLD,20));
		circle.setForeground(Color.white);
		circle.setBackground(Color.blue);
		panel.add(circle);
		
		circle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				takeInputDataForCircle();
			}
			
		});
		
		
		Button triangle=new Button("Add Triangle");
		triangle.setBounds(160,180,200,45);
		triangle.setFont(new Font("serif",Font.BOLD,20));
		triangle.setForeground(Color.white);
		triangle.setBackground(Color.blue);
		panel.add(triangle);
		
		Button reactangle=new Button("Add Rectangle");
		reactangle.setBounds(160,250,200,45);
		reactangle.setFont(new Font("serif",Font.BOLD,20));
		reactangle.setForeground(Color.white);
		reactangle.setBackground(Color.blue);
		panel.add(reactangle);
		
		reactangle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				takeInputDataForRectangle();
			}
			
		});
		
		Button flag=new Button("Add Flag");
		flag.setBounds(160,320,200,45);
		flag.setFont(new Font("serif",Font.BOLD,20));
		flag.setForeground(Color.white);
		flag.setBackground(Color.blue);
		panel.add(flag);
		
		flag.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				takeInputDataForFlag();
			}
			
		});
		
		
		Button clear=new Button("Clear");
		clear.setBounds(160,720,200,45);
		clear.setFont(new Font("serif",Font.BOLD,24));
		clear.setForeground(Color.white);
		clear.setBackground(Color.GREEN);
		panel.add(clear);
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				mainpanel.removeAll();
				revalidate();
				repaint();
			}
			
		});
		
		JLabel c=new JLabel("Choose color:");
		c.setBounds(60,420,200,45);
		c.setFont(new Font("serif",Font.BOLD,28));
		c.setForeground(Color.white);
		c.setBackground(Color.black);
		panel.add(c);
		
		JPanel p=new JPanel();
		p.setBackground(Color.black);
		p.setBounds(60,480,300,150);
		panel.add(p);
		p.setLayout(null);
		
		Button red=new Button();
		red.setBackground(Color.red);
		red.setBounds(10,10,30,30);
		p.add(red);
		
		Button green=new Button();
		green.setBackground(Color.green);
		green.setBounds(50,10,30,30);
		p.add(green);
		
		Button blue=new Button();
		blue.setBackground(Color.blue);
		blue.setBounds(90,10,30,30);
		p.add(blue);
		
		Button yellow=new Button();
		yellow.setBackground(Color.yellow);
		yellow.setBounds(10,50,30,30);
		p.add(yellow);
		
		Button cyan=new Button();
		cyan.setBackground(Color.cyan);
		cyan.setBounds(50,50,30,30);
		p.add(cyan);
		
		Button gray=new Button();
		gray.setBackground(Color.gray);
		gray.setBounds(90,50,30,30);
		p.add(gray);
		
	}
	
	
	public void takeInputDataForFlag() {
		
		JFrame frame=new JFrame("Input Data");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,400,550);
		frame.setLayout(null);
		//frame.setBounds(x, y, width, height);
		JLabel label=new JLabel();
		label.setBounds(10,40,100,40);
		label.setText("Cordinate:");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		
	    label=new JLabel();
		label.setBounds(150,15,80,40);
		label.setText("X");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		JTextField x=new JTextField();
		x.setBounds(120,46,80,30);
		frame.getContentPane().add(x);
		
		
		label=new JLabel();
		label.setBounds(270,15,80,40);
		label.setText("Y");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		JTextField y=new JTextField();
		y.setBounds(240,46,80,30);
		frame.getContentPane().add(y);
		
		
		label=new JLabel();
		label.setBounds(30,130,80,40);
		label.setText("Height:");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		JTextField fieldheight=new JTextField();
		fieldheight.setBounds(120,135,120,32);
		frame.getContentPane().add(fieldheight);
		
		
		label=new JLabel();
		label.setBounds(30,180,80,40);
		label.setText("Width:");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		JTextField fieldwidth=new JTextField();
		fieldwidth.setBounds(120,185,120,32);
		frame.getContentPane().add(fieldwidth);
		
		JButton cancel=new JButton("CANCEL");
		cancel.setBackground(Color.RED);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font(Font.SERIF,Font.BOLD,20));
		cancel.setBounds(50,420,120,40);
		frame.getContentPane().add(cancel);
		
		JButton ok=new JButton("OK");
		ok.setBackground(Color.BLUE);
		ok.setFont(new Font("serif",Font.BOLD,20));
		ok.setForeground(Color.WHITE);
		ok.setBounds(220,420,120,40);
		frame.getContentPane().add(ok);
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				 colorFill=true;
				 cX=Integer.parseInt(x.getText());
				 cY=Integer.parseInt(y.getText());
				 height=Integer.parseInt(fieldheight.getText());
				 width=Integer.parseInt(fieldwidth.getText());
				 
				 Flag flag=new Flag(cX,cY,height,width); 
				 g2d=(Graphics2D)mainpanel.getGraphics();
				 flag.draw(g2d);
				 frame.setVisible(false);
			}
			
		});
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				 frame.setVisible(false);
			}
			
		});
		
		JLabel c=new JLabel("Choose color:");
		c.setBounds(30,240,200,45);
		c.setFont(new Font("serif",Font.BOLD,24));
		c.setForeground(Color.black);
		c.setBackground(Color.black);
		frame.add(c);
		
		JPanel p=new JPanel();
		p.setBackground(Color.black);
		p.setBounds(40,290,200,100);
		frame.add(p);
		p.setLayout(null);
		
		Button red=new Button();
		red.setBackground(Color.red);
		red.setBounds(10,10,30,30);
		p.add(red);
		
		Button green=new Button();
		green.setBackground(Color.green);
		green.setBounds(50,10,30,30);
		p.add(green);
		
		Button blue=new Button();
		blue.setBackground(Color.blue);
		blue.setBounds(90,10,30,30);
		p.add(blue);
		
		Button yellow=new Button();
		yellow.setBackground(Color.yellow);
		yellow.setBounds(10,50,30,30);
		p.add(yellow);
		
		Button cyan=new Button();
		cyan.setBackground(Color.cyan);
		cyan.setBounds(50,50,30,30);
		p.add(cyan);
		
		Button gray=new Button();
		gray.setBackground(Color.gray);
		gray.setBounds(90,50,30,30);
		p.add(gray);
		
		
		frame.setVisible(true);
		
	}
	
	public void takeInputDataForRectangle() {
		
		JFrame frame=new JFrame("Input Data");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,400,550);
		frame.setLayout(null);
		//frame.setBounds(x, y, width, height);
		JLabel label=new JLabel();
		label.setBounds(10,40,100,40);
		label.setText("Cordinate:");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		
	    label=new JLabel();
		label.setBounds(150,15,80,40);
		label.setText("X");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		JTextField x=new JTextField();
		x.setBounds(120,46,80,30);
		frame.getContentPane().add(x);
		
		
		label=new JLabel();
		label.setBounds(270,15,80,40);
		label.setText("Y");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		JTextField y=new JTextField();
		y.setBounds(240,46,80,30);
		frame.getContentPane().add(y);
		
		
		label=new JLabel();
		label.setBounds(30,130,80,40);
		label.setText("Height:");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		JTextField fieldheight=new JTextField();
		fieldheight.setBounds(120,135,120,32);
		frame.getContentPane().add(fieldheight);
		
		
		label=new JLabel();
		label.setBounds(30,180,80,40);
		label.setText("Width:");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		JTextField fieldwidth=new JTextField();
		fieldwidth.setBounds(120,185,120,32);
		frame.getContentPane().add(fieldwidth);
		
		JButton cancel=new JButton("CANCEL");
		cancel.setBackground(Color.RED);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font(Font.SERIF,Font.BOLD,20));
		cancel.setBounds(50,420,120,40);
		frame.getContentPane().add(cancel);
		
		JButton ok=new JButton("OK");
		ok.setBackground(Color.BLUE);
		ok.setFont(new Font("serif",Font.BOLD,20));
		ok.setForeground(Color.WHITE);
		ok.setBounds(220,420,120,40);
		frame.getContentPane().add(ok);
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				 colorFill=false;
				 cX=Integer.parseInt(x.getText());
				 cY=Integer.parseInt(y.getText());
				 height=Integer.parseInt(fieldheight.getText());
				 width=Integer.parseInt(fieldwidth.getText());
				 
				 int[][] point=new int[4][2];
				 point[0][0]=cX;
				 point[0][1]=cY;
					
				 point[1][0]=cX+width;
				 point[1][1]=cY;
					
				 point[2][0]=cX+width;
				 point[2][1]=cY+height;
					
				 point[3][0]=cX;
				 point[3][1]=cY+height;				
				 
				 IShape flag=new Rectangle(point); 
				 g2d=(Graphics2D)mainpanel.getGraphics();
				 flag.draw(g2d);
				 frame.setVisible(false);
			}
			
		});
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				 frame.setVisible(false);
			}
			
		});
		
		JLabel c=new JLabel("Choose color:");
		c.setBounds(30,240,200,45);
		c.setFont(new Font("serif",Font.BOLD,24));
		c.setForeground(Color.black);
		c.setBackground(Color.black);
		frame.add(c);
		
		JPanel p=new JPanel();
		p.setBackground(Color.black);
		p.setBounds(40,290,200,100);
		frame.add(p);
		p.setLayout(null);
		
		Button red=new Button();
		red.setBackground(Color.red);
		red.setBounds(10,10,30,30);
		p.add(red);
		
		red.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				color=Color.red;
			}
			
		});
		
		Button green=new Button();
		green.setBackground(Color.green);
		green.setBounds(50,10,30,30);
		p.add(green);
		
		green.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				color=Color.green;
			}
			
		});
		
		Button blue=new Button();
		blue.setBackground(Color.blue);
		blue.setBounds(90,10,30,30);
		p.add(blue);
		
		blue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				color=Color.blue;
			}
			
		});
		
		Button yellow=new Button();
		yellow.setBackground(Color.yellow);
		yellow.setBounds(10,50,30,30);
		p.add(yellow);
		
		yellow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				color=Color.yellow;
			}
			
		});
		
		Button cyan=new Button();
		cyan.setBackground(Color.cyan);
		cyan.setBounds(50,50,30,30);
		p.add(cyan);
		
		cyan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				color=Color.cyan;
			}
			
		});
		
		Button gray=new Button();
		gray.setBackground(Color.gray);
		gray.setBounds(90,50,30,30);
		p.add(gray);
		
		gray.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				color=Color.gray;
			}
			
		});
		
		
		
		frame.setVisible(true);
		
	}
	
	
	public void takeInputDataForCircle() {
		
		JFrame frame=new JFrame("Input Data");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,400,550);
		frame.setLayout(null);
		//frame.setBounds(x, y, width, height);
		JLabel label=new JLabel();
		label.setBounds(10,40,100,40);
		label.setText("Center:");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		
	    label=new JLabel();
		label.setBounds(150,15,80,40);
		label.setText("cX");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		JTextField x=new JTextField();
		x.setBounds(120,46,80,30);
		frame.getContentPane().add(x);
		
		
		label=new JLabel();
		label.setBounds(270,15,80,40);
		label.setText("cY");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		JTextField y=new JTextField();
		y.setBounds(240,46,80,30);
		frame.getContentPane().add(y);
		
		
		label=new JLabel();
		label.setBounds(30,130,80,40);
		label.setText("Radius:");
		label.setFont(new Font("serif",Font.BOLD,20));
		frame.getContentPane().add(label);
		
		JTextField fieldheight=new JTextField();
		fieldheight.setBounds(120,135,120,32);
		frame.getContentPane().add(fieldheight);
		
		
	
		JButton cancel=new JButton("CANCEL");
		cancel.setBackground(Color.RED);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font(Font.SERIF,Font.BOLD,20));
		cancel.setBounds(50,420,120,40);
		frame.getContentPane().add(cancel);
		
		JButton ok=new JButton("OK");
		ok.setBackground(Color.BLUE);
		ok.setFont(new Font("serif",Font.BOLD,20));
		ok.setForeground(Color.WHITE);
		ok.setBounds(220,420,120,40);
		frame.getContentPane().add(ok);
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				 colorFill=false;
				 cX=Integer.parseInt(x.getText());
				 cY=Integer.parseInt(y.getText());
				 int radius=Integer.parseInt(fieldheight.getText());
				 
				
				 IShape flag=new Circle(cX,cY,radius); 
				 g2d=(Graphics2D)mainpanel.getGraphics();
				 flag.draw(g2d);
				 frame.setVisible(false);
			}
			
		});
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				 frame.setVisible(false);
			}
			
		});
		
		JLabel c=new JLabel("Choose color:");
		c.setBounds(30,240,200,45);
		c.setFont(new Font("serif",Font.BOLD,24));
		c.setForeground(Color.black);
		c.setBackground(Color.black);
		frame.add(c);
		
		JPanel p=new JPanel();
		p.setBackground(Color.black);
		p.setBounds(40,290,200,100);
		frame.add(p);
		p.setLayout(null);
		
		Button red=new Button();
		red.setBackground(Color.red);
		red.setBounds(10,10,30,30);
		p.add(red);
		
		red.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				color=Color.red;
			}
			
		});
		
		Button green=new Button();
		green.setBackground(Color.green);
		green.setBounds(50,10,30,30);
		p.add(green);
		
		green.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				color=Color.green;
			}
			
		});
		
		Button blue=new Button();
		blue.setBackground(Color.blue);
		blue.setBounds(90,10,30,30);
		p.add(blue);
		
		blue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				color=Color.blue;
			}
			
		});
		
		Button yellow=new Button();
		yellow.setBackground(Color.yellow);
		yellow.setBounds(10,50,30,30);
		p.add(yellow);
		
		yellow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				color=Color.yellow;
			}
			
		});
		
		Button cyan=new Button();
		cyan.setBackground(Color.cyan);
		cyan.setBounds(50,50,30,30);
		p.add(cyan);
		
		cyan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				color=Color.cyan;
			}
			
		});
		
		Button gray=new Button();
		gray.setBackground(Color.gray);
		gray.setBounds(90,50,30,30);
		p.add(gray);
		
		gray.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				color=Color.gray;
			}
			
		});
		
		
		
		
		
		
		frame.setVisible(true);
		
	}
	
	
	
	
}
