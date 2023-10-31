package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.validator.InputValidator.IsListDuplicate;
import static racingcar.util.validator.InputValidator.IsStringLengthValid;
import static racingcar.util.validator.InputValidator.checkBlank;
import static racingcar.util.validator.InputValidator.checkComma;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.util.Util;

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
    void 문자열_앞뒤_쉼표_포함_시_예외_발생() {
        String input = ",abc,test";

        assertThatThrownBy(() -> checkComma(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력받은 값 앞뒤 ','쉼표 포함");
    }

    @Test
    void 분리된_문자열_앞뒤_공백_포함_시_예외_발생() {
        String input = "test ";

        assertThatThrownBy(() -> checkBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자열 앞뒤 ' '공백 포함");
    }

    @Test
    void 분리된_문자열_길이가_6_이상인_경우_예외_발생() {
        String input = "123456";

        assertThatThrownBy(() -> IsStringLengthValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자열 길이 6자리 이상");
    }
    @Test
    void 분리된_문자열_길이가_0인_경우_예외_발생() {
        String input = "";

        assertThatThrownBy(() -> IsStringLengthValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자열 길이 0");
    }

    @Test
    void 분리된_문자열_중복인_경우_예외_발생() {
        String input = "test,test";
        Util util = new Util();
        List<String> list = util.splitStringToList(input);
        assertThatThrownBy(() -> IsListDuplicate(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자열 중복");
    }

}
