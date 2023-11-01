package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    private GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static GameController makeGame(InputView inputView, OutputView outputView) {
        return new GameController(inputView, outputView);
    }

    public void playGame() {
        List<Car> cars = createCars();
        int attempts = readAttemptsNumber();
        Race race = new Race(cars, attempts);

        startRace(race);
    }

    private List<Car> createCars() {
        outputView.printStartGame();
        List<String> carNames = inputView.inputCarNames();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.makeCar(carName));
        }

        return cars;
    }

    private int readAttemptsNumber() {
        outputView.printAskAttemptsNumber();
        return inputView.inputAttemptsNumber();
    }

    private void startRace(Race race) {
        outputView.printRacingStatus();
        while (race.hasMoreRounds()) {
            race.startRound();
            List<Car> cars = race.getCars();
            outputView.printCarPositions(cars);
        }

        List<String> winners = race.findWinner();
        outputView.printRacingResult(winners);
    }
}
