import java.util.ArrayList;
import java.util.Scanner;

public class Crypt {
	public static final Scanner sc = new Scanner(System.in);
	public static String MissatgeOriginal = "";

	public static void main(String[] args) {
		//Atributs
		String Alfabet;
		String MissatgeModificat;
		ArrayList<String> Historial = new ArrayList<String>();
	}
	
	//Entrar missatge
	public static String entrarMissatge() {
		//Introduir el text a xifrar
        do {
            System.out.print("Introdueix un text: ");
            MissatgeOriginal = sc.nextLine();
        } while (MissatgeOriginal.isEmpty());        
		return MissatgeOriginal;
	}
	
	//Mostrar missatgeModificat
	
	//Mostrar missatgeOriginal
	
	//Sortir
	

	// Metode per xifrar CESAR
	public static String xifratTextCesar(String text, int codi) {
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
		return xifrat.toString();
	}

	// Metode per desxifrar CESAR
	public static String desxifratTextCesar(String text, int codi) {
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
		return xifrat.toString();
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

}
