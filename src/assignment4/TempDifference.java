package assignment4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

public class TempDifference 
{
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	private static String name;
	private static String file;
	
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
			Date day = w.getDate();
			//System.out.println(day);
		

			switch (getName())
						{
			case "MaxF":
				dat.add(w.getMaxF());
				break;
			case "MeanF":
				dat.add(w.getMeanF());
				break;
			case "MinF":
				dat.add(w.getMinF());
				break;
			case "MaxDewF":
				dat.add(w.getMaxDewPointF());
				break;
			case "MeanDewF":
				dat.add(w.getMeanDewPointF());
				break;
			case "MinDewF":
				dat.add(w.getMinDewPointF());
				break;
			case "MaxHum":
				dat.add(w.getMaxHumidity());
				break;
			case "MeanHum":
				dat.add(w.getMeanHumidity());
				break;
			case "MinHum":
				dat.add(w.getMinHumidity());
				break;
			case "MaxPress":
				dat.add(w.getMaxPressureIn());
				break;
			case "MeanPress":
				dat.add(w.getMeanPressureIn());
				break;
			case "MinPress":
				dat.add(w.getMinPressureIn());
				break;
			case "MaxVis":
				dat.add(w.getMaxVisibilityMile());
				break;
			case "MeanVis":
				dat.add(w.getMeanVisibilityMile());
				break;
			case "MinVis":
				dat.add(w.getMinVisibilityMile());
				break;
			case "MaxWind":
				dat.add(w.getMaxWindMPH());
				break;
			case "MeanWind":
				dat.add(w.getMeanWindMPH());
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
		graphDraw.main(null);
	}
	
}
