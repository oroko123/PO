package hotel;

public class KlientPołowiczny extends Klient {
	
	KlientPołowiczny(String imię, String nazwisko) {
		super(imię, nazwisko);
	}

	@Override
	public boolean akceptuje(Pokój pokój) {
		return ilePasuje(pokój, ankieta) >= 3;
	}

	@Override
	public String toString() {
		return super.toString() + ", połowiczna";
	}
}
