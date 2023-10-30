package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.Error;

class CarTest {

    @Test
    void 자동차의_이름은_1자_이상_5자_이하만_가능하다() {
        assertThatThrownBy(() -> new Car("ABCDEF"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.CAR_NAME_LENGTH_ERROR.getMessage());

        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.CAR_NAME_LENGTH_ERROR.getMessage());
    }
}