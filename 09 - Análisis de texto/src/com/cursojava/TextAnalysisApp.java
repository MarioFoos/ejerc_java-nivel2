package com.cursojava;

/* Crea un programa que analice texto y obtenga: Número total de palabras, longitud media de las palabras,
 * número de oraciones del texto (cada vez que aparecen un punto), encuentre la palabra más larga.
 */
public class TextAnalysisApp
{
	private static final char[] punctuation = new char[] { '.', ',', ';', ':', '¿', '?', '¡', '!', '\"', '\'', '(', ')', '-' };

	public static void main(String[] args)
	{
		// Texto de prueba
		String str = "Prueba, texto de prueba. ¡Exclamación! ¿pregunta?, tal vez. Y una palabra larga: acontecimientos.";		
		
		String[] arrWords =  getWords(str);
		String largest = "";
		int acumWord = 0;
		for(String word : arrWords)
		{
			System.out.println(word);
			acumWord += word.length();
			if(word.length() > largest.length())
			{
				largest = word;
			}
		}
		String[] arrSentences =  getSentences(str);
		for(String sentence : arrSentences)
		{
			System.out.println(sentence);
		}
		
		System.out.println("Palabras: " + arrWords.length);
		System.out.println("Palabra promedio: " + Math.round(acumWord/(double)arrWords.length));
		System.out.println("Palabra más larga: " + largest + " (" + largest.length() + " letras)");
		System.out.println("Oraciones: " + arrSentences.length);
		
	}
	public static String[] getSentences(String str)
	{
		String[] arr = str.split("\\.\\s");
		
		return arr;
	}

	public static String[] getWords(String str)
	{
		String[] arr = str.split("\\s");
		
		for(int i = 0; i < arr.length; ++i)
		{
			arr[i] = cleanPuntuation(arr[i]);
		}
		return arr;
	}
	
	public static String cleanPuntuation(String str)
	{
		String out = "";
		int len = str.length();
		char c;
		
		for(int i = 0; i < len; ++i)
		{
			c = str.charAt(i);
			
			if(!isPunctuation(c))
			{
				out += c;
			}
		}
		return out;
	}
	
	public static boolean isPunctuation(char c)
	{
		for(int i = 0; i < punctuation.length; ++i)
		{
			if(punctuation[i] == c)
			{
				return true;
			}
		}
		return false;
	}
}
