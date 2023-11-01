package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void 자동차_전진_테스트() {
        // given
        List<Car> cars = new ArrayList<>();
        Car car = new Car("test");
        cars.add(car);
        int testNumber1 = 4;
        int testNumber2 = 6;

        RacingGame racingGame = new RacingGame(cars, 2);

        // when
        racingGame.moveCarByThreshold(testNumber1, car);
        racingGame.moveCarByThreshold(testNumber2, car);

        // then
        assertEquals(2, car.getMovement());
    }

    @Test
    void 자동차_멈춤_테스트() {
        // given
        List<Car> cars = new ArrayList<>();
        Car car = new Car("test");
        cars.add(car);
        int testNumber1 = 2;
        int testNumber2 = 3;

        RacingGame racingGame = new RacingGame(cars, 2);

        // when
        racingGame.moveCarByThreshold(testNumber1, car);
        racingGame.moveCarByThreshold(testNumber2, car);

        // then
        assertEquals(0, car.getMovement());
    }

    @Test
    void 경주_우승자_테스트() {
        // given
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));

        RacingGame racingGame = new RacingGame(cars, 1);

        racingGame.moveCarByThreshold(4, cars.get(0));
        racingGame.moveCarByThreshold(2, cars.get(1));
        racingGame.moveCarByThreshold(8, cars.get(2));

        // when
        List<String> winnerNames = racingGame.findWinnerNames(1);

        // then
        assertThat(winnerNames).contains("a", "c");
    }

    @Test
    void 경주_우승자_전진횟수_테스트() {
        // given
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));

        RacingGame racingGame = new RacingGame(cars, 2);

        racingGame.moveCarByThreshold(4, cars.get(0));
        racingGame.moveCarByThreshold(2, cars.get(1));
        racingGame.moveCarByThreshold(8, cars.get(2));

        racingGame.moveCarByThreshold(6, cars.get(0));
        racingGame.moveCarByThreshold(8, cars.get(1));
        racingGame.moveCarByThreshold(0, cars.get(2));

        racingGame.moveCarByThreshold(9, cars.get(0));
        racingGame.moveCarByThreshold(5, cars.get(1));
        racingGame.moveCarByThreshold(2, cars.get(2));

        // when
        int maxCarMovement = racingGame.getMaxCarMovement();

        // then
        assertThat(maxCarMovement).isEqualTo(3);
    }
}