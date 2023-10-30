package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.exception.console_input.CanNotConvertToIntInputException;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class AttemptCountTest {

    @CsvSource({"0, true", "1, false", "2, false", "3, false", "4, false"})
    @ParameterizedTest
    void 시도_횟수가_0보다_작거나_같게_남으면_true를_반환한다(String attemptCount, boolean expected) {
        // given
        AttemptCount count = new AttemptCount(attemptCount);

        // when
        boolean result = count.isGameOver();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 시도_횟수를_1만큼_감소시킨다() {
        // given
        AttemptCount count = new AttemptCount("1");

        // when
        count.decrease();

        // then
        assertThat(count.isGameOver()).isTrue();
    }

    @Test
    void 문자열이_숫자로_변환_불가능하면_예외를_발생시킨다() {
        // given
        String attemptCount = "test";

        // when & then
        assertThatThrownBy(() -> new AttemptCount(attemptCount))
                .isInstanceOf(CanNotConvertToIntInputException.class);
    }
}
