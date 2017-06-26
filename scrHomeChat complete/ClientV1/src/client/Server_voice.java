/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author Minions
 */
public class Server_voice {
    public static boolean calling = false;
    public static void main(String[] args) {
        sv_frlisten fr = new sv_frlisten();
        fr.setVisible(true);
        fr.init_audio();
    }
}
