package racingcar;

import java.util.List;
import java.util.Optional;
import racingcar.dto.output.CarInfo;
import racingcar.dto.output.WinnerInfo;

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

    public static WinnerInfo toWinnerInfo(List<String> names) {
        return new WinnerInfo(names);
    }

    public Optional<String> getWinnerName(int winnerScore) {
        if (this.moveCount == winnerScore) {
            return Optional.of(name);
        }
        return Optional.empty();
    }

    public int updateMax(int currentMaxMoveCount) {
        return Math.max(this.moveCount, currentMaxMoveCount);
    }
}
