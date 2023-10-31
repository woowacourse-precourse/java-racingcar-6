package racingcar.utils;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class ValidityTest {

    @Test
    void 글자_5_이하_통과_체크() {
        String str = "abcde";
        assertThat(true)
                .isEqualTo(Validity.isLessThanFiveCharacters(str));
    }

    @Test
    void 글자_5_초과_실패_체크() {
        String str = "abcdef";
        assertThat(false)
                .isEqualTo(Validity.isLessThanFiveCharacters(str));
    }


    @Test
    void 숫자_양수_int범위내_성공_체크() {
        String n = "10";
        assertThat(true)
                .isEqualTo(Validity.isPlusIntNumber(n));
    }

    @Test
    void 숫자_숫자가아님_실패_체크() {
        String n = "3ab9c";
        assertThat(false)
                .isEqualTo(Validity.isPlusIntNumber(n));

    }

    @Test
    void 숫자_음수_실패_체크() {
        String n = "-31";
        assertThat(false)
                .isEqualTo(Validity.isPlusIntNumber(n));
    }

    @Test
    void 숫자_양수_int범위외_실패_체크() {
        String n = "2147483649";
        assertThat(false)
                .isEqualTo(Validity.isPlusIntNumber(n));
    }
}