package racingcar.domain;

import static racingcar.domain.RacingConfig.FORWARD_NUMBER;

import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private final String name;
    private int randomNumber;
    private int round;
    private final int finalRound;
    private int moveResult;
    private List<String> moveHistory;

    public Car(String name, int randomNumber, int round, int finalRound, int moveResult, List<String> moveHistory) {
        this.name = name;
        this.randomNumber = randomNumber;
        this.round = round;
        this.finalRound = finalRound;
        this.moveResult = moveResult;
        this.moveHistory = moveHistory;
    }

    public String getName() {
        return name;
    }
    public int getRound() {
        return round;
    }
    public int getFinalRound() {
        return finalRound;
    }
    public int getMoveResult() {
        return moveResult;
    }

    public List<String> getMoveHistoryWithoutSpace() {
        return this.moveHistory.stream()
                .map(history -> history.replaceAll("\\s+", ""))
                .collect(Collectors.toList());
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void move() {
        if (this.randomNumber >= FORWARD_NUMBER) {
            moveForward();
            increaseRound();
            return;
        }
        stayInplace();
        increaseRound();
    }

    private void moveForward() {
        this.moveResult+= 1;
        this.moveHistory.add("-");
    }

    private void stayInplace() {
        this.moveHistory.add(" ");
    }

    private void increaseRound() {
        this.round += 1;
    }
}
