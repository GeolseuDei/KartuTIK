/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartu.tik;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author GeolseuDei
 */
public class Kegiatan extends javax.swing.JFrame {

    /**
     * Creates new form Kegiatan
     */
    public Kegiatan() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
        initComponents();
        setResizable(false);
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chkToday = new javax.swing.JCheckBox();
        txtNama = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtNoInduk = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        txtKegiatan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbTanggal = new javax.swing.JComboBox<>();
        cmbBulan = new javax.swing.JComboBox<>();
        cmbTahun = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chkToday.setText("Gunakan tanggal hari ini");
        chkToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTodayActionPerformed(evt);
            }
        });

        txtNama.setText("Masukkan No KTP.");

        jLabel1.setText("No. KTP :");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel2.setText("Kegiatan :");

        btnBack.setText("Kembali");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtNoInduk.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtNoIndukInputMethodTextChanged(evt);
            }
        });
        txtNoInduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoIndukActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama :");

        jLabel4.setText("Tanggal :");

        cmbTanggal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cmbTahun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017", "2018", "2019", "2020" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chkToday))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(448, 448, 448)
                            .addComponent(btnBack)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNoInduk, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCari)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNama))
                            .addComponent(txtKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNoInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama)
                    .addComponent(btnCari))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkToday))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnBack))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTodayActionPerformed
        if (chkToday.isSelected()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date d = new Date();
            String tanggalhariini = sdf.format(d);
            String hari = tanggalhariini.substring(0, 2);
            String bulan = tanggalhariini.substring(3, 5);
            String tahun = tanggalhariini.substring(6, 10);
            cmbTanggal.setEditable(true);
            cmbBulan.setEditable(true);
            cmbTahun.setEditable(true);
            cmbTanggal.getEditor().setItem(hari);
            cmbBulan.getEditor().setItem(bulan);
            cmbTahun.getEditor().setItem(tahun);
            cmbTanggal.setEnabled(false);
            cmbBulan.setEnabled(false);
            cmbTahun.setEnabled(false);
        } else {
            cmbTanggal.setEnabled(true);
            cmbBulan.setEnabled(true);
            cmbTahun.setEnabled(true);
            cmbTanggal.setEditable(false);
            cmbBulan.setEditable(false);
            cmbTahun.setEditable(false);
        }
    }//GEN-LAST:event_chkTodayActionPerformed
    boolean ditekan = false;
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        /*ProgramPendataan pp = new ProgramPendataan();
        String noinduk = txtNoInduk.getText();
        String nama = txtNama.getText();
        String kegiatan = txtKegiatan.getText();
        String tanggal = "";
        if (chkToday.isSelected()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date d = new Date();
            String tanggalhariini = sdf.format(d);
            String hari = tanggalhariini.substring(0, 2);
            String bulan = tanggalhariini.substring(3, 5);
            String tahun = tanggalhariini.substring(6, 10);
            tanggal = hari + "-" + bulan + "-" + tahun;
        } else {
            tanggal = cmbTanggal.getSelectedItem() + "-" + cmbBulan.getSelectedItem() + "-" + cmbTahun.getSelectedItem();
        }
        if (!txtNoInduk.getText().isEmpty()) {
            if (!txtKegiatan.getText().isEmpty()) {
                int reply = JOptionPane.showConfirmDialog(this, "No Induk : " + noinduk + " , " + nama + "\nKegiatan : " + kegiatan + "\nTanggal : " + tanggal, "Anda yakin?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    if (pp.InsertKegiatan(noinduk, kegiatan, tanggal)) {
                        JOptionPane.showMessageDialog(this, "Sukses");
                        txtNoInduk.setText("");
                        txtNama.setText("Masukkan No KTP.");
                        txtKegiatan.setText("");
                        txtNoInduk.setEnabled(true);
                        btnCari.setText("Cari");
                        ditekan = false;
                    } else {
                        JOptionPane.showMessageDialog(this, "Gagal");
                    }
                } else {

                }
            } else {
                JOptionPane.showMessageDialog(this, "Masukkan kegiatan yang dilakukan.", "Peringatan", JOptionPane.OK_OPTION);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Masukkan no induk.", "Peringatan", JOptionPane.OK_OPTION);
        }*/
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        KartuTIK k = new KartuTIK();
        if (!txtNoInduk.getText().isEmpty() || !txtKegiatan.getText().isEmpty()) {
            int reply = JOptionPane.showConfirmDialog(this, "Apa anda yakin untuk membatalkan?", "Peringatan", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                if (k.tipeUser.equalsIgnoreCase("1")) {
                    MenuAdmin f = new MenuAdmin();
                    f.setVisible(true);
                    this.dispose();
                } else {
                    
                }
            } else {

            }
        } else {
            if (k.tipeUser.equalsIgnoreCase("1")) {
                MenuAdmin f = new MenuAdmin();
                    f.setVisible(true);
                    this.dispose();
            } else {
                
            }
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtNoIndukInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtNoIndukInputMethodTextChanged

    }//GEN-LAST:event_txtNoIndukInputMethodTextChanged

    private void txtNoIndukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoIndukActionPerformed
        btnCariActionPerformed(evt);
    }//GEN-LAST:event_txtNoIndukActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        /*ProgramPendataan pp = new ProgramPendataan();
        if (!ditekan) {
            if (!txtNoInduk.getText().isEmpty()) {
                String noinduk = txtNoInduk.getText();
                if (txtNoInduk.getText().isEmpty()) {
                    txtNama.setText("Masukkan No Induk.");
                } else {
                    String data = pp.AmbilDataHakAkses(noinduk);
                    if (!data.equalsIgnoreCase("")) {
                        String[] partData = data.split(",");
                        String nama = partData[0];
                        txtNama.setText(nama);
                        ditekan = true;
                        btnCari.setText("Ganti?");
                        txtNoInduk.setEnabled(false);
                    } else {
                        JOptionPane.showConfirmDialog(this, "No induk salah / tidak ada.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Masukkan No Induk.");
            }
        } else {
            txtNoInduk.setEnabled(true);
            btnCari.setText("Cari");
            ditekan = false;
        }*/
    }//GEN-LAST:event_btnCariActionPerformed

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
            java.util.logging.Logger.getLogger(Kegiatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kegiatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kegiatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kegiatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kegiatan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JCheckBox chkToday;
    private javax.swing.JComboBox<String> cmbBulan;
    private javax.swing.JComboBox<String> cmbTahun;
    private javax.swing.JComboBox<String> cmbTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtKegiatan;
    private javax.swing.JLabel txtNama;
    private javax.swing.JTextField txtNoInduk;
    // End of variables declaration//GEN-END:variables
}