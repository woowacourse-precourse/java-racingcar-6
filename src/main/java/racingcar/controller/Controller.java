package racingcar.controller;

import racingcar.NumberGenerator;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.Racing;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.Input;
import racingcar.view.Output;

public class Controller {

    public void run() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Racing racing = new Racing(numberGenerator);
        CarFactory carFactory = new CarFactory(Input.inputCar());

        printGameState(racing, carFactory);
        Output.printWinner(racing.winnerNameList(carFactory.getCarList()));
    }

    private void printGameState(Racing racing, CarFactory carFactory) {
        int trial = Input.inputTrial();
        for (int i = 0; i < trial; i++) {
            racing.moveCar(carFactory.getCarList());
            printCarPosition(carFactory);
            System.out.println();
        }
    }

    private void printCarPosition(CarFactory carFactory) {
        for (Car car : carFactory.getCarList()) {
            Output.printPosition(car.getName(), car.getPosition());
        }
    }
}
