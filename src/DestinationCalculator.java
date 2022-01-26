public class DestinationCalculator {

    public static Coordinate getNewCoordinate(Coordinate current, Action action){
        switch(action){
            case Left:
            case Right:
                return Turn.findDestination(current);
            case Bash:
            case Forward:
                return MoveInDirection.findDestination(current);
            default:
                throw new Error("Invalid Action");
        }

    }

    private static DestinationFinder MoveInDirection = (Coordinate current) -> {
        return new Coordinate(current.getI() + current.direction.i,  current.getI() + current.direction.j);
    };

    private static DestinationFinder Turn = (Coordinate current) -> {
        return current;
    };

}
