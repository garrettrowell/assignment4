package assignment4;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class menuDraw extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final int width = 800;
    private static final int height = 400;
    private static JButton fileBtn,exitBtn,graphBtn;
    private static JLabel lbl1,lbl2;
    private static JRadioButton MaxF,MeanF,MinF,MaxDewF,MeanDewF,MinDewF,MaxHum,MeanHum,MinHum,MaxPress,MeanPress,MinPress,MaxVis,MeanVis,MinVis,MaxWind,MeanWind;
    
	public static void createAndShowGUI(){
        menuDraw mainPanel = new menuDraw();
        mainPanel.setPreferredSize(new Dimension(width, height));
        JFrame frame = new JFrame("MainMenu");
        mainPanel.setLayout(new GridLayout(1,2));
        
        //Sets up RadioButtons
        JPanel leftPnl = new JPanel();
        leftPnl.setLayout(new GridLayout(18,1));
        MaxF=new JRadioButton ("MaxF");
        MeanF=new JRadioButton ("MeanF");
        MinF=new JRadioButton ("MinF");
        MaxDewF=new JRadioButton ("MaxDewF");
        MeanDewF=new JRadioButton ("MeanDewF");
        MinDewF=new JRadioButton ("MinDewF");
        MaxHum=new JRadioButton ("MaxHum");
        MeanHum=new JRadioButton ("MeanHum");
        MinHum=new JRadioButton ("MinHum");
        MaxPress=new JRadioButton ("MaxPress");
        MeanPress=new JRadioButton ("MeanPress");
        MinPress=new JRadioButton ("MinPress");
        MaxVis=new JRadioButton ("MaxVis");
        MeanVis=new JRadioButton ("MeanVis");
        MinVis=new JRadioButton ("MinVis");
        MaxWind=new JRadioButton ("MaxWind");
        MeanWind=new JRadioButton ("MeanWind");
        lbl1=new JLabel("Select Data Set To Graph:");
        
        final ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(MaxF);
        radioButtons.add(MeanF);
        radioButtons.add(MinF);
        radioButtons.add(MaxDewF);
        radioButtons.add(MeanDewF);
        radioButtons.add(MinDewF);
        radioButtons.add(MaxHum);
        radioButtons.add(MeanHum);
        radioButtons.add(MinHum);
        radioButtons.add(MaxPress);
        radioButtons.add(MeanPress);
        radioButtons.add(MinPress);
        radioButtons.add(MaxVis);
        radioButtons.add(MeanVis);
        radioButtons.add(MinVis);
        radioButtons.add(MaxWind);
        radioButtons.add(MeanWind);
        
        leftPnl.add(lbl1);
        leftPnl.add(MaxF);
        leftPnl.add(MeanF);
        leftPnl.add(MinF);
        leftPnl.add(MaxDewF);
        leftPnl.add(MeanDewF);
        leftPnl.add(MinDewF);
        leftPnl.add(MaxHum);
        leftPnl.add(MeanHum);
        leftPnl.add(MinHum);
        leftPnl.add(MaxPress);
        leftPnl.add(MeanPress);
        leftPnl.add(MinPress);
        leftPnl.add(MaxVis);
        leftPnl.add(MeanVis);
        leftPnl.add(MinVis);
        leftPnl.add(MaxWind);
        leftPnl.add(MeanWind);
                
        //Right Side of menu
    	graphBtn = new JButton("Graph");
    	exitBtn = new JButton("Exit");
    	fileBtn = new JButton("Select File to Graph");
    	
    	lbl2 = new JLabel("Data File");
        JPanel rightPnl = new JPanel();
        rightPnl.setLayout(new GridLayout(2,2));
        rightPnl.add(lbl2);
        rightPnl.add(fileBtn);
        rightPnl.add(graphBtn);
        rightPnl.add(exitBtn);
        
    	//add right+left panels to main panel 
    	mainPanel.add(rightPnl);
    	mainPanel.add(leftPnl);
    	
    	//Action Listeners
    	exitBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);				
			}
    	}
    			);
    	
    	graphBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JRadioButton temp=null;
				Enumeration<AbstractButton> abstractButtons = radioButtons.getElements();
				while (abstractButtons.hasMoreElements()){
					temp=(JRadioButton)abstractButtons.nextElement();
					if (temp.isSelected()){
						break;
					}
				}
				//System.out.println(temp.getText());
				TempDifference td = new TempDifference();
				td.setName(temp.getText());
			}
    	}
    			);
    	
    	fileBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("fileButtonPressed!!!!");
				
			}
    	}
    			);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
