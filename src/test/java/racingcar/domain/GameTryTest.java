package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.exception.ExceptionMessage.GameTryCountException.CANNOT_MOVE_ANYMORE;
import static racingcar.exception.ExceptionMessage.GameTryCountException.TRY_COUNT_MUST_BE_AT_LEAST_ONE;

public class GameTryTest {
    @Nested
    @DisplayName("GameTryCount 생성")
    class Construct {
        @Test
        @DisplayName("게임 시도 횟수가 1번 미만이면 GameTry를 생성할 수 없다")
        void throwExceptionByInvalidTryCount() {
            assertThatThrownBy(() -> GameTry.from(0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(TRY_COUNT_MUST_BE_AT_LEAST_ONE.message);
        }

        @Test
        @DisplayName("GameTry를 생성한다")
        void success() {
            assertDoesNotThrow(() -> GameTry.from(1));
        }
    }

    @Nested
    @DisplayName("게임 진행 시도")
    class Proceed {
        @Test
        @DisplayName("남은 시도 횟수가 없다면 더이상 게임을 진행할 수 없다")
        void throwExceptionByCannotMoveAnymore() {
            // given
            final GameTry gameTry = GameTry.from(1);
            gameTry.proceed();

            // when - then
            assertThatThrownBy(gameTry::proceed)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage(CANNOT_MOVE_ANYMORE.message);
        }

        @Test
        @DisplayName("게임을 진행한다 (남은 시도 횟수 - 1)")
        void success() {
            // given
            final GameTry gameTry = GameTry.from(2);

            // when
            gameTry.proceed();

            // then
            assertThat(gameTry.getRemainingAttempts()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("게임 진행이 가능한지 확인한다")
    void isStillCanTry() {
        // given
        final GameTry gameTry = GameTry.from(1);

        /* remain = 1 */
        assertThat(gameTry.isStillCanTry()).isTrue();

        /* proceed -> remain = 0 */
        gameTry.proceed();
        assertThat(gameTry.isStillCanTry()).isFalse();
    }
}
