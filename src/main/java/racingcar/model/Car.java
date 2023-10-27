package racingcar.model;

import static racingcar.model.RacingGameConstants.MAX_CAR_NAME_LENGTH;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        validateNull(name);
        validateLength(name);
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("null이 입력되었습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_CAR_NAME_LENGTH + "자 이하만 가능합니다.");
        }
    }

    public void moveForward(int distance) {
        position += distance;
    }

    public String getForwardStateString(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.name).append(" : ");
        sb.append("-".repeat(position));
        return sb.toString();
    }
}
