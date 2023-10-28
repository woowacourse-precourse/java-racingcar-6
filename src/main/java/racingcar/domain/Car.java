package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private final String name;

    private int currentScore = 0;

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
        int number = Randoms.pickNumberInRange(0, 9);
        return (number >= 4);
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
