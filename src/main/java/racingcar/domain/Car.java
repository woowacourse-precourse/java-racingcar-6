package racingcar.domain;

import static racingcar.constant.CarRacingConstant.CAR_MAX_MOVE_POWER;
import static racingcar.constant.CarRacingConstant.CAR_MIN_MOVE_POWER;
import static racingcar.constant.CarRacingConstant.CAR_MOVABLE_POWER;
import static racingcar.constant.CarRacingConstant.CAR_NAME_MAX_LENGTH;
import static racingcar.constant.CarRacingConstant.START_POSITION;
import static racingcar.constant.CarRacingErrorMessage.CAR_NAME_BLANK_ERROR_MESSAGE;
import static racingcar.constant.CarRacingErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE;

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
        validateIsCarNameBlank(name);
    }

    private static void validateCarNameLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateIsCarNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_ERROR_MESSAGE);
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
