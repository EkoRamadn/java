package variabelTipeData;

import bangunDatar.ProgramHitungLuas;

public class variabelTipeData{
    
    public static void main(String[] args){
        
//       tipeData();
//        ProgramHitungLuas.luasSegitiga();
//        konversiData();
    }
    
    public static void tipeData(){
         /*
        Macam" tipe data
        
        char
        int
        float
        double
        String
        boolean
        */
        
        String nama =  "Eko ramadani";
        int usia = 19;
        double tinggi = 170.5;
        float berat = 52;
        boolean kondisi = true;
        char inisial = 'E';
        
        System.out.println("-------------");
        System.out.println("Nama : " + nama);
        System.out.println("Usia : " + usia);
        System.out.println("Tinggi Badan : " + tinggi);
        System.out.println("Berat Badan : " + berat);
        System.out.println("Kondisi Sehat : " + kondisi);
        System.out.println("Inisial Nama : " + inisial);
    }
    
    public static void konversiData(){
        
//        ubah double jadi int
        String hasilTestLamaStr = "wow";
        double hasilTestLamaDbl = 89.45;
        int hasilTestBaru = Integer.parseInt("ahsga");
        
        System.out.println("hasil test baru: " + hasilTestBaru);
    }
}