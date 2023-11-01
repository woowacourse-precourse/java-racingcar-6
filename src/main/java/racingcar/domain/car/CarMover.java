package racingcar.domain.car;

import static racingcar.constant.GameConstant.UNIT_OF_MOVEMENT;

import racingcar.dto.Car;

public class CarMover {
    private Car car;
    private static final CarInfo carStore = CarInfo.getInstance();

    public CarMover(Car car) {
        this.car = car;
    }

    public Integer moveForward() {
        Car updatedCar = new Car(car.name(), car.position() + UNIT_OF_MOVEMENT);
        carStore.updateCarInfo(updatedCar);

        return updatedCar.position();
    }

    public Integer stopMovement() {
        Car updatedCar = new Car(car.name(), car.position());
        carStore.updateCarInfo(car);
        return updatedCar.position();
    }
}