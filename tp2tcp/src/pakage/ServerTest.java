package pakage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerTest{
	public static void main(String[] args) throws IOException {
		List<Compte> list_compte = new ArrayList<Compte>();
         int port=5028;
		ServerSocket sc=new ServerSocket(port);
		while (true) {
			Socket connectionSocket=sc.accept();
			Servertraitement th=new Servertraitement(connectionSocket);
			th.start();}
		
		
		
	}

}
