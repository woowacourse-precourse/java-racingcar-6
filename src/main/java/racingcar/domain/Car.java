package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    private final String name;
    private final int randomNumber;
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

    public int getRandomNumber() {
        return randomNumber;
    }
    public int getRound() {
        return round;
    }
    public int getFinalRound() {
        return finalRound;
    }
    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void increaseMoveResult() {
        this.moveResult += 1;
        this.moveHistory.add("-");
    }
    public void increaseRound() {
        this.round += 1;
    }

}
