package structHasMap;

//import hashMap
import java.util.HashMap;

public class StructurHasMap{
//    Class HashMap merupakan class turunan dari class AbstractMap 
//        dan implementasi dari interface Map.
    
    public static void main(String[] args){
        fungsiPadaHashMap();
    }
    
    public static void startHashMap(){
//      deklarasi
        HashMap<Integer, String> days = new HashMap<Integer,String>();
    
//      mengisi hashMap
        days.put(1, "Minggu");
        days.put(2, "Senin");
        days.put(3, "Selasa");
        days.put(4, "Rabu");
        days.put(5, "Kamis");
        days.put(6, "Jum'at");
        days.put(7, "Sabtu");
        
        // mencetak semua isi dari objek days
        System.out.println("Isi objek days: " + days);
        System.out.println("Hari kedua: " + days.get(2));
        
        // menghapus malam minggu <-- jomblo detected :D
        days.remove(1);
        System.out.println("Isi objek days: " + days);
        
        // menghapus semua hari <-- oh tidak kiamat donk!
        days.clear();
        System.out.println("Isi objek days: " + days);
        
        // mengubah hari menggu menjadi hari ahad
        days.put(1, "Ahad");
        
        // mengubah hari rabu menjadi rabo
        days.replace(4, "Rabo");
        System.out.println("Isi objek days: " + days);
    }
    
    public static void fungsiPadaHashMap(){
//      deklarasi
        HashMap<Integer, String> days = new HashMap<Integer,String>();
    
//      mengisi hashMap
        days.put(1, "Minggu");
        days.put(2, "Senin");
        days.put(3, "Selasa");
        days.put(4, "Rabu");
        days.put(5, "Kamis");
        days.put(6, "Jum'at");
        days.put(7, "Sabtu");
        
//        MElakukan check hasmap apakah hasmap kosong
        System.out.println(days.isEmpty());
        
       
        
        
    }
}