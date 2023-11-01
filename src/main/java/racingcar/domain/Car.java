package racingcar.domain;

public class Car {
    private static final String CAR_NAME_RANGE_IN_FIVE = "자동차는 5이하의 글자수만 가능합니다.";
    private static final int CAR_NAME_BOUND = 5;
    private static final int MOVABLE_BOUND = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateInput(name);
        this.name = name;
    }

    public Car(String name, int position) {
        validateInput(name);
        this.name = name;
        this.position = position;
    }

    public boolean canMove(int pickNumberInRange) {
        if (MOVABLE_BOUND <= pickNumberInRange) {
            return true;
        }
        return false;
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public void printCarStatus() {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public void validateInput(String input) {
        keepLength(input);
    }

    public void keepLength(String input) {
        if (isValidLength(input)) {
            throw new IllegalArgumentException(CAR_NAME_RANGE_IN_FIVE);
        }
    }

    private boolean isValidLength(String input) {
        return input.length() > CAR_NAME_BOUND;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
