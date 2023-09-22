package Calculation;



import Utilities.User;

import javax.swing.JFrame;
import javax.swing.JOptionPane;




public class PrepoctyBmiKal 
{
	static String message=" ";
	private static double bmi;
	private static JFrame frame = new JFrame();

	
	public static String bmi(User user)
	{
		
		try
		{	
		
		int height = user.getHeight();
		int weight = user.getWeight();

		
		 
		bmi = weight / ( ( height / 100.0 ) * ( height / 100.0 ));

		
		if (bmi > 30.00)
		{
			message ="Mas Obezitu";
			
		}
		else if (bmi <29.99 && bmi >= 25)
		{
			message ="Mas Nadvahu";
			
		}
		else if (bmi < 24.999 && bmi >= 18.5)
		{			
			message ="Zdravy";
			
		}
		else if (bmi < 18.5)
		{
			
			message = "Si podviziveny/a";
		}
		else
		{
			message = "Nezadane";
		}
		
		
		}
		catch (NumberFormatException e)
		{
			
			JOptionPane.showMessageDialog(frame,"Nespravne zadane udaje");
		}
		String result = String.format("%.2f",bmi);
		return result;
	

	
	
	

	
	}	

	public static String getMessage() {
		return message;
	}




}
