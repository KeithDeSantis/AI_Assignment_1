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
    public Set<String> setOfActions;

    public Result() {
        this.score = 0.00;
        this.numActions = 0;
        this.numNodesExpanded = 0;
    }

    public Result(double score, int numActions, int numNodesExpanded, Set<String> setOfActions) {
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

    public Set<String> getSetOfActions() {
        return setOfActions;
    }

    public void setSetOfActions(Set<String> setOfActions) {
        this.setOfActions = setOfActions;
    }

    @Override
    public String toString() {

        Object[] actions = this.setOfActions.toArray();

        StringBuilder strBld = new StringBuilder();

        strBld.append("The run\'s score was " + this.score + ".\n");
        strBld.append("The number of actions taken was " + this.numActions + ".\n");
        strBld.append("The number of nodes expanded was " + this.numNodesExpanded + ".\n");
        strBld.append("The actions taken were:\n");
        for (int i = 0; i < actions.length; i++) {

            strBld.append(actions[i]);

        }

        return strBld.toString();
    }
}
