/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kangservis.form;

import kangservis.util.Servis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author muham
 */
public class servicetambah extends javax.swing.JDialog {

    public static Servis input = new Servis("", "","");

    public servicetambah(java.awt.Frame parent) {
        super(parent, true);
        initComponents();

        btntambah.addActionListener(e-> {
            input = new Servis("", namatxt.getText(), hargatxt.getText());
            dispose();
        });
    }

    public static Servis getInput(){
        return input;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btntambah = new javax.swing.JButton();
        namatxt = new javax.swing.JTextField();
        hargatxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nama Service : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Harga Service : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        btntambah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btntambah.setText("Tambah");
        getContentPane().add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        namatxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(namatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 130, -1));

        hargatxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(hargatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btntambah;
    private javax.swing.JTextField hargatxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField namatxt;
    // End of variables declaration//GEN-END:variables
}