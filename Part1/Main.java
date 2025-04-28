import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int raceLength;
        do {
            System.out.print("Enter the race length ");
            while (!scanner.hasNextInt()) {
                System.out.println("Must be positive. ");
                scanner.next();
            }
            raceLength = scanner.nextInt();
        } while (raceLength <= 0);
        scanner.nextLine();

        Race race = new Race(raceLength);

        int numberOfHorses;
        do {
            System.out.print("Enter the number of horses: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Must be positive.");
                scanner.next();
            }
            numberOfHorses = scanner.nextInt();
        } while (numberOfHorses <= 0);
        scanner.nextLine();

        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 1; i <= numberOfHorses; i++) {
            System.out.println("Horse " + i + ":");

            System.out.print("Enter the name of the horse: ");
            String name = scanner.nextLine();

            char symbol;
            do {
                System.out.print("Enter the symbol for the horse (single character): ");
                String input = scanner.nextLine();
                if (input.length() == 1) {
                    symbol = input.charAt(0);
                    break;
                } else {
                    System.out.println("Must be a single character.");
                }
            } while (true);

            double confidence;
            do {
                System.out.print("Enter the confidence level between 0.0 to 1.0 (exclusive): ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. ");
                    scanner.next();
                }
                confidence = scanner.nextDouble();
                if (confidence > 0.0 && confidence <= 1.0) {
                    break;
                } else {
                    System.out.println("Confidence level must be greater than 0.0 and less than or equal to 1.0.");
                }
            } while (true);
            scanner.nextLine();

            Horse horse = new Horse(symbol, name, confidence);
            horses.add(horse);
        }

        int numberOfLanes;
        do {
            System.out.print("Enter the number of lanes (must be >= number of horses): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. ");
                scanner.next();
            }
            numberOfLanes = scanner.nextInt();
        } while (numberOfLanes < numberOfHorses);
        scanner.nextLine();

        boolean[] occupiedLanes = new boolean[numberOfLanes];
        for (int i = 1; i <= numberOfHorses; i++) {
            int laneNumber;
            do {
                System.out.print("Assign a lane for Horse " + horses.get(i - 1).getName() + " (1 to " + numberOfLanes + "): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Enter a lane number between 1 and " + numberOfLanes + ".");
                    scanner.next();
                }
                laneNumber = scanner.nextInt();
                if (laneNumber < 1 || laneNumber > numberOfLanes) {
                    System.out.println("Invalid lane number. Enter a lane between 1 and " + numberOfLanes + ".");
                } else if (occupiedLanes[laneNumber - 1]) {
                    System.out.println("Lane " + laneNumber + " is already being used.");
                } else {
                    break;
                }
            } while (true);
            scanner.nextLine();

            race.addHorse(horses.get(i - 1), laneNumber);
            occupiedLanes[laneNumber - 1] = true;
        }

        String userInput = "";
        while (!userInput.equals("QUIT")) {
            for (Horse horse : horses) {
                horse.goBackToStart();
            }

            race.startRace();

            System.out.println("Type QUIT to exit or press ENTER to start a new race:");
            userInput = scanner.nextLine();
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}

