package racingcar.model;

import racingcar.util.validate.CarValidateImpl;

public record CarDto(String name, int position) {
    public static CarDto convertToDto(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }
}
