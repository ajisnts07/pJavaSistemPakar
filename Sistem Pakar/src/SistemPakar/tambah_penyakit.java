/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SistemPakar;

/**
 *
 * @author admin01
 */
public class tambah_penyakit extends javax.swing.JFrame {

    /**
     * Creates new form tambah_penyakit
     */
    public tambah_penyakit() {
        initComponents();
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
        labelLupaKataSandi = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        inputUsername = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        labelUsername1 = new javax.swing.JLabel();
        inputUsername1 = new javax.swing.JTextField();
        labelUsername2 = new javax.swing.JLabel();
        labelUsername3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnCari1 = new javax.swing.JButton();
        btnCari2 = new javax.swing.JButton();
        btnCari3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgWhite.setBackground(new java.awt.Color(254, 254, 254));

        bgRed.setBackground(new java.awt.Color(238, 99, 99));

        labelLupaKataSandi.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        labelLupaKataSandi.setForeground(new java.awt.Color(254, 254, 254));
        labelLupaKataSandi.setText("Tambah Penyakit");

        labelUsername.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelUsername.setForeground(new java.awt.Color(254, 254, 254));
        labelUsername.setText("Kode Penyakit");

        btnCari.setBackground(new java.awt.Color(254, 254, 254));
        btnCari.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        btnCari.setText("Tambah");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        labelUsername1.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelUsername1.setForeground(new java.awt.Color(254, 254, 254));
        labelUsername1.setText("Nama Penyakit");

        inputUsername1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUsername1ActionPerformed(evt);
            }
        });

        labelUsername2.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelUsername2.setForeground(new java.awt.Color(254, 254, 254));
        labelUsername2.setText("Deskripsi Penyakit");

        labelUsername3.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        labelUsername3.setForeground(new java.awt.Color(254, 254, 254));
        labelUsername3.setText("Solusi Penyakit");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnCari1.setBackground(new java.awt.Color(254, 254, 254));
        btnCari1.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        btnCari1.setText("Edit");
        btnCari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCari1ActionPerformed(evt);
            }
        });

        btnCari2.setBackground(new java.awt.Color(254, 254, 254));
        btnCari2.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        btnCari2.setText("Hapus");
        btnCari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCari2ActionPerformed(evt);
            }
        });

        btnCari3.setBackground(new java.awt.Color(254, 254, 254));
        btnCari3.setFont(new java.awt.Font("Nunito", 0, 13)); // NOI18N
        btnCari3.setText("Clear");
        btnCari3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCari3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgRedLayout = new javax.swing.GroupLayout(bgRed);
        bgRed.setLayout(bgRedLayout);
        bgRedLayout.setHorizontalGroup(
            bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgRedLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgRedLayout.createSequentialGroup()
                        .addComponent(btnCari2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCari3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelUsername3)
                        .addComponent(labelUsername2)
                        .addComponent(labelUsername1)
                        .addComponent(labelUsername)
                        .addComponent(inputUsername)
                        .addComponent(labelLupaKataSandi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputUsername1)
                        .addComponent(jScrollPane2)
                        .addComponent(jScrollPane1)
                        .addGroup(bgRedLayout.createSequentialGroup()
                            .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCari1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        bgRedLayout.setVerticalGroup(
            bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgRedLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelLupaKataSandi)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(labelUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUsername1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUsername2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUsername3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(btnCari1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari2)
                    .addComponent(btnCari3))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout bgWhiteLayout = new javax.swing.GroupLayout(bgWhite);
        bgWhite.setLayout(bgWhiteLayout);
        bgWhiteLayout.setHorizontalGroup(
            bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgWhiteLayout.createSequentialGroup()
                .addComponent(bgRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(476, Short.MAX_VALUE))
        );
        bgWhiteLayout.setVerticalGroup(
            bgWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgWhite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputUsername1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUsername1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputUsername1ActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnCari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCari1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCari1ActionPerformed

    private void btnCari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCari2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCari2ActionPerformed

    private void btnCari3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCari3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCari3ActionPerformed

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
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCari1;
    private javax.swing.JButton btnCari2;
    private javax.swing.JButton btnCari3;
    private javax.swing.JTextField inputUsername;
    private javax.swing.JTextField inputUsername1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel labelLupaKataSandi;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JLabel labelUsername1;
    private javax.swing.JLabel labelUsername2;
    private javax.swing.JLabel labelUsername3;
    // End of variables declaration//GEN-END:variables
}
