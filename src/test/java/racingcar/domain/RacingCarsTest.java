package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {

    @DisplayName("자동차가 2대 미만일 경우 예외가 발생한다.")
    @Test
    void minSizeCarsEx() {
        assertThatThrownBy(() -> RacingCars.from("one"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
