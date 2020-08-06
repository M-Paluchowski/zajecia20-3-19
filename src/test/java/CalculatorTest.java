import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void setUpAll() {
        System.out.println("Before all tests");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After all tests");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before each test");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test");
    }

    @Test
    void shouldReturnFiveWhenDividingTenByTwo() {
        //given
        int preparedFirstNumber = 10;
        int preparedSecondNumber = 2;

        //when
        int result = calculator.divide(preparedFirstNumber, preparedSecondNumber);

        //then
        int expectedNumber = 5;
        assertEquals(expectedNumber, result);
        assertThat(result, is(equalTo(expectedNumber)));
        assertThat(result, is(not(equalTo(6))));
        assertThat(result)
                .isBetween(4, 6)
                .isEqualTo(expectedNumber);
    }

    @Test
    void shouldThrowArithmeticExceptionWhenDividingByZero() {
        //given
        int preparedFirstNumber = 10;
        int preparedSecondNumber = 0;

        //when
        Executable methodCall = () -> calculator.divide(preparedFirstNumber, preparedSecondNumber);

        //then
        assertThrows(ArithmeticException.class, methodCall);
    }

    @Test
    void collectionWithAssertJ() {
        List<Integer> integers = List.of(1, 2, 3, 4);
        assertThat(integers)
                .doesNotContain(6)
                .contains(4, 3)
                .containsExactly(1, 2, 4, 3);
    }
}