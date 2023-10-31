package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Position extends Car {
    private static final int INITIAL_DISTANCE = 0;
    private static final String INITIAL_POSITION = "%s : ";
    private int distance;
    private StringBuilder position;

    private Position(Car car) {
        super(car.carInfo());
        this.distance = INITIAL_DISTANCE;
        this.position = new StringBuilder(String.format(INITIAL_POSITION, car.carInfo()));
    }

    public static Position createPosition(Car car) {
        return new Position(car);
    }

    public int distanceValue() {
        return this.distance;
    }

    public String positionValue() {
        return this.position.toString();
    }

    public void move(int random) {
        if (random >= 4) {
            this.distance += 1;
            this.position.append("-");
        }
    }

}
