package racingcar.controller.dto.request;

public class CarNameDto {
    private final String carName;

    public CarNameDto (String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }
}
