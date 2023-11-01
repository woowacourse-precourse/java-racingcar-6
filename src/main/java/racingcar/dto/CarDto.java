package racingcar.dto;

public class CarDto {
    private String carName;
    private int currentPosition = 0;

    public CarDto(String carName) {
        this.carName = carName;
    }

    public CarDto(String carName, int currentPosition) {
        this.carName = carName;
        this.currentPosition = currentPosition;
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

}
