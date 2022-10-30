   import java.io.*;
   import java.net.InetAddress;
   import java.util.*;  // for Scanner
   import java.awt.*; 
	import java.lang.*;

// Written by M. Ali Yousuf
// November 19, 2012

public class IPTest {
   
  public static void main(String[] args)
  throws FileNotFoundException 	{

		Scanner inputAd   = new Scanner(new File("IPAddresses.txt"));
		Scanner inputName = new Scanner(new File("IPNames.txt"));
				
		DrawingPanel panel = new DrawingPanel(400, 1000);
	   panel.setBackground(Color.WHITE);
		Graphics g = panel.getGraphics();
		g.drawString("Lo and behold, we are going to ping all the monitors",10,23); // drawString(text, x, y) writes text with bottom-left corner at (x, y)
		int I = 1;
		int base = 30;

	   while (inputAd.hasNextLine()) {
	    String addressLine = inputAd.nextLine();
		 String nameLine = inputName.nextLine();
 		      
       try {
									
// Test 1, using Java
			long startTime1 = System.currentTimeMillis();
	      InetAddress adr = InetAddress.getByName(addressLine);
		 	boolean t1 = adr.isReachable(5000);
			long endTime1 = System.currentTimeMillis();
			long diff1 = endTime1 - startTime1;
         System.out.println(I +". "+ nameLine+ " (" + addressLine + ") is: " +t1 +". Time taken: " +diff1 + " ms");
// end of Test 1				 
// Plot for test 1
	     if (t1){
			  g.setColor(Color.BLACK);
			  g.fillRect(350, base, 29, 29);	// filled rectangle,  fillRect(x, y, width, height)
			  g.setColor(Color.GREEN);
			  g.fillRect(352, base+2, 25, 25);	// filled rectangle,  fillRect(x, y, width, height)
			  g.drawString(I + ". The monitor " +nameLine+ " (" + addressLine + ") is Pingable",10,base+13); // drawString(text, x, y) writes text with bottom-left corner at (x, y)
		  }
		  else {
		  	  g.setColor(Color.BLACK);
			  g.fillRect(350, base, 29, 29);	// filled rectangle,  fillRect(x, y, width, height)
			  g.setColor(Color.RED);
			  g.fillRect(352, base+2, 25, 25);	// filled rectangle, fillRect(x, y, width, height)  
			  g.drawString(I + ". The monitor " +nameLine+ " (" + addressLine + ") is not responding",10,base+13); // drawString(text, x, y) writes text with bottom-left corner at (x, y)
		  }		
		  base = base + 40;	
					  
// end of Plot for test 1					  
// Test 2, using Ping	
		   if(!t1){				  
			boolean t2 = true;
			long startTime2 = System.currentTimeMillis();
			String testString ="Destination host unreachable";
											 
			Process ping = Runtime.getRuntime().exec("ping " + addressLine); 
			BufferedReader br = new BufferedReader(new InputStreamReader(ping.getInputStream())); 
			String pingLine; 
	
			while ((pingLine = br.readLine()) != null) {
						if (pingLine.contains(testString)) {
				    	t2 = false; }	
						//t2 = true;
			}
								
			long endTime2 = System.currentTimeMillis();
			long diff2 = endTime2 - startTime2;						
								
         System.out.println(I +". "+nameLine+ " (" + addressLine + ") is: " +t2 +". Time taken: " +diff2 + " ms");

	     if (t2){
		  	  g.setColor(Color.BLACK);
			  g.fillRect(350, base, 29, 29);	// filled rectangle,  fillRect(x, y, width, height)
			  g.setColor(Color.GREEN);
			  g.fillRect(352, base-40+2, 25, 25);	// filled rectangle,  fillRect(x, y, width, height)
			  g.setColor(Color.WHITE);
			  g.drawString(I + ". The monitor " +nameLine+ " (" + addressLine + ") is not responding",10,base-40+13); // drawString(text, x, y) writes text with bottom-left corner at (x, y)
			  g.setColor(Color.GREEN);						  
			  g.drawString(I + ". The monitor " +nameLine+ " (" + addressLine + ") is Pingable",  10,base-40+13); // drawString(text, x, y) writes text with bottom-left corner at (x, y)
		  }
		  else {
		  	  g.setColor(Color.BLACK);
			  g.fillRect(350, base, 29, 29);	// filled rectangle,  fillRect(x, y, width, height)
			  g.setColor(Color.RED);
			  g.fillRect(352, base-40+2, 25, 25);	// filled rectangle, fillRect(x, y, width, height)  
			  g.drawString(I + ". The monitor " +nameLine+ " (" + addressLine + ") is not responding",10,base-40+13); // drawString(text, x, y) writes text with bottom-left corner at (x, y)
		  }	
				  	
 		}  // end of if(~t1)   
				
         }catch (IOException e) {
               e.printStackTrace();
            }  
	      
			I = I+1;

  }  //end of while

		System.out.println("\n ...Program ended");
		g.setColor(Color.BLACK);
      g.drawString("That's all for today",10,base+13); // drawString(text, x, y) writes text with bottom-left corner at (x, y)    

   }//main
   
}//IPTest2			 
