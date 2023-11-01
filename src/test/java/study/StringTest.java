package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
    void join_문자열_배열_구분자로_합치기() {
        List<String> strings1 = List.of(new String[]{"poni", "woni", "jun"});
        List<String> strings2 = List.of(new String[]{"poni"});
        String str = "poni, woni, jun";

        String result1 = String.join(", ", strings1);
        String result2 = String.join(", ", strings2);

        assertThat(result1).isEqualTo(str);
        assertThat(result2).isEqualTo("poni");
    }

    @ParameterizedTest
    @CsvSource({"5", "10", "100"})
    void validateNumber_숫자인지_확인(String input) {
        assertThat(Integer.parseInt(input)).isInstanceOf(Number.class);
    }
}
