package com.cursojava;

/*
 * Crea un programa que sea capaz de transformar texto natural a código
 * morse y viceversa.
 * - Debe detectar automáticamente de qué tipo se trata y realizar
 *   la conversión.
 * - En morse se soporta raya "—", punto ".", un espacio " " entre letras
 *   o símbolos y dos espacios entre palabras "  ".
 * - El alfabeto morse soportado será el mostrado en
 *   https://es.wikipedia.org/wiki/Código_morse.
 */
public class AppWordsCount
{
	private static final char[] car = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	private static final String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "--.--", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----." };

	public static void main(String[] args)
	{
		String text = "Texto que se pasa a Morse";
		String morse = "- . -..- - ---  --.- ..- .  ... .  .--. .- ... .-  .-  -- --- .-. ... . ";
		String output = "";
		String overText = "";
		
		//if(isText(text))
		if(isText(morse))
		{
			String[] parts = text2Morse(text);
			for(int i = 0; i < parts.length; ++i)
			{
				output += parts[i];
				overText += text.charAt(i);
				for(int j = 0; j < parts[i].length() - 1; ++j)
				{
					overText += " ";
				}
			}
			System.out.println(overText);
			System.out.println(output);
		}
		else
		{
			output = morse2Text(morse);
			System.out.println(output);
		}
	}

	static String morse2Text(String text)
	{
		String[] cars = separateInChars(text);
		String out = "";

		for(int i = 0; i < cars.length; ++i)
		{
			if(cars[i].equals(" "))
			{
				out += ' ';
			}
			else
			{
				for(int j = 0; j < car.length; ++j)
				{
					if(cars[i].equals(morse[j]))
					{
						out += car[j];
						break;
					}
				}
			}
		}
		return out;
	}
	
	static String[] separateInChars(String text)
	{
		String aux, word;
		int pos, count;
		
		// Contar palabras e imprimirlas
		aux = text;
		if(aux.charAt(aux.length() - 1) != ' ')
		{
			aux += " ";
		}
		pos = aux.indexOf(" ");
		count = 0;
		while(pos >= 0)
		{
			word = aux.substring(0, pos);
			aux = aux.substring(pos + 1);

			pos = aux.indexOf(" ");
			++count;
		}
		if(count == 0)
		{
			return new String[0];
		}
		String[] cars = new String[count];
		aux = text;
		pos = aux.indexOf(" ");
		count = 0;
		while(pos >= 0)
		{
			word = aux.substring(0, pos);
			aux = aux.substring(pos + 1);

			cars[count] = word.isEmpty() ? " " : word;
			pos = aux.indexOf(" ");
			++count;
		}
		// Mostrar
		showArray(cars);
		return cars;
	}
	
	static void showArray(String[] arr)
	{
		for(int i = 0; i < arr.length; ++i)
		{
			if(i == 0)
			{
				System.out.print("{" + arr[i] + ", ");
			}
			else if(i < arr.length - 1)
			{
				System.out.print(arr[i] + ", ");
			}
			else
			{
				System.out.println(arr[i] + "}");
			}
		}		
	}
	
	static String[] text2Morse(String text)
	{
		String[] parts = new String[text.length()];
		String aux = text.toUpperCase();
		
		for(int i = 0; i < aux.length(); ++i)
		{
			char curCar = aux.charAt(i);
			if(curCar == ' ')
			{
				parts[i] = " ";
			}
			else
			{
				for(int j = 0; j < car.length; ++j)
				{
					if(curCar == car[j])
					{
						parts[i] = (morse[j] + " ");
						break;
					}
				}
			}
		}		
		return parts;
	}
	
	static boolean isText(String text)
	{
		// Si hay algo que no sean ".", "-" o " ", es un texto, sino es morse
		for(int i = 0; i < text.length(); ++i)
		{
			char c = text.charAt(i);
			switch(c)
			{
				case '.':
				case '-':
				case ' ':
					break;
				default:
					return true;
			}
		}
		return false;
	}

	
	
}



