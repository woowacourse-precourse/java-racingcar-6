package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

class CarTest {
    @Test
    void 자동차는_무작위_값이_4_미만일_경우_전진하지_않는다() {
        Car car = new Car("pobi");
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        assertRandomNumberInRangeTest(
                () -> {
                    car.forward(numberGenerator);
                    assertThat(car.getPoint()).isEqualTo(0);
                },
                2
        );
    }

    @Test
    void 자동차는_무작위_값이_4_이상일_경우_전진한다() {
        Car car = new Car("pobi");
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        assertRandomNumberInRangeTest(
                () -> {
                    car.forward(numberGenerator);
                    assertThat(car.getPoint()).isEqualTo(1);
                },
                5
        );
    }
}