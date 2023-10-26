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

    @Test
    @DisplayName("전진 신호(true) 가 파라미터로 주어지면 moveCount 를 1 증가시킨 객체를 반환한다.")
    void carMoveTest_true() {
        CarMoveCount carMoveCount = new CarMoveCount(0);
        CarMoveCount newCarMoveCount = carMoveCount.countMove(true);
        assertThat(newCarMoveCount.getMoveCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("멈춤 신호(false) 가 파라미터로 주어지면 동일한 moveCount 인 객체를 반환한다. ")
    void carMoveTest_false() {
        CarMoveCount carMoveCount = new CarMoveCount(0);
        CarMoveCount newCarMoveCount = carMoveCount.countMove(false);
        assertThat(newCarMoveCount.getMoveCount()).isEqualTo(0);
    }
}
