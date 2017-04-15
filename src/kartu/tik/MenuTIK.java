/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartu.tik;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GeolseuDei
 */
public class MenuTIK extends javax.swing.JFrame {

    /**
     * Creates new form MenuTIK
     */
    public MenuTIK() {
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

        LoadTabelDataTIK();
    }

    private void LoadTabelDataTIK() {
        KartuTIK k = new KartuTIK();
        ArrayList<DataTIK> list = new ArrayList<>(k.AmbilDataTabelTIK(k.divisi));
        DefaultTableModel model = (DefaultTableModel) tabelTIK.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getNamalengkap();
            rowData[1] = list.get(i).getAlias();
            rowData[2] = list.get(i).getTglnoktp();
            rowData[3] = list.get(i).getAgama();
            rowData[4] = list.get(i).getTgllahir();
            rowData[5] = list.get(i).getTempatlahir();
            model.addRow(rowData);
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

        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelTIK = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        btnTambah.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnTambah.setText("Tambah Data");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnUbah.setText("Ubah Data");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnHapus.setText("Hapus Data");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnRefresh.setText("Perbarui Data");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tabelTIK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Erwin Kurniawan Adidharma", "Erwin", "3578241911950001", "Konghucu", "11-11-1111", null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Lengkap", "Alias", "No. KTP", "Agama", "Tgl. Lahir", "Tempat Lahir"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelTIK);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKeluar)
                    .addComponent(btnRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        KartuTIK k = new KartuTIK();
        if (k.tipeUser.equalsIgnoreCase("1")) {
            MenuAdmin m = new MenuAdmin();
            m.setVisible(true);
            this.dispose();
        } else {
            MenuMember m = new MenuMember();
            m.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnKeluarActionPerformed

    public static int tambahUbah = 0; // 1 = insert , 2 = update , 3 = liat data full dari form Pencarian

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        tambahUbah = 1;
        TambahUbahTIK t = new TambahUbahTIK();
        t.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTambahActionPerformed
    public static String namalengkap = "";
    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        KartuTIK k = new KartuTIK();
        if (k.tipeUser.equalsIgnoreCase("1") || k.hakAksesUser.equalsIgnoreCase("1")) {
            tambahUbah = 2;
            int row = tabelTIK.getSelectedRow();
            if (row >= 0) {
                namalengkap = tabelTIK.getValueAt(row, 0).toString();
                TambahUbahTIK t = new TambahUbahTIK();
                t.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris pada tabel yang ingin di ubah.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hanya admin / member dengan hak akses spesial yang dapat menggunakan fitur ubah data.");
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        KartuTIK k = new KartuTIK();
        if (k.tipeUser.equalsIgnoreCase("1") || k.hakAksesUser.equalsIgnoreCase("1")) {
            int row = tabelTIK.getSelectedRow();
            if (row >= 0) {
                String namaLengkap = tabelTIK.getValueAt(row, 0).toString();
                int val = JOptionPane.showConfirmDialog(this, "Apa anda yakin akan menghapus data milik " + namaLengkap + " ?", "Peringatan!", JOptionPane.YES_NO_OPTION);
                if (val == JOptionPane.YES_OPTION) {
                    if (k.DeleteDataTIK(namaLengkap, k.divisi)) {
                        JOptionPane.showMessageDialog(this, "Data milik " + namaLengkap + " berhasil di hapus.");
                        LoadTabelDataTIK();
                    } else {
                        JOptionPane.showMessageDialog(this, "Penghapusan data gagal.");
                    }
                } else {
                    //delete canceled
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris pada tabel yang ingin di ubah.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hanya admin / member dengan hak akses spesial yang dapat menggunakan fitur ubah data.");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        LoadTabelDataTIK();
    }//GEN-LAST:event_btnRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(MenuTIK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuTIK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuTIK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuTIK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuTIK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelTIK;
    // End of variables declaration//GEN-END:variables
}
