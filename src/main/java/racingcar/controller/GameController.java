package racingcar.controller;

import racingcar.Validator;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final GameService gameService = new GameService();
    private final Validator validator = new Validator();

    public void run() {
        List<Car> carList = createCarList();
        int trialNum = createTrialNum();
        Game game = new Game(carList, trialNum);

        while (!finishedGame(trialNum, game.getTriedNum())) {
            gameService.play(game);
            OutputView.printScore(game.getCars());
        }

        List<String> winner = gameService.getWinner(game);
        OutputView.printWinner(winner);
    }

    private List<Car> createCarList() {
        String carName = InputView.getCarNames();
        List<String> carNames = gameService.parseCarName(carName);
        validator.checkCarName(carNames);
        return saveCars(carNames);
    }

    private int createTrialNum() {
        String countTrial = InputView.getTrialNum();
        validator.checkVaildNum(countTrial);
        return saveTrialNum(countTrial);
    }

    private List<Car> saveCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    private int saveTrialNum(String input) {
        int trialNum = Integer.parseInt(input);
        return trialNum;
    }

    private boolean finishedGame(int trialNum, int triedNum) {
        if (trialNum == triedNum) {
            return true;
        }
        return false;
    }
}
