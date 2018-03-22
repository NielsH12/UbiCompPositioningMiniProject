import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Radiomap {
    public int maxBeacons;
    public List<Datapoint> datapoints;

    Radiomap(int _maxBeacons){
        maxBeacons = _maxBeacons;
        datapoints = new ArrayList<>();
    }

    public Position NN(String csvFile){
        System.out.println("Locating.. ");
        double lowestDistance = 9000;

        Datapoint dp = readCSV(csvFile);
        Datapoint nearestPoint = dp;

        for (Datapoint point:datapoints) {
            double newDistance = compareDatapoint(dp, point);
            if (newDistance < lowestDistance){
                lowestDistance = newDistance;
                nearestPoint = point;
            }
        }

        return nearestPoint.position;
    }

    private double compareDatapoint(Datapoint p1, Datapoint p2){
        double distance = 0;
        boolean foundMatch = false;

        for (Datareading x:p1.readings){
            for (Datareading y:p2.readings){
                if (x.address.equals(y.address)){
                    double z = pow(x.signalStrength - y.signalStrength,2);
                    distance += z;
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch){
                distance += 100;
            }
            foundMatch = false;
        }

        return sqrt(distance);
    }

    private Datapoint readCSV(String csvFile){
        String line = "";
        String cvsSplitBy = ",";
        int counter = 0;

        Set<String> legit = new HashSet<>(Arrays.asList("64:f6:9d:21:59", "64:f6:9d:36:85", "64:f6:9d:48:ab", "64:f6:9d:37:a9", "64:f6:9d:43:20",
                "64:f6:9d:43:1b", "64:f6:9d:36:82", "64:f6:9d:37:a5", "64:f6:9d:3a:94", "64:f6:9d:37:a7",
                "64:f6:9d:3a:8a", "64:f6:9d:3a:8f", "64:f6:9d:37:9d"));

        String prevAdr = "";
        String address;
        int strength;
        Datapoint datapoint = new Datapoint(new Position(-1,-1), "");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

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
                } else if (legit.contains(address)) {
                    prevAdr = address;
                    datapoint.addDataReading(address, strength);
                    System.out.println("\taddress: " + address + " signal: " + strength );
                    if (counter >= maxBeacons){
                        break;
                    }
                    counter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datapoint;
    }

    public void addDataPoint(String csvFile, Position position, String _name){
        System.out.println("Adding datapoint: " + _name);
        position.print();

        Datapoint dp = readCSV(csvFile);
        dp.name = _name;
        dp.position = position;

        datapoints.add(dp);
    }
}
