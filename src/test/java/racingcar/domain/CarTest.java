package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move_전진() {
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
    void move_정지() {
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
    void of_주어진_값으로_자동차_생성시_이름이_6자_글자_이상이면_예외발생() {
        String input = "pobibibi";

        assertThatThrownBy(() -> Car.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void of_빈문자열으로_자동차_생성시_예외발생() {
        String input = "";

        assertThatThrownBy(() -> Car.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에는 빈 문자열은 불가능합니다.");
    }
}