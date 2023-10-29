package racingcar.model;

public class CarDto {
    private String carName;
    private int position;

    public CarDto(Car car) {
        this.carName = car.getName();
        this.position = car.getPosition();
    }

    public CarDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }
}
