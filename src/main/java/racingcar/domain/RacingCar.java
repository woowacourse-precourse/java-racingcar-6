package racingcar.domain;

public class RacingCar {

    private String carName;
    private int distance;

    public RacingCar(String carName) {
        this.carName = carName;
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }

}