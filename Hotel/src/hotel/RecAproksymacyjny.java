package hotel;

import java.util.ArrayList;

public class RecAproksymacyjny extends Recepcjonista {

	RecAproksymacyjny(String imię, String nazwisko) {
		super(imię, nazwisko);
	}
	
	@Override
	Pokój wybierzPokój(ArrayList<Pokój> dostępnePokoje, Zamówienie zamówienie) {
		Ankieta ankieta = zamówienie.ankieta;
		int pasuje = -1;
		Pokój wybrany = null;
		for(Pokój pokój : dostępnePokoje) {
			if (ilePasuje(pokój, ankieta) >= pasuje) {
				if(ilePasuje(pokój, ankieta) > pasuje) {
					wybrany = pokój;
					pasuje = ilePasuje(pokój, ankieta);
				}
				else if(pokój.opisPokoju.cena >= wybrany.opisPokoju.cena) {	
					if(pokój.opisPokoju.cena > wybrany.opisPokoju.cena) {
						wybrany = pokój;
					}
					else if(pokój.nr < wybrany.nr) {
						wybrany = pokój;
					}
				}
			}
		}
		return wybrany;
	}
	@Override
	public String toString() {
		return super.toString() + ", aproksymacyjna";
	}
}
