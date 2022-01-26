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

    private static CostFinder Forward = (int terrainCost, int totalCost) -> {
        return terrainCost + totalCost;
    };

    private static CostFinder Bash = (int terrainCost, int totalCost) -> {
        return 3 + totalCost;
    };

    private static CostFinder Turn = (int terrainCost, int totalCost) -> {
        return (int)Math.ceil(terrainCost * .5) + totalCost;
    };
}
