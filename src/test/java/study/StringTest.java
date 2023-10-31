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
    void split_메서드_사용시_구분자가_연속으로_포함된_경우_빈문자열_반환() {
        String input = "1,,2";
        String[] result = input.split(",");

        assertThat(result).contains("");
    }

    @Test
    void split_메서드_사용시_구분자로만_구성된_문자열인_경우_빈_배열_반환() {
        String input = ",,,";
        int result = input.split(",").length;

        assertThat(result).isEqualTo(0);
    }

    @Test
    void split_메서드_사용시_공백이_포함된_경우_공백도_포함하여_반환() {
        String input = "1, ,2";
        String[] result = input.split(",");

        assertThat(result).contains(" ");
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
    void contains_문자열에_특정_문자가_있는지_확인() {
        String target = ",";
        String inputWithTarget = "abc , 123";
        String inputWithoutTarget = "abc";

        assertThat(inputWithTarget.contains(target)).isTrue();
        assertThat(inputWithoutTarget.contains(target)).isFalse();
    }

    @Test
    void strip_문자열의_앞뒤_공백_제거() {
        String input = "  123 ";

        assertThat(input.strip()).isEqualTo("123");
    }
}
