package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private static void setCarPosition(Car car, int position) throws NoSuchFieldException, IllegalAccessException {
        Field positionField = Car.class.getDeclaredField("position");
        positionField.setAccessible(true);
        positionField.set(car, position);
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void carShouldMoveWhenRandomNumberIsGreaterThanOrEqualToFour() throws Exception {
        Car car = new Car("pobi");
        setCarPosition(car, 0);
        car.move();
    }

    @Test
    public void shouldPrintCorrectWinners() throws Exception {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        setCarPosition(car1, 3);
        setCarPosition(car2, 4);
        setCarPosition(car3, 4);

        Race race = new Race(Arrays.asList("Car1", "Car2", "Car3"), 1);
        race.printWinners();

        String output = outContent.toString();
        assertTrue(output.contains("Car2"));
        assertTrue(output.contains("Car3"));
    }
}

