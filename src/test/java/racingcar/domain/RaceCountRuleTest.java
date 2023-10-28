package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.InputTryCountValidator;

class RaceTryRuleTest {

    @DisplayName("시도 횟수가 1미만, 10초과라면 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "11"})
    void validateCount_exception_withInvalidRange(String invalidInputCount) {
        // given & when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputTryCountValidator.validateCount(invalidInputCount))
                .withMessageContaining("시도 횟수는 1 이상 10 이하의 숫자를 입력해야 합니다.");
    }

    @DisplayName("시도 횟수가 숫자가 아닌 입력이라면 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"0_", "f3"})
    void validateCount_exception_withNumberFormat(String invalidInputCount) {
        // given & when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputTryCountValidator.validateCount(invalidInputCount))
                .withMessageContaining("시도 횟수는 숫자만 입력해야 합니다.");
    }
}