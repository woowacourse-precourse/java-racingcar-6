package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.enums.ExceptionMessage;
import racingcar.util.ValidationUtils;

public class ValidationTest {

    @Nested
    @DisplayName("자동차 이름 입력 테스트")
    class CarNameValidationTest {
        @Test
        void 입력_길이가_10000자_이상일_때_예외_발생() {
            String input = String.join(",", "가".repeat(5001), "나".repeat(5000));
            assertThatThrownBy(() -> ValidationUtils.validateCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.TOO_LONG_INPUT.getMessage());
        }

        @Test
        void 이름이_5자를_넘을_때_예외_발생() {
            String input = "제임스고슬링,귀도반로섬";
            assertThatThrownBy(() -> ValidationUtils.validateCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.SHOULD_BE_FIVE_LETTERS_OR_BELOW.getMessage());
        }

        @Test
        void 이름이_하나일_때_예외_발생() {
            String input = "빌게이츠";
            assertThatThrownBy(() -> ValidationUtils.validateCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.SHOULD_INPUT_MORE_THAN_ONE_NAME.getMessage());
        }

        @Test
        void 이름이_빈_값일_때_예외_발생() {
            String input = "";
            assertThatThrownBy(() -> ValidationUtils.validateCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NAME_CANNOT_BE_BLANK.getMessage());
        }

        @Test
        void 이름이_중복될_때_예외_발생() {
            String input = "poby,poby";
            assertThatThrownBy(() -> ValidationUtils.validateCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.SHOULD_HAVE_UNIQUE_NAMES.getMessage());
        }
    }

    @Nested
    @DisplayName("시도 횟수 입력 테스트")
    class TrialCountValidationTest {
        @Test
        void 입력_값이_문자일_때_예외_발생() {
            String input = "가나";
            assertThatThrownBy(() -> ValidationUtils.validateTrialCount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.SHOULD_INPUT_ONLY_NUMBER.getMessage());
        }

        @Test
        void 입력_값이_빈_값일_때_예외_발생() {
            String input = " ";
            assertThatThrownBy(() -> ValidationUtils.validateTrialCount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.SHOULD_INPUT_ONLY_NUMBER.getMessage());
        }
    }
}
