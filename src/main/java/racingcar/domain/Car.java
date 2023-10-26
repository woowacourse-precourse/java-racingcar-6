package racingcar.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int DIVISION_NUMBER = 4;

    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public void move(int number) {
        if (judgeNumber(number)) {
            position++;
        }
    }

    private boolean judgeNumber(int number) {
        return number >= DIVISION_NUMBER;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름 길이의 범위를 벗어났습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
