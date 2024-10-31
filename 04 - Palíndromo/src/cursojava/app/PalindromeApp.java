package cursojava.app;

import java.util.Scanner;

/* Escribe una función que reciba un texto y retorne verdadero o falso (Boolean) según
 * sean o no palíndromos. Un Palíndromo es una palabra o expresión que es igual si se
 * lee de izquierda a derecha que de derecha a izquierda. NO se tienen en cuenta los espacios,
 * signos de puntuación y tildes. Ejemplo: Ana lleva al oso la avellana.
 */
public class PalindromeApp
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		System.out.println("Palíndomo: " + isPalindrome(str));
		
		scanner.close();
	}
	
	public static boolean isPalindrome(String str)
	{
		String aux = "", strl = str.toLowerCase();
		
		// Paso a minúsculas y elimino espacios y signos de puntuación que no cuentan
		for(int i = 0; i < str.length(); ++i)
		{
			char curCar = strl.charAt(i);
			if(isAlpha(curCar))
			{
				aux += curCar;
			}
		}
		int len = aux.length();
		for(int i = 0; i < len/2; ++i)
		{
			if(aux.charAt(i) != aux.charAt(len - 1 - i))
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean isAlpha(char car)
	{
		if(car >= 'a' && car <= 'z')
		{
			return true;
		}
		if(car >= 'A' && car <= 'Z')
		{
			return true;
		}
		// Caracteres especiales
		switch(car)
		{
			case 'á':
			case 'é':
			case 'í':
			case 'ó':
			case 'ú':
			case 'ü':
			case 'Á':
			case 'É':
			case 'Í':
			case 'Ó':
			case 'Ú':
			case 'Ü':
				return true;
		}
		return false;
	}
}
