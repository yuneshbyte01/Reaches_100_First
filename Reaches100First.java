import java.util.Random;
import java.util.Scanner;

public class Reaches100First {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        boolean playAgain = true;

        while (playAgain) {
            // Welcome message
            System.out.println("Welcome! 🎉 Let’s see who can reach 100 first! Good luck, players! 🍀\n");

            int choice;

            while (true) {
                // Main Menu
                System.out.println("***** Reaches 100 First Game! *****");
                System.out.println("1. Two Player Mode");
                System.out.println("2. Computer Mode");
                System.out.print("Enter your choice of mode: ");
                choice = getValidNumber(scanner);

                switch (choice) {
                    case 1:
                        multiplayerMode();
                        break;
                    case 2:
                        computerMode();
                        break;
                    default:
                        System.out.println("Invalid Choice! Please select 1 or 2.");
                        continue;
                }
                break;
            }

            // Ask if players want to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
                System.out.println("\nThanks for playing! Goodbye! 👋");
            } else if (!response.equalsIgnoreCase("yes")) {
                System.out.println("Invalid response! Exiting game.");
                playAgain = false;
            }
        }
    }

    public static int getValidNumber(Scanner scanner) {
        int num = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Choose a number between 1 to 10: ");
                num = scanner.nextInt();

                if (num >= 1 && num <= 10) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input! Please choose a number between 1 and 10.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return num;
    }

    public static void multiplayerMode() {
        int total = 0;
        do {
            int num1, num2;

            // Player 1's Turn
            System.out.println("\nPlayer 1's Turn:");
            num1 = getValidNumber(scanner);

            total += num1;
            System.out.println("Total : " + total);
            if (total == 100) {
                System.out.println("Player 1 Wins! 🎉");
                break;
            } else if (total > 90) {
                System.out.println("You're so close, Player 1!");
            }

            if (total > 100) {
                System.out.println("\nOops! Total Exceeds 100! 😅");
                total -= num1;
                System.out.println("Total : " + total);
                num1 = getValidNumber(scanner);
                total += num1;
                System.out.println("Total : " + total);
            }

            // Player 2's Turn
            System.out.println("\nPlayer 2's Turn:");
            num2 = getValidNumber(scanner);

            total += num2;
            System.out.println("Total : " + total);
            if (total == 100) {
                System.out.println("Player 2 Wins! 🎉");
                break;
            } else if (total > 90) {
                System.out.println("You're getting close, Player 2!");
            }

            if (total > 100) {
                System.out.println("\nOops! Total Exceeds 100! 😅");
                total -= num2;
                System.out.println("Total : " + total);
                num2 = getValidNumber(scanner);
                total += num2;
                System.out.println("Total : " + total);
            }

        } while (true);
    }

    public static void computerMode() {
        int total = 0;
        System.out.println("\nYou’re now playing against the computer! 🤖");

        do {
            int playerChoice, computerChoice;

            // Player's Turn
            System.out.println("\nYour Turn:");
            playerChoice = getValidNumber(scanner);

            total += playerChoice;
            System.out.println("Total : " + total);
            if (total == 100) {
                System.out.println("You Win! 🎉");
                break;
            } else if (total > 90) {
                System.out.println("You're getting close! 🏁");
            }

            if (total > 100) {
                System.out.println("\nOops! Total Exceeds 100! 😅");
                total -= playerChoice;
                System.out.println("Total : " + total);
                playerChoice = getValidNumber(scanner);
                total += playerChoice;
                System.out.println("Total : " + total);
            }

            // Computer's Turn
            System.out.println("\nComputer's Turn:");
            computerChoice = random.nextInt(10) + 1;

            total += computerChoice;
            System.out.println("Computer chooses: " + computerChoice);
            System.out.println("Total : " + total);
            if (total == 100) {
                System.out.println("Computer Wins! 🤖");
                break;
            } else if (total > 90) {
                System.out.println("Computer is getting close! 🏁");
            }

            if (total > 100) {
                System.out.println("\nOops! Total Exceeds 100! 😅");
                total -= computerChoice;
                System.out.println("Total : " + total);
                computerChoice = random.nextInt(10) + 1;
                total += computerChoice;
                System.out.println("Computer chooses: " + computerChoice);
                System.out.println("Total : " + total);
            }

        } while (true);
    }
}
