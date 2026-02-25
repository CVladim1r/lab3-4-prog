public class RoundToSquareAdapter implements SquarePeg{
    private RoundPeg roundPeg;

    public RoundToSquareAdapter (RoundPeg roundPeg){
        this.roundPeg = roundPeg;
    }

    @Override
    public double getWight(){
        return roundPeg.getRadius() * 2;
    }
}