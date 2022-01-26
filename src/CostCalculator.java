public class CostCalculator {

    public static int getNewCost(int terrainCost, int totalCost, Action action){
        switch(action){
            case Left:
            case Right:
                return Turn.findCost(terrainCost, totalCost);
            case Bash:
                return Bash.findCost(terrainCost, totalCost);
            case Forward:
                return Forward.findCost(terrainCost, totalCost);
            default:
                throw new Error("Invalid Action");
        }

    }

    private static final CostFinder Forward = Integer::sum;

    private static final CostFinder Bash = (int terrainCost, int totalCost) -> 3 + totalCost;

    private static final CostFinder Turn = (int terrainCost, int totalCost) -> (int)Math.ceil(terrainCost * .5) + totalCost;
}
