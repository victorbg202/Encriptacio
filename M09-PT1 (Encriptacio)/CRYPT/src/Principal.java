public class Principal extends Crypt {

public static void main(String[] args) {
		//Variables
		String comando;
        int estat = 0;
		IntroduirEstat(estat);
        //Tancar teclat
        sc.close();
    }

	//Introduir estat
	public static int IntroduirEstat(int estat) {
        do {
        	//Introduiir estat
			OpcionesMenu();
			estat=sc.nextInt();
        	
			//entar comanda
        	switch (estat) {
				case 0:
					System.out.println("Ha sido un placer!");
					break;
				case 1:
					entrarMissatge();
									
					break;
			}

		} while (estat!=0);
        while (estat!=1);
		return estat;
	}

	public static void OpcionesMenu(){
		System.out.println(" \t\t ----------------------------------");
		System.out.println("\t\t||"+"*****"+"||"+"  MENU PRINCIPAL  "+"||"+"*****"+"||");
		System.out.println("\t\t ----------------------------------");
		System.out.println("\t\t||                                ||");
		System.out.println("\t\t||    "+"************************"+"    ||");
		System.out.println("\t\t||  //                        \\\\  ||");
		System.out.println("\t\t|| ||        "+"1) INICIAR"+"        || ||");
		System.out.println("\t\t|| ||        "+"0) SALIR"+"          || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t||   "+"**************************"+"   ||");
		System.out.println("\t\t||                                ||");
		System.out.println("\t\t ----------------------------------");
		System.out.print("Introduce que opción vas a escojer:");
	}
    
}


