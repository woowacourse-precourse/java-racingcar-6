package racingcar;

import static racingcar.ExceptionMessage.INVALID_CAR_NAME_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int MIN_VAL = 0;
    private static final int MAX_VAL = 9;
    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVE_LENGTH = 1;
    private static final String CAR_FORMAT = "%s : %s";
    private static final String HYPEN = "-";
    private final String name;
    private Integer position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }

    public void attempt() {
        int randomNumber = Randoms.pickNumberInRange(MIN_VAL, MAX_VAL);
        if (randomNumber >= MOVE_THRESHOLD) {
            position += MOVE_LENGTH;
        }
    }

    @Override
    public String toString() {
        return String.format(CAR_FORMAT, name, HYPEN.repeat(position));
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
