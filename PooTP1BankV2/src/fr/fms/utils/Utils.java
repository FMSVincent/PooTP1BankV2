package fr.fms.utils;

import java.util.Scanner;

public class Utils {
	// properties
	private static Scanner sc = new Scanner(System.in);
	static String[] menuMain = {"1 - Creer clients", "2 - Creer un compte client", "3 - Faire une transaction(versement, retrait, transfert)","4 - Afficher la liste des comptes", "5 - Afficher la liste des transactions", "6 - Quitter"};

	// methodes
	public static void displayMenu() {
		System.out.println("*****************************");
		System.out.println("\r\n"
				+ " |  \\/  |                 \r\n"
				+ " | \\  / | ___ _ __  _   _ \r\n"
				+ " | |\\/| |/ _ \\ '_ \\| | | |\r\n"
				+ " | |  | |  __/ | | | |_| |\r\n"
				+ " |_|  |_|\\___|_| |_|\\__,_|\r\n");
		for (String title : menuMain) {
			System.out.println(title);
		}
		System.out.println("*****************************");
	}
	
	public static void displayTitle() {
		System.out.println("  ____                  ____       _   ____                  _ \r\n"
				+ " / ___|__ _ ___  __ _  |  _ \\  ___| | |  _ \\ __ _ _ __   ___| |\r\n"
				+ "| |   / _` / __|/ _` | | | | |/ _ \\ | | |_) / _` | '_ \\ / _ \\ |\r\n"
				+ "| |__| (_| \\__ \\ (_| | | |_| |  __/ | |  __/ (_| | |_) |  __/ |\r\n"
				+ " \\____\\__,_|___/\\__,_| |____/ \\___|_| |_|   \\__,_| .__/ \\___|_|\r\n"
				+ "                                                 |_|           ");
		System.out.println(" ____              _    \r\n"
				+ "| __ )  __ _ _ __ | | __\r\n"
				+ "|  _ \\ / _` | '_ \\| |/ /\r\n"
				+ "| |_) | (_| | | | |   < \r\n"
				+ "|____/ \\__,_|_| |_|_|\\_\\");
	}
	
	/**
	 * Verif if input user is a int else err message and ask again
	 * @param message
	 * @param arr simple
	 * @return int
	 */
	static public int verifIfInt(String message, int min, int max) {
		while(!sc.hasNextInt()) {
			System.out.println("Doit etre un int");
			sc.next();
		}
		int inputUser = sc.nextInt();
		while (inputUser < min || inputUser > max) {
			System.err.println(message);
			System.out.println("En attente d'une entrée valide");
			while(!sc.hasNextInt()) sc.next();
			inputUser = sc.nextInt();
		}
		return inputUser;
	}
	
	/**
	 * Control if inpuUser is empty if yes ask again
	 * @param inputUser
	 * @param sc scanner
	 * @return String inputser
	 */
	public static String verifIsEmptyInput(String message) {
		String inputUser = sc.nextLine();
		while(inputUser.isEmpty()) {
			System.err.println(message);
			inputUser = sc.nextLine();
		}
		return inputUser;
	}
	
}
// algo transaction
	// si ma transaction a reussi
	// je l'ajoute dans dans ma liste de transactions
	// 









