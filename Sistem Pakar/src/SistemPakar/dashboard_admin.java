/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SistemPakar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author admin01
 */
public class dashboard_admin extends javax.swing.JFrame {
    private DefaultTableModel model;
    /**
     * Creates new form dashboard_admin
     */
    public dashboard_admin() {
        initComponents();

        model = new DefaultTableModel();
        tabelPenyakit.setModel(model);
        model.addColumn("Kode");
        model.addColumn("Nama Penyakit");
        model.addColumn("Deskripsi");
        model.addColumn("Solusi");

        tampilPenyakit();

        model = new DefaultTableModel();
        tabelGejala.setModel(model);
        model.addColumn("Kode");
        model.addColumn("Nama Gejala");
        model.addColumn("Pertanyaan");

        tampilGejala();

        model = new DefaultTableModel();
        tabelAturan.setModel(model);
        model.addColumn("Kode");
        model.addColumn("Jika");
        model.addColumn("Maka");

        tampilAturan();

        model = new DefaultTableModel();
        tabelUser.setModel(model);
        model.addColumn("ID User");
        model.addColumn("Username");
        model.addColumn("Level");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn(("No Telepon"));

        tampilUser();
    }

    private void tampilPenyakit() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Statement stat = (Statement)koneksi.koneksiDb().createStatement();
            String sql = "SELECT * FROM penyakit";
            ResultSet dataPenyakit = stat.executeQuery(sql);

