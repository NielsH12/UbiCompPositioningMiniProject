public class main {
    public static void main(String argv[]){

        Radiomap rm = new Radiomap(10);

        rm.addDataPoint("C:\\Users\\Niels Hvid\\IdeaProjects\\UbiCompPositioningMiniProject\\src\\measurements/ApStrengthsA.csv", new Position(0, 0)); // AP: A
        //rm.addAP("ApStrengthsB.csv", new Position(0, 0)); // AP: B



        //rm.locate("fileName");
    }
}