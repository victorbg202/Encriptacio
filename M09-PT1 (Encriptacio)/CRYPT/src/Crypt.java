import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Crypt {
	//Atributs globals
	public static Scanner sc;
	public static String MissatgeOriginal;
	static String Alfabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?!.,_";
	public static String MissatgeModificat;
	static ArrayList<String> historial=new ArrayList<String>();

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
				System.out.print("Introdueix un codi per xifrar: ");
				int codi = sc.nextInt();
				historial.add("1 "+codi);
				xifratTextCesar(MissatgeModificat, codi);
				rentarPantalla();
				IntroduirOpcioMenuEncriptacio();
			} else if (opcio == 2) {
				rentarPantalla();
				System.out.print("Introdueix un codi per desxifrar: ");
				int codi = sc.nextInt();
				historial.add("2 "+codi);
				desxifratTextCesar(MissatgeModificat, codi);
				rentarPantalla();
				IntroduirOpcioMenuEncriptacio();
			} else if (opcio == 3) {
				
			} else if (opcio == 4) {
				
			} else if (opcio == 5) {
				
			} else if (opcio == 6) {
				
			} else if (opcio == 7) {
				rentarPantalla();
				desencriptarTotal();
			} else if (opcio == 8) {
				rentarPantalla();
				mostrarMissatgeOriginal();
			} else if (opcio == 9) {
				rentarPantalla();
				mostrarMissatgeModificat();
			} else if (opcio == 0) {
				historial.clear();
				rentarPantalla();
				Principal.IntroduirOpcioMenuPrincipal();
			} else {
				System.out.print("Introdueix una opcio valida (0-8): ");
			}
			
		} while (opcio < 0 || opcio > 7);
		
	}
	

	
	// Mostrar menu encriptacio
	public static void MenuOpcionsEncriptacio(){
		
		for(int i = 0; i < historial.size(); i++) {   
		    System.out.println(historial.get(i).toString());
		}  
		
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
		System.out.println("\t\t|| ||        "+"7) D. TOTAL "+"      || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||   "+"8) Missatge Original"+"   || ||");
		System.out.println("\t\t|| ||     "+"9) Missatge Actual"+"   || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||        "+"0) ENRERE"+"         || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t||   "+"**************************"+"   ||");
		System.out.println("\t\t||                                ||");
		System.out.println("\t\t ----------------------------------");
		System.out.println();
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
	public static void desencriptarTotal() {
		String accio = "";
		Collections.reverse(historial); 
		for (int i = 0; i < historial.size(); i++) {
			accio = historial.get(i).toString();
			String[] accioSplit = accio.split("\\s+");
			if (Integer.parseInt(accioSplit[0]) == 1) {
				desxifratTextCesar(MissatgeModificat, Integer.parseInt(accioSplit[1]));
			} else if (Integer.parseInt(accioSplit[0]) == 2) {
				xifratTextCesar(MissatgeModificat, Integer.parseInt(accioSplit[1]));
			}
		}
		historial.clear();
		IntroduirOpcioMenuEncriptacio();
	}
	
	//Mostrar alfabet
	public static String mostrarAlfabet() {
		return Alfabet;
	}
	
	//Sortir
	public static void Sotir() {
		sc.close();
		System.out.println("Ha sido un placer!");
	}
	

	// Metode per xifrar CESAR
//	public static void xifratTextCesar(String text, int codi) {
//		StringBuilder xifrat = new StringBuilder();
//		codi = codi % 26;
//
//		for (int i = 0; i < text.length(); i++) {
//			if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
//				if ((text.charAt(i) + codi) > 'z') {
//					xifrat.append((char) (text.charAt(i) + codi - 26));
//				} else {
//					xifrat.append((char) (text.charAt(i) + codi));
//				}
//			} else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
//				if ((text.charAt(i) + codi) > 'Z') {
//					xifrat.append((char) (text.charAt(i) + codi - 26));
//				} else {
//					xifrat.append((char) (text.charAt(i) + codi));
//				}
//			}
//		}
//		MissatgeModificat = xifrat.toString();
//	}
	
	public static void xifratTextCesar(String cadena,int codi) {
        String cadenaCod="";
        for (int i = 0; i < cadena.length() ; i++) {
            for (int j=0; j < Alfabet.length(); j++) {
                if (cadena.charAt(i)==Alfabet.charAt(j)) {
                    cadenaCod+=Alfabet.charAt((j+codi)%Alfabet.length());
                }
            }
        }
        MissatgeModificat=cadenaCod;
    }

//	// Metode per desxifrar CESAR
//	public static void desxifratTextCesar(String text, int codi) {
//		StringBuilder xifrat = new StringBuilder();
//		codi = codi % 26;
//
//		for (int i = 0; i < text.length(); i++) {
//			if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
//				if ((text.charAt(i) - codi) < 'a') {
//					xifrat.append((char) (text.charAt(i) - codi + 26));
//				} else {
//					xifrat.append((char) (text.charAt(i) - codi));
//				}
//			} else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
//				if ((text.charAt(i) - codi) < 'A') {
//					xifrat.append((char) (text.charAt(i) - codi + 26));
//				} else {
//					xifrat.append((char) (text.charAt(i) - codi));
//				}
//			}
//		}
//		MissatgeModificat = xifrat.toString();
//	
//	public String Desencriptar(String t, int key){        
//        String texto = LimpiarCadena(t);
//        String res = "";        
//        for(int i = 0; i < texto.length();i++)
//        {            
//            int pos = tabla.indexOf(texto.charAt(i));            
//            if ((pos - key) < 0){
//                res = res + tabla.charAt((pos-key) + tabla.length());
//            }
//            else
//            {
//                res = res + tabla.charAt(pos-key);
//            }         
//        }        
//        return res;
//    }
//	}
	
	public static void desxifratTextCesar(String cadena,int codi) {
        String cadenaCod="";
        //
        String abcInvertido = "";
		// Recorremos la original del final al inicio
		for (int indice = cadena.length() - 1; indice >= 0; indice--) {
			// Y vamos concatenando cada carácter a la nueva cadena
			abcInvertido += cadena.charAt(indice);
		}
		
        for (int i = 0; i < cadena.length() ; i++) {
            for (int j=0; j < Alfabet.length(); j++) {
                if (cadena.charAt(i)==Alfabet.charAt(j)) {
                    cadenaCod+=Alfabet.charAt((j-codi)%Alfabet.length());
                }
            }
        }
        MissatgeModificat=cadenaCod;
    }

	// Metode per desxifrar MONOALFABETIC
	public static String desxifrarTextMonoalfabetic(String text) {
		StringBuilder xifrat = new StringBuilder();
		
		//historial.add("3 "+codi);

		rentarPantalla();
		IntroduirOpcioMenuEncriptacio();

		return xifrat.toString();
	}

	// Metode per xifrar MONOALFABETIC
	public static String xifrarTextMonoalfabetic(String text) {
		StringBuilder xifrat = new StringBuilder();
		
		//historial.add("4 "+codi);

		rentarPantalla();
		IntroduirOpcioMenuEncriptacio();

		return xifrat.toString();
	}
	
	// Metode per desxifrar NUMERIC
	public static String desxifrarTextNumeric(String text) {
		StringBuilder xifrat = new StringBuilder();
		
		//historial.add("5 "+codi);

		rentarPantalla();
		IntroduirOpcioMenuEncriptacio();

		return xifrat.toString();
	}

	// Metode per xifrar NUMERIC
	public static String xifrarTextNumeric(String text) {
		StringBuilder xifrat = new StringBuilder();
		
		//historial.add("6 "+codi);

		rentarPantalla();
		IntroduirOpcioMenuEncriptacio();

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
