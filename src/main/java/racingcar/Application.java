package racingcar;

import static racingcar.Computer.getInput;
import static racingcar.constants.Message.INPUT_CAR_NAMES;
import static racingcar.constants.Message.INPUT_RACING_ROUND;

public class Application {

    public static void main(String[] args) {

        Car car = new Car(CarManager.createNames(getInput(INPUT_CAR_NAMES.getMessage())));

        car.move(CarRace.createRound(getInput(INPUT_RACING_ROUND.getMessage())));

        CarRace.printWinner(CarRace.findWinner(car, CarRace.findBest(car.movedDistances)));

    }

}
