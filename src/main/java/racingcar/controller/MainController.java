package racingcar.controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import racingcar.model.car.CarList;
import racingcar.model.car.CarRegister;
import racingcar.model.manager.CarMoveManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<GameStatus, Supplier<GameStatus>> gameGuide;
    private final CarMoveManager carMoveManager;
    private final CarRegister carRegister;

    public MainController(InputView inputView, OutputView outputView, CarMoveManager carMoveManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameGuide = initializeGameGuide();
        this.carMoveManager = carMoveManager;
        this.carRegister = new CarRegister();
    }

    private Map<GameStatus, Supplier<GameStatus>> initializeGameGuide() {
        Map<GameStatus, Supplier<GameStatus>> gameGuide = new EnumMap<>(GameStatus.class);
        gameGuide.put(GameStatus.CAR_REGISTRATION, this::registerCarList);
        gameGuide.put(GameStatus.GAME_START, this::race);
        return gameGuide;
    }

    public void play() {
        GameStatus gameStatus = progress(GameStatus.CAR_REGISTRATION);
        while(gameStatus.isContinue((gameStatus))) {
            gameStatus = progress(gameStatus);
        }
    }

    private GameStatus race() {
        int moveCount = inputView.readMoveCount();
        CarList carList = carRegister.prepareCarList();
        moveAllCarList(moveCount, carList);
        outputView.printResult();
        outputView.printWinners(carList.getWinners());
        return GameStatus.GAME_FINISH;
    }

    private GameStatus progress(GameStatus gameStatus) {
        return gameGuide.get(gameStatus).get();
    }

    private GameStatus registerCarList() {
        List<String> carNames = inputView.readCarNames();
        carNames.stream().forEach(carName -> carRegister.registerCar(carName));
        return GameStatus.GAME_START;
    }

    private void moveAllCarList(int moveCount, CarList carList) {
        for (int i = 0; i < moveCount; i++) {
            carList.moveAllCarListOnce(carMoveManager);
            outputView.printResultCarList(carList.getCurrentResult());
        }
    }

    private enum GameStatus {
        CAR_REGISTRATION, GAME_START, GAME_FINISH;

        boolean isContinue(GameStatus gameStatus) {
            return !gameStatus.equals(GAME_FINISH);
        }
    }
}
