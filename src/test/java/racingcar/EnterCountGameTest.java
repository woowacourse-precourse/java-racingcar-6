package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarGameController;

public class EnterCountGameTest {
    @Test
    void 숫자_입력_시() {
        String input = "12";

        Assertions.assertDoesNotThrow(() -> RacingCarGameController.parseCountGame(input));
    }

    @Test
    void 문자_입력_시() {
        String input = "aa";

        assertThatThrownBy(() -> RacingCarGameController.parseCountGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.ERR_CONUT_OF_GAME_IS_NUMBER);
    }

    @Test
    void 숫자_문자_혼합으로_입력_시() {
        String input = "12a";

        assertThatThrownBy(() -> RacingCarGameController.parseCountGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.ERR_CONUT_OF_GAME_IS_NUMBER);
    }
}
