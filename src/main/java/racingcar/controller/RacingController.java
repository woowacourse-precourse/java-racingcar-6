package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private Cars cars;
    public void runGame() {
        startGame();
        playGame();
        endGame();
    }

    private void startGame() {
        OutputView.printStartMessage();
        String [] players = InputView.getPlayerInput();
        OutputView.printTryNumberMessage();

        List<Car> carList = new ArrayList<>();
        for (String player : players) {
            Car car = new Car(player, "");
            carList.add(car);
        }
        cars = new Cars(carList);
    }

    private void playGame() {
        int tryNumber = InputView.getTryNumberInput();
        OutputView.printResultMessage();
        while (tryNumber > 0) {
            cars.printPlayers();
            tryNumber--;
        }
    }

    private void endGame() {
        cars.printWinner();
    }


}
