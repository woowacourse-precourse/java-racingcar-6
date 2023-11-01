package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final List<String> names;
    private final int[] moveAmount;
    private final int number;

    public Car(String namesString) {
        isCorrectNamesString(namesString);
        this.names = List.of(namesString.split(","));
        number = names.size();
        isCorrectNameList();
        moveAmount = new int[number];
    }

    private void isCorrectNamesString(String namesString) {
        checkNameUngiven(namesString);
        checkNameHasBlank(namesString);
        checkNameHasNothing(namesString);
    }

    private void checkNameUngiven(String namesString) {
        if (namesString.isEmpty()) {
            throw new IllegalArgumentException(ExceptionCase.INPUT_UNGIVEN.message());
        }
    }

    private void checkNameHasBlank(String namesString) {
        if (namesString.contains(" ")) {
            throw new IllegalArgumentException(ExceptionCase.CAR_NAME_HAS_BLANK.message());
        }
    }

    private void checkNameHasNothing(String namesString) {
        if (namesString.contains(",,")) {
            throw new IllegalArgumentException(ExceptionCase.UNNAMED_CAR_EXIST.message());
        }
        if (namesString.startsWith(",") || namesString.endsWith(",")) {
            throw new IllegalArgumentException(ExceptionCase.UNNAMED_CAR_EXIST.message());
        }
    }

    private void isCorrectNameList() {
        for (String name : names) {
            checkNameLength(name);
        }
        checkNameDuplication();
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionCase.CAR_NAME_LENGTH_OVERED.message());
        }
    }

    private void checkNameDuplication() {
        if (number != names.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionCase.CAR_NAME_DUPLICATION.message());
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
