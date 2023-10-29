package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.exception.ErrorMessages;

public class CarTest {

    @Test
    @DisplayName("값이 4이상이면 1번 전진한다")
    void 값이_4이상이면_1번전진한다() {
        Car car = new Car("pobi", 0);

        car.moveAccordingToInput(4);

        assertThat(car.getMovingCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("값이 3이하이면 정지한다")
    void 값이_3이하이면_정지한다() {
        Car car = new Car("pobi", 0);

        car.moveAccordingToInput(3);

        assertThat(car.getMovingCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차이름이 5자를 초과하면 에러가 발생한다.")
    void 자동차이름_5자를_초과하면_에러발생() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NAME_LENGTH_ERROR);
    }

    @Test
    @DisplayName("자동차이름을 입력하지 않으면 에러가 발생한다")
    void 자동차이름을_입력하지_않으면_에러가_발생한다() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NAME_BLANK_ERROR);
    }
}
