package study;

import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Test
    void stream_문자열_배열에서_각_문자열의_앞뒤_공백_제거_후_길이가_5_이하인_문자열만_필터링_후_stream_반환() {
        String[] input = {" 123 ", "  12345", "  123456  "};

        Stream<String> result = Arrays.stream(input).map(String::strip).filter(str -> str.length() <= 5);

        assertThat(result)
                .hasSize(2)
                .contains("123", "12345");
    }

    @Test
    void mapping_stream에서_문자열_각각을_key로_하는_map_객체_생성() {
        Stream<String> inputStream = Stream.of("pobi",
                "tobi",
                "navi");

        Map<String, String> result = inputStream.collect(toMap(data -> data, data -> ""));
        Map<String, String> expected = Map.of(
                "pobi", "",
                "tobi", "",
                "navi", ""
        );

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void parseInt_문자열이_정수인지_확인() {
        String input1 = "10";
        String input2 = "1o";

        assertThat(Integer.parseInt(input1)).isEqualTo(10);
        
        assertThatThrownBy(() -> Integer.parseInt(input2))
                .isInstanceOf(NumberFormatException.class);
    }

}
