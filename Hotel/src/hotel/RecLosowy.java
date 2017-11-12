package hotel;

import java.util.ArrayList;
import java.util.Random;

public class RecLosowy extends Recepcjonista {

	RecLosowy(String imię, String nazwisko) {
		super(imię, nazwisko);
	}

	@Override
	Pokój wybierzPokój(ArrayList<Pokój> dostępnePokoje, Zamówienie zamówienie) {
		Random generator = new Random();
		
		int index = generator.nextInt(dostępnePokoje.size());
		return dostępnePokoje.get(index);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", losowa";
	}
}
