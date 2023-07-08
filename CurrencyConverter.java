import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {
    private static final String API_KEY = "YOUR_API_KEY";
    private static final String API_URL = "https://openexchangerates.org/api/latest.json?app_id=" + API_KEY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Fetch exchange rates from the API
            String ratesJson = getExchangeRates();
            // Parse the JSON response to get the exchange rates

            // Prompt the user to enter the amount and currencies
            System.out.print("Enter the amount to convert: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter the base currency: ");
            String baseCurrency = scanner.next().toUpperCase();

            System.out.print("Enter the target currency: ");
            String targetCurrency = scanner.next().toUpperCase();

            // Convert the amount
            double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency, ratesJson);

            // Display the result
            System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
        } catch (IOException e) {
            System.out.println("Failed to fetch exchange rates. Please try again later.");
        } catch (Exception e) {
            System.out.println("An error occurred. Please check your input and try again.");
        }

        scanner.close();
    }

    private static String getExchangeRates() throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString();
    }

    private static double convertCurrency(double amount, String baseCurrency, String targetCurrency, String ratesJson) {
        // Implement the currency conversion logic here
        // You'll need to parse the ratesJson to get the exchange rates

        return 0.0; // Placeholder, replace with the actual conversion calculation
    }
}
