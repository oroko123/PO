package hotel;

public class Zamówienie {
	Klient klient;
	Ankieta ankieta;
	int próby;
	Zamówienie (Klient klient, Ankieta ankieta) {
		this.klient = klient;
		this.ankieta = ankieta;
		this.próby = 3;
	}

	@Override
	public String toString() {
		return "Zamówienie: " + ankieta.toString();
	}
}
