package hotel;

public class KlientPerfekcjonista extends Klient {

	KlientPerfekcjonista(String imię, String nazwisko) {
		super(imię, nazwisko);
	}

	@Override
	public boolean akceptuje(Pokój pokój) {
		return ilePasuje(pokój, ankieta) == 6;
	}

	@Override
	public String toString() {
		return super.toString() + ", perfekcjonistyczna";
	}
}
