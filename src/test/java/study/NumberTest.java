package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    void parseInt_숫자_아닌_경우_예외_발생() {
        String input = "문자";

        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string: ");
    }

    @Test
    void parseInt_null_경우_예외_발생() {
        String input = null;

        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("Cannot parse null string");
    }
}
