package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptCountValidatorTest {
    @DisplayName("입력 문자열이 정수로 이루어져 있는지 확인하는 기능.")
    @Test
    void inputAttemptCount_예외처리() {
        AttemptCountValidator validator = AttemptCountValidator.INSTANCE;
        String input = "1234a5";

        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
