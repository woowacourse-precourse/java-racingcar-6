package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_전진() throws Exception {
        // given
        final Car car = new Car("test", () -> 4);

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_멈춤() throws Exception {
        // given
        final Car car = new Car("test", () -> 3);

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 자동차_이름_NULL_예외() throws Exception {
        assertThatThrownBy(() -> new Car(null, () -> 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 문자열은 null일 수 없습니다.");
    }

    @Test
    void 자동차_이름_공백_예외() throws Exception {
        assertThatThrownBy(() -> new Car("   ", () -> 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 문자열 길이는 공백일 수 없습니다.");
    }

    @Test
    void 자동차_이름_최대_길이_예외() throws Exception {
        assertThatThrownBy(() -> new Car("handwoong", () -> 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 문자열의 길이는 5이하만 가능합니다.");
    }
}
