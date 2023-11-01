package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorCode;
import racingcar.model.intgenerator.CustomIntGenerator;

public class CarsTest {
    @Test
    void 자동차들_생성시_이름이_중복되면_예외가_발생한다() {
        List<String> names = List.of("pobi", "pobi");

        assertThatThrownBy(() -> Cars.fromNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATE_NAME.getMessage());
    }

    @Test
    void 자동차들_이동_시_고른_숫자가_기준점을_넘은_자동차들만_전진횟수가_증가한다() {
        Car movingCar = new Car("pobi", new CustomIntGenerator(6));
        Car nonMovingCar = new Car("woni", new CustomIntGenerator(1));
        Cars cars = Cars.fromCars(List.of(movingCar, nonMovingCar));

        cars.move();

        assertCarHasMovedForward(movingCar, 1);
        assertCarHasMovedForward(nonMovingCar, 0);
    }

    private void assertCarHasMovedForward(Car car, int expectedForwardCount) {
        CarState state = car.summarizeState();
        assertThat(state.forwardCount()).isEqualTo(expectedForwardCount);
    }
}
