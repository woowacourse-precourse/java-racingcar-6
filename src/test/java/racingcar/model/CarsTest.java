package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.model.exception.ExceptionMessage.DUPLICATE_CAR_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("자동차 이름이 모두 독립적이면 정상 생성된다.")
    void createCarsTest() {
        // when & then
        assertDoesNotThrow(() -> Cars.from("john,bob,alice"));
    }

    @Test
    @DisplayName("같은 이름을 가진 자동차가 있으면 예외가 발생한다.")
    void duplicateNameCarExceptionTest() {
        // when & then
        assertThatThrownBy(() -> Cars.from("john,john,bob")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CAR_EXCEPTION.getMessage());
    }
}
