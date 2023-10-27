package racingcar.domain.car.carcomponent.carmove;

import static racingcar.Constant.ONE;

public record CarMoveCount(int moveCount) {

    CarMoveCount raiseMoveCount() {
        return new CarMoveCount(moveCount + ONE);
    }
}
