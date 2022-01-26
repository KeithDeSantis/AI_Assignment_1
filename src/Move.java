public class Move {
    private Coordinate coordinate;
    private Direction direction;
    private int priority = 0;
    private int totalCost = 0;

    public Move(Move move, Action action, int terrainCost){
        this.direction = findDirection(action, move.direction);
        this.totalCost = CostCalculator.getNewCost(terrainCost, move.totalCost, action);
        this.coordinate = DestinationCalculator.getNewCoordinate(move, action);

    }

    public Move(Coordinate coordinate, int priority){
        this.coordinate = coordinate; //TODO should we set the direction of the move to the coords direction here to avoid null pointers?
        this.priority = priority;
    }

    public Direction findDirection(Action action, Direction currentDirection){
        if(action.equals(Action.Left))
            return findDirAfterTurnLeft(currentDirection);
        else if(action.equals(Action.Right))
            return findDirAfterTurnRight(currentDirection);
        else
            return currentDirection;
    }

    public Direction findDirAfterTurnLeft(Direction direction){
        switch (direction){
            case E: return Direction.N;
            case S: return Direction.E;
            case N: return Direction.W;
            case W: return Direction.S;
        }
        //should never reach here
        return direction;
    }

    public Direction findDirAfterTurnRight(Direction direction){
        switch (direction){
            case E: return Direction.S;
            case S: return Direction.W;
            case N: return Direction.E;
            case W: return Direction.N;
        }
        //should never reach here
        return direction;
    }


    public static boolean isPossible(int i, int j, int iMax, int jMax){
        return i >= 0 && j >= 0
                && j < iMax && i < jMax;

    }

    public int getPriority(){
        return priority;
    }

    public Coordinate createCoordinateWithHeuristic(int heuristic){
        coordinate.priority = totalCost + heuristic;
        return coordinate;
    }

    public void setPriority(int heuristicValue)
    {
        this.priority = totalCost + heuristicValue;
    }

    public int getTotalCost(){
        return totalCost;
    }


    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getI() {
        return coordinate.getI();
    }

    public int getJ() {
        return coordinate.getJ();
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
