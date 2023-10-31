package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private static final int MOVABLE_LOWER_BOUND = 4;
    private static final String CAR_TRACE_INDICATOR = "-";
    private static final int UPPER_BOUND_NAME_LENGTH = 5;
    private static final int LOWER_BOUND_NAME_LENGTH = 1;
    private static final String ERROR_NAME_IS_TOO_LONG = "5자 이하의 이름만 입력해주세요";
    private static final String ERROR_NAME_IS_TOO_SHORT = "1자 이상의 이름만 입력해주세요";
    private static final String ERROR_NAME_HAS_NULL = "null은 이름이 될 수 없습니다";
    private static final String STATUS_MESSAGE_FORMAT = "%s : %s";

    private final String name;
    private final StringBuilder mileage;

    private Car(String name) {
        this.name = name;
        this.mileage = new StringBuilder();
    }

    public static Car createCarByName(String name) {
        validateName(name);
        return new Car(name);
    }

    private static void validateName(String name) throws IllegalArgumentException {
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

    public static List<Car> createCarsByNames(List<String> carNames) {
        return carNames.stream()
                .map(Car::createCarByName)
                .collect(Collectors.toList());
    }

    public void moveForwardOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (isOkayToMove(randomNumber)) {
            moveForward();
        }
    }

    private boolean isOkayToMove(int randomNumber) {
        return randomNumber >= MOVABLE_LOWER_BOUND;
    }

    private void moveForward() {
        mileage.append(CAR_TRACE_INDICATOR);
    }

    public int getMileageInt() {
        return getMileageString().length();
    }

    private String getMileageString() {
        return mileage.toString();
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return String.format(STATUS_MESSAGE_FORMAT, getName(), mileage);
    }
}
