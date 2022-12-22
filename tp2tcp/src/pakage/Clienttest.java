package pakage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Clienttest  {
	public static void main(String[] args) throws IOException {
		 
		String hostname="127.0.0.1";
		int port=5028;
				
		
		
	
			
			try {
				Socket s=new Socket (hostname,port);
				
				while(true) {
				BufferedReader in =new BufferedReader(new InputStreamReader (System.in));
				
				 String msguser=in.readLine();
			//	System.out.println("msgfromserver is "+msgrecieved);
	
				PrintWriter outtoserver=new PrintWriter (new BufferedWriter(new OutputStreamWriter( s.getOutputStream())),true)		;
				
				outtoserver.println(msguser);
				
				BufferedReader infromserver =new BufferedReader(new InputStreamReader (s.getInputStream()));	
				
				String msgfromserver=infromserver.readLine();
				
				System.out.println(msgfromserver);
				//if (msg.startsWith("creat")
					
				}	
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				
				
				
			
			
		}
			  
			  
		  	  
			  
		    }
		  
		  
	  
	


