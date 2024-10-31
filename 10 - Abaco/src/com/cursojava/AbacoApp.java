package com.cursojava;

/* Crea una función que sea capaz de leer el número representado por el ábaco.
 * El ábaco se representa por un array con 7 elementos. Cada elemento tendrá 9 "O"
 * (aunque habitualmente tiene 10 para realizar operaciones) para las cuentas y una secuencia
 * de "---" para el alambre. El primer elemento del array representa los millones, y el último las unidades.
 * El número en cada elemento se representa por las cuentas que están a la izquierda del alambre.
 * 
 * Ejemplo de array y resultado:
 * ["O---OOOOOOOO",
 *  "OOO---OOOOOO",
 *  "---OOOOOOOOO",
 *  "OO---OOOOOOO",
 *  "OOOOOOO---OO",
 *  "OOOOOOOOO---",
 *  "---OOOOOOOOO"]
 *       
 * Resultado: 1.302.790
 * */
public class AbacoApp
{
	public static void main(String[] args)
	{
		String[] str = { "O---OOOOOOOO", "OOO---OOOOOO", "---OOOOOOOOO", "OO---OOOOOOO", "OOOOOOO---OO", "OOOOOOOOO---", "---OOOOOOOOO" };
		int pot10, value = 0;
		
		for(int i = 0; i < 7; ++i)
		{
			pot10 = (int) Math.pow(10, 6 - i);
			
			value += pot10*getValue(str[i]);
		}
		System.out.println("value: " + value);
	}
	
	
	public static int getValue(String line)
	{
		return line.indexOf("---");
	}

}
