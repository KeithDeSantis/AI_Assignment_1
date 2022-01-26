import java.util.*;

public class AStar {

    HeuristicFunction.heuristicFunction heuristicFunction = HeuristicFunction.NoHeuristics; //TODO temporary for testing

    public AStar(HeuristicFunction.heuristicFunction heuristicFunction){
        this.heuristicFunction = heuristicFunction;
    }

    public Result findPath(int[][] board, Coordinate s, Coordinate g) {
        Move lastMove = generatePath(board, s, g);

        if(lastMove == null)
            return null;

        ArrayList<Move> paths = buildPath(lastMove, firstMove);
        double score = 100 - lastMove.getTotalCost();
        int numActions = paths.size();

        return new Result(score, numActions, numNodesExpanded, paths);
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

    public ArrayList<Move> buildPath(Move lastMove, Move firstMove) {

        ArrayList<Move> movesTaken = new ArrayList<Move>();
        Stack<Move> tempStack = new Stack();

        Move current = lastMove;

        // traverse path in reverse pushing moves onto the stack
        while(!current.equals(firstMove)){
            tempStack.add(current);
            current = cameFrom.get(current);
        }

        // Add the first move to the array
        movesTaken.add(firstMove);

        // Pop the stack to build the path from start to end
        while (!tempStack.isEmpty())
            movesTaken.add(tempStack.pop());

        return movesTaken;

    }
}

