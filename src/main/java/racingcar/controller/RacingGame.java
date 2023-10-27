package racingcar.controller;

import racingcar.model.CarName;
import racingcar.model.TryNumber;
import racingcar.view.InputView;

public class RacingGame {
    InputView inputView = new InputView();
    CarName carName;
    TryNumber tryNumber;

    public RacingGame(){
        carName = new CarName();
        tryNumber = new TryNumber();
    }
    public void start(){
        InputCarNames();
    }
    public void InputCarNames(){
        String inputCarNames = inputView.InputCarNames();
        carName.carNamesToList(inputCarNames);
        carName.setClearCarList();
    }

}
