package racingcar.game;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void move() {
        Car car = new Car("test");

        assertRandomNumberInRangeTest(() -> {
                    car.move();
                    car.move();
                    car.move();
                    car.move();
                },
                MOVING_FORWARD,
                MOVING_FORWARD,
                STOP,
                STOP
        );

        try {
            Field positionField = car.getClass().getDeclaredField("position");
            positionField.setAccessible(true);

            int position = (int) positionField.get(car);

            assertThat(position).isEqualTo(2);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void printNameAndPosition() {
        Car car = new Car("test");

        assertRandomNumberInRangeTest(() -> {
                    car.move();
                    car.move();
                },
                MOVING_FORWARD,
                MOVING_FORWARD
        );
        car.printNameAndPosition();

        assertThat(output()).isEqualTo("test : --");
    }

    @Test
    void isWinner() {
        Car winner = new Car("winner");
        Car loser = new Car("loser1");

        List<Car> cars = new ArrayList<>();
        cars.add(winner);
        cars.add(loser);
        cars.add(new Car("loser2"));

        assertRandomNumberInRangeTest(() -> {
                cars.forEach(Car::move);
                cars.forEach(Car::move);
                cars.forEach(Car::move);
                },
                MOVING_FORWARD,
                MOVING_FORWARD,
                STOP,

                MOVING_FORWARD,
                STOP,
                STOP,

                MOVING_FORWARD,
                MOVING_FORWARD,
                MOVING_FORWARD
        );

        assertThat(winner.isWinner(cars)).isTrue();
        assertThat(loser.isWinner(cars)).isFalse();
    }

    @Override
    protected void runMain() {

    }
}