package racingcar.domain;

public class Car {

    private static final int MAX_LENGTH = 5;
    private static final String NAME_LENGTH_EXCEPTION = "자동차 이름은 %d자 이하만 가능합니다.";

    private final String name;
    private int moveCount;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.moveCount = 0;
    }

    private void validateLength(String name) {
        if (MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException(String.format(NAME_LENGTH_EXCEPTION, MAX_LENGTH));
        }
    }

    public void move() {
        moveCount++;
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
