package mk.ukim.finki;

import org.junit.jupiter.api.*;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {

    private final Calculator calc = new Calculator();

    //najbitni tests koristeni -> lifecycle na testovite
    //ako padne eden ne se izvrsuvaat site

    //se izrvusva EDNAS pred site tests
    @BeforeAll
    static void init(){
        System.out.println("@This method invokes BEFORE ALL test!");
    }

    //se izvrsuva pred sekoj test
    @BeforeEach
    void beforeEachTest(){
        System.out.println("@This method invokes BEFORE each test!");
    }

    //se izvrsuva posle sekoj
    @AfterEach
    void afterEachTest(){
        System.out.println("@This method invokes AFTER each test!");
    }

    //obicni tests
    @Test
    void divideNormalNums() {
        System.out.println("Test divide normal nums");
        assertEquals(3, calc.divide(9, 3));
        assertEquals(2, calc.divide(4, 2));
        assertEquals(0, calc.divide(0,2));
    }

    @Test
    void divideDecimalNums(){
        System.out.println("Test divide decimal nums");
        assertEquals(2.25, calc.divide(9,4));
        assertEquals(0, calc.divide(0,4.5));
    }

    @Test
    void assertionTypes(){
        System.out.println("Assertion types tests");
        assertEquals(0, calc.divide(0,2), "Optional failure message");
        assertTrue(3 > calc.divide(4,2), "Optional failure message");
        assertNotEquals(3 , calc.divide(10, 3));
//        assertTimeout(); //da zavrsi za nekoe vreme
//        assertSame();
    }

    //grupni tests za da se izvrsat site iako padne eden
    //gi tretira kako posebni
    @Test
    void groupAssertion(){
        assertAll("AssertionHeading",
                () -> assertEquals(3, calc.divide(6,2)),
                () -> assertEquals(3, calc.divide(4,2)),
                () -> assertEquals(3, calc.divide(2,2)));
    }

    //-------------------------timeouts-------------------------
    @Test
    void timeout(){
        //pagja ako ne se zavrsi za ocekuvaniot timeout
        assertTimeout(Duration.ofMillis(10), () -> calc.calculateTotalInInterval(0,5));
    }

    //---------------------------exceptions-----------------
    @Test
    void exceptionTest(){
       // assertEquals(0, calc.divide(5,0));
        //mine so exception da se deli so nula
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> calc.divide(5,0));
        assertTrue(ex.getMessage().contains("Can not divide by zero"));

        ex = assertThrows(RuntimeException.class, () -> calc.divide(0,0));
        assertTrue(ex.getMessage().contains("Can not divide by zero"));
    }

    //------------------------Parameterized test------------------
//    void divideParamTest(double a, double b, double result){
//
//    }


    //se izvrsuva EDNAS posle site test
    //ako e padnat nekoj test obicen ovoj after all se izvrsuva na kraj skroz posle site prints
    @AfterAll
    static void destroy(){
        System.out.println("@This method invokes AFTER ALL test!");
    }
}