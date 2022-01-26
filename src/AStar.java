import java.util.*;

public class AStar {

    HeuristicFunction.heuristicFunction heuristicFunction = HeuristicFunction.NoHeuristics; //TODO temporary for testing

    //s and g should have its priority of 0
    //s should have default dir of N
    public void findPath(int[][] board, Coordinate s, Coordinate g){
        PriorityQueue<Move> pQueue = new PriorityQueue<>(Comparator.comparingInt(Move::getPriority));
        Move firstMove = new Move(s, 0);
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
                Move nextMove = new Move(currentMove, action, board[currentMove.getI()][currentMove.getJ()]);
                if(!Move.isPossible(nextMove.getI(), nextMove.getJ(), iMax, jMax)){
                    continue;
                }
                Set<Coordinate> keys = costSoFar.keySet();
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

                Coordinate nextMoveCoordinate = nextMove.getCoordinate();
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



}
