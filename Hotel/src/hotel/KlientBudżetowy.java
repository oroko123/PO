package hotel;

public class KlientBudżetowy extends Klient {

	KlientBudżetowy(String imię, String nazwisko) {
		super(imię, nazwisko);
	}

	@Override
	public boolean akceptuje(Pokój pokój) {
		return pokój.opisPokoju.cena <= ankieta.opisPokoju.cena;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", budżetowa";
	}
}
