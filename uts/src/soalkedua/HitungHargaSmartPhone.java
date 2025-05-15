package soalkedua;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import animasi.Animtext;
import utils.*;
import java.util.ArrayList;
// import java.util.List;
import java.util.Arrays;

public class HitungHargaSmartPhone {
    static DecimalFormat df = new DecimalFormat("#,###.00");
    static List<Pajak> daftarPajak = new ArrayList<>(Arrays.asList(
            new Pajak("Samsung", "Galaxy S21", 10000000),
            new Pajak("Samsung", "Galaxy S20", 8000000),
            new Pajak("Samsung", "Galaxy S10", 6000000),
            new Pajak("Samsung", "Galaxy S9", 4000000),
            new Pajak("Samsung", "Galaxy S8", 2000000),
            new Pajak("Samsung", "Galaxy S7", 1000000),
            new Pajak("Samsung", "Galaxy S6", 500000),
            new Pajak("Samsung", "Galaxy S5", 300000),
            new Pajak("Samsung", "Galaxy S4", 200000),
            new Pajak("Samsung", "Galaxy S3", 100000),
            new Pajak("Samsung", "Galaxy S2", 50000),
            new Pajak("Samsung", "Galaxy S1", 10000),
            new Pajak("Samsung", "Galaxy S0", 5000),
            new Pajak("Samsung", "Galaxy S", 1000),
            new Pajak("Samsung", "Galaxy A", 500),
            new Pajak("Samsung", "Galaxy B", 100),
            new Pajak("Samsung", "Galaxy C", 50),
            new Pajak("Samsung", "Galaxy D", 10),
            new Pajak("Samsung", "Galaxy E", 5),
            new Pajak("Samsung", "Galaxy F", 1),
            new Pajak("Samsung", "Galaxy G", 0)));

    public static void start(Scanner scanner) {
        boolean loop = true;

        while (loop) {
            Utilliti.clearTerminal();
            System.out.println("+-----+---------------------+");
            System.out.println("| NO  |       PROGRAM       |");
            System.out.println("+-----+---------------------+");
            System.out.println("| 1   | Tampil Produk       |");
            System.out.println("| 2   | Tambah Produk       |");
            System.out.println("| 3   | Hapus Produk        |");
            System.out.println("| 0   | Kembali             |");
            System.out.println("+-----+---------------------+");
            System.out.print("Masukkan pilihanmu (0/1/2/3): ");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    tampilProduk(daftarPajak, scanner);
                    break;
                case 2:
                    tambahProduk(scanner);
                    break;
                case 3:
                    hapusProduk(scanner);
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

    static void tampilProduk(List<Pajak> datas, Scanner scanner) {

        Utilliti.clearTerminal();
        System.out.println("PROGRAM TAMPIL PRODUK 📦");
        System.out.println("+-----+--------------+----------------+---------------------+");
        System.out.println("| NO  | VENDOR       | TIPE           | HARGA(IDR)          |");
        System.out.println("+-----+--------------+----------------+---------------------+");

        for (int i = 0; i < datas.size(); i++) {
            String vendor = String.format("%-12s", datas.get(i).getVendor());
            String tipe = String.format("%-14s", datas.get(i).getTipe());
            String harga = String.format("%19s", df.format(datas.get(i).getHarga()));

            System.out.println(String.format("| %-3d | %-12s | %-14s | %19s |", i + 1, vendor, tipe, harga));
        }

        System.out.println("+-----+--------------+----------------+---------------------+");
        Utilliti.logicIO(scanner);
    }

    static void tambahProduk(Scanner scanner) {
        Utilliti.clearTerminal();
        System.out.println("+------------------------------->");
        System.out.println("| PROGRAM TAMBAH PRODUK 📥");
        scanner.nextLine();
        System.out.print("| Masukkan Vendor : ");
        String vendor = scanner.nextLine();

        System.out.print("| Masukan Tipe    : ");
        String tipe = scanner.nextLine();

        System.out.print("| Masukan Harga   : ");
        int harga = scanner.nextInt();
        scanner.nextLine();

        System.out.println("+------------------------------->");

        Ppn ppn = hitungPPN(harga);
        int hargaSetelahPPN = harga + ppn.ppnIdr;

        System.out.println("| Memproses... 🛠️(IDR)");
        Animtext.charAnim("| Harga Produk       : " + df.format(harga), 20);
        Animtext.charAnim("| Produk terkena PPN : " + ppn.ppnCen + "%", 20);
        Animtext.charAnim("| Harga setelah PPN  : " + df.format(hargaSetelahPPN), 20);

        daftarPajak.add(new Pajak(vendor, tipe, hargaSetelahPPN));

        Animtext.charAnim("| Status : ✅ Berhasil Ditambahkan", 20);
        System.out.println("+------------------------------->");
        Utilliti.logicIO(scanner);
    }

    static void hapusProduk(Scanner scanner) {
        Utilliti.clearTerminal();
        System.out.println("+------------------------------->");
        System.out.println("| PROGRAM HAPUS PRODUK 📤");

        System.out.print("| Masukan ID Produk : ");
        int idProduk = scanner.nextInt();
        scanner.nextLine();
        System.out.println("+------------------------------->");

        if (idProduk < 1 || idProduk > daftarPajak.size()) {
            Animtext.charAnim("| ❌ ID produk tidak valid!", 15);
            System.out.println("+------------------------------->");
            Utilliti.logicIO(scanner);
            return;
        }

        Pajak produk = daftarPajak.get(idProduk - 1);
        System.out.println("| Memproses... 🛠️");
        Animtext.charAnim("| Vendor      : " + produk.getVendor(), 20);
        Animtext.charAnim("| Tipe        : " + produk.getTipe(), 20);
        Animtext.charAnim("| Harga(IDR)  : " + df.format(produk.getHarga()), 20);
        if (confirmIO(scanner)) {
            daftarPajak.remove(produk); // ✅ Hapus berdasarkan objek langsung
            Animtext.charAnim("| Status      : ✅ Berhasil Dihapus", 20);
        } else {
            Animtext.charAnim("| Status      : ⏳ Membatalkan Hapus", 20);
        }

        System.out.println("+------------------------------->");
        Utilliti.logicIO(scanner);
    }

    public static Ppn hitungPPN(int harga) {
        Ppn ppn;

        if (harga > 4000000 && harga <= 4500000) {
            ppn = new Ppn(1, (harga * 1 / 100));

        } else if (harga > 4500000 && harga <= 8000000) {
            ppn = new Ppn(2, (harga * 2 / 100));
        } else if (harga > 8000000) {
            ppn = new Ppn(5, (harga * 5 / 100));
        } else {
            ppn = new Ppn(0, 0);
        }

        return ppn;
    }

    static boolean confirmIO(Scanner scanner) {
        while (true) {
            System.out.println("+------------------------------->");
            System.out.print("| Hapus produk? (yes/no): ");
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
