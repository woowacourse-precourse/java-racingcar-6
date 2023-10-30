package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("position 값 1 증가")
    void moveTest() {
        // given
        Position position = new Position();

        // when
        position.move();

        // then
        Assertions.assertThat(position.getLawPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("compareToSame 비교 결과 동일")
    void compareToSameTest() {
        // given
        Position position1 = new Position();
        Position position2 = new Position();

        // when
        int result = position1.compareTo(position2);

        // then
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("compareToSame 비교 결과 다름")
    void compareToDifferentTest() {
        // given
        Position position1 = new Position();
        Position position2 = new Position();

        // when
        position1.move();
        int result = position1.compareTo(position2);

        // then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("isSamePosition 비교 결과 같음")
    void isSamePositionSameTest() {
        // given
        Position position1 = new Position();
        Position position2 = new Position();

        // when
        boolean result = position1.isSamePosition(position2);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("isSamePosition 비교 결과 다름")
    void isSamePositionDifferentTest() {
        // given
        Position position1 = new Position();
        Position position2 = new Position();

        // when
        position1.move();
        boolean result = position1.isSamePosition(position2);

        // then
        Assertions.assertThat(result).isFalse();
    }
}
