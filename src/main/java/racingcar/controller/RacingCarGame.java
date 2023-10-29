package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    private OutputView outputView = OutputView.getInstance();
    private InputView inputView = InputView.getInstance();
    private Cars cars = new Cars();

    public void run(){
        carInitialize();
    }

    public void carInitialize() {
        String carNames = inputView.InputCarNames();
        List<String> carNameList = carList(carNames);
        cars.makeCarsFromCarList(carNameList);
    }

    public List<String> carList(String carNames){
        String[] carNameList = carNames.split("");
        return List.of(carNameList);
    }
}
