/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartu.tik;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Scanner;
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
    public static String divisi = "";

    private String ipkeserver = "localhost";
    private int portkeserver = 8888;


    public void ReadingIPFromNotePad() throws FileNotFoundException {
        Scanner fileIn = new Scanner(new File(System.getProperty("user.dir") + "\\ip.txt"));
        String fileRead = fileIn.nextLine();
        String fileReadPart[] = fileRead.split(":");
        ipkeserver = fileReadPart[1];
    }

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
                hakAksesUser = input.readLine();
                divisi = input.readLine();
            } else {
                status = false;
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public ArrayList AmbilDataLogMenuAdmin(String divisi) {
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

            output.println(divisi);
            
            int sizeArray = Integer.parseInt(input.readLine());
            for (int i = 0; i < sizeArray; i++) {
                classLog l = new classLog();
                l.setNama(input.readLine());
                l.setEvent(input.readLine());
                l.setWaktu(input.readLine());
                list.add(l);
            }
            s.close();

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
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList AmbilDataTabelTIK(String divisi) {
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
            String jenisdata = "tabeltik";
            output.println(jenisdata);
            
            output.println(divisi);

            int sizeArray = Integer.parseInt(input.readLine());
            for (int i = 0; i < sizeArray; i++) {
                DataTIK d = new DataTIK();
                d.setNamalengkap(input.readLine());
                d.setAlias(input.readLine());
                d.setTglnoktp(input.readLine());
                d.setAgama(input.readLine());
                d.setTgllahir(input.readLine());
                d.setTempatlahir(input.readLine());
                list.add(d);
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean InsertDataTIK(String divisi) {
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
            output.println(d.getRumussidikjari());
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
            output.println(divisi);

            if (input.readLine().equalsIgnoreCase("true")) {
                status = true;
                output.println(idUser);
            } else {
                status = false;
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean InsertFoto(String url, String namafoto, String noktp, String divisi) {
        boolean status = false;
        Socket s;
        String address = "localhost";
        int port = 8888;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            s.setReceiveBufferSize(4096);
            s.setSendBufferSize(4096);
            s.setSoTimeout(2000);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            output.println("insertfoto");

            output.println(namafoto);
            output.println(noktp);
            output.println(divisi);

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

            String statusrespon = input.readLine();
            if (statusrespon.equalsIgnoreCase("true")) {
                output.println(idUser);
                status = true;
            } else {
                status = false;
            }
            outputStream.close();
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean UpdateFoto(String url, String namafoto, String id, String divisi) {
        boolean status = false;
        Socket s;
        String address = "localhost";
        int port = 8888;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            s.setReceiveBufferSize(4096);
            s.setSendBufferSize(4096);
            s.setSoTimeout(2000);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            output.println("updatefoto");

            output.println(namafoto);
            output.println(id);
            output.println(divisi);

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

            String statusrespon = input.readLine();
            if (statusrespon.equalsIgnoreCase("true")) {
                output.println(idUser);
                status = true;
            } else {
                status = false;
            }
            outputStream.close();
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public void AmbilDataLengkapByNamaLengkap(String namalengkap) {
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "ambildatalengkapbynamalengkap";
            output.println(jenisdata);

            output.println(namalengkap);

            d.setId(input.readLine());
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
            d.setAlamatorgtua(input.readLine());
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
            d.setUrlfoto(input.readLine());
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean AmbilFotoTIKbyID(String id) {
        boolean status = false;
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            s.setReceiveBufferSize(4096);
            s.setSendBufferSize(4096);
            s.setSoTimeout(2000);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "ambilfotoubah";
            output.println(jenisdata);

            output.println(id);
            
            BufferedInputStream inputStream = new BufferedInputStream(s.getInputStream());

            String nama = input.readLine();

            System.out.println("Reading: " + System.currentTimeMillis());

            byte[] sizeAr = new byte[4];
            inputStream.read(sizeAr);
            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

            byte[] imageAr = new byte[size];
            inputStream.read(imageAr);

            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

            System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
            ImageIO.write(image, "png", new File(System.getProperty("user.dir") + "\\src\\foto\\" + nama));

            d.setUrlfoto(System.getProperty("user.dir") + "\\src\\foto\\" + nama);
            System.out.println(d.getUrlfoto());
            
            status = true;
            
            inputStream.close();
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public void AmbilDataLengkapByKTP(String ktp, String divisi) {
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "ambildatalengkapbyktp";
            output.println(jenisdata);

            output.println(ktp);
            output.println(divisi);

            d.setId(input.readLine());
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
            d.setAlamatorgtua(input.readLine());
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

            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean UpdateDataTIK(String id, String divisi) {
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

            output.println(id);
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
            output.println(d.getRumussidikjari());
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
            output.println(divisi);

            String statusrespon = input.readLine();
            if (statusrespon.equalsIgnoreCase("true")) {
                status = true;
                output.println(idUser);
            } else {
                status = false;
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean DeleteDataTIK(String namalengkap,String divisi) {
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
            output.println(divisi);

            String statuslogin = input.readLine();
            if (statuslogin.equalsIgnoreCase("true")) {
                status = true;
                output.println(idUser);
            } else {
                status = false;
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean AmbilDataTIKByKTP(String ktp, String divisi) {
        boolean status = false;
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            s.setReceiveBufferSize(4096);
            s.setSendBufferSize(4096);
            s.setSoTimeout(2000);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "ambildataTIKbyKTP";
            output.println(jenisdata);

            output.println(ktp);
            output.println(divisi);

            String statuslogin = input.readLine();
            if (statuslogin.equalsIgnoreCase("true")) {
                status = true;
                d.setId(input.readLine());
                d.setNamalengkap(input.readLine());
                d.setAlias(input.readLine());
                d.setTglnoktp(input.readLine());
                d.setAgama(input.readLine());
                d.setTgllahir(input.readLine());
                d.setTempatlahir(input.readLine());

                BufferedInputStream inputStream = new BufferedInputStream(s.getInputStream());

                String nama = input.readLine();

                System.out.println("Reading: " + System.currentTimeMillis());

                byte[] sizeAr = new byte[4];
                inputStream.read(sizeAr);
                int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

                byte[] imageAr = new byte[size];
                inputStream.read(imageAr);

                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

                System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
                ImageIO.write(image, "png", new File(System.getProperty("user.dir") + "\\src\\foto\\" + nama));

                d.setUrlfoto(System.getProperty("user.dir") + "\\src\\foto\\" + nama);
                System.out.println(d.getUrlfoto());

            } else {
                status = false;
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean PrintDataTIK(String namalengkap, String idUser, String divisi) {
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
            String jenisdata = "printdatatik";
            output.println(jenisdata);

            output.println(namalengkap);
            output.print(divisi);

            String statuslogin = input.readLine();
            if (statuslogin.equalsIgnoreCase("true")) {
                status = true;
                output.println(idUser);
            } else {
                status = false;
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public ArrayList AmbilDataTabelKegiatan(String id) {
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
            String jenisdata = "tabelkegiatan";
            output.println(jenisdata);

            output.println(id);

            int sizeArray = Integer.parseInt(input.readLine());
            for (int i = 0; i < sizeArray; i++) {
                classKegiatan k = new classKegiatan();
                k.setNamakegiatan(input.readLine());
                k.setTanggal(input.readLine());
                list.add(k);
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean InsertKegiatan(String id, String kegiatan, String waktu, String nama, String divisi) {
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
            String jenisdata = "insertkegiatan";
            output.println(jenisdata);

            output.println(id);
            output.println(kegiatan);
            output.println(waktu);
            output.println(nama);
            output.println(divisi);

            String statuslogin = input.readLine();
            if (statuslogin.equalsIgnoreCase("true")) {
                status = true;
                output.println(idUser);
            } else {
                status = false;
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean GantiNama(String namabaru, String id) {
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
            String jenisdata = "gantinama";
            output.println(jenisdata);

            output.println(namabaru);
            output.println(id);

            String statuslogin = input.readLine();
            if (statuslogin.equalsIgnoreCase("true")) {
                status = true;
            } else {
                status = false;
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean PasswordLamaSama(String passwordlama, String id) {
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
            String jenisdata = "cekpassword";
            output.println(jenisdata);

            output.println(passwordlama);
            output.println(id);

            String statuslogin = input.readLine();
            if (statuslogin.equalsIgnoreCase("true")) {
                status = true;
            } else {
                status = false;
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean GantiPassword(String password, String id) {
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
            String jenisdata = "gantipassword";
            output.println(jenisdata);

            output.println(password);
            output.println(id);

            String statuslogin = input.readLine();
            if (statuslogin.equalsIgnoreCase("true")) {
                status = true;
            } else {
                status = false;
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public String DataHakAkses(String noinduk) {
        String data = "";
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "datahakakses";
            output.println(jenisdata);

            output.println(noinduk);

            String statuslogin = input.readLine();
            if (statuslogin.equalsIgnoreCase("true")) {
                data = input.readLine();
            } else {
                data = "";
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public boolean UbahHakAkses(String noinduk, String jenis, String nama, String divisi) {
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
            String jenisdata = "ubahhakakses";
            output.println(jenisdata);

            output.println(noinduk);
            output.println(jenis);
            output.println(nama);
            output.println(divisi);

            String statuslogin = input.readLine();
            if (statuslogin.equalsIgnoreCase("true")) {
                status = true;
                output.println(idUser);
            } else {
                status = false;
            }
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public void Logout(String id, String divisi) {
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "logout";
            output.println(jenisdata);

            output.println(id);
            output.println(divisi);

            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String AmbilNamaByKTP(String ktp, String divisi) {
        String data = "";
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "ambilnamabyktp";
            output.println(jenisdata);

            output.println(ktp);
            output.println(divisi);

            data = input.readLine();

            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public boolean BuatAkunMember(String nama, String noinduk, String username, String password, String divisi) {
        boolean respon = false;
        Socket s;
        String address = ipkeserver;
        int port = portkeserver;
        PrintStream output;
        BufferedReader input;
        try {
            s = new Socket(address, port);
            output = new PrintStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String jenisdata = "buatakunmember";
            output.println(jenisdata);

            output.println(nama);
            output.println(noinduk);
            output.println(username);
            output.println(password);
            output.println(divisi);
            
            if(input.readLine().equalsIgnoreCase("true")){
                respon = true;
            } else {
                respon = false;
            }
            
            s.close();

        } catch (IOException ex) {
            Logger.getLogger(KartuTIK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respon;
    }
}
