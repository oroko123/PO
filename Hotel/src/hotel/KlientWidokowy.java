package hotel;

public class KlientWidokowy extends Klient {

	KlientWidokowy(String imię, String nazwisko) {
		super(imię, nazwisko);
	}

	@Override
	public boolean akceptuje(Pokój pokój) {
		return pokój.opisPokoju.kierunek == ankieta.opisPokoju.kierunek;
	}

	@Override
	public String toString() {
		return super.toString() + ", widokowa";
	}
}
