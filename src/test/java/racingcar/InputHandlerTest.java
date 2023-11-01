package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest {

    @Test
    void createRacerFromInput() {
        InputHandler inputHandler = new InputHandler();
        String input = "pobi,woni,jun";
        Racer[] result = inputHandler.createRacerFromInput(input);

        assertThat(result).hasSize(3);
        assertThat(result).extracting(Racer::getName).containsExactly("pobi", "woni", "jun");
    }

}