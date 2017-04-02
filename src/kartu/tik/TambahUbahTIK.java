/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartu.tik;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.coobird.thumbnailator.Thumbnails;

/**
 *
 * @author GeolseuDei
 */
public class TambahUbahTIK extends javax.swing.JFrame {

    /**
     * Creates new form TambahUbahTIK
     */
    KartuTIK d;

    public TambahUbahTIK() {
        d = new KartuTIK();
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

        ComboBoxTanggalBulanTahun();

        if (MenuTIK.tambahUbah == 1) {
            btnSimpanUbah.setText("Simpan");
        } else if (MenuTIK.tambahUbah == 2) {
            btnSimpanUbah.setText("Ubah");
            PengisianDataLengkapUbah();
        } else if (MenuTIK.tambahUbah == 3) {
            btnFoto.setVisible(false);
            btnSimpanUbah.setText("Print");
            PengisianDataLengkapCari();
            txtFieldEnabled(false);
        }

        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
    }

    public void ComboBoxTanggalBulanTahun() {
        for (int i = 1; i < 32; i++) {
            cmbTanggal.addItem(String.valueOf(i));
        }
        for (int i = 1; i < 13; i++) {
            cmbBulan.addItem(String.valueOf(i));
        }
        for (int i = 1945; i < 2018; i++) {
            cmbTahun.addItem(String.valueOf(i));
        }
    }

    public static String id = "";

    public void PengisianDataLengkapUbah() {
        KartuTIK k = new KartuTIK();
        k.AmbilDataLengkapByNamaLengkap(MenuTIK.namalengkap);

        id = k.d.getId();
        txtNamaLengkap.setText(k.d.getNamalengkap());
        txtAlias.setText(k.d.getAlias());
        txtKTP.setText(k.d.getTglnoktp());
        txtPasport.setText(k.d.getTglnopasport());
        txtAgama.setText(k.d.getAgama());
        String data[] = k.d.getTgllahir().split("-");
        String tanggal = data[0];
        String bulan = data[1];
        String tahun = data[2];
        cmbTanggal.setEditable(true);
        cmbBulan.setEditable(true);
        cmbTahun.setEditable(true);
        cmbTanggal.getEditor().setItem(tanggal);
        cmbBulan.getEditor().setItem(bulan);
        cmbTahun.getEditor().setItem(tahun);
        cmbTanggal.setPreferredSize(new Dimension(35, cmbTanggal.getPreferredSize().height));
        cmbBulan.setPreferredSize(new Dimension(35, cmbBulan.getPreferredSize().height));
        cmbTahun.setPreferredSize(new Dimension(55, cmbTahun.getPreferredSize().height));
        txtUmur.setText(k.d.getUmur());
        txtTempatLahir.setText(k.d.getTempatlahir());
        if (KartuTIK.tipeUser.equalsIgnoreCase("1") || KartuTIK.hakAksesUser.equalsIgnoreCase("1")) {
            //kebuka semua
        } else if (KartuTIK.tipeUser.equalsIgnoreCase("0")) {
            if (!k.d.getAlamat().isEmpty()) {
                txtAlamat.setEnabled(false);
            }
            if (!k.d.getPerubahanalamat1().isEmpty()) {
                txtPerubahanAlamat1.setEnabled(false);
            }
            if (!k.d.getPerubahanalamat2().isEmpty()) {
                txtPerubahanAlamat2.setEnabled(false);
            }
            if (!k.d.getPerubahanalamat3().isEmpty()) {
                txtPerubahanAlamat3.setEnabled(false);
            }
        }
        txtAlamat.setText(k.d.getAlamat());
        txtPerubahanAlamat1.setText(k.d.getPerubahanalamat1());
        txtPerubahanAlamat2.setText(k.d.getPerubahanalamat2());
        txtPerubahanAlamat3.setText(k.d.getPerubahanalamat3());
        txtKedudukan.setText(k.d.getKedudukan());
        txtNamaBapak.setText(k.d.getNamabapak());
        txtNamaIbu.setText(k.d.getNamaibu());
        txtAlamatOrangTua.setText(k.d.getAlamatorgtua());
        txtPekerjaan.setText(k.d.getPekerjaan());
        txtJabatan.setText(k.d.getJabatan());
        txtInstansi.setText(k.d.getInstansilembagakantor());
        txtNamaIstri.setText(k.d.getNamaistri());
        txtUmurIstri.setText(k.d.getUmuristri());
        txtPekerjaanIstri.setText(k.d.getPekerjaanistri());
        txtNamaBapakIstri.setText(k.d.getNamabapakistri());
        txtUmurBapakIstri.setText(k.d.getUmurbapakistri());
        txtPekerjaanBapakIstri.setText(k.d.getPekerjaanbapakistri());
        txtNamaIbuIstri.setText(k.d.getNamaibuistri());
        txtUmurIbuIstri.setText(k.d.getUmuribuistri());
        txtPekerjaanIbuIstri.setText(k.d.getPekerjaanibuistri());
        txtAlamatOrangTuaIstri.setText(k.d.getAlamatorgtuaistri());
        txtTanggungan.setText(k.d.getTanggungan());
        txtAlamatTanggungan.setText(k.d.getAlamattanggungan());
        txtRambut.setText(k.d.getRambut());
        txtMuka.setText(k.d.getMuka());
        txtKulit.setText(k.d.getKulit());
        txtTinggi.setText(k.d.getTinggi());
        txtTandaIstimewa.setText(k.d.getTandaistimewa());
        txtRumusSidikJari.setText(k.d.getRumussidikjari());
        txtNamaAnak1.setText(k.d.getNamaanak1());
        txtNamaAnak2.setText(k.d.getNamaanak2());
        txtNamaAnak3.setText(k.d.getNamaanak3());
        txtNamaAnak4.setText(k.d.getNamaanak4());
        txtNamaAnak5.setText(k.d.getNamaanak5());
        txtNamaAnak6.setText(k.d.getNamaanak6());
        txtUmurAnak1.setText(k.d.getUmuranak1());
        txtUmurAnak2.setText(k.d.getUmuranak2());
        txtUmurAnak3.setText(k.d.getUmuranak3());
        txtUmurAnak4.setText(k.d.getUmuranak4());
        txtUmurAnak5.setText(k.d.getUmuranak5());
        txtUmurAnak6.setText(k.d.getUmuranak6());
        txtPekerjaanAnak1.setText(k.d.getPekerjaananak1());
        txtPekerjaanAnak2.setText(k.d.getPekerjaananak2());
        txtPekerjaanAnak3.setText(k.d.getPekerjaananak3());
        txtPekerjaanAnak4.setText(k.d.getPekerjaananak4());
        txtPekerjaanAnak5.setText(k.d.getPekerjaananak5());
        txtPekerjaanAnak6.setText(k.d.getPekerjaananak6());
        txtNamaSekolah1.setText(k.d.getNamasekolah1());
        txtNamaSekolah2.setText(k.d.getNamasekolah2());
        txtNamaSekolah3.setText(k.d.getNamasekolah3());
        txtNamaSekolah4.setText(k.d.getNamasekolah4());
        txtNamaSekolah5.setText(k.d.getNamasekolah5());
        txtNamaSekolah6.setText(k.d.getNamasekolah6());
        txtTahunLulusSekolah1.setText(k.d.getTahunlulussekolah1());
        txtTahunLulusSekolah2.setText(k.d.getTahunlulussekolah2());
        txtTahunLulusSekolah3.setText(k.d.getTahunlulussekolah3());
        txtTahunLulusSekolah4.setText(k.d.getTahunlulussekolah4());
        txtTahunLulusSekolah5.setText(k.d.getTahunlulussekolah5());
        txtTahunLulusSekolah6.setText(k.d.getTahunlulussekolah6());
        txtKesenanganKegemaranHobi.setText(k.d.getHobi());
        txtKriminal1.setText(k.d.getCatatankriminal1());
        txtKriminal2.setText(k.d.getCatatankriminal2());
        txtKriminal3.setText(k.d.getCatatankriminal3());
        if (k.d.getUrlfoto().isEmpty() || k.d.getUrlfoto().equalsIgnoreCase("")) {
            lblFoto.setText("Tidak ada foto");
        } else {
            if (k.AmbilFotoTIKbyID(k.d.getId())) {
                ImageIcon ii = new ImageIcon(k.d.getUrlfoto());
                lblFoto.setIcon(ii);
                lblFoto.setText("");
            } else {
                System.out.println(k.d.getUrlfoto());
                JOptionPane.showMessageDialog(this, "Foto tidak termuat / tidak ada, Ulangi kembali. Jika belum upload, mohon upload foto");
            }
        }

    }

