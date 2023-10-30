package racingcar.model.car;

public class Car {
    private CarId carId;
    private CarName carName;
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
        if(distance > 0 && distance + position < 0) {
            throw new IllegalArgumentException();
        }
        position += distance;
    }

    public CarId getCarId() {
        return carId;
    }

    public CarName getCarName() {
        return carName;
    }

    public Integer getPosition() {
        return position;
    }
}
