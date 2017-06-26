/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Rainy
 */
public class login extends javax.swing.JFrame {

    String a;
    Client_fr fr= new Client_fr() ;
    public login() {
        initComponents();
        setResizable(false);
        
    }
public void CloseFrame(){
    super.dispose();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        checks = new javax.swing.JCheckBox();
        txt = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Homechat");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(500, 200, 0, 0));
        setMaximumSize(new java.awt.Dimension(278, 375));
        setMinimumSize(new java.awt.Dimension(278, 375));
        setPreferredSize(new java.awt.Dimension(278, 375));
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(133, 188, 244));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(53, 294, 63, 30);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(148, 294, 71, 30);

        checks.setText("Static server");
        checks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checksActionPerformed(evt);
            }
        });
        getContentPane().add(checks);
        checks.setBounds(53, 265, 101, 25);

        txt.setText("192.168.0.110");
        txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMouseClicked(evt);
            }
        });
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });
        getContentPane().add(txt);
        txt.setBounds(101, 211, 139, 22);

        name.setText("Your name");
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
        });
        getContentPane().add(name);
        name.setBounds(101, 240, 139, 22);

        jLabel1.setText("Server: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(25, 214, 47, 16);

        jLabel2.setText("Your name: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(25, 243, 71, 16);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/Untitled-2.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 272, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (checks.isSelected()){
        String st="";
        if (name.getText().equals(st)){
            JOptionPane.showMessageDialog(null, "Enter your name!");
        }
        else {
        
        String id=name.getText();
        fr.setVisible(true);
        fr.username=id;
        fr.isConnected=true;
        CloseFrame();
        }
        }else {
            String stt="";
            String iip="Enter IP address...";
            if (txt.getText().equals(iip)||txt.getText().equals(stt)){
            JOptionPane.showMessageDialog(null, "Enter IP!");
        }
            if (name.getText().equals(stt)){
            JOptionPane.showMessageDialog(null, "Enter your name!");
        }
            if (!txt.getText().equals(stt) && !name.getText().equals(stt))
            {
                String id=name.getText();
                System.out.println(""+id);
                fr.setVisible(true);
                fr.username=id;
                fr.address=txt.getText();
                fr.isConnected=true;
                CloseFrame();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMouseClicked
        txt.requestFocus();
        txt.selectAll();
    }//GEN-LAST:event_txtMouseClicked

    private void checksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checksActionPerformed
        if (checks.isSelected()){
        txt.setEnabled(false);
        fr.address="192.168.137.1";
        }
        else {
            txt.setEnabled(true);
            fr.address=txt.getText();
        }
    }//GEN-LAST:event_checksActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            if (checks.isSelected()){
        String st="";
        if (name.getText().equals(st)){
            JOptionPane.showMessageDialog(null, "Enter your name!");
        }
        else {
        
        String id=name.getText();
        fr.setVisible(true);
        fr.username=id;
        fr.isConnected=true;
        CloseFrame();
        }
        }else {
            String stt="";
            String iip="Enter IP address...";
            if (txt.getText().equals(iip)||txt.getText().equals(stt)){
            JOptionPane.showMessageDialog(null, "Enter IP!");
        }
            if (name.getText().equals(stt)){
            JOptionPane.showMessageDialog(null, "Enter your name!");
        }
            if (!txt.getText().equals(stt) && !name.getText().equals(stt))
            {
                String id=name.getText();
                System.out.println(""+id);
                fr.setVisible(true);
                fr.username=id;
                fr.address=txt.getText();
                fr.isConnected=true;
                CloseFrame();
            }
        }
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            if (checks.isSelected()){
        String st="";
        if (name.getText().equals(st)){
            JOptionPane.showMessageDialog(null, "Enter your name!");
        }
        else {
        
        String id=name.getText();
        fr.setVisible(true);
        fr.username=id;
        fr.isConnected=true;
        CloseFrame();
        }
        }else {
            String stt="";
            String iip="Enter IP address...";
            if (txt.getText().equals(iip)||txt.getText().equals(stt)){
            JOptionPane.showMessageDialog(null, "Enter IP!");
        }
            if (name.getText().equals(stt)){
            JOptionPane.showMessageDialog(null, "Enter your name!");
        }
            if (!txt.getText().equals(stt) && !name.getText().equals(stt))
            {
                String id=name.getText();
                System.out.println(""+id);
                fr.setVisible(true);
                fr.username=id;
                fr.address=txt.getText();
                //System.out.println(""+fr.address);
                fr.isConnected=true;
                CloseFrame();
            }
        }
        }
    }//GEN-LAST:event_nameKeyPressed

    private void txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            name.selectAll();
            name.requestFocus();
        }
    }//GEN-LAST:event_txtKeyPressed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checks;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JTextField name;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables
}
