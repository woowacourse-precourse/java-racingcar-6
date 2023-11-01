package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.Constant.*;
import static racingcar.constant.ErrorMessage.CAR_NAME_BLANK_ERROR_MESSAGE;
import static racingcar.constant.ErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE;

public class car implements Comparable<car>{

    public String name;
    public int position;

    public car(String name) {
        validate(name);
        this.name = name;
        this.position = START_POSITION;
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
            throw new IllegalArgumentException(String.valueOf(CAR_NAME_BLANK_ERROR_MESSAGE));
        }
    }

    public void triesToMove() {
        int power = Randoms.pickNumberInRange(0, 9);
        if (power >= CAR_MOVABLE_POWER) {
            move();
        }
    }
    public boolean isLocatedIn(int position) {
        return this.position == position;
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
    public void move() {
        position++;
    }

    @Override
    public int compareTo(car o) {
        return o.getPosition() - this.getPosition();
    }
}
