package hotel;

public class OpisPokoju {

	public int liczbaOsób;
	public int cena;
	Styl styl;
	Kolorystyka kolorystyka;
	Kierunek kierunek;
	public boolean internet;
	
	public OpisPokoju(int liczbaOsób, int cena, Styl styl,
			Kolorystyka kolorystyka, Kierunek kierunek, boolean internet) {
		super();
		this.liczbaOsób = liczbaOsób;
		this.cena = cena;
		this.styl = styl;
		this.kolorystyka = kolorystyka;
		this.kierunek = kierunek;
		this.internet = internet;
	}
	
	@Override
	public String toString() {
		return this.liczbaOsób + ", " + this.cena + ", " + this.styl + ", " + 
				this.kolorystyka + ", " + this.kierunek + ", " +this.internet;
	}
}
