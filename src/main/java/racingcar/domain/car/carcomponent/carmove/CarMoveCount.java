package racingcar.domain.car.carcomponent.carmove;

public record CarMoveCount(int moveCount) {

    public CarMoveCount countMove(boolean moveOrNot) {
        if (moveOrNot) {
            return new CarMoveCount(moveCount + 1);
        }
        return this;
    }
}
