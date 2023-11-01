package racingcar.controller;
import racingcar.view.InputView;
import racingcar.view.OutputView;
public class RacingCarController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    public void startGame(){
        Cars racingCar = createRacingCar();
    }
    private Cars createRacingCar() {
        outputView.printRequestCarNames();
        String[] carNames = inputView.inputCarNames();
        return CarFactory.createCars(carNames);
    }


}
