package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @Test
    void 공백_또는_공백포함_예외() {
        // given
        final String includeBlank = "woo wa";
        final String blank = "";

        // when
        final IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> Validator.nameBlankCheck(includeBlank));
        final IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> Validator.nameBlankCheck(blank));
        // then
        Assertions.assertThat(exception1.getMessage()).isEqualTo("이름에 공백이 포함되었습니다.");
        Assertions.assertThat(exception2.getMessage()).isEqualTo("이름에 공백이 포함되었습니다.");
    }

    @Test
    void 길이_초과_예외() {
        // given
        final String string = "woowatech";

        // when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.nameLengthCheck(string));

        // then
        Assertions.assertThat(exception.getMessage()).isEqualTo("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 중복_이름_예외() {
        // given
        final List<String> names = Arrays.asList("pobi", "woni", "jun", "pobi");

        // when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.nameDuplicatenCheck(names));

        // then
        Assertions.assertThat(exception.getMessage()).isEqualTo("중복된 이름이 존재합니다.");
    }

    @Test
    void 공백_입력_예외() {
        // given
        final String blank = "";

        // when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.blankCheck(blank));

        // then
        Assertions.assertThat(exception.getMessage()).isEqualTo("잘못된 값이 입력되었습니다.");
    }

    @Test
    void 횟수_0_입력_예외() {
        // given
        final String zero = "0";

        // when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.countZeroCheck(zero));

        // then
        Assertions.assertThat(exception.getMessage()).isEqualTo("0이 아닌 양의 정수 입력해주세요.");
    }

    @Test
    void 횟수_입력_예외() {
        // given
        final String numberIncludeRealNumber = "12.34";
        final String numberIncludeChar = "a123";
        final String numberIncludeBlank = "1 2";
        final String nonNumeric = "www";

        // when
        final IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> Validator.countNumericCheck(numberIncludeRealNumber));
        final IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> Validator.countNumericCheck(numberIncludeChar));
        final IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class,
                () -> Validator.countNumericCheck(numberIncludeBlank));
        final IllegalArgumentException exception4 = assertThrows(IllegalArgumentException.class,
                () -> Validator.countNumericCheck(nonNumeric));

        // then
        Assertions.assertThat(exception1.getMessage()).isEqualTo("잘못된 값이 입력되었습니다.");
        Assertions.assertThat(exception2.getMessage()).isEqualTo("잘못된 값이 입력되었습니다.");
        Assertions.assertThat(exception3.getMessage()).isEqualTo("잘못된 값이 입력되었습니다.");
        Assertions.assertThat(exception4.getMessage()).isEqualTo("잘못된 값이 입력되었습니다.");
    }
}
