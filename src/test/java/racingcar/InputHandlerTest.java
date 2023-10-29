package racingcar.controller;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest {

    @Test
    void parseCarName_shouldReturnListOfCarNames() {
        String input = "car1,car2,car3";
        List<String> carNames = InputHandler.parseCarName(input);
        assertThat(carNames).containsExactly("car1", "car2", "car3");
    }

    @Test
    void triesCount_shouldReturnNumberOfTries() {
        String input = "5";
        int tries = InputHandler.triesCount(input);
        assertThat(tries).isEqualTo(5);
    }

    @Test
    void triesCount_shouldThrowNumberFormatExceptionForInvalidInput() {
        String input = "invalid";
        assertThatThrownBy(() -> InputHandler.triesCount(input))
            .isInstanceOf(NumberFormatException.class);
    }
}
