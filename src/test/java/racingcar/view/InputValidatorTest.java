package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setup() {
        this.inputValidator = new InputValidator();
    }

    @DisplayName("이름에 빈 공간이 있는 경우 예외발생")
    @Test
    void inputNameValidFalseTest() {
        List<String> names = List.of("nana", "", "sol");
        assertThat(inputValidator.nameSplitValid(names)).isFalse();

    }

    @DisplayName("이름에 빈 공간이 없는 경우 true")
    @Test
    void inputNameValidTrueTest() {
        List<String> names = List.of("nana", "sol");
        assertThat(inputValidator.nameSplitValid(names)).isTrue();
    }

    @DisplayName("이름 없는 경우")
    @Test
    void inputNameValidNullTest() {
        List<String> names = List.of("");
        assertThat(inputValidator.nameSplitValid(names)).isFalse();
    }


}