import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class RecordKeeper {

    private final String pricesFileName = "src/main/resources/prices.csv";
    private final String receiptsFilePath = "src/main/resources/receipts";
    private HashMap<String, Double> itemPrices;

    public void readPricesFromRecords() {
        itemPrices = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pricesFileName))) {

            bufferedReader.readLine(); // Skips over the header of the prices file
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.startsWith("#")) { // Skips to the next line if a line starts with "#", allowing non-price information to be skipped.
                    continue;
                }

                String[] parts = line.split("\\|");

                if (parts.length == 4) {
                    String category = parts[0].trim();
                    String material = parts[1].trim();
                    String type = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());

                    String key = category + "|" + material + "|" + type;
                    itemPrices.put(key, price);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Sorry, I could not find the records you requested.");
        } catch (IOException e) {
            System.err.println("I apologize, something went horribly wrong while searching for those records.");
        }
    }

    public double getReadPrice(String category, String material, String type) {

        String key = category + "|" + material + "|" + type;

        return itemPrices.get(key); // Returns the key's value within the hashmap
    }
}
