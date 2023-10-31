package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.TotalRoundInputValidator.TotalRoundInputExceptionMessage;

class TotalRoundInputValidatorTest {

    @Test
    @DisplayName("[실패 테스트] 숫자가 아닌 입력 - 문자")
    void notNumericTest() {
        // given
        String input = "r";
        // when, then
        Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                .hasMessage(TotalRoundInputExceptionMessage.NOT_NUMERIC.getError());
    }

    @Test
    @DisplayName("[실패 테스트] 숫자가 아닌 입력: 공백 혼합")
    void blankMixTest() {
        // given
        String input = "1 ";
        // when, then
        Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                .hasMessage(TotalRoundInputExceptionMessage.NOT_NUMERIC.getError());
    }

    @Test
    @DisplayName("[실패 테스트] 숫자가 아닌 입력: 0으로 시작")
    void startZeroTest() {
        // given
        String input = "00000001";
        // when, then
        Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                .hasMessage(TotalRoundInputExceptionMessage.NOT_NUMERIC.getError());
    }

    @Test
    @DisplayName("[실패 테스트] 숫자가 아닌 입력: -0 입력")
    void minusZeroTest() {
        // given
        String input = "-0";
        // when, then
        Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                .hasMessage(TotalRoundInputExceptionMessage.NOT_NUMERIC.getError());
    }

    @Test
    @DisplayName("[실패 테스트] 숫자가 아닌 입력: 공백")
    void blankTest() {
        // given
        String input = "";
        // when, then
        Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                .hasMessage(TotalRoundInputExceptionMessage.NOT_NUMERIC.getError());
    }

    @Test
    @DisplayName("[실패 테스트] Integer 범위 초과 입력: 2147483647 초과")
    void rangeEdgeFailTest() {
        // given
        String input = "2147483648";
        // when, then
        Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                .hasMessage(TotalRoundInputExceptionMessage.NOT_INTEGER.getError());
    }

    @Test
    @DisplayName("[실패 테스트] Integer 범위 초과 입력: -2147483648 미만")
    void rangeEdgeFailTest2() {
        // given
        String input = "-2147483649";
        // when, then
        Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                .hasMessage(TotalRoundInputExceptionMessage.NOT_INTEGER.getError());
    }

    @Test
    @DisplayName("[실패 테스트] 유효하지 않은 범위 입력: 0")
    void zeroTest() {
        // given
        String input = "0";
        // when, then
        Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                .hasMessage(TotalRoundInputExceptionMessage.OUT_OF_RANGE.getError());
    }

    @Test
    @DisplayName("[실패 테스트] 유효하지 않은 범위 입력: 음수")
    void minusTest() {
        // given
        String input = "-1";
        // when, then
        Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                .hasMessage(TotalRoundInputExceptionMessage.OUT_OF_RANGE.getError());
    }

    @Test
    @DisplayName("[성공 테스트] Integer 범위 이하 입력")
    void rangeEdgeSuccessTest() {
        // given
        String input = "2147483647";
        // when, then
        Assertions.assertThatCode(() -> TotalRoundInputValidator.validate(input))
                .hasMessage(TotalRoundInputExceptionMessage.OUT_OF_RANGE.getError());
    }
}