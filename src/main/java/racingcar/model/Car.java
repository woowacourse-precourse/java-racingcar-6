package racingcar.model;

public class Car {

    private final String carName;

    private int position;

    public Car(String carName) {

        validateCarNameLength(carName);
        validateCarNameBlank(carName);
        validateCarNameEmpty(carName);
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {

        return carName;
    }

    public int getPosition() {

        return position;
    }

    public void move() {

        this.position += 1;
    }

    private void validateCarNameLength(String carName) {

        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로만 가능합니다.");
        }
    }

    private void validateCarNameBlank(String carName) {

        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있습니다.");
        }
    }

    private void validateCarNameEmpty(String carName) {

        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
    }
}
