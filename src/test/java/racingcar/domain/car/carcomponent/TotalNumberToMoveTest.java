package racingcar.domain.car.carcomponent;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalNumberToMoveTest {

    @Test
    @DisplayName("TotalNumberToMove 에서 자동차 전진 횟수를 저장하고, 전진 가능 여부를 확인한다_TotalNumberToMove 보다 적게 전진하면 True 반환.")
    void TotalNumberToMoveTest_CanMove() {
        TotalNumberToMove totalNumberToMove = new TotalNumberToMove(4);
        totalNumberToMove.moveCar();
        totalNumberToMove.moveCar();
        boolean moveOrNot = totalNumberToMove.canMoveCar();
        Assertions.assertThat(moveOrNot).isTrue();
    }

    @Test
    @DisplayName("TotalNumberToMove 에서 자동차 전진 횟수를 저장하고, 전진 가능 여부를 확인한다_TotalNumberToMove 와 같은 횟수 전진하면 True 반환.")
    void TotalNumberToMoveTest_CannotMove() {
        TotalNumberToMove totalNumberToMove = new TotalNumberToMove(2);
        totalNumberToMove.moveCar();
        totalNumberToMove.moveCar();
        boolean moveOrNot = totalNumberToMove.canMoveCar();
        Assertions.assertThat(moveOrNot).isFalse();
    }
}
