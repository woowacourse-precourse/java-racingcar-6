package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(ReplaceUnderscores.class)
class CarNamesTest {

    @Test
    void 자동차_개수가_2개_미만일_경우_예외가_발생한다() {
        // given
        String carNames = "자동차1";

        // when, then
        assertThatThrownBy(() -> new CarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_개수가_2개_이상일_경우_예외가_발생하지_않는다() {
        // given
        String carNames = "자동차1,자동차2";

        // when, then
        assertThatNoException().isThrownBy(() -> new CarNames(carNames));
    }

    @Test
    void 중복된_자동차_이름이_존재할_경우_예외를_발생한다() {
        // given
        String carNames = "자동차,자동차";

        // when, then
        assertThatThrownBy(() -> new CarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_자동차_이름이_존재하지_않을_경우_예외를_발생하지_않는다() {
        // given
        String carNames = "자동차1,자동차2";

        // when, then
        assertThatNoException().isThrownBy(() -> new CarNames(carNames));
    }

}