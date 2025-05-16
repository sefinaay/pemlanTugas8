package tugasDelapann;

import java.awt.*;

public class MainDaftarUlang {

    public static void main(String[] args) {
        FormDaftarUlang f = new FormDaftarUlang();        //membuat objek form 
        f.setSize(500, 500);                 //mengatur ukuran jendela form 
        f.setTitle("Form Daftar Ulang");            //menentukan judul jendelan form
        f.setBackground(new Color(240, 240, 240));  //mengatur warna latar belaknag jendela
        f.setVisible(true);                             //menampilkan jendela form
        
    }

}
