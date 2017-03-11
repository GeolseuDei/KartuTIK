/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartu.tik;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GeolseuDei
 */
public class MenuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form MenuAdmin
     */
    Timer t, t2;

    public MenuAdmin() {
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

        KartuTIK k = new KartuTIK();
        lblNama.setText(k.namaUser);

        ActionListener updateClockAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                Date d = new Date();
                lblJam.setText(sdf.format(d));
            }
        };
        t = new Timer(100, updateClockAction);
        t.start();

        ActionListener updateTabelAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addRowToTable();
            }
        };
        t2 = new Timer(100, updateTabelAction);
        t2.start();
    }

    public void addRowToTable() {
        KartuTIK k = new KartuTIK();
        ArrayList<classLog> list = new ArrayList<>(k.AmbilDataLogMenuAdmin());
        DefaultTableModel model = (DefaultTableModel) tabelLog.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getNama();
            rowData[1] = list.get(i).getEvent();
            rowData[2] = list.get(i).getWaktu();
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

        jLabel1 = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblJam = new javax.swing.JLabel();
        btnTIK = new javax.swing.JButton();
        btnPencarian = new javax.swing.JButton();
        btnKegiatan = new javax.swing.JButton();
        btnLog = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelLog = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Selamat Datang,");

        lblNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNama.setText("ini nama");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Jam :");

        lblJam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblJam.setText("00:00:00");

        btnTIK.setText("Data TIK");
        btnTIK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTIK.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTIKActionPerformed(evt);
            }
        });

        btnPencarian.setText("Pencarian");
        btnPencarian.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPencarian.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPencarianActionPerformed(evt);
            }
        });

        btnKegiatan.setText("Kegiatan");
        btnKegiatan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKegiatan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKegiatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKegiatanActionPerformed(evt);
            }
        });

        btnLog.setText("Riwayat Sistem");
        btnLog.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLog.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKeluar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        tabelLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "31-12-2000 00:00:00"},
                {null, null, null},
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
                "Nama Pengguna", "Kegiatan", "Waktu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelLog);
        if (tabelLog.getColumnModel().getColumnCount() > 0) {
            tabelLog.getColumnModel().getColumn(0).setMinWidth(150);
            tabelLog.getColumnModel().getColumn(0).setMaxWidth(150);
            tabelLog.getColumnModel().getColumn(2).setMinWidth(110);
            tabelLog.getColumnModel().getColumn(2).setMaxWidth(110);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(lblNama)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblJam))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTIK, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLog, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(btnPencarian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblNama)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lblJam)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTIK, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnKegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLog, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTIKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTIKActionPerformed
        t.stop();
        t2.stop();
        MenuTIK m = new MenuTIK();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTIKActionPerformed

    private void btnKegiatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKegiatanActionPerformed
        t.stop();
        t2.stop();
        Kegiatan k = new Kegiatan();
        k.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKegiatanActionPerformed

    private void btnPencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPencarianActionPerformed
        t.stop();
        t2.stop();
        Pencarian p = new Pencarian();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPencarianActionPerformed

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        t.stop();
        t2.stop();
        Log l = new Log();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        t.stop();
        t2.stop();
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKegiatan;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnPencarian;
    private javax.swing.JButton btnTIK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJam;
    private javax.swing.JLabel lblNama;
    private javax.swing.JTable tabelLog;
    // End of variables declaration//GEN-END:variables
}
