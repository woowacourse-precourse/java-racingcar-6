package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private Name name;
    private int position = 0;

    public Car(String carName) {
        this.name = new Name(carName);
    }

    public void move() {
        int randomResult = Randoms.pickNumberInRange(0, 9);
        if (4 <= randomResult) {
            addPosition();
        }
    }

    public String getName() {
        return this.name.getName();
    }

    private void addPosition() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getPositionStatus() {
        return "-".repeat(Math.max(0, this.position));
    }

}
