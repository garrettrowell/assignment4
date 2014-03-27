package assignment4;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class menuDraw extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final int width = 800;
    private static final int height = 400;
    
	public static void createAndShowGUI(){
        menuDraw mainPanel = new menuDraw();
        mainPanel.setPreferredSize(new Dimension(width, height));
        JFrame frame = new JFrame("MainMenu");
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
