package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public Car move(int numberOfMove) {
        return null;
    }

    //test 만을 위한 코드입니다.
    public String getNameForTest() {
        return name;
    }
}
