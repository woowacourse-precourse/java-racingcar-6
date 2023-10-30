package racingcar;

import java.util.Arrays;
import java.util.List;

public class Car {
    private final List<String> names;
    private final int[] moveAmount;
    private final int number;
    private static final int CAR_NAME_LENGTH_MAX = 5;

    public Car(String carNamesString) {
        isCorrectNameString(carNamesString);
        this.names = List.of(carNamesString.split(","));
        number = names.size();
        isCorrectNameList();
        moveAmount = new int[number];
    }

    private void isCorrectNameString(String carNamesString) {
        checkCarNameHasBlank(carNamesString);
        checkCarNameHasNothing(carNamesString);
    }

    private void checkCarNameHasBlank(String carNamesString) {
        if (carNamesString.contains(" ")) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_HAS_BLANK);
        }
    }

    private void checkCarNameHasNothing(String carNamesString) {
        if (carNamesString.contains(",,")) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_HAS_NOTHING);
        }
        if (carNamesString.startsWith(",") || carNamesString.endsWith(",")) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_HAS_NOTHING);
        }
    }

    private void isCorrectNameList() {
        for (String name : names) {
            checkCarNameLength(name);
        }
        checkCarNameDuplication();
    }

    private void checkCarNameLength(String name) {
        if (name.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_LENGTH_OVERED);
        }
    }

    private void checkCarNameDuplication() {
        if (number != names.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATION);
        }
    }

    public void move(int index) {
        moveAmount[index]++;
    }

    public String name(int index) {
        return names.get(index);
    }

    public List<String> names() {
        return names;
    }

    public int movedLately(int index) {
        return moveAmount[index];
    }

    public int mostMovedAmount() {
        return Arrays.stream(moveAmount).max().getAsInt();
    }

    public int numberOf() {
        return number;
    }
}
