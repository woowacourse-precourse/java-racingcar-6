package racingcar.model;

public class Car {
    public static final int MOVE_THRESHOLD = 4;
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        if(hasOverLengthName(name)){
            throw new IllegalArgumentException("자동차 이름은" + MAX_NAME_LENGTH + " 이하여야 합니다.");
        }

        this.name = name;
        this.position = 0;
    }

    public void move(int moveValue) {
        if (isMovable(moveValue)) {
            position++;
        }
    }

    private boolean hasOverLengthName(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    private boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
}
