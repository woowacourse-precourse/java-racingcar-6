package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("자동차에게 이름을 부여한다.")
    @Test
    void 자동차_이름_부여() {
        assertThatCode(() -> new Car("자동차1")).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름이 1자 이상, 5자 이하 시 성공")
    @ParameterizedTest
    @ValueSource(strings = {"일", "일이", "일이삼", "일이삼사"})
    void 자동차_이름_길이_성공(String name) {
        assertThatCode(() -> new Car(name)).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름이 1자 미만, 5자 초과 시 실패")
    @ParameterizedTest
    @ValueSource(strings = {"여섯글자이름", ""})
    void 자동차_이름_길이_실패(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하여야 합니다.");
    }

    @DisplayName("자동차가 전진한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_전진(int value) {
        Car car = new Car("전진");

        int position = car.getPosition();
        car.move(value);

        assertThat(car.getPosition()).isEqualTo(position + 1);
    }

    @DisplayName("자동차가 멈춘다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차_멈춤(int value) {
        Car car = new Car("멈춤");

        int position = car.getPosition();
        car.move(value);

        assertThat(car.getPosition()).isEqualTo(position);
    }

}
