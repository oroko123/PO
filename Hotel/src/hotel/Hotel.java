package hotel;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;

public class Hotel {
	
	public Hotel(Recepcjonista[] recepcjonisci, Pokój[] pokoje) {}
	ArrayDeque <Zamówienie> listaZamówień;
	public static void akceptuj(Zamówienie[] zamówienia, Pokój[] pokoje, Recepcjonista[] recepcjonisci) {
		
		ArrayDeque <Zamówienie> listaZamówień = new ArrayDeque <Zamówienie> ();
		
		for(Zamówienie z: zamówienia) {
			listaZamówień.add(z);
		}

		int iterator = 0;
		while (!listaZamówień.isEmpty()) {
			Zamówienie zamówienie = listaZamówień.poll();
			Ankieta ankieta = zamówienie.ankieta;
			Recepcjonista recepcjonista = recepcjonisci[iterator++];
			if (iterator >= recepcjonisci.length) {
				iterator = 0;
			}
			
			ArrayList <Pokój> dostępnePokoje = recepcjonista.dostępnePokoje(pokoje, zamówienie);
			
			Pokój pokój;
			if (!dostępnePokoje.isEmpty()) {
				pokój = recepcjonista.wybierzPokój(dostępnePokoje, zamówienie);
			}
			else {
				pokój = null;
			}
			System.out.println(recepcjonista);
			System.out.println(zamówienie);
			System.out.println("Pokój: " + pokój);
			System.out.println(zamówienie.klient);

			if (pokój != null && zamówienie.klient.akceptuje(pokój)) {
				System.out.print("tak\n\n");
				pokój.zajęteTerminy.add(new Rezerwacja(ankieta.dataPrzyjazdu, ankieta.ileDni));
			}
			else {
				System.out.print("nie\n\n");
				if (!dostępnePokoje.isEmpty() && --zamówienie.próby > 0) {
					listaZamówień.add(zamówienie);
				}
			}
		}
	}
	
	public static Zamówienie przyjmijZamówienie(Klient klient, Ankieta ankieta) {
		klient.ankieta = ankieta;
		Zamówienie zamówienie = new Zamówienie(klient, ankieta);
		return zamówienie;
	}	
	
	public static void main(String[] args) {
		
		Recepcjonista[] recepcjonisci = new  Recepcjonista[4];
		Pokój[] pokoje = new Pokój[6];
		Klient[] klienci = new Klient[6];
		Ankieta[] ankiety = new Ankieta[5];
		Zamówienie[] zamówienia = new Zamówienie[6];

		recepcjonisci[0] = new RecZłośliwy("Juliusz", "Słowacki");
		recepcjonisci[1] = new RecLosowy("Adam", "Mickiewicz");
		recepcjonisci[2] = new RecPerfekcjonista("Fryderyk", "Chopin");
		recepcjonisci[3] = new RecAproksymacyjny("Jan", "Matejko");
		
		klienci[0] = new KlientBudżetowy("Ferdynand", "Kiepski");
		klienci[1] = new KlientPerfekcjonista("Marian", "Paździoch");
		klienci[2] = new KlientUgodowy("Arnold", "Boczek");
		klienci[3] = new KlientPołowiczny("Walduś", "Kiepski");
		klienci[4] = new KlientWidokowy("Halina", "Kiepska");
		klienci[5] = new KlientWidokowy("Mariola", "Kiepska");
		
		Calendar data1 = Calendar.getInstance();
		data1.clear();
		data1.set(2016, 5, 29);
		
		Calendar data2 = Calendar.getInstance();
		data2.clear();
		data2.set(2016, 6, 1);
		
		Calendar data3 = Calendar.getInstance();
		data3.clear();
		data3.set(2016, 6, 10);
		
		Calendar data4 = Calendar.getInstance();
		data4.clear();
		data4.set(2016, 6, 15);
		
		pokoje[0] = new Pokój(0, 2, 400, Styl.rustykalny,
				Kolorystyka.seledynowy, Kierunek.zachód, true);
		pokoje[1] = new Pokój(1, 2, 550, Styl.morski, 
				Kolorystyka.stalowy, Kierunek.wschód, false);
		pokoje[2] = new Pokój(2, 3, 700, Styl.nowoczesny,
				Kolorystyka.morski, Kierunek.zachód, true);
		pokoje[3] = new Pokój(3, 3, 800, Styl.orientalny, 
				Kolorystyka.purpurowy, Kierunek.północ, true);
		pokoje[4] = new Pokój(4, 4, 1000, Styl.secesyjny,
				Kolorystyka.seledynowy, Kierunek.zachód, true);
		pokoje[5] = new Pokój(5, 4, 1200, Styl.morski, 
				Kolorystyka.jasnozielony, Kierunek.północ, true);
		
		
		ankiety[0] = new Ankieta(data1, 3, 3, 500, Styl.rustykalny, 
				Kolorystyka.seledynowy, Kierunek.zachód, true);
		
		ankiety[1] = new Ankieta(data2, 7, 2, 400, Styl.morski,
				Kolorystyka.stalowy, Kierunek.północ, true);
		
		ankiety[2] = new Ankieta(data3, 3, 5, 1000, Styl.secesyjny, 
				Kolorystyka.seledynowy, Kierunek.południe, true);
		
		ankiety[3] = new Ankieta(data4, 10, 4, 800, Styl.orientalny,
				Kolorystyka.jasnozielony, Kierunek.północ, false);
		
		ankiety[4] = new Ankieta(data4, 2, 1, 10000, Styl.rustykalny, 
				Kolorystyka.morski, Kierunek.zachód, false);
		
		for(int i = 0; i < 5; i++) {
			zamówienia[i] = przyjmijZamówienie(klienci[i], ankiety[i]);
		}
		zamówienia[5] = przyjmijZamówienie(klienci[5], ankiety[4]);
		
		akceptuj(zamówienia, pokoje, recepcjonisci);
		
	}
}
