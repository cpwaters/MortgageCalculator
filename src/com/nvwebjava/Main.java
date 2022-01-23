package com.nvwebjava;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // basic output string
        System.out.println("Welcome to MortgageBod!!");
        // Date
        Date now = new Date();
        // Currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String resultCurrency = currency.format(12536635.66);
        // Percent
        NumberFormat percent = NumberFormat.getPercentInstance();
        String resultPercent = percent.format(0.6);
        // Percent (method chained)
        String resultPercentChain = NumberFormat.getPercentInstance().format(0.6);
        //System.out.println(resultPercentChain);
        mortgage();
    }

    public static void mortgage() {
        // Consts
            final byte MONTHS_IN_YEAR = 12;
            final byte PERCENT = 100;
        // User input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Age: ");
        byte age = scanner.nextByte();
        System.out.println("Hi! " + name + ", Lets work out how much your mortgage will be:");
        // get principal amount
        System.out.print("Principal Amount: £");
        int principal = scanner.nextInt();
        // get the interest rate
        System.out.print("Annual Interest Rate (%): ");
        float annualInterestRate = scanner.nextFloat();
        // get payment terms (in years)
        System.out.print("Payment Term (Years): ");
        int termInYears = scanner.nextInt();

        double monthlyInterestRate =  annualInterestRate / MONTHS_IN_YEAR  / PERCENT;
        int termInMonths = (termInYears * MONTHS_IN_YEAR);

        double topline = monthlyInterestRate * Math.pow(1 + monthlyInterestRate, termInMonths);
        double bottomline = (Math.pow(1 + monthlyInterestRate, termInMonths) - 1);

        double monthlyMortgagePayments = principal * (topline / bottomline);
        String totalRepayments = NumberFormat.getCurrencyInstance().format(monthlyMortgagePayments);
        System.out.println("Monthly Repayments: " + totalRepayments);

        int totalYears = age + termInYears;
        System.out.println("You will be " + totalYears + " when you've paid your mortgage off.");
    }
}
