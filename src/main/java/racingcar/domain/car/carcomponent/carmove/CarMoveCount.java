package racingcar.domain.car.carcomponent.carmove;

public record CarMoveCount(int moveCount) {

    CarMoveCount raiseMoveCount() {
        return new CarMoveCount(moveCount + 1);
    }
}
