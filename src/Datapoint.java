import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Datapoint {
    public String name;
    public Position position;

    public List<Datareading> readings;

    Datapoint(Position _position, String _name){
        position = _position;
        name = _name;
        readings = new ArrayList<>();
    }

    public void addDataReading(String addr, int SignalStrength){
        //Optional<Datareading> result = readings.stream().filter(obj -> obj.address.equals(addr)).findAny();
        //if (result.isPresent()){
        //    return;
        //}
        readings.add(new Datareading(addr, SignalStrength));
    }
}
