package racingcar.domain;

public class Car {
    private final String carName;
    private int position = 0;

    public Car(String carName) {
        validateCarNameLength(carName);
        this.carName = carName;
    }

    public void addPosition() {
        position += 1;
    }

    private void validateCarNameLength(String carName) {
        if (isCarNameLengthOverThan5(carName)){
            throw new IllegalArgumentException("자동차의 이름은 이름은 5자 이하만 가능합니다.");
        }
        if (isCarNameLengthEqualZero(carName)){
            throw new IllegalArgumentException("자동차의 이름은 공백이 될 수 없습니다.");
        }
    }

    private boolean isCarNameLengthOverThan5(String carName) {
        return carName.length() > 5;
    }

    private boolean isCarNameLengthEqualZero(String carName) {
        return carName.length() == 0;
    }
}
