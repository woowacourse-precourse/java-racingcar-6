package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.model.exception.ExceptionMessage.DUPLICATE_CAR_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("같은 이름을 가진 자동차가 있으면 예외가 발생한다.")
    void duplicateNameCarExceptionTest() {
        // when & then
        assertThatThrownBy(() -> Cars.from("john,john,bob")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CAR_EXCEPTION.getMessage());
    }
}
