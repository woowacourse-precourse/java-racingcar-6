package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RoundTest {

    @ParameterizedTest(name = "시도 횟수: {arguments}")
    @ValueSource(ints = {-1, 0})
    void 횟수가_1보다_작을_경우_예외를_발생한다(int round) {
        // when, then
        assertThatThrownBy(() -> new Round(round))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "시도 횟수: {arguments}")
    @ValueSource(ints = {1, 2, 5, 10, 100})
    void 횟수가_1보다_클_경우_예외를_발생하지_않는다(int round) {
        // when, then
        assertThatNoException().isThrownBy(() -> new Round(round));
    }

}