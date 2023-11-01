package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int MOVING_CONDITION = 4;

    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = MINIMUM_NUMBER;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
        if (isMovable(randomNumber)) {
            position += randomNumber;
        }
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= MOVING_CONDITION;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return name.equals(car.name);
    }

    @Override
    public String toString() {
        return this.name
                + " : "
                + "-".repeat(position)
                +"\n";
    }

    public String carNameToString() {
        return this.name.toString();
    }

}
