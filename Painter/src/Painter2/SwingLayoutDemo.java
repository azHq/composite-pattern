package Painter2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingLayoutDemo {

		private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;
	   private JLabel msglabel;

	   public SwingLayoutDemo(){
	      prepareGUI();
	   }
	   public static void main(String[] args){
	      SwingLayoutDemo swingLayoutDemo = new SwingLayoutDemo();  
	      swingLayoutDemo.showBorderLayoutDemo();       
	   }
	   private void prepareGUI(){
	      mainFrame = new JFrame("Java SWING Examples");
	      mainFrame.setSize(1400,1400);
	      mainFrame.setLayout(new GridLayout(3, 1));

	      headerLabel = new JLabel("",JLabel.CENTER );
	      statusLabel = new JLabel("",JLabel.CENTER);        
	      statusLabel.setSize(350,100);
	      
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }
	   private void showBorderLayoutDemo(){
	      headerLabel.setText("Layout in action: BorderLayout");      

	      JPanel panel = new JPanel();
	      panel.setBackground(Color.darkGray);
	      panel.setSize(1300,1300);
	      BorderLayout layout = new BorderLayout();
	      layout.setHgap(10);
	      layout.setVgap(10);
	      
	      panel.setLayout(layout);        
	      panel.add(new JButton("Center"),BorderLayout.CENTER);
	      panel.add(new JButton("Line Start"),BorderLayout.LINE_START); 
	      panel.add(new JButton("Line End"),BorderLayout.LINE_END);
	      panel.add(new JButton("East"),BorderLayout.EAST);   
	      panel.add(new JButton("West"),BorderLayout.WEST); 
	      panel.add(new JButton("North"),BorderLayout.NORTH); 
	      panel.add(new JButton("South"),BorderLayout.SOUTH); 

	      controlPanel.add(panel);
	      mainFrame.setVisible(true);  
	   }
}
