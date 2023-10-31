package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.utils.RandomNumberGenerator;

class RefereeTest {

    private static final int VALUE_FOR_MOVING_FORWARD = 5;
    private static final int VALUE_FOR_STOP = 2;

    @DisplayName("우승한 자동차의 수는 가장 많이 전진한 자동차의 수와 같다.")
    @Test
    void decideWinners_Success_IsResultSizeSameAsCarsCount() {
        // given
        List<Car> createdCars = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            createdCars.add(new Car("car" + i));
        }
        Cars cars = new Cars(createdCars);
        Referee referee = new Referee();

        // when, then
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                () -> {
                    cars.handleCarMovement(new RandomNumberGenerator());
                    cars.handleCarMovement(new RandomNumberGenerator());
                    List<Car> result = referee.decideWinners(cars);
                    Assertions.assertThat(result.size()).isEqualTo(2);
                },
                VALUE_FOR_STOP, VALUE_FOR_MOVING_FORWARD, VALUE_FOR_MOVING_FORWARD
        );
    }
}
