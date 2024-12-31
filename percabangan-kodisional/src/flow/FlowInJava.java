package flow;

import java.util.Scanner;


public class FlowInJava{
    
    public static void main(String[] args) throws InterruptedException{
        belanjaYuk();
    }
    
    public static void belanjaYuk() throws InterruptedException {
        char valid;
        Scanner keyboard = new Scanner(System.in);

        while (true) { // Gunakan loop untuk menghindari rekursi
            System.out.println("Hei Kamu Disana Belanja Yuk (Y/N): ");
            valid = keyboard.next().charAt(0); // Membaca input pengguna

            switch (valid) {
                case 'Y', 'y' -> {
                    System.out.println("Berangkat Yuk");
                    keyboard.close(); // Menutup Scanner sebelum keluar
                    return; // Keluar dari metode
                }
                case 'N', 'n' -> {
                    System.out.println("Tapi stok gudang dah HABIS");
                    Thread.sleep(2000);
                    System.out.println("Pokoknya Harus BELANJA");
                }
                default -> {
                    System.out.println("Yang bener DONG kalo JAWAB");
                    Thread.sleep(2000);
                }
            }
        }
    
    }
}