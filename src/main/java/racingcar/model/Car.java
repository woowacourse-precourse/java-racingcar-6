package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 이어야 합니다.");
        }
        this.name = name.trim();
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            distance++;
        }
    }

}
