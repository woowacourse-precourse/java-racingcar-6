package racingcar.model;

public class Car {

    private CarName name;
    private RacingNumber racingNumber;
    private Integer location;

    public Car(CarName carName, RacingNumber racingNumber) {
        this.racingNumber = racingNumber;
        this.name = carName;
        this.location = 0;
    }

    public static Car makeCar(CarName carName, RacingNumber racingNumber) {
        return new Car(carName, racingNumber);
    }

    public void generateRandomNumber() {
        racingNumber.generateAndSaveRandomNumber();
    }

    public void stopOrMove() {
        if (racingNumber.decideMoveOrStop(racingNumber)) {
            location++;
        }
    }

    @Override
    public String toString() {
        return name.toString() + " : " + location;
    }
}
