/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatorserver;

/**
 *
 * @author Leonardo
 */
public class CalcolatorServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerCal server=new ServerCal();
        server.attendi();
        server.calcola();
    }
    
}
