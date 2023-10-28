package racingcar.handler;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.view.input.ConsoleInputView;
import racingcar.view.input.InputView;

class InputHandlerTest {
    private final String input = "pobi,woni,jun";
    private final InputHandler inputHandler = new InputHandler(new InputConvertor(), new InputValidator(),
        new InputView() {
            @Override
            public String readCarNames() {
                return input;
            }

            @Override
            public String readRaceTimes() {
                return null;
            }
        });
    @Test
    void handleCarNamesInput() {
        final List<String> excepted = List.of("pobi", "woni", "jun");
        List<String> result = inputHandler.handleCarNamesInput();

        Assertions.assertThat(result).isEqualTo(excepted);
    }
}