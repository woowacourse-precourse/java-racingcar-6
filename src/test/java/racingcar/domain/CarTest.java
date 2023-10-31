package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 전진() {
        Car car = Car.of("test");
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getPosition()).isEqualTo(1);
                },
                4
        );
    }

    @Test
    void 정지() {
        Car car = Car.of("test");
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getPosition()).isEqualTo(0);
                },
                2
        );
    }

    @Test
    void 주어진_값으로_자동차_생성시_이름이_6자_글자_이상이면_예외발생() {
        String input = "pobibibi";

        assertThatThrownBy(() -> Car.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }
}