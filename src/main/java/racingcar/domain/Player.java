package racingcar.domain;

import racingcar.operator.GameOperator;

public class Player {

    private final String name;
    private Integer progressScore;
    private final static Integer START_SCORE = 0;
    private final static String SCORE_FORMAT = "-";

    public Player(String name) {
        this.name = name;
        this.progressScore = START_SCORE;
    }

    public void tryProgress() {
        progressScore += GameOperator.play();
    }

    public String executionResult() {
        return String.format("%s : %s \n",
                name,
                SCORE_FORMAT.repeat(progressScore));
    }

    public Integer getProgressScore() {
        return progressScore;
    }

    public String getName() {
        return name;
    }
}