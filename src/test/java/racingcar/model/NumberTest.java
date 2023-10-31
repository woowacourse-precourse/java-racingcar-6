package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    @DisplayName("양수를 가져올 수 있는지 확인")
    @Test
    void getNumber() {
        // given
        final String num = "2";
        final Number number = new Number(num);

        // when
        int value = number.getNumber();

        // then
        assertThat(value).isEqualTo(Integer.parseInt(num));
    }

    @DisplayName("음수를 입력하면 예외 발생 확인")
    @Test
    void createNumberThrowCase1() {
        // given
        final String num = "-1";

        // when, then
        assertThatThrownBy(() -> new Number(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이하의 수를 입력할 수 없습니다.");
    }

    @DisplayName("0을 입력하면 예외 발생 확인")
    @Test
    void createNumberThrowCase2() {
        // given
        final String num = "0";

        // when, then
        assertThatThrownBy(() -> new Number(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이하의 수를 입력할 수 없습니다.");
    }


    @DisplayName("문자열을 입력하면 예외 발생 확인")
    @Test
    void createNumberThrowCase3() {
        // given
        final String num = "숫자";

        // when, then
        assertThatThrownBy(() -> new Number(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수가 아닙니다.");
    }
}