package racingcar.dto;

import racingcar.domain.Car;

public record CarDto(String name, int position) {
    private static final String POSITION_PROGRESS = "-";

    public static CarDto from(Car car) {
        return new CarDto(car.getCarName(), car.getPosition());
    }

    public String convertPositionValue() {
        return POSITION_PROGRESS.repeat(this.position);
    }
}
