package racingcar;

public class CarStatusDto {
    private final String carName;
    private final int position;

    public CarStatusDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
