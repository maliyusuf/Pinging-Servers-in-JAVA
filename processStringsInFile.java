import java.io.*;
import java.util.*;  // for Scanner
import java.lang.*;

public class processStringsInFile {
   
   public static void main(String[] args)
	throws FileNotFoundException 	{

	int I = 0;
	Scanner inputFile = new Scanner(new File("InputIPs2.txt"));
			
	   while (inputFile.hasNextLine()) {
			
	    String line = inputFile.nextLine();
		 System.out.println(line);
		 String Locations[] = line;			 
	   }  

      String Locations = new String();
			//String[] allAddresses = 
			
	}
}
		