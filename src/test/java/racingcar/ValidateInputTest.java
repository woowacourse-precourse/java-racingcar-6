package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateInputTest {
    @Test
    void validateCarNameBlank_유효성검사_성공_테스트() {
        String input = "red";

        Application.validateCarNameBlank(input);
    }

    @Test
    void validateCarNameBlank_유효성검사_실패_테스트() {
        String input = "";

        assertThatThrownBy(() -> Application.validateCarNameBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarListInputBlank_유효성검사_성공_테스트() {
        List<String> inputList = Arrays.asList("red", "green", "blue");

        Application.validateCarListInputBlank(inputList);
    }

    @Test
    void validateCarListInputBlank_유효성검사_실패_테스트() {
        List<String> inputList = Arrays.asList("", "red", "green");

        assertThatThrownBy(() -> Application.validateCarListInputBlank(inputList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNameLength_유효성검사_성공_테스트() {
        String input = "abcde";

        Application.validateCarNameLength(input);
    }

    @Test
    void validateCarNameLength_유효성검사_실패_테스트() {
        String input = "abcdef";

        assertThatThrownBy(() -> Application.validateCarNameLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarListInputLength_유효성검사_성공_테스트() {
        List<String> inputList = Arrays.asList("red", "green", "blue");

        Application.validateCarListInputLength(inputList);
    }

    @Test
    void validateCarListInputLength_유효성검사_실패_테스트() {
        List<String> inputList = Arrays.asList("red", "purple", "yellow");

        assertThatThrownBy(() -> Application.validateCarListInputLength(inputList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarListInputUnique_유효성검사_성공_테스트() {
        List<String> inputList = Arrays.asList("red", "green", "blue");

        Application.validateCarListInputUnique(inputList);
    }

    @Test
    void validateCarListInputUnique_유효성검사_실패_테스트() {
        List<String> inputList = Arrays.asList("red", "green", "red");

        assertThatThrownBy(() -> Application.validateCarListInputUnique(inputList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
