package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.message.ErrorMessage;

@Nested
class RacingTest {


    @Test
    @DisplayName("음의 정수인 시도횟수 입력에 대해서 예외 발생에 성공한다")
    void validateTryCountTest01() {
        //given
        String testInput = "-1";
        assertThatThrownBy(() -> Racing.validateTryCount(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_AN_INTEGER_OVER_ZERO.getMessage());
    }

    @Test
    @DisplayName("시도횟수에 대한 입력 0에 대해서 예외 발생에 성공한다.")
    void validateTryCountTest02() {
        //given
        String testInput = "0";
        assertThatThrownBy(() -> Racing.validateTryCount(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_AN_INTEGER_OVER_ZERO.getMessage());
    }

    @Test
    @DisplayName("유효한 시도횟수 입력에 대해서 입력의 정수값을 반환한다")
    void validateTryCountTest03() {
        String testInput = "7";
        assertThat(Racing.validateTryCount(testInput))
                .isEqualTo(Integer.parseInt(testInput));
    }

    @Test
    @DisplayName("규정 길이를 초과하는 자동차 이름 입력에 대해서 예외 발생에 성공한다")
    void validateCarNameTest01() {
        String testInput = "pobiNbipo";
        assertThatThrownBy(() -> Racing.validateCarName(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_LENGTH_MUST_BE_UNDER_5.getMessage());
    }
}