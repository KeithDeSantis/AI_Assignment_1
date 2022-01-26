import java.util.*;

public class AStar {



    //s and g should have its priority of 0
    //s should have default dir of N
    public void findPath(String[][] board, Coordinate s, Coordinate g){
        PriorityQueue<Coordinate> pQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.priority));
        pQueue.add(s);
        Map<Coordinate,Coordinate> cameFrom = new HashMap<>();
        Map<Coordinate, Integer> costSoFar = new HashMap<>();
        cameFrom.put(s, null);
        costSoFar.put(s,0);

        while(!pQueue.isEmpty()){
            Move currentMove = pQueue.poll();
            Direction curDir = currentMove.getDirection();

            boolean hasBashed = false;
            if(cur.equals(g)) return;
            for (Action action: Action.values()) {
                int new_cost = 0;
                int nextI = 0, nextJ = 0;
                Coordinate next=null;
                Set<Coordinate> keys = costSoFar.keySet();
                if(action.equals(Action.Forward) || hasBashed){ //case moving forward
                    //next coor's i j
                    nextI = cur.i+ curDir.i;
                    nextJ = cur.j+ curDir.j;
                    if(nextI < 0 || nextJ < 0){
                        continue;
                    }
                    next = CoordinateFactory.makeOrdinaryCoor(nextI, nextJ);
                    //cost based on terrain complexity
                    new_cost = costSoFar.get(cur) + Integer.parseInt(board[nextI][nextJ]);
                }

                if(action.equals(Action.Bash)){
                    nextI = cur.i+ curDir.i;
                    nextJ = cur.j+ curDir.j;
                    if(nextI < 0 || nextJ < 0){
                        continue;
                    }
                    next = CoordinateFactory.makeOrdinaryCoor(nextI, nextJ);
                    //cost based on terrain complexity
                    new_cost = costSoFar.get(cur) + 3; //bash ignores the cost
                    hasBashed = true;
                }

                if(action.equals(Action.Left) || action.equals(Action.Right)){
                    Direction newDir = null;
                    if(action.equals(Action.Left)){
                        newDir = findDirAfterTurnLeft(curDir);
                    }else{
                        newDir = findDirAfterTurnRight(curDir);
                    }
                    next = CoordinateFactory.makeOrdinaryCoor(cur.i, cur.j);
                    next.setDirection(newDir);
                    new_cost = (int)Math.ceil(1.5 * costSoFar.get(cur));
                }



                //update the queue accordingly
                if(!keys.contains(nextMoveCoordinate) || nextMove.getTotalCost() < costSoFar.get(nextMoveCoordinate)){
                    costSoFar.put(nextMoveCoordinate, nextMove.getTotalCost());
                    int heuristic = heuristicFunction.getHeuristics(nextMove.getCoordinate(), g);
                    nextMove.setPriority(heuristic);
                    pQueue.add(nextMove);
                    cameFrom.put(nextMove.getCoordinate(), currentMove.getCoordinate());

                    if(hasBashed){// removes the flag
                        hasBashed = false;
                        break;
                    }
                }
            }
        }

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


}
