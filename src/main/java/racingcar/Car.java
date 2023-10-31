package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int MIN_VAL = 0;
    private static final int MAX_VAL = 9;
    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVE_LENGTH = 1;
    private static final String CAR_FORMAT = "%s : %s";
    private final String name;
    private Integer position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
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
        StringBuilder stringBuilder = new StringBuilder();
        for (int positionCount = 1; positionCount <= position; positionCount++) {
            stringBuilder.append("-");
        }
        return String.format(CAR_FORMAT, name, stringBuilder.toString());
    }
}
