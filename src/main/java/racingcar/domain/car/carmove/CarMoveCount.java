package racingcar.domain.car.carmove;

public record CarMoveCount(int moveCount) {

    CarMoveCount raiseMoveCount() {
        return new CarMoveCount(moveCount + 1);
    }
}
