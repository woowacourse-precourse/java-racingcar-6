package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int place = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getPlace() {
        return place;
    }

    public void forward() {
        if (generateRandomNumber() > 3) {
            place++;
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
