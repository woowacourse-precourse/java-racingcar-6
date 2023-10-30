package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import racingcar.domain.RaceCount;
import racingcar.util.InputValidator;

public class RaceCountTest {

    // 테스트 시 from과 구체적인 validate 메소드 중 어떤 걸 테스트하는 게 맞을까?
    @Test
    void 시도횟수가_숫자가_아니면_예외를_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateRaceCount("a1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수가_숫자면_예외를_발생시키지_않는다() {
        assertDoesNotThrow(() -> InputValidator.validateRaceCount("11"));
    }

    @ParameterizedTest
    @EmptySource
    void 시도횟수가_공백이면_예외를_발생한다(String empty) {
        assertThatThrownBy(() -> InputValidator.validateRaceCount(empty))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수가_0이면_예외를_발생한다() {
        assertThatThrownBy(() -> RaceCount.from(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
