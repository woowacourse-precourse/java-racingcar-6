package racingcar.domain;

public class Car {
    private final String name;
    private int position;
    private final int MAX_CAR_NAME_LENGTH = 5;

    public Car(String name) {
        validateCarNameLength(name);
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void addPosition() {
        position += 1;
    }

    private void validateCarNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름이 다섯글자를 초과했습니다.");
        }
    }
}
