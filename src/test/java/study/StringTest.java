package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

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
    void 문자열_배열을_Cars_객체로_변환한다() {
        String[] splitNames = "jenny,risa,rose,jisoo".split(",");
        List<Car> carList = Arrays.stream(splitNames)
                .map(Car::of)
                .toList();
        assertEquals(carList.size(), 4);
    }

    @Test
    void 정규표현식으로_알파벳_문자열임을_검증한다() {
        String name1 = "jenny";
        String name2 = "Jenny1";

        boolean match1 = name1.matches("[a-zA-Z]+");
        boolean match2 = name2.matches("[a-zA-Z]+");

        assertThat(match1).isTrue();
        assertThat(match2).isFalse();
    }
}
