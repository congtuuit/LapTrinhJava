/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_voice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author PC
 */
public class send implements Runnable{
    int port=7777;
    String message;
    String serverHost=null;//="192.168.137.1";
    String ip;
    @Override
  
    public void run(){
        try {
            
            
            Socket socketOfClient = null;
            BufferedWriter os = null;
            BufferedReader is = null;
            try {
                socketOfClient = new Socket(serverHost, port);
                os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));              
                // Luồng đầu vào tại Client (Nhận dữ liệu từ server).
                //is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
                // Tạo luồng đầu ra tại client (Gửi dữ liệu tới server)
                os.write(message);
                os.newLine();
                os.flush();
            } catch (IOException ex) {
                Logger.getLogger(send.class.getName()).log(Level.SEVERE, null, ex);
            }
           
//            os.write(ip);
//            os.newLine();
//            os.flush();
//            String responseLine;
//           while ((responseLine = is.readLine()) != null) {
//               System.out.println("Server tra ve " + responseLine);
//               if (responseLine.indexOf("QUIT") != -1) {
//                   break;
//               }
//           }
            os.close();
//            is.close();
           socketOfClient.close();
                    
                    
                    } catch (IOException ex) {
            System.out.println(" Khong thể gửi OK ");
        }
           
           
     }
}
