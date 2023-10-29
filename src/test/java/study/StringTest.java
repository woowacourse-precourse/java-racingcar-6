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
    void compareTo_A_B_비교하기() {
        String a = "abc";
        String b = "bcd";
        assertThat(a.compareTo(b)).isEqualTo(-1);
    }

    @Test
    void compareTo_A_B_비교하기_2() {
        String a = "abc";
        String b = "bcd";
        assertThat(b.compareTo(a)).isEqualTo(1);
    }
    @Test
    void contains_포함되어_있는지_체크() {
        String a = "abc";
        String b = "b";

        assertThat(a.contains(b)).isEqualTo(true);
    }

    @Test
    void contains_포함되어_있는지_체크_2() {
        String a = "abc";
        String b = "abcdef";

        assertThat(a.contains(b)).isEqualTo(false);
    }

    @Test
    void startsWith_대상으로_시작하는_체크() {
        String a = "abcd";
        String b = "a";

        assertThat(a.startsWith(b)).isEqualTo(true);
    }

    @Test
    void endsWith_대상으로_끝나는지_체크() {
        String a = "abcd";
        String b = "d";

        assertThat(a.endsWith(b)).isEqualTo(true);
    }

    @Test
    void equals_두_대상의_동등성_비교() {
        String a = "abcd";
        String b = "abcd";

        assertThat(a.equals(b)).isEqualTo(true);
    }

    @Test
    void equals_두_대상의_동등성_비교_2() {
        String a = "abcd";
        String b = "abc";

        assertThat(a.equals(b)).isEqualTo(false);
    }

    @Test
    void equals_두_대상의_동등성_비교_예외상황() {
        String a = null;
        String b = "abc";

        assertThatThrownBy(() -> a.equals(b)).isInstanceOf(NullPointerException.class).hasMessageContaining("\"a\" is null");
    }

}
