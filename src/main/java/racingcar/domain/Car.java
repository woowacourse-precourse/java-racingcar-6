package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int location = 0;

    private String name;

    public Car(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public int getPosition() {

        return location;
    }

    public void createRandomNumbers() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            location += 1;
        }
    }
}
