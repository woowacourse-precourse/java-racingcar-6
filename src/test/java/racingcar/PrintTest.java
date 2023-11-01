package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Arrays;

class PrintTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testStatus() {
        Print print = new Print();
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("woni"));
        Car firstCar = cars.get(0);
        firstCar.moveForward();
        print.status(cars);
        String expectedOutput = "pobi : -\nwoni : \n\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    void testResult() {
        Print print = new Print();
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("woni"));
        Car firstCar = cars.get(0);
        firstCar.moveForward();
        print.result(cars);
        String expectedOutput = "최종 우승자 : pobi";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
