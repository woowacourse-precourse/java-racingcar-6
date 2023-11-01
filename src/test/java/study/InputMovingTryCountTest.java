package study;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.Validator;

public class InputMovingTryCountTest {
    Validator validator;

    @BeforeEach
    void init() {
        validator = new Validator();
    }

    @Test
    @DisplayName("입력받은 시도할 횟수가 정수가 아닌 경우에 예외 발생")
    void 정수가_아니면_예외_발생() {
        String input = "cars";
        assertThatThrownBy(() -> validator.validateInputMovingTryCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력받은 시도할 횟수가 1에서 10 사이가 아닌 경우에 예외 발생")
    @ValueSource(strings = {"0", "11"})
    void 범위를_벗어나면_예외_발생(String input) {
        assertThatThrownBy(() -> validator.validateInputMovingTryCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
