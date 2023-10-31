package racingcar.controller;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void isValid_중복된_값() {
        List<String> values = Arrays.asList("pobi", "woni", "pobi");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.isValid(values));
        assertThat(exception).hasMessage(null);
    }

    @Test
    void isValid_길이_초과() {
        List<String> values = Arrays.asList("pobi", "woni", "junyoung");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.isValid(values));
        assertThat(exception).hasMessage(null);
    }

    @Test
    void isValid_올바른_값() {
        List<String> values = Arrays.asList("pobi", "woni", "jun");

        assertThatCode(() -> InputValidator.isValid(values)).doesNotThrowAnyException();
    }
}