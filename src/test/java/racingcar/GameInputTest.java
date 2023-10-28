package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameInputTest {

    public GameInput gameInput = new GameInput();

    @Test
    void splitInput_메서드로_문자열을_구분자로_나눠_리스트로_반환() {
        String input = "hi,wootecho";
        String delimiter = ",";
        List<String> result = gameInput.splitInput(input, delimiter);
        assertThat(result)
                .contains("hi", "wootecho")
                .hasSize(2);
    }

    @Test
    void splitInput_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "hi";
        String delimiter = ",";
        List<String> result = gameInput.splitInput(input, delimiter);
        assertThat(result)
                .contains("hi")
                .hasSize(1);
    }

    @Test
    void convertToMovingNumber_메서드로_이동수를_입력받은_문자열을_정수형으로_반환() {
        String input = "25";
        int result = gameInput.convertToMovingNumber(input);
        assertThat(result)
                .isInstanceOf(Integer.class)
                .isEqualTo(25);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "@", "12 3", "123a", "123.45"})
    void convertToMovingNumber_메서드_사용시_이동수를_입력받은_문자열이_정수값이_아닐_때_예외발생(String input) {
        assertThatThrownBy(() -> gameInput.convertToMovingNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input number is not valid");
    }


    @Test
    public void convertToCarNameList_메서드로_입력받은_문자열을_구분자로_나눠_리스트로_반환() {
        String input = "pobi,woni,jun";
        List<String> result = gameInput.convertToCarNameList(input);
        assertThat(result)
                .containsExactly("pobi", "woni", "jun")
                .hasSize(3);
    }

    @Test
    public void convertToCarNameList_메서드_사용시_문자열에_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "pobi";
        List<String> result = gameInput.convertToCarNameList(input);
        assertThat(result)
                .containsExactly("pobi")
                .hasSize(1);
    }

    @Test
    public void convertToCarNameList_메서드_사용시_구분자로_나눠진_문자열의_길이가_5보다_큰_경우_예외발생() {
        String input = "pobi12,woni1,jun1";
        assertThatThrownBy(() -> gameInput.convertToCarNameList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Carname length must be <= " + 5);
    }


}