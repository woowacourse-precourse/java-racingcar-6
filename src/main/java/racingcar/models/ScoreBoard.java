package racingcar.models;

import static racingcar.utils.Constants.MIN_MOVED_DISTANCE;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private int highScore = MIN_MOVED_DISTANCE;
    private final List<String> winners = new ArrayList<>();

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getHighScore() {
        return highScore;
    }

    public void addWinner(String carName) {
        winners.add(carName);
    }

    public List<String> getWinners() {
        return new ArrayList<>(winners);
    }
}
