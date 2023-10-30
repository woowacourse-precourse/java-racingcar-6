package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final Name name;
    private final Distance distance;

    public Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance();
    }

    public String getName() {
        return name.toString();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public void move() {
        distance.move();
    }

    public void stopOrMove() {
        if (shouldMove()) {
            move();
        }
    }

    private boolean shouldMove() {
        return generatedRandomNumber() >= 4;
    }

    protected int generatedRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}