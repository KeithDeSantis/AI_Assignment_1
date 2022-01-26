import java.util.*;

public class AStar {

    HeuristicFunction.heuristicFunction heuristicFunction = HeuristicFunction.NoHeuristics; //TODO temporary for testing

    public AStar(HeuristicFunction.heuristicFunction heuristicFunction){
        this.heuristicFunction = heuristicFunction;
    }

    //s and g should have its priority of 0
    //s should have default dir of N
    private Move generatePath(int[][] board, Coordinate s, Coordinate g){
        PriorityQueue<Move> pQueue = new PriorityQueue<Move>(Comparator.comparingInt(Move::getPriority));
        firstMove = new Move(s, 0);
        firstMove.setDirection(Direction.N);
        pQueue.add(firstMove);
        Map<Coordinate,Coordinate> cameFrom = new HashMap<>();
        Map<Coordinate, Integer> costSoFar = new HashMap<>();
        cameFrom.put(s, null);
        costSoFar.put(s,0);

        int iMax = board.length;
        int jMax = board[0].length;

        while(!pQueue.isEmpty()){
            Move currentMove = pQueue.poll();
            Direction curDir = currentMove.getDirection();

            boolean hasBashed = false;
            if(currentMove.getCoordinate().equals(g)) return; // deals with edge case that start and goal are the same
            for (Action action: Action.values()) {

                if(!currentMove.isPossible(action)) continue;
                Move nextMove;
                try {
                    nextMove = new Move(currentMove, action, board);
                } catch (OutBoundsError e) { continue; }

                Set<Move> keys = costSoFar.keySet();

                Coordinate nextMoveCoordinate = nextMove.getCoordinate();
                //update the queue accordingly
                if(!keys.contains(nextMoveCoordinate) || nextMove.getTotalCost() < costSoFar.get(nextMoveCoordinate)){
                    costSoFar.put(nextMoveCoordinate, nextMove.getTotalCost());
                    int heuristic = heuristicFunction.getHeuristics(nextMove.getCoordinate(), g);
                    nextMove.setPriority(heuristic);
                    pQueue.add(nextMove);
                    numNodesExpanded++;
                    cameFrom.put(nextMove, currentMove);

                }
            }
        }
    }
}


/*                int new_cost = 0;
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
                }*/

