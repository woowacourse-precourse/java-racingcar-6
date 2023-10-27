package racingcar.io.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.exception.ExceptionMessage.InputException.GAME_TRY_COUNT_MUST_BE_NUMERIC;
import static racingcar.exception.ExceptionMessage.InputException.INPUT_MUST_NOT_CONTAINS_SPACE;

public class GameTryInputValidatorTest {
    private final GameTryCountInputValidator sut = new GameTryCountInputValidator();

    @Test
    @DisplayName("게임 시도 횟수에 공백이 존재하면 예외가 발생한다")
    void throwExceptionByInputHasSpace() {
        assertThatThrownBy(() -> sut.validate("1 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MUST_NOT_CONTAINS_SPACE.message);
    }

    @Test
    @DisplayName("게임 시도 횟수가 숫자로 표현될 수 없으면 예외가 발생한다")
    void throwExceptionByInputCannotBeInteger() {
        assertThatThrownBy(() -> sut.validate("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GAME_TRY_COUNT_MUST_BE_NUMERIC.message);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "100", "1000"})
    @DisplayName("게임 시도 횟수 검증에 성공한다")
    void success(final String userInput) {
        assertDoesNotThrow(() -> sut.validate(userInput));
    }
}
