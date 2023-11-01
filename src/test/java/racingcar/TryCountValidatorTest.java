package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.vaildator.TryCountValidator;

public class TryCountValidatorTest {

    @Test
    @DisplayName("시도 횟수가 0일 때를 검증한다.")
    void validateInputTryCount() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> TryCountValidator.validateInputTryCountZero("0"));
    }

    @Test
    @DisplayName("아무것도 입력하지 않았을 때를 검증한다.")
    void validateInputTryCountNothing() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> TryCountValidator.validateInputTryCountNothing(""));
    }

    @DisplayName("자연수만 입력하였는지를 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-10", "1.5", "-0.52"})
    void validateInputTryCountNumeric(String tryCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> TryCountValidator.validateInputTryCountNumeric(tryCount));
    }
}
