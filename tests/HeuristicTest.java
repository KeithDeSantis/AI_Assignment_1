import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeuristicTest {

    @Test
    void firstTest(){
        System.out.println("hello world");
    }

    @Test
    void testZeroH(){
        Assertions.assertEquals(0,
                HeuristicFunction.noHeuristics(CoordinateFactory.makeOrdinaryCoor(0,0),
                        CoordinateFactory.makeOrdinaryCoor(0,0), Direction.N));
    }

    @Test
    void testMinH(){
        Assertions.assertEquals(1,
                HeuristicFunction.MinOfVerticalAndHorizontal.getHeuristics(CoordinateFactory.makeOrdinaryCoor(0,0),
                        CoordinateFactory.makeOrdinaryCoor(1,3), Direction.N));
    }

    @Test
    void testMaxH(){
        Assertions.assertEquals(3,
                HeuristicFunction.MaxOfVerticalAndHorizontal.getHeuristics(CoordinateFactory.makeOrdinaryCoor(0,0),
                        CoordinateFactory.makeOrdinaryCoor(1,3), Direction.N));
    }

    @Test
    void testSumH(){
        Assertions.assertEquals(4,
                HeuristicFunction.SumOfVerticalAndHorizontal.getHeuristics(CoordinateFactory.makeOrdinaryCoor(0,0),
                        CoordinateFactory.makeOrdinaryCoor(1,3), Direction.N));
    }

    @Test
    void customHeuristicTwoTurns1(){
        Assertions.assertEquals(3,
                HeuristicFunction.CustomHeuristic.getHeuristics(CoordinateFactory.makeOrdinaryCoor(-5,0),
                        CoordinateFactory.makeOrdinaryCoor(-4,0), Direction.N));
    }

    @Test
    void customHeuristicTwoTurns2(){
        Assertions.assertEquals(7,
                HeuristicFunction.CustomHeuristic.getHeuristics(CoordinateFactory.makeOrdinaryCoor(0,1),
                        CoordinateFactory.makeOrdinaryCoor(2,-2), Direction.E));
    }

    @Test
    void customHeuristicTwoTurns3(){
        Assertions.assertEquals(6,
                HeuristicFunction.CustomHeuristic.getHeuristics(CoordinateFactory.makeOrdinaryCoor(1,-1),
                        CoordinateFactory.makeOrdinaryCoor(-1,1), Direction.W));
    }

    @Test
    void customHeuristicOneTurn1(){
        Assertions.assertEquals(6,
                HeuristicFunction.CustomHeuristic.getHeuristics(CoordinateFactory.makeOrdinaryCoor(0,1),
                        CoordinateFactory.makeOrdinaryCoor(2,-2), Direction.W));
    }

    @Test
    void customHeuristicOneTurn2(){
        Assertions.assertEquals(5,
                HeuristicFunction.CustomHeuristic.getHeuristics(CoordinateFactory.makeOrdinaryCoor(1,0),
                        CoordinateFactory.makeOrdinaryCoor(1,5), Direction.S));
    }

    @Test
    void customHeuristicZero(){
        Assertions.assertEquals(0,
                HeuristicFunction.CustomHeuristic.getHeuristics(CoordinateFactory.makeOrdinaryCoor(0,1),
                        CoordinateFactory.makeOrdinaryCoor(0,1), Direction.E));
    }


}
