public class Geep implements Car {
    @Override
    public void drive(){
        System.out.println("DRIVEE, 0-100 with 30 seconds! All roads possible :)");
    }

    @Override
    public void stop(){
        System.out.println("The car was stopped");
    }
}