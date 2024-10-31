package com.cursojava;

/* Crea un programa que calcule quien gana más partidas al piedra, papel, tijera. El resultado puede ser:
 * "Player 1", "Player 2", "Tie" (empate). La función recibe un listado que contiene pares, representando cada jugada.
 * El par puede contener combinaciones de "R" (piedra), "P" (papel) o "S" (tijera).
 * Ejemplo. Entrada: [("R","S"), ("S","R"), ("P","S")]. Resultado: "Player 2".
 */
public class RockScissorsPaperApp
{
	public static void main(String[] args)
	{
		String input = "[(\"R\",\"S\"), (\"S\",\"R\"), (\"P\",\"S\")]";
		String[] parts = checkFormat(input);
		
		if(parts == null)
		{
			System.out.println("Formato no válido: " + input);
			return;
		}

		int winP1 = 0, winP2 = 0;
		for(String part : parts)
		{
			char selP1 = part.charAt(2);
			char selP2 = part.charAt(6);
			switch(selP1)
			{
				case 'R':	// Piedra
					switch(selP2)
					{
						case 'P':	// Papel
							++winP2;
							break;
						case 'S':	// Tijera
							++winP1;
							break;
					}
					break;
				case 'P':	// Papel
					switch(selP2)
					{
						case 'R':	// Piedra
							++winP1;
							break;
						case 'S':	// Tijera
							++winP2;
							break;
					}
					break;
				case 'S':	// Tijera
					switch(selP2)
					{
						case 'R':	// Piedra
							++winP2;
							break;
						case 'P':	// Papel
							++winP1;
							break;
					}
					break;
			}
		}
		if(winP1 > winP2)
		{
			System.out.println("Resultado: Player 1");
		}
		else if(winP1 < winP2)
		{
			System.out.println("Resultado: Player 2");
		}
		else
		{
			System.out.println("Resultado: Tie");
		}
	}
	
	public static String[] checkFormat(String str)
	{
		String aux = "";
		int len = str.length();
		
		for(int i = 0; i < len; ++i)
		{
			char car = str.charAt(i);
			if(!isBlank(car))
			{
				if(isValid(car))
				{
					aux += car;
				}
				else
				{
					return null;
				}
			}
		}
		// Acá tenemnos a aux limpia
		aux = aux.toUpperCase();
		len = aux.length();
		if(len < 3)
		{
			return null;
		}
		if(aux.charAt(0) != '[' || aux.charAt(len - 1) != ']')
		{
			return null;
		}
		// Mímimo queda ("X","Y")
		aux = aux.substring(1, len - 1);
		len = aux.length();
		if(len < 9)
		{
			return null;
		}
		// Elimino las comas entre los pares
		aux = aux.replace("),(", ")(");
		// Deben quedar solo los pares que cada uno ocupa 9 caracteres, nos fijamos si es múltiplo
		len = aux.length();
		if(len%9 != 0)
		{
			return null;
		}
		// Separo en partes para ver que todas tengan el formato válido
		int pos = 0;
		String[] parts = new String[len/9];
		for(int i = 0; i < len; i += 9)
		{
			String sub = aux.substring(i, i + 9);
			// Compruebo el formato de cada parte
			if(sub.indexOf("(\"") != 0)
			{
				return null;
			}
			if(sub.indexOf("\",\"") != 3)
			{
				return null;
			}
			if(sub.indexOf("\")") != 7)
			{
				return null;
			}
			switch(sub.charAt(2))
			{
				case 'R':
				case 'S':
				case 'P':
					break;
				default:
					return null;
			}
			parts[pos] = sub;
			++pos;
		}
		// Si llegué hasta acá, el formato es el correcto
		
		
		return parts;
	}
	
	public static boolean isBlank(char car)
	{
		switch(car)
		{
			case ' ':
			case '\t':
			case '\r':
			case '\b':
			case '\n':
				return true;
		}
		return false;
	}
	
	public static boolean isValid(char car)
	{
		switch(car)
		{
			case '[':
			case ']':
			case '(':
			case ')':
			case '"':
			case 'R':
			case 'P':
			case 'S':
			case ',':
				return true;
		}
		return false;
	}
	
}
