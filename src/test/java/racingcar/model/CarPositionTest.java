package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarPositionTest {

    @Test
    void 자동차_위치를_초기화하면_초기_위치값을_갖는다() {
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
    void 두_자동차_위치_값을_비교할때_첫번째_위치가_작다면_음수를_반환한다() {
        CarPosition smallerPosition = new CarPosition(1);
        CarPosition largerPosition = new CarPosition(2);

        int result = smallerPosition.compareTo(largerPosition);

        assertThat(result).isNegative();
    }

    @Test
    void 두_자동차_위치_값을_비교할때_서로_같다면_0을_반환한다() {
        CarPosition firstPosition = new CarPosition(1);
        CarPosition secondPosition = new CarPosition(1);

        int result = firstPosition.compareTo(secondPosition);

        assertThat(result).isZero();
    }

    @Test
    void 두_자동차_위치_값을_비교할때_첫번째_위치가_큰다면_양수를_반환한다() {
        CarPosition largerPosition = new CarPosition(2);
        CarPosition smallerPosition = new CarPosition(1);

        int result = largerPosition.compareTo(smallerPosition);

        assertThat(result).isPositive();
    }

    @Test
    void 자동차_위치_값이_서로_같으면_같은_객체로_판단한다() {
        CarPosition actualCarPosition = new CarPosition(1);
        CarPosition expectedCarPosition = new CarPosition(1);

        assertThat(actualCarPosition).isEqualTo(expectedCarPosition);
    }

    @Test
    void 자동차_위치_값이_서로_다르면_다른_객체로_판단한다() {
        CarPosition actualCarPosition = new CarPosition(1);
        CarPosition expectedCarPosition = new CarPosition(2);

        assertThat(actualCarPosition).isNotEqualTo(expectedCarPosition);
    }

    @Test
    void 자동차_위치_값이_서로_같으면_동일한_hashcode를_가진다() {
        CarPosition actualCarPosition = new CarPosition(1);
        CarPosition expectedCarPosition = new CarPosition(1);

        assertThat(actualCarPosition.hashCode()).isEqualTo(expectedCarPosition.hashCode());
    }
}
