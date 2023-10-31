package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.InputError.NOT_DIGIT_MOVING_COUNT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovingCountTest {

    @DisplayName("이동 횟수 생성 시 숫자 값을 입력받는다.")
    @Test
    void success_Valid_Input() {
        // given
        System.out.println(Integer.MAX_VALUE);
        String input = "1";
        int expected = Integer.parseInt(input);

        // when
        MovingCount result = MovingCount.createMovingCount(input);

        // then
        assertThat(result).hasFieldOrPropertyWithValue("count", expected);
    }

    @DisplayName("이동 횟수 생성 시 숫자가 아닌 값을 입력 받으면 예외가 발생한다.")
    @Test
    void exception_Invalid_Input_Not_Digit() {
        // given
        String input = "123a23";
        // when // then
        assertThatThrownBy(() -> MovingCount.createMovingCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIGIT_MOVING_COUNT.toString());
    }
}
