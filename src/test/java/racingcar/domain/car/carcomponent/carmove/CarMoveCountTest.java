package racingcar.domain.car.carcomponent.carmove;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarMoveCountTest {

    @Test
    @DisplayName("CarMoveCount 객체에서 getMoveCount 로 값을 받아올 수 있다.")
    void carMoveCountGetTest() {
        CarMoveCount carMoveCount = new CarMoveCount(2);
        assertThat(carMoveCount.moveCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("raiseMoveCount 메서드는 moveCount 를 1 증가시킨 객체를 반환한다.")
    void carMoveTest_true() {
        CarMoveCount carMoveCount = new CarMoveCount(0);
        CarMoveCount newCarMoveCount = carMoveCount.raiseMoveCount();
        assertThat(newCarMoveCount.moveCount()).isEqualTo(1);
    }
}
