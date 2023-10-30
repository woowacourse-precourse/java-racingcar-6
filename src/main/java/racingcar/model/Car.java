package racingcar.model;

public class Car {

    private CarName name;
    private RacingNumber racingNumber;

    public Car(CarName carName, RacingNumber racingNumber) {
        this.racingNumber = racingNumber;
        this.name = carName;
    }

    public static Car makeCar(CarName carName, RacingNumber racingNumber) {
        return new Car(carName, racingNumber);
    }

    public void generateRandomNumber() {
        racingNumber.generateAndSaveRandomNumber();
    }

    public void stopOrMove() {

    }

    @Override
    public String toString() {
        return name.toString() + " : " + racingNumber.toString();
    }
}
