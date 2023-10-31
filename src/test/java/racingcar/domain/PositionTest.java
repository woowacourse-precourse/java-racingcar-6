package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PositionTest {

    @Test
    void 자동차_위치가_0보다_작으면_예외가_발생한다() {
        // given
        int position = -1;

        // when, then
        assertThatThrownBy(() -> new Position(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void 자동차_위치가_0보다_크거나_같으면_예외가_발생하지_않는다(int position) {
        // when, then
        assertThatNoException().isThrownBy(() -> new Position(position));
    }

    @Test
    void position_객체의_값이_같다면_동등성을_보장한다() {
        // given
        Position position1 = new Position(1);
        Position position2 = new Position(1);

        // when, then
        assertAll(
                () -> assertThat(position1).isEqualTo(position2),
                () -> assertThat(position1).hasSameHashCodeAs(position2)
        );
    }

    @Test
    void position_객체의_값이_다르다면_동등성을_보장하지_않는다() {
        // given
        Position position1 = new Position(1);
        Position position2 = new Position(2);

        // when, then
        assertAll(
                () -> assertThat(position1).isNotEqualTo(position2),
                () -> assertThat(position1).doesNotHaveSameHashCodeAs(position2)
        );
    }

}