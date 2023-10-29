package racingcar.model.car;

import Config.AppConfig;

public class Car {
    private final CarId carId;
    private final CarName carName;
    private int position = 0;

    private Car(CarId carId, CarName carName) {
        this.carId = carId;
        this.carName = carName;
    }

    public static Car of(int value, String name) {
        CarId id = new CarId(value);
        CarName carName = new CarName(name);
        return new Car(id,carName);
    }

    public void move(int distance, boolean canMove){
        if(canMove) {
            throwExceptionWhenOverflow(distance);
            position += distance;
        }
    }

    private void throwExceptionWhenOverflow(int distance) {
        if(distance > 0 && position + distance < position) {
            throw new IllegalArgumentException("자동차의 이동범위의 한계는 " + AppConfig.CAR_POSITION_MAX + "입니다.");
        }
    }

    public CarId getCarId() {
        return carId;
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
