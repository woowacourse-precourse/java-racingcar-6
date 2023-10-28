package racingcar;

import java.util.List;
import racingcar.dto.output.CarInfo;

public class Car {
    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void increaseMoveCount() {
        moveCount++;
    }

    public CarInfo toCarInfo() {
        return new CarInfo(name, moveCount);
    }

    public void addWinnerToList(int winnerScore, List<String> winnerNames) {
        if (this.moveCount == winnerScore) {
            winnerNames.add(this.name);
        }
    }

    public int updateMax(int currentMaxMoveCount) {
        return Math.max(this.moveCount, currentMaxMoveCount);
    }
}
