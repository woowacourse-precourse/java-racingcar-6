package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static racingcar.service.Validator.*;

public class ValidatorTest {

    @Test
    void 입력한_이름_6글자_이상인지_검증_실패_케이스() {
        // given
        String[] input = {"abcdef","AB"};

        // when
        boolean result = isValidNameLength(input);

        // then
        Assertions.assertThat(result).isFalse();
    }
    @Test
    void 입력한_이름_공백_체크_검증_실패_케이스() {
        // given
        String[] input = {"A B","AB"};

        // when
        boolean result = hasNotContainSpace(input);

        // then
        Assertions.assertThat(result).isFalse();
    }
    @Test
    void 입력한_이름_중복_체크_검증_실패_케이스() {
        // given
        String[] input = {"AB","AB"};

        // when
        boolean result = streamDuplicateCheck(input);

        // then
        Assertions.assertThat(result).isFalse();
    }
    @Test
    void 입력한_이름_갯수_체크_검증_실패_케이스() {
        // given
        String[] input = {"AB"};

        // when
        boolean result = isValidListLength(input);

        // then
        Assertions.assertThat(result).isFalse();
    }
    @Test
    void 입력한_숫자_양수_체크_검증_실패_케이스() {
        // given
        String input = "-1";

        // when
        boolean result = isValidNum(input);

        // then
        Assertions.assertThat(result).isFalse();
    }
}
