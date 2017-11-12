package hotel;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Recepcjonista extends Człowiek {

	Recepcjonista(String imię, String nazwisko) {
		super(imię, nazwisko);
	}
	
	protected boolean dostępny(Pokój pokój, Ankieta ankieta) {
		Calendar dataWyjazdu = Calendar.getInstance();
		dataWyjazdu.setTime(ankieta.dataPrzyjazdu.getTime());
		dataWyjazdu.add(Calendar.DAY_OF_MONTH, ankieta.ileDni-1);
		for (Rezerwacja rezerwacja : pokój.zajęteTerminy) {
			if (ankieta.dataPrzyjazdu.compareTo(rezerwacja.dataWyjazdu) <= 0 &&
				rezerwacja.dataPrzyjazdu.compareTo(dataWyjazdu) <= 0) { 
				return false;
			}
		}
		return true;
	}
	abstract Pokój wybierzPokój(ArrayList<Pokój> dostępnePokoje, Zamówienie zamówienie);
	
	public ArrayList <Pokój> dostępnePokoje(Pokój[] pokoje, Zamówienie zamówienie) {
		ArrayList <Pokój> dostępnePokoje = new ArrayList <Pokój> ();
		for (Pokój pokój : pokoje) {
			Ankieta ankieta = zamówienie.ankieta;
			if (dostępny(pokój, ankieta)) {
				dostępnePokoje.add(pokój);
			}
		}
		return dostępnePokoje;
	}
	
	@Override
	public String toString() {
		return "Recepcjonista: " + super.toString();
	}
}
