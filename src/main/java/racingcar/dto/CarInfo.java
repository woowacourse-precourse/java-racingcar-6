package racingcar.dto;

import racingcar.domain.Car;

public record CarInfo(String name, int position) {
    public static final String POSITION_PROGRESS = "-";

    public static CarInfo of(Car car) {
        return new CarInfo(car.getName(), car.getPosition());
    }

    public String convertPositionValue() {
        return POSITION_PROGRESS.repeat(this.position);
    }
}
