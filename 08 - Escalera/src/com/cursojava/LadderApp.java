package com.cursojava;

/* Crea una función que dibuje una escalera según su número de escalones.
 * Si el número es positivo, será ascendente de izquiera a derecha.
 * Si el número es negativo, será descendente de izquiera a derecha.
 * Si el número es cero, se dibujarán dos guiones bajos (__).
 * 
 * Ejemplo: 4
 *         _
 *       _|
 *     _|
 *   _|
 * _|
 * 
 * Ejemplo: -4
 * _
 *  |_
 *    |_
 *      |_
 *        |_
 **/

public class LadderApp
{

	public static void main(String[] args)
	{
		drawStep(4);
		
		drawStep(-4);
		
		drawStep(0);
	}
	
	public static void drawStep(int number)
	{
		if(number > 0)
		{
			System.out.println(stepLine(number, true, true));
			for(int i = number - 1; i >= 0; --i)
			{
				System.out.println(stepLine(i, true, false));	
			}
		}
		else if(number < 0)
		{
			number = -1*number;
			System.out.println(stepLine(0, false, true));
			for(int i = 1; i <= number; ++i)
			{
				System.out.println(stepLine(i, false, false));
			}
		}
		else
		{
			System.out.println("__");
		}
	}
	
	public static String stepLine(int floor, boolean asc, boolean top)
	{
		String line = "";
		if(asc)
		{
			if(top)
			{
				line = "_";
			}
			else
			{
				line = "_|";
			}
			for(int i = 0; i < floor; ++i)
			{
				line = "  " + line;
			}
		}
		else
		{
			if(top)
			{
				line = "_";
			}
			else
			{
				line = " |_";
				for(int i = 1; i < floor; ++i)
				{
					line = "  " + line;
				}
			}
		}
		return line;
	}
}
