import java.util.concurrent.TimeUnit;
import java.lang.Math;

/**
 @author Fowzan Raja
 @version 2.0
 */

public class Race
{
    private int raceLength;
    private Horse lane1Horse;
    private Horse lane2Horse;
    private Horse lane3Horse;

    public Race(int distance)
    {
        raceLength = distance;
        lane1Horse = null;
        lane2Horse = null;
        lane3Horse = null;
    }
    
    public void addHorse(Horse theHorse, int laneNumber)
    {
        if (laneNumber == 1)
        {
            lane1Horse = theHorse;
        }
        else if (laneNumber == 2)
        {
            lane2Horse = theHorse;
        }
        else if (laneNumber == 3)
        {
            lane3Horse = theHorse;
        }
        else
        {
            System.out.println("Cannot add horse to lane " + laneNumber + " because there is no such lane");
        }
    }
    
    public void startRace()
    {
        boolean finished = false;
        
        lane1Horse.goBackToStart();
        lane2Horse.goBackToStart();
        lane3Horse.goBackToStart();
                      
        while (!finished)
        {
            moveHorse(lane1Horse);
            moveHorse(lane2Horse);
            moveHorse(lane3Horse);

            if (raceWonBy(lane1Horse)) {
                lane1Horse.setConfidence(lane1Horse.getConfidence() + 0.1);
            } else if (raceWonBy(lane2Horse)) {
                lane2Horse.setConfidence(lane2Horse.getConfidence() + 0.1);
            } else if (raceWonBy(lane3Horse)) {
                lane3Horse.setConfidence(lane3Horse.getConfidence() + 0.1);
            }
                        
            printRace();
            
            if (raceWonBy(lane1Horse)) {
                System.out.println("And the winner is... " + lane1Horse.getName() + "!");
                finished = true;
            } else if (raceWonBy(lane2Horse)) {
                System.out.println("And the winner is... " + lane2Horse.getName() + "!");
                finished = true;
            } else if (raceWonBy(lane3Horse)) {
                System.out.println("And the winner is... " + lane3Horse.getName() + "!");
                finished = true;
            }
           
            try{ 
                TimeUnit.MILLISECONDS.sleep(100);
            }catch(Exception e){}
        }
    }
    
    private void moveHorse(Horse theHorse)
    {
        if  (!theHorse.hasFallen())
        {
            if (Math.random() < theHorse.getConfidence())
            {
               theHorse.moveForward();
            }
            
            if (Math.random() < (0.1*theHorse.getConfidence()*theHorse.getConfidence()))
            {
                theHorse.fall();
            }
        }
    }
        
    private boolean raceWonBy(Horse theHorse)
    {
        if (theHorse.getDistanceTravelled() == raceLength)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void printRace() {
        System.out.print('\u000C');  // Clear the terminal window

        multiplePrint('=', raceLength + 4); // Top edge of the track
        System.out.println();

        printLane(lane1Horse);
        System.out.println();

        printLane(lane2Horse);
        System.out.println();

        printLane(lane3Horse);
        System.out.println();

        multiplePrint('=', raceLength + 4); // Bottom edge of the track
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

    private void multiplePrint(char aChar, int times)
    {
        int i = 0;
        while (i < times)
        {
            System.out.print(aChar);
            i = i + 1;
        }
    }
}
