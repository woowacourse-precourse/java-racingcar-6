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
    void length_메서드로_문자열의_길이를_확인() {
        String input = "Hello, World!";
        int length = input.length();

        assertThat(length).isEqualTo(13);
    }

    @Test
    void trim_메서드로_문자열_앞뒤의_공백을_제거() {
        String input = "   Hello, World!   ";
        String trimmed = input.trim();

        assertThat(trimmed).isEqualTo("Hello, World!");
    }

    @Test
    void equalsIgnoreCase_메서드로_대소문자_구분_없는_문자열_비교() {
        String input = "Hello, World!";
        boolean isEqual = input.equalsIgnoreCase("hello, world!");

        assertThat(isEqual).isTrue();
    }

    @Test
    void concat_메서드로_두_문자열을_연결() {
        String firstPart = "Hello, ";
        String secondPart = "World!";
        String concatenated = firstPart.concat(secondPart);

        assertThat(concatenated).isEqualTo("Hello, World!");
    }

    @Test
    void startsWith_메서드로_문자열이_특정_문자열로_시작하는지_확인() {
        String input = "Hello, World!";
        boolean startsWithHello = input.startsWith("Hello");

        assertThat(startsWithHello).isTrue();
    }

}
