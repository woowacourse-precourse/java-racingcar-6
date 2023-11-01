package racingcar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.CarNameValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class ValidatorTest {
    @Test
    @DisplayName("자동차 이름의 길이가 5보다 클 때 예외처리 발생")
    void shouldThrowExceptionWhenCarNameIsLongerThanFive() {
        assertThatThrownBy(() -> CarNameValidator.validateCarName("aaaaaaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
