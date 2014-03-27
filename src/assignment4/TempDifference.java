package assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TempDifference 
{
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	static String d1[] = new String[3];
	static String d2[] = new String[3];
	static int menu = 0,submenu=0;
	static String subVal;
	
	public static void main(String[] args) 
	{
		ArrayList<Double> dat=new ArrayList<Double>();
		dateIN();
		menu();
		
		for (int i=Integer.parseInt(d1[0]); i<=Integer.parseInt(d2[0]); i++) 
		{
			ArrayList<WundergroundData> wd = WundergroundData.fromFile("/home/garrett/workspace_CSET1200/WeatherData/test/janweather-" + i +".csv");			
			int lowsBelowZero=0;
			
			for (WundergroundData w : wd) 
			{
				Date day = w.getDate();
				try 
				{
					//date1 is start date; date2 is end date
					Date date1 = new SimpleDateFormat("yyyyMMDD").parse(d1[0]+d1[1]+d1[2]);
					Date date2 = new SimpleDateFormat("yyyyMMDD").parse(d2[0]+d2[1]+d2[2]);
					
					//if day is between date1 & date2
					if (day.compareTo(date1)>=0 && day.compareTo(date2)<=0)
					{
						switch (submenu)
						{
						case 1:
							dat.add(w.getMaxF());
							subVal="MaxF";
							break;
						case 2:
							dat.add(w.getMeanF());
							subVal="MeanF";
							break;
						case 3:
							dat.add(w.getMinF());
							subVal="MinF";
							break;
						case 4:
							dat.add(w.getMaxDewPointF());
							subVal="MaxDewPointF";
							break;
						case 5:
							dat.add(w.getMeanDewPointF());
							subVal="MeanDewPointF";
							break;
						case 6:
							dat.add(w.getMinDewPointF());
							subVal="MinDewPointF";
							break;
						case 7:
							dat.add(w.getMaxHumidity());
							subVal="MaxHumidity";
							break;
						case 8:
							dat.add(w.getMeanHumidity());
							subVal="MeanHumidity";
							break;
						case 9:
							dat.add(w.getMinHumidity());
							subVal="MinHumidity";
							break;
						case 10:
							dat.add(w.getMaxPressureIn());
							subVal="MaxPressureIn";
							break;
						case 11:
							dat.add(w.getMeanPressureIn());
							subVal="MeanPressureIn";
							break;
						case 12:
							dat.add(w.getMinPressureIn());
							subVal="MinPressureIn";
							break;
						case 13:
							dat.add(w.getMaxVisibilityMile());
							subVal="MaxVisibilityMile";
							break;
						case 14:
							dat.add(w.getMeanVisibilityMile());
							subVal="MeanVisibilityMile";
							break;
						case 15:
							dat.add(w.getMinVisibilityMile());
							subVal="MinVisibilityMile";
							break;
						case 16:
							dat.add(w.getMaxWindMPH());
							subVal="MaxWindMPH";
							break;
						case 17:
							dat.add(w.getMeanWindMPH());
							subVal="MeanWindMPH";
							break;
						case 18:
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
						}
					}
				} 
				catch (ParseException e) 
				{
					e.printStackTrace();
				}
				
				if (w.getMinF() < 0) 
				{
					lowsBelowZero++;
				}
			}
			System.out.println("The year " + i + " had " + lowsBelowZero + " lows below zero in Jan");
	
		}	
		if (menu==1)
		{
			System.out.println("The STD for " + subVal + " between "+d1[0]+"-"+d1[1]+"-"+d1[2]+" and "+d2[0]+"-"+d2[1]+"-"+d2[2]+" is "+STD(dat));
		}
		else if(menu==2)
		{
			System.out.println("The Mean for " + subVal + " between "+d1[0]+"-"+d1[1]+"-"+d1[2]+" and "+d2[0]+"-"+d2[1]+"-"+d2[2]+" is "+MEAN(dat));
		}
	}
	
	public static void dateIN()
	{
		try 
		{
			System.out.println("Please enter the Beginning Date in YYYY-MM-DD Format: \nExample: 1999-01-05");
			String line = buffer.readLine();
			try
			{
				String[] y1 = line.split("-");
				for (int i=0;i<=2;i++)
				{
					d1[i]=y1[i];
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("ERROR!/nTry AGAIN!!/n");
				dateIN();
			}
			System.out.println("Please enter the Ending Date in YYYY-MM-DD Format: \nExample: 2010-01-11");
			String line2 = buffer.readLine();
			try
			{
				String[] y2 = line2.split("-");
				for (int i=0;i<=2;i++)
				{
					d2[i]=y2[i];
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("ERROR!/nTry AGAIN!!/n");
				dateIN();
			}
		} 
		catch (NumberFormatException | IOException e1) 
		{
			e1.printStackTrace();
			dateIN();
		}
	}
	
	public static void menu()
	{
		System.out.println("Choose what you want to calculate for: \n1) STD\n2) Mean");
		try 
		{
			menu = Integer.parseInt(buffer.readLine());
		} 
		catch (NumberFormatException | IOException e) 
		{
			e.printStackTrace();
			menu();
		}
		if (menu==1)
		{
			submenu("STD");
		}
		if (menu==2)
		{
			submenu("Mean");
		}
	}
	
	public static void submenu(String calc)
	{
		String t=calc;
		System.out.println("What do you want to calculate "+calc+" for: ");
		System.out.println("1) MaxF");
		System.out.println("2) MeanF");
		System.out.println("3) MinF");
		System.out.println("4) MaxDewPointF");
		System.out.println("5) MeanDewPointF");
		System.out.println("6) MinDewPointF");
		System.out.println("7) MaxHumidity");
		System.out.println("8) MeanHumidity");
		System.out.println("9) MinHumidity");
		System.out.println("10) MaxPressure");
		System.out.println("11) MeanPressure");
		System.out.println("12) MinPressure");
		System.out.println("13) MaxVisibilityMile");
		System.out.println("14) MeanVisibilityMile");
		System.out.println("15) MinVisibilityMile");
		System.out.println("16) MaxWindMPH");
		System.out.println("17) MeanWindMPH");
		System.out.println("18) MaxGustMPH");
		System.out.println("19) PrecipIn");
		System.out.println("20) CloudCover");
		System.out.println("21) WindDirDeg");
		try 
		{
			submenu = Integer.parseInt(buffer.readLine());
		} 
		catch (NumberFormatException | IOException e) 
		{
			e.printStackTrace();
			submenu(t);
		}
	}
	
	public static double MEAN(ArrayList <Double> in)
	{
		//Calculates the mean of a set of values
		double Mean=0;
		for(int i=0;i<=(in.size()-1);i++)
		{
			Mean=Mean+in.get(i);
		}
		Mean=Mean/in.size();
		return Mean;
	}
	
	public static double STD(ArrayList <Double> in)
	{
		//calculates the standard deviation of a set of numbers
		//Utilizes the MEAN method above
		double Std=0;
		double mean=MEAN(in);
		for(int i=0;i<=(in.size()-1);i++)
		{
			in.set(i, Math.pow((in.get(i)-mean),2));
			Std=Std+in.get(i);
		}
		Std=Math.sqrt(Std/in.size());
		return Std;
	}
}
