package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    private OutputView outputView = OutputView.getInstance();
    private InputView inputView = InputView.getInstance();
    Cars cars = new Cars();

    public void run(){
        String carNames = inputView.InputCarNames();
    }

    public List<String> carList(String carNames){
        String[] carNameList = carNames.split("");
        return List.of(carNameList);
    }
}
