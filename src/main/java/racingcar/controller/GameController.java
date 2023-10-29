package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.util.Message;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();
    private final GameService gameService = GameService.getInstance();
    private List<Car> cars;
    private int round;

    public GameController() {
    }

    public static GameController getInstance() {
        return GameController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final GameController INSTANCE = new GameController();
    }

    private void getCars() {
        outputView.printMessage(Message.GET_CARS);
        cars = gameService.toCarList(inputView.getCarNames());
    }
}
