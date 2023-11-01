package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.GameConstant;
import racingcar.constant.message.CarNamesInputErrorMessage;

public class CarTest {
    @DisplayName("생성 시 전달된 이름 길이가 " + GameConstant.CAR_NAME_MAX_LENGTH + " 초과인 경우 IllegalArgumentException 발생 여부 테스트")
    @Test
    void 전달된_차량_이름이_다섯글자_초과시_예외_발생() {
        // given
        final String[] carNames = {"woowa-course", "alibaba", "samsung", "junjun"};

        // when, then
        for (String carName : carNames) {
            assertThatThrownBy(() -> new Car(carName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CarNamesInputErrorMessage.INPUT_LENGTH_EXCEEDS_LIMIT);
        }
    }

    @DisplayName("생성 시 전달된 이름이 비어있는 값일 경우 IllegalArgumentException 발생 여부 테스트")
    @Test
    void 전달된_차량_이름이_비어있을때_예외_발생() {
        // given
        final String carName = "";

        // when, then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarNamesInputErrorMessage.INPUT_IS_EMPTY);
    }

    @DisplayName("차량이 전진 혹은 멈출 수 있는지 여부 테스트")
    @Test
    void 차량이_전진_혹은_멈출수_있는지_테스트() {
        // given
        Car car = new Car("woowa");

        // when, then
        for (int i = 0; i < 10000000; i++) {
            assertThatNoException().isThrownBy(car::moveOrStop);
        }
        assertThat(car.getDistance()).isGreaterThan(0);
    }
}