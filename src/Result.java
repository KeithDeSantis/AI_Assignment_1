import java.util.Set;
import java.lang.StringBuilder;

/**
 * Class that represents the result of a search.
 * Will hold all info we will print out for a search.
 */
public class Result {

    public double score;
    public int numActions;
    public int numNodesExpanded;
    public ArrayList<Move> setOfActions = null;

    public Result() {
        this.score = 0.00;
        this.numActions = 0;
        this.numNodesExpanded = 0;
    }

    public Result(double score, int numActions, int numNodesExpanded, ArrayList<Move> setOfActions) {
        this.score = score;
        this.numActions = numActions;
        this.numNodesExpanded = numNodesExpanded;
        this.setOfActions = setOfActions;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumActions() {
        return numActions;
    }

    public void setNumActions(int numActions) {
        this.numActions = numActions;
    }

    public int getNumNodesExpanded() {
        return numNodesExpanded;
    }

    public void setNumNodesExpanded(int numNodesExpanded) {
        this.numNodesExpanded = numNodesExpanded;
    }

    public ArrayList<Move> getSetOfActions() {
        return setOfActions;
    }

    public void setSetOfActions(ArrayList<Move> setOfActions) {
        this.setOfActions = setOfActions;
    }

    @Override
    public String toString() {

        StringBuilder strBld = new StringBuilder();

        strBld.append("The run\'s score was " + this.score + ".\n");
        strBld.append("The number of actions taken was " + this.numActions + ".\n");
        strBld.append("The number of nodes expanded was " + this.numNodesExpanded + ".\n");
        strBld.append("The actions taken were:\n");
        for ( int i = 1; i < this.setOfActions.size(); i++) {
            strBld.append(this.setOfActions.get(i) + "\n");
        }

        return strBld.toString();
    }
}
