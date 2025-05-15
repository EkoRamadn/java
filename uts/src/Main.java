import java.util.Scanner;

import animasi.*;
import soalpertama.*;
import soalkedua.*;
import utils.*;

public class Main {

    public static void main(String[] args) {
        Utilliti.clearTerminal();
        Animtext.charAnim("Memulai Aplikasi", 20);

        Scanner scanner = new Scanner(System.in);
        start(scanner);
        scanner.close();
    }

    static void start(Scanner scanner) {

        boolean loop = true;
        int pilih;

        while (loop) {
            Utilliti.clearTerminal();
            System.out.println("+---+-----------------+");
            System.out.println("|NO |   PROGRAM       |");
            System.out.println("+---+--------- -------+");
            System.out.println("| 1 |   Program 1     |");
            System.out.println("| 2 |   Program 2     |");
            System.out.println("| 3 |   Exit          |");
            System.out.println("+---+-----------------+");
            System.out.print("Masukkan pilihanmu (1/2/3):  ");
            pilih = scanner.nextInt();

            if (pilih == 1) {
                ProgramBangunRuang.soalPertama(scanner);
            } else if (pilih == 2) {
                HitungHargaSmartPhone.start(scanner);
            } else if (pilih == 3) {
                System.out.println("Keluar Program...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Ups! Ada gangguan waktu");
                }

                Utilliti.clearTerminal();
                Animtext.charAnim("Terima Kasih Telah Menggunakan Aplikasi Ini", 20);
                loop = false;
            } else {
                Utilliti.invalidInput(scanner);
            }
        }

    }

    public static void soalkedua(Scanner scanner) {

    }

}
