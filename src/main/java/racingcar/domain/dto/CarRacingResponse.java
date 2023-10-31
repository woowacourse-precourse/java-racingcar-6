package racingcar.domain.dto;

public class CarRacingResponse {
    private final String name;
    private final int position;

    public CarRacingResponse(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarRacingResponse create(String carName, int carPosition) {
        return new CarRacingResponse(carName, carPosition);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
