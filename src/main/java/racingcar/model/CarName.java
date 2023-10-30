package racingcar.model;

public class CarName {

    private final String name;

    public CarName(String carName) {
        validateName(carName);
        this.name = carName;
    }

    public void validateName(String carName) {
        if (carName.length() >= 5) {
            throw new IllegalArgumentException("이름은 5자 이내여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
