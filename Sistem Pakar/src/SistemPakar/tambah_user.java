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
public class tambah_user extends javax.swing.JFrame {
    private DefaultTableModel model;
    String id_user, username, password, level, nama, alamat, telp;
    /**
     * Creates new form tambah_user
     */
    public tambah_user() {
        initComponents();

        model = new DefaultTableModel();
        tabelUser.setModel(model);
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("No Telepon");
        model.addColumn("ID User");
        model.addColumn("Level");
        model.addColumn("Username");
        model.addColumn(("Password"));

        tampilData();
    }

    private void loadData() {
        id_user = txtIdUser.getText();
        username = txtUsername.getText();
        password = txtPassword.getText();
        level = (String)comboLevel.getSelectedItem();
        nama = txtNama.getText();
        alamat = txtAlamat.getText();
        telp = txtNoTelepon.getText();
    }

    private void tampilData() {
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

    private void tambahData() {
        loadData();
        try {
            if (txtIdUser.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Isi id user terlebih dahulu");
            } else if (txtUsername.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Isi username terlebih dahulu");
            } else if (txtPassword.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Isi password terlebih dahulu");
            } else if (comboLevel.getSelectedItem().equals(true)) {
                JOptionPane.showMessageDialog(null, "Pilih level terlebih dahulu");
            } else if (txtNama.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Isi nama terlebih dahulu");
            } else if (txtAlamat.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Isi alamat terlebih dahulu");
            } else if (txtNoTelepon.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Isi no telepon terlebih dahulu");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menyimpan data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        String sql = "INSERT INTO user VALUES ('"+txtIdUser.getText()+"','"+txtUsername.getText()+"','"+txtPassword.getText()+"','"+comboLevel.getSelectedItem()+"','"+txtNama.getText()+"','"+txtAlamat.getText()+"','"+txtNoTelepon.getText()+"')";
                        java.sql.Connection conn = (Connection)koneksi.koneksiDb();
                        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Berhasil, Data Berhasil Disimpan!");
                        this.dispose();
                        tambah_user f = new tambah_user();
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
                String sql = "DELETE FROM user WHERE id_user = '"+id_user+"'";
                java.sql.Connection conn = (Connection)koneksi.koneksiDb();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Berhasil, data sudah di hapus!");
                this.dispose();
                tambah_user f = new tambah_user();
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
                String sql = "UPDATE user SET username = '"+username+"', password = '"+password+"', level = '"+level+"', nama = '"+nama+"', alamat = '"+alamat+"', telp = '"+telp+"' WHERE id_user = '"+id_user+"' ";
                java.sql.Connection conn = (Connection)koneksi.koneksiDb();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Berhasil, data sudah di perbaharui!");
                this.dispose();
                tambah_user f = new tambah_user();
                f.setVisible(true);
                tampilData();
                clearData(); 
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void clearData() {
        txtIdUser.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        comboLevel.setSelectedItem("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtNoTelepon.setText("");
    }

    private void selectData() {
        int i = tabelUser.getSelectedRow(); 
        txtNama.setText(""+model.getValueAt(i, 0));
        txtAlamat.setText(""+model.getValueAt(i, 1));
        txtNoTelepon.setText(""+model.getValueAt(i, 2));
        txtIdUser.setText(""+model.getValueAt(i, 3));
        comboLevel.setSelectedItem(""+model.getValueAt(i, 4));
        txtUsername.setText(""+model.getValueAt(i, 5));
        txtPassword.setText(""+model.getValueAt(i, 6));        
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
        bgBlue = new javax.swing.JPanel();
        labelDataUser = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        labelNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        labelAlamat = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        labelNoTelepon = new javax.swing.JLabel();
        txtNoTelepon = new javax.swing.JTextField();
        labelLevel = new javax.swing.JLabel();
        txtIdUser = new javax.swing.JTextField();
        comboLevel = new javax.swing.JComboBox<>();
        labelIdUser = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        logo = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelUser = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgWhite.setBackground(new java.awt.Color(254, 254, 254));

        bgBlue.setBackground(new java.awt.Color(238, 99, 99));

        labelDataUser.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        labelDataUser.setForeground(new java.awt.Color(254, 254, 254));
        labelDataUser.setText("Data User");

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

        labelNama.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelNama.setForeground(new java.awt.Color(254, 254, 254));
        labelNama.setText("Nama");

        labelAlamat.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelAlamat.setForeground(new java.awt.Color(254, 254, 254));
        labelAlamat.setText("Alamat");

        labelNoTelepon.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelNoTelepon.setForeground(new java.awt.Color(254, 254, 254));
        labelNoTelepon.setText("No Telepon");

        labelLevel.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelLevel.setForeground(new java.awt.Color(254, 254, 254));
        labelLevel.setText("Level");

        comboLevel.setBackground(new java.awt.Color(254, 254, 254));
        comboLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin"}));

        labelIdUser.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelIdUser.setForeground(new java.awt.Color(254, 254, 254));
        labelIdUser.setText("ID User");

        labelUsername.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelUsername.setForeground(new java.awt.Color(254, 254, 254));
        labelUsername.setText("Username");

        labelPassword.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelPassword.setForeground(new java.awt.Color(254, 254, 254));
        labelPassword.setText("Password");

        javax.swing.GroupLayout bgBlueLayout = new javax.swing.GroupLayout(bgBlue);
        bgBlue.setLayout(bgBlueLayout);
        bgBlueLayout.setHorizontalGroup(
            bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgBlueLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgBlueLayout.createSequentialGroup()
                        .addGroup(bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPassword)
                            .addComponent(labelUsername)
                            .addComponent(labelNama)
                            .addComponent(labelAlamat)
                            .addComponent(labelNoTelepon))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBlueLayout.createSequentialGroup()
                        .addGroup(bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoTelepon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgBlueLayout.createSequentialGroup()
                                .addComponent(labelDataUser, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(bgBlueLayout.createSequentialGroup()
                                .addGroup(bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTambah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIdUser)
                                    .addGroup(bgBlueLayout.createSequentialGroup()
                                        .addComponent(labelIdUser)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgBlueLayout.createSequentialGroup()
                                        .addComponent(labelLevel)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(22, 22, 22))))
        );
        bgBlueLayout.setVerticalGroup(
            bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgBlueLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelDataUser)
                .addGap(18, 18, 18)
                .addComponent(labelNama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAlamat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNoTelepon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLevel)
                    .addComponent(labelIdUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboLevel)
                    .addComponent(txtIdUser, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
        tabelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelUser);

        javax.swing.GroupLayout bgWhiteLayout = new javax.swing.GroupLayout(bgWhite);
        bgWhite.setLayout(bgWhiteLayout);
        bgWhiteLayout.setHorizontalGroup(
            bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgWhiteLayout.createSequentialGroup()
                .addComponent(bgBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgWhiteLayout.createSequentialGroup()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(327, 327, 327))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        bgWhiteLayout.setVerticalGroup(
            bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgWhiteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(bgWhiteLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearData();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapusData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        editData();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        tambahData();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
        dashboard_admin f = new dashboard_admin();
        f.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void tabelUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelUserMouseClicked
        selectData();
    }//GEN-LAST:event_tabelUserMouseClicked

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
            java.util.logging.Logger.getLogger(tambah_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tambah_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tambah_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tambah_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tambah_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgBlue;
    private javax.swing.JPanel bgWhite;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> comboLevel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAlamat;
    private javax.swing.JLabel labelDataUser;
    private javax.swing.JLabel labelIdUser;
    private javax.swing.JLabel labelLevel;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelNoTelepon;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tabelUser;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtIdUser;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoTelepon;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
