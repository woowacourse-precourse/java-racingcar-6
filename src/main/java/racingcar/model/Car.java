package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final Name name;
    private int position = 0;

    public Car(String carName) {
        this.name = new Name(carName);
    }

    public void move() {
        int randomResult = Randoms.pickNumberInRange(0, 9);
        if (4 <= randomResult) {
            movePosition();
        }
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position;
    }

    public String getPositionStatus() {
        return "-".repeat(Math.max(0, this.position));
    }

    private void movePosition() {
        this.position++;
    }


}
