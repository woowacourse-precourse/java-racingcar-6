package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String carName) {
        validateCarNameLength(carName);
        this.name = carName;
    }

    public void addPosition() {
        position += 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateCarNameLength(String carName) {
        if (!isStringLengthInRange(carName)) {
            throw new IllegalArgumentException("자동차의 이름은 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    private boolean isStringLengthInRange(String string) {
        return string.length() <= 5 && string.length() != 0;
    }
}
