package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private RacingCar racingCar;
    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void RacingCar_각_자동차의_현재_위치를_출력함() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.canForward(Car.MIN_NUMBER_TO_MOVE);
        car2.canForward(Car.MIN_NUMBER_TO_MOVE);
        racingCar = new RacingCar(List.of(car1, car2, car3));

        racingCar.printLocationAllCar();
        String expectedOutput = "car1 : -\ncar2 : -\ncar3 :";

        assertEquals(expectedOutput, outputContent.toString().trim());
    }

    @Test
    void RacingCar_최대_움직인_거리를_찾음() {
        Car car1 = new Car("MAX_DISTANCE_CAR1");
        Car car2 = new Car("NORMAL_CAR1");
        Car car3 = new Car("NORMAL_CAR2");
        car1.canForward(Car.MIN_NUMBER_TO_MOVE);
        racingCar = new RacingCar(List.of(car1, car2, car3));
        int expectedDistance = 1;

        assertEquals(expectedDistance, racingCar.findMaxDistance());
    }

    @Test
    void RacingCar_단일_우승자_찾기() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.canForward(Car.MIN_NUMBER_TO_MOVE);
        racingCar = new RacingCar(List.of(car1, car2, car3));

        List<Car> winner = racingCar.findWinner();

        assertEquals(Arrays.asList(car1), winner);
    }

    @Test
    void RacingCar_복수의_우승자_찾기() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.canForward(Car.MIN_NUMBER_TO_MOVE);
        car2.canForward(Car.MIN_NUMBER_TO_MOVE);
        racingCar = new RacingCar(List.of(car1, car2, car3));

        List<Car> winners = racingCar.findWinner();

        assertEquals(Arrays.asList(car1, car2), winners);
    }
}
