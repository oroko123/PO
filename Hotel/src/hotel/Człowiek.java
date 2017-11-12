package hotel;

public abstract class Człowiek {
	
	public String imię;
	public String nazwisko;
	
	Człowiek(String imię, String nazwisko)
	{
		this.imię = imię;
		this.nazwisko = nazwisko;
	}
	
	int ilePasuje(Pokój pokój, Ankieta ankieta) {
		OpisPokoju opis1 = pokój.opisPokoju;
		OpisPokoju opis2 = ankieta.opisPokoju;
		int licznik = 0;
		if (opis1.cena <= opis2.cena) {
			licznik++;
		}
		if (opis1.liczbaOsób >= opis2.liczbaOsób) {
			licznik++;
		}
		if (opis1.kierunek == opis2.kierunek) {
			licznik++;
		}
		if (opis1.kolorystyka == opis2.kolorystyka) {
			licznik++;
		}
		if(opis1.styl == opis2.styl) {
			licznik++;
		}
		if (opis1.internet == opis2.internet) {
			licznik++;
		}
		return licznik;
	}
	
	@Override
	public String toString() {
		return this.imię + " " + this.nazwisko;
	}
}
