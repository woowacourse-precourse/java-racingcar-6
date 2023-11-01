package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        //모두 입력하지 않아도, 중복 값 있어도, 순서 바뀌어도 성공, String/collection 사용가능
        assertThat(result).contains("1", "2");
        assertThat(result).contains("2", "1");
        assertThat(result).contains("1", "2", "2");
        assertThat(result).contains("2");

        //contain에서 원소 개수까지 맞아야함 (순서랑 중복은 상관 없음)
        assertThat(result).containsOnly("1", "2");
        assertThat(result).containsOnly("2", "1");
        assertThat(result).containsOnly("1", "2", "2");
//        assertThat(result).containsOnly("2");

        //중복 값, 순서 다른 것 도 허용 안함
        assertThat(result).containsExactly("1", "2");
//        assertThat(result).containsExactly("2", "1");
//        assertThat(result).containsExactly("1", "2", "2");
//        assertThat(result).containsExactly("2");
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
        String resultCopy = result;

        // 값을 비교
        assertThat(result).isEqualTo("1,2");
        assertThat(result).isEqualTo(resultCopy);
        
        //주소를 비교
//        assertThat(result).isSameAs("1,2");
        assertThat(result).isSameAs(resultCopy);
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

}
