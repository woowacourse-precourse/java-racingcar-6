package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountTest {

    @Test
    void strToInt_메서드로_입력_문자열을_숫자_값으로_변환_후_반환() {
        Count count = new Count("123");
        String isInt = (((Integer) count.val).getClass().getSimpleName());

        assertThat(isInt).isEqualTo("Integer");
    }
}