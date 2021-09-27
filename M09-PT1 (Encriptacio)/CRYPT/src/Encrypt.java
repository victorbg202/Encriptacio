import java.io.IOException;

public class Encrypt extends Crypt {

public static void main(String[] args) {
		//Variables
		String comando;
        int estat;
        
        //Introduir estat
        do {
			//entar comanda
        	switch (key) {
			case value: {
				
				yield type;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
		} while (estat!=0);
        
        //Introduir missatge
        entrarMissatge();
        

        //Tancar teclat
        sc.close();
        
//        //Introduir el codi de xifrat
//        do {
//            System.out.print("Introdueix el codi de xifrat: ");
//            codi = sc.nextInt();
//        } while (codi < 1);
        
//        //Introducir la operaci�n a realizar: cifrar o descifrar
//        do {
//            sc.nextLine();
//            System.out.print("(X) xifrar o (D) desxifrar?: ");
//            try {
//				opcio = (char) System.in.read();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        } while (Character.toUpperCase(opcio) != 'X' && Character.toUpperCase(opcio) != 'D');    
        
        
//        //Xifrar o desxifrar
//        if (Character.toUpperCase(opcio) == 'X') {
//            System.out.println("Text xifrat: " + xifratTextCesar(text, codi));
//        } else {
//            System.out.println("Text desxifrat: " + desxifratTextCesar(text, codi));
//        }
    }
    
}


