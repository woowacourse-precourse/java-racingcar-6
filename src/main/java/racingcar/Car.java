package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private String position;

    public Car(String name) {
        this.name = name;
        this.position = "";
    }

    @Override
    public String toString() {
        return this.name + " : " + position;
    }

    public void move() {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);

        if (pickedNumber >= 4) {
            position += "-";
        }
    }


}
