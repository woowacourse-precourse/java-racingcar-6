package racingcar.model.data;

import racingcar.model.record.MoveCount;

public class Race {
    private Cars cars;
    private MoveCount moveCount;

    public Race(Cars cars, MoveCount moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public void startMove() {}
    public void determineWinners() {}
}
