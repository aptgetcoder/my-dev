import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeLoanPaymentSheet {

	public static void main(String[] args) {
		List<Integer> dataList = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("Enter your Loan Amount : ");
		double principal = sc.nextDouble();
		double initialPrincipal = principal;
		System.out.println("Enter your Loan's Rate of Interest : ");
		double rateOfInterest = sc.nextDouble();
		System.out.println("Enter your Loan's Tenure in Month : ");
		int tenure = sc.nextInt();
		System.out.println("Enter your EMI : ");
		int emi = sc.nextInt();
		double totalInterest = 0.0;
		double finalSettlement = 0;
		
		for(int i = 1; i <= tenure && principal > emi; i++ ) {
			System.out.print(i);
			System.out.print("\t|\t");
			System.out.print(Math.ceil(principal));
			System.out.print("\t|\t");
			double interestAmount = Double.parseDouble(df.format((principal*rateOfInterest)/1200));
			System.out.print(Math.ceil(interestAmount));
			System.out.print("\t|\t");
			double paidPrincipal = Double.parseDouble(df.format(emi - interestAmount));
			System.out.print(Math.ceil(paidPrincipal));
			System.out.print("\t|\t");
			principal = Double.parseDouble(df.format(principal - paidPrincipal));
			System.out.print(Math.ceil(principal));
			if(i % 12 == 0) {
				System.out.print("\n");
				System.out.print("Enter Prepayment Amount : ");
				int prepayment = sc.nextInt();
				principal = principal - prepayment;
			}
			System.out.print("\n");
		    totalInterest = Double.parseDouble(df.format(totalInterest + interestAmount));
		    finalSettlement = principal;
		}
		System.out.println("Loan Amount : " + initialPrincipal);
		System.out.println("Total Interest : " + totalInterest);
		double totalAmount = initialPrincipal + totalInterest;
		System.out.println("Total Amount Paid for Property : " + Double.parseDouble(df.format(totalAmount)));
		System.out.println("Final Settlement to be done to close the loan : " + Double.parseDouble(df.format(finalSettlement)));
	}

}
