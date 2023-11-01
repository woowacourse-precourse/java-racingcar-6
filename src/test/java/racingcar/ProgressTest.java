package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ProgressTest extends NsTest {

    @BeforeEach
    public void setUp() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1", 0));
        cars.add(new Car("Car2", 0));
    }

    @Test
    public void testStartComment() {
        // Simulate user input for car names
        String input = "Car1, Car2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = Progress.startComment();
        assertEquals("Car1, Car2", result);
    }


    @Test
    public void testIsNumeric() {
        assertEquals(true, Progress.isNumeric("12345"));
        assertFalse(Progress.isNumeric("abcde"));
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
