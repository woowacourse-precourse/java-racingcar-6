package racingcar.domain;

import static racingcar.constant.RacingCarConstant.CAR_MAX_MOVE_POWER;
import static racingcar.constant.RacingCarConstant.CAR_MIN_MOVE_POWER;
import static racingcar.constant.RacingCarConstant.CAR_MOVABLE_POWER;
import static racingcar.constant.RacingCarConstant.CAR_NAME_MAX_LENGTH;
import static racingcar.constant.RacingCarConstant.START_POSITION;
import static racingcar.constant.RacingCarErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public static Car fromName(String name) {
        validate(name);
        return new Car(name);
    }


    private static void validate(String name) {
        validateCarNameLength(name);
    }

    private static void validateCarNameLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public void triesToMove() {
        int power = pushAccelerator();
        if (power >= CAR_MOVABLE_POWER) {
            move();
        }
    }

    private int pushAccelerator() {
        return Randoms.pickNumberInRange(CAR_MIN_MOVE_POWER, CAR_MAX_MOVE_POWER);
    }

    public boolean isLocatedIn(int position) {
        return this.position == position;
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return o.getPosition() - this.getPosition();
    }
}
