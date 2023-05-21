package mk.ukim.finki;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class lab_exampleTest {

    private List<Double> list(Double... elems){
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void everyStatementTest() {
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> lab_example.sumOfPricesGreaterThan(null, 5d));
        assertTrue(ex.getMessage().contains("List of prices is not ok"));

        ex = assertThrows(RuntimeException.class,
                () -> lab_example.sumOfPricesGreaterThan(list(1d,3d,-2d), 2d));
        assertTrue(ex.getMessage().contains("Negative price is not allowed"));

        assertEquals(9d, lab_example.sumOfPricesGreaterThan(list(1d,4d,5d),3d));
    }

    //istite testovi minat
    @Test
    void everyBranchTest(){
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> lab_example.sumOfPricesGreaterThan(null, 5d));
        assertTrue(ex.getMessage().contains("List of prices is not ok"));

        ex = assertThrows(RuntimeException.class,
                () -> lab_example.sumOfPricesGreaterThan(list(1d,3d,-2d), 2d));
        assertTrue(ex.getMessage().contains("Negative price is not allowed"));

        assertEquals(9d, lab_example.sumOfPricesGreaterThan(list(1d,4d,5d),3d));
    }

    @Test
    void everyPathTest(){
        //1,2, 3, 12
        //1,2, 4, 5.1, 5.2, 6, 7, 12
        //1,2, 4, 5.1, (5.2, 6, 8, 10, 5.3, 5.2)
        //1,2, 4, 5.1, 5.2, 11, 12
        //1,2, 4, 5.1, (5.2, 6, 8, 9, 10, 5.3, 5.2)
    }

    @Test
    void multipleConditionTest(){
        //if(prices==null || prices.isEmpty()) //2
        //T || X
        //F || T
        //F || F
    }

}