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

    @Test
    void validateInputForRacerCreation_ValidInput() {
        InputHandler inputHandler = new InputHandler();
        String[] names = {"pobi", "woni", "jun"};

        assertThat(inputHandler.validateInputForRacerCreation(names)).isTrue();
    }
    @Test
    void validateInputForRacerCreation_InvalidInput_OverLength() {
        InputHandler inputHandler = new InputHandler();
        String[] names = {"pobi", "wo", "javaji"};

        assertThatThrownBy(() -> inputHandler.validateInputForRacerCreation(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하만 가능합니다.");
    }
    @Test
    void validateInputForRacerCreation_InvalidInput_InvalidChar() {
        InputHandler inputHandler = new InputHandler();
        String[] names = {"pobi", "w:o", "j6n"};

        assertThatThrownBy(() -> inputHandler.validateInputForRacerCreation(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 한글, 알파벳, 쉼표만 포함해야 합니다.");
    }

    @Test
    void setAttemptCountFromInput_ValidInput() {
        InputHandler inputHandler = new InputHandler();
        String input = "3";

        assertThat(inputHandler.setAttemptCountFromInput(input)).isEqualTo(3);
    }

    @Test
    void setAttemptCountFromInput_InvalidInput() {
        InputHandler inputHandler = new InputHandler();
        String input = "a";

        assertThatThrownBy(() -> inputHandler.setAttemptCountFromInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수형 입력이 필요합니다.");
    }
}