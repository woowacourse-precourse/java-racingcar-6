package racingcar.domain.service;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.RacingGameConstant;
import racingcar.domain.model.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {
    private static final int MOVING_FORWARD = RacingGameConstant.MOVING_FORWARD;
    private static final int STOP = RacingGameConstant.STOP;

    private RacingGame racingGame;
    private List<Car> cars;

    @BeforeEach
    public void setUp() {
        racingGame = RacingGame.getInstance();
        cars = Arrays.asList(new Car("Tycan"), new Car("Aclass"), new Car("X7"));
    }

    @Test
    public void moveCars_ShouldMoveAllCars() {
        Assertions.assertRandomNumberInRangeTest(() -> racingGame.moveCars(cars), MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
        for (Car car : cars) {
            assertEquals(1, car.getPosition());
        }
    }

    @Test
    public void moveCars_ShouldMoveSomeCars() {
        Assertions.assertRandomNumberInRangeTest(() -> racingGame.moveCars(cars), MOVING_FORWARD, STOP, MOVING_FORWARD);

        assertEquals(1, cars.get(0).getPosition());

        assertEquals(0, cars.get(1).getPosition());

        assertEquals(1, cars.get(2).getPosition());
    }


    @Test
    public void determineWinners_ShouldReturnCarsWithMaxPosition() {
        Assertions.assertRandomNumberInRangeTest(() -> racingGame.moveCars(cars), MOVING_FORWARD, STOP, STOP);
        Assertions.assertRandomNumberInRangeTest(() -> racingGame.moveCars(cars), MOVING_FORWARD, STOP, STOP);

        List<Car> winners = racingGame.determineWinners(cars);
        assertEquals(1, winners.size());
        assertEquals(2, winners.get(0).getPosition());
    }
}