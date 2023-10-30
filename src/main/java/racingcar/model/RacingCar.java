package racingcar.model;

public class RacingCar implements Car {
    String name;

    public RacingCar(String carName) throws IllegalArgumentException {
        this.name = carName;
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Integer getCurrentLocation() {
        return null;
    }

    @Override
    public void goForward() {

    }
}
