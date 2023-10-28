package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static final GameController instance = new GameController();
    private int totalRound;
    private Cars cars;

    private GameController() {
    }

    public static GameController getInstance() {
        return instance;
    }

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
        OutputView.askCarNames();
        List<String> carNames = getCarNames();
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(Car.create(name));
        }
        cars = Cars.create(carList);
    }

    private List<String> getCarNames() {
        String input = InputView.readFromUser();
        return Validator.validateCarNames(input);
    }

    private void setTotalRoundFromUserInput() {
        OutputView.askTotalRound();
        String input = InputView.readFromUser();
        totalRound = Validator.validateTotalRound(input);
    }

    private void play(Cars cars, int totalRound) {
        for (int i = 0; i < totalRound; i++) {
            cars.play();
        }
    }

    private static void processResult(Cars cars, int totalRound) {
        List<String> carNames = cars.provideCarNames();
        List<List<Integer>> roundScores = cars.provideAllCumulativeScoreList();
        List<String> winnerNames = cars.determineWinners();
        OutputView.printResult(totalRound, carNames, roundScores, winnerNames);
    }
}
