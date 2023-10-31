package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameCountValidatorTest {

    @Test
    @DisplayName("게임 진행 횟수가 양의 정수가 아닐 때 예외를 발생시킨다.")
    void throwExceptionGameCountNotPositiveDigit() {
        //given // when // then
        Assertions.assertThatThrownBy(() -> GameCountValidator.validatePositiveDigitAnInRangeGameCount("0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("게임 진행 횟수는 양의 정수만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("게임 진행 횟수가 10을 초과할 경우 예외를 발생시킨다.")
    void throwExceptionGameOver10() {
        //given // when // then
        Assertions.assertThatThrownBy(() -> GameCountValidator.validatePositiveDigitAnInRangeGameCount("11"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("게임 진행 횟수는 10이하의 수만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("게임 진행 횟수가 10이하일 경우 예외를 발생시키지 않는다.")
    void noThrowExceptionGameCountLessThanEquals10() {
        //given // when // then
        Assertions.assertThatCode(() -> GameCountValidator.validatePositiveDigitAnInRangeGameCount("10"))
            .doesNotThrowAnyException();
    }
}