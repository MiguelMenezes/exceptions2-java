package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.WithdrawException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("ENTER ACCOUNT DATA");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			sc.nextLine();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw Limit: ");
			double withdrawLimit = sc.nextDouble();

			Account acc = new Account(number, holder, initialBalance, withdrawLimit);

			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();

			acc.withdraw(amount);

			System.out.print("New balance: " + acc.getBalance());
		} 
		catch (WithdrawException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}

		sc.close();
	}

}
