/* Escribe un programa que sea capaz de generar contraseñas de forma aleatoria.
 * Podrás configurar generar contraseñas con los siguientes parámetros: Longitud: Entre 8 y 16, con o sin
 * letras mayúsculas, con o sin números y con o sin símbolos.
 * */
package com.cursojava;

import java.util.Scanner;

public class PasswordApp
{
	private static final char[] simbols = new char[] { '-', '_', '.', '#', '%', '$', '?', '!', '|', ';', ',' };
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		boolean capital, numbers, simbols;
		
		System.out.println("¿Usar mayúsculas (Y/N)?");
		String opt = scanner.nextLine();
		if(opt.equalsIgnoreCase("Y"))
		{
			capital = true;
		}
		else if(opt.equalsIgnoreCase("N"))
		{
			capital = false;
		}
		else
		{
			System.out.println("Opción no válida, fin del programa");
			scanner.close();
			return;
		}
		System.out.println("¿Usar números (Y/N)?");
		opt = scanner.nextLine();
		if(opt.equalsIgnoreCase("Y"))
		{
			numbers = true;
		}
		else if(opt.equalsIgnoreCase("N"))
		{
			numbers = false;
		}
		else
		{
			System.out.println("Opción no válida, fin del programa");
			scanner.close();
			return;
		}
		System.out.println("¿Usar símbolos (Y/N)?");
		opt = scanner.nextLine();
		if(opt.equalsIgnoreCase("Y"))
		{
			simbols = true;
		}
		else if(opt.equalsIgnoreCase("N"))
		{
			simbols = false;
		}
		else
		{
			System.out.println("Opción no válida, fin del programa");
			scanner.close();
			return;
		}
		System.out.println("Generado: " + genPass(capital, numbers, simbols));
		
		scanner.close();
	}
	
	public static String genPass(boolean hasCapital, boolean hasNumbers, boolean hasSimbols)
	{
		String pass = "";
		int len = randNum(8, 16);
		String types = "L";
		if(hasCapital)
		{
			types += "U";
		}
		if(hasNumbers)
		{
			types += "N";
		}
		if(hasSimbols)
		{
			types += "S";
		}
		for(int i = 0; i < len; ++i)
		{
			int pos = randNum(0, types.length() - 1);
			switch(types.charAt(pos))
			{
				case 'L':
					pass += genCar(false);
					break;
				case 'U':
					pass += genCar(true);
					break;
				case 'N':
					pass += genNum();
					break;
				case 'S':
					pass += genSimbol();
					break;
			}
		}
		return pass;
	}
	
	public static char genSimbol()
	{
		int pos = (int)(Math.random()*simbols.length);
		return simbols[pos];
	}

	public static char genNum()
	{
		return (char)((int)(Math.random()*9) + '0');
	}
	
	public static int randNum(int min, int max)
	{
		return (int)(Math.random()*(max - min + 1)) + min;
	}

	public static char genCar(boolean capital)
	{
		int delta = randNum(0, 'Z' - 'A');
		return capital ? (char)(delta + 'A') : (char)(delta + 'a');
	}
	

}
