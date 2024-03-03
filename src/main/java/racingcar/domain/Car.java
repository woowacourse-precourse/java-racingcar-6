package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final String ONE_STEP = "-";
    private static final int START_NUM = 0;
    private static final int END_NUM = 9;
    private static final int GO_FORWARD = 4;

    private final String name;
    private int location = 0;
    private StringBuilder status;

    public Car(String name) {
        this.name = name;
        location = 0;
        status = new StringBuilder();
    }

    public static Car createCar(String name) {
        return new Car(name);
    }

    public void decideMove() {
        if (Randoms.pickNumberInRange(START_NUM, END_NUM) >= GO_FORWARD) {
            location++;
            status.append(ONE_STEP);
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public String getStatus() {
        return status.toString();
    }
}
