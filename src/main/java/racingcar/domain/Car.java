package racingcar.domain;

public class Car {

    private final int MOVING_FORWARD_CRITERION = 4;
    private final int NAME_LENGTH_CRITERION = 5;
    private String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int number) {
        if (number >= MOVING_FORWARD_CRITERION) {
            this.position++;
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_CRITERION) {
            throw new IllegalArgumentException("이름은 5자 이내로 작성해야 합니다");
        }
    }
}
