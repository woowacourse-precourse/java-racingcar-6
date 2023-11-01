package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StringTest {

    @Test
    void isEmpty_isBlank() {
        System.out.println(" 조민서".isEmpty() + " " + " 조민서".isBlank()); // false, false
        System.out.println("조민서 ".isEmpty() + " " + "조민서 ".isBlank()); // false, false
        System.out.println(" 조민서 ".isEmpty() + " " + " 조민서 ".isBlank()); // false, false
        System.out.println("".isEmpty() + " " + "".isBlank()); // true, true
        System.out.println(" ".isEmpty() + " " + " ".isBlank()); // false, true
    }

    @Test
    void contains_문자열에서_찾기() {
        String input = "(1,2,3)";
        boolean result = input.contains("1,2,3)");
        assertThat(result).isTrue();

        result = input.contains("1,3");
        assertThat(result).isFalse();

        result = input.contains("");
        assertThat(result).isTrue();
    }

    @Test
    void 널포인트예외() {
        String input = null;

        assertThatThrownBy(() -> input.charAt(0))
                .isInstanceOf(NullPointerException.class);

        assertThatThrownBy(() -> input.substring(0))
                .isInstanceOf(NullPointerException.class);

        assertThatThrownBy(() -> input.contains(""))
                .isInstanceOf(NullPointerException.class);

        assertThatThrownBy(() -> input.split(""))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_맨앞_regex_시작() {
        String input = ",1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("","1", "2");
    }

    @Test
    void split_맨뒤_regex() {
        String input = "1,2,";
        String[] result = input.split(",");
        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_맨뒤_regex_limit() {
        String input = "1,2,3,4,5,6,7,8,9,10";
        String[] result = input.split(",",5);
        assertThat(result).containsExactly("1", "2", "3", "4", "5,6,7,8,9,10");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "123";
        String[] result = input.split(",");
        assertThat(result).contains("123");
    }

    @Test
    void substring_메서드로_구간_반환() {
        String input = "(1,2)";
        String result = input.substring(1);
        assertThat(result).isEqualTo("1,2)");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void substring_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "(1,2)";
        assertThatThrownBy(() -> input.substring(1, 6))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("begin 1, end 6, length 5");
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
    void repeat_매서드_사용시_문자열_반복_추가후_반환() {
        String input = "-";
        String result = input.repeat(5);
        assertThat(result).isEqualTo("-----");

        input = "";
        result = input.repeat(1000);
        assertThat(result).isEqualTo("");
    }

    @Test
    void join_문자열_합치기() {
        String[] foodArray = {"cream", "cheese", "eggs", "milk"};
        String result = String.join(",", foodArray);
        assertThat(result).isEqualTo("cream,cheese,eggs,milk");
        List<String> foodList = Arrays.asList("cream", "cheese", "eggs", "milk");
        result = String.join(",", foodList);
        assertThat(result).isEqualTo("cream,cheese,eggs,milk");
    }

    @Test
    void join_문자열_합치기_응용() {
        String input = "cream,500원 cheese,1000원";
        String[] splitList = input.split(",");
        String result = String.join(":", splitList);
        assertThat(result).isEqualTo("cream:500원 cheese:1000원");
    }

    @Test
    void replace_문자열_변경() {
        String input = "abc abc abc";
        String result = input.replace("abc", "ABC");
        assertThat(result).isEqualTo("ABC ABC ABC");
    }

    @Test
    void replaceAll_정규식() {
        String input = "phoneasd010phonasde1234phoeasdn5678asd";
        String result = input.replaceAll("[^0-9]", "");
        assertThat(result).isEqualTo("01012345678");
    }

    @Test
    void replaceFirst_문자열() {
        String input = "abc abc abc";
        String result = input.replaceFirst("abc", "ABC");
        assertThat(result).isEqualTo("ABC abc abc");
    }

    @Test
    void replaceFirst_정규식() {
        String input = "phoneasd010phonasde1234phoeasdn5678asd";
        String result = input.replaceFirst("[^0-9]", "");
        assertThat(result).isEqualTo("honeasd010phonasde1234phoeasdn5678asd");
    }

    @Test
    void 메모리주소_test() {
        String javaStr = "Java";
        String oldStr = "자바 프로그래밍";
        String newStr = oldStr.replace("자바 프로그래밍", "Java");
        String subStr = newStr.substring(0);
        String javaSubStr0 = javaStr.substring(0);
        String javaSubStr2 = javaStr.substring(2);

        assertThat(javaStr).isSameAs("Java");               // 1 번
        //assertThat(subStr).isSameAs("Java");                // 2 번
        //assertThat(javaStr).isSameAs(newStr);                        // 3 번
        assertThat(javaSubStr0).isSameAs("Java");           // 4 번
        //assertThat(javaSubStr2).isSameAs("va");             // 5 번
        assertThat(subStr).isSameAs(newStr);                         // 6 번
    }
}
