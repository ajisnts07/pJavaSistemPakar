/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sikar.view;

import javax.swing.JOptionPane;

/**
 *
 * @author admin01
 */
public class DiagnosaFrame extends javax.swing.JFrame {

    /**
     * Creates new form DiagnosaFrame
     */
    public DiagnosaFrame() {
        initComponents();
    }

    void penyakitPage() {
        new PenyakitFrame().setVisible(true);
        dispose();
    }

    void checkDiagnosa() {
        if (radioLemas.isSelected()&&radioDemam.isSelected()&&radioMual.isSelected()) {
            JOptionPane.showMessageDialog(null, "[P01] Hepatitis B", "Hasil Diagnosa", JOptionPane.INFORMATION_MESSAGE);
            penyakitPage();
        } else if (radioLemas.isSelected()&&radioSesak.isSelected()&&radioPucat.isSelected()) {
            JOptionPane.showMessageDialog(null, "[P02] Anemia", "Hasil Diagnosa", JOptionPane.INFORMATION_MESSAGE);
            penyakitPage();
        } else if (radioLemas.isSelected()&&radioBuram.isSelected()&&radioKering.isSelected()) {
            JOptionPane.showMessageDialog(null, "[P03] Diabetes Gestasional", "Hasil Diagnosa", JOptionPane.INFORMATION_MESSAGE);
            penyakitPage();
        } else {
            JOptionPane.showMessageDialog(null, "Penyakit dengan gejala tersebut, tidak ditemukan!", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
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

        bgBlue = new javax.swing.JPanel();
        navbar = new javax.swing.JPanel();
        Aturan = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        DataPenyakitBox = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        radioLemas = new javax.swing.JRadioButton();
        radioPucat = new javax.swing.JRadioButton();
        radioDemam = new javax.swing.JRadioButton();
        radioSesak = new javax.swing.JRadioButton();
        radioKering = new javax.swing.JRadioButton();
        radioMual = new javax.swing.JRadioButton();
        radioBuram = new javax.swing.JRadioButton();
        btnDiagnosa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgBlue.setBackground(new java.awt.Color(5, 101, 201));

        navbar.setBackground(new java.awt.Color(254, 254, 254));

        Aturan.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        Aturan.setText("Diagnosa");

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navbarLayout = new javax.swing.GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(Aturan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 447, Short.MAX_VALUE)
                .addComponent(btnKembali)
                .addGap(36, 36, 36))
        );
        navbarLayout.setVerticalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aturan)
                    .addComponent(btnKembali))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        DataPenyakitBox.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SILAKAN PILIH GEJALA YANG TERASA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        radioLemas.setText("Lemas / Lelah");
        radioLemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLemasActionPerformed(evt);
            }
        });

        radioPucat.setText("Kulit Pucat");

        radioDemam.setText("Demam");
        radioDemam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDemamActionPerformed(evt);
            }
        });

        radioSesak.setText("Sesak Nafas");

        radioKering.setText("Mulut Kering");
        radioKering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioKeringActionPerformed(evt);
            }
        });

        radioMual.setText("Mual/Muntah");
        radioMual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMualActionPerformed(evt);
            }
        });

        radioBuram.setText("Penglihatan Buram");

        btnDiagnosa.setBackground(new java.awt.Color(5, 101, 201));
        btnDiagnosa.setForeground(new java.awt.Color(254, 254, 254));
        btnDiagnosa.setText("Diagnosa");
        btnDiagnosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiagnosaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DataPenyakitBoxLayout = new javax.swing.GroupLayout(DataPenyakitBox);
        DataPenyakitBox.setLayout(DataPenyakitBoxLayout);
        DataPenyakitBoxLayout.setHorizontalGroup(
            DataPenyakitBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DataPenyakitBoxLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(btnDiagnosa, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(DataPenyakitBoxLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(DataPenyakitBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DataPenyakitBoxLayout.createSequentialGroup()
                        .addGroup(DataPenyakitBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioPucat)
                            .addComponent(radioLemas))
                        .addGap(33, 33, 33)
                        .addGroup(DataPenyakitBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioSesak)
                            .addComponent(radioMual))
                        .addGap(49, 49, 49)
                        .addGroup(DataPenyakitBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioDemam)
                            .addComponent(radioBuram)))
                    .addComponent(radioKering))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DataPenyakitBoxLayout.setVerticalGroup(
            DataPenyakitBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPenyakitBoxLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(DataPenyakitBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioLemas)
                    .addComponent(radioMual)
                    .addComponent(radioBuram))
                .addGap(18, 18, 18)
                .addGroup(DataPenyakitBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioPucat)
                    .addComponent(radioSesak)
                    .addComponent(radioDemam))
                .addGap(18, 18, 18)
                .addComponent(radioKering)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(btnDiagnosa, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        javax.swing.GroupLayout bgBlueLayout = new javax.swing.GroupLayout(bgBlue);
        bgBlue.setLayout(bgBlueLayout);
        bgBlueLayout.setHorizontalGroup(
            bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBlueLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(DataPenyakitBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        bgBlueLayout.setVerticalGroup(
            bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgBlueLayout.createSequentialGroup()
                .addComponent(navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(DataPenyakitBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        this.dispose();
        UserFrame f = new UserFrame();
        f.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnDiagnosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiagnosaActionPerformed
        // TODO add your handling code here:
        checkDiagnosa();
    }//GEN-LAST:event_btnDiagnosaActionPerformed

    private void radioMualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioMualActionPerformed

    private void radioKeringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioKeringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioKeringActionPerformed

    private void radioLemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLemasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioLemasActionPerformed

    private void radioDemamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDemamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDemamActionPerformed

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
            java.util.logging.Logger.getLogger(DiagnosaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagnosaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagnosaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagnosaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiagnosaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Aturan;
    private javax.swing.JPanel DataPenyakitBox;
    private javax.swing.JPanel bgBlue;
    private javax.swing.JButton btnDiagnosa;
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel navbar;
    private javax.swing.JRadioButton radioBuram;
    private javax.swing.JRadioButton radioDemam;
    private javax.swing.JRadioButton radioKering;
    private javax.swing.JRadioButton radioLemas;
    private javax.swing.JRadioButton radioMual;
    private javax.swing.JRadioButton radioPucat;
    private javax.swing.JRadioButton radioSesak;
    // End of variables declaration//GEN-END:variables
}
