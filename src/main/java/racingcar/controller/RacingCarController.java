package racingcar.controller;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.util.CarFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;
public class RacingCarController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    public void startGame(){
        Cars racingCars = createRacingCars();
        TryCount tryCount = getTryCount();

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

}
