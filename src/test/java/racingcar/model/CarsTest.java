package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorCode;
import racingcar.model.intgenerator.CustomIntGenerator;

public class CarsTest {
    private static final int MOVING_CONDITION = 4;
    private static final int NON_MOVING_CONDITION = 3;
    private static final int MOVING_RESULT = 1;
    private static final int NON_MOVING_RESULT = 0;

    @Test
    void 자동차들_생성시_이름이_중복되면_예외가_발생한다() {
        List<String> names = List.of("pobi", "pobi");

        assertThatThrownBy(() -> Cars.fromNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATE_NAME.getMessage());
    }

    @Test
    void 자동차들_이동_시_고른_숫자가_기준점을_넘은_자동차들만_전진횟수가_증가한다() {
        Car movingCar = new Car("pobi", new CustomIntGenerator(MOVING_CONDITION));
        Car nonMovingCar = new Car("woni", new CustomIntGenerator(NON_MOVING_CONDITION));
        Cars cars = Cars.fromCars(List.of(movingCar, nonMovingCar));

        cars.move();

        assertCarHasMovedForward(movingCar, MOVING_RESULT);
        assertCarHasMovedForward(nonMovingCar, NON_MOVING_RESULT);
    }

    private void assertCarHasMovedForward(Car car, int expectedForwardCount) {
        CarState state = car.summarizeState();
        assertThat(state.forwardCount()).isEqualTo(expectedForwardCount);
    }
}
