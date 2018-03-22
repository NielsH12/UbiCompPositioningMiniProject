import java.util.ArrayList;
import java.util.List;

public class Datapoint {
    Position position;

    private List<Datareading> reading;

    Datapoint(Position _position){
        position = _position;
        reading = new ArrayList<>();
    }

    public void addDataReading(String addr, int SignalStrength){
        reading.add(new Datareading(addr, SignalStrength))
    }
}
