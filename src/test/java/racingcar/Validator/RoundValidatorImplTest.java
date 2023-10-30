package racingcar.Validator;

import static racingcar.Message.RoundExceptionPrompt.RANGEPROMPT;
import static racingcar.Message.RoundExceptionPrompt.REALNUMBERPROMPT;
import static racingcar.Message.RoundExceptionPrompt.STRINGPROMPT;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundValidatorImplTest {

    private final RoundValidatorImpl RoundValidatorImpl = new RoundValidatorImpl();
    @Test
    @DisplayName("시도 횟수가 문자열이 아닌지 검증")
    void isNotString() {
        String testRound = "test";

        Assertions.assertThatThrownBy(() -> RoundValidatorImpl.isNotString(testRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(STRINGPROMPT.getMessage(testRound));
    }

    @Test
    @DisplayName("시도 횟수가 실수가 아닌지 검증")
    void isNotRealNumber() {
        String testRound = "1.1";

        Assertions.assertThatThrownBy(() -> RoundValidatorImpl.isNotRealNumber(testRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(REALNUMBERPROMPT.getMessage(testRound));
    }

    @Test
    @DisplayName("시도 횟수가 범위안에 존재하는 검증")
    void isValidRange() {
        String testRound = "0";

        Assertions.assertThatThrownBy(() -> RoundValidatorImpl.isValidRange(testRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RANGEPROMPT.getMessage(testRound));
    }
}