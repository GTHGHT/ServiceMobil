/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Function.MysqlCon;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author rizky
 */
public class Tampil_Mobil extends javax.swing.JFrame {
    private final static DataSource ds = MysqlCon.getDataSource();
    private final static Object[] columnNames = new Object[]{"ID Customer", "Nama Customer", "No HandPhone"};
    private final static Object[] columnNames2 = new Object[]{"Plat", "Merek Mobil"};
    /**
     * Creates new form login
     */
    public Tampil_Mobil() {
        initComponents();
        loadCustomer();
        Txt_ID_Cust.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void changedUpdate(DocumentEvent e) {
          changed();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
          changed();
        }
        @Override
        public void insertUpdate(DocumentEvent e) {
          changed();
        }

        public void changed() {
            loadMobil();
        }
      });
    }
    
    private void loadMobil(){
        String loadServisSQL = "SELECT * FROM mobil_cust LEFT JOIN cust ON mobil_cust.id_cust = cust.id_cust "
                +"WHERE mobil_cust.id_cust = ? ";
        try(
                Connection con = ds.getConnection();
                PreparedStatement statement = con.prepareStatement(loadServisSQL);
        ){
            statement.setString(1, Txt_ID_Cust.getText());
        try(ResultSet rs = statement.executeQuery()){
            DefaultTableModel tableModel = new DefaultTableModel(columnNames2, 0){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            while (rs.next()){
                tableModel.addRow(new Object[]{
                        rs.getString("plat"),
                        rs.getString("merek")
                });
            }
            tablemobil.setModel(tableModel);
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane,
                    "Koneksi ke tabel di database gagal",
                    "Koneksi Gagal", JOptionPane.ERROR_MESSAGE);
        }
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane,
                    "Koneksi ke tabel di database gagal",
                    "Koneksi Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void fillField(){
        DefaultTableModel tableModel = (DefaultTableModel) tablecust.getModel();
        int selectedRow = tablecust.getSelectedRow();
        Txt_ID_Cust.setText((String) tableModel.getValueAt(selectedRow, 0));
        Txt_Nama.setText((String) tableModel.getValueAt(selectedRow, 1));
    }
    
    private void fillField2(){
        DefaultTableModel tableModel = (DefaultTableModel) tablemobil.getModel();
        int selectedRow = tablemobil.getSelectedRow();
        Txt_Plat.setText((String) tableModel.getValueAt(selectedRow, 0));
        Txt_Mobil.setText((String) tableModel.getValueAt(selectedRow, 1));
    }

    private void loadCustomer(){
        String loadCustomerSQL = "SELECT * FROM cust";
        try(
                Connection con = ds.getConnection();
                PreparedStatement statement = con.prepareStatement(loadCustomerSQL);
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
                        rs.getString("id_cust"),
                        rs.getString("nama"),
                        rs.getString("nohp")
                });
            }
            tablecust.setModel(tableModel);
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane,
                    "Koneksi ke tabel di database gagal",
                    "Koneksi Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void CariloadCustomer(){
        String cariMobilSQL = "SELECT * FROM cust WHERE id_cust LIKE ? OR nama LIKE ? OR nohp LIKE ?";
        try (Connection con = ds.getConnection();
            PreparedStatement statement = con.prepareStatement(cariMobilSQL)){
            statement.setString(1, '%'+field_Search.getText()+'%');
            statement.setString(2, '%'+field_Search.getText()+'%');
            statement.setString(3, '%'+field_Search.getText()+'%');
            ResultSet rs = statement.executeQuery();

            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            while (rs.next()){
                tableModel.addRow(new Object[]{
                        rs.getString("id_cust"),
                        rs.getString("nama"),
                        rs.getString("nohp")
                });
            }
            tablecust.setModel(tableModel);
            field_Search.setText("");                        
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane,
                    "Pencarian Gagal\nKode Error SQL = "+e.getSQLState(),
                    "Aksi Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Panel_1 = new javax.swing.JPanel();
        TOP_Panel = new javax.swing.JPanel();
        label_Kepemilikan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Tabel = new javax.swing.JScrollPane();
        tablecust = new javax.swing.JTable();
        lbl_ID_Cust = new javax.swing.JLabel();
        lbl_Nama = new javax.swing.JLabel();
        lbl_Jenis_Mobil = new javax.swing.JLabel();
        lbl_Plat = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        Txt_ID_Cust = new javax.swing.JTextField();
        Txt_Mobil = new javax.swing.JTextField();
        Txt_Plat = new javax.swing.JTextField();
        Txt_Nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ICON_ADD_NEW = new javax.swing.JLabel();
        bt_Search = new javax.swing.JButton();
        lbl_CRUD = new javax.swing.JLabel();
        Judul_Icon_Data_Diri = new javax.swing.JLabel();
        label_Icon_Data_Diri = new javax.swing.JLabel();
        field_Search = new javax.swing.JTextField();
        Tabel1 = new javax.swing.JScrollPane();
        tablemobil = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Customer", "Plat", "Mobil"
            }
        ));
        jTable1.setAutoscrolls(false);
        jTable1.setPreferredSize(new java.awt.Dimension(400, 120));
        jScrollPane1.setViewportView(jTable1);

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Panel_1.setBackground(new java.awt.Color(2, 48, 71));
        Panel_1.setPreferredSize(new java.awt.Dimension(5010, 4480));
        Panel_1.setLayout(null);

        TOP_Panel.setBackground(new java.awt.Color(79, 93, 117));
        TOP_Panel.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        label_Kepemilikan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        label_Kepemilikan.setForeground(new java.awt.Color(129, 178, 154));
        label_Kepemilikan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Kepemilikan.setText("Kepemilikan Mobil");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon_tampil_mobil/Kepemilikan_Mobil.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon_tampil_mobil/Minimize.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon_tampil_mobil/Close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout TOP_PanelLayout = new javax.swing.GroupLayout(TOP_Panel);
        TOP_Panel.setLayout(TOP_PanelLayout);
        TOP_PanelLayout.setHorizontalGroup(
            TOP_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TOP_PanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_Kepemilikan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 422, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        TOP_PanelLayout.setVerticalGroup(
            TOP_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(TOP_PanelLayout.createSequentialGroup()
                .addGroup(TOP_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TOP_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_Kepemilikan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_1.add(TOP_Panel);
        TOP_Panel.setBounds(0, 0, 690, 30);

        tablecust.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Cust", "Nama", "No. HP"
            }
        ));
        tablecust.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablecustMouseClicked(evt);
            }
        });
        Tabel.setViewportView(tablecust);
        if (tablecust.getColumnModel().getColumnCount() > 0) {
            tablecust.getColumnModel().getColumn(0).setHeaderValue("ID Cust");
            tablecust.getColumnModel().getColumn(1).setHeaderValue("Nama");
        }

        Panel_1.add(Tabel);
        Tabel.setBounds(20, 160, 290, 130);

        lbl_ID_Cust.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_ID_Cust.setText("ID Customer ");
        Panel_1.add(lbl_ID_Cust);
        lbl_ID_Cust.setBounds(340, 150, 90, 30);

        lbl_Nama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_Nama.setText("Nama ");
        Panel_1.add(lbl_Nama);
        lbl_Nama.setBounds(340, 220, 50, 30);

        lbl_Jenis_Mobil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_Jenis_Mobil.setText("Jenis Mobil ");
        Panel_1.add(lbl_Jenis_Mobil);
        lbl_Jenis_Mobil.setBounds(340, 360, 80, 30);

        lbl_Plat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_Plat.setText("Plat ");
        Panel_1.add(lbl_Plat);
        lbl_Plat.setBounds(340, 290, 40, 30);

        jLabel5.setText(":");
        Panel_1.add(jLabel5);
        jLabel5.setBounds(420, 290, 34, 30);

        jLabel6.setText(":");
        Panel_1.add(jLabel6);
        jLabel6.setBounds(420, 360, 34, 30);

        jLabel7.setText(":");
        Panel_1.add(jLabel7);
        jLabel7.setBounds(420, 140, 34, 50);

        jLabel8.setText(":");
        Panel_1.add(jLabel8);
        jLabel8.setBounds(420, 220, 34, 30);
        Panel_1.add(jSeparator2);
        jSeparator2.setBounds(440, 250, 220, 30);
        Panel_1.add(jSeparator3);
        jSeparator3.setBounds(440, 320, 220, 30);
        Panel_1.add(jSeparator4);
        jSeparator4.setBounds(440, 390, 220, 30);
        Panel_1.add(jSeparator5);
        jSeparator5.setBounds(440, 180, 220, 30);

        Txt_ID_Cust.setEditable(false);
        Txt_ID_Cust.setBackground(new java.awt.Color(244, 241, 222));
        Txt_ID_Cust.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Txt_ID_Cust.setForeground(new java.awt.Color(142, 139, 120));
        Txt_ID_Cust.setText("Masukkan ID Customer");
        Txt_ID_Cust.setBorder(null);
        Txt_ID_Cust.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Txt_ID_CustFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Txt_ID_CustFocusLost(evt);
            }
        });
        Txt_ID_Cust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_ID_CustActionPerformed(evt);
            }
        });
        Panel_1.add(Txt_ID_Cust);
        Txt_ID_Cust.setBounds(440, 150, 210, 30);

        Txt_Mobil.setBackground(new java.awt.Color(244, 241, 222));
        Txt_Mobil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Txt_Mobil.setForeground(new java.awt.Color(142, 139, 120));
        Txt_Mobil.setText("Masukkan Jenis Mobil");
        Txt_Mobil.setBorder(null);
        Txt_Mobil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Txt_MobilFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Txt_MobilFocusLost(evt);
            }
        });
        Panel_1.add(Txt_Mobil);
        Txt_Mobil.setBounds(440, 360, 210, 30);

        Txt_Plat.setBackground(new java.awt.Color(244, 241, 222));
        Txt_Plat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Txt_Plat.setForeground(new java.awt.Color(142, 139, 120));
        Txt_Plat.setText("Masukkan Plat");
        Txt_Plat.setBorder(null);
        Txt_Plat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Txt_PlatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Txt_PlatFocusLost(evt);
            }
        });
        Txt_Plat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_PlatActionPerformed(evt);
            }
        });
        Panel_1.add(Txt_Plat);
        Txt_Plat.setBounds(440, 290, 210, 30);

        Txt_Nama.setBackground(new java.awt.Color(244, 241, 222));
        Txt_Nama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Txt_Nama.setForeground(new java.awt.Color(142, 139, 120));
        Txt_Nama.setText("Masukkan Nama Customer");
        Txt_Nama.setBorder(null);
        Txt_Nama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Txt_NamaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Txt_NamaFocusLost(evt);
            }
        });
        Panel_1.add(Txt_Nama);
        Txt_Nama.setBounds(440, 220, 210, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon_tampil_mobil/Tambah.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        Panel_1.add(jLabel4);
        jLabel4.setBounds(430, 420, 40, 30);

        ICON_ADD_NEW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ICON_ADD_NEW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon_tampil_mobil/Edit_Folder.png"))); // NOI18N
        ICON_ADD_NEW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ICON_ADD_NEWMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ICON_ADD_NEWMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ICON_ADD_NEWMouseExited(evt);
            }
        });
        Panel_1.add(ICON_ADD_NEW);
        ICON_ADD_NEW.setBounds(530, 410, 40, 50);

        bt_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon_tampil_mobil/Search.png"))); // NOI18N
        bt_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SearchActionPerformed(evt);
            }
        });
        Panel_1.add(bt_Search);
        bt_Search.setBounds(250, 90, 40, 30);

        lbl_CRUD.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lbl_CRUD.setForeground(new java.awt.Color(129, 178, 154));
        lbl_CRUD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_CRUD.setText("EDIT DATA CUST");
        lbl_CRUD.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_CRUD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel_1.add(lbl_CRUD);
        lbl_CRUD.setBounds(420, 90, 150, 20);

        Judul_Icon_Data_Diri.setBackground(new java.awt.Color(204, 51, 0));
        Judul_Icon_Data_Diri.setForeground(new java.awt.Color(51, 51, 255));
        Judul_Icon_Data_Diri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon_tampil_mobil/Judul_Icon_Data_Diri.png"))); // NOI18N
        Judul_Icon_Data_Diri.setText("jLabel1");
        Panel_1.add(Judul_Icon_Data_Diri);
        Judul_Icon_Data_Diri.setBounds(410, 60, 170, 80);

        label_Icon_Data_Diri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon_tampil_mobil/Data_Diri.png"))); // NOI18N
        label_Icon_Data_Diri.setPreferredSize(new java.awt.Dimension(120, 175));
        Panel_1.add(label_Icon_Data_Diri);
        label_Icon_Data_Diri.setBounds(320, 90, 350, 390);

        field_Search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        field_Search.setForeground(new java.awt.Color(142, 139, 120));
        field_Search.setText("Search here");
        field_Search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                field_SearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                field_SearchFocusLost(evt);
            }
        });
        field_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_SearchActionPerformed(evt);
            }
        });
        Panel_1.add(field_Search);
        field_Search.setBounds(20, 90, 230, 30);

        tablemobil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Plat", "Jenis Mobil"
            }
        ));
        tablemobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablemobilMouseClicked(evt);
            }
        });
        Tabel1.setViewportView(tablemobil);

        Panel_1.add(Tabel1);
        Tabel1.setBounds(20, 330, 290, 130);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pemilik Mobil : ");
        Panel_1.add(jLabel9);
        jLabel9.setBounds(20, 130, 120, 22);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Kepemilikan Mobil : ");
        Panel_1.add(jLabel10);
        jLabel10.setBounds(20, 300, 160, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );

        Panel_1.getAccessibleContext().setAccessibleName("Halo");
        Panel_1.getAccessibleContext().setAccessibleDescription("Hei there");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SearchActionPerformed
        // TODO add your handling code here:
        CariloadCustomer();
    }//GEN-LAST:event_bt_SearchActionPerformed

    private void field_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_SearchActionPerformed

    private void Txt_PlatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_PlatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_PlatActionPerformed

    private void Txt_ID_CustFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Txt_ID_CustFocusGained
        // TODO add your handling code here:
        if(Txt_ID_Cust.getText().equals("Masukkan ID Customer")){
            Txt_ID_Cust.setText("");
            Txt_ID_Cust.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_Txt_ID_CustFocusGained

    private void Txt_ID_CustFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Txt_ID_CustFocusLost
        // TODO add your handling code here:
        if(Txt_ID_Cust.getText().equals("")){
            Txt_ID_Cust.setText("Masukkan ID Customer");
            Txt_ID_Cust.setForeground(new Color(142,139,120));
        }
    }//GEN-LAST:event_Txt_ID_CustFocusLost

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setBackground(new Color(247,131,132));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jLabel1.setBackground(new Color(247,131,132));
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setExtendedState(Tampil_Mobil.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void Txt_ID_CustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_ID_CustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_ID_CustActionPerformed

    private void Txt_NamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Txt_NamaFocusLost
        if(Txt_Nama.getText().equals("")){
            Txt_Nama.setText("Masukkan Nama Customer");
            Txt_Nama.setForeground(new Color(142,139,120));
        }
    }//GEN-LAST:event_Txt_NamaFocusLost

    private void Txt_NamaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Txt_NamaFocusGained
        if(Txt_Nama.getText().equals("Masukkan Nama Customer")){
            Txt_Nama.setText("");
            Txt_Nama.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_Txt_NamaFocusGained

    private void ICON_ADD_NEWMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ICON_ADD_NEWMouseEntered
        // TODO add your handling code here:
        ICON_ADD_NEW.setBackground(new Color(142,139,120));
    }//GEN-LAST:event_ICON_ADD_NEWMouseEntered

    private void ICON_ADD_NEWMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ICON_ADD_NEWMouseExited
        // TODO add your handling code here:
        ICON_ADD_NEW.setBackground(new Color(255,255,248));
    }//GEN-LAST:event_ICON_ADD_NEWMouseExited

    private void Txt_PlatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Txt_PlatFocusGained
        // TODO add your handling code here:
        if(Txt_Plat.getText().equals("Masukkan Plat")){
            Txt_Plat.setText("");
            Txt_Plat.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_Txt_PlatFocusGained

    private void Txt_PlatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Txt_PlatFocusLost
        // TODO add your handling code here:
        if(Txt_Plat.getText().equals("")){
            Txt_Plat.setText("Masukkan Plat");
            Txt_Plat.setForeground(new Color(142,139,120));
        }
    }//GEN-LAST:event_Txt_PlatFocusLost

    private void Txt_MobilFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Txt_MobilFocusGained
        // TODO add your handling code here:
        if(Txt_Mobil.getText().equals("Masukkan Jenis Mobil")){
            Txt_Mobil.setText("");
            Txt_Mobil.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_Txt_MobilFocusGained

    private void Txt_MobilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Txt_MobilFocusLost
        // TODO add your handling code here:
        if(Txt_Mobil.getText().equals("")){
            Txt_Mobil.setText("Masukkan Jenis Mobil");
            Txt_Mobil.setForeground(new Color(142,139,120));
        }
    }//GEN-LAST:event_Txt_MobilFocusLost

    private void field_SearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_field_SearchFocusGained
        // TODO add your handling code here:
        if(field_Search.getText().equals("Search here")){
            field_Search.setText("");
            field_Search.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_field_SearchFocusGained

    private void field_SearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_field_SearchFocusLost
        // TODO add your handling code here:
        if(field_Search.getText().equals("")){
            field_Search.setText("Search here");
            field_Search.setForeground(new Color(142,139,120));
        }
    }//GEN-LAST:event_field_SearchFocusLost

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        if (Txt_ID_Cust.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Input Masih Kosong");
        }else if (Txt_Nama.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Input Masih Kosong");
        }else if (Txt_Plat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Input Masih Kosong");
        }else if (Txt_Mobil.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Input Masih Kosong");
        } else {
            String tambahMobilSQL = "INSERT INTO mobil_cust(plat, merek, id_cust) VALUES(?,?,?)";
            try (Connection con = ds.getConnection();
                PreparedStatement statement = con.prepareStatement(tambahMobilSQL)){
                statement.setString(1, Txt_Plat.getText());
                statement.setString(2, Txt_Mobil.getText());
                statement.setString(3, Txt_ID_Cust.getText());
                statement.executeUpdate();
                Txt_ID_Cust.setText("");
                Txt_Plat.setText("");
                Txt_Nama.setText("");
                Txt_Mobil.setText(""); 
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di tambahkan");
            }catch (SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane,
                        "Data Gagal Ditambah Gagal\nKode Error SQL = "+e.getSQLState(),
                        "Aksi Gagal", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void tablecustMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablecustMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()>1){
            fillField();
            loadCustomer();
        } 
    }//GEN-LAST:event_tablecustMouseClicked

    private void tablemobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablemobilMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()>1){
            fillField2();
            loadMobil();
        }     
    }//GEN-LAST:event_tablemobilMouseClicked

    private void ICON_ADD_NEWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ICON_ADD_NEWMouseClicked
        // TODO add your handling code here:
        String editMobilSQL = "UPDATE mobil_cust SET plat = ? , merek = ?, id_cust = ? WHERE plat = ?";
        try (
                Connection con = ds.getConnection();
                PreparedStatement statement = con.prepareStatement(editMobilSQL)
        ){
            statement.setString(1, Txt_Plat.getText());
            statement.setString(2, Txt_Mobil.getText());
            statement.setString(3, Txt_ID_Cust.getText());
            statement.setString(4, Txt_Plat.getText());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            Txt_Nama.setText("");
            Txt_Plat.setText("");
            Txt_Mobil.setText("");
            Txt_ID_Cust.setText("");
        }catch (SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane,
                    "Pengubahan Data Mobil Gagal\nKode Error SQL = "+ ex.getSQLState(),
                    "Aksi Gagal", JOptionPane.ERROR_MESSAGE);
        }
        loadCustomer();
    }//GEN-LAST:event_ICON_ADD_NEWMouseClicked

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
            java.util.logging.Logger.getLogger(Tampil_Mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tampil_Mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tampil_Mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tampil_Mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tampil_Mobil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ICON_ADD_NEW;
    private javax.swing.JLabel Judul_Icon_Data_Diri;
    private javax.swing.JPanel Panel_1;
    private javax.swing.JPanel TOP_Panel;
    private javax.swing.JScrollPane Tabel;
    private javax.swing.JScrollPane Tabel1;
    private javax.swing.JTextField Txt_ID_Cust;
    private javax.swing.JTextField Txt_Mobil;
    private javax.swing.JTextField Txt_Nama;
    private javax.swing.JTextField Txt_Plat;
    private javax.swing.JButton bt_Search;
    private javax.swing.JTextField field_Search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel label_Icon_Data_Diri;
    private javax.swing.JLabel label_Kepemilikan;
    private javax.swing.JLabel lbl_CRUD;
    private javax.swing.JLabel lbl_ID_Cust;
    private javax.swing.JLabel lbl_Jenis_Mobil;
    private javax.swing.JLabel lbl_Nama;
    private javax.swing.JLabel lbl_Plat;
    private javax.swing.JTable tablecust;
    private javax.swing.JTable tablemobil;
    // End of variables declaration//GEN-END:variables
}
