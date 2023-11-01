package racingcar.domain.car.carmove;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarMoveReaderTest {

    @Test
    @DisplayName("CarMoveReader 에서 자동차 전진 횟수를 저장하고, 전진 가능 여부를 확인한다_totalNumberMove 보다 적게 전진하면 True 반환.")
    void CarMoveReaderTest_CanMove() {
        CarMoveReader carMoveReader = new CarMoveReader(4);
        carMoveReader.raiseMoveCount();
        carMoveReader.raiseMoveCount();
        boolean moveOrNot = carMoveReader.canMoveCar();
        Assertions.assertThat(moveOrNot).isTrue();
    }

    @Test
    @DisplayName("CarMoveReader 에서 자동차 전진 횟수를 저장하고, 전진 가능 여부를 확인한다_totalNumberMove 와 같은 횟수 전진하면 False 반환.")
    void CarMoveReaderTest_CannotMove() {
        CarMoveReader carMoveReader = new CarMoveReader(2);
        carMoveReader.raiseMoveCount();
        carMoveReader.raiseMoveCount();
        boolean moveOrNot = carMoveReader.canMoveCar();
        Assertions.assertThat(moveOrNot).isFalse();
    }
}