    public void PengisianDataLengkapCari() {
        KartuTIK k = new KartuTIK();
        k.AmbilDataLengkapByKTP(Pencarian.ktp);

        //id = k.d.getId();
        txtNamaLengkap.setText(k.d.getNamalengkap());
        txtAlias.setText(k.d.getAlias());
        txtKTP.setText(k.d.getTglnoktp());
        txtPasport.setText(k.d.getTglnopasport());
        txtAgama.setText(k.d.getAgama());
        String data[] = k.d.getTgllahir().split("-");
        String tanggal = data[0];
        String bulan = data[1];
        String tahun = data[2];
        cmbTanggal.setEditable(true);
        cmbBulan.setEditable(true);
        cmbTahun.setEditable(true);
        cmbTanggal.getEditor().setItem(tanggal);
        cmbBulan.getEditor().setItem(bulan);
        cmbTahun.getEditor().setItem(tahun);
        cmbTanggal.setPreferredSize(new Dimension(35, cmbTanggal.getPreferredSize().height));
        cmbBulan.setPreferredSize(new Dimension(35, cmbBulan.getPreferredSize().height));
        cmbTahun.setPreferredSize(new Dimension(55, cmbTahun.getPreferredSize().height));
        txtUmur.setText(k.d.getUmur());
        txtTempatLahir.setText(k.d.getTempatlahir());
        if (KartuTIK.tipeUser.equalsIgnoreCase("1") || KartuTIK.hakAksesUser.equalsIgnoreCase("1")) {
            //kebuka semua
        } else if (KartuTIK.tipeUser.equalsIgnoreCase("0")) {
            if (!k.d.getAlamat().isEmpty()) {
                txtAlamat.setEnabled(false);
            }
            if (!k.d.getPerubahanalamat1().isEmpty()) {
                txtPerubahanAlamat1.setEnabled(false);
            }
            if (!k.d.getPerubahanalamat2().isEmpty()) {
                txtPerubahanAlamat2.setEnabled(false);
            }
            if (!k.d.getPerubahanalamat3().isEmpty()) {
                txtPerubahanAlamat3.setEnabled(false);
            }
        }
        txtAlamat.setText(k.d.getAlamat());
        txtPerubahanAlamat1.setText(k.d.getPerubahanalamat1());
        txtPerubahanAlamat2.setText(k.d.getPerubahanalamat2());
        txtPerubahanAlamat3.setText(k.d.getPerubahanalamat3());
        txtKedudukan.setText(k.d.getKedudukan());
        txtNamaBapak.setText(k.d.getNamabapak());
        txtNamaIbu.setText(k.d.getNamaibu());
        txtPekerjaan.setText(k.d.getPekerjaan());
        txtJabatan.setText(k.d.getJabatan());
        txtInstansi.setText(k.d.getInstansilembagakantor());
        txtNamaIstri.setText(k.d.getNamaistri());
        txtUmurIstri.setText(k.d.getUmuristri());
        txtPekerjaanIstri.setText(k.d.getPekerjaanistri());
        txtNamaBapakIstri.setText(k.d.getNamabapakistri());
        txtUmurBapakIstri.setText(k.d.getUmurbapakistri());
        txtPekerjaanBapakIstri.setText(k.d.getPekerjaanbapakistri());
        txtNamaIbuIstri.setText(k.d.getNamaibuistri());
        txtUmurIbuIstri.setText(k.d.getUmuribuistri());
        txtPekerjaanIbuIstri.setText(k.d.getPekerjaanibuistri());
        txtAlamatOrangTuaIstri.setText(k.d.getAlamatorgtuaistri());
        txtTanggungan.setText(k.d.getTanggungan());
        txtAlamatTanggungan.setText(k.d.getAlamattanggungan());
        txtRambut.setText(k.d.getRambut());
        txtMuka.setText(k.d.getMuka());
        txtKulit.setText(k.d.getKulit());
        txtTinggi.setText(k.d.getTinggi());
        txtTandaIstimewa.setText(k.d.getTandaistimewa());
        txtRumusSidikJari.setText(k.d.getRumussidikjari());
        txtNamaAnak1.setText(k.d.getNamaanak1());
        txtNamaAnak2.setText(k.d.getNamaanak2());
        txtNamaAnak3.setText(k.d.getNamaanak3());
        txtNamaAnak4.setText(k.d.getNamaanak4());
        txtNamaAnak5.setText(k.d.getNamaanak5());
        txtNamaAnak6.setText(k.d.getNamaanak6());
        txtUmurAnak1.setText(k.d.getUmuranak1());
        txtUmurAnak2.setText(k.d.getUmuranak2());
        txtUmurAnak3.setText(k.d.getUmuranak3());
        txtUmurAnak4.setText(k.d.getUmuranak4());
        txtUmurAnak5.setText(k.d.getUmuranak5());
        txtUmurAnak6.setText(k.d.getUmuranak6());
        txtPekerjaanAnak1.setText(k.d.getPekerjaananak1());
        txtPekerjaanAnak2.setText(k.d.getPekerjaananak2());
        txtPekerjaanAnak3.setText(k.d.getPekerjaananak3());
        txtPekerjaanAnak4.setText(k.d.getPekerjaananak4());
        txtPekerjaanAnak5.setText(k.d.getPekerjaananak5());
        txtPekerjaanAnak6.setText(k.d.getPekerjaananak6());
        txtNamaSekolah1.setText(k.d.getNamasekolah1());
        txtNamaSekolah2.setText(k.d.getNamasekolah2());
        txtNamaSekolah3.setText(k.d.getNamasekolah3());
        txtNamaSekolah4.setText(k.d.getNamasekolah4());
        txtNamaSekolah5.setText(k.d.getNamasekolah5());
        txtNamaSekolah6.setText(k.d.getNamasekolah6());
        txtTahunLulusSekolah1.setText(k.d.getTahunlulussekolah1());
        txtTahunLulusSekolah2.setText(k.d.getTahunlulussekolah2());
        txtTahunLulusSekolah3.setText(k.d.getTahunlulussekolah3());
        txtTahunLulusSekolah4.setText(k.d.getTahunlulussekolah4());
        txtTahunLulusSekolah5.setText(k.d.getTahunlulussekolah5());
        txtTahunLulusSekolah6.setText(k.d.getTahunlulussekolah6());
        txtKesenanganKegemaranHobi.setText(k.d.getHobi());
        txtKriminal1.setText(k.d.getCatatankriminal1());
        txtKriminal2.setText(k.d.getCatatankriminal2());
        txtKriminal3.setText(k.d.getCatatankriminal3());
        ImageIcon ii = new ImageIcon(Pencarian.urlfoto);
        lblFoto.setIcon(ii);
        lblFoto.setText("");
    }

