package hotel;

import java.util.Calendar;

public class Ankieta {
	
	Calendar dataPrzyjazdu;
	public int ileDni;
	OpisPokoju opisPokoju;
	
	public Ankieta(Calendar dataPrzyjazdu, int ileDni, int liczbaOsób,
			int cena, Styl styl, Kolorystyka kolorystyka, 
			Kierunek kierunek, boolean internet) {
		this.dataPrzyjazdu = dataPrzyjazdu;
		this.ileDni = ileDni;
		opisPokoju = new OpisPokoju(liczbaOsób, cena, 
				styl, kolorystyka, kierunek, internet);
	}

	@Override
	public String toString() {
		return this.dataPrzyjazdu.get(Calendar.DAY_OF_MONTH) + "-" + 
				(this.dataPrzyjazdu.get(Calendar.MONTH)+1) + "-" + 
				this.dataPrzyjazdu.get(Calendar.YEAR) + ", " +
				opisPokoju.toString();
	}
}
