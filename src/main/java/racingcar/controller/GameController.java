package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.util.Message;
import racingcar.util.RandomValue;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();
    private final GameService gameService = GameService.getInstance();
    private List<Car> cars;
    private int rounds;

    public GameController() {
    }

    public static GameController getInstance() {
        return GameController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final GameController INSTANCE = new GameController();
    }

    public void run() {
        init();

        outputView.printMessage(Message.TEXT_RESULT);
        while (rounds > 0) {
            race();
            rounds--;
        }

        end();
    }

    private void init() {
        getCars();
        getRounds();
    }

    private void end() {
        findWinner();
    }

    private void getCars() {
        outputView.printMessage(Message.GET_CARS);
        cars = gameService.toCarList(inputView.getCarNames());
    }

    private void getRounds() {
        outputView.printMessage(Message.GET_ROUNDS);
        rounds = inputView.getRounds();
    }

    private void race() {
        for (Car car : cars) {
            if (canMove()) {
                car.oneMoving();
            }
        }

        List<String> results = gameService.toCarString(cars);
        outputView.printOneRoundResult(results);
    }

    private Boolean canMove() {
        return gameService.canMove(RandomValue.getRandomValue());
    }

    private void findWinner() {
        List<String> results = gameService.getWinner(cars);
        outputView.printWinner(results);
    }
}
