package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.service.CarRace;
import racingcar.service.CarResult;
import racingcar.service.CarWinner;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingController {

    private Cars cars;

    public void runGame() {
        startGame();
        playGame();
        endGame();
    }

    private void assignPlayersToCars(String [] players) {
        List<Car> carList = Arrays.stream(players)
                .map(player -> new Car(player , ""))
                .collect(Collectors.toList());
        cars = new Cars(carList);
    }
    private void startGame() {
        OutputView.printStartMessage();
        String [] players = InputView.getPlayerInput();
        OutputView.printTryNumberMessage();
        assignPlayersToCars(players);
    }
    private void playGame() {
        int tryNumber = InputView.getTryNumberInput();
        OutputView.printResultMessage();
        CarRace carRace = new CarRace(cars.getCars());

        IntStream.range(0, tryNumber)
                .forEach(index -> carRace.printPlayersWithPositions());
    }
    private void endGame() {
        OutputView.printWinnerMessage();
        CarResult result = new CarResult(cars.getCars());
        CarWinner carWinner = new CarWinner(result);
        String winner = carWinner.printWinner();
        System.out.println(winner);
    }


}
