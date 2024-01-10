/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation

	public static void main(String[] args) {		

		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
		double balance = loan; 
		double payment = loan/n; 
		iterationCounter = 0;
		while(balance > 0) {
			iterationCounter++;
			balance = endBalance(loan, rate, n, payment);
			if(balance > 0)
				payment = payment + epsilon;
		}
    	return payment;    	
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		double balance = loan;
		double L = loan/n;
		double H = loan;
		double g = (L+H)/2;
		double payment = g;
		iterationCounter = 0;
		while(Math.abs(balance) >= epsilon){
			iterationCounter++;
			payment = g;
			balance =endBalance(loan, rate, n, payment);
			if(balance > 0)
				L = g;
			else 
				H = g;
			g = (L+H)/2;
		}

		return payment;
    }
	
	private static double endBalance(double loan, double rate, int n, double payment) {
		double balance = loan; 
		for(int i = 0; i < n ; i++) 
			balance = (balance - payment)*(1 + rate/100);
    	return balance;
	}
} 