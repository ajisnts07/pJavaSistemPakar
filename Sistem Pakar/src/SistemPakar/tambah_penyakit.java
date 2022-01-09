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
public class tambah_penyakit extends javax.swing.JFrame {
    private DefaultTableModel model;
    String kode, nama, deskripsi, solusi;
    /**
     * Creates new form tambah_penyakit
     */
    public tambah_penyakit() {
        initComponents();

        model = new DefaultTableModel();
        tabelPenyakit.setModel(model);  
        model.addColumn("Kode");
        model.addColumn("Nama Penyakit");
        model.addColumn("Deskripsi");
        model.addColumn("Solusi");

        tampilData();
    }

    private void loadData() {
        kode = txtKodePenyakit.getText();
        nama = txtNamaPenyakit.getText();
        deskripsi = txtDeskripsiPenyakit.getText();
        solusi = txtSolusi.getText();
    }

    private void tampilData() {
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

    private void tambahData() {
        loadData();
        try {
            if (txtKodePenyakit.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Isi kode penyakit terlebih dahulu");
            } else if (txtNamaPenyakit.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Isi nama penyakit terlebih dahulu");
            } else if (txtDeskripsiPenyakit.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Isi deskripsi penyakit terlebih dahulu");
            } else if (txtSolusi.getText().length()==0) {
               JOptionPane.showMessageDialog(null, "Isi solusi penyakit terlebih dahulu");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menyimpan data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        String sql = "INSERT INTO penyakit VALUES ('"+txtKodePenyakit.getText()+"','"+txtNamaPenyakit.getText()+"','"+txtDeskripsiPenyakit.getText()+"','"+txtSolusi.getText()+"')";
                        java.sql.Connection conn = (Connection)koneksi.koneksiDb();
                        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Berhasil, Data Berhasil Disimpan!");
                        this.dispose();
                        tambah_penyakit f = new tambah_penyakit();
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
                String sql = "DELETE FROM penyakit WHERE kode = '"+kode+"'";
                java.sql.Connection conn = (Connection)koneksi.koneksiDb();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Berhasil, data sudah di hapus!");
                this.dispose();
                tambah_penyakit f = new tambah_penyakit();
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
                String sql = "UPDATE penyakit SET nama = '"+nama+"', deskripsi = '"+deskripsi+"', solusi = '"+solusi+"' WHERE kode = '"+kode+"' ";
                java.sql.Connection conn = (Connection)koneksi.koneksiDb();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Berhasil, data sudah di perbaharui!");
                this.dispose();
                tambah_penyakit f = new tambah_penyakit();
                f.setVisible(true);
                tampilData();
                clearData(); 
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void clearData() {
        txtKodePenyakit.setText("");
        txtNamaPenyakit.setText("");
        txtDeskripsiPenyakit.setText("");
        txtSolusi.setText("");
    }

    private void selectData() {
        int i = tabelPenyakit.getSelectedRow();
        txtKodePenyakit.setText(""+model.getValueAt(i, 0));
        txtNamaPenyakit.setText(""+model.getValueAt(i, 1));
        txtDeskripsiPenyakit.setText(""+model.getValueAt(i, 2));
        txtSolusi.setText(""+model.getValueAt(i, 3));
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
        labelKodePenyakit = new javax.swing.JLabel();
        labelTambahPenyakit = new javax.swing.JLabel();
        txtKodePenyakit = new javax.swing.JTextField();
        labelNamaPenyakit = new javax.swing.JLabel();
        txtNamaPenyakit = new javax.swing.JTextField();
        labelDeskripsiPenyakit = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDeskripsiPenyakit = new javax.swing.JTextArea();
        labelSolusi = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtSolusi = new javax.swing.JTextArea();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPenyakit = new javax.swing.JTable();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgWhite.setBackground(new java.awt.Color(254, 254, 254));

        bgRed.setBackground(new java.awt.Color(238, 99, 99));

        labelKodePenyakit.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelKodePenyakit.setForeground(new java.awt.Color(254, 254, 254));
        labelKodePenyakit.setText("Kode Penyakit");

        labelTambahPenyakit.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        labelTambahPenyakit.setForeground(new java.awt.Color(254, 254, 254));
        labelTambahPenyakit.setText("Tambah Penyakit");

        labelNamaPenyakit.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelNamaPenyakit.setForeground(new java.awt.Color(254, 254, 254));
        labelNamaPenyakit.setText("Nama Penyakit");

        labelDeskripsiPenyakit.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelDeskripsiPenyakit.setForeground(new java.awt.Color(254, 254, 254));
        labelDeskripsiPenyakit.setText("Deskripsi Penyakit");

        txtDeskripsiPenyakit.setColumns(20);
        txtDeskripsiPenyakit.setRows(5);
        jScrollPane3.setViewportView(txtDeskripsiPenyakit);

        labelSolusi.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelSolusi.setForeground(new java.awt.Color(254, 254, 254));
        labelSolusi.setText("Solusi");

        txtSolusi.setColumns(20);
        txtSolusi.setRows(5);
        jScrollPane4.setViewportView(txtSolusi);

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

        javax.swing.GroupLayout bgRedLayout = new javax.swing.GroupLayout(bgRed);
        bgRed.setLayout(bgRedLayout);
        bgRedLayout.setHorizontalGroup(
            bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgRedLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgRedLayout.createSequentialGroup()
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelSolusi)
                        .addComponent(labelDeskripsiPenyakit)
                        .addComponent(labelNamaPenyakit)
                        .addComponent(txtKodePenyakit)
                        .addComponent(labelKodePenyakit)
                        .addComponent(labelTambahPenyakit, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addComponent(txtNamaPenyakit)
                        .addComponent(jScrollPane3)
                        .addComponent(jScrollPane4))
                    .addGroup(bgRedLayout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        bgRedLayout.setVerticalGroup(
            bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgRedLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(labelTambahPenyakit)
                .addGap(18, 18, 18)
                .addComponent(labelKodePenyakit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKodePenyakit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNamaPenyakit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPenyakit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDeskripsiPenyakit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSolusi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        tabelPenyakit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPenyakitMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPenyakit);

        btnKembali.setBackground(new java.awt.Color(238, 99, 99));
        btnKembali.setForeground(new java.awt.Color(254, 254, 254));
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgWhiteLayout = new javax.swing.GroupLayout(bgWhite);
        bgWhite.setLayout(bgWhiteLayout);
        bgWhiteLayout.setHorizontalGroup(
            bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgWhiteLayout.createSequentialGroup()
                .addComponent(bgRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .addGroup(bgWhiteLayout.createSequentialGroup()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        bgWhiteLayout.setVerticalGroup(
            bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgWhiteLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
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

    private void tabelPenyakitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPenyakitMouseClicked
        selectData();
    }//GEN-LAST:event_tabelPenyakitMouseClicked

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
        dashboard_admin f = new dashboard_admin();
        f.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

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
            java.util.logging.Logger.getLogger(tambah_penyakit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tambah_penyakit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tambah_penyakit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tambah_penyakit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tambah_penyakit().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelDeskripsiPenyakit;
    private javax.swing.JLabel labelKodePenyakit;
    private javax.swing.JLabel labelNamaPenyakit;
    private javax.swing.JLabel labelSolusi;
    private javax.swing.JLabel labelTambahPenyakit;
    private javax.swing.JTable tabelPenyakit;
    private javax.swing.JTextArea txtDeskripsiPenyakit;
    private javax.swing.JTextField txtKodePenyakit;
    private javax.swing.JTextField txtNamaPenyakit;
    private javax.swing.JTextArea txtSolusi;
    // End of variables declaration//GEN-END:variables
}
