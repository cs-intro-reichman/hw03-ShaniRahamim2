public class Calendar {

    static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	static int sundays = 0; 

	public static void main(String args[]) {
        int givenYear = Integer.parseInt(args[0]);

	 	while (year < givenYear) {	
            year++; 
	 	}
            advance();
        }
	
	 private static void advance() {
		 
			for (month = 1; month <= 12; month++){  			
				int countDays = nDaysInMonth(month, year); 		
				for (dayOfMonth = 1; dayOfMonth <= countDays; dayOfMonth++){
					if(dayOfWeek == 1) {
						sundays++; 
						System.out.println( dayOfMonth + "/" + month + "/" + year +" Sunday" );
					}
					else {
						System.out.println( dayOfMonth + "/" + month + "/" + year );
						}
					if ( dayOfWeek == 7) {
						dayOfWeek = 0; 
					}
					dayOfWeek++; 
					
				}
			}
	 } 
		 
	private static boolean isLeapYear(int year) {
		if  (year % 400 == 0){
			return true;
		} 
		if (((year % 4) == 0) && ((year % 100) != 0) ) {
			return true;
		}
		return false;
	}

	private static int nDaysInMonth(int month, int year) {
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
	   }
	   else if (month == 2) {
		   if (isLeapYear(year) == true){
			   return 29;
		   }
		   else {
			   return 28; 
		   }
	   }
	   else {
		   return 31;
	   }
	   }
    }
