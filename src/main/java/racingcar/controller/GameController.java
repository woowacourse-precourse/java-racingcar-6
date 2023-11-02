package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.CarNameValidator;
import racingcar.utils.TotalRoundValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private int totalRound;
    private Cars cars;

    public void run() {
        prepareGame();
        play(cars, totalRound);
        processResult(cars, totalRound);
    }

    private void prepareGame() {
        createCarsFromCarNamesUserInput();
        setTotalRoundFromUserInput();
    }

    private void createCarsFromCarNamesUserInput() {
        List<String> carNames = getCarNames();
        List<Car> carsFromUserInput = new ArrayList<>();
        for (String name : carNames) {
            carsFromUserInput.add(Car.create(name));
        }
        cars = Cars.create(carsFromUserInput);
    }

    private List<String> getCarNames() {
        String input = inputView.readCarNames();
        return CarNameValidator.validateCarNames(input);
    }

    private void setTotalRoundFromUserInput() {
        String input = inputView.readTotalRound();
        totalRound = TotalRoundValidator.validateTotalRound(input);
    }

    private void play(Cars cars, int totalRound) {
        for (int i = 0; i < totalRound; i++) {
            cars.play();
        }
    }

    private void processResult(Cars cars, int totalRound) {
        List<String> carNames = cars.provideCarNames();
        List<List<Integer>> roundScores = cars.provideAllCumulativeScoreList();
        List<String> winnerNames = cars.determineWinners();
        outputView.printResult(totalRound, carNames, roundScores, winnerNames);
    }
}
