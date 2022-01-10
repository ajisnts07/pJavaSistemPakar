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
public class tambah_gejala extends javax.swing.JFrame {
    private DefaultTableModel model;
    String kode, nama, pertanyaan;
    /**
     * Creates new form tambah_gejala
     */
    public tambah_gejala() {
        initComponents();

        model = new DefaultTableModel();
        tabelGejala.setModel(model);    
        model.addColumn("Kode");
        model.addColumn("Nama Gejala");
        model.addColumn("Pertanyaan");

        tampilData();
    }

    private void loadData() {
        kode = txtKodeGejala.getText();
        nama = txtNamaGejala.getText();
        pertanyaan = txtPertanyaan.getText();
    }

    private void tampilData() {
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

    private void tambahData() {
        loadData();
        try {
            if (txtKodeGejala.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Isi kode penyakit terlebih dahulu");
            } else if (txtNamaGejala.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Isi nama penyakit terlebih dahulu");
            } else if (txtPertanyaan.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Isi deskripsi penyakit terlebih dahulu");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menyimpan data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        String sql = "INSERT INTO gejala VALUES ('"+txtKodeGejala.getText()+"','"+txtNamaGejala.getText()+"','"+txtPertanyaan.getText()+"')";
                        java.sql.Connection conn = (Connection)koneksi.koneksiDb();
                        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Berhasil, Data Berhasil Disimpan!");
                        this.dispose();
                        tambah_gejala f = new tambah_gejala();
                        f.setVisible(true);
                    } catch (SQLException | HeadlessException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        } catch (Exception e){}
    }

     private void hapusData() {
        loadData();
        int confirm = JOptionPane.showConfirmDialog(null, "Bernarkah anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM gejala WHERE kode = '"+kode+"'";
                java.sql.Connection conn = (Connection)koneksi.koneksiDb();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Berhasil, data sudah di hapus!");
                this.dispose();
                tambah_gejala f = new tambah_gejala();
                f.setVisible(true);
                tampilData();
                clearData(); 
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void editData() {
        loadData();
        int confirm = JOptionPane.showConfirmDialog(null, "Bernarkah anda ingin menyimpan perubahan ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String sql = "UPDATE gejala SET nama = '"+nama+"', pertanyaan = '"+pertanyaan+"' WHERE kode = '"+kode+"' ";
                java.sql.Connection conn = (Connection)koneksi.koneksiDb();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Berhasil, data sudah di perbaharui!");
                this.dispose();
                tambah_gejala f = new tambah_gejala();
                f.setVisible(true);
                tampilData();
                clearData(); 
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void clearData() {
        txtKodeGejala.setText("");
        txtNamaGejala.setText("");
        txtPertanyaan.setText("");
    }

    private void selectData() {
        int i = tabelGejala.getSelectedRow();
        txtKodeGejala.setText(""+model.getValueAt(i, 0));
        txtNamaGejala.setText(""+model.getValueAt(i, 1));
        txtPertanyaan.setText(""+model.getValueAt(i, 2));
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
        bgRed = new javax.swing.JPanel();
        labelKodeGejala = new javax.swing.JLabel();
        labelTambahPenyakit = new javax.swing.JLabel();
        txtKodeGejala = new javax.swing.JTextField();
        labelNamaGejala = new javax.swing.JLabel();
        txtNamaGejala = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtPertanyaan = new javax.swing.JTextField();
        labelPertanyaan = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelGejala = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgWhite.setBackground(new java.awt.Color(254, 254, 254));

        bgRed.setBackground(new java.awt.Color(238, 99, 99));

        labelKodeGejala.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelKodeGejala.setForeground(new java.awt.Color(254, 254, 254));
        labelKodeGejala.setText("Kode Gejala");

        labelTambahPenyakit.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        labelTambahPenyakit.setForeground(new java.awt.Color(254, 254, 254));
        labelTambahPenyakit.setText("Tambah Gejala");

        labelNamaGejala.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelNamaGejala.setForeground(new java.awt.Color(254, 254, 254));
        labelNamaGejala.setText("Nama Gejala");

        btnTambah.setBackground(new java.awt.Color(254, 254, 254));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(254, 254, 254));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(254, 254, 254));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(254, 254, 254));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        labelPertanyaan.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelPertanyaan.setForeground(new java.awt.Color(254, 254, 254));
        labelPertanyaan.setText("Pertanyaan");

        javax.swing.GroupLayout bgRedLayout = new javax.swing.GroupLayout(bgRed);
        bgRed.setLayout(bgRedLayout);
        bgRedLayout.setHorizontalGroup(
            bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgRedLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgRedLayout.createSequentialGroup()
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgRedLayout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelPertanyaan)
                        .addGroup(bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPertanyaan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNamaGejala, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKodeGejala, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelKodeGejala, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTambahPenyakit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNamaGejala, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        bgRedLayout.setVerticalGroup(
            bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgRedLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(labelTambahPenyakit)
                .addGap(18, 18, 18)
                .addComponent(labelKodeGejala)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKodeGejala, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNamaGejala)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaGejala, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPertanyaan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPertanyaan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnKembali.setBackground(new java.awt.Color(238, 99, 99));
        btnKembali.setForeground(new java.awt.Color(254, 254, 254));
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

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
        tabelGejala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelGejalaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelGejala);

        javax.swing.GroupLayout bgWhiteLayout = new javax.swing.GroupLayout(bgWhite);
        bgWhite.setLayout(bgWhiteLayout);
        bgWhiteLayout.setHorizontalGroup(
            bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgWhiteLayout.createSequentialGroup()
                .addComponent(bgRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgWhiteLayout.createSequentialGroup()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 335, Short.MAX_VALUE))
                    .addGroup(bgWhiteLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18))))
        );
        bgWhiteLayout.setVerticalGroup(
            bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgWhiteLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
       tambahData();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       editData();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapusData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearData();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
        dashboard_admin f = new dashboard_admin();
        f.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void tabelGejalaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelGejalaMouseClicked
        selectData();
    }//GEN-LAST:event_tabelGejalaMouseClicked

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
            java.util.logging.Logger.getLogger(tambah_gejala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tambah_gejala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tambah_gejala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tambah_gejala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tambah_gejala().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgRed;
    private javax.swing.JPanel bgWhite;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelKodeGejala;
    private javax.swing.JLabel labelNamaGejala;
    private javax.swing.JLabel labelPertanyaan;
    private javax.swing.JLabel labelTambahPenyakit;
    private javax.swing.JTable tabelGejala;
    private javax.swing.JTextField txtKodeGejala;
    private javax.swing.JTextField txtNamaGejala;
    private javax.swing.JTextField txtPertanyaan;
    // End of variables declaration//GEN-END:variables
}
