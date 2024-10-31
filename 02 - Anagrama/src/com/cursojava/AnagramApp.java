package com.cursojava;

import java.util.Scanner;

/* Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Bool)
 * según sean o no anagramas. Un Anagrama consiste en formar una palabra reordenando TODAS
 * las letras de otra palabra inicial. NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.
 */
public class AnagramApp
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in); 
		String str1, str2;
		
		System.out.println("Ingrese la dos cadenas:");
		str1 = scanner.nextLine();
		str2 = scanner.nextLine();
		
		System.out.println("Anagrama: " + isAnagram(str1, str2));
		
		scanner.close();
	}
	
	public static boolean isAnagram(String str1, String str2)
	{
		if(str1.length() != str2.length())
		{
			return false;
		}
		// Voy buscando cada letra de str1 en str2 y si está la tacho (pongo cero)
		// Si al final tengo todos ceros en str2, es un anagrama
		int len = str1.length();
		byte[] bytes1 = str1.toLowerCase().getBytes();
		byte[] bytes2 = str2.toLowerCase().getBytes();
		for(int i = 0; i < len; ++i)
		{
			byte curCar = bytes1[i];
			boolean found = false;
			for(int j = 0; j < len; ++j)
			{
				if(bytes2[j] == curCar)
				{
					found = true;
					bytes2[j] = 0;
					break;
				}
			}
			if(!found)
			{
				return false;
			}
		}
		for(int i = 0; i < len; ++i)
		{
			if(bytes2[i] != 0)
			{
				return false;
			}
		}
		return true;
	}

}
