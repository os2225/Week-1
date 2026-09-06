import java.util.Random;

public class BMICalculator {

    // Method to classify BMI
    public static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } 
        else if (bmi < 25) {
            return "Normal";
        } 
        else if (bmi < 30) {
            return "Overweight";
        } 
        else {
            return "Obese";
        }
    }

    // Method to print the wellness report
    public static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println("\n================ WELLNESS REPORT ================");

        System.out.printf("%-10s %-15s %-15s %-10s %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);

            String status = getBmiStatus(bmi);

            System.out.printf("%-10d %-15.2f %-15.2f %-10.2f %-15s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {

        Random random = new Random();

        int people = 10;

        double[] heights = new double[people];
        double[] weights = new double[people];

        // Generate random height and weight
        for (int i = 0; i < people; i++) {

            // Height between 1.50 and 1.90 meters
            heights[i] = 1.50 + (1.90 - 1.50) * random.nextDouble();

            // Weight between 45 and 100 kg
            weights[i] = 45 + (100 - 45) * random.nextDouble();
        }

        // Print report
        printWellnessReport(heights, weights);
    }
}