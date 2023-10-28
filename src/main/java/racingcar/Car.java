package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MAX_NAME_SIZE = 5;

    String name;
    int position;

    public Car(String name) {
        checkValidCarName(name);
        this.name = name;
        this.position = 0;
    }

    private void checkValidCarName(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    public String printResult() {
        StringBuilder result = new StringBuilder();
        result.append(name).append(" : ");
        result.append("-".repeat(Math.max(0, position)));
        return result.toString();
    }
}
