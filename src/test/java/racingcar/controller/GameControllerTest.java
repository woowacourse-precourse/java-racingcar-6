package racingcar.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    private GameController gameController;

    @BeforeEach
    void setUp() {
        gameController = new GameController();
    }

    @Test
    void 시도_횟수_유효성_검사_정상() {
        String playerInput = "3";
        int expectedCount = 3;
        assertThat(gameController.getValidatedCount(playerInput)).isEqualTo(expectedCount);
    }

    @Test
    void 시도_횟수_유효성_검사_숫자가_아닐_경우() {
        String playerInput = "a";
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> gameController.getValidatedCount(playerInput));
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.COUNT_INPUT_EXCEPTION_MESSAGE.get());
    }
}