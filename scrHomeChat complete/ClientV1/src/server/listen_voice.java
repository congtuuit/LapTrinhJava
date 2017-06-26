/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author PC
 */
public class listen_voice extends Thread{
    public int port_voice ;
    public SourceDataLine audio_out;
    public static AudioFormat getaudioformat(){
        float sampleRate = 8000.0F;
        int sampleSizeInbits = 16;
        int channel = 2;
        boolean signed = true;
        boolean bigEndian = false;
        return new AudioFormat(sampleRate, sampleSizeInbits, channel, signed, bigEndian);
    }
    @Override
    public void run(){
        try {
            AudioFormat format = getaudioformat();
            DataLine.Info info_out = new DataLine.Info(SourceDataLine.class, format);
            if(!AudioSystem.isLineSupported(info_out)){
                System.out.println("not suport");
                System.exit(0);
            }
            audio_out = (SourceDataLine)AudioSystem.getLine(info_out);
            audio_out.open(format);
            audio_out.start();
            player_thread p = new player_thread();
            p.din = new DatagramSocket(port_voice);
            p.audio_out = audio_out;
            client_voice.Client_voice.calling=true;
            client_voice.Client_voice.accept_voice=true;
            p.start();
            System.out.println(" da lang nghe ở port "+ this.port_voice);
        } catch (LineUnavailableException | SocketException ex) {
            System.out.println(" Không thể lắng nghe Lỗi ở listen_voice ");
        }
    
}
}
    
