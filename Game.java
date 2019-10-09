import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static String ConvertIntToChoice(int number){
		if (number == 0) {
			return "Rock";
		} else if (number == 1) {
			return "Paper";
		} else {
			return "Scissors";
		}
	}
	

	public static void DetermineWinner(String ComputerChoice, String UserChoice){
	try {
		if (ComputerChoice.equalsIgnoreCase(UserChoice)) { // Tie
			System.out.println("It's a tie! Play again.");
			PlayGame();
		} else if (ComputerChoice.equalsIgnoreCase("Rock") && UserChoice.equalsIgnoreCase("Scissors")) {
			System.out.println(ComputerChoice + " beats " + UserChoice);
			Thread.sleep(1000);
			System.out.println("Computer wins!");
		} else if (ComputerChoice.equalsIgnoreCase("Paper") && UserChoice.equalsIgnoreCase("Rock")) {
			System.out.println(ComputerChoice + " beats " + UserChoice);
			Thread.sleep(1000);
			System.out.println( "Computer wins!");
		} else if (ComputerChoice.equalsIgnoreCase("Scissors") && UserChoice.equalsIgnoreCase("Paper")) {
			System.out.println(ComputerChoice + " beats " + UserChoice);
			Thread.sleep(1000);
			System.out.println("Computer wins!");
		} else {
			System.out.println(UserChoice + " beats " + ComputerChoice);
			Thread.sleep(1000);
			System.out.println("Player wins!");
		}
	
	} catch (InterruptedException e) { }
	}


	public static String GenerateComputerChoice() {
		Random rand = new Random();
		int choice = rand.nextInt(3);
		return ConvertIntToChoice(choice);
	}
	

	public static String GenerateUserChoice() {
		Scanner scanner = new Scanner(System.in);
		String UserChoice = scanner.nextLine();
		return UserChoice;
	}

	public static void PlayGame(){	
	try {
		System.out.println("Enter a choice: ");
		String Computer = GenerateComputerChoice();
		String User = GenerateUserChoice();
		Thread.sleep(1000);
		System.out.println("You played: " +  User);
		Thread.sleep(1000);
		System.out.println("Computer played: " + Computer);
		Thread.sleep(750);
		System.out.print(".	");
		Thread.sleep(750);
		System.out.print(".	");
		Thread.sleep(750);
		System.out.println(".");
		Thread.sleep(1000);
		DetermineWinner(Computer, User);
	} catch (InterruptedException e) { }
	}

	// MAIN FUNCTION
	public static void main(String[] args) {

		int i = 1;
		while (i == 1) {
		try {
			PlayGame();
			Thread.sleep(1000);
			System.out.println("Do you want to play again?");
			Scanner scanner = new Scanner(System.in);
			String PlayAgain = scanner.next();
			if (PlayAgain.equalsIgnoreCase("yes")) { i = 1; } else { i = 0; }

		} catch (InterruptedException e) { }

		}
	}
}	
