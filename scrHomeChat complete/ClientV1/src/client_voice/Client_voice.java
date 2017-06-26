/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_voice;

/**
 *
 * @author duong
 */
public class Client_voice {

    public static boolean calling = false;
    public static boolean accept_voice = false;
    public static String ip_send_voice;

    public static void main(String[] args) {
        Thread t2= new Thread(new r());
        t2.start();
        client_fr fr = new client_fr();
        fr.setVisible(true);
    }
    
}
