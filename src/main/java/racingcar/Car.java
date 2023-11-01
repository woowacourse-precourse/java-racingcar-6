package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int score;

    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int SCORE_THRESHOLD = 4;

    public Car(String name) {
        Validation.validateNameLengthNotOver(name, NAME_LENGTH_LIMIT);
        Validation.validateNotEmptyName(name);
        this.name = name;
        this.score = 0;
    }

    public void updateScore() {
        boolean getScore = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX) >= SCORE_THRESHOLD;
        if (getScore) {
            this.score += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
