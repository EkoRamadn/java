package hash;

import java.util.Scanner;

import utils.Utilliti;

public class HashStart {
    public static boolean start(Scanner scanner) {

        while (true) {
            Utilliti.clearTerminal();
            System.out.println("+-----+---------------------+");
            System.out.println("| NO  |       PROGRAM       |");
            System.out.println("+-----+---------------------+");
            System.out.println("| 1   | HillChipher         |");
            System.out.println("| 0   | Kembali             |");
            System.out.println("+-----+---------------------+");
            System.out.print("Masukkan pilihanmu (0/1): ");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    Uinterface.start(scanner);
                    break;
                case 0:
                    return false;
                default:
                    Utilliti.invalidInput(scanner);
                    break;
            }

        }
    }
}
