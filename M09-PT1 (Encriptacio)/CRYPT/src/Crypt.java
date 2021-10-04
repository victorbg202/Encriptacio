import java.util.ArrayList;
import java.util.Scanner;

public class Crypt {
	//Atributs globals
	public static Scanner sc;
	public static String MissatgeOriginal;
	static String Alfabet;
	public static String MissatgeModificat;
	static ArrayList<int[]> historial=new ArrayList<int[]>();

//int a1[]={1,2,3};
//arl.add(0,a1);
//System.out.println("Arraylist contains:"+arl.get(0));

	//Entrar missatge
	public static void entrarMissatge() {
		//Introduir el text a xifrar
        do {
        	System.out.print("Introdueix un text per encriptar/desencriptar:");
            MissatgeOriginal = sc.next();
            MissatgeModificat = MissatgeOriginal;
        } while (MissatgeOriginal.isEmpty());  
        rentarPantalla();
	}
	
	//Introduir opcions menu encriptacio
	public static void IntroduirOpcioMenuEncriptacio() {
		//Introduiir estat
		MenuOpcionsEncriptacio();	
		int opcio = 0;
		do {
			opcio = introduirNum(opcio);
			if (opcio == 1) {
				rentarPantalla();
				xifratTextCesar(MissatgeModificat);
			} else if (opcio == 2) {
				rentarPantalla();
				desxifratTextCesar(MissatgeModificat);
			} else if (opcio == 3) {
				
			} else if (opcio == 4) {
				
			} else if (opcio == 5) {
				
			} else if (opcio == 6) {
				
			} else if (opcio == 7) {
				rentarPantalla();
				mostrarMissatgeOriginal();
			} else if (opcio == 8) {
				rentarPantalla();
				mostrarMissatgeModificat();
			} else if (opcio == 0) {
				rentarPantalla();
				Principal.IntroduirOpcioMenuPrincipal();
			} else {
				System.out.print("Introdueix una opcio valida (0-8): ");
			}
			
		} while (opcio < 0 || opcio > 6);
		
	}
	

	
	// Mostrar menu encriptacio
	public static void MenuOpcionsEncriptacio(){
		System.out.println(" \t\t ----------------------------------");
		System.out.println("\t\t||"+"*****"+"||"+"  MENU PRINCIPAL  "+"||"+"*****"+"||");
		System.out.println("\t\t ----------------------------------");
		System.out.println("\t\t||                                ||");
		System.out.println("\t\t||    "+"************************"+"    ||");
		System.out.println("\t\t||  //                        \\\\  ||");
		System.out.println("\t\t|| ||        "+"1) E. Cesar"+"       || ||");
		System.out.println("\t\t|| ||        "+"2) D. Cesar"+"       || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||    "+"3) E. Monoalfabetic"+"   || ||");
		System.out.println("\t\t|| ||    "+"4) D. Monoalfabetic"+"   || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||       "+"5) E. Numeric"+"      || ||");
		System.out.println("\t\t|| ||       "+"6) D. Numeric"+"      || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||   "+"7) Missatge Original"+"   || ||");
		System.out.println("\t\t|| ||     "+"8) Missatge Actual"+"   || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||        "+"0) ENRERE"+"         || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t||   "+"**************************"+"   ||");
		System.out.println("\t\t||                                ||");
		System.out.println("\t\t ----------------------------------");
		System.out.print("Introduce que opcion vas a escojer:");
	}
	
	//Mostrar missatgeModificat
	public static void mostrarMissatgeModificat() {
		System.out.println("Aquest es el missatge actual: " + MissatgeModificat + "\n\n");
		IntroduirOpcioMenuEncriptacio();		
	}
	
	//Mostrar missatgeOriginal
	public static void mostrarMissatgeOriginal() {
		System.out.println("Aquest es el missatge original: " + MissatgeOriginal + "\n\n");
		IntroduirOpcioMenuEncriptacio();
	}
	
	//Desencriptar tot seguint l'historial
	public static String desencriptarTotal() {
		
		return MissatgeOriginal;
	}
	
	//Mostrar alfabet
	public static String mostrarAlfabet() {
		return Alfabet;
	}
	
	//Sortir
	public static void Sotir() {
		System.out.println("Ha sido un placer!");
	}
	

	// Metode per xifrar CESAR
	public static void xifratTextCesar(String text) {
		System.out.print("Introdueix un codi per xifrar: ");
		int codi = sc.nextInt();
		StringBuilder xifrat = new StringBuilder();
		codi = codi % 26;

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
				if ((text.charAt(i) + codi) > 'z') {
					xifrat.append((char) (text.charAt(i) + codi - 26));
				} else {
					xifrat.append((char) (text.charAt(i) + codi));
				}
			} else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
				if ((text.charAt(i) + codi) > 'Z') {
					xifrat.append((char) (text.charAt(i) + codi - 26));
				} else {
					xifrat.append((char) (text.charAt(i) + codi));
				}
			}
		}
		MissatgeModificat = xifrat.toString();
		

		int accio[]={1, codi};
		historial.add(accio);

		rentarPantalla();
		IntroduirOpcioMenuEncriptacio();
	}

	// Metode per desxifrar CESAR
	public static void desxifratTextCesar(String text) {
		System.out.print("Introdueix un codi per desxifrar: ");
		int codi = sc.nextInt();
		StringBuilder xifrat = new StringBuilder();
		codi = codi % 26;

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
				if ((text.charAt(i) - codi) < 'a') {
					xifrat.append((char) (text.charAt(i) - codi + 26));
				} else {
					xifrat.append((char) (text.charAt(i) - codi));
				}
			} else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
				if ((text.charAt(i) - codi) < 'A') {
					xifrat.append((char) (text.charAt(i) - codi + 26));
				} else {
					xifrat.append((char) (text.charAt(i) - codi));
				}
			}
		}
		MissatgeModificat = xifrat.toString();
		
		int accio[]={2, codi};
		historial.add(accio);

		rentarPantalla();
		IntroduirOpcioMenuEncriptacio();
	}

	// Metode per desxifrar MONOALFABETIC
	public static String desxifrarTextMonoalfabetic(String text) {
		StringBuilder xifrat = new StringBuilder();

		return xifrat.toString();
	}

	// Metode per xifrar MONOALFABETIC
	public static String xifrarTextMonoalfabetic(String text) {
		StringBuilder xifrat = new StringBuilder();

		return xifrat.toString();
	}
	
	// Metode per desxifrar NUMERIC
	public static String desxifrarTextNumeric(String text) {
		StringBuilder xifrat = new StringBuilder();

		return xifrat.toString();
	}

	// Metode per xifrar NUMERIC
	public static String xifrarTextNumeric(String text) {
		StringBuilder xifrat = new StringBuilder();

		return xifrat.toString();
	}
	
	//Rentar pantalla
	public static void rentarPantalla() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
	
	// Introduir un numero
	public static int introduirNum(int num) {
		try {
			num=sc.nextInt();			
		} catch (Exception e) {
			System.out.println("Error s'ha d'introduir un numero");
		}
		return num;		
	}

}
