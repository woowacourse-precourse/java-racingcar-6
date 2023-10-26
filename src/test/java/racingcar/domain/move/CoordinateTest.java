package racingcar.domain.move;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class CoordinateTest {
    @DisplayName("Coordinate는 0 이상의 값을 가져야 한다")
    @Test
    void createCoordinateSuccess() {
        // given
        int input1 = 0;
        int input2 = 10;

        // when
        final Coordinate coordinate1 = new Coordinate(input1);
        final Coordinate coordinate2 = new Coordinate(input2);

        // then
        assertThat(coordinate1.getCoordinate()).isEqualTo(input1);
        assertThat(coordinate2.getCoordinate()).isEqualTo(input2);
    }

    @DisplayName("Coordinate를 음수로 생성 시, 예외를 던진다")
    @Test
    void createCoordinateFailure() {
        // given
        int input1 = -1;

        // when
        // then
        assertThatThrownBy(() ->
                new Coordinate(input1))
                .isInstanceOf(InvalidCoordinateException.class)
                .hasMessage(InvalidCoordinateException.INVALID_COORDINATE_EXCEPTION);
    }
}