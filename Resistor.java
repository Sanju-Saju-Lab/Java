import java.util.Scanner;
import java.util.HashMap;

public class Resistor {

    // Define color codes for resistor bands
    private static final HashMap<String, Integer> COLOR_CODES = new HashMap<>();
    
    // Define multipliers for resistor colors
    private static final HashMap<String, Integer> MULTIPLIERS = new HashMap<>();
    
    // Define tolerance values for resistor colors
    private static final HashMap<String, String> TOLERANCE = new HashMap<>();

    // Static block to initialize the color codes, multipliers, and tolerance values
    static {
        // Initialize color codes (values for the first two bands)
        COLOR_CODES.put("black", 0);
        COLOR_CODES.put("brown", 1);
        COLOR_CODES.put("red", 2);
        COLOR_CODES.put("orange", 3);
        COLOR_CODES.put("yellow", 4);
        COLOR_CODES.put("green", 5);
        COLOR_CODES.put("blue", 6);
        COLOR_CODES.put("violet", 7);
        COLOR_CODES.put("gray", 8);
        COLOR_CODES.put("white", 9);

        // Initialize multipliers (values for the third band)
        MULTIPLIERS.put("black", 1);
        MULTIPLIERS.put("brown", 10);
        MULTIPLIERS.put("red", 100);
        MULTIPLIERS.put("orange", 1000);
        MULTIPLIERS.put("yellow", 10000);
        MULTIPLIERS.put("green", 100000);
        MULTIPLIERS.put("blue", 1000000);
        MULTIPLIERS.put("gold", 1);
        MULTIPLIERS.put("silver", 0.1);

        // Initialize tolerance values (for the fourth band)
        TOLERANCE.put("brown", "±1%");
        TOLERANCE.put("red", "±2%");
        TOLERANCE.put("gold", "±5%");
        TOLERANCE.put("silver", "±10%");
    }

    // Method to calculate resistance from color bands
    public static void calculateResistance() {
        Scanner scanner = new Scanner(System.in);

        // Display available colors for the 1st and 2nd bands
        System.out.println("\nAvailable colors for 1st and 2nd band:");
        COLOR_CODES.keySet().forEach(color -> System.out.print(color + " "));
        System.out.print("\nEnter the 1st color: ");
        String band1 = scanner.nextLine().trim().toLowerCase();  // Get user input for the first band
        System.out.print("Enter the 2nd color: ");
        String band2 = scanner.nextLine().trim().toLowerCase();  // Get user input for the second band

        // Display available colors for the multiplier
        System.out.println("\nAvailable multiplier colors:");
        MULTIPLIERS.keySet().forEach(color -> System.out.print(color + " "));
        System.out.print("\nEnter the multiplier color: ");
        String multiplier = scanner.nextLine().trim().toLowerCase();  // Get user input for the multiplier band

        // Display available colors for tolerance
        System.out.println("\nAvailable tolerance colors:");
        TOLERANCE.keySet().forEach(color -> System.out.print(color + " "));
        System.out.print("\nEnter the tolerance color: ");
        String tolerance = scanner.nextLine().trim().toLowerCase();  // Get user input for tolerance band

        // Validate the user input and calculate the resistance
        if (COLOR_CODES.containsKey(band1) && COLOR_CODES.containsKey(band2) && MULTIPLIERS.containsKey(multiplier)) {
            int resistance = (COLOR_CODES.get(band1) * 10 + COLOR_CODES.get(band2)) * MULTIPLIERS.get(multiplier);
            String toleranceValue = TOLERANCE.getOrDefault(tolerance, "Unknown tolerance");  // Get tolerance if valid
            System.out.println("\nResistance: " + resistance + " Ω " + toleranceValue);
        } else {
            System.out.println("\nInvalid color code entered. Please try again.");  // Error message for invalid input
        }
    }

    // Method to suggest color bands based on a given resistance value
    public static void suggestColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the resistance value in Ω: ");
        double resistance = scanner.nextDouble();  // Get resistance input from the user
        scanner.nextLine();  // Consume the newline character
        System.out.print("Enter the tolerance (1%, 2%, 5%, or 10%): ");
        String tolerance = scanner.nextLine().trim().toLowerCase();  // Get tolerance input from the user

        // Check for matching color bands for the given resistance value
        for (String band1 : COLOR_CODES.keySet()) {
            for (String band2 : COLOR_CODES.keySet()) {
                for (String multiplierColor : MULTIPLIERS.keySet()) {
                    // Calculate resistance based on current color bands
                    double calculatedResistance = (COLOR_CODES.get(band1) * 10 + COLOR_CODES.get(band2)) * MULTIPLIERS.get(multiplierColor);
                    // Check if the calculated resistance matches the input resistance
                    if (Math.abs(calculatedResistance - resistance) < 0.001) {
                        // Find the corresponding tolerance color
                        String toleranceColor = TOLERANCE.entrySet().stream()
                                .filter(entry -> entry.getValue().equals("±" + tolerance + "%"))
                                .map(entry -> entry.getKey())
                                .findFirst()
                                .orElse(null);
                        if (toleranceColor != null) {
                            // Output the color bands corresponding to the resistance value
                            System.out.println("\nColor Bands: " + band1 + ", " + band2 + ", " + multiplierColor + ", " + toleranceColor);
                            return;
                        } else {
                            System.out.println("\nInvalid tolerance value entered.");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("\nNo matching color code found.");  // If no match is found, display this message
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Display the menu with available options
            System.out.println("\nChoose an option:");
            System.out.println("1. Calculate resistance from color bands.");
            System.out.println("2. Suggest color bands from resistance.");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            // Execute the appropriate method based on user input
            switch (choice) {
                case "1":
                    calculateResistance();  // Call the method to calculate resistance
                    break;
                case "2":
                    suggestColor();  // Call the method to suggest color bands
                    break;
                case "3":
                    System.out.println("\nExiting the program. Goodbye!");
                    return;  // Exit the program
                default:
                    System.out.println("\nInvalid choice. Please try again.");  // Error message for invalid choice
            }
        }
    }
}
