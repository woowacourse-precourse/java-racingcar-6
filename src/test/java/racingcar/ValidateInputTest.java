package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateInputTest {
    @Test
    void validateCarInputBlank_유효성검사_성공_테스트() {
        String input = "red";

        Application.validateCarInputBlank(input);
    }

    @Test
    void validateCarInputBlank_유효성검사_실패_테스트() {
        String input = "";

        assertThatThrownBy(() -> Application.validateCarInputBlank(input))
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
}
