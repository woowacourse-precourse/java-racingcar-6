package game.car;

public class CarName {
    private final String carName;

    public CarName(String inputName) {
        this.validateNameLength(inputName);
        this.carName = inputName;
    }

    private void validateNameLength(String inputName) {
        if (inputName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    public String getCarName() {
        return carName;
    }
}
