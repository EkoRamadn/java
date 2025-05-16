package soalpertama;

import java.util.Scanner;

import utils.Utilliti;

public class ProgramBangunRuang {
    public static void soalPertama(Scanner scanner) {

        int pilih;
        boolean loop = true;

        while (loop) {
            Utilliti.clearTerminal();
            System.out.println("+------+---------------------+");
            System.out.println("| KODE |     BANGUN RUANG    |");
            System.out.println("+------+---------------------+");
            System.out.println("|  0   |       Kembali       |");
            System.out.println("|  1   |       Kubus         |");
            System.out.println("|  2   |       Balok         |");
            System.out.println("|  3   |       Silinder      |");
            System.out.println("|  4   |       Bola          |");
            System.out.println("+------+---------------------+");
            System.out.print("Masukkan pilihanmu (0/1/2/3/4): ");
            pilih = scanner.nextInt();
            switch (pilih) {
                case 0:
                    loop = false;
                    break;
                case 1:
                    Utilliti.clearTerminal();
                    System.out.println("+------------------------------->");
                    System.out.println("| PROGRAM KUBUS 📦(cm)");
                    System.out.print("| Masukkan panjang rusuk kubus: ");
                    int rusuk = scanner.nextInt();
                    BangunRuang kubus = new BangunRuang(rusuk);
                    kubus.tampil();
                    Utilliti.logicIO(scanner);
                    break;
                case 2:
                    Utilliti.clearTerminal();
                    System.out.println("+------------------------------->");
                    System.out.println("| PROGRAM BALOK 🗄️(cm)");
                    System.out.print("| Masukkan panjang balok: ");
                    double panjang = scanner.nextDouble();
                    System.out.print("| Masukkan lebar balok: ");
                    double lebar = scanner.nextDouble();
                    System.out.print("| Masukkan tinggi balok: ");
                    double tinggiBalok = scanner.nextDouble();
                    BangunRuang balok = new BangunRuang(panjang, lebar, tinggiBalok);
                    balok.tampil();
                    Utilliti.logicIO(scanner);
                    break;
                case 3:
                    Utilliti.clearTerminal();
                    System.out.println("+------------------------------->");
                    System.out.println("| PROGRAM SILINDER 🔋(cm)");
                    System.out.print("| Masukkan jari-jari silinder: ");
                    double jariSilinder = scanner.nextDouble();
                    System.out.print("| Masukkan tinggi silinder: ");
                    double tinggiSilinder = scanner.nextDouble();
                    BangunRuang silinder = new BangunRuang(jariSilinder, tinggiSilinder);
                    silinder.tampil();
                    Utilliti.logicIO(scanner);
                    break;
                case 4:
                    Utilliti.clearTerminal();
                    System.out.println("+------------------------------->");
                    System.out.println("| PROGRAM BOLA ⚽(cm)");
                    System.out.print("| Masukkan jari-jari bola: ");
                    double jariBola = scanner.nextDouble();
                    BangunRuang bola = new BangunRuang(jariBola);
                    bola.tampil();
                    Utilliti.logicIO(scanner);
                    break;
                default:
                    Utilliti.invalidInput(scanner);
            }
        }

    }
}
