package racingcar.domain.dto;

import racingcar.domain.Car;

public class CarDTO {
    private String name;
    private int position;
    public CarDTO(String name, int position){
        this.name = name;
        this.position = position;
    }

    public static CarDTO from(Car car) {
        return new CarDTO(car.getName(), car.getDistance());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
