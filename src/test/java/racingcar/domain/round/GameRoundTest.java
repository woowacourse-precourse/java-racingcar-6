package racingcar.domain.round;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.errorMessage.ErrorMessages;
import racingcar.constant.errorMessage.InvalidArgumentException;

class GameRoundTest {

    private static final int DECREASING_COUNT_NUMBER = 1;
    private static final int GAME_FINISH_NUMBER = 0;

    @ParameterizedTest
    @ValueSource(ints = {0, -2, -3, -2000000})
    @DisplayName("게임 실행 횟수 입력값 정수 아닌 경우 예외 처리 테스트")
    void gameRoundCountIsNegativeTest(final int count) {
        final String message = ErrorMessages.ROUND_IS_NOT_POSITIVE.getMessage();
        assertThatThrownBy(() -> new GameRound(count))
                .isInstanceOf(InvalidArgumentException.class)
                .hasMessageContaining(message);
    }

    @ParameterizedTest
    @ValueSource(ints = {20000000, 300, 10, 1, 2, 3})
    @DisplayName("게임 실행 횟수 객체 생성 테스트")
    void gameRoundObjectCreationTest(final int count) {
        assertDoesNotThrow(() -> new GameRound(count));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 2, 3, 4, 100})
    @DisplayName("게임 실행 횟수 1씩 감소하는지 테스트")
    void decreaseCountTest(final int count) {
        final GameRound gameRound = new GameRound(count);
        gameRound.isCountDecrease();

        final int actual = gameRound.getCount();
        final int expected = count - DECREASING_COUNT_NUMBER;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 2, 3, 4, 100})
    @DisplayName("게임 실행 횟수 0까지 감소하는지 테스트")
    void isNotFinishedTest(final int count) {
        final GameRound gameRound = new GameRound(count);
        checkCountIsDecrease(gameRound, count);

        final int actual = gameRound.getCount();
        assertThat(actual).isEqualTo(GAME_FINISH_NUMBER);
    }

    private void checkCountIsDecrease(final GameRound gameRound, final int count) {
        for (int i = 0; i < count; i++) {
            gameRound.isCountDecrease();
        }
    }
}
