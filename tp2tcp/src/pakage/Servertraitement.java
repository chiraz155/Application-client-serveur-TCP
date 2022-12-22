package pakage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servertraitement extends Thread {
	private Socket s;
	List<Compte> list_compte = new ArrayList<Compte>();
	List <String> listhisto=new ArrayList<String >();

	public Servertraitement(Socket s) {
		this.s = s;
	}

	public void run() {

		try {

			BufferedReader infromclient = new BufferedReader(new InputStreamReader(s.getInputStream()));

			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())), true);

			String msgclient = infromclient.readLine();
			while (true) {
				if (msgclient.startsWith("creat")) {
					boolean existe = false;
					System.out.println(msgclient);
					String nomc = msgclient.substring(6);
					for (Compte c : list_compte) {
						if ((c.getC().getNom()).equals(nomc)) {

							existe = true;
						}
					}

					if (existe == false) {
						Client e = new Client(nomc);
						Compte c1 = new Compte();
						c1.setC(e);
						c1.setSold(0);
						c1.setEtat(true);
						int numm = c1.getNumC();
						String msg1 = "account created suuccessfully and numero de compte=" + numm;
						out.println(msg1);
						list_compte.add(c1);

						// if(msgclient.startsWith("show")) {
						// for (Compte k : list_compte) {
						// String msg2 ="liste de comptes"+k.getC().getNom();}}
						while (true) {
							String msgclient1 = infromclient.readLine();

							if (msgclient1.startsWith("Ajout")) {

								String msg = " ok";
							//	out.println(msg);
						   String mm=msgclient1.substring(6);
						   System.out.println(mm);
                          Float A= Float.parseFloat(mm);
							 
							 c1.setSold((c1.getSold())+A);
							 String msg2=" sold ajouté de"+A;
							 out.println(msg2);
							 listhisto.add(msg2);
						}
							if (msgclient1.startsWith("Debiter")) {
								 String debite=msgclient1.substring(8);
								  Float Debite=Float.parseFloat(debite);

								  if (c1.getSold()>=Debite) {

								 float Sold=(c1.getSold())-Debite;
								  String msgout="Sold debité de"+debite;
								  listhisto.add(msgout);
								  c1.setSold(Sold);
								  out.println(msgout);}

								  else {
								   String msgout2="Sold insuffisant";
								    out.println(msgout2);}}
							if (msgclient1.startsWith("sold")) {
								float sold=c1.getSold();
								String m="votre sold est"+sold;
								 out.println(m);
							} 
							if (msgclient1.startsWith("Transferer ")) {
								String msg5="A qui?";
								 out.println(msg5);
								
								 String msgclient3 = infromclient.readLine();
								  String nom=msgclient3;
								  String msg6="Sold a ajouter?";
									 out.println(msg6);

									 String msgclient4 = infromclient.readLine();
									 float sold=Float.parseFloat(msgclient4);

								  for(Compte l:list_compte) {
									 if (l.getC().getNom().equals(nom)){ 
										float newsold= l.getSold()+sold;
										 l.setSold(newsold);
										 String msg2="transfert terminé";
										 String msggg="transfert de "+sold+"a "+nom;
										 listhisto.add(msggg);
										 
										 out.println(msg2);}
										 else {
											 String msg9="compte n'existe pas";
											 out.println(msg9);
										 }
										 

									
								}

								 
							}
							if (msgclient1.startsWith("Histo")) {
								
								for(String k:listhisto) {
									String msg22="Operation effectués:"+listhisto;
									out.println(msg22);
								}
							}
							
							
					    

					}}
				}

				else {
					String msg = "account exist";
					out.println(msg);
				}
			}

			// else 
			// }

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}}

	

