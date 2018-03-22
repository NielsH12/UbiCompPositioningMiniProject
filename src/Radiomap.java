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

    public Position locate(String csvFile){
            
        return new Position(0,0);
    }

    public void addDataPoint(String csvFile, Position position){
        String line = "";
        String cvsSplitBy = ",";
        int counter = 0;

        String prevAdr = "";
        String address;
        int strength;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            Datapoint datapoint = new Datapoint(position);

            while ((line = br.readLine()) != null) {
                if (counter == 0) { // Skip header
                    counter ++;
                    continue;
                }

                String[] nextLine = line.split(cvsSplitBy);

                strength = Integer.parseInt(nextLine[3].replaceAll("\\s+",""));

                address = nextLine[1].replaceAll("\\s+","");
                address = address.substring(0, address.length() - 3);

                if (address.equals(prevAdr)) {
                    continue;
                } else {
                    prevAdr = address;
                }
                datapoint.addDataReading(address, strength);

                if (counter >= maxBeacons){
                    break;
                }
                counter++;
            }
            datapoints.add(datapoint);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
