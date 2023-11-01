package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.util.CarFactory;
import racingcar.util.RacingCarRandomMoveUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private final RacingCarRandomMoveUtils racingCarRandomMoveUtils = new RacingCarRandomMoveUtils();

    public void startGame() {
        Cars racingCars = createRacingCars();
        TryCount tryCount = getTryCount();

        racing(racingCars, tryCount);

        outputView.printRacingCarWinnerResult(racingCars);
    }

    private Cars createRacingCars() {
        outputView.printRequestCarNames();
        String[] carNames = inputView.inputCarNames();
        return CarFactory.createCars(carNames);
    }

    private TryCount getTryCount() {
        outputView.printRequestTryCount();
        String inputTryCount = inputView.inputTryCount();
        return new TryCount(inputTryCount);
    }

    private void racing(Cars cars, TryCount tryCount) {
        outputView.printExecutionResult();

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            cars.moveAll(racingCarRandomMoveUtils);
            outputView.printRoundByExecutionResults(cars);
        }
    }


}
