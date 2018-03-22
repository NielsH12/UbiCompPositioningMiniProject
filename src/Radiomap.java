import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Radiomap {

    private int maxBeacons;
    private List<Datapoint> datapoints;

    Radiomap(int _maxBeacons){
        maxBeacons = _maxBeacons;
        datapoints = new ArrayList<>();
    }

    public void addDataPoint(String csvFile, Position position){
        String line = "";
        String cvsSplitBy = ",";
        int counter = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                if (counter == 0) { // Skip header
                    counter ++;
                    continue;
                }

                String[] nextLine = line.split(cvsSplitBy);
                System.out.println("CSV1: " + nextLine[0] +" CSV2: " + nextLine[1] + " CSV3: " + nextLine[2] + " CSV4: " + nextLine[3]);

                if (counter >= maxBeacons){
                    break;
                }
                counter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
