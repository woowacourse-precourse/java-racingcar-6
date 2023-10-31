package racingcar;

import racingcar.race.Race;
import racingcar.race.Car;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RaceTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private List<Car> cars;
    private Race race;

    @BeforeEach
    void setup() {
        cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        race = new Race(cars, 1);
    }

    @Test
    void raceShouldRunSpecifiedRounds() {
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    race.run();
                    assertThatCarsMovedCorrectly();
                },
                MOVING_FORWARD, STOP
        );
    }

    private void assertThatCarsMovedCorrectly() {
        if (cars.get(0).getPosition() > 0) {
            org.assertj.core.api.Assertions.assertThat(cars.get(0).getName() + " : " + "-".repeat(cars.get(0).getPosition()))
                    .isEqualTo("car1 : -");
            org.assertj.core.api.Assertions.assertThat(cars.get(1).getName() + " : " + "-".repeat(cars.get(1).getPosition()))
                    .isEqualTo("car2 : ");
        } else {
            org.assertj.core.api.Assertions.assertThat(cars.get(0).getName() + " : " + "-".repeat(cars.get(0).getPosition()))
                    .isEqualTo("car1 : ");
            org.assertj.core.api.Assertions.assertThat(cars.get(1).getName() + " : " + "-".repeat(cars.get(1).getPosition()))
                    .isEqualTo("car2 : ");
        }
    }
}





