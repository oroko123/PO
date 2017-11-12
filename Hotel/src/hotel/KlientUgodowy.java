package hotel;

public class KlientUgodowy extends Klient {

	KlientUgodowy(String imię, String nazwisko) {
		super(imię, nazwisko);
	}

	@Override
	public boolean akceptuje(Pokój pokój) {
		return true;
	}	
	
	@Override
	public String toString() {
		return super.toString() + ", ugodowa";
	}
}
