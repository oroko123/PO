package hotel;

import java.util.ArrayList;

public class Pokój {
	
	public int nr;
	OpisPokoju opisPokoju;
	ArrayList <Rezerwacja> zajęteTerminy = new ArrayList <Rezerwacja> ();
	public Pokój() {}
	
	public Pokój(int nr, int liczbaOsób, int cena, Styl styl,
			Kolorystyka kolorystyka, Kierunek kierunek, boolean internet) {
		this.nr = nr;
		opisPokoju = new OpisPokoju(liczbaOsób, cena, styl, kolorystyka, kierunek, internet);
	}

	@Override
	public String toString() {
		return opisPokoju.toString();
	}
}
