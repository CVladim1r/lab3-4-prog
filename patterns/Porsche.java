public class Porsche implements Car{
    @Override
    public void drive(){
        System.out.println("DRIVEE, 0-100 with 3 seconds!");
    }
    @Override
    public void stop(){
        System.out.println("The car was stopped");
    }
}