import java.io.*;
import java.net.InetAddress;

public class IPTest_Android {
   
  public static void main(String[] args){
				
      try {
// Test 1, using Java
	      InetAddress adr = InetAddress.getByName("www.yahoo.com");
		 	boolean t1 = adr.isReachable(5000);
         System.out.println(t1);	

// Test 2, using Ping
			Process ping = Runtime.getRuntime().exec("ping " + "www.yahoo.com"); 
			BufferedReader br = new BufferedReader(new InputStreamReader(ping.getInputStream())); 
			String pingLine; 
			String testString ="Destination host unreachable";
			boolean t2 = true;

			while ((pingLine = br.readLine()) != null) {
						if (pingLine.contains(testString)) {
				    	t2 = false; }	
			}
		   System.out.println(t2);
			
			
      }catch (IOException e) {
            e.printStackTrace();
		 }
  }
}

