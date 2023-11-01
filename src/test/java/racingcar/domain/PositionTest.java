package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("위치 값 1 증가")
    void Expect_IncreasePositionBy1() {
        // given
        Position position = new Position();

        // when
        position.move();

        // then
        Assertions.assertThat(position.getLawPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("두 위치 값이 같을 때 비교 결과 0")
    void When_TwoPositionAreSame_Expect_0() {
        // given
        Position position1 = new Position();
        Position position2 = new Position();

        // when
        int result = position1.compareTo(position2);

        // then
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("첫 번째 위치 값이 더 클 때 비교 결과 양수")
    void When_FirstPositionIsLarger_Expect_Positive() {
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
    @DisplayName("첫 번째 위치 값이 더 작을 때 비교 결과 음수")
    void When_FirstPositionIsSmaller_Expect_Negative() {
        // given
        Position position1 = new Position();
        Position position2 = new Position();

        // when
        position2.move();
        int result = position1.compareTo(position2);

        // then
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("두 위치 값이 같을 때 비교 결과 true")
    void When_TwoPositionAreSame_Expect_True() {
        // given
        Position position1 = new Position();
        Position position2 = new Position();

        // when
        boolean result = position1.isSamePosition(position2);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("두 위치 값이 다를 때 비교 결과 false")
    void When_TwoPositionAreDifferent_Expect_False() {
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
