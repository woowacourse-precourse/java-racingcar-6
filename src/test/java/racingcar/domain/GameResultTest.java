package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars.Car;

public class GameResultTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testDoGetResult() {
        Car car1 = new Car("car1");
        car1.setNumberOfMoves(3);
        Car car2 = new Car("car2");
        car2.setNumberOfMoves(3);
        Car car3 = new Car("car3");
        car3.setNumberOfMoves(2);

        Cars cars = new Cars(new String[]{"car1", "car2", "car3"});
        cars.getCarList().set(0, car1);
        cars.getCarList().set(1, car2);
        cars.getCarList().set(2, car3);

        GameResult gameResult = new GameResult(cars);
        gameResult.doGetResult();

        assertEquals("최종 우승자 : car1, car2", outputStreamCaptor.toString());
    }
}
