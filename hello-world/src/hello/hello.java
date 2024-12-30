package hello;

public class hello {

    public static void main(String[] args) {
        
        // hello world
        System.out.println("hello wordl");
        System.out.print("hello test");
        
        // variabel 
        var x = 3;
        var y = 1;
        String nama = "eko";
        System.out.println(x + y);
        
        // kondisional
//        if(x+y == 8){
//            System.out.println("benar");
//        }else if(x+y == 4){
//            System.out.println("hasil 4 nih");
//        }else{
//            System.out.println(nama);
//        }
        
//        switch (x+y) {
//            case 8:
//                System.out.println("benar");
//                break;
//            case 4:
//                System.out.println("hasil 4 nih");
//                break;
//            default:
//                System.out.println(nama);
//                break;
//        }

        switch (x+y) {
            case 8 -> System.out.println("benar");
            case 4 -> System.out.println("hasil 4 nih");
            default -> System.out.println(nama);
        }
        
//        Perulangan
//        for( int i = 0; i <10; i++){
//            System.out.println("cetak 10x");
//        }
        
        int j = 0;
//        while(j<10){
//            System.out.println("cetak 10x");
//            j++;
//        }
        
        do{
            System.out.println("cetak 10x");
            j++;
        }while(j<10);
        
    }
    
}
