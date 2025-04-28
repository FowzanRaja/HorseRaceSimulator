# Horse Race Simulator

## Overview
The Horse Race Simulator is a Java-based console application that simulates a horse race. Users can configure the race length, number of horses, and assign lanes to each horse. The race progresses with each horse moving forward based on its confidence level, and the winner is determined when a horse reaches the finish line.

---

## Project Setup Instructions

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- A terminal or command prompt to run the application

### Steps to Run the Project Locally
1. Clone or download the repository to your local machine.
2. Navigate to the `Part1` directory where the source files are located.
3. Compile the Java files using the following command:
   ```sh
   javac *.java
   ```
4. Run the application using the following command:
   ```sh
   java Main
   ```

---

## Dependencies & Usage Guidelines

### Dependencies
This project does not require any external libraries or dependencies. It uses only the standard Java Development Kit (JDK) classes.

### Usage Instructions
1. **Start the Application**: Run the `Main` class as described in the setup instructions.
2. **Configure the Race**:
   - Enter the race length (must be a positive integer).
   - Specify the number of horses participating in the race.
   - For each horse:
     - Provide a name.
     - Assign a single-character symbol.
     - Set a confidence level between 0.0 and 1.0 (exclusive).
   - Assign lanes to each horse (ensure the number of lanes is greater than or equal to the number of horses).
3. **Run the Race**:
   - The race will start, and the progress of each horse will be displayed in the console.
   - The race ends when a horse reaches the finish line or all horses fall.
4. **Repeat or Exit**:
   - After the race, you can type `QUIT` to exit or press `ENTER` to start a new race.

---

## Additional Notes
- The confidence level of a horse increases slightly after winning a race, making it more likely to succeed in subsequent races.