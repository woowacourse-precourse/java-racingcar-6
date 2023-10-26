package racingcar.domain.car.carcomponent;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarMoveCountTest {

    @Test
    @DisplayName("CarMoveCount 객체에서 getMoveCount 로 값을 받아올 수 있다.")
    void carMoveCountGetTest() {
        CarMoveCount carMoveCount = new CarMoveCount(2);
        assertThat(carMoveCount.getMoveCount()).isEqualTo(2);
    }
}