            while (dataPenyakit.next()) {
                Object[] obj = new Object[4];
                obj[0] = dataPenyakit.getString("kode");
                obj[1] = dataPenyakit.getString("nama");
                obj[2] = dataPenyakit.getString("deskripsi");
                obj[3] = dataPenyakit.getString("solusi");

                model.addRow(obj);
            }
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());}
    }

    private void tampilGejala() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Statement stat = (Statement)koneksi.koneksiDb().createStatement();
            String sql = "SELECT * FROM gejala";
            ResultSet dataGejala = stat.executeQuery(sql);

            while (dataGejala.next()) {
                Object[] obj = new Object[3];
                obj[0] = dataGejala.getString("kode");
                obj[1] = dataGejala.getString("nama");
                obj[2] = dataGejala.getString("pertanyaan");          

                model.addRow(obj);
            }
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());}
    }

    private void tampilAturan() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Statement stat = (Statement)koneksi.koneksiDb().createStatement();
            String sql = "SELECT * FROM aturan";
            ResultSet dataAturan = stat.executeQuery(sql);

            while (dataAturan.next()) {
                Object[] obj = new Object[3];
                obj[0] = dataAturan.getString("kode");
                obj[1] = dataAturan.getString("jika");
                obj[2] = dataAturan.getString("maka");

                model.addRow(obj);
            }
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());}
    }

    private void tampilUser() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Statement stat = (Statement)koneksi.koneksiDb().createStatement();
            String sql = "SELECT * FROM user";
            ResultSet dataUser = stat.executeQuery(sql);

            while (dataUser.next()) {
                Object[] obj = new Object[7];
                obj[0] = dataUser.getString("nama");
                obj[1] = dataUser.getString("alamat");
                obj[2] = dataUser.getString("telp");
                obj[3] = dataUser.getString("id_user");
                obj[4] = dataUser.getString("level");
                obj[5] = dataUser.getString("username");
                obj[6] = dataUser.getString("password");

                model.addRow(obj);
            }
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgWhite = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        labelSistemPakar = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JButton();
        btnTambahPenyakit = new javax.swing.JButton();
        dataPenyakit = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPenyakit = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelGejala = new javax.swing.JTable();
        dataGejala = new javax.swing.JLabel();
        btnTambahGejala = new javax.swing.JButton();
        DataAturan = new javax.swing.JLabel();
        btnTambahAturan = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelAturan = new javax.swing.JTable();
        btnTambahUser = new javax.swing.JButton();
        dataUser = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelUser = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgWhite.setBackground(new java.awt.Color(254, 254, 254));

        jPanel1.setBackground(new java.awt.Color(238, 99, 99));

        labelSistemPakar.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        labelSistemPakar.setForeground(new java.awt.Color(254, 254, 254));
        labelSistemPakar.setText("Sistem Pakar");
        labelSistemPakar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnKeluar.setBackground(new java.awt.Color(254, 254, 254));
        btnKeluar.setText("Keluar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelSistemPakar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKeluar)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKeluar)
                    .addComponent(labelSistemPakar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnTambahPenyakit.setBackground(new java.awt.Color(254, 254, 254));
        btnTambahPenyakit.setText("Tambah");
        btnTambahPenyakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahPenyakitActionPerformed(evt);
            }
        });

        dataPenyakit.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        dataPenyakit.setText("Data Penyakit");

        tabelPenyakit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelPenyakit);

        tabelGejala.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabelGejala);

        dataGejala.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        dataGejala.setText("Data Gejala");

        btnTambahGejala.setBackground(new java.awt.Color(254, 254, 254));
        btnTambahGejala.setText("Tambah");
        btnTambahGejala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahGejalaActionPerformed(evt);
            }
        });

        DataAturan.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        DataAturan.setText("Data Aturan");

        btnTambahAturan.setBackground(new java.awt.Color(254, 254, 254));
        btnTambahAturan.setText("Tambah");
        btnTambahAturan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahAturanActionPerformed(evt);
            }
        });

        tabelAturan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tabelAturan);

        btnTambahUser.setBackground(new java.awt.Color(254, 254, 254));
        btnTambahUser.setText("Tambah");
        btnTambahUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahUserActionPerformed(evt);
            }
        });

        dataUser.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        dataUser.setText("Data User");

        tabelUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tabelUser);

        javax.swing.GroupLayout bgWhiteLayout = new javax.swing.GroupLayout(bgWhite);
        bgWhite.setLayout(bgWhiteLayout);
        bgWhiteLayout.setHorizontalGroup(
            bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgWhiteLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgWhiteLayout.createSequentialGroup()
                        .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgWhiteLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(bgWhiteLayout.createSequentialGroup()
                                .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dataPenyakit)
                                    .addComponent(btnTambahPenyakit))
                                .addGap(275, 275, 275)))
                        .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgWhiteLayout.createSequentialGroup()
                                .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dataGejala)
                                    .addComponent(btnTambahGejala))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)))
                    .addGroup(bgWhiteLayout.createSequentialGroup()
                        .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DataAturan)
                            .addComponent(btnTambahAturan)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                            .addGroup(bgWhiteLayout.createSequentialGroup()
                                .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dataUser)
                                    .addComponent(btnTambahUser))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(30, 30, 30))
        );
        bgWhiteLayout.setVerticalGroup(
            bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgWhiteLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgWhiteLayout.createSequentialGroup()
                        .addComponent(dataPenyakit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambahPenyakit))
                    .addGroup(bgWhiteLayout.createSequentialGroup()
                        .addComponent(dataGejala)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambahGejala)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(bgWhiteLayout.createSequentialGroup()
                        .addComponent(DataAturan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambahAturan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgWhiteLayout.createSequentialGroup()
                        .addComponent(dataUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambahUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahPenyakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPenyakitActionPerformed
        this.dispose();
        tambah_penyakit f = new tambah_penyakit();
        f.setVisible(true);
    }//GEN-LAST:event_btnTambahPenyakitActionPerformed

    private void btnTambahGejalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahGejalaActionPerformed
        this.dispose();
        tambah_gejala f = new tambah_gejala();
        f.setVisible(true);
    }//GEN-LAST:event_btnTambahGejalaActionPerformed

    private void btnTambahAturanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahAturanActionPerformed
        this.dispose();
        tambah_aturan f = new tambah_aturan();
        f.setVisible(true);
    }//GEN-LAST:event_btnTambahAturanActionPerformed

    private void btnTambahUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahUserActionPerformed
        this.dispose();
        tambah_user f = new tambah_user();
        f.setVisible(true);
    }//GEN-LAST:event_btnTambahUserActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http:labelSistemPakaroad.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashboard_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataAturan;
    private javax.swing.JPanel bgWhite;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambahAturan;
    private javax.swing.JButton btnTambahGejala;
    private javax.swing.JButton btnTambahPenyakit;
    private javax.swing.JButton btnTambahUser;
    private javax.swing.JLabel dataGejala;
    private javax.swing.JLabel dataPenyakit;
    private javax.swing.JLabel dataUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelSistemPakar;
    private javax.swing.JTable tabelAturan;
    private javax.swing.JTable tabelGejala;
    private javax.swing.JTable tabelPenyakit;
    private javax.swing.JTable tabelUser;
    // End of variables declaration//GEN-END:variables
}
