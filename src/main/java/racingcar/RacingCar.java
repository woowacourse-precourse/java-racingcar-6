package racingcar;

public class RacingCar {
    public final String name;

    public RacingCar(String carName) {
        validateCarName(carName);
        name = carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
