package assignment4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Date;

public class TempDifference 
{
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	private static String name, file;

	public static String getFile(){
		return file;
	}
	public void setFile(String file){
		TempDifference.file = file;
	}
	
	public static String getName() {
		return name;
	}
	public void setName(String name) {
		TempDifference.name = name;
	}
	
	
	
	public static void main(String[] args) 
	{
		ArrayList<Double> dat=new ArrayList<Double>();

		ArrayList<WundergroundData> wd = WundergroundData.fromFile(getFile());			
					
		for (WundergroundData w : wd) {
			//Date day = w.getDate();
			//System.out.println(day);
		

			switch (getName())
						{
			case "MaxF":
				dat.add(w.getMaxF());
				graphDraw.setYtitle("Degrees F");
				break;
			case "MeanF":
				dat.add(w.getMeanF());
				graphDraw.setYtitle("Degrees F");
				break;
			case "MinF":
				dat.add(w.getMinF());
				graphDraw.setYtitle("Degrees F");
				break;
			case "MaxDewF":
				dat.add(w.getMaxDewPointF());
				graphDraw.setYtitle("Degrees F");
				break;
			case "MeanDewF":
				dat.add(w.getMeanDewPointF());
				graphDraw.setYtitle("Degrees F");
				break;
			case "MinDewF":
				dat.add(w.getMinDewPointF());
				graphDraw.setYtitle("Degrees F");
				break;
			case "MaxHum":
				dat.add(w.getMaxHumidity());
				graphDraw.setYtitle("Humidity");
				break;
			case "MeanHum":
				dat.add(w.getMeanHumidity());
				graphDraw.setYtitle("Humidity");
				break;
			case "MinHum":
				dat.add(w.getMinHumidity());
				graphDraw.setYtitle("Humidity");
				break;
			case "MaxPress":
				dat.add(w.getMaxPressureIn());
				graphDraw.setYtitle("Pressure IN");
				break;
			case "MeanPress":
				dat.add(w.getMeanPressureIn());
				graphDraw.setYtitle("Pressure IN");
				break;
			case "MinPress":
				dat.add(w.getMinPressureIn());
				graphDraw.setYtitle("Pressure IN");
				break;
			case "MaxVis":
				dat.add(w.getMaxVisibilityMile());
				graphDraw.setYtitle("Visibility Mile");
				break;
			case "MeanVis":
				dat.add(w.getMeanVisibilityMile());
				graphDraw.setYtitle("Visibility Mile");
				break;
			case "MinVis":
				dat.add(w.getMinVisibilityMile());
				graphDraw.setYtitle("Visibility Mile");
				break;
			case "MaxWind":
				dat.add(w.getMaxWindMPH());
				graphDraw.setYtitle("Wind MPH");
				break;
			case "MeanWind":
				dat.add(w.getMeanWindMPH());
				graphDraw.setYtitle("Wind MPH");
				break;
			/*case 18:
				dat.add(w.getMaxGustMPH());
				subVal="MaxGustMPH";
				break;
			case 19:
				dat.add(w.getPrecipIn());
				subVal="PrecipIn";
				break;
			case 20:
				dat.add(w.getCloudCover());
				subVal="CloudCover";
				break;
			case 21:
				dat.add(w.getWindDirDeg());
				subVal="WindDirDeg";
				break;
				*/
						}
			}
		graphDraw graph = new graphDraw(dat);
		graph.setScores(dat);
		graphDraw.setTitle(getName()+" for "+ getFile().substring(getFile().lastIndexOf('/')+1));
		graphDraw.setXtitle("Days in File");
		graphDraw.main(args);
	}
	
}
