package racingcar.model;

import racingcar.model.validators.RandomNumberValidator;
import racingcar.model.validators.Validator;
import racingcar.utils.RandomNumberGenerator;

import java.util.Objects;


public class Car {

    private CarName carName;
    private CarPosition carPosition;

    private static final int MOVABLE_NUMBER = 4;
    private static final Validator validator = new RandomNumberValidator();

    public Car(String carName, Integer carPosition) {
        this.carName = new CarName(carName);
        this.carPosition = new CarPosition(carPosition);
    }

    public boolean move() {
        int pos = carPosition.getValue();

        if (canMove()) {
            setCarPosition(++pos);
            return true;
        }
        return false;
    }

    private boolean canMove() {
        int randomNumber = RandomNumberGenerator.pickNumberInRange();
        validator.validate(randomNumber);

        if (randomNumber >= MOVABLE_NUMBER) {
            return true;
        }
        return false;
    }

    public String getName() {
        return carName.getValue();
    }

    public int getPosition() {
        return carPosition.getValue();
    }

    public void setCarPosition(Integer carPosition) {
        this.carPosition = new CarPosition(carPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(carPosition, car.carPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, carPosition);
    }
}
