package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.GameView;

class RacingCarControllerTest {
    GameView view = new GameView();
    RacingCarController controller = new RacingCarController(view);

    @Test
    @DisplayName("이름 입력이 비었을 때, 예외를 던진다.")
    void validateCarNamesInput_InputIsEmpty_ThrowsException() {
        // Given
        String input = "";

        // When & Then
        assertThatThrownBy(() -> controller.validateCarNamesInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("첫번째 입력이 비어있습니다.");
    }

    @Test
    @DisplayName("이름 입력이 null일 때, 예외를 던진다.")
    void validateCarNamesInput_InputIsNull_ThrowsException() {
        // Given
        String input = null;

        // When & Then
        assertThatThrownBy(() -> controller.validateCarNamesInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("첫번째 입력이 비어있습니다.");
    }

    @Test
    @DisplayName("이름 입력에 제어문자가 포함되어 있을 때, 예외를 던진다.")
    void validateCarNamesInput_InputContainsControlCharacters_ThrowsException() {
        // Given
        String input = "name\u0001";

        // When & Then
        assertThatThrownBy(() -> controller.validateCarNamesInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("첫번째 입력은 제어문자와 공백문자를 허용하지 않습니다.");
    }

    @Test
    @DisplayName("이름 입력에 공백이 포함되어 있을 때, 예외를 던진다.")
    void validateCarNamesInput_InputContainsSpaces_ThrowsException() {
        // Given
        String input = "name name";

        // When & Then
        assertThatThrownBy(() -> controller.validateCarNamesInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("첫번째 입력은 제어문자와 공백문자를 허용하지 않습니다.");
    }

    @Test
    @DisplayName("이름 입력에 쉼표가 연속해서 나올 때, 예외를 던진다.")
    void validateCarNamesInput_InputContainsConsecutiveCommas_ThrowsException() {
        // Given
        String input = "name,,name";

        // When & Then
        assertThatThrownBy(() -> controller.validateCarNamesInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("','는 연속해서 나오거나 시작/끝에 위치할 수 없습니다.");
    }

    @Test
    @DisplayName("이름 입력이 쉼표로 시작할 때, 예외를 던진다.")
    void validateCarNamesInput_InputStartsWithComma_ThrowsException() {
        // Given
        String input = ",name";

        // When & Then
        assertThatThrownBy(() -> controller.validateCarNamesInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("','는 연속해서 나오거나 시작/끝에 위치할 수 없습니다.");
    }

    @Test
    @DisplayName("이름 입력이 쉼표로 끝날 때, 예외를 던진다.")
    void validateCarNamesInput_InputEndsWithComma_ThrowsException() {
        // Given
        String input = "name,";

        // When & Then
        assertThatThrownBy(() -> controller.validateCarNamesInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("','는 연속해서 나오거나 시작/끝에 위치할 수 없습니다.");
    }

    @Test
    @DisplayName("올바른 이름 입력일 때, 예외를 던지지 않는다.")
    void validateCarNamesInput_InputIsValid_DoesNotThrowException() {
        // Given
        String input = "name,name2,name3";

        // When & Then
        assertThatCode(() -> controller.validateCarNamesInput(input))
                .doesNotThrowAnyException();
    }
}
