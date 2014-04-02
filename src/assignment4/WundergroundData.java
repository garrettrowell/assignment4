package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WundergroundData {

	private Date date;
	private double maxF;
	private double meanF;
	private double minF;
	private double maxDewPointF;
	private double meanDewPointF;
	private double minDewPointF;
	private double maxHumidity;
	private double meanHumidity;
	private double minHumidity;
	private double maxPressureIn;
	private double meanPressureIn;
	private double minPressureIn;
	private double maxVisibilityMile;
	private double meanVisibilityMile;
	private double minVisibilityMile;
	private double maxWindMPH;
	private double meanWindMPH;
	private double maxGustMPH;
	private double precipIn;
	private double cloudCover;
	private String events;
	private double windDirDeg;

	public Date getDate() {
		return date;
	}
	public void setDate(Date date2) {
		this.date = date2;
	}
	public double getMaxF() {
		return maxF;
	}
	public void setMaxF(double maxF) {
		this.maxF = maxF;
	}
	public double getMeanF() {
		return meanF;
	}
	public void setMeanF(double meanF) {
		this.meanF = meanF;
	}
	public double getMinF() {
		return minF;
	}
	public void setMinF(double minF) {
		this.minF = minF;
	}
	public double getMaxDewPointF() {
		return maxDewPointF;
	}
	public void setMaxDewPointF(double maxDewPointF) {
		this.maxDewPointF = maxDewPointF;
	}
	public double getMeanDewPointF() {
		return meanDewPointF;
	}
	public void setMeanDewPointF(double meanDewPointF) {
		this.meanDewPointF = meanDewPointF;
	}
	public double getMinDewPointF() {
		return minDewPointF;
	}
	public void setMinDewPointF(double minDewPointF) {
		this.minDewPointF = minDewPointF;
	}
	public double getMaxHumidity() {
		return maxHumidity;
	}
	public void setMaxHumidity(double maxHumidity) {
		this.maxHumidity = maxHumidity;
	}
	public double getMeanHumidity() {
		return meanHumidity;
	}
	public void setMeanHumidity(double meanHumidity) {
		this.meanHumidity = meanHumidity;
	}
	public double getMinHumidity() {
		return minHumidity;
	}
	public void setMinHumidity(double minHumidity) {
		this.minHumidity = minHumidity;
	}
	public double getMaxPressureIn() {
		return maxPressureIn;
	}
	public void setMaxPressureIn(double maxPressureIn) {
		this.maxPressureIn = maxPressureIn;
	}
	public double getMeanPressureIn() {
		return meanPressureIn;
	}
	public void setMeanPressureIn(double meanPressureIn) {
		this.meanPressureIn = meanPressureIn;
	}
	public double getMinPressureIn() {
		return minPressureIn;
	}
	public void setMinPressureIn(double minPressureIn) {
		this.minPressureIn = minPressureIn;
	}
	public double getMaxVisibilityMile() {
		return maxVisibilityMile;
	}
	public void setMaxVisibilityMile(double maxVisibilityMile) {
		this.maxVisibilityMile = maxVisibilityMile;
	}
	public double getMeanVisibilityMile() {
		return meanVisibilityMile;
	}
	public void setMeanVisibilityMile(double meanVisibilityMile) {
		this.meanVisibilityMile = meanVisibilityMile;
	}
	public double getMinVisibilityMile() {
		return minVisibilityMile;
	}
	public void setMinVisibilityMile(double minVisibilityMile) {
		this.minVisibilityMile = minVisibilityMile;
	}
	public double getMaxWindMPH() {
		return maxWindMPH;
	}
	public void setMaxWindMPH(double maxWindMPH) {
		this.maxWindMPH = maxWindMPH;
	}
	public double getMeanWindMPH() {
		return meanWindMPH;
	}
	public void setMeanWindMPH(double meanWindMPH) {
		this.meanWindMPH = meanWindMPH;
	}
	public double getMaxGustMPH() {
		return maxGustMPH;
	}
	public void setMaxGustMPH(double maxGustMPH) {
		this.maxGustMPH = maxGustMPH;
	}
	public double getPrecipIn() {
		return precipIn;
	}
	public void setPrecipIn(double precipIn) {
		this.precipIn = precipIn;
	}
	public double getCloudCover() {
		return cloudCover;
	}
	public void setCloudCover(double cloudCover) {
		this.cloudCover = cloudCover;
	}
	public String getEvents() {
		return events;
	}
	public void setEvents(String events) {
		this.events = events;
	}
	public double getWindDirDeg() {
		return windDirDeg;
	}
	public void setWindDirDeg(double windDirDeg) {
		this.windDirDeg = windDirDeg;
	}
	
	public static ArrayList<WundergroundData> fromFile(String filename) {
		BufferedReader is = null;
		ArrayList<WundergroundData> ret = new ArrayList<WundergroundData>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
		try {
			is = new BufferedReader(new FileReader(filename));
			String line=null;
			while ((line = is.readLine()) != null) {
				String[] la = line.split(",");
				WundergroundData wd = new WundergroundData();
				try {
					wd.setDate(sdf.parse(la[0]));
					wd.setMaxF(Double.parseDouble(la[1]));
					wd.setMeanF(Double.parseDouble(la[2]));
					wd.setMinF(Double.parseDouble(la[3]));
					//Above Provided below added
					wd.setMaxDewPointF(Double.parseDouble(la[4]));
					wd.setMeanDewPointF(Double.parseDouble(la[5]));
					wd.setMinDewPointF(Double.parseDouble(la[6]));
					wd.setMaxHumidity(Double.parseDouble(la[7]));
					wd.setMeanHumidity(Double.parseDouble(la[8]));
					wd.setMinHumidity(Double.parseDouble(la[9]));
					wd.setMaxPressureIn(Double.parseDouble(la[10]));
					wd.setMeanPressureIn(Double.parseDouble(la[11]));
					wd.setMinPressureIn(Double.parseDouble(la[12]));
					wd.setMaxVisibilityMile(Double.parseDouble(la[13]));
					wd.setMeanVisibilityMile(Double.parseDouble(la[14]));
					wd.setMinVisibilityMile(Double.parseDouble(la[15]));
					wd.setMaxWindMPH(Double.parseDouble(la[16]));
					wd.setMeanWindMPH(Double.parseDouble(la[17]));
					try
					{
						wd.setMaxGustMPH(Double.parseDouble(la[18]));
					}
					catch(NumberFormatException e)
					{
						//System.out.println("MGust "+e);
					}
					try
					{
						wd.setPrecipIn(Double.parseDouble(la[19]));
					}
					catch(NumberFormatException e)
					{
						//System.out.println(la[0]+" Precip "+e+" assuming 0");
					}
					try
					{
						wd.setCloudCover(Double.parseDouble(la[20]));
					}
					catch(NumberFormatException e)
					{
						//System.out.println("CloudCover "+e);
					}
					try
					{
						wd.setEvents(la[21]);
					}
					catch(NumberFormatException e)
					{
						//System.out.println("Events "+e);
					}
					try
					{
						wd.setWindDirDeg(Double.parseDouble(la[22]));
					}
					catch(NumberFormatException e)
					{
						//System.out.println("WindDir "+e);
					}
					
					
					
				} catch (ParseException e) {
					System.out.println("Unable to parse data: " + line);
					continue;
				}
				ret.add(wd);
			}
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		} finally {
			try {
				is.close();
			} catch (IOException e) { 
				return null;
			}
		}
		return ret;
	}
	
	public String toString() {
		return "Date: " + date.toString() + " MaxF: " + maxF;
	}
}
