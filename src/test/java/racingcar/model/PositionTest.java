package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class PositionTest {

    @Test
    void 동일한_위치를_가진_Position_인스턴스는_동등하다() {
        // given
        Position result = Position.createDefault();
        Position expected = Position.createDefault();

        // when & then
        assertThat(result).isEqualTo(expected)
                .hasSameHashCodeAs(expected);
    }

    @Test
    void 현재_위치를_반환한다() {
        // given
        int expected = 1;
        Position position = Position.createDefault();
        position.move();

        // when
        int result = position.getPosition();

        // when & then
        assertThat(result).isEqualTo(expected);
    }
}
