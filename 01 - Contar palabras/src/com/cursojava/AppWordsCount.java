package com.cursojava;

/*
 * Crea un programa que cuente cuantas veces se repite cada palabra
 * y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que
 *   lo resuelvan automáticamente.
 */
public class AppWordsCount
{
	public static void main(String[] args)
	{
		String text = "Lista de palabras: Una lista de Palabras, para contar las palabras de la lista.";
		String aux1, aux2, word;
		int count, pos;
		
		// Prepocesar: Paso a minusculas y elimino todos los signos de puntuación
		text = text.toLowerCase();
		aux1 = "";
		char c;
		for(int i = 0; i < text.length(); ++i)
		{
			c = text.charAt(i);
			switch(c)
			{
				case '.':
				case ',':
				case ';':
				case ':':
				case '\'':
				case '\"':
				case '¡':
				case '!':
				case '¿':
				case '?':
					break;
				default:
					aux1 += text.charAt(i);		
			}
		}
		aux1 += " ";
		aux2 = aux1;	// Copia
		
		// Contar palabras e imprimirlas
		pos = aux1.indexOf(" ");
		count = 0;
		while(pos >= 0)
		{
			word = aux1.substring(0, pos);
			aux1 = aux1.substring(pos + 1);
			
			pos = aux1.indexOf(" ");

			++count;
			System.out.println(count + " -> word: "+ word);
		}
		if(count == 0)
		{
			return;
		}
		// Cargo las palabras a un array
		String[] arrWords = new String[count];
		
		pos = aux2.indexOf(" ");
		count = 0;
		while(pos >= 0)
		{
			word = aux2.substring(0, pos);
			aux2 = aux2.substring(pos + 1);
			
			pos = aux2.indexOf(" ");
			
			arrWords[count] = word;
			++count;
		}
		for(int i = 0; i < count; ++i)
		{
			if(i == 0)
			{
				System.out.print("{" + arrWords[i] + ", ");
			}
			else if(i < count - 1)
			{
				System.out.print(arrWords[i] + ", ");
			}
			else
			{
				System.out.println(arrWords[i] + "}");
			}
		}
		
		String[] arrUnique = new String[count];
		int[] arrCount = new int[count];
		
		// Voy contando y poniendo en blanco las palabras que ya conté
		String searchWord;
		int searchCount;
		int posUniques = 0;
		for(int i = 0; i < count; ++i)
		{
			// Busco la primer palabra no vacia
			searchWord = "";
			for(int j = 0; j < count; ++j)
			{
				if(!arrWords[j].isEmpty())
				{
					searchWord = arrWords[j];
					break;
				}
			}
			if(searchWord.isEmpty())
			{
				break;
			}
			// Cuento las iguales
			searchCount = 0;
			for(int j = 0; j < count; ++j)
			{
				if(arrWords[j].equals(searchWord))
				{
					arrWords[j] = "";
					++searchCount;
				}
			}
			arrUnique[posUniques] = searchWord;
			arrCount[posUniques] = searchCount;
			++posUniques;
		}

		// Mostrar resultado
		System.out.println("Cuenta de palabras:");
		for(int i = 0; i < posUniques; ++i)
		{
			System.out.println(arrUnique[i] + " -> " + arrCount[i]);
		}
	}
}



