package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.Validator;
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
        outputView.askCarNames();
        List<String> carNames = getCarNames();
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(Car.create(name));
        }
        cars = Cars.create(carList);
    }

    private List<String> getCarNames() {
        return Validator.validateCarNames(inputView.readFromUser());
    }

    private void setTotalRoundFromUserInput() {
        outputView.askTotalRound();
        totalRound = Validator.validateTotalRound(inputView.readFromUser());
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
