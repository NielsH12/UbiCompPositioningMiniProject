import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Datapoint {
    private Position position;

    private List<Datareading> readings;

    Datapoint(Position _position){
        position = _position;
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
