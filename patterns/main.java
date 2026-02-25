public class main {
    public static boolean fitsInSquareHoll(RoundToSquareAdapter rtsa, double holl){
        return rtsa.getWight() <= holl;
    }

    public static void main(String args[]){

        // SingleTon
        TestSingleton.getInstance().print();

        // Factory
        Car car = CarSelector.getCar(RoadType.CITY);
        car.drive();

        // Adapter
        // Пролезет ли круглая тема в квадратную дырку (изначально имеем только радиус)?
        RoundPeg roundPeg = new RoundPeg(3.0);
        RoundToSquareAdapter rtsa = new RoundToSquareAdapter(roundPeg);
        boolean result = fitsInSquareHoll(rtsa, 5.0);
        System.out.println("True??" + result);

    }
}
