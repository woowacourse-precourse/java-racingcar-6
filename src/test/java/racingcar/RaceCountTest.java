package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

public class RaceCountTest {

    @Test
    void 시도횟수가_숫자가_아니면_예외를_발생한다() {
        RaceCount raceCount = new RaceCount();
        assertThatThrownBy(() -> raceCount.validateNumber("a1"))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 시도횟수가_숫자면_예외를_발생시키지_않는다() {
        RaceCount raceCount = new RaceCount();
        assertDoesNotThrow(() -> raceCount.validateNumber("11"));
    }

    @ParameterizedTest
    @EmptySource
    void 시도횟수가_공백이면_예외를_발생한다(String empty) {
        RaceCount raceCount = new RaceCount();
        assertThatThrownBy(() -> raceCount.validateNumber(empty))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 시도횟수가_0이면_예외를_발생한다() {
        RaceCount raceCount = new RaceCount();
        assertThatThrownBy(() -> raceCount.validateRange("0"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
