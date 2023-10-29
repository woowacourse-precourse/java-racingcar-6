package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountValidatorTest {

    @DisplayName("모든 경우의 수를 따져서 올바른 tryCount일 경우에는 예외가 발생하지 않는다.")
    @Test
    void validateAllCasesDoesNotThrowAnyException() {
        // given
        String validTryCount = "2";

        // when
        // then
        assertThatCode(() -> new TryCountValidator(validTryCount))
                .doesNotThrowAnyException();
    }

    @DisplayName("validateTryCountExists()로 시도할 횟수를 입력하지 않으면 ''으로 저장되기 때문에 예외가 발생한다.")
    @Test
    void validateTryCountExistsWithBlank() {
        // given
        String invalidTryCount = "";

        // when
        // then
        assertThatThrownBy(() -> new TryCountValidator(invalidTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수를 입력해주세요.");
    }

    @DisplayName("validateTryCountIsInteger()로 시도할 횟수가 정수가 아니라면 예외가 발생한다.")
    @Test
    void validateTryCountIsIntegerWithInvalidTryCount() {
        // given
        String invalidTryCount = "akb1";

        // when
        // then
        assertThatThrownBy(() -> new TryCountValidator(invalidTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 정수여야 합니다.");
    }

}
