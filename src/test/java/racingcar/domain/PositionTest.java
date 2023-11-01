package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.CarConstant.CAR_ONE_STEP;
import static racingcar.constant.CarConstant.CAR_START_POSITION;
import static racingcar.exception.ErrorMessage.NEGATIVE_POSITION;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class PositionTest {

    @DisplayName(CAR_START_POSITION + "이상이면 생성할 수 있다.")
    @ParameterizedTest
    @MethodSource
    void newPosition(int value) {
        // given
        Position position = new Position(value);

        assertThat(position.getValue()).isEqualTo(value);
    }

    static Stream<Integer> newPosition() {
        return Stream.iterate(CAR_START_POSITION, i -> i + 1)
                .limit(10);
    }

    @DisplayName(CAR_START_POSITION + "미만은 생성할 수 없다.")
    @ParameterizedTest
    @MethodSource
    void newPositionException(int value) {

        assertThatThrownBy(() -> new Position(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_POSITION.getMessage());
    }

    static Stream<Integer> newPositionException() {
        return Stream.iterate(CAR_START_POSITION, i -> i - 1)
                .skip(1)
                .limit(10);
    }

    @DisplayName("포지션은 " + CAR_ONE_STEP +"씩 증가한다.")
    @ParameterizedTest
    @CsvSource({"0,5", "1,10", "2,100", "10,30"})
    void plus(String startString, String countString) {
        // given
        int start = Integer.parseInt(startString);
        int count = Integer.parseInt(countString);

        Position position = new Position(start);

        // when
        for (int i = 0; i < count; i++) {
            position.plus();
        }

        // then
        assertThat(position).isEqualTo(new Position(start + count * CAR_ONE_STEP));
    }

    @DisplayName("포지션을 대소비교할 수 있다.")
    @ParameterizedTest
    @CsvSource({"0,5", "1,10", "2,100", "10,30"})
    void compareTo(String smallString, String largeString) {
        // given
        int small = Integer.parseInt(smallString);
        int large = Integer.parseInt(largeString);
        int smallSame = Integer.parseInt(smallString);

        // when
        Position smallPosition = new Position(small);
        Position largePosition = new Position(large);
        Position smallPositionSame = new Position(smallSame);

        // then
        assertThat(smallPosition.compareTo(largePosition) < 0).isTrue();
        assertThat(largePosition.compareTo(smallPosition) > 0).isTrue();
        assertThat(smallPositionSame.compareTo(smallPosition) == 0).isTrue();
    }


}