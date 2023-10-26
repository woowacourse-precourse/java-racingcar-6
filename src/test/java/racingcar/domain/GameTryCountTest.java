package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.exception.ExceptionMessage.GameTryCountException.TRY_COUNT_MUST_BE_AT_LEAST_ONE;

public class GameTryCountTest {
    @Test
    @DisplayName("게임 시도 횟수가 1번 미만이면 GameTryCount를 생성할 수 없다")
    void throwExceptionByInvalidTryCount() {
        assertThatThrownBy(() -> GameTryCount.from(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TRY_COUNT_MUST_BE_AT_LEAST_ONE.message);
    }

    @Test
    @DisplayName("GameTryCount를 생성한다")
    void success() {
        assertDoesNotThrow(() -> GameTryCount.from(1));
    }
}
