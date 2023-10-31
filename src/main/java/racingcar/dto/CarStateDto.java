package racingcar.dto;

public class CarStateDto {
    private final String carStatus;

    public CarStateDto(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarStatus() {
        return carStatus;
    }
}