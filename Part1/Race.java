import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Race {
    private int raceLength;
    private ArrayList<Horse> lanes;

    public Race(int distance) {
        raceLength = distance;
        lanes = new ArrayList<>();
    }

    public void addHorse(Horse theHorse, int laneNumber) {
        while (lanes.size() < laneNumber) {
            lanes.add(null);
        }
        lanes.set(laneNumber - 1, theHorse);
    }

    public void startRace() {
        boolean finished = false;

        for (Horse horse : lanes) {
            if (horse != null) {
                horse.goBackToStart();
            }
        }

        printRace();

        while (!finished) {
            boolean allFallen = true;

            for (Horse horse : lanes) {
                if (horse != null) {
                    moveHorse(horse);
                    if (!horse.hasFallen()) {
                        allFallen = false;
                    }
                }
            }

            if (allFallen) {
                printRace();
                System.out.println("All the horses have fallen.");
                break;
            }

            for (Horse horse : lanes) {
                if (horse != null && raceWonBy(horse)) {
                    horse.setConfidence(horse.getConfidence() + 0.1);
                    printRace();
                    System.out.println("And the winner is... " + horse.getName() + "!");
                    finished = true;
                    break;
                }
            }

            if (!finished) {
                printRace();
            }

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (Exception e) {
            }
        }
    }

    private void moveHorse(Horse theHorse) {
        if (!theHorse.hasFallen()) {
            if (Math.random() < theHorse.getConfidence()) {
                theHorse.moveForward();
            }

            if (Math.random() < (0.1 * theHorse.getConfidence() * theHorse.getConfidence())) {
                theHorse.fall();
            }
        }
    }

    private boolean raceWonBy(Horse theHorse) {
        return theHorse.getDistanceTravelled() == raceLength;
    }

    private void printRace() {
        clearScreen();

        multiplePrint('=', raceLength + 4);
        System.out.println();

        for (int i = 0; i < lanes.size(); i++) {
            Horse horse = lanes.get(i);
            if (horse != null) {
                printLane(horse);
            } else {
                System.out.print("|" + " ".repeat(raceLength) + "  |");
            }
            System.out.println();
        }

        multiplePrint('=', raceLength + 4);
        System.out.println();
    }

    private void printLane(Horse theHorse) {
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();

        System.out.print('|');

        multiplePrint(' ', spacesBefore);

        if (theHorse.hasFallen()) {
            System.out.print('❌');
        } else {
            System.out.print(theHorse.getSymbol() + " ");
        }

        multiplePrint(' ', spacesAfter);

        System.out.print('|');

        System.out.print(" " + theHorse.getName() + " (Current confidence " + theHorse.getConfidence() + ")");
    }

    private void multiplePrint(char aChar, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(aChar);
        }
    }

    private void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Error clearing screen: " + e.getMessage());
        }
    }
}