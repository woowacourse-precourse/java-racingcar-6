package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MAX_NAME_SIZE = 5;

    private String name;
    private int position;

    public Car(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.position++;
        }
    }
}
