/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatoreserver;

import calcolatorserver.ServerCal;

/**
 *
 * @author Leonardo
 */
public class CalcolatoreServer {
    
   
    public static void main(String[] args) {
        ServerCal server=new ServerCal();
        server.attendi();
        server.calcola();
    }
    
}
