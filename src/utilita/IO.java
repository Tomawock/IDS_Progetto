package utilita;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import versione_1.model.Database_file;

public class IO 
{	
	public final static String SEPARATORE_STRINGHE="--";
	/**
	 * Funzione che permette la lettura da tastiera
	 * 
	 * @param b se falso chiude l'input altrimenti legge i dati
	 * @return str String di output letta da tstiera
	 */
	public static String inKeyBoard(boolean b)
	{
		 InputStreamReader reader = new InputStreamReader (System.in);
         BufferedReader myInput = new BufferedReader (reader);
         String str= new String();
         try
         {
        	 if(b==true)
        	 {
        		 str = myInput.readLine(); 
        	 }
        	 else
        	 {
        		 myInput.close();
        	 }
         }catch(Exception e)
         {
        	 System.out.println("ERRORE "+e);
         }
         return str;
	}

	/**
	 * Funzione che stampa a video i dati
	 */
	public static void out(Object s)
	{
		System.out.println(s);
	}
	
	/**
	 * Crea il file , se è gia presente non fa nulla
	 * 
	 * @param percorso di destinazione del file
	 * @return il file creato
	 */
	public static File apreCreaFile(String percorso)
	{
		File file = new File(percorso);	
	    try 
	    {
	    	if (!file.exists())
			{
	    		file.createNewFile();
	    		IO.out("File creato in "+percorso);
			}
			else 
				IO.out("non è possibile crare il file in "+percorso);
		} catch (IOException e)
	    {
			IO.out(e);
		}
	    
	    return file;
	}
	/**
	 * Crea il file , se è gia presente non fa nulla
	 * 
	 * @param percorso di destinazione del file
	 * 
	 */
	public static void CreaFile(String percorso)
	{
		File file = new File(percorso);	
	    try 
	    {
	    	if (!file.exists())
			{
	    		file.createNewFile();
	    		IO.out("File creato in "+percorso);
			}
		} catch (IOException e)
	    {
			IO.out(e);
		}
	}
	
	/**
	 * Permette la scrittura di una sringa su un file txt
	 * 
	 * @param file file destinazione su cui scrivere 
	 * @param testo strina che si vuole scrivere
	 */
	public static void scriviFileTxt(File file,String testo)
	{
		try 
		{
			FileWriter fw = new FileWriter(file.getCanonicalFile(),true);
			fw.write(testo);
			fw.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}

	/**
	 * Legge i dati presenti in un file txt e li restituisce in output come una stringa
	 * @param file da cui legge i dati
	 * @return stringa di dati presenti nel file
	 */
	public static String leggiFileTxt(File file)
	{
		String str="";
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) 
			{
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			str=stringBuffer.toString();

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return str;
	}
	
	/**
	 * Elimina tutti i dati presenti su unu file txt
	 * 
	 * @param file da svuotare
	 */
	public static void svuotaFileTxt(File file)
	{
		try 
		{
			FileWriter fw = new FileWriter(file.getCanonicalFile(),false);
			fw.write("");
			fw.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	public static String insertString(){
		String input=inKeyBoard(true);
		if(input==null) insertString();
		return input;
	}
	
	public static int insertInt() {
		boolean numerico = true;
		String s="0";
		while(numerico) {
			s=inKeyBoard(true);
			char[] sequenza = s.toCharArray();
			for (int i=0; i< sequenza.length; i++) {
			try {
				Integer.parseInt(Character.toString(sequenza[i]));
			} 
			catch (Exception e) {
				System.out.println("Non hai inserito un corretto valore");
				numerico=true;
				break;
			}
			numerico=false;
			}
		}
		return Integer.parseInt(s);
	}

	public static int insertInt(int a, int b) {
		int numero=insertInt();
		if (numero<a || numero>b) {
			System.out.println("Numero inserito non compreso fra " + a +" e "+b);
			insertInt(a, b);
		}
		return numero;
	}
	
	public static void main(String[] args)
	{	
		//IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		//f=IO.apreCreaFile("src/File/test2.xls");
		/*IO.svuotaFileTxt(f);
		IO.scriviFileTxt(f, "P XXX LOL \n");
		IO.scriviFileTxt(f, "PP \n");
		IO.out(IO.leggiFileTxt(f));
		System.out.println("cf");
		String st=IO.inCodiceFiscale();
		System.out.println("fine");*/
	}

}
