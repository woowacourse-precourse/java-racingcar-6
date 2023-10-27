package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import racingcar.model.Position;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class PositionTest {

    @Test
    void 특정_인덱스의_위치가_이미_존재한다면_존재하는_객체를_반환한다() {
        // given
        Position position = Position.createWith(0);

        // when
        Position newInstance = Position.createWith(0);

        // then
        assertThat(position).isSameAs(newInstance);
    }

    @Test
    void 현재_위치를_입력_받으면_다음_위치를_반환한다() {
        // given
        createPositionTo(5);
        Position position = Position.createWith(1);

        // when
        Position nextPosition = position.getNextPosition();

        // then
        assertThat(nextPosition).isEqualTo(Position.createWith(2));
    }

    private void createPositionTo(int index) {
        IntStream.rangeClosed(0, index)
                .forEach(Position::createWith);
    }
}
