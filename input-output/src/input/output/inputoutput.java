package input.output;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class inputoutput{
 
    public static void main(String[] args){
        System.out.println("hello");
        pow("eko");
//        inputScanner();
        inputBufferReader();
        
    }
    
    public static void pow(String nama){
        System.out.println(nama);
    }
    
    public static void inputScanner(){
        String nama, alamat;
        int usia, gaji;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("### Pendataan Wali Murid ###");
        System.out.println("Nama wali: ");
        
        nama = keyboard.nextLine();
        
        System.out.println("Alamat: ");
        alamat = keyboard.nextLine();
        
        System.out.println("Usia: ");
        usia = keyboard.nextInt();
        
        System.out.println("Gaji: ");
        gaji = keyboard.nextInt();
        
        System.out.println("------------------------");
        System.out.println("Nama Wali: " + nama);
        System.out.println("Alama: " + alamat);
        System.out.println("Usia: " + usia);
        System.out.println("Gaji: " + gaji);
    }
    
   public static void inputBufferReader() {
        String nama;

        // Membuat objek InputStreamReader dan BufferedReader
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            // Mengisi variabel nama dengan BufferedReader
            System.out.print("Inputkan nama: ");
            nama = br.readLine();

            // Menampilkan output isi variabel nama
            System.out.println("Nama kamu adalah " + nama);
        } catch (IOException e) {
            // Menangani IOException
            System.out.println("Terjadi kesalahan saat membaca input: " + e.getMessage());
        }
    }
}
