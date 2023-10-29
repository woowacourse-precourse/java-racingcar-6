package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Car {

    // constant
    private final int MOVABLE_LOWER_BOUND = 4;
    private final String INDICATOR_PER_MOVE = "-";
    private final int MAXIMUM_LENGTH_OF_NAME = 5;
    private final String ERROR_EXCESS_LENGTH_OF_NAME = "5자 이하의 이름만 입력해주세요";

    // field
    private String name;
    private StringBuilder mileage;

    private Car(String name) {
        this.name = name;
        this.mileage = new StringBuilder();
    }

    public static Car createCarByName(String name) {
        return new Car(name);
    }

    private void checkIfExcessLengthOfName(List<String> names) {
        for (String name : names) {
            if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
                throw new IllegalArgumentException(ERROR_EXCESS_LENGTH_OF_NAME);
            }
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
