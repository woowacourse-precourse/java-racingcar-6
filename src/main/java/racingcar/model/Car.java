package racingcar.model;

import racingcar.model.vo.CarName;
import racingcar.model.vo.RacingNumber;

public class Car {

    private CarName name;
    private RacingNumber racingNumber;
    private Integer location;

    public Car(CarName carName) {
        this.racingNumber = new RacingNumber();
        this.name = carName;
        this.location = 0;
    }

    public static Car make(CarName carName) {
        return new Car(carName);
    }

    public void playGameOneRound() {
        generateRandomNumber();
        stopOrMove();
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
