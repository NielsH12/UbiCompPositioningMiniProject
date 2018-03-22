public class main {
    public static void main(String argv[]){

        Radiomap rm = new Radiomap(10);

        String path = "C:/Users/Niels Hvid/IdeaProjects/UbiCompPositioningMiniProject/src/measurements/";

        rm.addDataPoint(path + "ApStrengthsBravo.csv", new Position(83, 169), "Bravo");
        rm.addDataPoint(path + "ApStrengthsCharlie.csv", new Position(86,371), "Charlie");
        rm.addDataPoint(path + "ApStrengthsDelta.csv", new Position(85,500),"Delta");
        rm.addDataPoint(path + "ApStrengthsIndia.csv", new Position(226,278), "India");
        rm.addDataPoint(path + "ApStrengthsLima.csv", new Position(364,170), "Lima");
        rm.addDataPoint(path + "ApStrengthsMike.csv", new Position(365,327), "Mike");
        rm.addDataPoint(path + "ApStrengthsNovember.csv", new Position(326,446), "November");

        Position position = rm.NN(path + "Test/ApStrengthsTest.csv");
        position.print();
    }
}