package racingcar.domain;

public class Car {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final int CAN_MOVE_CONDITION = 4;
    private static final String NAME_LENGTH_EXCEPTION = "자동차 이름은 %d ~ %d글자만 가능합니다.";
    private static final String NAME_LETTER_EXCEPTION = "자동차 이름에 특수문자나 숫자는 포함될 수 없습니다.";

    private final String name;
    private int moveCount;

    public Car(String name) {
        name = name.trim();
        validateLength(name);
        validateLetter(name);
        this.name = name;
        this.moveCount = 0;
    }

    private void validateLength(String name) {
        if (name.length() < MIN_LENGTH || MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException(String.format(NAME_LENGTH_EXCEPTION, MIN_LENGTH, MAX_LENGTH));
        }
    }

    private void validateLetter(String name) {
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new IllegalArgumentException(NAME_LETTER_EXCEPTION);
            }
        }
    }

    public void move(int condition) {
        if (CAN_MOVE_CONDITION <= condition) {
            moveCount++;
        }
    }

    public boolean isMaxMove(int maxMove) {
        return this.moveCount == maxMove;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
