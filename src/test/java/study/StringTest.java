package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_메서드로_특정_위치의_문자_찾기() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    void trim_입력_문자열이_공백일_경우_예외_발생() {
        String input = " ";

        assertThatThrownBy(() -> validateName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Name should not be blank");
    }

    void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name should not be blank");
        }
    }

    @Test
    void 사용자에게_입력_받은_값이_0과_같거나_보다_작은경우_예외_발생() {
        String input = "0";

        assertThatThrownBy(() -> validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Number should be greater than 0");
    }

    void validateNumber(String numberStr) {
        int number = Integer.parseInt(numberStr);
        if (number <= 0) {
            throw new IllegalArgumentException("Number should be greater than 0");
        }
    }

    @Test
    void 사용자에게_입력_받은_값이_숫자가_아닐경_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> validateIsNumber(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string: \"" + input + "\"");
    }

    void validateIsNumber(String numberStr) {
        int number = Integer.parseInt(numberStr);
    }
}
