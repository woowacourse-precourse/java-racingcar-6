package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private String position;
    public Car(String name) {
        this.name = name;
        position = "";
    }

    public void move() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            for (int count = 0; count < randomNum; count++) {
                position += "-";
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
