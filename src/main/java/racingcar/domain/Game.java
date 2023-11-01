package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final int finalRaceCount;
    private int currentRaceCount;

    public Game(int finalRaceCount) {
        this.finalRaceCount = finalRaceCount;
    }

    public void setCurrentRaceCount() {
        currentRaceCount++;
    }

    public boolean isNotGameOver() {
        return finalRaceCount != currentRaceCount;
    }


}
