package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars.Car;

class GameTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    public void isRunnable_ReturnsTrue_WhenRandomNumberIsGreaterThanOrEqualToFour() {
        String[] carArray = {"car1", "car2", "car3"};
        Game game = new Game(new Cars(carArray));

        assertTrue(game.isRunnable(4));
        assertTrue(game.isRunnable(5));
        assertTrue(game.isRunnable(9));
    }

    @Test
    public void isRunnable_ReturnsFalse_WhenRandomNumberIsLessThanFour() {
        String[] carArray = {"car1", "car2", "car3"};
        Game game = new Game(new Cars(carArray));

        assertFalse(game.isRunnable(0));
        assertFalse(game.isRunnable(1));
        assertFalse(game.isRunnable(3));
    }

    @Test
    public void runCar_ShouldMoveCar_WhenRandomNumberIsGreaterThanOrEqualToFour() {
        Game game = new Game(new Cars(new String[]{"car1"}));
        Car car = new Car("testCar");

        game.processCarMovement(car, 4);

        assertTrue(car.getDrawingMovement().length() > 0);
        assertTrue(car.getNumberOfMoves() > 0);
    }

    @Test
    public void runCar_ShouldNotMoveCar_WhenRandomNumberIsLessThanFour() {
        Game game = new Game(new Cars(new String[]{"car1"}));
        Car car = new Car("testCar");

        game.processCarMovement(car, 3);

        assertEquals("", car.getDrawingMovement());
        assertEquals(0, car.getNumberOfMoves());
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testPrintOneRoundResult() {
        Game game = new Game(new Cars(new String[]{"car1", "car2"}));
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));

        cars.get(0).setDrawingMovement("--");
        cars.get(1).setDrawingMovement("-");

        game.printOneRoundResult(cars);

        String expectedOutput = "car1 : --" + System.lineSeparator() + "car2 : -" + System.lineSeparator();
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

}