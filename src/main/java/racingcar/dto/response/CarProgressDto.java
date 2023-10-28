package racingcar.dto.response;

import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.CarPosition;

public class CarProgressDto {
    private final String carName;
    private final int position;

    private CarProgressDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public static CarProgressDto from(Car car) {
        CarName carName = car.getName();
        String name = carName.getName();
        CarPosition carPosition = car.getPosition();
        int position = carPosition.getPosition();

        return new CarProgressDto(name, position);
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
