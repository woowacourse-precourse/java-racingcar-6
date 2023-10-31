package racingcar.domain.car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.move.RandomMovement;

class CarTest extends NsTest {

    @Test
    void 자동차는_랜덤값이_4이상일때_전진한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("car", new RandomMovement());
                    car.move();
                    assertThat(car.toProgress()).contains("car : -");
                },
                4
        );
    }

    @Test
    void 자동차는_랜덤값이_3이하일때_멈춘다() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("car", new RandomMovement());
                    car.move();
                    assertThat(car.toProgress()).contains("car : ");
                },
                3
        );
    }

    @Override
    protected void runMain() {

    }
}