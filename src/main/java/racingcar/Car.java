package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    private void isValidName(String name) {
        if (name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void printResult() {
        System.out.println(this.name + " : " + "-".repeat(this.position));
    }
}
