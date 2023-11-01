package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

    @DisplayName("자동차 이름이 5자를 넘을 경우 예외가 발생한다.")
    @Test
    void throwsExceptionForInvalidNameSize() {
        // given
        String carName = "123456";

        // when & then
        assertThatThrownBy(() -> CarName.from(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Name of Car length should less than or equal to 5");
    }

}