public class CarSelector {
    public static Car getCar(RoadType roadType) {
        Car car = null;

        switch (roadType) {
            case CITY:
                car = new Porsche();
                System.out.println("New porshe activated");
                break;
            case OFF_ROAD:
                car = new Geep();
                System.out.println("New geep activated now!");
                break;
        }

        return car;
    }
}