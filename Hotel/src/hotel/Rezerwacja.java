package hotel;

import java.util.Calendar;

public class Rezerwacja {
	Calendar dataPrzyjazdu;
	Calendar dataWyjazdu;
	
	public Rezerwacja(Calendar dataPrzyjazdu, int ileDni) {
		this.dataPrzyjazdu = dataPrzyjazdu;
		this.dataWyjazdu = Calendar.getInstance();
		this.dataWyjazdu.setTime(dataPrzyjazdu.getTime());
		this.dataWyjazdu.add(Calendar.DAY_OF_MONTH, ileDni-1);
	}
}
