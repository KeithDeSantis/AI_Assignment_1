import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeuristicTest {

    @Test
    void firstTest(){
        System.out.println("hello world");
    }

    @Test
    void testZeroH(){
        Assertions.assertEquals(0, HeuristicFunction.noHeuristics(CoordinateFactory.makeOrdinaryCoor(0,0), CoordinateFactory.makeOrdinaryCoor(0,0)));
    }

    @Test
    void testMinH(){
        Assertions.assertEquals(1, HeuristicFunction.MinOfVerticalAndHorizontal.getHeuristics(CoordinateFactory.makeOrdinaryCoor(0,0), CoordinateFactory.makeOrdinaryCoor(1,3)));
    }

    @Test
    void testMaxH(){
        Assertions.assertEquals(3, HeuristicFunction.MaxOfVerticalAndHorizontal.getHeuristics(CoordinateFactory.makeOrdinaryCoor(0,0), CoordinateFactory.makeOrdinaryCoor(1,3)));
    }

    @Test
    void testSumH(){
        Assertions.assertEquals(4, HeuristicFunction.SumOfVerticalAndHorizontal.getHeuristics(CoordinateFactory.makeOrdinaryCoor(0,0), CoordinateFactory.makeOrdinaryCoor(1,3)));
    }
}
