public class AccessPoint {
    public String MAC;
    public String SSID;
    public int signalStrength;

    public AccessPoint(String _MAC, String _SSID, int _signalStrength){
        MAC = _MAC;
        SSID = _SSID;
        signalStrength = _signalStrength;
    }
}
