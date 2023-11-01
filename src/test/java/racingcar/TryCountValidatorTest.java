package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validator.TryCountValidator;

public class TryCountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"yoon", "+", "-", "one", "two"})
    void 시도_횟수가_숫자가_아닌_문자열인_경우_예외처리_발생_테스트(String tryCount) {
        Assertions.assertThatThrownBy(() -> TryCountValidator.validateString(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자만 가능합니다. 애플리케이션을 종료합니다.");
    }

    @Test
    void 시도_횟수가_빈_값인_경우_예외처리_발생_테스트() {
        //given
        String emptyTryCount = "";

        //when & then
        Assertions.assertThatThrownBy(() -> TryCountValidator.validateEmpty(emptyTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수가 빈 값입니다. 애플리케이션을 종료합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   ", "    ", "     "})
    void 시도_횟수가_공백을_포함하는_경우_예외처리_발생_테스트(String tryCount) {
        Assertions.assertThatThrownBy(() -> TryCountValidator.validateTryCountIncludeEmpty(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 공백을 포함하고 있습니다. 애플리케이션을 종료합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3, -10000})
    void 시도_횟수가_양의_정수가_아닌_경우_예외처리_발생_테스트(int tryCount) {
        Assertions.assertThatThrownBy(() -> TryCountValidator.validateNatureNumber(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수가 양의 정수가 아닙니다. 애플리케이션을 종료합니다.");
    }
}
