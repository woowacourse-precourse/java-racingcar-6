package racingcar.domain.round;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.errorMessage.ErrorMessages;
import racingcar.constant.errorMessage.InvalidArgumentException;

class GameRoundTest {

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
}
