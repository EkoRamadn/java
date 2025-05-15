package animasi;

public class Animtext {
    public static void charAnim(String text, int sec) {
        String kalimat = text;

        for (int i = 0; i < kalimat.length(); i++) {
            System.out.print(kalimat.charAt(i));
            try {
                Thread.sleep(sec);
            } catch (InterruptedException e) {
                System.out.println("Ups! Ada gangguan waktu");
            }
        }

        System.out.println();
    }
}
