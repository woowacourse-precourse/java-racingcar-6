package racingcar;

import static racingcar.view.input.Input.inputNames;
import static racingcar.view.output.Output.printMessage;

import racingcar.controller.CarController;
import racingcar.domain.car.Cars;
import racingcar.util.RandomGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.output.OutputMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        printMessage(OutputMessage.PLEASE_ENTER_CAR_NAME);
        Cars cars = new Cars(inputNames());
        RandomGenerator randomGenerator = new RandomNumberGenerator();

        CarController carController = new CarController(cars, randomGenerator);
        carController.run();
    }
}
