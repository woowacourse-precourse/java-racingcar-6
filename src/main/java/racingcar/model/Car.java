package racingcar.model;

public class Car {

    private String name = null;
    private RacingNumber racingNumber;

    public Car(String name, RacingNumber racingNumber) {
        this.racingNumber = racingNumber;
        this.name = name;
    }

    public static Car makeCar(String name, RacingNumber racingNumber) {
        return new Car(name, racingNumber);
    }

    public void generateRandomNumber() {
        racingNumber.generateAndSaveRandomNumber();
    }

    public void stopOrMove() {

    }
}
