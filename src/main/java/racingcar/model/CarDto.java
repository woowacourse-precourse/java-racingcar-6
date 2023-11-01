package racingcar.model;

import racingcar.util.validate.CarValidateImpl;

public class CarDto {
    private String name;
    private int position;

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto convertToDto(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}
