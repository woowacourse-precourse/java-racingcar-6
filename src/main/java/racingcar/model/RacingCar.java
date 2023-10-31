package racingcar.model;

import racingcar.view.RacingGameMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCar {
    private final int MOVE_LIMITS = 3;
    private final String racingCarName;
    private int moveCount;

    public RacingCar(final String carName) {
        this.racingCarName = carName;
        this.moveCount = 0;
    }

    public void move(final int movableNumber) {
        if (movableNumber > MOVE_LIMITS) {
            moveCount += 1;
        }
    }

    public String getRaceResult() {
        StringBuilder raceResult = new StringBuilder();
        IntStream.range(0, moveCount).forEach(i -> raceResult.append(RacingGameMessage.MOVE.getMoveMessage()));

        return raceResult.toString();
    }

    public String getRacingCarName() {
        return this.racingCarName;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    @Override
    public String toString() {
        final String gameResult = getRaceResult();

        return this.racingCarName + " : " + gameResult + "\n";
    }
}
