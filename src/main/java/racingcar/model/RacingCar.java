package racingcar.model;

import static racingcar.constant.GameStringConstant.BLANK;
import static racingcar.constant.GameStringConstant.SCORE_BAR;
import static racingcar.constant.GameStringConstant.SCORE_DIVDER;

import racingcar.constant.GameStringConstant;

public class RacingCar {

    private final String name;
    private int score;

    private RacingCar(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static RacingCar nameOf(String name) {
        return new RacingCar(name, 0);
    }

    public void addScore() {
        this.score++;
    }

    public int getScore() {
        return this.score;
    }

    public String getNameIfCarIsWinner(int winnerScore) {
        if (this.score == winnerScore) {
            return this.name;
        }

        return GameStringConstant.BLANK.getValue();
    }

    public String getCarInfo() {
        return this.name + BLANK.getValue() + SCORE_DIVDER.getValue() + BLANK.getValue() + this.getScoreBars();
    }

    private String getScoreBars() {
        return SCORE_BAR.getValue().repeat(this.score);
    }
}
