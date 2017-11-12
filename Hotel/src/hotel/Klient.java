package hotel;

public abstract class Klient extends Człowiek {
	
	Klient(String imię, String nazwisko) {
		super(imię, nazwisko);
	}

	Ankieta ankieta;

	@Override
	public String toString() {
		return "Klient: " + super.toString();
	}
	
	public abstract boolean akceptuje(Pokój pokój);
}
