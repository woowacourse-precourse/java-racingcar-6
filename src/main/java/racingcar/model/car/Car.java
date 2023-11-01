package racingcar.model.car;

import racingcar.config.AppConfig;

public class Car {
    private final CarId carId;
    private final CarName carName;
    private int position = 0;

    private Car(CarId carId, CarName carName) {
        this.carId = carId;
        this.carName = carName;
    }

    public static Car of(int value, String name) {
        CarId carId = new CarId(value);
        CarName carName = new CarName(name);

        return new Car(carId, carName);
    }

    public void move(int distance) {
        checkOverFlow(distance);
        position += distance;
    }

    private void checkOverFlow(int distance) {
        if (distance > 0 && distance + position < 0) {
            throw new IllegalArgumentException("자동차 이동거리는 " + AppConfig.POSITION_MAX + "를 넘을 수 없습니다.");
        }
    }

    public int getCarId() {
        return carId.getId();
    }
    public String getName() {
        return carName.name();
    }
    public int getPosition() {
        return position;
    }
}
