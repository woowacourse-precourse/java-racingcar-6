package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;

class GameCountValidatorTest {

    GameCountValidator gameCountValidator = new GameCountValidator();

    @Test
    void 입력값이_빈칸이라면_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> gameCountValidator.validateGameCount(""));
    }

    @Test
    void 자동차_이름이_중복일경우_예외발생() {
        assertThatThrownBy(() -> gameCountValidator.validateGameCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.GAME_COUNT_TYPE.getMessage());
    }
}