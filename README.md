# Horse Race Simulator

## Overview
This is a Java-based console game that simulates a horse race. The user can change the race length, number of horses, and assign lanes to each horse. Each horse has a confidence level which affects its likelihood of moving faster but also its chance of falling.

---

## Project Setup Instructions

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command prompt

### Steps to Run the Project Locally
1. Download the repository to your local machine.
2. Go to the `Part1` folder.
3. Compile the Java files using:
   ```sh
   javac *.java
   ```
4. Run the game using:
   ```sh
   java Main
   ```

---

## Dependencies & Usage Guidelines

### Dependencies
This game does not require any external libraries or dependencies as they are all included in the JDK.

### Usage Instructions
1. **Start the Application**: Run the `Main` class.
2. **Using the Race**:
   - Choose the race distance.
   - Specify the number of horses.
   - For each horse:
     - Give a name.
     - Give a symbol.
     - Give a confidence level between 0.0 and 1.0 (exclusive).
   - Assign which lane each horse will be running on.
3. **The Actual Race**:
   - The race will start the current race will be displayed in terminal.
   - The race will end if a horse reaches the finish line or all the horses fall.
4. **Repeat or Exit**:
   - After the race, you can type `QUIT` to exit or press `ENTER` to start a new race.

---

## Additional Notes
- The confidence level of a horse increases slightly after winning a race, making it more likely to succeed in subsequent races.
