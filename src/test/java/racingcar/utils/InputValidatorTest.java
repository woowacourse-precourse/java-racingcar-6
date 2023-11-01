package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 다섯_글자_넘는_경우() {
        assertInvalidCarNames(Arrays.asList("다섯자이상의이름"), "자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 중간에_다섯글자_넘는_경우() {
        assertInvalidCarNames(Arrays.asList("pobi", "다섯글자넘는이름", "jun"), "자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 컴마_연속_두개() {
        assertInvalidCarNames(Arrays.asList("pobi", "", "jun", "aa"),
            "자동차 이름은 null 또는 비어 있을 수 없습니다.");
    }

    @Test
    void NULL_테스트() {
        assertInvalidCarNames(Arrays.asList(null, "", "jun", "aa"),
            "자동차 이름은 null 또는 비어 있을 수 없습니다.");
    }

    @Test
    void 중복_이름이_들어오는_경우() {
        assertInvalidCarNames(Arrays.asList("a", "a", "b", "c"), "자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 빈_문자열() {
        assertInvalidCarNames(Arrays.asList(""), "자동차 이름은 null 또는 비어 있을 수 없습니다.");
    }

    @Test
    void 컴마_빈칸_컴마() {
        assertInvalidCarNames(Arrays.asList("pobi", " ", "jun"), "자동차 이름은 null 또는 비어 있을 수 없습니다.");
    }

    @Test
    void 올바른_입력() {
        List<String> carNames = Arrays.asList("pobi", "jun", "aa");
        assertThatCode(() -> {
            InputValidator.validateCarNames(carNames);
        }).doesNotThrowAnyException();
    }

    @Test
    void 시도횟수_0이하_인_경우() {
        assertInvalidAttemptCount(-1, "시도 횟수는 0보다 커야 합니다.");
    }


    private void assertInvalidCarNames(List<String> carNames, String expectedErrorMessage) {
        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(expectedErrorMessage);
    }

    private void assertInvalidAttemptCount(int attemptCount, String expectedErrorMessage) {
        assertThatThrownBy(() -> InputValidator.validateAttemptCount(attemptCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(expectedErrorMessage);
    }

}