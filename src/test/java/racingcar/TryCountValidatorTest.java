package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.vaildator.TryCountValidator;

public class TryCountValidatorTest {

    @Test
    @DisplayName("시도 횟수가 0일 때를 검증한다.")
    void validateInputTryCount() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> TryCountValidator.validateInputTryCount("0"));
    }

    @Test
    @DisplayName("아무것도 입력하지 않았을 때를 검증한다.")
    void validateInputTryCountNothing() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> TryCountValidator.validateInputTryCountNothing(""));
    }
}
