/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_voice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author PC
 */
public class r implements Runnable{
    ServerSocket listener = null;
    String line;
    BufferedReader is;
    BufferedWriter os;
    Socket socketOfServer = null;
    Recieve_JFrame fr;
    public int port_server;// port gui mixer
    public String add_server ;//= "192.168.137.1";
    TargetDataLine audio_in;
    public static String ip_myself;
    public static AudioFormat getaudioformat(){
        float sampleRate = 8000.0F;
        int sampleSizeInbits = 16;
        int channel = 2;
        boolean signed = true;
        boolean bigEndian = false;
        return new AudioFormat(sampleRate, sampleSizeInbits, channel, signed, bigEndian);
    }
    public void init_audio(){
        try {
            AudioFormat format = getaudioformat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            if(!AudioSystem.isLineSupported(info)){
                System.out.println("not suport");
                System.exit(0);
            }
            audio_in = (TargetDataLine) AudioSystem.getLine(info);
            audio_in.open(format);
            audio_in.start();
            recorder_thread r = new recorder_thread();
            InetAddress inet = InetAddress.getByName(add_server);
            r.audio_in = audio_in;
            r.dout = new DatagramSocket();
            r.server_ip = inet;
            r.server_port = port_server;
            Client_voice.calling = true;
            r.start();
        } catch (LineUnavailableException | UnknownHostException | SocketException ex) {
            Logger.getLogger(client_fr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run(){
        try {
        listener= new ServerSocket(7777);
        
        System.out.println("Accept a client!");
 
      
           // Mở luồng vào ra trên Socket tại Server.
                   
           while (true) {
               socketOfServer=listener.accept();
               is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
               os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));  
               // Đọc dữ liệu tới server (Do client gửi tới).
               line = is.readLine();
 
               // Ghi vào luồng đầu ra của Socket tại Server.
               // (Nghĩa là gửi tới Client).
               os.write("Server dan nhan  " + line);
               // Kết thúc dòng
               os.newLine();
               // Đẩy dữ liệu đi
               os.flush();  
                    System.out.println(" IP cua ban la: "+ip_myself);
                    //String s = "OK"+ip_myself;
                   if(line.equals(ip_myself))
                   {
                   System.out.println(" Nhận OK tai ip  "+ip_myself);
                   fr= new Recieve_JFrame();
                   fr.setVisible(true);
                   }               
                   else
                   {
                   System.out.println(" Ip can goi lai la " + line);
                   Client_voice.ip_send_voice=line;
                   }
               
               
           
          
           }
        } catch (IOException ex) {
            System.out.println(" Khong mo ser vẻ lang nghe OK dc ");
        }
                
    }
        
    
}
