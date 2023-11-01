package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryTimesValidatorTest {
    @Test
    @DisplayName("시도 횟수 입력 통과 케이스")
    void testTryTimes() {
        //given
        String tryTimes = "5";
        //when
        //then
        TryTimesValidator.validateNumber(tryTimes);
    }

    @Test
    @DisplayName("0 입력했을 시 실패")
    void testIfTryTimesIsZero() {
        //given
        String tryTimes = "0";
        //when
        //then
        Assertions.assertThatThrownBy(() -> TryTimesValidator.validateNumber(tryTimes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1이상의 숫자만 입력해주세요.\n");
    }

    @Test
    @DisplayName("음수 값 입력했을 시 실패")
    void testIfTryTimesIsNegative() {
        //given
        String tryTimes = "-5";
        //when
        //then
        Assertions.assertThatThrownBy(() -> TryTimesValidator.validateNumber(tryTimes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1이상의 숫자만 입력해주세요.\n");
    }

    @Test
    @DisplayName("숫자 외의 값 입력 시 실패")
    void testIfTryTimesHasLetter() {
        //given
        String tryTimes = "g5";
        //when
        //then
        Assertions.assertThatThrownBy(() -> TryTimesValidator.validateNumber(tryTimes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1이상의 숫자만 입력해주세요.\n");
    }

    @Test
    @DisplayName("공백만 입력했을 시 실패")
    void testIfTryTimesIsEmpty() {
        //given
        String tryTimes = "";
        //when
        //then
        Assertions.assertThatThrownBy(() -> TryTimesValidator.validateNumber(tryTimes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1이상의 숫자만 입력해주세요.\n");
    }
}