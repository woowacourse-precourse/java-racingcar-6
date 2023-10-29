package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.service.CarRace;
import racingcar.service.CarResult;
import racingcar.service.CarWinner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        setPlayerNames(players);
    }

    private void setPlayerNames(String [] players) {
        List<Car> carList = Arrays.stream(players)
                .map(player -> new Car(player , ""))
                .collect(Collectors.toList());
        cars = new Cars(carList);
    }
    private void playGame() {
        int tryNumber = InputView.getTryNumberInput();
        OutputView.printResultMessage();
        CarRace carRace = new CarRace(cars.getCars());
        while (tryNumber > 0) {
            carRace.printPlayers();
            tryNumber--;
        }
    }

    private void endGame() {
        OutputView.printWinnerMessage();
        CarResult result = new CarResult(cars.getCars());
        CarWinner winner = new CarWinner(result);
        winner.printWinner();
    }


}
