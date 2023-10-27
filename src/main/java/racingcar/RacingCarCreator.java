package racingcar;

public class RacingCarCreator {
    private String carName;

    public RacingCarCreator(String carName) {
        this.carName = carName;
    }

    public RacingCarCreator createNewCar(String carName) {
        return new RacingCarCreator(carName);
    }

    public String getCarName() {
        return carName;
    }
}
