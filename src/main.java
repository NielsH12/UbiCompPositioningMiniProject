public class main {
    public static void main(String argv[]){

        Radiomap rm = new Radiomap(10);

        rm.addDataPoint("C:/Users/Niels Hvid/IdeaProjects/UbiCompPositioningMiniProject/src/measurements/ApStrengthsA.csv", new Position(151, 32)); // AP: A
        rm.addDataPoint("C:/Users/Niels Hvid/IdeaProjects/UbiCompPositioningMiniProject/src/measurements/ApStrengthsB.csv", new Position(83, 169)); // AP: B



        //rm.locate("fileName");
    }
}