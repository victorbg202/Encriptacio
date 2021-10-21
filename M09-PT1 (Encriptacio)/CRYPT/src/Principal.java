import java.util.Scanner;

public class Principal extends Crypt {

public static void main(String[] args) {
		//Variables
	    sc = new Scanner(System.in);
	    
	    //Funcionamiento
        setAlfabeto();
        rentarPantalla();
        IntroduirOpcioMenuPrincipal();
		sc.close();
    }

	//Introduir opcions menu principal
	public static void IntroduirOpcioMenuPrincipal() {
		//Introduiir estat
		MenuOpcionsPrincipal();
		int opcio = 0;
		do {
			opcio = introduirNum(opcio);
			if (opcio == 1) {
				entrarMissatge();
				IntroduirOpcioMenuEncriptacio();
			} else if (opcio == 0) {
				Sotir();
			} else {
				System.out.print("Introdueix una opcio valida (1-0): ");
			}
		} while (opcio != 0 && opcio != 1);
	}
	
	
	// Mostrar menu principal
	public static void MenuOpcionsPrincipal(){
		System.out.println(" \t\t ----------------------------------");
		System.out.println("\t\t||"+"*****"+"||"+"  MENU PRINCIPAL  "+"||"+"*****"+"||");
		System.out.println("\t\t ----------------------------------");
		System.out.println("\t\t||                                ||");
		System.out.println("\t\t||    "+"************************"+"    ||");
		System.out.println("\t\t||  //                        \\\\  ||");
		System.out.println("\t\t|| ||        "+"1) INICIAR"+"        || ||");
		System.out.println("\t\t|| ||        "+"0) SORTIR"+"         || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t||   "+"**************************"+"   ||");
		System.out.println("\t\t||                                ||");
		System.out.println("\t\t ----------------------------------");
		System.out.println();
		System.out.print("Introduce que opcion vas a escojer:");
	}
    
}


