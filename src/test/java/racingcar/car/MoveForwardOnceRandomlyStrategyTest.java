package racingcar.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.CarMovementStrategy;
import racingcar.domain.strategy.MoveForwardOnceRandomlyStrategy;

public class MoveForwardOnceRandomlyStrategyTest {

    @Test
    @DisplayName("MoveForwardOnceRandomlyStrategy 전략이 0 또는 1을 반환한다.")
    void moveForwardOnceRandomlyStrategyTest() {
        // given
        CarMovementStrategy carMovementStrategy = new MoveForwardOnceRandomlyStrategy();

        // when
        int incrementValue = carMovementStrategy.getIncrementValue();
        boolean isZero = incrementValue == 0;
        boolean isOne = incrementValue == 1;

        // then
        Assertions.assertTrue(isZero || isOne);
    }

}
