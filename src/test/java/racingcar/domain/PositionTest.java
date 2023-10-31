package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.CarConstant.CAR_START_POSITION;
import static racingcar.exception.ErrorMessage.NEGATIVE_POSITION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @DisplayName(CAR_START_POSITION + "이상이면 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 10, 100, 1000, 10000, 999999})
    void newPosition(int value) {
        // given
        Position position = new Position(value);

        assertThat(position.getValue()).isEqualTo(value);
    }

    @DisplayName(CAR_START_POSITION + "미만은 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -10, -100, -1000, -10000, -999999})
    void newPositionException(int value) {

        assertThatThrownBy(() -> new Position(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_POSITION.getMessage());
    }

    @DisplayName("포지션은 1씩 증가한다.")
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
        assertThat(position).isEqualTo(new Position(start + count));
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