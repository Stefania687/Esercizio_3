package it.objectmethod.ese;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReaderList {

	public static void main(String[] args) throws IOException {

		String file = "src/articoli.csv";
		String delimiter = ";";
		String line = "";
		String[] art;

		ArrayList<Articolo> articoli = new ArrayList<Articolo>(); // gli oggetti sono di tipo Articolo

		try (Scanner s = new Scanner(new File(file))) {
			while (s.hasNextLine()) {
				line = s.nextLine(); // mi tiro fuori dal file tutte le righe
				// System.out.println(line);
				art = line.split(delimiter); // divido la stringa facendola diventare un array tramite il delimitatore ;
				// System.out.println(art[2]); //stampo le colonne*
				Articolo articolo = new Articolo(Integer.parseInt(art[0]), art[1], art[2], Integer.parseInt(art[3]));
				// creo l'oggeto articolo e ci passo dentro i parametri del costruttore
				articoli.add(articolo);

				System.out.println(articolo.getId() + " - " + articolo.getCodice() + " - " + articolo.getDescrizione()
						+ " - " + articolo.getQuantita());

			}
			System.out.println("Inserisci nuovo articolo: ");

			String risposta = "";
			Scanner sc = new Scanner(System.in);
			do {

				int idTmp = 5;

				System.out.println("Inserisci codice: ");
				String codiceTmp = sc.nextLine();
				System.out.println("Inserisci descrizione: ");
				String descrizioneTmp = sc.nextLine().toUpperCase();
				System.out.println("Inserisci quantita: ");
				int quantitaTmp = Integer.parseInt(sc.nextLine());

				Articolo articoloTmp = new Articolo(idTmp, codiceTmp, descrizioneTmp, quantitaTmp);

				articoli.add(articoloTmp);

				System.out.println(articoloTmp.getId() + " - " + articoloTmp.getCodice() + " - "
						+ articoloTmp.getDescrizione() + " - " + articoloTmp.getQuantita());

				System.out.println("Vuoi inserire un alro articolo? y/n ");
				risposta = sc.nextLine();

			} while (!risposta.equals("n"));
			sc.close();
		}
		////////////////// WRITING//////////////////////

		String lineSeparator = "\n";
		String fileName = "src/nuovo_articoli_lista.csv";

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);

			

			// Write a new student object list to the CSV file
			for (Articolo article : articoli) {
				fileWriter.append(String.valueOf(article.getId()));
				fileWriter.append(delimiter);
				fileWriter.append(article.getCodice());
				fileWriter.append(delimiter);
				fileWriter.append(article.getDescrizione());
				fileWriter.append(delimiter);
				fileWriter.append(String.valueOf(article.getQuantita()));
				fileWriter.append(lineSeparator);
			}
			fileWriter.flush();
			fileWriter.close();

			System.out.println("CSV creato!!!");

		} catch (Exception e) {
			System.out.println("Errore!!!");
			e.printStackTrace();
		}

	}

}
