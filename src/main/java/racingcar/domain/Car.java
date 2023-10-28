package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final String LENGTH_ERROR_MESSAGE = "자동차 이름은 5글자 이하만 가능합니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_DICE_VALUE = 0;
    private static final int MAX_DICE_VALUE = 9;
    private static final int STANDARD_VALUE = 4;
    private final String name;
    private int position = 0;


    private Car(String name) {
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static Car getNewCar(String name) {
        return new Car(name);
    }

    public void move() {
        if (canMove()) {
            position += 1;
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private boolean canMove() {
        int value = Randoms.pickNumberInRange(MIN_DICE_VALUE, MAX_DICE_VALUE);
        return value >= STANDARD_VALUE;
    }
}
