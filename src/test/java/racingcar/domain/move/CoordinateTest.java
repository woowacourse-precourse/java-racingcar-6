package racingcar.domain.move;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.coordinate.boxed.Coordinate;
import racingcar.exception.coordinate.InvalidCoordinateException;

final class CoordinateTest {
    @DisplayName("Coordinate는 0 이상의 값을 가져야 한다")
    @Test
    void Coordinate_withPositive_shouldCreateCoordinate() {
        // given
        int input1 = 0;
        int input2 = 10;

        // when
        final Coordinate coordinate1 = new Coordinate(input1);
        final Coordinate coordinate2 = new Coordinate(input2);

        // then
        assertThat(coordinate1.value()).isEqualTo(input1);
        assertThat(coordinate2.value()).isEqualTo(input2);
    }

    @DisplayName("Coordinate를 음수로 생성 시, 예외를 던진다")
    @Test
    void Coordinate_withNegative_shouldThrowException() {
        // given
        int input1 = -1;

        // when
        // then
        assertThatThrownBy(() ->
                new Coordinate(input1))
                .isInstanceOf(InvalidCoordinateException.class)
                .hasMessage(InvalidCoordinateException.INVALID_COORDINATE_EXCEPTION);
    }

    @DisplayName("coordinate 간의 뺄셈 연산")
    @Test
    void subtract_betweenTwoCoordinate_shouldReturnIntValue() {
        // given
        final Coordinate coordinate1 = new Coordinate(1);
        final Coordinate coordinate2 = new Coordinate(2);

        // when
        final int result1 = coordinate1.subtract(coordinate2);
        final int result2 = coordinate2.subtract(coordinate1);

        // then
        assertThat(result1).isEqualTo(-1);
        assertThat(result2).isEqualTo(1);
    }

    @DisplayName("서로 같거나 다른 coordinate 간의 비교가 가능하다")
    @Test
    void equals_betweenTwoCoordinate_shouldReturnBooleanValue() {
        // given
        final Coordinate coordinate1 = new Coordinate(1);
        final Coordinate coordinate2 = new Coordinate(1);
        final Coordinate coordinate3 = new Coordinate(2);

        // when
        final boolean result1 = coordinate1.equals(coordinate2);
        final boolean result2 = coordinate1.equals(coordinate3);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }

    @DisplayName("increase를 호출할 때마다 Coordinate를 1씩 증가시킬 수 있다")
    @Test
    void increase_withCoordinate_shouldIncreaseCoordinateOne() {
        // given
        final int input1 = 1;
        final Coordinate coordinate1 = new Coordinate(input1);

        // when
        coordinate1.increase();

        // then
        assertThat(coordinate1.value()).isEqualTo(input1 + 1);

    }


    @DisplayName("Coordinate.zero는 value가 0인 객체 생성한다.")
    @Test
    void zero__shouldCreateCoordinateHasZeroValue() {
        // given
        final Coordinate coordinate1 = Coordinate.zero();

        // when
        // then
        assertThat(coordinate1.value()).isZero();
    }
}