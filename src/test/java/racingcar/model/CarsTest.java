package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.constant.Error;

class CarsTest {
    @Test
    void 중복된_자동차_이름_확인() {
        String[] stringArray = {"A", "A", "B"};
        assertThatThrownBy(() -> new Cars(stringArray))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.DUPLICATE_CAR_NAME_ERROR.getMessage());
    }

}