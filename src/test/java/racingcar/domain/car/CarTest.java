package racingcar.domain.car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 랜덤값_4_이상이면_차_이동거리_증가() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("car");
                    car.move();
                    assertThat(car.getTravelDistance()).isEqualTo(1);
                },
                4
        );
    }

    @Test
    void 랜덤값_4_미안이면_차_이동거리_증가_안함() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("car");
                    car.move();
                    assertThat(car.getTravelDistance()).isEqualTo(0);
                },
                3
        );
    }

}
