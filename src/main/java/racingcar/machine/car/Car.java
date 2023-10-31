package racingcar.machine.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements CarInterface {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void tryForwardMove() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) distance++;
    }

    @Override
    public String carMoveLength() {
        return this.name + " : " + "-".repeat(Math.max(0, this.distance));
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public String getName() {
        return name;
    }
}
