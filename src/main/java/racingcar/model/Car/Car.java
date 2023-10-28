package racingcar.model.Car;

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
            validateOverflow(distance);
            position += distance;
        }
    }

    private void validateOverflow(int distance) {
        if(distance > 0 && position + distance < position) {
            throw new IllegalArgumentException();
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
