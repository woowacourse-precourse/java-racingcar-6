package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Computer;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private List<Car> cars;
    private int playCount;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Computer computer = new Computer();
    Winner winner = new Winner();

    public void run() {
        cars = new ArrayList<>();
        String[] carNames = inputView.carName();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        playCount = inputView.playNumber();

        outputView.printResultMessage();
        for(int attempt = 0; attempt<playCount; attempt++){
            for (Car car : cars) {
                car.moveForward(computer.getRandomNumber());
                outputView.printCarPositionMessage(car.getCarName(), car.getPosition());
            }
            System.out.println();
        }
        winner.findWinnerName(cars);
        outputView.printWinnerCarName(winner.getWinnerName());
    }
}
