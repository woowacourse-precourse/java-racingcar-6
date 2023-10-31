package racingcar.unitTest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.validation.AttemptValidator;

public class AttemptValidatorTest {

    private AttemptValidator attemptValidator;

    @BeforeEach
    void setUp() {
        attemptValidator = new AttemptValidator();
    }

    @Test
    void should_throwException_when_isBlank() {
        // given
        String attempt = "";
        // when & then
        assertThatThrownBy(() -> attemptValidator.validate(attempt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 값은 입력할 수 없습니다.");
    }

    @Test
    void should_throwException_when_isNotNumeric() {
        // given
        String attempt = "12a";
        // when & then
        assertThatThrownBy(() -> attemptValidator.validate(attempt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 이외에 입력할 수 없습니다.");
    }
}
