
/* Crea un programa capaz de interactuar con un fichero TXT.
 * - Si no existe, debe crear un fichero llamado "text.txt".
 * - Desde el programa debes ser capaz de introducir texto por consola y guardarlo en una nueva línea cada vez que se pulse el botón "Enter".
 * - Si el fichero existe, el programa tiene que dar la opción de seguir escribiendo a continuación o borrar su contenido y comenzar desde el principio.
 * - Si se selecciona continuar escribiendo, se tiene que mostrar por consola el texto que ya posee el fichero.
 * */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TxtApp
{
	private static String filePath = "file.txt";
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		File file = new File(filePath);
		String line;
		int option;
		
		
		System.out.println("Escriba una línea de texto y presione enter:");
		
		line = scanner.nextLine();
		
		if(file.exists())
		{
			System.out.println("El archivo existe y su contenido es:");
			System.out.println();
			logFile();
			System.out.println();
			System.out.println("Escriba una opción:");
			System.out.println("1) Borrar archivo");
			System.out.println("2) Agregar texto");
			
			do
			{
				option = scanner.nextInt();
				if(option == 1)
				{
					if(file.delete())
					{
						System.out.println("Archivo borrado con éxito");
					}
					else
					{
						System.out.println("Error al borrar archivo");
					}
				}
				else if(option == 2)
				{
					try
					{
						FileWriter fw = new FileWriter(file, true);
						fw.write(line);
						fw.write('\n');
						fw.close();
						System.out.println("Texto agregado. Nuevo contenido del archivo");
						System.out.println();
						logFile();
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("Opción no válida");
				}
			} while(option != 1 && option != 2);
		}
		else
		{
			try
			{
				FileWriter fw = new FileWriter(filePath);
				fw.write(line);
				fw.write('\n');
				fw.close();
				
				System.out.println("Archivo creado con el contenido:");
				System.out.println();
				logFile();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		scanner.close();
	}
	
	public static void logFile()
	{
		try
		{
			FileReader fr = new FileReader(filePath);
			int readed;
			while((readed = fr.read()) != -1)
			{
				System.out.print((char) readed);
			}
			fr.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
