package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;
    private static final int MOVE_THRESHOLD = 4;
    private int currentScore = 0;
    private final String name;
    private final List<Integer> cumulativeScoreList = new ArrayList<>();

    private Car(String name) {
        this.name = name;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public void play() {
        if (move()) {
            cumulativeScoreList.add(++currentScore);
            return;
        }
        cumulativeScoreList.add(currentScore);
    }

    private boolean move() {
        int number = Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
        return (number >= MOVE_THRESHOLD);
    }

    public String getName() {
        return name;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public List<Integer> getCumulativeScoreList() {
        return Collections.unmodifiableList(cumulativeScoreList);
    }
}
