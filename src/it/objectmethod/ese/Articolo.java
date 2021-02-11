package it.objectmethod.ese;

public class Articolo {

	private int id;
	private String codice;
	private String descrizione;
	private int quantita;

	//creo il costruttore e gli passo i parametri di cui ho bisogno
	public Articolo(int id, String codice, String descrizione, int quantita) {
		this.setId(id);
		this.setCodice(codice);
		this.setDescrizione(descrizione);
		this.setQuantita(quantita);
	}
	//genero i metodi get e set (get ti permette di leggere i dati, set di modificarli)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

}
