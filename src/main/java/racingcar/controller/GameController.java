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

        while (!finishGame(trialNum, game.getTriedNum())) {
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
        return convertCarName(carNames);
    }

    private int createTrialNum() {
        String countTrial = InputView.getTrialNum();
        validator.checkVaildNum(countTrial);
        return convertTrialNumToInt(countTrial);
    }

    private List<Car> convertCarName(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    private int convertTrialNumToInt(String input) {
        int trialNum = Integer.parseInt(input);
        return trialNum;
    }

    private boolean finishGame(int trialNum, int triedNum) {
        if (trialNum == triedNum) {
            return true;
        }
        return false;
    }
}