    public void txtFieldEnabled(boolean trufal) {
        txtNamaLengkap.setEnabled(trufal);
        txtAlias.setEnabled(trufal);
        txtKTP.setEnabled(trufal);
        txtPasport.setEnabled(trufal);
        txtAgama.setEnabled(trufal);
        cmbTanggal.setEnabled(trufal);
        cmbBulan.setEnabled(trufal);
        cmbTahun.setEnabled(trufal);
        txtUmur.setEnabled(trufal);
        txtTempatLahir.setEnabled(trufal);
        txtAlamat.setEnabled(trufal);
        txtPerubahanAlamat1.setEnabled(trufal);
        txtPerubahanAlamat2.setEnabled(trufal);
        txtPerubahanAlamat3.setEnabled(trufal);
        txtKedudukan.setEnabled(trufal);
        txtNamaBapak.setEnabled(trufal);
        txtNamaIbu.setEnabled(trufal);
        txtAlamatOrangTua.setEnabled(trufal);
        txtPekerjaan.setEnabled(trufal);
        txtJabatan.setEnabled(trufal);
        txtInstansi.setEnabled(trufal);
        txtNamaIstri.setEnabled(trufal);
        txtUmurIstri.setEnabled(trufal);
        txtPekerjaanIstri.setEnabled(trufal);
        txtNamaBapakIstri.setEnabled(trufal);
        txtUmurBapakIstri.setEnabled(trufal);
        txtPekerjaanBapakIstri.setEnabled(trufal);
        txtNamaIbuIstri.setEnabled(trufal);
        txtUmurIbuIstri.setEnabled(trufal);
        txtPekerjaanIbuIstri.setEnabled(trufal);
        txtAlamatOrangTuaIstri.setEnabled(trufal);
        txtTanggungan.setEnabled(trufal);
        txtAlamatTanggungan.setEnabled(trufal);
        txtRambut.setEnabled(trufal);
        txtMuka.setEnabled(trufal);
        txtKulit.setEnabled(trufal);
        txtTinggi.setEnabled(trufal);
        txtTandaIstimewa.setEnabled(trufal);
        txtRumusSidikJari.setEnabled(trufal);
        txtNamaAnak1.setEnabled(trufal);
        txtNamaAnak2.setEnabled(trufal);
        txtNamaAnak3.setEnabled(trufal);
        txtNamaAnak4.setEnabled(trufal);
        txtNamaAnak5.setEnabled(trufal);
        txtNamaAnak6.setEnabled(trufal);
        txtUmurAnak1.setEnabled(trufal);
        txtUmurAnak2.setEnabled(trufal);
        txtUmurAnak3.setEnabled(trufal);
        txtUmurAnak4.setEnabled(trufal);
        txtUmurAnak5.setEnabled(trufal);
        txtUmurAnak6.setEnabled(trufal);
        txtPekerjaanAnak1.setEnabled(trufal);
        txtPekerjaanAnak2.setEnabled(trufal);
        txtPekerjaanAnak3.setEnabled(trufal);
        txtPekerjaanAnak4.setEnabled(trufal);
        txtPekerjaanAnak5.setEnabled(trufal);
        txtPekerjaanAnak6.setEnabled(trufal);
        txtNamaSekolah1.setEnabled(trufal);
        txtNamaSekolah2.setEnabled(trufal);
        txtNamaSekolah3.setEnabled(trufal);
        txtNamaSekolah4.setEnabled(trufal);
        txtNamaSekolah5.setEnabled(trufal);
        txtNamaSekolah6.setEnabled(trufal);
        txtTahunLulusSekolah1.setEnabled(trufal);
        txtTahunLulusSekolah2.setEnabled(trufal);
        txtTahunLulusSekolah3.setEnabled(trufal);
        txtTahunLulusSekolah4.setEnabled(trufal);
        txtTahunLulusSekolah5.setEnabled(trufal);
        txtTahunLulusSekolah6.setEnabled(trufal);
        txtKesenanganKegemaranHobi.setEnabled(trufal);
        txtKriminal1.setEnabled(trufal);
        txtKriminal2.setEnabled(trufal);
        txtKriminal3.setEnabled(trufal);
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
        jPanel1 = new javax.swing.JPanel();
        btnFoto = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNamaLengkap = new javax.swing.JTextField();
        txtAlias = new javax.swing.JTextField();
        txtPasport = new javax.swing.JTextField();
        txtKTP = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAgama = new javax.swing.JTextField();
        txtTempatLahir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUmur = new javax.swing.JTextField();
        cmbTanggal = new javax.swing.JComboBox<>();
        cmbBulan = new javax.swing.JComboBox<>();
        cmbTahun = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        txtPerubahanAlamat1 = new javax.swing.JTextField();
        txtPerubahanAlamat2 = new javax.swing.JTextField();
        txtPerubahanAlamat3 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtInstansi = new javax.swing.JTextField();
        txtPekerjaan = new javax.swing.JTextField();
        txtJabatan = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNamaIstri = new javax.swing.JTextField();
        txtNamaBapakIstri = new javax.swing.JTextField();
        txtNamaIbuIstri = new javax.swing.JTextField();
        txtAlamatOrangTuaIstri = new javax.swing.JTextField();
        txtUmurIstri = new javax.swing.JTextField();
        txtUmurBapakIstri = new javax.swing.JTextField();
        txtUmurIbuIstri = new javax.swing.JTextField();
        txtPekerjaanIstri = new javax.swing.JTextField();
        txtPekerjaanBapakIstri = new javax.swing.JTextField();
        txtPekerjaanIbuIstri = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtAlamatTanggungan = new javax.swing.JTextField();
        txtTanggungan = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtNamaAnak1 = new javax.swing.JTextField();
        txtNamaAnak2 = new javax.swing.JTextField();
        txtNamaAnak3 = new javax.swing.JTextField();
        txtNamaAnak4 = new javax.swing.JTextField();
        txtNamaAnak5 = new javax.swing.JTextField();
        txtNamaAnak6 = new javax.swing.JTextField();
        txtUmurAnak1 = new javax.swing.JTextField();
        txtUmurAnak2 = new javax.swing.JTextField();
        txtUmurAnak3 = new javax.swing.JTextField();
        txtUmurAnak4 = new javax.swing.JTextField();
        txtUmurAnak5 = new javax.swing.JTextField();
        txtUmurAnak6 = new javax.swing.JTextField();
        txtPekerjaanAnak1 = new javax.swing.JTextField();
        txtPekerjaanAnak2 = new javax.swing.JTextField();
        txtPekerjaanAnak3 = new javax.swing.JTextField();
        txtPekerjaanAnak4 = new javax.swing.JTextField();
        txtPekerjaanAnak5 = new javax.swing.JTextField();
        txtPekerjaanAnak6 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtRambut = new javax.swing.JTextField();
        txtTinggi = new javax.swing.JTextField();
        txtMuka = new javax.swing.JTextField();
        txtTandaIstimewa = new javax.swing.JTextField();
        txtKulit = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtRumusSidikJari = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtNamaSekolah1 = new javax.swing.JTextField();
        txtNamaSekolah2 = new javax.swing.JTextField();
        txtNamaSekolah3 = new javax.swing.JTextField();
        txtNamaSekolah4 = new javax.swing.JTextField();
        txtNamaSekolah5 = new javax.swing.JTextField();
        txtNamaSekolah6 = new javax.swing.JTextField();
        txtTahunLulusSekolah1 = new javax.swing.JTextField();
        txtTahunLulusSekolah2 = new javax.swing.JTextField();
        txtTahunLulusSekolah3 = new javax.swing.JTextField();
        txtTahunLulusSekolah4 = new javax.swing.JTextField();
        txtTahunLulusSekolah5 = new javax.swing.JTextField();
        txtTahunLulusSekolah6 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        txtKesenanganKegemaranHobi = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtKriminal1 = new javax.swing.JTextField();
        txtKriminal2 = new javax.swing.JTextField();
        txtKriminal3 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        txtKedudukan = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtNamaBapak = new javax.swing.JTextField();
        txtNamaIbu = new javax.swing.JTextField();
        txtAlamatOrangTua = new javax.swing.JTextField();
        btnSimpanUbah = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        btnFoto.setText("Pilih Foto");
        btnFoto.setEnabled(false);
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        lblFoto.setText("Foto");
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Nama Lengkap :");

        jLabel2.setText("Alias :");

        jLabel3.setText("No KTP :");

        jLabel4.setText("No Pasport :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamaLengkap, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKTP, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(txtPasport)
                            .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNamaLengkap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPasport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Agama :");

        jLabel6.setText("Tgl Lahir / Umur :");

        jLabel7.setText("Tempat lahir :");

        jLabel8.setText("/");

        cmbTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTahunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cmbTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTahun, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(txtUmur, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAgama, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAgama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(txtUmur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTahun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Alamat :");

        jLabel10.setText("Perubahan Alamat 1 :");

        jLabel11.setText("Perubahan Alamat 2 :");

        jLabel12.setText("Perubahan Alamat 3 :");

        txtPerubahanAlamat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerubahanAlamat2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(txtPerubahanAlamat1)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtPerubahanAlamat3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtPerubahanAlamat2)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPerubahanAlamat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtPerubahanAlamat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPerubahanAlamat3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setText("Pekerjaan :");

        jLabel14.setText("Jabatan : ");

        jLabel15.setText("Instansi / Lembaga / Kantor :");

        txtPekerjaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPekerjaanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPekerjaan, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInstansi)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(txtPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtInstansi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setText("Umur");

        jLabel17.setText("Pekerjaan");

        jLabel18.setText("Nama Istri :");

        jLabel19.setText("Nama Bapak Istri :");

        jLabel20.setText("Nama Ibu Istri :");

        jLabel21.setText("Alamat :");

        txtAlamatOrangTuaIstri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlamatOrangTuaIstriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(txtAlamatOrangTuaIstri))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(txtNamaIstri, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtNamaBapakIstri, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addGap(106, 106, 106)
                                    .addComponent(txtNamaIbuIstri, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUmurIbuIstri, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUmurBapakIstri, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUmurIstri, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPekerjaanBapakIstri)
                                    .addComponent(txtPekerjaanIbuIstri)
                                    .addComponent(txtPekerjaanIstri)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addGap(23, 23, 23)))))
                .addGap(27, 27, 27))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNamaIstri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUmurIstri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPekerjaanIstri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamaBapakIstri, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(txtPekerjaanBapakIstri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUmurBapakIstri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtNamaIbuIstri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUmurIbuIstri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPekerjaanIbuIstri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlamatOrangTuaIstri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setText("Sanak saudara yang menjadi");

        jLabel23.setText("Tanggungan :");

        jLabel24.setText("Alamat :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAlamatTanggungan)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtTanggungan, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 167, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTanggungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtAlamatTanggungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel25.setText("Nama Anak-anak :");

        jLabel26.setText("Umur");

        jLabel27.setText("Pekerjaan");

        jLabel28.setText("1.");

        jLabel29.setText("2.");

        jLabel30.setText("3.");

        jLabel31.setText("4.");

        jLabel32.setText("5.");

        jLabel33.setText("6.");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(txtNamaAnak2))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(txtNamaAnak3))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(txtNamaAnak4))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addComponent(txtNamaAnak5))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(txtNamaAnak6))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(txtNamaAnak1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(txtUmurAnak1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPekerjaanAnak1))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(txtUmurAnak2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPekerjaanAnak2))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(txtUmurAnak3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPekerjaanAnak3))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(txtUmurAnak4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPekerjaanAnak4))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(txtUmurAnak5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPekerjaanAnak5))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(txtUmurAnak6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPekerjaanAnak6))))
                .addGap(18, 18, 18))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtNamaAnak1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUmurAnak1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPekerjaanAnak1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtNamaAnak2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUmurAnak2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPekerjaanAnak2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtNamaAnak3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUmurAnak3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPekerjaanAnak3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtNamaAnak4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUmurAnak4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPekerjaanAnak4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtNamaAnak5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUmurAnak5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPekerjaanAnak5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtNamaAnak6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUmurAnak6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPekerjaanAnak6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel34.setText("1. Rambut :");

        jLabel35.setText("2. Muka :");

        jLabel36.setText("3. Kulit :");

        jLabel37.setText("4. Tinggi :");

        jLabel38.setText("5. Tanda istimewa :");

        txtMuka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMukaActionPerformed(evt);
            }
        });

        jLabel39.setText("Ciri-ciri Badan :");

        jLabel40.setText("Rumus Sidik Jari :");

        jLabel58.setText("cm");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRumusSidikJari))
                    .addComponent(jLabel39)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTinggi, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel58)
                                .addGap(12, 12, 12))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRambut, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTandaIstimewa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txtMuka, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKulit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(txtRambut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMuka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKulit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(txtTinggi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTandaIstimewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtRumusSidikJari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel41.setText("Riwayat Sekolah :");

        jLabel42.setText("Tahun Lulus");

        jLabel43.setText("1.");

        jLabel44.setText("2.");

        jLabel45.setText("3.");

        jLabel46.setText("4.");

        jLabel47.setText("5.");

        jLabel48.setText("6.");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNamaSekolah2))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNamaSekolah3))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNamaSekolah4))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNamaSekolah5))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNamaSekolah6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTahunLulusSekolah2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTahunLulusSekolah3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTahunLulusSekolah4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTahunLulusSekolah5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTahunLulusSekolah6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNamaSekolah1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTahunLulusSekolah1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtNamaSekolah1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTahunLulusSekolah1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtNamaSekolah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTahunLulusSekolah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtNamaSekolah3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTahunLulusSekolah3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtNamaSekolah4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTahunLulusSekolah4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txtNamaSekolah5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTahunLulusSekolah5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtNamaSekolah6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTahunLulusSekolah6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel49.setText("Kesenangan / Kegemaran / Hobi :");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtKesenanganKegemaranHobi)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtKesenanganKegemaranHobi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel50.setText("Catatan Kriminal yang ada :");

        jLabel51.setText("1.");

        jLabel52.setText("2.");

        jLabel53.setText("3.");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addGap(18, 18, 18)
                        .addComponent(txtKriminal1))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(18, 18, 18)
                        .addComponent(txtKriminal2))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(18, 18, 18)
                        .addComponent(txtKriminal3)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtKriminal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtKriminal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(txtKriminal3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel54.setText("Kedudukan dalam keluarga : ");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKedudukan)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtKedudukan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel55.setText("Nama Bapak :");

        jLabel56.setText("Nama Ibu :");

        jLabel57.setText("Alamat :");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel57)
                    .addComponent(jLabel55)
                    .addComponent(jLabel56))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlamatOrangTua)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaIbu, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(txtNamaBapak))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtNamaBapak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtNamaIbu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtAlamatOrangTua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(btnFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFoto)))
                        .addGap(14, 14, 14)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        btnSimpanUbah.setText("Simpan / Ubah / Print");
        btnSimpanUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanUbahActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSimpanUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanUbah)
                    .addComponent(btnKembali))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static String directoryFoto;

    private String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
    public static String extension;
    public static String nama;
    boolean insertDiTekan = false;
    boolean updateDiTekan = false;
    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        if (MenuTIK.tambahUbah == 1) {
            if (insertDiTekan) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    extension = getFileExtension(selectedFile);
                    nama = selectedFile.getName();//"uploadfoto." + extension;
                    try {
                        Thumbnails.of(new File(selectedFile.getAbsolutePath()))
                                .size(98, 135) // p , l
                                .toFile(new File(System.getProperty("user.dir") + "\\src\\foto\\" + nama));
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(this, e);
                    }
                    ImageIcon ii = new ImageIcon(System.getProperty("user.dir") + "\\src\\foto\\" + nama);
                    lblFoto.setIcon(ii);
                    lblFoto.setText("");
                    directoryFoto = System.getProperty("user.dir") + "\\src\\foto\\" + nama;
                    KartuTIK d = new KartuTIK();
                    if (d.InsertFoto(this.directoryFoto, txtKTP.getText() + txtNamaLengkap.getText() + "." + this.extension, txtKTP.getText())) {
                        JOptionPane.showMessageDialog(this, "Upload Foto (" + txtNamaLengkap.getText() + ") sukses!");
                        MenuTIK m = new MenuTIK();
                        m.setVisible(true);
                        m.tambahUbah = 0;
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Upload Foto (" + txtNamaLengkap.getText() + ") gagal.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Mohon mengisikan data-data secara lengkap dahulu dan tekan tombol Simpan lalu tekan tombol ini kembali. ");
            }
        } else if (MenuTIK.tambahUbah == 2) {
            if (updateDiTekan) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    extension = getFileExtension(selectedFile);
                    nama = selectedFile.getName();//"uploadfoto." + extension;
                    try {
                        Thumbnails.of(new File(selectedFile.getAbsolutePath()))
                                .size(98, 135) // p , l
                                .toFile(new File(System.getProperty("user.dir") + "\\src\\foto\\" + nama));
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(this, e);
                    }
                    ImageIcon ii = new ImageIcon(System.getProperty("user.dir") + "\\src\\foto\\" + nama);
                    lblFoto.setIcon(ii);
                    lblFoto.setText("");
                    directoryFoto = System.getProperty("user.dir") + "\\src\\foto\\" + nama;
                    KartuTIK d = new KartuTIK();
                    if (d.UpdateFoto(this.directoryFoto, txtKTP.getText() + txtNamaLengkap.getText() + "." + this.extension, this.id)) {
                        JOptionPane.showMessageDialog(this, "Perubahan Foto (" + txtNamaLengkap.getText() + ") sukses!");
                        MenuTIK m = new MenuTIK();
                        m.setVisible(true);
                        m.tambahUbah = 0;
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Perubahan Foto (" + txtNamaLengkap.getText() + ") gagal.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Mohon mengisikan data-data secara lengkap dahulu dan tekan tombol Simpan lalu tekan tombol ini kembali. ");
            }
        }
    }//GEN-LAST:event_btnFotoActionPerformed

    private void txtAlamatOrangTuaIstriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatOrangTuaIstriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatOrangTuaIstriActionPerformed

    private void txtPerubahanAlamat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerubahanAlamat2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPerubahanAlamat2ActionPerformed

    private void txtPekerjaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPekerjaanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPekerjaanActionPerformed

    private void txtMukaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMukaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMukaActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        MenuTIK m = new MenuTIK();
        if (m.tambahUbah == 3) {
            Pencarian p = new Pencarian();
            p.setVisible(true);
            m.tambahUbah = 0;
            this.dispose();
        } else {
            int val = JOptionPane.showConfirmDialog(this, "Apa anda yakin untuk keluar?", "Peringatan!", JOptionPane.YES_NO_OPTION);
            if (val == JOptionPane.YES_OPTION) {
                m.setVisible(true);
                m.tambahUbah = 0;
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnSimpanUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanUbahActionPerformed
        if (MenuTIK.tambahUbah == 1) {
            try {
                if (!txtUmur.getText().isEmpty()) {
                    Integer.parseInt(txtUmur.getText());
                }
                if (!txtUmurIstri.getText().isEmpty()) {
                    Integer.parseInt(txtUmurIstri.getText());
                }
                if (!txtUmurBapakIstri.getText().isEmpty()) {
                    Integer.parseInt(txtUmurBapakIstri.getText());
                }
                if (!txtUmurIbuIstri.getText().isEmpty()) {
                    Integer.parseInt(txtUmurIbuIstri.getText());
                }
                if (!txtTinggi.getText().isEmpty()) {
                    Integer.parseInt(txtTinggi.getText());
                }
                if (!txtUmurAnak1.getText().isEmpty()) {
                    Integer.parseInt(txtUmurAnak1.getText());
                }
                if (!txtUmurAnak2.getText().isEmpty()) {
                    Integer.parseInt(txtUmurAnak2.getText());
                }
                if (!txtUmurAnak3.getText().isEmpty()) {
                    Integer.parseInt(txtUmurAnak3.getText());
                }
                if (!txtUmurAnak4.getText().isEmpty()) {
                    Integer.parseInt(txtUmurAnak4.getText());
                }
                if (!txtUmurAnak5.getText().isEmpty()) {
                    Integer.parseInt(txtUmurAnak5.getText());
                }
                if (!txtUmurAnak6.getText().isEmpty()) {
                    Integer.parseInt(txtUmurAnak6.getText());
                }
                if (!txtTahunLulusSekolah1.getText().isEmpty()) {
                    Integer.parseInt(txtTahunLulusSekolah1.getText());
                }
                if (!txtTahunLulusSekolah2.getText().isEmpty()) {
                    Integer.parseInt(txtTahunLulusSekolah2.getText());
                }
                if (!txtTahunLulusSekolah3.getText().isEmpty()) {
                    Integer.parseInt(txtTahunLulusSekolah3.getText());
                }
                if (!txtTahunLulusSekolah4.getText().isEmpty()) {
                    Integer.parseInt(txtTahunLulusSekolah4.getText());
                }
                if (!txtTahunLulusSekolah5.getText().isEmpty()) {
                    Integer.parseInt(txtTahunLulusSekolah5.getText());
                }
                if (!txtTahunLulusSekolah6.getText().isEmpty()) {
                    Integer.parseInt(txtTahunLulusSekolah6.getText());
                }

                if (txtNamaLengkap.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Masukkan nama lengkap!");
                } else {
                    if (txtKTP.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Masukkan no KTP!");
                    } else {
                        if (txtAgama.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Masukkan agama!");
                        } else {
                            if (txtTempatLahir.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(this, "Masukkan tempat lahir!");
                            } else {
                                KartuTIK d = new KartuTIK();
                                d.d.setNamalengkap(txtNamaLengkap.getText());
                                d.d.setAlias(txtAlias.getText());
                                d.d.setTglnoktp(txtKTP.getText());
                                d.d.setTglnopasport(txtPasport.getText());
                                d.d.setAgama(txtAgama.getText());
                                cmbTanggal.setEditable(true);
                                cmbBulan.setEditable(true);
                                cmbTahun.setEditable(true);
                                String tanggal = cmbTanggal.getEditor().getItem().toString();
                                String bulan = cmbBulan.getEditor().getItem().toString();
                                String tahun = cmbTahun.getEditor().getItem().toString();
                                String tgllahir = tanggal + "-" + bulan + "-" + tahun;
                                d.d.setTgllahir(tgllahir);
                                d.d.setUmur(txtUmur.getText());
                                d.d.setTempatlahir(txtTempatLahir.getText());
                                d.d.setAlamat(txtAlamat.getText());
                                d.d.setPerubahanalamat1(txtPerubahanAlamat1.getText());
                                d.d.setPerubahanalamat2(txtPerubahanAlamat2.getText());
                                d.d.setPerubahanalamat3(txtPerubahanAlamat3.getText());
                                d.d.setKedudukan(txtKedudukan.getText());
                                d.d.setNamabapak(txtNamaBapak.getText());
                                d.d.setNamaibu(txtNamaIbu.getText());
                                d.d.setAlamatorgtua(txtAlamatOrangTua.getText());
                                d.d.setPekerjaan(txtPekerjaan.getText());
                                d.d.setJabatan(txtJabatan.getText());
                                d.d.setInstansilembagakantor(txtInstansi.getText());
                                d.d.setNamaistri(txtNamaIstri.getText());
                                d.d.setUmuristri(txtUmurIstri.getText());
                                d.d.setPekerjaanistri(txtPekerjaanIstri.getText());
                                d.d.setNamabapakistri(txtNamaBapakIstri.getText());
                                d.d.setUmurbapakistri(txtUmurBapakIstri.getText());
                                d.d.setPekerjaanbapakistri(txtPekerjaanBapakIstri.getText());
                                d.d.setNamaibuistri(txtNamaIbuIstri.getText());
                                d.d.setUmuribuistri(txtUmurIbuIstri.getText());
                                d.d.setPekerjaanibuistri(txtPekerjaanIbuIstri.getText());
                                d.d.setAlamatorgtuaistri(txtAlamatOrangTuaIstri.getText());
                                d.d.setTanggungan(txtTanggungan.getText());
                                d.d.setAlamattanggungan(txtAlamatTanggungan.getText());
                                d.d.setRambut(txtRambut.getText());
                                d.d.setMuka(txtMuka.getText());
                                d.d.setKulit(txtKulit.getText());
                                d.d.setTinggi(txtTinggi.getText());
                                d.d.setTandaistimewa(txtTandaIstimewa.getText());
                                d.d.setRumussidikjari(txtRumusSidikJari.getText());
                                d.d.setNamaanak1(txtNamaAnak1.getText());
                                d.d.setNamaanak2(txtNamaAnak2.getText());
                                d.d.setNamaanak3(txtNamaAnak3.getText());
                                d.d.setNamaanak4(txtNamaAnak4.getText());
                                d.d.setNamaanak5(txtNamaAnak5.getText());
                                d.d.setNamaanak6(txtNamaAnak6.getText());
                                d.d.setUmuranak1(txtUmurAnak1.getText());
                                d.d.setUmuranak2(txtUmurAnak2.getText());
                                d.d.setUmuranak3(txtUmurAnak3.getText());
                                d.d.setUmuranak4(txtUmurAnak4.getText());
                                d.d.setUmuranak5(txtUmurAnak5.getText());
                                d.d.setUmuranak6(txtUmurAnak6.getText());
                                d.d.setPekerjaananak1(txtPekerjaanAnak1.getText());
                                d.d.setPekerjaananak2(txtPekerjaanAnak2.getText());
                                d.d.setPekerjaananak3(txtPekerjaanAnak3.getText());
                                d.d.setPekerjaananak4(txtPekerjaanAnak4.getText());
                                d.d.setPekerjaananak5(txtPekerjaanAnak5.getText());
                                d.d.setPekerjaananak6(txtPekerjaanAnak6.getText());
                                d.d.setNamasekolah1(txtNamaSekolah1.getText());
                                d.d.setNamasekolah2(txtNamaSekolah2.getText());
                                d.d.setNamasekolah3(txtNamaSekolah3.getText());
                                d.d.setNamasekolah4(txtNamaSekolah4.getText());
                                d.d.setNamasekolah5(txtNamaSekolah5.getText());
                                d.d.setNamasekolah6(txtNamaSekolah6.getText());
                                d.d.setTahunlulussekolah1(txtTahunLulusSekolah1.getText());
                                d.d.setTahunlulussekolah2(txtTahunLulusSekolah2.getText());
                                d.d.setTahunlulussekolah3(txtTahunLulusSekolah3.getText());
                                d.d.setTahunlulussekolah4(txtTahunLulusSekolah4.getText());
                                d.d.setTahunlulussekolah5(txtTahunLulusSekolah5.getText());
                                d.d.setTahunlulussekolah6(txtTahunLulusSekolah6.getText());
                                d.d.setHobi(txtKesenanganKegemaranHobi.getText());
                                d.d.setCatatankriminal1(txtKriminal1.getText());
                                d.d.setCatatankriminal2(txtKriminal2.getText());
                                d.d.setCatatankriminal3(txtKriminal3.getText());

                                int val = JOptionPane.showConfirmDialog(this, "Apa anda sudah yakin untuk menambah data?", "Peringatan!", JOptionPane.YES_NO_OPTION);
                                if (val == JOptionPane.YES_OPTION) {
                                    if (d.InsertDataTIK()) {
                                        JOptionPane.showMessageDialog(this, "Penambahan data sukses! Sekarang pilihlah foto untuk di upload!");
                                        btnFoto.setEnabled(true);
                                        txtFieldEnabled(false);
                                        btnSimpanUbah.setEnabled(false);
                                        insertDiTekan = true;
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Penambahan data gagal.");
                                    }
                                } else {
                                    //nothing happens
                                }
                            }
                        }
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Pengisian (Umur, Tinggi, Tahun lulus) harus berupa angka.");
            }
        } else if (MenuTIK.tambahUbah == 2) {
            try {
                if (!txtUmur.getText().isEmpty()) {
                    Integer.parseInt(txtUmur.getText());
                }
                if (!txtUmurIstri.getText().isEmpty()) {
                    Integer.parseInt(txtUmurIstri.getText());
                }
                if (!txtUmurBapakIstri.getText().isEmpty()) {
                    Integer.parseInt(txtUmurBapakIstri.getText());
                }
                if (!txtUmurIbuIstri.getText().isEmpty()) {
                    Integer.parseInt(txtUmurIbuIstri.getText());
                }
                if (!txtTinggi.getText().isEmpty()) {
                    Integer.parseInt(txtTinggi.getText());
                }
                if (!txtUmurAnak1.getText().isEmpty()) {
                    Integer.parseInt(txtUmurAnak1.getText());
                }
                if (!txtUmurAnak2.getText().isEmpty()) {
                    Integer.parseInt(txtUmurAnak2.getText());
                }
                if (!txtUmurAnak3.getText().isEmpty()) {
                    Integer.parseInt(txtUmurAnak3.getText());
                }
                if (!txtUmurAnak4.getText().isEmpty()) {
                    Integer.parseInt(txtUmurAnak4.getText());
                }
                if (!txtUmurAnak5.getText().isEmpty()) {
                    Integer.parseInt(txtUmurAnak5.getText());
                }
                if (!txtUmurAnak6.getText().isEmpty()) {
                    Integer.parseInt(txtUmurAnak6.getText());
                }
                if (!txtTahunLulusSekolah1.getText().isEmpty()) {
                    Integer.parseInt(txtTahunLulusSekolah1.getText());
                }
                if (!txtTahunLulusSekolah2.getText().isEmpty()) {
                    Integer.parseInt(txtTahunLulusSekolah2.getText());
                }
                if (!txtTahunLulusSekolah3.getText().isEmpty()) {
                    Integer.parseInt(txtTahunLulusSekolah3.getText());
                }
                if (!txtTahunLulusSekolah4.getText().isEmpty()) {
                    Integer.parseInt(txtTahunLulusSekolah4.getText());
                }
                if (!txtTahunLulusSekolah5.getText().isEmpty()) {
                    Integer.parseInt(txtTahunLulusSekolah5.getText());
                }
                if (!txtTahunLulusSekolah6.getText().isEmpty()) {
                    Integer.parseInt(txtTahunLulusSekolah6.getText());
                }
                
                if (txtNamaLengkap.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Masukkan nama lengkap!");
                } else {
                    if (txtKTP.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Masukkan no KTP!");
                    } else {
                        if (txtAgama.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Masukkan agama!");
                        } else {
                            if (txtTempatLahir.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(this, "Masukkan tempat lahir!");
                            } else {
                                KartuTIK d = new KartuTIK();
                                d.d.setNamalengkap(txtNamaLengkap.getText());
                                d.d.setAlias(txtAlias.getText());
                                d.d.setTglnoktp(txtKTP.getText());
                                d.d.setTglnopasport(txtPasport.getText());
                                d.d.setAgama(txtAgama.getText());
                                cmbTanggal.setEditable(true);
                                cmbBulan.setEditable(true);
                                cmbTahun.setEditable(true);
                                String tanggal = cmbTanggal.getEditor().getItem().toString();
                                String bulan = cmbBulan.getEditor().getItem().toString();
                                String tahun = cmbTahun.getEditor().getItem().toString();
                                String tgllahir = tanggal + "-" + bulan + "-" + tahun;
                                d.d.setTgllahir(tgllahir);
                                d.d.setUmur(txtUmur.getText());
                                d.d.setTempatlahir(txtTempatLahir.getText());
                                d.d.setAlamat(txtAlamat.getText());
                                d.d.setPerubahanalamat1(txtPerubahanAlamat1.getText());
                                d.d.setPerubahanalamat2(txtPerubahanAlamat2.getText());
                                d.d.setPerubahanalamat3(txtPerubahanAlamat3.getText());
                                d.d.setKedudukan(txtKedudukan.getText());
                                d.d.setNamabapak(txtNamaBapak.getText());
                                d.d.setNamaibu(txtNamaIbu.getText());
                                d.d.setAlamatorgtua(txtAlamatOrangTua.getText());
                                d.d.setPekerjaan(txtPekerjaan.getText());
                                d.d.setJabatan(txtJabatan.getText());
                                d.d.setInstansilembagakantor(txtInstansi.getText());
                                d.d.setNamaistri(txtNamaIstri.getText());
                                d.d.setUmuristri(txtUmurIstri.getText());
                                d.d.setPekerjaanistri(txtPekerjaanIstri.getText());
                                d.d.setNamabapakistri(txtNamaBapakIstri.getText());
                                d.d.setUmurbapakistri(txtUmurBapakIstri.getText());
                                d.d.setPekerjaanbapakistri(txtPekerjaanBapakIstri.getText());
                                d.d.setNamaibuistri(txtNamaIbuIstri.getText());
                                d.d.setUmuribuistri(txtUmurIbuIstri.getText());
                                d.d.setPekerjaanibuistri(txtPekerjaanIbuIstri.getText());
                                d.d.setAlamatorgtuaistri(txtAlamatOrangTuaIstri.getText());
                                d.d.setTanggungan(txtTanggungan.getText());
                                d.d.setAlamattanggungan(txtAlamatTanggungan.getText());
                                d.d.setRambut(txtRambut.getText());
                                d.d.setMuka(txtMuka.getText());
                                d.d.setKulit(txtKulit.getText());
                                d.d.setTinggi(txtTinggi.getText());
                                d.d.setTandaistimewa(txtTandaIstimewa.getText());
                                d.d.setRumussidikjari(txtRumusSidikJari.getText());
                                d.d.setNamaanak1(txtNamaAnak1.getText());
                                d.d.setNamaanak2(txtNamaAnak2.getText());
                                d.d.setNamaanak3(txtNamaAnak3.getText());
                                d.d.setNamaanak4(txtNamaAnak4.getText());
                                d.d.setNamaanak5(txtNamaAnak5.getText());
                                d.d.setNamaanak6(txtNamaAnak6.getText());
                                d.d.setUmuranak1(txtUmurAnak1.getText());
                                d.d.setUmuranak2(txtUmurAnak2.getText());
                                d.d.setUmuranak3(txtUmurAnak3.getText());
                                d.d.setUmuranak4(txtUmurAnak4.getText());
                                d.d.setUmuranak5(txtUmurAnak5.getText());
                                d.d.setUmuranak6(txtUmurAnak6.getText());
                                d.d.setPekerjaananak1(txtPekerjaanAnak1.getText());
                                d.d.setPekerjaananak2(txtPekerjaanAnak2.getText());
                                d.d.setPekerjaananak3(txtPekerjaanAnak3.getText());
                                d.d.setPekerjaananak4(txtPekerjaanAnak4.getText());
                                d.d.setPekerjaananak5(txtPekerjaanAnak5.getText());
                                d.d.setPekerjaananak6(txtPekerjaanAnak6.getText());
                                d.d.setNamasekolah1(txtNamaSekolah1.getText());
                                d.d.setNamasekolah2(txtNamaSekolah2.getText());
                                d.d.setNamasekolah3(txtNamaSekolah3.getText());
                                d.d.setNamasekolah4(txtNamaSekolah4.getText());
                                d.d.setNamasekolah5(txtNamaSekolah5.getText());
                                d.d.setNamasekolah6(txtNamaSekolah6.getText());
                                d.d.setTahunlulussekolah1(txtTahunLulusSekolah1.getText());
                                d.d.setTahunlulussekolah2(txtTahunLulusSekolah2.getText());
                                d.d.setTahunlulussekolah3(txtTahunLulusSekolah3.getText());
                                d.d.setTahunlulussekolah4(txtTahunLulusSekolah4.getText());
                                d.d.setTahunlulussekolah5(txtTahunLulusSekolah5.getText());
                                d.d.setTahunlulussekolah6(txtTahunLulusSekolah6.getText());
                                d.d.setHobi(txtKesenanganKegemaranHobi.getText());
                                d.d.setCatatankriminal1(txtKriminal1.getText());
                                d.d.setCatatankriminal2(txtKriminal2.getText());
                                d.d.setCatatankriminal3(txtKriminal3.getText());

                                int val = JOptionPane.showConfirmDialog(this, "Apa anda sudah yakin untuk merubah data?", "Peringatan!", JOptionPane.YES_NO_OPTION);
                                if (val == JOptionPane.YES_OPTION) {
                                    if (d.UpdateDataTIK(this.id)) {
                                        JOptionPane.showMessageDialog(this, "Perubahan data milik " + d.d.getNamalengkap() + " sukses!");
                                        int rep = JOptionPane.showConfirmDialog(this, "Apa anda mau merubah foto?", "Pertanyaan.", JOptionPane.YES_NO_OPTION);
                                        if (rep == JOptionPane.YES_OPTION) {
                                            updateDiTekan = true;
                                            btnSimpanUbah.setEnabled(false);
                                            txtFieldEnabled(false);
                                            btnFoto.setEnabled(true);
                                        } else {
                                            MenuTIK m = new MenuTIK();
                                            m.setVisible(true);
                                            m.tambahUbah = 0;
                                            this.dispose();
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(this, "Penambahan data gagal.");
                                    }
                                } else {
                                    //nothing happens
                                }
                            }
                        }
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Pengisian (Umur, Tinggi, Tahun lulus) harus berupa angka.");
            }
        } else if (MenuTIK.tambahUbah == 3) {
            int val = JOptionPane.showConfirmDialog(this, "Apa anda sudah yakin akan Print data milik " + d.d.getNamalengkap() + " ?", "Peringatan!", JOptionPane.YES_NO_OPTION);
            if (val == JOptionPane.YES_OPTION) {
                KartuTIK k = new KartuTIK();
                if (d.PrintDataTIK(d.d.getNamalengkap(), k.idUser)) {
                    JOptionPane.showMessageDialog(this, "Print data milik " + d.d.getNamalengkap() + " berhasil dilaksanakan!");
                    Pencarian p = new Pencarian();
                    p.setVisible(true);
                    MenuTIK.tambahUbah = 0;
                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(this, "Print data gagal.");
                }
            } else {
                //nothing happens
            }
        }
    }//GEN-LAST:event_btnSimpanUbahActionPerformed

    private void cmbTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTahunActionPerformed

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
            java.util.logging.Logger.getLogger(TambahUbahTIK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahUbahTIK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahUbahTIK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahUbahTIK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahUbahTIK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpanUbah;
    private javax.swing.JComboBox<String> cmbBulan;
    private javax.swing.JComboBox<String> cmbTahun;
    private javax.swing.JComboBox<String> cmbTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTextField txtAgama;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtAlamatOrangTua;
    private javax.swing.JTextField txtAlamatOrangTuaIstri;
    private javax.swing.JTextField txtAlamatTanggungan;
    private javax.swing.JTextField txtAlias;
    private javax.swing.JTextField txtInstansi;
    private javax.swing.JTextField txtJabatan;
    private javax.swing.JTextField txtKTP;
    private javax.swing.JTextField txtKedudukan;
    private javax.swing.JTextField txtKesenanganKegemaranHobi;
    private javax.swing.JTextField txtKriminal1;
    private javax.swing.JTextField txtKriminal2;
    private javax.swing.JTextField txtKriminal3;
    private javax.swing.JTextField txtKulit;
    private javax.swing.JTextField txtMuka;
    private javax.swing.JTextField txtNamaAnak1;
    private javax.swing.JTextField txtNamaAnak2;
    private javax.swing.JTextField txtNamaAnak3;
    private javax.swing.JTextField txtNamaAnak4;
    private javax.swing.JTextField txtNamaAnak5;
    private javax.swing.JTextField txtNamaAnak6;
    private javax.swing.JTextField txtNamaBapak;
    private javax.swing.JTextField txtNamaBapakIstri;
    private javax.swing.JTextField txtNamaIbu;
    private javax.swing.JTextField txtNamaIbuIstri;
    private javax.swing.JTextField txtNamaIstri;
    private javax.swing.JTextField txtNamaLengkap;
    private javax.swing.JTextField txtNamaSekolah1;
    private javax.swing.JTextField txtNamaSekolah2;
    private javax.swing.JTextField txtNamaSekolah3;
    private javax.swing.JTextField txtNamaSekolah4;
    private javax.swing.JTextField txtNamaSekolah5;
    private javax.swing.JTextField txtNamaSekolah6;
    private javax.swing.JTextField txtPasport;
    private javax.swing.JTextField txtPekerjaan;
    private javax.swing.JTextField txtPekerjaanAnak1;
    private javax.swing.JTextField txtPekerjaanAnak2;
    private javax.swing.JTextField txtPekerjaanAnak3;
    private javax.swing.JTextField txtPekerjaanAnak4;
    private javax.swing.JTextField txtPekerjaanAnak5;
    private javax.swing.JTextField txtPekerjaanAnak6;
    private javax.swing.JTextField txtPekerjaanBapakIstri;
    private javax.swing.JTextField txtPekerjaanIbuIstri;
    private javax.swing.JTextField txtPekerjaanIstri;
    private javax.swing.JTextField txtPerubahanAlamat1;
    private javax.swing.JTextField txtPerubahanAlamat2;
    private javax.swing.JTextField txtPerubahanAlamat3;
    private javax.swing.JTextField txtRambut;
    private javax.swing.JTextField txtRumusSidikJari;
    private javax.swing.JTextField txtTahunLulusSekolah1;
    private javax.swing.JTextField txtTahunLulusSekolah2;
    private javax.swing.JTextField txtTahunLulusSekolah3;
    private javax.swing.JTextField txtTahunLulusSekolah4;
    private javax.swing.JTextField txtTahunLulusSekolah5;
    private javax.swing.JTextField txtTahunLulusSekolah6;
    private javax.swing.JTextField txtTandaIstimewa;
    private javax.swing.JTextField txtTanggungan;
    private javax.swing.JTextField txtTempatLahir;
    private javax.swing.JTextField txtTinggi;
    private javax.swing.JTextField txtUmur;
    private javax.swing.JTextField txtUmurAnak1;
    private javax.swing.JTextField txtUmurAnak2;
    private javax.swing.JTextField txtUmurAnak3;
    private javax.swing.JTextField txtUmurAnak4;
    private javax.swing.JTextField txtUmurAnak5;
    private javax.swing.JTextField txtUmurAnak6;
    private javax.swing.JTextField txtUmurBapakIstri;
    private javax.swing.JTextField txtUmurIbuIstri;
    private javax.swing.JTextField txtUmurIstri;
    // End of variables declaration//GEN-END:variables
}
