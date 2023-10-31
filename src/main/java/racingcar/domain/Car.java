package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public void moveForward() {
        int randomNumber = GameCondition.getInstance().forwardCar();
        if (randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getPositionString() {
        return "-".repeat(position);
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로 작성해야 합니다.");
        }
    }
}
