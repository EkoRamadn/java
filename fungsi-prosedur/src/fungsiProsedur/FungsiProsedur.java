package fungsiProsedur;

public class FungsiProsedur {

    public static void main(String[] args) {
        
//        static func
        funcStatic();
        
//        nonStatic func
        FungsiProsedur nonStatic = new FungsiProsedur();
        
        nonStatic.funcNonStatic();
    }
    
    static void funcStatic(){
        System.out.println("say hello1");
    }
    
    void funcNonStatic(){
        System.out.println("say hello2");
    }
    
}
