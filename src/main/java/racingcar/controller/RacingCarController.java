package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Computer;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    Cars cars;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Computer computer = new Computer();
    Winner winner = new Winner();

    public void run() {
        List<Car> collectCars = new ArrayList<>();
        String[] carNames = inputView.carName();
        for (String carName : carNames) {
            collectCars.add(new Car(carName));
        }
        cars = new Cars(collectCars);

        cars.playNumberTimes(inputView.playNumber());

        outputView.printResultMessage();
        for(int attemptMove = 0; attemptMove<cars.getPlayNumbers(); attemptMove++){
            for (Car car : cars.getCars()) {
                car.moveForward(computer.getRandomNumber());
                outputView.printCarPositionMessage(car.getCarName(), car.getPosition());
            }
            System.out.println();
        }
        winner.findWinnerName(cars.getCars());
        outputView.printWinnerCarName(winner.getWinnerName());
    }
}
