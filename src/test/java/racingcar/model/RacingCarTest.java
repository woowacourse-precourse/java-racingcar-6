package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.CAR_NAME_OVER_MAX_LENGTH;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void 자동차의_이름은_공백포함_5자이하여야_한다() {
        assertThatThrownBy(() -> new RacingCar("5자이상 자동차 이름"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_OVER_MAX_LENGTH);
    }

}