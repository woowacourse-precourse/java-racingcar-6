package racingcar;

import car.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void getRandomNumberBetweenZeroAndNine_랜덤_번호_0_9_사이의_값을_반환() {
        List<Integer> arr = new ArrayList<>();
        Car car = new Car("test");

        for (int i = 0; i < 10000; i++){
            arr.add(car.getRandomNumberBetweenZeroAndNine());
        }

        assertThat(arr).allMatch(value -> value >= 0 && value <= 9);

    }
    @Test
    void movingForward_자동차_앞으로_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("test");
                    car.movingForward();
                    assertThat(car.getDistance()).isEqualTo(1);
                },
                4
        );
    }
}
