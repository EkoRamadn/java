package utils;

import java.util.Scanner;
import animasi.Animtext;

public class Utilliti {
    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void logicIO(Scanner scanner) {
        boolean loop = true;

        while (loop) {
            System.out.print("ketik 1 untuk melanjutkan : ");
            int io = scanner.nextInt();

            if (io == 1) {
                loop = false;
            } else {
                invalidInput(scanner);
            }
        }

    }

    public static void invalidInput(Scanner scanner) {
        Animtext.charAnim("Pilihan tidak valid. Tekan Enter untuk ulang...", 20);
        scanner.nextLine();
        scanner.nextLine();
    }

    public static boolean confirmIO(Scanner scanner, String test) {
        while (true) {
            System.out.println("+------------------------------->");
            System.out.print(test);
            String yesOrNo = scanner.nextLine().trim();

            if (yesOrNo.equalsIgnoreCase("yes")) {
                return true;
            } else if (yesOrNo.equalsIgnoreCase("no")) {
                return false;
            } else {
                Animtext.charAnim("| Input tidak dikenali.", 15);
            }
            System.out.println("+------------------------------->");
        }
    }

}
