package racingcar.domain;

import static racingcar.domain.Constants.MAX_CAR_LENGTH;
import static racingcar.domain.Constants.MIN_MOVE_NUMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.util.ExceptionUtil;

public class Car extends IndexModel {

    private final String NAME_LENGTH_OVER_MESSAGE = "이름의 길이가 초과되었습니다.";
    private final String ALPHA_NUMERIC_NAME_MESSAGE = "이름은 알파벳, 숫자만 가능합니다.";

    private String name;
    private List<Integer> pickedNumbers = new ArrayList<>();
    private int lastPosition = 0;
    private List<Integer> positions = new ArrayList<>();

    private Car(String name) {
        this.name = name;
        validateCar();
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getLastPosition() {
        return lastPosition;
    }

    public int calcPickedNumberSize() {
        return pickedNumbers.size();
    }

    public void insertPickedNumber(int num) { //TODO: 이부분 Service로 분리할지?
        pickedNumbers.add(num);
        moveForwardIfNumberisSameOrOverCriteria(num);
    }

    public boolean isPositionSameOrOver(int maxPosition) {
        return lastPosition >= maxPosition;
    }

    private void moveForwardIfNumberisSameOrOverCriteria(int num) {
        if (num >= MIN_MOVE_NUMBER) {
            moveForward();
        }
    }

    private void moveForward() {
        lastPosition++;
    }

    private void validateNameLength() {
        if (name.length() > MAX_CAR_LENGTH) {
            ExceptionUtil.throwInvalidValueException(NAME_LENGTH_OVER_MESSAGE);
        }
    }

    private void validateAlphaNumeric() {
        if (!Pattern.matches("^[a-zA-Z0-9]*$", name)) {
            ExceptionUtil.throwInvalidValueException(ALPHA_NUMERIC_NAME_MESSAGE);
        }
    }

    private void validateCar() {
        validateNameLength();
        validateAlphaNumeric();
    }
}