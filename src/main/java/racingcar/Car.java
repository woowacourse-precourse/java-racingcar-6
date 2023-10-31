package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            distance++;
        }
    }

    public String getProgress() {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            progress.append("-");
        }
        return progress.toString();
    }
}