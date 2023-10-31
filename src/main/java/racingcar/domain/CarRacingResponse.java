package racingcar.domain;

public class CarRacingResponse {
    private final String carName;
    private final int carPosition;

    public CarRacingResponse(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static CarRacingResponse create(String carName, int carPosition) {
        return new CarRacingResponse(carName, carPosition);
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

}
