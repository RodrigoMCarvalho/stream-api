package teste;

import java.util.*;

public class CalendarTest {

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 11);
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.YEAR, 2019);
        
        Date dataAtual = calendar.getTime();
		
        System.out.println(dataAtual);
	}

}
