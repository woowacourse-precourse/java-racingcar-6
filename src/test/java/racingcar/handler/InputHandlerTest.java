package racingcar.handler;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.view.input.InputView;

class InputHandlerTest {
    private final String inputCarNames = "pobi,woni,jun";
    private final String inputRaceTime = "3";
    private final InputHandler inputHandler = new InputHandler(new InputConvertor(), new InputValidator(),
        new InputView() {
            @Override
            public String readCarNames() {
                return inputCarNames;
            }

            @Override
            public String readRaceTime() {
                return inputRaceTime;
            }
        });
    @Test
    void handleCarNamesInput() {
        final List<String> excepted = List.of("pobi", "woni", "jun");

        List<String> result = inputHandler.handleCarNamesInput();

        Assertions.assertThat(result).isEqualTo(excepted);
    }

    @Test
    void handleRaceTimeInput() {
        final int excepted = Integer.parseInt(inputRaceTime);

        int result = inputHandler.handleRaceTimeInput();

        Assertions.assertThat(result).isEqualTo(excepted);
    }
}