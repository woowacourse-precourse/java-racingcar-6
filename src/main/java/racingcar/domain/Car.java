package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private String name;
    private int distance;
    private int randomNumber;
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;

    public String getName() {
        return name;
    }

    public int generateRandomNumber() {
        return pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    Car(String name) {
        this.name = name;
    }
}
