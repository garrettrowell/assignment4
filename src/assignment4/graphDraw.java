package assignment4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class graphDraw extends JPanel{
	private static final long serialVersionUID = 1L;
	private static int width = 800;
    private static int height = 400;
    private static ArrayList<Double> scores;
    private int padding = 25;
    private int labelPadding = 25;
    private Color lineColor = new Color(44, 102, 230, 180);
    private Color pointColor = new Color(100, 100, 100, 180);
    private Color gridColor = new Color(200, 200, 200, 200);
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    private int pointWidth = 4;
    private int numberYDivisions = 25;

	 @Override protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2 = (Graphics2D) g;
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	        double xScale = ((double) getWidth() - (2 * padding) - labelPadding-(12+padding)) / (scores.size() - 1);
	        double yScale = ((double) getHeight() - 2 * padding - labelPadding) / (getMaxScore() - getMinScore());
	        FontMetrics metrics = g2.getFontMetrics();
	        AffineTransform aff = AffineTransform.getRotateInstance(Math.toRadians(-90));

	        String title="Graph Title";
	        String xtitle="X Title";
	        String ytitle="Y Title";
	        
	        //makes the title
	        int titleWidth = metrics.stringWidth(title);
	        g2.drawString(title, getWidth()/2-titleWidth/2, 15);
	        //x axis title
	        int xtitleWidth = metrics.stringWidth(xtitle);
	        g2.drawString(xtitle, getWidth()/2-xtitleWidth/2, getHeight()-5);
	        //y axis title
	        int ytitleWidth = metrics.stringWidth(ytitle);
	        g2.setFont((g.getFont()).deriveFont(aff));
	        g2.drawString(ytitle, padding, (getHeight()/2)+(ytitleWidth/2));

	        ArrayList<Point> graphPoints = new ArrayList<>();
	        for (int i = 0; i < scores.size(); i++) {
	            int x1 = (int) (i * xScale + padding + labelPadding);
	            int y1 = (int) ((getMaxScore() - scores.get(i)) * yScale + padding);
	            graphPoints.add(new Point(x1, y1));
	        }
	        
	        // draw white background
	        g2.setColor(Color.WHITE);
	        g2.fillRect(padding + labelPadding+(12+padding), padding, getWidth() - (2 * padding) - labelPadding-(12+padding), getHeight() - 2 * padding - labelPadding);
	        g2.setColor(Color.BLACK);
	        
	        // create hatch marks and grid lines for x axis
	        for (int i = 0; i < scores.size(); i++) {
	            if (scores.size() > 1) {
	                int x0 = i * (getWidth() - padding * 2 - labelPadding-(12+padding)) / (scores.size() - 1) + padding + labelPadding+(12+padding);
	                int x1 = x0;
	                int y0 = getHeight() - padding - labelPadding;
	                int y1 = y0 - pointWidth;
	                g2.setColor(gridColor);
	                g2.drawLine(x0, getHeight() - padding - labelPadding - 1 - pointWidth, x1, padding);
	                g2.setColor(Color.BLACK);
	                String xLabel = i+1 + "";
	                g2.drawString(xLabel, x0 + 12 / 2, y0 + metrics.getHeight() + 10);
	                AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(-90));
	                g2.setFont((g.getFont()).deriveFont(at));
	                g2.drawLine(x0, y0, x1, y1);
	            
	            }
	        }
	        // create hatch marks and grid lines for y axis.
	        for (int i = 0; i < numberYDivisions + 1; i++) {
	            int x0 = padding + labelPadding+(12+padding);
	            int x1 = pointWidth + padding + labelPadding+(12+padding);
	            int y0 = getHeight() - ((i * (getHeight() - padding * 2 - labelPadding)) / numberYDivisions + padding + labelPadding);
	            int y1 = y0;
	            if (scores.size() > 0) {
	                g2.setColor(gridColor);
	                g2.drawLine(padding + labelPadding + 1 + pointWidth+(12+padding), y0, getWidth() - padding, y1);
	                g2.setColor(Color.BLACK);
	                //String yLabel = ((int) ((getMinScore() + (getMaxScore() - getMinScore()) * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
	                System.out.println("i: "+i+" "+Math.round(getMinScore()+(getMaxScore()-getMinScore())*i/numberYDivisions));
	                String yLabel = Math.round(getMinScore()+(getMaxScore()-getMinScore())*i/numberYDivisions)+ "";
	                //String yLabel = ((Double)((getMaxScore()-getMinScore())*i/numberYDivisions)) + "";
	                
	                /*
	                System.out.println("getMinScore: "+getMinScore());
	                System.out.println("getMaxScore: "+getMaxScore());
	                System.out.println("i: "+i);
	                System.out.println("numberYDivisions: "+numberYDivisions);
	                */
	                
	                int labelWidth = metrics.stringWidth(yLabel);
	                AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(360));
	                g2.setFont((g.getFont()).deriveFont(at));
	                g2.drawString(yLabel, x0 - labelWidth - 15, y0 + (metrics.getHeight() / 2) - 3); 
	            }
	            g2.drawLine(x0, y0, x1, y1);
	        }
	        // create x and y axes 
	        g2.drawLine(padding + labelPadding+(12+padding), getHeight() - padding - labelPadding, padding + labelPadding+(12+padding), padding);
	        g2.drawLine(padding + labelPadding+(12+padding), getHeight() - padding - labelPadding, getWidth() - padding, getHeight() - padding - labelPadding);

	        //Draw on screen
	        Stroke oldStroke = g2.getStroke();
	        g2.setColor(lineColor);
	        g2.setStroke(GRAPH_STROKE);
	        for (int i = 0; i < graphPoints.size() - 1; i++) {
	            int x1 = graphPoints.get(i).x+(12+padding);
	            int y1 = graphPoints.get(i).y;
	            int x2 = graphPoints.get(i + 1).x+(12+padding);
	            int y2 = graphPoints.get(i + 1).y;
	            g2.drawLine(x1, y1,x2, y2);
	        }

	        g2.setStroke(oldStroke);
	        g2.setColor(pointColor);
	        for (int i = 0; i < graphPoints.size(); i++) {
	            int x = graphPoints.get(i).x+(12+padding) - pointWidth / 2;
	            int y = graphPoints.get(i).y - pointWidth / 2;
	            int ovalW = pointWidth;
	            int ovalH = pointWidth;
	            g2.fillOval(x, y, ovalW, ovalH);
	        }
	 }

	 public graphDraw(ArrayList<Double> scores) {
	        graphDraw.scores = scores;
	 }
	 private double getMinScore() {
		 double minScore = Double.MAX_VALUE;
		 for (Double score : scores) {
			 minScore = Math.round(Math.min(minScore, score));
		 }
		 if (minScore>=0)
			 minScore=0;
		 else{
			 while (minScore%10!=0){
				 minScore--;
			 }
		 }
		 return minScore;
	 }

	 private double getMaxScore() {
		 double maxScore = Double.MIN_VALUE;
		 for (Double score : scores) {
			 maxScore = Math.round(Math.max(maxScore, score));
		 }
		 while(maxScore%10!=0)
			 maxScore++;
		 return maxScore;
	 }
	 
	 public void setScores(ArrayList<Double> scores) {
		 graphDraw.scores = scores;
		 invalidate();
		 this.repaint();
	 }

	 public static ArrayList<Double> getScores() {
		 return scores;
	 }
	 
	 public static void createAndShowGui() {
	        /*ArrayList<Double> scores = new ArrayList<>();
	        Random random = new Random();
	        int maxDataPoints = 31;
	        int maxScore = 100;
	        for (int i = 0; i < maxDataPoints; i++) {
	        	scores.add((double) random.nextDouble() * maxScore);
	            //displays data points to verify graphs accuracy
	            //System.out.println((i+1)+": "+scores.get(i));
	        }
	        graphDraw mainPanel = new graphDraw(scores);
	        */
		 	graphDraw mainPanel = new graphDraw(getScores());
		 	for (int i = 0;i<=scores.size()-1;i++){
		 		System.out.println((i+1)+": "+scores.get(i));
		 	}
	        mainPanel.setPreferredSize(new Dimension(width, height));
	        JFrame frame = new JFrame("DrawGraph");
	        //JFrame frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(mainPanel);
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	      SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	            createAndShowGui();
	         }
	      });
	      
	    }
	    
	
	    
}
