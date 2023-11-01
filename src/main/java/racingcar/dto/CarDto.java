package racingcar.dto;

public class CarDto {
    private String carName;
    private int movedDistance;

    public CarDto(String carName, int movedDistance) {
        this.carName = carName;
        this.movedDistance = movedDistance;
    }

    public String getCarName() {
        return carName;
    }

    public int getMovedDistance() {
        return movedDistance;
    }
}
