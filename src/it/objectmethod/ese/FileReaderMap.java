package it.objectmethod.ese;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReaderMap {
	public static void main(String[] args) throws IOException {

		/////////// READ///////////////

		String file = "src/articoli.csv";
		String delimiter = ";";
		String line = "";
		String[] art;

		Map<String, Articolo> articoli = new HashMap<String, Articolo>();

		try (Scanner s = new Scanner(new File(file))) {
			while (s.hasNextLine()) {
				line = s.nextLine();
				art = line.split(delimiter);
				Articolo articolo = new Articolo(Integer.parseInt(art[0]), art[1], art[2], Integer.parseInt(art[3]));
				articoli.put(articolo.getCodice(), articolo);

				System.out.println(articolo.getId() + " - " + articolo.getCodice() + " - " + articolo.getDescrizione()
						+ " - " + articolo.getQuantita());
			}

			/////////// INSERT NEW ARTICLE/////////////////

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

				articoli.put(codiceTmp, articoloTmp);

				System.out.println(articoloTmp.getId() + " - " + articoloTmp.getCodice() + " - "
						+ articoloTmp.getDescrizione() + " - " + articoloTmp.getQuantita());

				System.out.println("Vuoi inserire un alro articolo? y/n ");
				risposta = sc.nextLine();

			} while (!risposta.toLowerCase().equals("n"));
			
			//////////////////SEARCH////////////////
			
			System.out.println("Cerca tramite chiave: ");
			String chiave = sc.nextLine();
			
			System.out.println(articoli.get(chiave).getId() + " - " + articoli.get(chiave).getCodice() + " - " + articoli.get(chiave).getDescrizione() + " - " + articoli.get(chiave).getQuantita());
			sc.close();
		}

		////////////////// WRITING//////////////////////

		String lineSeparator = "\n";
		String fileName = "src/nuovo_articoli_map.csv";

		FileWriter fileWriter = null;

		try (Writer writer = new FileWriter(fileName)) {

			fileWriter = new FileWriter(fileName);

			for (Articolo article : articoli.values()) {
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

		}

		////////////// ERRORE/////////////
		catch (Exception e) {
			System.out.println("Errore!!!");
			e.printStackTrace();
		}

	}

}
