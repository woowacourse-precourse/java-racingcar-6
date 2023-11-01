package racingcar.dto;

import racingcar.domain.Car;

public class CarPositionResponse {

    private final String name;
    private final int position;

    private CarPositionResponse(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarPositionResponse create(Car car) {
        return new CarPositionResponse(car.getName(), car.getPosition());
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
