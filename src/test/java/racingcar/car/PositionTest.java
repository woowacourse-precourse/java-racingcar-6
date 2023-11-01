package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    @Test
    void 포지션을_생성한다() {
        // given
        Position position = new Position(0);

        // then
        Assertions.assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    void 포지션이_전진한다() {
        // given
        Position position = new Position(0);

        // when
        position.move();

        // then
        Assertions.assertThat(position).isEqualTo(new Position(1));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,-", "3,---"})
    void 포지션만큼_기호로_표기한다(int positionNumber, String expected) {
        // given
        Position position = new Position(positionNumber);

        // when
        String positionText = position.getPositionText();

        // then
        Assertions.assertThat(positionText).isEqualTo(expected);
    }
}
