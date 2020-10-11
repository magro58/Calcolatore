/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatorclient;

/**
 *
 * @author Leonardo
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientCal {
	
    String nome_server="localhost";
    int porta_server=1235;
    Socket socket;
    BufferedReader input_tastiera;
    String risposta;
    DataOutputStream dati_al_server;
    BufferedReader dati_dal_server;
    
    public Socket connetti(){
        System.out.println("Client in esecuzione.");
        try {
            socket=new Socket(nome_server,porta_server);
            input_tastiera=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client connesso con successo al server ' " + nome_server +" ' sulla porta: " + porta_server);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione.");
            System.exit(1);
        }
        return(socket);
    }
    
    public void menu(){
        try{
            System.out.println("|...........Calcolatrice...........|");
            System.out.println("____________________________________");
            System.out.println(" 1- Somma \n 2- Differenza \n 3- Divisione \n 4- Moltiplicazione \n 0- Uscita");
        } catch (Exception e){
            System.out.println("Errore");
        }
    }
    
    public void comunica(){
        try {
            String scelta;
            do{
                menu();
                System.out.println("Inserire l'operazione desiderata");
                scelta = input_tastiera.readLine();
                System.out.println(scelta);
                System.out.println("Invio scelta al server...");
                dati_al_server.writeBytes(scelta + '\n');
                
                System.out.println("Inserire il primo numero");
                double x = input_tastiera.read();
                dati_al_server.writeBytes(x + "\n");
                
                System.out.println("Inserire il secondo numero");
                double y = input_tastiera.read();
                dati_al_server.writeBytes(y + "\n");
                
                System.out.println("Risposta del server: "+risposta);
                System.out.println("Chiusura dell'esecuzione.");
            }while (scelta != "0");
            socket.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione col server.");
            System.exit(1);
        }
    }
}
