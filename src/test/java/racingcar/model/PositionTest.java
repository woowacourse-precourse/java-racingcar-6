package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class PositionTest {

    @Test
    void 다음_위치로_이동한다() {
        // given
        Position position = Position.createDefault();

        // when
        position.moveToNext();

        // then
        assertThat(position.getCurrentSpace()).isEqualTo(1);
    }

    @Test
    void 현재_위치를_반환한다() {
        // given
        Position position = Position.createDefault();

        // when
        int currentSpace = position.getCurrentSpace();

        // then
        assertThat(currentSpace).isEqualTo(0);
    }
}
