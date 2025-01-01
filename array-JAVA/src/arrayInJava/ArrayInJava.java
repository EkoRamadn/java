package arrayInJava;

import java.util.ArrayList;

public class ArrayInJava{
    
    public static void main(String[] args){
//        Array pada Java
//        arrayMultidimensi();
        arrayListInJava();
        
    }
    
    public static void arrayNih(){
        String siswa[] = {"hadi","ari","ilham","rara","tohir"};
        
        for(int i = 0; i < siswa.length ; i++){
            System.out.print(siswa[i] + " ");
        }
        System.out.print(" \n");
    }
    
    public static void arrayMultidimensi(){
        String[][] kontak = {
            {"Lili","08111"},
            {"Lala","08122"},
            {"Maya","08133"}
        };
        
//        MEnampilkan Array Multi Dimensi
        for(int i = 0; i < kontak.length; i++){
            for(int j = 0; j < kontak[i].length; j++){
                System.out.format("data dari kontak[%s][%s] : %s \n" ,i , j, kontak[i][j]);
            }
        }
    }
    
    public static void arrayListInJava(){
        ArrayList kantongSemar = new ArrayList();
        
//        Mengisi Kantong semar
        kantongSemar.add("woi lah");
        kantongSemar.add(17);
        kantongSemar.add('F');
        kantongSemar.add(23.44);
        kantongSemar.add(true);
        
//        Mencoba menampilkan
        System.out.println(kantongSemar);
        System.out.println("Size kantongSemar: " + kantongSemar.size());
        
    }
}