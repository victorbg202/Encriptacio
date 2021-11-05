import java.util.ArrayList;
import java.util.Arrays;
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
				System.out.print("Introdueix un codi per xifrar (numero): ");
				int codi = sc.nextInt();
				historial.add("1 " + codi);
				xifratTextCesar(MissatgeModificat, codi);
				rentarPantalla();
				IntroduirOpcioMenuEncriptacio();
			} else if (opcio == 2) {
				rentarPantalla();
				System.out.print("Introdueix un codi per desxifrar (numero): ");
				int codi = sc.nextInt();
				historial.add("2 " + codi);
				desxifratTextCesar(MissatgeModificat, codi);
				rentarPantalla();
				IntroduirOpcioMenuEncriptacio();
			} else if (opcio == 3) {
				rentarPantalla();
				System.out.print("Introdueix un codi per xifrar (paraula): ");
				String codi = sc.next();
				historial.add("3 " + codi);
				xifrarTextMonoalfabetic(codi);
				rentarPantalla();
				IntroduirOpcioMenuEncriptacio();
			} else if (opcio == 4) {
				rentarPantalla();
				System.out.print("Introdueix un codi per xifrar (paraula): ");
				String codi = sc.next();
				historial.add("4 " + codi);
				desxifrarTextMonoalfabetic(codi);
				rentarPantalla();
				IntroduirOpcioMenuEncriptacio();
			} else if (opcio == 5) {
				rentarPantalla();
				System.out.print("Introdueix un codi per xifrar (paraula): ");
				String codi = sc.next();
				historial.add("5 " + codi);
				xifrarTextNumeric(codi);
				rentarPantalla();
				IntroduirOpcioMenuEncriptacio();
			} else if (opcio == 6) {
				rentarPantalla();
				System.out.print("Introdueix un codi per xifrar (paraula): ");
				String codi = sc.next();
				historial.add("6 " + codi);
				desxifrarTextNumeric(codi);
				rentarPantalla();
				IntroduirOpcioMenuEncriptacio();
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

	// Desencriptar tot seguint l'historial
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
			} else if (Integer.parseInt(accioSplit[0]) == 3) {
				desxifrarTextMonoalfabetic(accioSplit[1]);
			} else if (Integer.parseInt(accioSplit[0]) == 4) {
				xifrarTextMonoalfabetic(accioSplit[1]);
			} else if (Integer.parseInt(accioSplit[0]) == 5) {
				desxifrarTextNumeric(accioSplit[1]);
			} else if (Integer.parseInt(accioSplit[0]) == 6) {
				xifrarTextNumeric(accioSplit[1]);
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
	public static void desxifrarTextMonoalfabetic(String codi) {
		// Creem l'alfabet desordenat
		String alfaMonoDesordenat = "";
		alfaMonoDesordenat = crearAlfabetMono(codi);

		// Desxifrar missatge
		String[] splitMissatgeMod = MissatgeModificat.split("");
		String xifratMono = "";
		int posAlfaO = 0;

		for (int i = 0; i < splitMissatgeMod.length; i++) {
			String letra = splitMissatgeMod[i];

			// Obtener posicion en el alfabeto original
			for (int j = 0; j < alfaMonoDesordenat.length(); j++) {
				//
				System.out.println(String.valueOf(alfaMonoDesordenat.charAt(j)) + " ---- " + letra);
				if (String.valueOf(alfaMonoDesordenat.charAt(j)).equals(letra)) {
					System.out.println("ok");
					posAlfaO = j;
					xifratMono += Alfabet.get(posAlfaO).toString();
				}
			}
		}

		MissatgeModificat = xifratMono;

		rentarPantalla();
		IntroduirOpcioMenuEncriptacio();
	}

	// Metode per xifrar MONOALFABETIC
	public static void xifrarTextMonoalfabetic(String codi) {
		// Creem l'alfabet desordenat
		String alfaMonoDesordenat = "";
		alfaMonoDesordenat = crearAlfabetMono(codi);

		// Xifrar missatge
		String[] splitMissatgeMod = MissatgeModificat.split("");
		String xifratMono = "";
		int posAlfaO = 0;

		//
		for (int i = 0; i < splitMissatgeMod.length; i++) {
			String letra = splitMissatgeMod[i];

			// Obtener posicion en el alfabeto original
			for (int j = 0; j < Alfabet.size(); j++) {
				//
				if (letra.equals(Alfabet.get(j).toString())) {
					posAlfaO = j;
					xifratMono += alfaMonoDesordenat.charAt(posAlfaO);
				}
			}
		}

		MissatgeModificat = xifratMono;

	}

	// Metode per desxifrar NUMERIC
	public static void desxifrarTextNumeric(String codi) {// S'extreuen els caracters duplicats i s'afegeix el missatge
															// a continuacio
		String codiMissatge = codi;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < codiMissatge.length(); i++) {
			if (codiMissatge.indexOf(codiMissatge.charAt(i)) == i) {
				// Primera impresión
				sb.append(codiMissatge.charAt(i));
			}

		}
		codiMissatge = sb.toString() + MissatgeModificat;

		// Generem la matriu amb l'alfabet
		String mAlfabetNum[][] = new String[1 + (codiMissatge.length() / sb.toString().length())][sb.toString()
				.length()];
		// Emplenem la matriu
		String[] arrayAlfaNum = codiMissatge.split("");

		int cont = 0;
		for (int i = 0; i < mAlfabetNum.length; i++) {
			for (int j = 0; j < mAlfabetNum[i].length; j++) {
				if (cont < arrayAlfaNum.length) {
					mAlfabetNum[i][j] = arrayAlfaNum[cont++];
				} else {
					mAlfabetNum[i][j] = "";
					cont++;
				}
			}
		}

		// Reordenem l'alfabet ordenant les columnes alfabeticament per la primera
		// lletra
		String mAlfabetNumFinal[][] = new String[1 + (codiMissatge.length() / sb.toString().length())][sb.toString()
				.length()];

		String letras[] = new String[sb.toString().length()];

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < mAlfabetNum[i].length; j++) {
				if (!(mAlfabetNum[0][j].equals(null))) {
					letras[j] = mAlfabetNum[0][j];
				}

			}
		}

		// Ordenem l'array de la primera fila
		Arrays.sort(letras);

		// Generem l'array reordenat


		// Recorrem les primeres lletres de l'array original
		for (int i = 0; i < sb.toString().length(); i++) {
			// Recorrem l'array amb les primeres lletres ordenades
			for (int j = 0; j < letras.length; j++) {
				if (mAlfabetNum[0][i].equals(letras[j])) {
					System.out.println("Letra original" + mAlfabetNum[0][i] + "letra ordenada" + letras[j]);
					// Guardem aquella fila a la posicio que correspon a l'array ordenat
					for (int j2 = 0; j2 < (1 + (codiMissatge.length() / sb.toString().length())); j2++) {
						for (int j3 = 0; j3 < sb.toString().length(); j3++) {
							//mAlfabetNumFinal[j2][j] = mAlfabetNum[j2][i];
						}
					}
					
				}

			}
		}
		


		// Recorrem l'array per columes i guardem el missatge
		String missatgeFinal = "";

		for (int i = 0; i < sb.toString().length(); i++)
			for (int j = 0; j < (1 + (codiMissatge.length() / sb.toString().length())); j++) {
				missatgeFinal += mAlfabetNumFinal[j][i];
			}

		// Resultat
		MissatgeModificat = missatgeFinal;
		rentarPantalla();
		IntroduirOpcioMenuEncriptacio();
	}

	// Metode per xifrar NUMERIC
	public static void xifrarTextNumeric(String codi) {
		// S'extreuen els caracters duplicats i s'afegeix el missatge a continuacio
		String codiMissatge = codi;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < codiMissatge.length(); i++) {
			if (codiMissatge.indexOf(codiMissatge.charAt(i)) == i) {
				// Primera impresión
				sb.append(codiMissatge.charAt(i));
			}

		}
		codiMissatge = sb.toString() + MissatgeModificat;

		// Generem la matriu amb l'alfabet
		String mAlfabetNum[][] = new String[1 + (codiMissatge.length() / sb.toString().length())][sb.toString()
				.length()];
		// Emplenem la matriu
		String[] arrayAlfaNum = codiMissatge.split("");

		int cont = 0;
		for (int i = 0; i < mAlfabetNum.length; i++) {
			for (int j = 0; j < mAlfabetNum[i].length; j++) {
				if (cont < arrayAlfaNum.length) {
					mAlfabetNum[i][j] = arrayAlfaNum[cont++];
				} else {
					mAlfabetNum[i][j] = "";
					cont++;
				}
				// System.out.print(mAlfabetNum[i][j] + " ");
			}
			// System.out.println();
		}

		// Reordenem l'alfabet ordenant les columnes alfabeticament per la primera
		// lletra
		String mAlfabetNumFinal[][] = new String[1 + (codiMissatge.length() / sb.toString().length())][sb.toString()
				.length()];

		String letras[] = new String[sb.toString().length()];

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < mAlfabetNum[i].length; j++) {
				if (!(mAlfabetNum[0][j].equals(null))) {
					letras[j] = mAlfabetNum[0][j];
				}

			}
		}

		// Ordenem l'array de la primera fila
		Arrays.sort(letras);

		// Generem l'array reordenat

		// Recorrem l'array amb les primeres lletres ordenades
		for (int i = 0; i < letras.length; i++) {
			// Recorrem les primeres lletres de l'array original
			for (int j = 0; j < sb.toString().length(); j++) {

				if (letras[i].equals(mAlfabetNum[0][j])) {
					// Guardem aquella fila a la posicio que correspon a l'array ordenat
					for (int j2 = 0; j2 < mAlfabetNum.length; j2++) {
						for (int j3 = 0; j3 < mAlfabetNum[j2].length; j3++) {
							mAlfabetNumFinal[j2][i] = mAlfabetNum[j2][j];
						}
					}
				}

			}
		}

		// Recorrem l'array per columes i guardem el missatge
		String missatgeFinal = "";

		for (int i = 0; i < sb.toString().length(); i++)
			for (int j = 0; j < (1 + (codiMissatge.length() / sb.toString().length())); j++) {
				missatgeFinal += mAlfabetNumFinal[j][i];
			}

		// Resultat
		MissatgeModificat = missatgeFinal;
		rentarPantalla();
		IntroduirOpcioMenuEncriptacio();
	}

	// Generem l'alfabet desordenat
	public static String crearAlfabetMono(String codi) {
		// S'extreuen els caracters duplicats i s'afegeix l'alfabet a continuació
		String alfabetMono = "";

		for (int i = 0; i < Alfabet.size(); i++) {

			alfabetMono += codi + Alfabet.get(i).charValue();
		}

		alfabetMono = AlfabetClau(alfabetMono);

		// Obtenim el codi sense duplicades
		String codiSenseDuplicades = codi;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < codiSenseDuplicades.length(); i++) {
			if (codiSenseDuplicades.indexOf(codiSenseDuplicades.charAt(i)) == i) {
				// Primera impresión
				sb.append(codiSenseDuplicades.charAt(i));
			}

		}
		codiSenseDuplicades = sb.toString();

		// Creem la matriu per reordenarla
		int filas = 1 + (Alfabet.size() / codiSenseDuplicades.length());
		int columnas = codiSenseDuplicades.length();

		String[][] mAlfabetMono = new String[filas][columnas];

		// Emplenem la matriu
		String[] arrayAlfaMono = alfabetMono.split("");

		int cont = 0;
		for (int i = 0; i < mAlfabetMono.length; i++) {
			for (int j = 0; j < mAlfabetMono[i].length; j++) {
				if (cont < arrayAlfaMono.length) {
					mAlfabetMono[i][j] = arrayAlfaMono[cont++];
				} else {
					mAlfabetMono[i][j] = "";
					cont++;
				}
				// System.out.print(mAlfabetMono[i][j] + " ");
			}
			// System.out.println();
		}

		// Guardem l'alfabet desordenat
		String alfaMonoDesordenat = "";

		for (int i = 0; i < mAlfabetMono[i].length; i++) {
			for (int j = 0; j < mAlfabetMono.length; j++) {
				alfaMonoDesordenat = alfaMonoDesordenat + mAlfabetMono[j][i];
			}
		}

		return alfaMonoDesordenat;
	}

	// Generar alfabet amb clau+alfabet traient els caracters duplicats
	public static String AlfabetClau(String clau) {
		String str = "";

		for (int i = 0; i < Alfabet.size(); i++) {
			str += clau + Alfabet.get(i).charValue();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.indexOf(str.charAt(i)) == i) {
				// Primera impresión
				sb.append(str.charAt(i));
			}

		}
		String result = sb.toString();
		return result;
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
