/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kangservis.form;

import kangservis.util.MyDataSource;
import kangservis.util.Servis;

import javax.sql.DataSource;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author muham
 */
public class servicetampil extends javax.swing.JFrame {

    private final static DataSource ds = MyDataSource.getDataSource();
    private final static Object[] columnNames = new Object[]{"ID Servis", "Nama Servis", "Harga"};

    public servicetampil() {
        initComponents();
        loadServis();
        jButton2.addActionListener(e ->{
            String editServisSQL = "UPDATE servis SET nama = ? , harga = ? WHERE id_service = ?";
            try (
                    Connection con = ds.getConnection();
                    PreparedStatement statement = con.prepareStatement(editServisSQL)
            ){
                statement.setString(1, namatxt.getText());
                statement.setString(2, hargatxt.getText());
                statement.setString(3, idtxt.getText());
                statement.executeUpdate();
            }catch (SQLException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(rootPane,
                        "Pengubahan Service Gagal\nKode Error SQL = "+ ex.getSQLState(),
                        "Aksi Gagal", JOptionPane.ERROR_MESSAGE);
            }
            loadServis();
        });
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount()>1) fillField();
            }
        });
    }

    private void loadServis(){
        String loadServisSQL = "SELECT * FROM servis";
        try(
                Connection con = ds.getConnection();
                PreparedStatement statement = con.prepareStatement(loadServisSQL);
                ResultSet rs = statement.executeQuery()
        ){
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            while (rs.next()){
                tableModel.addRow(new Object[]{
                        rs.getString("id_service"),
                        rs.getString("nama"),
                        rs.getString("harga")
                });
            }
            jTable1.setModel(tableModel);
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane,
                    "Koneksi ke tabel di database gagal",
                    "Koneksi Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fillField(){
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();
        idtxt.setText((String) tableModel.getValueAt(selectedRow, 0));
        namatxt.setText((String) tableModel.getValueAt(selectedRow, 1));
        hargatxt.setText((String) tableModel.getValueAt(selectedRow, 2));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idtxt = new javax.swing.JTextField();
        namatxt = new javax.swing.JTextField();
        hargatxt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Nama Service", "Harga Service"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 510, 100));

        jButton1.setText("Tambah Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 530, 10));

        jLabel1.setText("ID Service : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel2.setText("Nama Service : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel3.setText("Harga Service :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        idtxt.setEditable(false);
        getContentPane().add(idtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 140, -1));
        getContentPane().add(namatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 140, -1));
        getContentPane().add(hargatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 140, -1));

        jButton2.setText("Edit");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new servicetambah(this).setVisible(true);
        Servis servis = servicetambah.getInput();
        if(!servis.getNamaService().equals("")||!servis.getHarga().equals("")){
            String tambahServisSQL = "INSERT INTO servis(nama, harga) VALUES(?,?)";
            try (Connection con = ds.getConnection();
                 PreparedStatement statement = con.prepareStatement(tambahServisSQL)){
                statement.setString(1, servis.getNamaService());
                statement.setInt(2, Integer.parseInt(servis.getHarga()));
                statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane,
                        "Penambahan Service Gagal\nKode Error SQL = "+e.getSQLState(),
                        "Aksi Gagal", JOptionPane.ERROR_MESSAGE);
            }
            loadServis();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(servicetampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(servicetampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(servicetampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(servicetampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new servicetampil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hargatxt;
    private javax.swing.JTextField idtxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField namatxt;
    // End of variables declaration//GEN-END:variables
}
