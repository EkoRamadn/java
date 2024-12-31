
package bangunDatar;

import java.util.Scanner;

public class ProgramHitungLuas {
    
    public static void luasLinkaran(){
        
        double PI = 3.14;
        int r;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Masukan Jari\" Lingkaran:");
        r = keyboard.nextInt();
        
        double hasilLuas = PI * r * r;
        
        System.out.println("Luas Linkaran adalah: " + hasilLuas);
    }
    
    public static void luasSegitiga(){
        int alas, tinggi;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Input Alas: ");
        alas = keyboard.nextInt();
        
        
        System.out.println("Input Tinggi: ");
        tinggi = keyboard.nextInt();
        
        double luas = 0.5 * alas * tinggi;
        
        System.out.println("Alas segitiga: " + luas);
        
    }
    
}
