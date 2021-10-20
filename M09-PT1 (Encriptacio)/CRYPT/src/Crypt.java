import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Crypt {
	// Atributs globals
	public static Scanner sc;
	public static String MissatgeOriginal;
	public static String MissatgeModificat;
	static ArrayList<String> historial = new ArrayList<String>();
	static ArrayList<Character> Alfabet = new ArrayList<Character>();

	// Entrar missatge
	public static void entrarMissatge() {
		// Introduir el text a xifrar
		do {
			System.out.print("Introdueix un text per encriptar/desencriptar:");
			MissatgeOriginal = sc.next();
			MissatgeModificat = MissatgeOriginal;
		} while (MissatgeOriginal.isEmpty());
		rentarPantalla();
	}

	// Introduir opcions menu encriptacio
	public static void IntroduirOpcioMenuEncriptacio() {
		// Introduiir estat
		MenuOpcionsEncriptacio();
		int opcio = 0;
		do {
			opcio = introduirNum(opcio);
			if (opcio == 1) {
				rentarPantalla();
				System.out.print("Introdueix un codi per xifrar: ");
				int codi = sc.nextInt();
				historial.add("1 " + codi);
				xifratTextCesar(MissatgeModificat, codi);
				rentarPantalla();
				IntroduirOpcioMenuEncriptacio();
			} else if (opcio == 2) {
				rentarPantalla();
				System.out.print("Introdueix un codi per desxifrar: ");
				int codi = sc.nextInt();
				historial.add("2 " + codi);
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
			} else if (opcio == 10) {
				rentarPantalla();
				mostrarAlfabet();
			} else if (opcio == 0) {
				historial.clear();
				rentarPantalla();
				Principal.IntroduirOpcioMenuPrincipal();
			} else {
				System.out.print("Introdueix una opcio valida (0-10): ");
			}
			System.out.println();

		} while (opcio < 0 || opcio > 10);

	}

	// Inicializar alfabeto
	public static void setAlfabeto() {
		// Letras
		for (int i = 'a'; i <= 'z'; i++) {
			Alfabet.add((char) i);
		}
		for (int i = 'A'; i <= 'Z'; i++) {
			Alfabet.add((char) i);
		}

		// Numeros
		char element1 = '0';
		for (int i = 0; i < 10; i++) {
			Alfabet.add(element1);
			element1 += 1;
		}

		// ?!.,_
		Alfabet.add('?');
		Alfabet.add('!');
		Alfabet.add('.');
		Alfabet.add(',');
		Alfabet.add('_');
	}

	// Mostrar menu encriptacio
	public static void MenuOpcionsEncriptacio() {
		System.out.println(" \t\t ----------------------------------");
		System.out.println("\t\t||" + "*****" + "||" + "  MENU PRINCIPAL  " + "||" + "*****" + "||");
		System.out.println("\t\t ----------------------------------");
		System.out.println("\t\t||                                ||");
		System.out.println("\t\t||    " + "************************" + "    ||");
		System.out.println("\t\t||  //                        \\\\  ||");
		System.out.println("\t\t|| ||        " + "1) E. Cesar" + "       || ||");
		System.out.println("\t\t|| ||        " + "2) D. Cesar" + "       || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||    " + "3) E. Monoalfabetic" + "   || ||");
		System.out.println("\t\t|| ||    " + "4) D. Monoalfabetic" + "   || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||       " + "5) E. Numeric" + "      || ||");
		System.out.println("\t\t|| ||       " + "6) D. Numeric" + "      || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||        " + "7) D. TOTAL " + "      || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||   " + "8) Missatge Original" + "   || ||");
		System.out.println("\t\t|| ||     " + "9) Missatge Actual" + "   || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||     " + "10) Ver alfabeto " + "    || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||        " + "0) ENRERE" + "         || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t||   " + "**************************" + "   ||");
		System.out.println("\t\t||                                ||");
		System.out.println("\t\t ----------------------------------");
		System.out.println();
		System.out.print("Introduce que opcion vas a escojer:");
	}

	// Mostrar missatgeModificat
	public static void mostrarMissatgeModificat() {
		System.out.println("Aquest es el missatge actual: " + MissatgeModificat + "\n\n");
		IntroduirOpcioMenuEncriptacio();
	}

	// Mostrar missatgeOriginal
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

	// Mostrar alfabet
	public static void mostrarAlfabet() {
		for (int i = 0; i < Alfabet.size(); i++) {
			System.out.print(Alfabet.get(i).charValue());
		}
		System.out.println("\n\n");

		IntroduirOpcioMenuEncriptacio();
	}

	// Sortir
	public static void Sotir() {
		sc.close();
		System.out.println("Ha sido un placer!");
	}

	// Xifrar text CESAR
	static void xifratTextCesar(String str, int key) {
		String result = "";
		key = key % Alfabet.size();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int index = Alfabet.indexOf(c);
			if (Alfabet.size() - Alfabet.indexOf(c) <= key) {
				index = Alfabet.indexOf(c) - Alfabet.size();
				c = (char) Alfabet.get(index + key);
			} else {
				c = (char) Alfabet.get(index + key);
			}
			result += c;
		}
		MissatgeModificat = result;
	}

	// Desxifrar text CESAR
	static void desxifratTextCesar(String str, int key1) {
		String result = "";
		key1 = key1 % Alfabet.size();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int index = Alfabet.indexOf(c);
			if (Alfabet.indexOf(c) < key1) {
				index = Alfabet.indexOf(c) + Alfabet.size();
				c = (char) Alfabet.get(index - key1);
			} else {
				c = (char) Alfabet.get(index - key1);
			}
			result = result + c;
		}
		MissatgeModificat = result;
	}

	// Metode per desxifrar MONOALFABETIC
	public static String desxifrarTextMonoalfabetic(String text) {
		StringBuilder xifrat = new StringBuilder();

		// historial.add("3 "+codi);

		rentarPantalla();
		IntroduirOpcioMenuEncriptacio();

		return xifrat.toString();
	}

	// Metode per xifrar MONOALFABETIC
	public static String xifrarTextMonoalfabetic(String text) {
		StringBuilder xifrat = new StringBuilder();

		// historial.add("4 "+codi);

		rentarPantalla();
		IntroduirOpcioMenuEncriptacio();

		return xifrat.toString();
	}

	// Metode per desxifrar NUMERIC
	public static String desxifrarTextNumeric(String text) {
		StringBuilder xifrat = new StringBuilder();

		// historial.add("5 "+codi);

		rentarPantalla();
		IntroduirOpcioMenuEncriptacio();

		return xifrat.toString();
	}

	// Metode per xifrar NUMERIC
	public static String xifrarTextNumeric(String text) {
		StringBuilder xifrat = new StringBuilder();

		// historial.add("6 "+codi);

		rentarPantalla();
		IntroduirOpcioMenuEncriptacio();

		return xifrat.toString();
	}

	// Rentar pantalla
	public static void rentarPantalla() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	// Introduir un numero
	public static int introduirNum(int num) {
		try {
			num = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Error s'ha d'introduir un numero");
		}
		return num;
	}

}
