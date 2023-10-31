package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.TotalRoundInputValidator.TotalRoundInputExceptionMessage;

class TotalRoundInputValidatorTest {

    @Nested
    @DisplayName("잘못된 입력 테스트")
    class WrongInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"r", "띵", "불", "땅", "f", "da", "QWE", "ㄱ", "봉"})
        @DisplayName("[실패 테스트] 숫자가 아닌 입력: 문자")
        void notNumericTest(String input) {
            // when, then
            Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                    .hasMessage(TotalRoundInputExceptionMessage.NOT_NUMERIC.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1 ", " 4", " 5 ", "", " ", "  "})
        @DisplayName("[실패 테스트] 숫자가 아닌 입력: 공백 포함")
        void blankMixTest(String input) {
            Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                    .hasMessage(TotalRoundInputExceptionMessage.NOT_NUMERIC.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"01", "001", "00001", "00000001"})
        @DisplayName("[실패 테스트] 숫자가 아닌 입력: 0으로 시작")
        void startZeroTest(String input) {
            Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                    .hasMessage(TotalRoundInputExceptionMessage.NOT_NUMERIC.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"-0"})
        @DisplayName("[실패 테스트] 숫자가 아닌 입력: 마이너스 입력")
        void minusZeroTest(String input) {
            Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                    .hasMessage(TotalRoundInputExceptionMessage.NOT_NUMERIC.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"+0", "+1", "+2", "+10", "+100"})
        @DisplayName("[실패 테스트] 숫자가 아닌 입력: 플러스 입력")
        void plusTest(String input) {
            Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                    .hasMessage(TotalRoundInputExceptionMessage.NOT_NUMERIC.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"2147483648", "-2147483649"})
        @DisplayName("[실패 테스트] Integer 범위 초과 입력")
        void rangeEdgeFailTest(String input) {
            Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                    .hasMessage(TotalRoundInputExceptionMessage.NOT_INTEGER.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"0", "2147483647"})
        @DisplayName("[실패 테스트] 유효하지 않은 범위 입력")
        void zeroTest(String input) {
            Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                    .hasMessage(TotalRoundInputExceptionMessage.OUT_OF_RANGE.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"-1", "-10", "-100", "-1000000"})
        @DisplayName("[실패 테스트] 유효하지 않은 범위 입력: 음수")
        void minusTest(String input) {
            Assertions.assertThatThrownBy(() -> TotalRoundInputValidator.validate(input))
                    .hasMessage(TotalRoundInputExceptionMessage.OUT_OF_RANGE.getError());
        }
    }

    @Nested
    @DisplayName("올바른 입력 테스트")
    class CorrectInputTest {

        static final String MIN_TOTAL_ROUND = "1";
        static final String MAX_TOTAL_ROUND = "10";

        @ParameterizedTest
        @ValueSource(strings = {MIN_TOTAL_ROUND, MAX_TOTAL_ROUND})
        void edgeTest(String input) {
            Assertions.assertThatCode(() -> TotalRoundInputValidator.validate(input))
                    .doesNotThrowAnyException();
        }
    }
}