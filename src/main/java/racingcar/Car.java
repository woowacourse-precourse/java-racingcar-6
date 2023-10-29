package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final int MOVABLE_LOWER_BOUND = 4;
    private final String INDICATOR_PER_MOVE = "-";
    private static final int UPPER_BOUND_NAME_LENGTH = 5;
    private static final int LOWER_BOUND_NAME_LENGTH = 1;
    private static final String ERROR_NAME_IS_TOO_LONG = "5자 이하의 이름만 입력해주세요";
    private static final String ERROR_NAME_IS_TOO_SHORT = "1자 이상의 이름만 입력해주세요";
    private static final String ERROR_NAME_HAS_NULL = "null은 이름이 될 수 없습니다";

    private String name;
    private StringBuilder mileage;

    private Car(String name) {
        this.name = name;
        this.mileage = new StringBuilder();
    }

    public static Car createCarByName(String name) {
        validateLengthOfName(name);
        return new Car(name);
    }

    private static void validateLengthOfName(String name) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException(ERROR_NAME_HAS_NULL);
        }
        if (name.length() > UPPER_BOUND_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_IS_TOO_LONG);
        }
        if (name.length() < LOWER_BOUND_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_IS_TOO_SHORT);
        }
    }

    public void moveForwardOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (isOkayToMove(randomNumber)) {
            mileage.append(INDICATOR_PER_MOVE);
        }
    }

    private boolean isOkayToMove(int randomNumber) {
        return randomNumber >= MOVABLE_LOWER_BOUND;
    }


    public int getMileageAsInt() {
        return mileage.toString().length();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name +
                " : " +
                mileage.toString();
    }
}
