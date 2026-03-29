import java.util.Scanner; // Import the Scanner class for user input

// Base class representing a generic sports match
class Match {
    protected String team1;
    protected String team2;
    protected String venue;

    public Match(String team1, String team2, String venue) {
        this.team1 = team1;
        this.team2 = team2;
        this.venue = venue;
    }

    public void displayMatchDetails() {
        System.out.println("Match: " + team1 + " vs " + team2);
        System.out.println("Venue: " + venue);
    }
}

// Derived class specifically for Cricket
class CricketMatch extends Match {
    private String matchFormat;
    private int runsTeam1;
    private int wicketsTeam1;
    private int runsTeam2;
    private int wicketsTeam2;

    public CricketMatch(String team1, String team2, String venue, String matchFormat,
                        int runsTeam1, int wicketsTeam1, int runsTeam2, int wicketsTeam2) {
        super(team1, team2, venue);
        this.matchFormat = matchFormat;
        this.runsTeam1 = runsTeam1;
        this.wicketsTeam1 = wicketsTeam1;
        this.runsTeam2 = runsTeam2;
        this.wicketsTeam2 = wicketsTeam2;
    }

    public void displayResult() {
        displayMatchDetails();
        System.out.println("Format: " + matchFormat);
        System.out.println("-------------------------");
        System.out.println(team1 + " Score: " + runsTeam1 + "/" + wicketsTeam1);
        System.out.println(team2 + " Score: " + runsTeam2 + "/" + wicketsTeam2);
        System.out.println("-------------------------");

        if (runsTeam1 > runsTeam2) {
            System.out.println("Result: " + team1 + " won by " + (runsTeam1 - runsTeam2) + " runs.");
        } else if (runsTeam2 > runsTeam1) {
            System.out.println("Result: " + team2 + " won the match!");
        } else {
            System.out.println("Result: The match ended in a tie.");
        }
    }
}

// Main class to execute the program
public class Program5 {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Enter Match Details ===");
        
        System.out.print("Enter Team 1 Name: ");
        String team1 = scanner.nextLine();

        System.out.print("Enter Team 2 Name: ");
        String team2 = scanner.nextLine();

        System.out.print("Enter Venue: ");
        String venue = scanner.nextLine();

        System.out.print("Enter Match Format (e.g., T20, ODI): ");
        String matchFormat = scanner.nextLine();

        System.out.println("\n=== Enter Score Details ===");
        
        System.out.print("Enter " + team1 + " Runs: ");
        int runsT1 = scanner.nextInt();
        
        System.out.print("Enter " + team1 + " Wickets: ");
        int wkT1 = scanner.nextInt();

        System.out.print("Enter " + team2 + " Runs: ");
        int runsT2 = scanner.nextInt();
        
        System.out.print("Enter " + team2 + " Wickets: ");
        int wkT2 = scanner.nextInt();

        // Creating an object of the derived class using the inputs
        CricketMatch match = new CricketMatch(team1, team2, venue, matchFormat, runsT1, wkT1, runsT2, wkT2);
        
        System.out.println("\n=== Final Match Summary ===");
        match.displayResult();

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}