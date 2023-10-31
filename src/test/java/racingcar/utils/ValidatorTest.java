package racingcar.utils;

import org.junit.jupiter.api.Test;
import racingcar.enums.Common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    Validator validator = new Validator();
    @Test
    void 자연수_테스트() {
        assertThat(validator.isPositive("-1")).isFalse();
        assertThat(validator.isPositive(-1)).isFalse();
        assertThat(validator.isPositive(5)).isTrue();
        assertThat(validator.isPositive("5")).isTrue();
    }
    @Test
    void 숫자_검증_테스트() {
        assertThat(validator.isNumeric("abc")).isFalse();
        assertThat(validator.isNumeric("abc5")).isFalse();
        assertThat(validator.isNumeric("5")).isTrue();
    }

    @Test
    void 숫자_비교_테스트() {
        assertThat(validator.isOverMaxLength("123")).isFalse();
        assertThat(validator.isOverMaxLength("1234")).isFalse();
        assertThat(validator.isOverMaxLength("12345")).isFalse();
        assertThat(validator.isOverMaxLength("123456")).isTrue();
    }
    @Test
    void 차_이름_예외_테스트() {
        // 5글자 이상
        assertThatThrownBy(() -> validator.validateCarNameInput("123456")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validateCarNameInput("isaacHan")).isInstanceOf(IllegalArgumentException.class);
        // 공백
        assertThatThrownBy(() -> validator.validateCarNameInput(" ")).isInstanceOf(IllegalArgumentException.class);
        // 구분자만
        assertThatThrownBy(() -> validator.validateCarNameInput(Common.SEPARATOR.getStringValue())).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validateCarNameInput(",,,,")).isInstanceOf(IllegalArgumentException.class);
        // 여러 이름중 5글자 이상
        assertThatThrownBy(() -> validator.validateCarNameInput("a,b,c,d,efghij")).isInstanceOf(IllegalArgumentException.class);
        // 여러 이름중 공백
        assertThatThrownBy(() -> validator.validateCarNameInput("a,b,c, ,efghij")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_예외_테스트() {
        // 문자일 경우
        assertThatThrownBy(() -> validator.validateNumberOfAttemptsInput("isaac")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validateNumberOfAttemptsInput("%$#!@#")).isInstanceOf(IllegalArgumentException.class);
        // 0일 경우
        assertThatThrownBy(() -> validator.validateNumberOfAttemptsInput("0")).isInstanceOf(IllegalArgumentException.class);
        // 음수일 경우
        assertThatThrownBy(() -> validator.validateNumberOfAttemptsInput("-1")).isInstanceOf(IllegalArgumentException.class);
    }
}