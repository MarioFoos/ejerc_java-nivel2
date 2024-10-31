package com.cursojava;

/* Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 */
public class BinToDecApp
{
	public static void main(String[] args)
	{
		String bin = "100111011";
		
		System.out.println(convertToDec(bin));
	}
	
	public static int convertToDec(String str)
	{
		int len = str.length();
		int value = 0;
		
		// bin  1 0 1 0 1
		// pot: 4 3 2 1 0
		for(int i = 0; i < len; ++i)
		{
			char car = str.charAt(i);
			if(car != '0' && car != '1')
			{
				return -1;
			}
			int digit = (int)(car - '0');
			
			value += (Math.pow(2, len - 1 - i)*digit);
		}
		return value;
	}

}
