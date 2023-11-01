package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    Number number;
    final static String NUM_SIZE_ERROR_MSG = "0~9 사이 숫자를 입력해주세요!";
    final static String NUM_STRING_ERROR_MSG = "숫자가 아닙니다!";
    @Test
    void 숫자입력_Number_예외_테스트() {
        String num = "12";
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> number = new Number(num));
        assertThat(e.getMessage()).isEqualTo(NUM_SIZE_ERROR_MSG);
    }

    @Test
    void 숫자입력_string_예외_테스트() {
        String num = "a";
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> number = new Number(num));
        assertThat(e.getMessage()).isEqualTo(NUM_STRING_ERROR_MSG);
    }
}