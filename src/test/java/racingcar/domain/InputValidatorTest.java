package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {
    private InputValidator inputValidator = new InputValidator();

    @DisplayName("자동차 이름 검증")
    @Nested
    class ValidateCarNames {
        @Test
        @DisplayName("정상동작")
        void good_case() {
            //given
            InputValidator inputValidator = new InputValidator();

            //when
            String goodCarNamesInput = "카,붕붕카,타요버스,시내버스,토마스버스,'";

            //then
            assertDoesNotThrow(() -> {
                inputValidator.validateCarNames(goodCarNamesInput);
            });
        }

        @ParameterizedTest
        @CsvSource(value = {"'붕붕카,타요버스,'", "'붕붕카,'", "',붕붕카'", "'붕붕카,,타요버스'"})
        @DisplayName("쉼표구분 예외")
        void 쉼표구분_예외_테스트(String input) {
            //given
            InputValidator inputValidator = new InputValidator();

            //then
            assertThatThrownBy(() -> inputValidator.validateCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름의 길이는 1이상 5이하여야 합니다");
        }

        @ParameterizedTest
        @CsvSource(value = {"'붕붕카,붕붕카를타는토마스'", "'붕붕카를타는토마스,타요버스'", "'붕붕카, "})
        @DisplayName("길이 예외")
        void 길이_예외_테스트(String input) {
            //given
            InputValidator inputValidator = new InputValidator();

            //then
            assertThatThrownBy(() -> inputValidator.validateCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름의 길이는 1이상 5이하여야 합니다");
        }

        @ParameterizedTest
        @CsvSource(value = {"'붕붕카,붕붕카'", "'타요버스, 타요버스'", "'타요버스 ,타요버스'", "'타요버스, 타요버스 '"})
        @DisplayName("중복 예외")
        void 중복_예외_테스트(String input) {
            //given
            InputValidator inputValidator = new InputValidator();

            //then
            assertThatThrownBy(() -> inputValidator.validateCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 중복되면 안됩니다");
        }

        @ParameterizedTest
        @CsvSource(value = {"붕붕카", "타요버스"})
        @DisplayName("개수 예외")
        void 개수_예외_테스트(String input) {
            //given
            InputValidator inputValidator = new InputValidator();

            //then
            assertThatThrownBy(() -> inputValidator.validateCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 2개 이상 입력되어야 합니다");
        }
    }

    @DisplayName("이동 횟수 검증")
    @Nested
    class ValidateMoveCount {
        @Test
        @DisplayName("정상 동작")
        void good_case() {
            //when
            String goodMoveCountInput = "3";

            //then
            assertDoesNotThrow(() -> {
                inputValidator.validateMoveCount(goodMoveCountInput);
            });
        }

        @ParameterizedTest
        @CsvSource(value = {"-3", "-1", "ㅇ", "#", "c"})
        @DisplayName("자연수가 아닐 때 예외 발생")
        void 자연수_아닐때_예외_발생(String input) {
            assertThatThrownBy(() -> inputValidator.validateMoveCount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("이동횟수는 자연수여야합니다.");
        }

        @ParameterizedTest
        @CsvSource(value = {"0","00","000"})
        @DisplayName("0일 때 예외 발생")
        void zero_예외_발생(String input) {
            assertThatThrownBy(() -> inputValidator.validateMoveCount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("이동횟수는 0이어서는 안됩니다.");
        }

        @ParameterizedTest
        @CsvSource(value = {"1000000000","20000000000000","1000000001"})
        @DisplayName("자릿수 초과 예외 발생")
        void 자릿수_초과_예외_발생(String input) {
            assertThatThrownBy(() -> inputValidator.validateMoveCount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("이동 횟수는 아홉 자릿수 이내여야 합니다.");
        }
    }
}