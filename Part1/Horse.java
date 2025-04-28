/**
 Represents a horse in the race simulation.
 
 @author Fowzan Raja
 @version 1.0
 */

public class Horse {
    private char symbol;
    private String name;
    private int distanceTravelled;
    private boolean fallen;
    private double confidence; 

    public Horse(char horseSymbol, String horseName, double horseConfidence) {
        this.symbol = horseSymbol;
        this.name = horseName;
        this.confidence = horseConfidence;
        this.distanceTravelled = 0;
        this.fallen = false;
    }

    public void fall() {
        this.fallen = true;

        setConfidence(getConfidence() - 0.1);
    }

    public double getConfidence() {
        return this.confidence;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void goBackToStart() {
        this.distanceTravelled = 0;
        this.fallen = false;
    }

    public boolean hasFallen() {
        return this.fallen;
    }

    public void moveForward() {
        if (!this.fallen) {
            this.distanceTravelled++;
        }
    }

    public void setConfidence(double newConfidence) {
        if (newConfidence > 0 && newConfidence <= 1) {
            this.confidence = newConfidence;
        }
    }

    public void setSymbol(char newSymbol) {
        this.symbol = newSymbol;
    }
}