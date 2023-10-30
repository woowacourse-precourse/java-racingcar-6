package racingcar.model;

public class CarName {

    private final String name;

    public CarName(String carName) {
        validateLength(carName);
        validateBlank(carName);
        this.name = carName;
    }

    private void validateLength(String carName) {
        if (carName.length() >= 5) {
            throw new IllegalArgumentException("이름은 5자 이내여야 합니다.");
        }
    }

    public void validateBlank(String carName) {
        if (carName.isBlank()){
            throw new IllegalArgumentException("이름에 빈 값이 들어올 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
