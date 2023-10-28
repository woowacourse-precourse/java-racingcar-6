package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarPositionTest {

    @Test
    void 자동차_위치를_초기화하면_0위치값을_갖는다() {
        CarPosition actualPosition = CarPosition.initialPosition();
        CarPosition expectedPosition = new CarPosition(0);

        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void 자동차_위치값은_음수를_가질_수_없다(int position) {
        assertThatThrownBy(() -> new CarPosition(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_위치가_전진하면_위치값이_증가한다() {
        CarPosition carPosition = CarPosition.initialPosition();
        CarPosition expectedPosition = new CarPosition(1);

        CarPosition actualCarPosition = carPosition.move();

        assertThat(actualCarPosition).isEqualTo(expectedPosition);
    }

    @Test
    void 자동차_위치값은_내부값으로_크기를_비교할_수_있다() {
        CarPosition carPosition = new CarPosition(1);
        CarPosition otherCarPosition = new CarPosition(2);
        int expectedCompareResult = -1;

        int actualCompareResult = carPosition.compareTo(otherCarPosition);

        assertThat(actualCompareResult).isEqualTo(expectedCompareResult);
    }

    @Test
    void 자동차_위치_값이_서로_같으면_같은_객체로_판단한다() {
        CarPosition actualCarPosition = new CarPosition(1);
        CarPosition expectedCarPosition = new CarPosition(1);

        assertThat(actualCarPosition).isEqualTo(expectedCarPosition);
    }
}
