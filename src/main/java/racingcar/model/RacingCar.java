package racingcar.model;

import racingcar.view.RacingGameMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {
    private final int MOVE_LIMITS = 3;
    private String racingCarName;
    private List<Boolean> racingCarMove;
    private int moveCount;

    public RacingCar(final String carName) {
        this.racingCarName = carName;
        this.racingCarMove= new ArrayList<>();
        this.moveCount = 0;
    }

    public void move(final int movableNumber) {
        if (movableNumber > MOVE_LIMITS) {
            this.racingCarMove.add(true);
            moveCount += 1;
        }
    }

    public String getRaceResult() {
        final String gameResult = this.racingCarMove.stream()
                .filter(move -> move)
                .map(move -> RacingGameMessage.MOVE.getMoveMessage())
                .collect(Collectors.joining());

        return gameResult;
    }

    public String getRacingCarName() {
        return this.racingCarName;
    }

    public List<Boolean> getRacingCarMove() {
        return this.racingCarMove;
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
