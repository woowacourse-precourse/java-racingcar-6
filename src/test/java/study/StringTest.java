package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split 메소드로 주어진 값을 구분")
    void useSplitCase1() {
        final String input = "1,2";
        final String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split 메소드 사용 시 구분자가 포함되지 않은 경우 값을 그대로 반환")
    void useSplitCase2() {
        final String input = "1";
        final String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("substring 메소드로 특정 구간 값을 반환")
    void useSubstring() {
        final String input = "(1,2)";
        final String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드로 특정 위치의 문자 찾기")
    void useCharAtCase1() {
        final String input = "abc";
        final char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt 메소드 사용 시 문자열의 길이보자 큰 숫자 위치의 문자를 찾을 때 예외 발생")
    void useCharAtCase2() {
        final String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
