package racingcar.util.car;

import racingcar.model.Car;

public class CarHandlerImpl implements CarHandler{
    private Car car;
    public CarHandlerImpl(Car car) {
        this.car = car;
    }
    public CarHandlerImpl createCar() {
        return new CarHandlerImpl(car);
    }
    @Override
    public void go(int randomValue) {
        if(randomValue >= 4)
            car.setPosition(car.getPosition() + 1);
    }

    @Override
    public int getPosition() {
        return car.getPosition();
    }
}
