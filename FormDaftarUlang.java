package tugasDelapann;

//mengimpor semua kelas dari java.awt dan java.awt.event
import java.awt.*;
import java.awt.event.*;

public class FormDaftarUlang extends Frame {

    //mendeklarasikan semua komponen GUI yang akan digunakan, seperti Label, TextField, CheckBox, dan Button
    Label LJudul, LNama, LJenisKelamin, LTgl, LNo, LTelp, LEmail, LAlamat;      //Label digunakan untuk menampilkan teks 
    TextField TNama, TTgl, TNo, TTelp, TEmail, TALamat;                         //TextField digunakan untuk input teks
    CheckboxGroup jenisKelamin;                                                 //CheckBoxGroup digunakan untuk mengelompokan CheckBox
    Checkbox CLaki, CPerempuan;                                                 //CheckBox digunakan untuk pilihan jenis kelamin   
    Checkbox CPersetujuan;                                                      //CheckBox digunakan untuk menyetujui pernyataan
    Button Submit;                                                              //Button digunakan untuk tombol submit

    public FormDaftarUlang(){

        //menonaktifkan layout manager, agar dapat mengatur posisi secara manual
        setLayout(null);

        LJudul = new Label("Formulir Daftar Ulang");                       //membuat label teks yang berisi "Formulir Daftar Ulang"
        LJudul.setFont(new Font("Arial", Font.BOLD, 20));             //mengatur font label menjadi Arial tebal dengan ukuran 20
        LJudul.setBounds(150, 40, 350, 25);                    //mengatur ukuran dan posisi label dijendela
        add(LJudul);                                                            //menambahkan label ke dalam frame

        //label dan inputan teks untuk nama lengkap
        LNama = new Label("Nama Lengkap: ");               //label untuk nama lengkap
        add(LNama);                                             //menambahkan label ke frame 
        LNama.setBounds(50, 80, 100, 20);      //mengatur posisi dan ukuran label

        //inputan teks untuk nama lengkap
        TNama = new TextField();                                //membuat kolom input teks untuk memasukan nama lengkap
        add(TNama);                                             //menambahkan field ke frame 
        TNama.setBounds(200, 80, 250, 25);     //menentukan posisi dan ukuran field

        //label untuk jenis kelamin dan pengaturannya
        LJenisKelamin = new Label("Jenis Kelamin: ");
        add(LJenisKelamin);
        LJenisKelamin.setBounds(50, 120, 100, 20);

        //membuat checkbox grup dengan dua pilihan yaitu laki-laki dan perempuan
        jenisKelamin = new CheckboxGroup();
        CLaki = new Checkbox("Laki-Laki", jenisKelamin, false);
        add(CLaki);
        CPerempuan = new Checkbox("Perempuan", jenisKelamin, false);
        add(CPerempuan);
        //menempatkan checkbox di posisi yang sesuai
        CLaki.setBounds(200, 120, 80, 20);
        CPerempuan.setBounds(290, 120, 90, 20);

        //label dan field untuk tanggal lahir 
        LTgl = new Label("Tanggal Lahir: ");
        add(LTgl);
        LTgl.setBounds(50, 160, 100, 20);

        TTgl = new TextField();
        add(TTgl);
        TTgl.setBounds(200, 160, 250, 25);

        //label dan field untuk nomor pendaftaran
        LNo = new Label("Nomor Pendaftaran: ");
        add(LNo);
        LNo.setBounds(50, 200, 120, 20);

        TNo = new TextField();
        add(TNo);
        TNo.setBounds(200, 200, 250, 25);

        //label dan field untuk nomor telepon
        LTelp = new Label("No. Telepon: ");
        add(LTelp);
        LTelp.setBounds(50, 240, 100, 20);

        TTelp = new TextField();
        add(TTelp);
        TTelp.setBounds(200, 240, 250, 25);

        //label dan field untuk alamat
        LAlamat = new Label("Alamat: ");
        add(LAlamat);
        LAlamat.setBounds(50, 280, 100, 40);

        TALamat = new TextField();
        add(TALamat);
        TALamat.setBounds(200, 280, 250, 45);

        //label dan field untuk email
        LEmail = new Label("E-mail: ");
        add(LEmail);
        LEmail.setBounds(50, 340, 100, 20);

        TEmail = new TextField();
        add(TEmail);
        TEmail.setBounds(200, 340, 250, 25);

        //checkbox sebagai syarat validasi bahwa data benar
        CPersetujuan = new Checkbox("Dengan ini saya menyatakan bahwa data yang saya masukan adalah benar");
        add(CPersetujuan);
        CPersetujuan.setBounds(50, 380, 400, 20);

        //membuat tombol submit untuk mengirimkan data yang telah diisi, jika tombol ditekan validasi data (validasiForm()), jika valid muncul konfirmasi data (konfirmasiData())
        Submit = new Button("Submit");
        add(Submit);
        Submit.setBounds(200, 420, 100, 30);
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(validasiForm()) {
                    KonfirmasiData();
                }
            }
        });

        //menambahkan fungsi penutup saat tombol X dipojok kanan atas jendela, tanpa ini saat mengklik X dipojok kanan atas jendela tidak otomatis menutup jendela pada frame di AWT
        addWindowFocusListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we){
                dispose();
            }
        });
    }

    //Untuk memastikan semua field diisi dengan benar, jika terdapat field yang kosong atau tidak di centang maka akan menampilkan peringatan
    private boolean validasiForm(){

        if (TNama.getText().trim().isEmpty()) {                     //memeriksa apakah field nama kosong, jika tidak terdapat ini maka form dapat disubmit walaupun nama kosong
            tampilkanPeringatan("Nama lengkap harus diisi!");
            return false;
        }
        if (jenisKelamin.getSelectedCheckbox() == null) {          //memeriksa apakah jenis kelamin dipilih, jika tidak terdapat ini maka form dapat disubmit walaupun jenis kelamin belum dipilih
            tampilkanPeringatan("Jenis kelamin harus dipilih!");
            return false;
        }
        if (TTgl.getText().trim().isEmpty()) {                     //memeriksa apakah field tanggal lahir kosong, jika tidak terdapat ini maka form dapat disubmit walaupun tanggal lahir kosong
            tampilkanPeringatan("Tanggal lahir harus diisi!");
            return false;
        }
        if (TNo.getText().trim().isEmpty()) {                      //memeriksa apakah field nomor pendaftaran kosong, jika tidak terdapat ini maka form dapat disubmit walaupun nomor pendaftaran kosong
            tampilkanPeringatan("Nomor pendaftaran harus diisi!");
            return false;
        }
        if (TTelp.getText().trim().isEmpty()) {                    //memeriksa apakah field nomor telepon kosong, jika tidak terdapat ini maka form dapat disubmit walaupun nomor telepon kosong
            tampilkanPeringatan("No. Telepon harus diisi!");
            return false;
        }
        if (TALamat.getText().trim().isEmpty()) {                  //memeriksa apakah field alamat kosong, jika tidak terdapat ini maka form dapat disubmit walaupun alamat kosong
            tampilkanPeringatan("Alamat harus diisi!");
            return false;
        }
        if (TEmail.getText().trim().isEmpty()) {                   //memeriksa apakah field email kosong, jika tidak terdapat ini maka form dapat disubmit walaupun email kosong
            tampilkanPeringatan("E-mail harus diisi!");
            return false;
        }
        if (!CPersetujuan.getState()) {                            //memeriksa apakah field persetujuan sudah dicentang, jika tidak terdapat ini maka form dapat disubmit walaupun persetujuan belum dipilih
            tampilkanPeringatan("Anda harus menyetujui pernyataan!");
            return false;
        }
        //jika semua field sudah diisi dengan benar maka form dapat disubmit 
        return true;

    }

    //Untuk menampilkan jendela dialog peringatan yang berisi pesan peringatan jika validasi gagal, dilengkapi dengan tombol OK untuk kembali ke jendela utama.
    private void tampilkanPeringatan(String message){
        Dialog dialog = new Dialog(this, "Peringatan", true);                   //Dialog untuk menyampaikan pesan peringatan
        dialog.setLayout(new FlowLayout());                                                 //menonaktifkan layout dialog
        dialog.setSize(300,80);                                                //mengatur ukuran dialog 
        dialog.setLocationRelativeTo(this);                                                 //mengatur posisi dialog agar berada di tengah jendela utama

        //menambahkan label dan tombol OK kedalam dialog 
        Label Lmessage = new Label(message);
        Button Ok = new Button("OK");

        //menambahkan action Listener pada tombol OK agar ketika tombol OK dipencet maka dialog akan tertutup dan kembali ke jendela utama
        Ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dialog.dispose();
            }
        });

        //menampilkan jendela dialog ke pengguna
        dialog.add(Lmessage);
        dialog.add(Ok);
        dialog.setVisible(true);

    }

    //Setelah validasi berhasil, menampilkan dialog konfirmasi untuk memastikan pengguna yakin bahwa data yang dimasukan sudah benar dan siap untuk disubmit
    private void KonfirmasiData(){
        Dialog dialog = new Dialog(this, "Konfirmasi Data", true);                  //dialog untuk konfirmasi data
        dialog.setLayout(new FlowLayout());                                                     //menonaktifkan layout dialog
        dialog.setSize(350, 120);                                                  //mengatur ukuran dialog
        dialog.setLocationRelativeTo(this);                                                     //mengatur posisi dialog agar berada ditengah jendela 

        Label Lmessage = new Label("Apakah anda yakin data yang anda isi sudah benar?");    //Label untuk menampilkan pesan konfirmasi 
        Button Ok = new Button("OK");                                                      //button untuk menyetujui submit data 
        Button Cancel = new Button("Cancel");                                              //button untuk membatalkan submit data

        //menambahkan action Listener pada tombol OK agar ketika tombol OK dipencet maka dialog akan tertutup dan menampilkan data mahasiswa yang sudah diisi sebelumnya
        Ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dialog.dispose();
                tampilkanData();
            }
        });

        //menambahkan action Listener pada tombol Cancel agar ketika tombol Cancel dipencet maka dialog akan tertutup dan kembali ke jendela utama 
        Cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dialog.dispose();
            }
        });

        //menambahkan label dan tombol OK dan Cancel kedalam dialog
        dialog.add(Lmessage);
        dialog.add(Ok);
        dialog.add(Cancel);
        dialog.setVisible(true);
    }

    //Menampilkan data yang telah diisi dalam frame baru dengan tampilan terformat. menggunakan Panel yang digambar bordernya (Borderedpanel)
    private void tampilkanData(){
        Frame dataFrame = new Frame("Data Daftar Ulang");                   //Frame untuk menampilkan data mahasiswa
        dataFrame.setSize(450, 400);                                 //mengatur ukuran frame
        dataFrame.setLayout(null);                                            //menonaktifkan layout frame 
        dataFrame.setLocationRelativeTo(this);                                    //mengatur posisi frame agar berada ditengah jendela utama
        dataFrame.setBackground(new Color(211, 211, 211));                  //mengatut warna latar belakang 

        //untuk membuat panel khusus yang memiliki bingkai atau garis tepi berwarna abu-abu tua 
        class BorderedPanel extends Panel {
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(Color.DARK_GRAY);
                g.drawRect(0, 0, getWidth()-1, getHeight()-1);
            }
        }

        BorderedPanel p = new BorderedPanel();                          //membuat objek panel dari kelas BorderedPanel 
        p.setLayout(null);                                          //menonaktifkan layout panel
        p.setBounds(30, 70, 390, 260);                 //mengatur ukuran panel 
        p.setBackground(new Color(240, 240, 240));                                   //mengatur warna latar belakang panel 
        dataFrame.add(p);                                               //menambahkan panel p ke dalam jendela dataFrame agar tampilan di UI

        Label LJudul = new Label("Data Mahasiswa");                 //membuat label teks yang berisi "Data Mahasiswa"
        LJudul.setFont(new Font("Arial", Font.BOLD, 18));      //mengatur jenis font label
        LJudul.setBounds(160, 40, 250, 25);             //mengatur ukuran label didalam dataFrame
        dataFrame.add(LJudul);                                           //menambahkan label LJudul ke dalam jendela dataFrame agar tampilan di UI

        int y = 30;                                                             //mendefinisikan variabel y untuk menyimpan posisi vertikal awal penempatan label data didalam panel
        //memanggil method tambahLabelData untuk menambahkan satu baris label ke panel p
        tambahLabelData(p, "Nama", TNama.getText(), y); y += 35;          
        tambahLabelData(p, "Tanggal Lahir", TTgl.getText(), y); y += 35;
        tambahLabelData(p, "No. Pendaftaran", TNo.getText(), y); y += 35;
        tambahLabelData(p, "No. Telp", TTelp.getText(), y); y += 35;
        tambahLabelData(p, "Alamat", TALamat.getText(), y); y += 35;
        tambahLabelData(p, "E-mail", TEmail.getText(), y); y += 35;
        
        Button Tutup = new Button("Tutup");                   //membuat tombol tutup untuk menutup jendela 
        Tutup.setFont(new Font("Arial", Font.PLAIN, 12)); //mengatur font tombol "Tutup"
        dataFrame.add(Tutup);                                       //Menambahkan tombol "Tutup" ke jendela dataFrame
        Tutup.setBounds(175, 340, 100, 30);        //menentukan posisi dan ukuran tombol di dalam jendela 
       
       //menambahkan action Listener pada tombol "Tutup" agar ketika tombol "Tutup" dipencet maka jendela dataFrame akan tertutup
        Tutup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataFrame.dispose();                          //jendela akan ditutup atau dihapus dari memori
            }
        });

        //menambahkan fungsi penutup saat tombol X dipojok kanan atas jendela, tanpa ini saat mengklik X dipojok kanan atas jendela tidak otomatis menutup jendela pada frame di AWT
        dataFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dataFrame.dispose();
            }
        });
        
        //menampilkan jendela dataFrame ke layar
        dataFrame.setVisible(true);
    }

    //Menambahkan label data ke dalam panel tampilan data, lengkap dengan : dan isian nilainya. Digunakan untuk menghindari pengulangan kode 
    private void tambahLabelData(Container container, String label, String value, int y) {
        Label LLabel = new Label(label);                                    //membuat label untuk judul data
        LLabel.setFont(new Font("Arial", Font.PLAIN, 12));        //mengatur jenis font label judul
        LLabel.setBounds(20, y, 100, 20);                    //mengatur posisi dan ukuran label judul 
        container.add(LLabel);                                              //menambahkan label judul ke dalam panel 

        Label LTitikDua = new Label(":");                              //membuat label yang berisi tanda titik dua ":" sebagai pemisah antara label dan nilai
        LTitikDua.setFont(new Font("Arial", Font.PLAIN, 12));     //mengatur jenis font 
        LTitikDua.setBounds(120, y, 10, 20);                 //mengatur posisi dan ukuran 
        container.add(LTitikDua);                                           //menambahkan label titik dua ke dalam panel

        Label LValue = new Label(value);                                    //membuat label berisi isi dari data inputan yang dimasukan oleh pengguna
        LValue.setFont(new Font("Arial", Font.PLAIN, 12));        //mengatur jenis font
        LValue.setBounds(140, y, 220, 20);                   //mengatur posisi dan ukuran 
        container.add(LValue);                                              //menambahkan label value ke dalam panel
    }

}
