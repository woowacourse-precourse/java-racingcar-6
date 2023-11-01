package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.model.Car;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameControllerTest {
    GameController gameController;
    ByteArrayOutputStream outputStream;
    InputStream inputStream;

    @BeforeEach
    public void setUp() {
        gameController = new GameController();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        inputStream = System.in;
    }

    @Test
    public void testSetCars() {
        String input = "Car1,Car2,Car3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Car> cars = gameController.setCars();

        assertEquals(3, cars.size());
        assertEquals("Car1", cars.get(0).getName());
        assertEquals("Car2", cars.get(1).getName());
        assertEquals("Car3", cars.get(2).getName());
    }

}
