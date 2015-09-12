package lab1;

import java.util.Scanner;
import java.util.*;
import java.text.DecimalFormat;

public class CISC181_Lab1 {
	public static void main(String[] args) {
		System.out.println("Hello!Please anwser the following questions using either integer or float");

		Scanner input = new Scanner(System.in);
		System.out.print("How many years do you plan to work? ");
		int WorkYears = input.nextInt();

		Scanner input2 = new Scanner(System.in);
		System.out.print("What is your expected average annual return during work? Please enter float instead of xx%");
		Double AnnualReturn = input2.nextDouble();

		Scanner input3 = new Scanner(System.in);
		System.out.print("How many years do you want to draw?");
		int DrawYears = input3.nextInt();

		Scanner input4 = new Scanner(System.in);
		System.out.print("What's your required income?");
		double RequiredIncome = input4.nextDouble();

		Scanner input5 = new Scanner(System.in);
		System.out.print("What is your expected ISS?");
		Double ISS = input5.nextDouble();

		Scanner input6 = new Scanner(System.in);
		System.out.print("What is your expected average annual return after retire? Please enter float instead of xx%");
		Double AnnualReturn2 = input6.nextDouble();

		Double baseAmount = 117000.00;
		Double RetiredReturn = 0.002;

		double RetireRate = AnnualReturn2 / 12;
		double RetireNper = DrawYears * 12;
		double RetirePmt = RequiredIncome - ISS;

		double Pv = RetirePmt * (((Math.pow(1 + RetireRate, RetireNper)) - 1) / RetireRate)
				/ (Math.pow(1 + RetireRate, RetireNper));

		double WorkRate = AnnualReturn / 12;
		double WorkNper = WorkYears * 12;
		

		double WorkPmt = 0;

		WorkPmt = -(WorkRate / (1 - Math.pow((1 + WorkRate), WorkNper))) * Pv;

		DecimalFormat formatter = new DecimalFormat("#0.00");

		System.out.println("The money you need to save each month is " + (formatter.format(WorkPmt)));
		System.out.println("The money you will have saved by the year you retire is " + (formatter.format(Pv)));

	}

}