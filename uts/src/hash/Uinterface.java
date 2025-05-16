package hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import animasi.Animtext;
import utils.Utilliti;

public class Uinterface {
    static int[][] matrix = new int[][] {
            { -4, -1, 1 },
            { 5, 0, 2 },
            { -2, -1, 2 }
    };

    // hillchiper menu
    public static void start(Scanner scanner) {
        boolean loop = true;

        while (loop) {
            Utilliti.clearTerminal();
            System.out.println("+-----+---------------------+");
            System.out.println("| NO  |       PROGRAM       |");
            System.out.println("+-----+---------------------+");
            System.out.println("| 1   | Ecrypt              |");
            System.out.println("| 2   | decrypt             |");
            System.out.println("| 3   | Set Matrix Key      |");
            System.out.println("| 0   | Kembali             |");
            System.out.println("+-----+---------------------+");
            System.out.print("Masukkan pilihanmu (0/1/2/3): ");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    Utilliti.clearTerminal();
                    encrypMatrix(scanner);
                    break;
                case 2:
                    Utilliti.clearTerminal();
                    decryptMatrix(scanner);
                    break;
                case 3:
                    Utilliti.clearTerminal();
                    setMatrixKey(scanner);
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    Utilliti.invalidInput(scanner);
                    break;
            }

        }
    }

    static void tampilMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|  [ ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d", matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
    }

    static boolean setMatrixKey(Scanner scanner) {
        while (true) {
            Utilliti.clearTerminal();
            boolean then = tampilKeyMatrik(scanner);
            if (then) {
                Utilliti.clearTerminal();
                System.out.println("+------------------------------->");
                System.out.println("| PROGRAM SET MATRIX KEY 🔓");
                System.out.println("+------------------------------->");
                System.out.println("| Masukan Matrix baru:");

                int rows = matrix.length;
                int cols = matrix[0].length;
                List<String> nn = new ArrayList<>();

                // Input Matrix
                for (int i = 0; i < rows; i++) {
                    System.out.print("| => ");
                    String input = scanner.nextLine().trim();
                    String[] row = input.split("\\s+");
                    if (row.length != cols) {
                        Animtext.charAnim("| ⚠️ masukan " + cols + " elemen per baris.", 15);
                        i--;
                        continue;
                    }
                    for (String num : row) {
                        nn.add(num);
                    }
                }

                System.out.println("+------------------------------->");
                System.out.println("| Memproses.. 🛠️");

                if (nn.size() != rows * cols) {
                    Animtext.charAnim("| Status : ❌ Gagal mengubah", 15);
                    return false;
                }

                try {
                    int[][] tmp = new int[3][3];
                    int index = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            tmp[i][j] = Integer.parseInt(nn.get(index++));
                        }
                    }
                    int det = HillCipherHash.getDet(tmp);
                    Animtext.charAnim("| Mendapat Determinan : " + det, 15);
                    if (0 >= det) {
                        Animtext.charAnim("| ❌matrik tidak memiliki invers.", 15);
                        System.out.println("+------------------------------->");
                        Utilliti.logicIO(scanner);
                        return false;
                    }

                    index = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            matrix[i][j] = Integer.parseInt(nn.get(index++));
                        }
                    }
                    Animtext.charAnim("| Status : ✅ Berhasil", 15);
                } catch (NumberFormatException e) {
                    Animtext.charAnim("| Status : ❌ Input tidak valid. Harus angka semua.", 15);
                    Animtext.charAnim(e.getMessage(), 15);
                    return false;
                }
                System.out.println("+------------------------------->");
                Utilliti.logicIO(scanner);
                return false;
            } else {
                return false;
            }
        }
    }

    static boolean tampilKeyMatrik(Scanner scanner) {
        while (true) {
            Utilliti.clearTerminal();
            System.out.println("+------------------------------->");
            Animtext.charAnim("| Matrik Kunci Saat Ini 🔐:", 0);
            tampilMatrix(matrix, scanner);
            scanner.nextLine();
            if (Utilliti.confirmIO(scanner, "| Ubah Matrik?(yes/no): ")) {
                try {
                    Animtext.charAnim("| Status : ✒️Memulai Mengubah.", 15);
                    System.out.println("+------------------------------->");
                    Thread.sleep(500);
                } catch (Exception e) {
                    Animtext.charAnim("| Status : ✒️Memulai Mengubah.", 15);
                    Animtext.charAnim(e.getMessage(), 15);
                } finally {
                    return true;
                }

            } else {
                try {
                    Animtext.charAnim("| Status : 🔒Batal Mengubah.", 15);
                    System.out.println("+------------------------------->");
                    Thread.sleep(500);
                } catch (Exception e) {
                    Animtext.charAnim("| Status : 🔒Batal Mengubah.", 15);
                    Animtext.charAnim(e.getMessage(), 15);
                } finally {
                    return false;
                }

            }

        }
    }

    static void decryptMatrix(Scanner scanner) {
        Utilliti.clearTerminal();
        System.out.println("+------------------------------->");
        System.out.println("| PROGRAM DENCRYP 🧷");
        System.out.println("| Masukan Chiper Text: ");
        scanner.nextLine();
        System.out.print("| => ");
        String input = scanner.nextLine();
        System.out.println("+------------------------------->");
        try {
            System.out.println("| Memproses.. 🛠️");
            Thread.sleep(1000);
            Animtext.charAnim("| Memasukan Matrix Kunci Invers.", 15);
            String chiperText = HillCipherHash.decrypt(input, matrix);
            Thread.sleep(1000);
            Animtext.charAnim("| Status : ✅Berhasil Dencrypt.", 15);
            System.out.println("+------------------------------->");
            Animtext.charAnim("| Result : " + chiperText, 15);
        } catch (Exception e) {
            Animtext.charAnim("| Status : ❌Gagal Dencrypt.", 15);
            Animtext.charAnim(e.getMessage(), 15);
        } finally {
            System.out.println("+------------------------------->");
            Utilliti.logicIO(scanner);
        }
    }

    static void encrypMatrix(Scanner scanner) {
        Utilliti.clearTerminal();
        System.out.println("+------------------------------->");
        System.out.println("| PROGRAM ENCRYP 🔗");
        System.out.println("| Masukan Password: ");
        scanner.nextLine();
        System.out.print("| => ");
        String input = scanner.nextLine();
        System.out.println("+------------------------------->");
        try {
            System.out.println("| Memproses.. 🛠️");
            Thread.sleep(1000);
            Animtext.charAnim("| Memasukan Matrix Kunci.", 15);
            String chiperText = HillCipherHash.encryp(input, matrix);
            Thread.sleep(1000);
            Animtext.charAnim("| Status : ✅Berhasil membuat.", 15);
            System.out.println("+------------------------------->");
            Animtext.charAnim("| ChiperText : " + chiperText, 15);
        } catch (Exception e) {
            Animtext.charAnim("| Status : ❌Gagal membuat.", 15);
            Animtext.charAnim(e.getMessage(), 15);
        } finally {
            System.out.println("+------------------------------->");
            Utilliti.logicIO(scanner);
        }
    }
}
