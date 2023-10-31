package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.trycnt.TryCntIsNumberException;
import racingcar.exception.trycnt.TryCntIsPositiveException;

class TryCntValidatorTest {
    @Test
    @DisplayName("[에러] 시도 횟수가 숫자가 아니라면 IllegalArgumentException 발생")
    public void checkTryCntIsNumber() {
        String tryCnt = "일";
        assertThatExceptionOfType(TryCntIsNumberException.class)
                .isThrownBy(() -> TryCntValidator.checkTryCount(tryCnt))
                .withMessageMatching("시도 횟수는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("[에러] 시도 횟수가 음수라면 IllegalArgumentException 발생")
    public void checkTryCntIsPositive() {
        String tryCnt = "-1";
        assertThatExceptionOfType(TryCntIsPositiveException.class)
                .isThrownBy(() -> TryCntValidator.checkTryCount(tryCnt))
                .withMessageMatching("시도 횟수는 양수여야 합니다.");
    }
}