/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartu.tik;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author GeolseuDei
 */
public class KartuTIK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login l = new Login();
        l.setVisible(true);
    }
    
    public static DataTIK d = new DataTIK();
    
    public static String idUser = "";
    public static String namaUser = "";
    public static String tipeUser = "";
    public static String hakAksesUser = "";

    private String ipkeserver = "localhost";
    private int portkeserver = 8888;

    public boolean Login(String username, String password) {
        boolean status = false;
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "login";
            output.println(jenisdata);

            output.println(username);
            output.println(password);

            String statuslogin = input.readLine();
            if (statuslogin.equalsIgnoreCase("true")) {
                status = true;
                idUser = input.readLine();
                namaUser = input.readLine();
                tipeUser = input.readLine();
            } else {
                status = false;
            }

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public ArrayList AmbilDataLogMenuAdmin() {
        ArrayList list = new ArrayList<>();
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "menulog";
            output.println(jenisdata);

            int sizeArray = Integer.parseInt(input.readLine());
            for (int i = 0; i < sizeArray; i++) {
                classLog l = new classLog();
                l.setNama(input.readLine());
                l.setEvent(input.readLine());
                l.setWaktu(input.readLine());
                list.add(l);
            }

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList AmbilDataLogDenganTanggal(String tanggal, String bulan, String tahun) {
        ArrayList list = new ArrayList<>();
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "tanggallog";
            output.println(jenisdata);

            output.println(tanggal);
            output.println(bulan);
            output.println(tahun);

            int sizeArray = Integer.parseInt(input.readLine());
            for (int i = 0; i < sizeArray; i++) {
                classLog l = new classLog();
                l.setNama(input.readLine());
                l.setEvent(input.readLine());
                l.setWaktu(input.readLine());
                list.add(l);
            }

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean InsertDataTIK() {
        boolean status = false;
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "insertTIK";
            output.println(jenisdata);

            output.println(d.getNamalengkap());
            output.println(d.getAlias());
            output.println(d.getTglnoktp());
            output.println(d.getTglnopasport());
            output.println(d.getAgama());
            output.println(d.getTgllahir());
            output.println(d.getUmur());
            output.println(d.getTempatlahir());
            output.println(d.getAlamat());
            output.println(d.getPerubahanalamat1());
            output.println(d.getPerubahanalamat2());
            output.println(d.getPerubahanalamat3());
            output.println(d.getKedudukan());
            output.println(d.getNamabapak());
            output.println(d.getNamabapak());
            output.println(d.getAlamatorgtua());
            output.println(d.getPekerjaan());
            output.println(d.getJabatan());
            output.println(d.getInstansilembagakantor());
            output.println(d.getNamaistri());
            output.println(d.getUmuristri());
            output.println(d.getPekerjaanistri());
            output.println(d.getNamabapakistri());
            output.println(d.getUmurbapakistri());
            output.println(d.getPekerjaanbapakistri());
            output.println(d.getNamaibuistri());
//            output.println(umuribuistri);
//            output.println(pekerjaanibuistri);
//            output.println(alamatorangtuaistri);
//            output.println(tanggungan);
//            output.println(alamattanggungan);
//            output.println(namaanak1);
//            output.println(namaanak2);
//            output.println(namaanak3);
//            output.println(namaanak4);
//            output.println(namaanak5);
//            output.println(namaanak6);
//            output.println(umuranak1);
//            output.println(umuranak2);
//            output.println(umuranak3);
//            output.println(umuranak4);
//            output.println(umuranak5);
//            output.println(umuranak6);
//            output.println(pekerjaananak1);
//            output.println(pekerjaananak2);
//            output.println(pekerjaananak3);
//            output.println(pekerjaananak4);
//            output.println(pekerjaananak5);
//            output.println(pekerjaananak6);
//            output.println(rambut);
//            output.println(muka);
//            output.println(kulit);
//            output.println(tinggi);
//            output.println(tandaistimewa);
//            output.println(namasekolah1);
//            output.println(namasekolah2);
//            output.println(namasekolah3);
//            output.println(namasekolah4);
//            output.println(namasekolah5);
//            output.println(namasekolah6);
//            output.println(tahunlulussekolah1);
//            output.println(tahunlulussekolah2);
//            output.println(tahunlulussekolah3);
//            output.println(tahunlulussekolah4);
//            output.println(tahunlulussekolah5);
//            output.println(tahunlulussekolah6);
//            output.println(hobi);
//            output.println(catatankriminal1);
//            output.println(catatankriminal2);
//            output.println(catatankriminal3);
            
            if (input.readLine().equalsIgnoreCase("true")) {
                status = true;
            } else {
                status = false;
            }

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public void sendimage(String url, String nama) {
        Socket s;
        String address = "localhost";
        int port = 8888;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            output.println("foto");
            output.println(nama);

            OutputStream outputStream = s.getOutputStream();

            BufferedImage image = ImageIO.read(new File(url));

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", byteArrayOutputStream);

            byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
            outputStream.write(size);
            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.flush();
            System.out.println("Flushed: " + System.currentTimeMillis());

            System.out.println("Closing: " + System.currentTimeMillis());
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AmbilDataLengkap(String namalengkap) {
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "ambildatalengkap";
            output.println(jenisdata);

            output.println(namalengkap);
/*
            d.setNamalengkap(input.readLine());
            d.setAlias(input.readLine());
            d.setTglnoktp(input.readLine());
            d.setTglnopasport(input.readLine());
            d.setAgama(input.readLine());
            d.setTgllahir(input.readLine());
            d.setUmur(input.readLine());
            d.setTempatlahir(input.readLine());
            d.setAlamat(input.readLine());
            d.setPerubahanalamat1(input.readLine());
            d.setPerubahanalamat2(input.readLine());
            d.setPerubahanalamat3(input.readLine());
            d.setKedudukan(input.readLine());
            d.setNamabapak(input.readLine());
            d.setNamaibu(input.readLine());
            d.setPekerjaan(input.readLine());
            d.setJabatan(input.readLine());
            d.setInstansilembagakantor(input.readLine());
            d.setNamaistri(input.readLine());
            d.setUmuristri(input.readLine());
            d.setPekerjaanistri(input.readLine());
            d.setNamabapakistri(input.readLine());
            d.setUmurbapakistri(input.readLine());
            d.setPekerjaanbapakistri(input.readLine());
            d.setNamaibuistri(input.readLine());
            d.setUmuribuistri(input.readLine());
            d.setPekerjaanibuistri(input.readLine());
            d.setAlamatorgtuaistri(input.readLine());
            d.setTanggungan(input.readLine());
            d.setAlamattanggungan(input.readLine());
            d.setRambut(input.readLine());
            d.setMuka(input.readLine());
            d.setKulit(input.readLine());
            d.setTinggi(input.readLine());
            d.setTandaistimewa(input.readLine());
            d.setRumussidikjari(input.readLine());
            d.setNamaanak1(input.readLine());
            d.setNamaanak2(input.readLine());
            d.setNamaanak3(input.readLine());
            d.setNamaanak4(input.readLine());
            d.setNamaanak5(input.readLine());
            d.setNamaanak6(input.readLine());
            d.setUmuranak1(input.readLine());
            d.setUmuranak2(input.readLine());
            d.setUmuranak3(input.readLine());
            d.setUmuranak4(input.readLine());
            d.setUmuranak5(input.readLine());
            d.setUmuranak6(input.readLine());
            d.setPekerjaananak1(input.readLine());
            d.setPekerjaananak2(input.readLine());
            d.setPekerjaananak3(input.readLine());
            d.setPekerjaananak4(input.readLine());
            d.setPekerjaananak5(input.readLine());
            d.setPekerjaananak6(input.readLine());
            d.setNamasekolah1(input.readLine());
            d.setNamasekolah2(input.readLine());
            d.setNamasekolah3(input.readLine());
            d.setNamasekolah4(input.readLine());
            d.setNamasekolah5(input.readLine());
            d.setNamasekolah6(input.readLine());
            d.setTahunlulussekolah1(input.readLine());
            d.setTahunlulussekolah2(input.readLine());
            d.setTahunlulussekolah3(input.readLine());
            d.setTahunlulussekolah4(input.readLine());
            d.setTahunlulussekolah5(input.readLine());
            d.setTahunlulussekolah6(input.readLine());
            d.setHobi(input.readLine());
            d.setCatatankriminal1(input.readLine());
            d.setCatatankriminal2(input.readLine());
            d.setCatatankriminal3(input.readLine());
*/

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean UpdateDataTIK() {
        boolean status = false;
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "updateTIK";
            output.println(jenisdata);

            DataTIK d = new DataTIK();
            output.println(d.getNamalengkap());
            output.println(d.getAlias());
            output.println(d.getTglnoktp());
            output.println(d.getTglnopasport());
            output.println(d.getAgama());
            output.println(d.getTgllahir());
            output.println(d.getUmur());
            output.println(d.getTempatlahir());
            output.println(d.getAlamat());
            output.println(d.getPerubahanalamat1());
            output.println(d.getPerubahanalamat2());
            output.println(d.getPerubahanalamat3());
            output.println(d.getKedudukan());
            output.println(d.getNamabapak());
            output.println(d.getNamaibu());
            output.println(d.getAlamatorgtua());
            output.println(d.getPekerjaan());
            output.println(d.getJabatan());
            output.println(d.getInstansilembagakantor());
            output.println(d.getNamaistri());
            output.println(d.getUmuristri());
            output.println(d.getPekerjaanistri());
            output.println(d.getNamabapakistri());
            output.println(d.getUmurbapakistri());
            output.println(d.getPekerjaanbapakistri());
            output.println(d.getNamaibuistri());
            output.println(d.getUmuribuistri());
            output.println(d.getPekerjaanibuistri());
            output.println(d.getAlamatorgtuaistri());
            output.println(d.getTanggungan());
            output.println(d.getAlamattanggungan());
            output.println(d.getNamaanak1());
            output.println(d.getNamaanak2());
            output.println(d.getNamaanak3());
            output.println(d.getNamaanak4());
            output.println(d.getNamaanak5());
            output.println(d.getNamaanak6());
            output.println(d.getUmuranak1());
            output.println(d.getUmuranak2());
            output.println(d.getUmuranak3());
            output.println(d.getUmuranak4());
            output.println(d.getUmuranak5());
            output.println(d.getUmuranak6());
            output.println(d.getPekerjaananak1());
            output.println(d.getPekerjaananak2());
            output.println(d.getPekerjaananak3());
            output.println(d.getPekerjaananak4());
            output.println(d.getPekerjaananak5());
            output.println(d.getPekerjaananak6());
            output.println(d.getRambut());
            output.println(d.getMuka());
            output.println(d.getKulit());
            output.println(d.getTinggi());
            output.println(d.getTandaistimewa());
            output.println(d.getNamasekolah1());
            output.println(d.getNamasekolah2());
            output.println(d.getNamasekolah3());
            output.println(d.getNamasekolah4());
            output.println(d.getNamasekolah5());
            output.println(d.getNamasekolah6());
            output.println(d.getTahunlulussekolah1());
            output.println(d.getTahunlulussekolah2());
            output.println(d.getTahunlulussekolah3());
            output.println(d.getTahunlulussekolah4());
            output.println(d.getTahunlulussekolah5());
            output.println(d.getTahunlulussekolah6());
            output.println(d.getHobi());
            output.println(d.getCatatankriminal1());
            output.println(d.getCatatankriminal2());
            output.println(d.getCatatankriminal3());

            String extension = TambahUbahTIK.extension.substring(1);
            output.println(extension);

            OutputStream outputStream = s.getOutputStream();

            BufferedImage image = ImageIO.read(new File(TambahUbahTIK.directoryFoto));

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, extension, byteArrayOutputStream);

            byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
            outputStream.write(size);
            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.flush();

            //System.out.println("Flushed: " + System.currentTimeMillis());
            //System.out.println("Closing: " + System.currentTimeMillis());
            String statusrespon = input.readLine();
            if (statusrespon.equalsIgnoreCase("true")) {
                status = true;
            } else {
                status = false;
            }

            s.close();

            String statuslogin = input.readLine();
            if (statuslogin.equalsIgnoreCase("true")) {
                status = true;
            } else {
                status = false;
            }

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean DeleteDataTIK(String namalengkap) {
        boolean status = false;
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "deleteTIK";
            output.println(jenisdata);

            output.println(namalengkap);

            String statuslogin = input.readLine();
            if (statuslogin.equalsIgnoreCase("true")) {
                status = true;
            } else {
                status = false;
            }

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}
