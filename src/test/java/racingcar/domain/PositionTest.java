package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PositionTest {

    @Test
    @DisplayName("정상적인 위치값을 가진 Position 객체 생성 테스트")
    void createPositionWithValidValue() {
        // given
        int expectedValue = 5;

        // when
        Position position = new Position(expectedValue);

        // then
        assertThat(position.value()).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("0 미만의 위치값을 입력했을 때 예외 발생 테스트")
    void createPositionWithInvalidValue() {
        // given
        int invalidValue = -1;

        // when & then
        assertThatThrownBy(() -> new Position(invalidValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 위치는 0 이상이어야 합니다.");
    }

    @Test
    @DisplayName("move 메서드 호출 시 Position 값이 1 증가하는지 테스트")
    void movePosition() {
        // given
        Position position = new Position(3);

        // when
        Position movedPosition = position.move();

        // then
        assertThat(movedPosition).isEqualTo(new Position(4));
    }

    @Test
    @DisplayName("동일한 value 값을 가진 Position 객체끼리 비교 시 equals와 hashCode 테스트")
    void equalsAndHashCode() {
        // given
        Position position1 = new Position(5);
        Position position2 = new Position(5);

        // then
        assertAll(
                () -> assertThat(position1).isEqualTo(position2),
                () -> assertThat(position1).hasSameHashCodeAs(position2)
        );
    }

    @Test
    @DisplayName("compareTo 메서드를 사용한 Position 객체 비교 테스트")
    void compareToTest() {
        // given
        Position position1 = new Position(3);
        Position position2 = new Position(5);

        // when & then
        assertAll(
                () -> assertThat(position1.compareTo(position2)).isNegative(),
                () -> assertThat(position2.compareTo(position1)).isPositive(),
                () -> assertThat(position1.compareTo(new Position(3))).isZero()
        );
    }
}
